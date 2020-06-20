package io.smart.swings.utils;

import io.smart.swings.panel.BaseFrame;

import javax.swing.*;
import java.net.URL;

public class ResourceProvider {
    public static ImageIcon getImageIcon(String imagePath) {
        URL splashImageResource = BaseFrame.class.getResource(String.format("/%s", imagePath));
        return new ImageIcon(splashImageResource);
    }
}
