package io.smart.swings.table;

import io.smart.swings.basemodel.SwingsModel;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.swing.*;
import java.awt.*;

@Data
@RequiredArgsConstructor
public class BaseTable extends JTable {
    private final SwingsModel swingsModel;
    private ListSelectionModel select;
    JScrollPane scrollPanel = new JScrollPane();


    public void populateTable() {
        setSelect(select);
        scrollPanel.add(this);
        setModel(swingsModel);
    }
}
