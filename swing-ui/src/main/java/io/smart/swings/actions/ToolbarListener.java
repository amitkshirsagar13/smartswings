package io.smart.swings.actions;

import io.smart.swings.panel.BasePanelListener;
import io.smart.swings.toolpanel.ToolbarPanel;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.swing.*;
import java.awt.*;
import java.util.function.Consumer;

@Data
@Slf4j
public class ToolbarListener extends BasePanelListener {

    private ToolbarPanel toolbarPanel;

    @Override
    public boolean executeButtonAction(String actionName) {
        boolean executed = false;
        if ("DEV".equalsIgnoreCase(actionName)) {
            toggleColor.accept(toolbarPanel.getButtons().get(actionName));
            executed = true;
        }
        return executed;
    }

    private Consumer<JButton> toggleColor = (button) -> {
        Color color = button.getBackground().equals(Color.RED) ? Color.GREEN : Color.RED;
        button.setBackground(color);
    };
}
