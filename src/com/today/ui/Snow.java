package com.today.ui;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JWindow;

import com.sun.awt.AWTUtilities;

/**
 * ���� today��Ժ����ϵͳ��ӭ�����   ѩ��Ʈ��
 * @author lwp940118
 *
 */

public class Snow{
	private static final long serialVersionUID = 1L;
	
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private ImageIcon snowFlower = new ImageIcon(Login.class.getResource("/com/today/images/snowflower.png"));
	private JLabel[] lbs = new JLabel[50];
	private ImageIcon leftWind = new ImageIcon(Login.class.getResource("/com/today/images/left.gif"));
	private ImageIcon rightWind = new ImageIcon(Login.class.getResource("/com/today/images/right.gif"));
	private JLabel wind = new JLabel();
	
	private JWindow jWindow;
	
	public Snow(JWindow jWindow){
		this.jWindow = jWindow;
		init();
	}
	//��ʼ��
	private void init(){
		jWindow.setSize(screenSize);
		AWTUtilities.setWindowOpaque(jWindow, false);
		jWindow.setLayout(null);
		jWindow.setAlwaysOnTop(true);
		for(int i=0;i<50;i++){//����20��ѩ��
			lbs[i] = new JLabel();
			lbs[i].setSize(snowFlower.getIconWidth(), snowFlower.getIconHeight());
			lbs[i].setIcon(snowFlower);
			int x = new Random().nextInt(screenSize.width-snowFlower.getIconWidth());
			int y = new Random().nextInt((screenSize.height));
			lbs[i].setLocation(x,y);
			jWindow.add(lbs[i]);
			new FlowDownThread(lbs[i]).start();//Ϊÿ��ѩ������һ��Ʈ����߳�
		}
		wind.setSize(leftWind.getIconWidth(), leftWind.getIconHeight());
		jWindow.add(wind);
		jWindow.setVisible(true);
		Timer timer = new Timer(true);
		timer.schedule(new Wind(), 2000, 5*1000);
	}
	
	//ģ��ѩ��Ʈ��
	private class FlowDownThread extends Thread{
		private JLabel flower;
		private int speed = new Random().nextInt(20)+10;//ÿһ��ѩ���Ľ����ٶ�
		
		public FlowDownThread(JLabel flower){
			this.flower = flower;
		}
		@Override
		public void run() {
			while(true){
				Point p = flower.getLocation();
				p = new Point(p.x,p.y+2);
				flower.setLocation(p);
				if(p.y>screenSize.height){//��������߽�
					flower.setLocation(p.x,0);
					speed = new Random().nextInt(20)+10;//��������һ�������ٶ�
				}
				try {
					sleep(speed);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	private class Wind extends TimerTask{
		@Override
		public void run() {
			//���λ��
			int x = new Random().nextInt(screenSize.width-snowFlower.getIconWidth());
			int y = new Random().nextInt(screenSize.height);
			if(x+wind.getWidth()>screenSize.width){
				x = screenSize.width-wind.getWidth();
			}
			if(y+wind.getHeight()>screenSize.getHeight()){
				y = screenSize.height-wind.getHeight();
			}
			int a = new Random().nextInt(2);//��������ķ磬1����0���Ҵ�
			wind.setVisible(true);
			for(int i=0;i<50;i++){
				if(a==0){
					wind.setIcon(rightWind);
					wind.setLocation(x, y);
					if(lbs[i].getX()>x-wind.getWidth()&&lbs[i].getY()>y){
						new FlowByWindThread(lbs[i],a).start();
					}
				}
				if(a==1){
					wind.setIcon(leftWind);
					wind.setLocation(x, y);
					if(lbs[i].getX()<x+wind.getWidth()&&lbs[i].getY()>y){
						new FlowByWindThread(lbs[i],a).start();
					}
				}
			}
		}
	}
	//���紵��
	private class FlowByWindThread extends Thread{
		JLabel lb = null;
		int a;
		
		public FlowByWindThread(JLabel lb,int a){
			this.lb = lb;
			this.a = a;
		}
		@Override
		public void run() {
			int tmp = 100;
			while(tmp>0){
				if(a==0){
					lb.setLocation(lb.getX()+3, lb.getY());
				}
				if(a==1){
					lb.setLocation(lb.getX()-3, lb.getY());
				}
				try {
					sleep(10);
					tmp--;
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if(lb.getX()>screenSize.width){
					lb.setLocation(new Random().nextInt(screenSize.width-snowFlower.getIconWidth()),
							0);
				}
			}
			wind.setVisible(false);
		}
	}
}