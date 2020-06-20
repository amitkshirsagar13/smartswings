package io.smart.swings.table;

import io.smart.swings.basemodel.SwingsModel;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.swing.*;

@Data
@RequiredArgsConstructor
public class BaseTable extends JTable {
    private final SwingsModel tableModel;
    private ListSelectionModel select;


    public void populateTable(JPanel contentPanel) {
        setSelect(select);
        JScrollPane sp=new JScrollPane(this);
        contentPanel.add(sp);
    }
}
