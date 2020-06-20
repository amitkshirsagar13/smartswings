package io.smart.swings.table;

import io.smart.swings.basemodel.renderer.BaseTableRenderer;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.util.Enumeration;

@Data
@RequiredArgsConstructor
public class BaseTable extends JTable {
    private ListSelectionModel select;
    private Dimension viewDimension;
    public void populateTable(BaseTableRenderer baseTableRenderer, Dimension viewDimension) {
        setSelect(select);
        Enumeration<TableColumn> columns = getColumnModel().getColumns();
        while(columns.hasMoreElements()) {
            TableColumn tableColumn = columns.nextElement();
            tableColumn.setCellRenderer(baseTableRenderer);
        }
        this.viewDimension = viewDimension;
    }
}
