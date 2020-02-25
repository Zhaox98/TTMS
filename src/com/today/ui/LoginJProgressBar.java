package com.today.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.Timer;

import com.xy.today.mycontrols.MyPanel;

/**
 * 需求：today剧院管理系统的   登录进度条
 *
 * @author lwp940118
 *
 */
public class LoginJProgressBar {
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
	public static int tag = 0 ;

	public LoginJProgressBar() {
		jFrame_Jprogressbar.setSize(800, 300);

		// 进度条 的jpanel
		JPanel myPanel = jindutiao();
		myPanel.setOpaque(false);

		jFrame_Jprogressbar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame_Jprogressbar.setUndecorated(true);
		// AWTUtilities.setWindowOpaque(jFrame_Jprogressbar, false);
		jFrame_Jprogressbar.setContentPane(myPanel);
		// myPanel.setOpaque(false);
		// 设置点击事件
		jFrame_Jprogressbar.setBackground(Color.black);
		jFrame_Jprogressbar.setLocationRelativeTo(null); // 设置窗体居中
		jFrame_Jprogressbar.setVisible(true);
	}

	private JPanel jindutiao() {
		// TODO Auto-generated method stub
		JPanel myPanel = new JPanel();

		Insets insets = new Insets(0, 0, 0, 0);
		// 设置关闭 最小化的布局
		GridBagLayout gridBagLayout = new GridBagLayout();
		myPanel.setLayout(gridBagLayout);
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.insets = insets;

		ImageIcon imageIcon_jindu = new ImageIcon(
				Login.class.getResource("/com/today/images/login.png"));
		imageIcon_jindu.setImage(imageIcon_jindu.getImage().getScaledInstance(
				800, 80, Image.SCALE_DEFAULT));
		JPanel jPanel_wei = new JPanel();
		jPanel_wei.setLayout(new FlowLayout());
		JLabel jLabel = new JLabel(imageIcon_jindu);
		jPanel_wei.add(jLabel);
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.weightx = 200;
		gridBagConstraints.weighty = 10;
		jPanel_wei.setOpaque(false);
		myPanel.add(jPanel_wei, gridBagConstraints);

		MyPanel jPanel_nei = change();
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.weightx = 200;
		gridBagConstraints.weighty = 700;
		myPanel.add(jPanel_nei, gridBagConstraints);

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
					if (tag == 1) {
						new Conductor();
					}else if(tag == 2){
						new Administrator();
					}
				}
			}
		});
		timer.start();
		// myPanel.setOpaque(false);
		myPanel.add(progressBar);
		return myPanel;
	}

}
