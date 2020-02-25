package com.today.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
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
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.xy.today.mycontrols.JComboBox_Item;
import com.xy.today.mycontrols.MyPanel;
import com.xy.today.sql.Employee;

/**
 * 	需求:售票员界面。当账号登录成功时today系统自动识别  并登录管理员和售票员
 *
 *
 *
 */
public class Conductor {
	/**
	 * 登录的外部图片
	 */
//	private ImageIcon imageIcon_login_hudie = new ImageIcon(
//			Login.class.getResource("/com/today/images/hudie.gif"));
	/**
	 * 登录进去的jFrame
	 */
	public static JFrame jFrame_Conductor = new JFrame();
	/**
	 * 管理员外部 最小化按钮
	 */
	private JButton jButton_zuixiaohua;
	/**
	 * 管理员外部关闭按钮
	 */
	private JButton jButton_guanbi;

	/**
	 * 管理员关闭的图片
	 */
	private ImageIcon imageIcon_guanbi = new ImageIcon(
			Login.class.getResource("/com/today/images/guanbi.png"));
	/**
	 * 管理员最小的图片
	 */
	private ImageIcon imageIcon_zuixiaohua = new ImageIcon(
			Login.class.getResource("/com/today/images/zuixiaohua.png"));

	public static void main(String[] args) {
		new Conductor();
	}
	private Color color1 = new Color(245,245,220);
	public Conductor() {

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // 得到屏幕的尺寸
		// 设置全屏
		Rectangle bounds = new Rectangle(screenSize);
		jFrame_Conductor.setBounds(bounds);
		JPanel jPanel = myPanel_Waibu();
		jPanel.setOpaque(false);
		jFrame_Conductor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//jFrame_Conductor.setUndecorated(true);
		// 设置Jframe透明
		//AWTUtilities.setWindowOpaque(jFrame_GuanLi, false);
		jFrame_Conductor.setContentPane(jPanel);
		// 设置点击事件
		jFrame_Conductor.setBackground(color1);
		jFrame_Conductor.setLocationRelativeTo(null); // 设置窗体居中
		jFrame_Conductor.setVisible(true);
	}

	private JPanel myPanel_Waibu() {
		// 得到屏幕的宽高
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int h = (int) screenSize.getHeight();
		int w = (int) screenSize.getWidth();
//		imageIcon_login_hudie.setImage(imageIcon_login_hudie.getImage()
//				.getScaledInstance(w, h, Image.SCALE_DEFAULT));
//		MyPanel myPanel = new MyPanel(imageIcon_login_hudie.getImage(), w, h);
		Insets insets = new Insets(0, 0, 0, 0);
		JPanel myPanel = new JPanel();
		//myPanel.setBorder(new EmptyBorder(0, 80, 100, 80));
		// 设置关闭 最小化的布局
		GridBagLayout gridBagLayout = new GridBagLayout();
		myPanel.setLayout(gridBagLayout);
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.insets = insets;

		// 外部 关闭接口
		JPanel jPanel_wai = guanBi();
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.weightx = 200;
		gridBagConstraints.weighty = 40;
		myPanel.add(jPanel_wai, gridBagConstraints);

		/**
		 * 售票员的    界面
		 */
		UIManager.put("TabbedPane.contentOpaque", false);
		UIManager.put("TabbedPane.selected", Color.black);
		JTabbedPane jPanel_nei = new ConductorMain();
		jPanel_nei.setTabPlacement(JTabbedPane.LEFT);
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.weightx = 200;
		gridBagConstraints.weighty = 500;
		myPanel.add(jPanel_nei, gridBagConstraints);
		return myPanel;
	}

	/**
	 * 管理员 外部 关闭操作
	 *
	 * @return
	 */

	private JPanel guanBi() {
		JPanel jPanel_guanbi = new JPanel();

		// 得到屏幕的宽高
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int h = (int) screenSize.getHeight();
		int w = (int) screenSize.getWidth();

		Insets insets = new Insets(2, 2, 2, 2);
		// 设置关闭 最小化的布局
		GridBagLayout gridBagLayout = new GridBagLayout();
		jPanel_guanbi.setLayout(gridBagLayout);
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.insets = insets;

		ImageIcon imageIcon_shoupiaoyuan = new ImageIcon(
				Login.class.getResource("/com/today/images/shoupiaoyuan1.png"));
		imageIcon_shoupiaoyuan.setImage(imageIcon_shoupiaoyuan.getImage()
				.getScaledInstance(650, 120, Image.SCALE_DEFAULT));
		JLabel jLabel = new JLabel(imageIcon_shoupiaoyuan);
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.weightx = 1;
		gridBagConstraints.weighty = 6;

		jPanel_guanbi.add(jLabel, gridBagConstraints);

		imageIcon_guanbi.setImage(imageIcon_guanbi.getImage()
				.getScaledInstance(40, 40, Image.SCALE_DEFAULT));
		jButton_guanbi = new JButton(imageIcon_guanbi);
		jButton_guanbi.setContentAreaFilled(false);
		jButton_guanbi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("管理员的关闭button点击成功");
				jFrame_Conductor.dispose();
			}
		});
		imageIcon_zuixiaohua.setImage(imageIcon_zuixiaohua.getImage()
				.getScaledInstance(40, 40, Image.SCALE_DEFAULT));
		jButton_zuixiaohua = new JButton(imageIcon_zuixiaohua);
		jButton_zuixiaohua.setContentAreaFilled(false);
		jButton_zuixiaohua.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("管理员的最小化button点击成功");
				jFrame_Conductor.setExtendedState(JFrame.ICONIFIED);
			}
		});

		jPanel_guanbi.add(jButton_guanbi);
		jPanel_guanbi.add(jButton_zuixiaohua);
		jPanel_guanbi.setOpaque(false);
		return jPanel_guanbi;
	}


}
