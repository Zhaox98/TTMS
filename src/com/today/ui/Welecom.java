package com.today.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import com.xy.today.mycontrols.MyPanel;

/**
 * 需求：today剧院管理系统的    启动  进度条
 *
 *
 *
 */
public class Welecom {
	/**
	 * swing 进度条控制
	 */
	private Timer timer;
	/**
	 * 进度条 显示
	 */
	private JProgressBar progressBar;
	/**
	 * 进度条的tupain
	 */
	private ImageIcon imageIcon_jindutiao = new ImageIcon(
			Login.class.getResource("/com/today/images/chengxuqidong.gif"));

	private JFrame jFrame_Jprogressbar = new JFrame();
	private JWindow jFrame_xuehua = new JWindow();

//	public static void main(String[] args){
//		new Welecom();
//	}
	private Color color1 =new Color(239,239,239);//bg

	public Welecom() {

		new Snow(jFrame_xuehua);

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // 得到屏幕的尺寸
		// 设置全屏
		Rectangle bounds = new Rectangle(screenSize);
		jFrame_Jprogressbar.setBounds(bounds);

		//jFrame_Jprogressbar.setSize(800, 300);
		JPanel jPanel = wai();
		// 进度条 的jpanel
		jFrame_Jprogressbar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame_Jprogressbar.setUndecorated(true);
		// AWTUtilities.setWindowOpaque(jFrame_Jprogressbar, false);
		jFrame_Jprogressbar.setContentPane(jPanel);
		// myPanel.setOpaque(false);
		// 设置点击事件
		jFrame_Jprogressbar.setBackground(color1);
		jFrame_Jprogressbar.setLocationRelativeTo(null); // 设置窗体居中
		jFrame_Jprogressbar.setVisible(true);
	}

	private JPanel wai() {
		// TODO Auto-generated method stub
		JPanel jPanel = new JPanel();
		Insets insets = new Insets(0, 0, 0, 0);
		// 设置关闭 最小化的布局
		GridBagLayout gridBagLayout = new GridBagLayout();
		jPanel.setLayout(gridBagLayout);
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.insets = insets;

		ImageIcon imageIcon_huanying1 = new ImageIcon(
				Login.class.getResource("/com/today/images/huanying1.png"));
		imageIcon_huanying1.setImage(imageIcon_huanying1.getImage().getScaledInstance(
				800, 80, Image.SCALE_DEFAULT));
		ImageIcon imageIcon_huanying2 = new ImageIcon(
				Login.class.getResource("/com/today/images/huanying2.png"));
		imageIcon_huanying2.setImage(imageIcon_huanying2.getImage().getScaledInstance(
				800, 80, Image.SCALE_DEFAULT));
		/**
		 * 空jpanel占位置
		 */
		JPanel jPanel_wei = new JPanel();
		jPanel_wei.setLayout(new GridLayout(2,1));

		gridBagConstraints.fill = GridBagConstraints.BOTH;
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.weightx = 200;
		gridBagConstraints.weighty = 70;

		JLabel jLabel = new JLabel(imageIcon_huanying1);
		jPanel_wei.add(jLabel);
		JLabel jLabe2 = new JLabel(imageIcon_huanying2);
		jPanel_wei.add(jLabe2);

		jPanel_wei.setOpaque(false);
		jPanel.add(jPanel_wei, gridBagConstraints);

		JPanel myPanel = jindutiao();
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.weightx = 200;
		gridBagConstraints.weighty = 200;
		myPanel.setOpaque(false);
		myPanel.setBorder(new EmptyBorder(50, 250, 100, 250));
		jPanel.add(myPanel, gridBagConstraints);

		JPanel jPanel2 = new JPanel();
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.weightx = 200;
		gridBagConstraints.weighty = 20;
		jPanel2.setOpaque(false);
		jPanel.add(jPanel2, gridBagConstraints);

		jPanel.setOpaque(false);
		return jPanel;
	}

	private JPanel jindutiao() {
		// TODO Auto-generated method stub
		JPanel myPanel = new JPanel();

		Insets insets = new Insets(0, 0, 0, 0);

		GridBagLayout gridBagLayout = new GridBagLayout();
		myPanel.setLayout(gridBagLayout);
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.insets = insets;

		MyPanel jPanel_nei = change();
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.weightx = 200;
		gridBagConstraints.weighty = 700;
		myPanel.add(jPanel_nei, gridBagConstraints);

		ImageIcon imageIcon_qidong = new ImageIcon(
				Login.class.getResource("/com/today/images/qidong.png"));
		imageIcon_qidong.setImage(imageIcon_qidong.getImage().getScaledInstance(
				800, 180, Image.SCALE_DEFAULT));
		JPanel jPanel_wei = new JPanel();
		jPanel_wei.setLayout(new FlowLayout());
		JLabel jLabel = new JLabel(imageIcon_qidong);
		jPanel_wei.add(jLabel);
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.weightx = 200;
		gridBagConstraints.weighty = 10;
		jPanel_wei.setOpaque(false);
		myPanel.add(jPanel_wei, gridBagConstraints);

		return myPanel;
	}

	private MyPanel change() {
		// TODO Auto-generated method stub
		MyPanel myPanel = new MyPanel(imageIcon_jindutiao.getImage(), 800, 200);

		progressBar = new JProgressBar();
		progressBar.setStringPainted(true); // 设置进度条呈现进度字符串,默认为false
		progressBar.setBorderPainted(false); // 不绘制边框,默认为true
		progressBar.setPreferredSize(new Dimension(600, 20)); // 设置首选大小
		progressBar.setOpaque(false);
		timer = new Timer(50, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int loadingValue = progressBar.getValue();
				if (loadingValue < 100) {
					progressBar.setValue(++loadingValue);
				} else {
					timer.stop();
					jFrame_Jprogressbar.dispose();
					jFrame_xuehua.dispose();
					new Login();
				}
			}
		});
		timer.start();
		// myPanel.setOpaque(false);
		myPanel.add(progressBar);
		return myPanel;
	}

}
