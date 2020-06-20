package io.smart.swings.basepanel;

import io.smart.swings.utils.LookAndFeel;
import io.smart.swings.ComponentConfiguration;
import io.smart.swings.splash.BaseSplash;
import io.smart.swings.utils.ResourceProvider;
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

    private LookAndFeel lookAndFeel;
    private BaseSplash baseSplash;

    public BaseFrame(ComponentConfiguration componentConfiguration, LookAndFeel lookAndFeel) {
        super();
        this.lookAndFeel = lookAndFeel;
        this.lookAndFeel.lookAndFeel();
        setTitle(componentConfiguration.getApplicationName());
        setIconImage(ResourceProvider.getImageIcon(componentConfiguration.getIcon()).getImage());
        initSplash(componentConfiguration.getSplashScreen());
    }
    public void initSplash(String iImgName) {
        if (iImgName == null || iImgName.equals("")) {
            iImgName = System.getProperty("JSPLASH_SCREEN");
        }
        log.info("Pop SplashScreen (System Property: JSPLASH_SCREEN): " + iImgName);

        baseSplash = new BaseSplash(this, ResourceProvider.getImageIcon(iImgName));
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
