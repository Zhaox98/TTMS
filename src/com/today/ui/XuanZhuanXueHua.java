package com.today.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import twaver.TWaverUtil;

import com.sun.awt.AWTUtilities;

public class XuanZhuanXueHua {  
	
    public void XuanZhuan(final JFrame frame){
    	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // 得到屏幕的尺寸
		// 设置全屏
		Rectangle bounds = new Rectangle(screenSize);
		frame.setBounds(bounds);
        frame.setAlwaysOnTop(true);  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        frame.setUndecorated(true); 
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);  
        AWTUtilities.setWindowOpaque(frame, false); 
        
        final JPanel pane = new JPanel() {  
  
            private int[] snowX = null;  
            private int[] snowY = null;  
            private int[] angles = null;  
            private int count = 45;  
  
            @Override  
            public void paint(Graphics g) {  
                super.paint(g);  
                Rectangle bounds = frame.getBounds();  
                if (snowX == null) {  
  
                    snowX = new int[count];  
                    for (int i = 0; i < snowX.length; i++) {  
                        snowX[i] = TWaverUtil.getRandomInt(bounds.width);  
                    }  
                    snowY = new int[count];  
                    for (int i = 0; i < snowY.length; i++) {  
                        snowY[i] = TWaverUtil.getRandomInt(bounds.height);  
                    }  
                    angles = new int[count];  
                    for (int i = 0; i < snowY.length; i++) {  
                        angles[i] = TWaverUtil.getRandomInt(360);  
                    }  
                }  
                Graphics2D g2d = (Graphics2D) g;  
                Image image = TWaverUtil.getImage("/com/today/images/snow.png");  
                for (int i = 0; i < count; i++) {  
                    snowX[i] += TWaverUtil.getRandomInt(5) - 3;  
                    snowY[i] += 5;  
                    angles[i] += i / 5;  
                    snowY[i] = snowY[i] > bounds.height ? 0 : snowY[i];  
                    angles[i] = angles[i] > 360 ? 0 : angles[i];  
                    int x = snowX[i];  
                    int y = snowY[i];  
                    int angle = angles[i];  
                    g2d.translate(x, y);  
                    double angleValue = Math.toRadians(angle);  
                    g2d.rotate(angleValue);  
                    g2d.drawImage(image, 0, 0, null);  
                    g2d.rotate(-angleValue);  
                    g2d.translate(-x, -y);  
                }  
            }  
        };  
        
        pane.setOpaque(false);
  
        frame.setContentPane(pane);  
        frame.setVisible(true);  
        Thread thread = new Thread() {  
  
            @Override  
            public void run() {  
                while (true) {  
                    try {  
                        Thread.sleep(10);  
                    } catch (Exception ex) {  
                        ex.printStackTrace();  
                    }  
                    pane.repaint();  
                }  
            }  
        };  
  
        thread.start();  
    }
}   
