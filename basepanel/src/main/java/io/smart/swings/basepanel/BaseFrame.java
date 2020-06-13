package io.smart.swings.basepanel;

import io.smart.swings.ComponentConfiguration;
import io.smart.swings.splash.BaseSplash;
import io.smart.swings.utils.ThreadUtils;
import lombok.extern.slf4j.Slf4j;

import javax.swing.*;
import java.net.URL;

/**
 *
 *
 * BaseMasterFrame Copyright 2016 Amit Kshirsagar
 * <amit.kshirsagar.13@gmail.com>.
 *
 * <p>
 * <b>Overview:</b>
 * <p>
 *
 *
 * <pre>
 * Project Name: basepanel
 * Creation date: Aug 14, 2017
 * &#64;author Amit Kshirsagar
 * &#64;version 1.0
 * &#64;since
 *
 * <p><b>Modification History:</b><p>
 *
 *
 * </pre>
 */

@Slf4j
public abstract class BaseFrame extends JFrame {

    private BaseSplash baseSplash = null;

    public BaseFrame(ComponentConfiguration componentConfiguration) {
        super();
        initSplash(componentConfiguration.getSplashScreen());

    }
    public void initSplash(String iImgName) {
        if (iImgName == null || iImgName.equals("")) {
            iImgName = System.getProperty("JSPLASH_SCREEN");
        }
        log.info("Pop SplashScreen (System Property: JSPLASH_SCREEN): " + iImgName);
        URL splashImageResource = BaseFrame.class.getResource(String.format("/%s", iImgName));
        baseSplash = new BaseSplash(this, new ImageIcon(splashImageResource));
        baseSplash.setVisible(true);
        baseSplash.setAlwaysOnTop(true);
        ThreadUtils.slowDown.run();
    }

    public BaseSplash getBaseSplash() {
        return baseSplash;
    }

    public void closeSplashScreen() {
        baseSplash.closeIt();
    }

}
