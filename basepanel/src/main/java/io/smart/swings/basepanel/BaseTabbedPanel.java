package io.smart.swings.basepanel;

import io.smart.swings.statuspanel.view.StatusPanel;
import io.smart.swings.utils.ThreadUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
public class BaseTabbedPanel extends JTabbedPane {
    private Map<String, BasePanel> basePanelMap;
    private final StatusPanel statusPanel;

    @PostConstruct
    private void postConstruct() {
        basePanelMap = new HashMap<>();
    }

    public void populateTabbedPanels(JPanel contentPanel) {
        contentPanel.add(this, BorderLayout.CENTER);
    }

    public void addTabbedPanel(BasePanel tab) {
        if (!basePanelMap.containsKey(tab.getName())) {
            addTab(tab.getName(), tab);
            tab.setStatusPanel(statusPanel);
            basePanelMap.put(tab.getName(), tab);
            statusPanel.setStatusMessage(String.format("Added %s Panel to tab!!!", tab.getName()));
            ThreadUtils.slowDown(1000);
        }
    }

}
