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
 * ����today��Ժ����ϵͳ��   ��¼������
 *
 * @author lwp940118
 *
 */
public class LoginJProgressBar {
	/**
	 * swing ����������
	 */
	private Timer timer;
	/**
	 * ������ ��ʾ
	 */
	private JProgressBar progressBar;
	/**
	 * ��������tupain
	 */
	private ImageIcon imageIcon_jindutiao = new ImageIcon(
			Login.class.getResource("/com/today/images/chengxuqidong.gif"));

	private JFrame jFrame_Jprogressbar = new JFrame();
	public static int tag = 0 ;

	public LoginJProgressBar() {
		jFrame_Jprogressbar.setSize(800, 300);

		// ������ ��jpanel
		JPanel myPanel = jindutiao();
		myPanel.setOpaque(false);

		jFrame_Jprogressbar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame_Jprogressbar.setUndecorated(true);
		// AWTUtilities.setWindowOpaque(jFrame_Jprogressbar, false);
		jFrame_Jprogressbar.setContentPane(myPanel);
		// myPanel.setOpaque(false);
		// ���õ���¼�
		jFrame_Jprogressbar.setBackground(Color.black);
		jFrame_Jprogressbar.setLocationRelativeTo(null); // ���ô������
		jFrame_Jprogressbar.setVisible(true);
	}

	private JPanel jindutiao() {
		// TODO Auto-generated method stub
		JPanel myPanel = new JPanel();

		Insets insets = new Insets(0, 0, 0, 0);
		// ���ùر� ��С���Ĳ���
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
		progressBar.setStringPainted(true); // ���ý��������ֽ����ַ���,Ĭ��Ϊfalse
		progressBar.setBorderPainted(false); // �����Ʊ߿�,Ĭ��Ϊtrue
		progressBar.setPreferredSize(new Dimension(600, 20)); // ������ѡ��С
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
