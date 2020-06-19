package io.smart.swings.utils;

import io.smart.swings.ComponentConfiguration;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import javax.swing.*;
import java.awt.*;

@AllArgsConstructor
@Slf4j
public class LookAndFeel {
    private ComponentConfiguration componentConfiguration;
    public void lookAndFeel() {
        try {
            UIManager.put("ProgressBar.verticalSize", new Dimension(400, 20));
            if (StringUtils.isNotEmpty(componentConfiguration.getLookAndFeel()))
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                log.info(info.getName());
                if (componentConfiguration.getLookAndFeel().equalsIgnoreCase(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    UIManager.put("nimbusOrange", new Color(40, 225, 40));
                    UIManager.put("Table.background", Color.WHITE);
                    UIManager.put("Table.alternateRowColor", Color.BLUE);
                    UIManager.put("nimbusSelectionBackground", new Color(220, 220, 220));
                    UIManager.put("List[Selected].textBackground", new Color(220, 220, 220));
                    break;
                }
            }
        } catch (Exception e) {
        }
    }
}
