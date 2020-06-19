package io.smart.swings.splash;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BaseSplash extends JWindow {
    BorderLayout borderLayout1 = new BorderLayout();
    JLabel imageLabel = new JLabel();
    private static JProgressBar progressBar = new JProgressBar();
    private static JLabel progressBarMsg = new JLabel();
    ImageIcon imageIcon;
    private final Color iBorderColor = Color.BLACK;
    private int iImgWidth;
    private int iImgHeight;

    public BaseSplash(Frame parent, ImageIcon imageIcon) {
        super(parent);
        this.imageIcon = imageIcon;

        if (iBorderColor != null) {
            this.getContentPane().setBackground(iBorderColor);
        }

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        iImgWidth = imageIcon.getIconWidth();
        iImgHeight = imageIcon.getIconHeight();
        int width = iImgWidth;
        int height = iImgHeight;

        int x = (screenSize.width - width) / 2;
        int y = (screenSize.height - height) / 2;

        this.setBounds(x, y, width, height);

        try {
            jbInit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        // This will show the splash screen until the user presses a key
        // Notice that it is attached to the splash screen itself
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                closeIt();
            }
        });

        // This will show the splash screen until the user clicks the mouse on
        // the window
        // Notice that it is attached to the splash screen itself
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                closeIt();
            }
        });
    }

    public void closeIt() {
        setVisible(false);
        dispose();
    }

    // note - this class created with JBuilder
    void jbInit() throws Exception {
        setProgressMax(100);
        imageLabel.setIcon(imageIcon);

        this.getContentPane().setLayout(borderLayout1);
        this.getContentPane().add(imageLabel, BorderLayout.CENTER);

        progressBar.setForeground(Color.GREEN);
        progressBar.setBackground(Color.BLACK);

        progressBarMsg.setSize(iImgWidth, 15);
        progressBarMsg.setForeground(Color.BLACK);

        progressBar.setBounds(0, iImgHeight - 40, iImgWidth, 20);

        progressBarMsg.setFont(new Font("SansSerif", Font.PLAIN, 12));
        progressBarMsg.setOpaque(false);


        progressBar.setPreferredSize(new Dimension(iImgWidth, 20));
        progressBar.add(progressBarMsg);

        imageLabel.setLayout(null);
        imageLabel.add(progressBar);

        this.pack();
    }

    public void setProgressMax(int maxProgress) {
        progressBar.setMaximum(maxProgress);
    }

    public void setProgress(int progress) {
        final int theProgress = progress;
        SwingUtilities.invokeLater(()-> {
            progressBar.setValue(theProgress);
        });
    }

    public void setProgress(String message, int progress) {
        final int theProgress = progress;
        final String theMessage = message;
        setProgress(progress);
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                changeProgressBarColor();
                progressBar.setValue(theProgress);
                setMessage(theMessage);
            }
        });
    }

    private static void changeProgressBarColor() {
        if (progressBar.getForeground() == Color.GREEN) {
            UIManager.put("ProgressBar.foreground", Color.YELLOW);
        } else if (progressBar.getForeground() == Color.YELLOW) {
            UIManager.put("ProgressBar.foreground", Color.ORANGE);
        } else if (progressBar.getForeground() == Color.ORANGE) {
            UIManager.put("ProgressBar.foreground", Color.RED);
        } else if (progressBar.getForeground() == Color.RED) {
            UIManager.put("ProgressBar.foreground", Color.GREEN);
        }
    }

    public void setScreenVisible(boolean b) {
        final boolean boo = b;
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                setVisible(boo);
            }
        });
    }

    private static void setMessage(String message) {
        if (message == null) {
            message = "";
            progressBarMsg.setText("");
        } else {
            progressBarMsg.setText("   " + message);
        }
    }
}
