package com.xy.today.mycontrols;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

/**
 * ��дjpanel�������������ԣ����ͼƬ;
 * 
 * @author lwp940118
 * 
 */
public class MyPanel extends JPanel {
	private Image im;

	// ���캯���ƶ�Jpanel�Ĵ�С
	public MyPanel(Image im,int w,int h) {
		this.im = im;
		this.setSize(w, h);
	}

	// ��������
	@Override
	protected void paintComponent(Graphics g) {
		// ����
		super.paintComponent(g);
		g.drawImage(im, 0, 0, this.getWidth(), this.getHeight(), this);
	}
}
