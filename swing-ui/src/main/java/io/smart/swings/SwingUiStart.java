package io.smart.swings;

import io.smart.swings.actions.UiPanelListener;
import io.smart.swings.panel.BasePanel;
import io.smart.swings.panel.BaseTabbedPanel;
import io.smart.swings.statuspanel.view.StatusPanel;
import io.smart.swings.toolpanel.ToolbarPanel;
import io.smart.swings.ui.SwingUiMainFrame;
import io.smart.swings.x2jparser.builder.ButtonBuilder;
import io.smart.swings.x2jparser.builder.FormBuilder;
import io.smart.swings.x2jparser.builder.JComponentBuilder;
import io.smart.swings.x2jparser.builder.TableBuilder;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.event.EventListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


@SpringBootApplication
public class SwingUiStart {
    private final StatusPanel statusPanel;
    private final BaseTabbedPanel tabbedPanel;
    private final SwingUiMainFrame swingUiMainFrame;
    private final ToolbarPanel toolbarPanel;
    private final UiPanelListener uiPanelListener;
    private final FormBuilder formBuilder;
    private final ButtonBuilder buttonBuilder;
    private final TableBuilder tableBuilder;
    private final JComponentBuilder jComponentBuilder;

    public SwingUiStart(StatusPanel statusPanel, BaseTabbedPanel tabbedPanel, SwingUiMainFrame swingUiMainFrame, ToolbarPanel toolbarPanel, UiPanelListener uiPanelListener, FormBuilder formBuilder, ButtonBuilder buttonBuilder, TableBuilder tableBuilder, JComponentBuilder jComponentBuilder) {
        this.statusPanel = statusPanel;
        this.tabbedPanel = tabbedPanel;
        this.swingUiMainFrame = swingUiMainFrame;
        this.toolbarPanel = toolbarPanel;
        this.uiPanelListener = uiPanelListener;
        this.formBuilder = formBuilder;
        this.buttonBuilder = buttonBuilder;
        this.tableBuilder = tableBuilder;
        this.jComponentBuilder = jComponentBuilder;
    }
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(SwingUiStart.class)
                .headless(false).run(args);
    }

    @EventListener(ApplicationReadyEvent.class)
    private void runApplicationReadyEvent(ApplicationReadyEvent event) {

        swingUiMainFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
        swingUiMainFrame.setVisible(true);
        swingUiMainFrame.setSize(new Dimension(1000, 750));
        updateInitStatus(null, 25);

        JPanel contentPanel = (JPanel) swingUiMainFrame.getContentPane();
        contentPanel.setLayout(new BorderLayout());

        toolbarPanel.loadPanelOnContentPanel(BorderLayout.NORTH);
        statusPanel.loadPanelOnContentPanel(BorderLayout.SOUTH);

        tabbedPanel.populateTabbedPanels(contentPanel);


        jComponentBuilder.getApplication()
                .getFrame()
                .getPanel()
                .stream()
                .filter(
                        panel -> panel
                                .getSubPanelName()
                                .equalsIgnoreCase("FormPanel")
                ).forEach(panel -> {
                    BasePanel tabPanel = new BasePanel(uiPanelListener, formBuilder, buttonBuilder, tableBuilder, contentPanel);
                    tabPanel.buildPanel(panel.getPanelName());
                    updateInitStatus(String.format("Added %s tab !!!",panel.getPanelName()), 25);
                    tabbedPanel.addTabbedPanel(tabPanel);
                });

        swingUiMainFrame.closeSplashScreen();
    }
    int progress = 0;

    private void updateInitStatus(String message, int progress) {
        this.progress = this.progress + progress;
        if (StringUtils.isNotEmpty(message)) {
            swingUiMainFrame.getBaseSplash().setProgress(String.format(" %s", message), this.progress);
        } else {
            swingUiMainFrame.getBaseSplash().setProgress(this.progress);
        }
    }
}
