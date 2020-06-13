package io.smart.swings;

import io.smart.swings.actions.ToolbarListener;
import io.smart.swings.actions.UiPanelListener;
import io.smart.swings.basepanel.BasePanel;
import io.smart.swings.basepanel.BaseTabbedPanel;
import io.smart.swings.statuspanel.StatusPanelListener;
import io.smart.swings.statuspanel.view.StatusPanel;
import io.smart.swings.toolpanel.ToolbarConfiguration;
import io.smart.swings.toolpanel.ToolbarPanel;
import io.smart.swings.ui.SwingUiMainFrame;
import io.smart.swings.x2jparser.builder.ButtonBuilder;
import io.smart.swings.x2jparser.builder.FormBuilder;
import io.smart.swings.x2jparser.builder.JComponentBuilder;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


@SpringBootApplication
public class SwingUiStart {
    @Autowired
    private StatusPanelListener statusPanelListener;

    @Autowired
    private StatusPanel statusPanel;

    @Autowired
    private BaseTabbedPanel tabbedPanel;

    @Autowired
    private SwingUiMainFrame swingUiMainFrame;

    @Autowired
    private ToolbarPanel toolbarPanel;

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(SwingUiStart.class)
                .headless(false).run(args);
    }

    @Bean
    public JComponentBuilder jComponentBuilder(ComponentConfiguration componentConfiguration) {
        return new JComponentBuilder(componentConfiguration.getComponentConfigXml());
    }

    @Bean
    public FormBuilder formBuilder(JComponentBuilder jComponentBuilder) {
        return new FormBuilder(jComponentBuilder);
    }

    @Bean
    public ButtonBuilder buttonBuilder(JComponentBuilder jComponentBuilder) {
        return new ButtonBuilder(jComponentBuilder);
    }

    @Bean
    public SwingUiMainFrame swingUiMainFrame(ComponentConfiguration componentConfiguration) {
        return new SwingUiMainFrame(componentConfiguration);
    }

    @Bean
    public StatusPanelListener statusPanelListener() {
        return new StatusPanelListener();
    }

    @Bean
    public StatusPanel statusPanel() {
        return new StatusPanel(statusPanelListener);
    }

    @Bean
    public ToolbarListener toolbarListener() {
        return new ToolbarListener();
    }

    @Bean
    public UiPanelListener uiPanelListener() {
        return new UiPanelListener();
    }

    @Bean
    public ToolbarPanel toolbarPanel(ToolbarListener toolbarListener, ToolbarConfiguration toolbarConfiguration) {
        ToolbarPanel toolbarPanel = new ToolbarPanel(toolbarListener, toolbarConfiguration);
        toolbarListener.setToolbarPanel(toolbarPanel);
        return toolbarPanel;
    }

    @Bean
    public BaseTabbedPanel baseTabbedPanel(StatusPanel statusPanel) {
        return new BaseTabbedPanel(statusPanel);
    }

    @Bean
    @ConfigurationProperties("ui.toolbar")
    public ToolbarConfiguration toolbarConfiguration(){
        return new ToolbarConfiguration();
    }

    @Bean
    @ConfigurationProperties("ui.component")
    public ComponentConfiguration componentConfiguration() {
        return new ComponentConfiguration();
    }

    @Autowired
    private UiPanelListener uiPanelListener;

    @Autowired
    private FormBuilder formBuilder;

    @Autowired
    private ButtonBuilder buttonBuilder;

    @Autowired
    private JComponentBuilder jComponentBuilder;

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

        toolbarPanel.loadPanelOnContentPanel(contentPanel, BorderLayout.NORTH);
        statusPanel.loadPanelOnContentPanel(contentPanel, BorderLayout.SOUTH);
        
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
                    BasePanel tabPanel = new BasePanel(uiPanelListener, formBuilder, buttonBuilder);
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
