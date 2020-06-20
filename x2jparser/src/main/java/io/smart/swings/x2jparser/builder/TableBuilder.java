package io.smart.swings.x2jparser.builder;


import io.smart.swings.x2jparser.builder.components.Panel;
import io.smart.swings.x2jparser.builder.components.Table;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
public class TableBuilder {
    private final JComponentBuilder jComponentBuilder;

    public List<Table> getTablesForPanel(String panelName) {
        Optional<Panel> optionalPanel = jComponentBuilder.getApplication()
                .getFrame()
                .getPanel()
                .stream()
                .filter(panel -> panel
                        .getPanelName()
                        .equalsIgnoreCase(panelName))
                .findFirst();
        return optionalPanel.isPresent()? optionalPanel.get().getTable() : new ArrayList<>();
    }
}
