package io.smart.swings.config;

import io.smart.swings.ComponentConfiguration;
import io.smart.swings.actions.ToolbarListener;
import io.smart.swings.actions.UiPanelListener;
import io.smart.swings.panel.BaseTabbedPanel;
import io.smart.swings.statuspanel.StatusPanelListener;
import io.smart.swings.statuspanel.view.StatusPanel;
import io.smart.swings.toolpanel.ToolbarConfiguration;
import io.smart.swings.toolpanel.ToolbarPanel;
import io.smart.swings.ui.SwingUiMainFrame;
import io.smart.swings.utils.LookAndFeel;
import io.smart.swings.x2jparser.builder.ButtonBuilder;
import io.smart.swings.x2jparser.builder.FormBuilder;
import io.smart.swings.x2jparser.builder.JComponentBuilder;
import io.smart.swings.x2jparser.builder.TableBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.swing.*;

@Configuration
public class SwingUiConfiguration {

    @Bean
    public LookAndFeel lookAndFeel(ComponentConfiguration componentConfiguration){
        return new LookAndFeel(componentConfiguration);
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
    public TableBuilder tableBuilder(JComponentBuilder jComponentBuilder) {
        return new TableBuilder(jComponentBuilder);
    }

    @Bean
    public SwingUiMainFrame swingUiMainFrame(ComponentConfiguration componentConfiguration, LookAndFeel lookAndFeel) {
        return new SwingUiMainFrame(componentConfiguration, lookAndFeel);
    }

    @Bean
    public StatusPanelListener statusPanelListener() {
        return new StatusPanelListener();
    }

    @Bean
    public StatusPanel statusPanel(SwingUiMainFrame swingUiMainFrame, StatusPanelListener statusPanelListener) {
        return new StatusPanel(statusPanelListener, (JPanel) swingUiMainFrame.getContentPane());
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
    public ToolbarPanel toolbarPanel(ToolbarListener toolbarListener, ToolbarConfiguration toolbarConfiguration, SwingUiMainFrame swingUiMainFrame) {
        ToolbarPanel toolbarPanel = new ToolbarPanel(toolbarListener, toolbarConfiguration, (JPanel) swingUiMainFrame.getContentPane());
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
}
