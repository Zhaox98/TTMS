package com.today.ui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Point;
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
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.xy.today.mycontrols.JComboBox_Item;
import com.xy.today.mycontrols.MyPanel;
import com.xy.today.sql.Employee;

/**
 * 需求：today注册  界面，，
 * 将ui层信息  获取并传递到 经过一系列操作到 数据库中
 * @author lwp940118
 *
 */
public class Registered {

	/**
	 * 注册ui的Jfrmae
	 */
	private JFrame jFrame_Registered = new JFrame();
	/**
	 * 注册的图片边框
	 */
	private ImageIcon imageIcon_Registered = new ImageIcon(
			Login.class.getResource("/com/today/images/Registered.gif"));
	private MyPanel jPanel_Registered;
	/**
	 * button的图片
	 */
	private ImageIcon imageIcon_button = new ImageIcon(
			Login.class.getResource("/com/today/images/button.png"));
	/**
	 * 关闭的图片
	 */
	private ImageIcon imageIcon_guanbi = new ImageIcon(
			Login.class.getResource("/com/today/images/guanbi.png"));
	/**
	 * 最小的图片
	 */
	private ImageIcon imageIcon_zuixiaohua = new ImageIcon(
			Login.class.getResource("/com/today/images/zuixiaohua.png"));
	/**
	 * 关闭和最小化按钮
	 */
	private JButton jButton_guanbi;
	private JButton jButton_zuixiaohua;
	/**
	 * 姓名
	 */
	private JTextField jTextField_name;
	/**
	 * 密码
	 */
	private JPasswordField jPasswordField_password;
	/**
	 * 职位的选择
	 */
	private JComboBox jComboBox;

	private JButton jButton_zhuce;
	private JButton jButton_quxiao;


	public static void main(String args[]){
		new Registered();
	}

	public Registered(){
		jFrame_Registered.setSize(900, 600);

		// 第一层嵌套，login的外层
		jPanel_Registered = registered_Jpanel();
		jPanel_Registered.setOpaque(false);

		jFrame_Registered.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame_Registered.setUndecorated(true);
		//AWTUtilities.setWindowOpaque(jFrame_login, false);
		jFrame_Registered.setContentPane(jPanel_Registered);
		// 设置点击事件
		dianji();
		jFrame_Registered.setBackground(Color.black);
		jFrame_Registered.setLocationRelativeTo(null); // 设置窗体居中
		jFrame_Registered.setVisible(true);
	}
	/**
	 * 设置注册界面的点击事件
	 */
	private void dianji() {

		jButton_quxiao.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("取消button点击成功");
				jFrame_Registered.dispose();
				new Login();
			}
		});

		jButton_zhuce.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String string_name = jTextField_name.getText();
				String string_password = jPasswordField_password.getText();
				String string_zhiwei = "";
				int t = jComboBox.getSelectedIndex();
				if (t == 0) {
					string_zhiwei = "经理";
				}else {
					string_zhiwei = "售票员";
				}
				if (string_name.equals("")) {

					int num = 10;// 抖动次数
					Point point = jFrame_Registered.getLocation();// 窗体位置
					for (int i = 10; i > 0; i--) {
						// 设置 真的
						for (int j = num; j > 0; j--) {
							point.y += i;
							jFrame_Registered.setLocation(point);
							point.x += i;
							jFrame_Registered.setLocation(point);
							point.y -= i;
							jFrame_Registered.setLocation(point);
							point.x -= i;
							jFrame_Registered.setLocation(point);

						}
					}
					JOptionPane.showMessageDialog(jFrame_Registered.getContentPane(),
							"姓名不能为空!", "today登录系统信息", JOptionPane.WARNING_MESSAGE);
				}else if(string_password.equals("")){
					int num = 10;// 抖动次数
					Point point = jFrame_Registered.getLocation();// 窗体位置
					for (int i = 10; i > 0; i--) {
						// 设置 真的
						for (int j = num; j > 0; j--) {
							point.y += i;
							jFrame_Registered.setLocation(point);
							point.x += i;
							jFrame_Registered.setLocation(point);
							point.y -= i;
							jFrame_Registered.setLocation(point);
							point.x -= i;
							jFrame_Registered.setLocation(point);

						}
					}
					JOptionPane.showMessageDialog(jFrame_Registered.getContentPane(),
							"密码不能为空!", "today登录系统信息", JOptionPane.WARNING_MESSAGE);
				}else{
					Employee employee = new Employee();
					String string = employee.employeeRegistered(string_name,
							string_password, string_zhiwei);
					JOptionPane.showMessageDialog(jFrame_Registered.getContentPane(),
							"恭喜您在today剧院注册成功\n"+"您申注册后的账号是：\n\t"+string+
							"\n请牢记，如有遗失请联系超管：18240800871"
							, "today登录系统信息", JOptionPane.WARNING_MESSAGE);
					jFrame_Registered.dispose();
					new Login();
				}
			}
		});
	}

	/**
	 * jpanel定义  嵌套的类容
	 * @return
	 */
	private MyPanel registered_Jpanel(){
		MyPanel myPanel = new MyPanel(imageIcon_Registered.getImage(), 400, 800);

		Insets insets = new Insets(0, 0, 0, 0);
		myPanel.setBorder(new EmptyBorder(10, 100, 10, 100));
		// 设置关闭 最小化的布局
		GridBagLayout gridBagLayout = new GridBagLayout();
		myPanel.setLayout(gridBagLayout);
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.insets = insets;

		JPanel jPanel_wei = gaunbi();
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.weightx = 200;
		gridBagConstraints.weighty = 10;
		myPanel.add(jPanel_wei, gridBagConstraints);

		JPanel jPanel_nei = zhuce();
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.weightx = 200;
		gridBagConstraints.weighty = 400;
		myPanel.add(jPanel_nei, gridBagConstraints);

		return myPanel;
	}

	/**
	 * 注册界面的内容  调整s
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private JPanel zhuce() {
		// TODO Auto-generated method stub
		JPanel myPanel_zhuce = new JPanel();
		myPanel_zhuce.setLayout(new GridLayout(6,1));

		/**
		 * 空jpanel占用空间
		 */
		JPanel jPanel0 = new JPanel();
		jPanel0.setOpaque(false);
		myPanel_zhuce.add(jPanel0);

		/**
		 * 设置姓名
		 */
		JPanel jPanel1 = new JPanel();
		jPanel1.setLayout(new FlowLayout());
		JLabel jLabel_zhanghao = new JLabel("姓名", JLabel.RIGHT);
		jLabel_zhanghao.setFont(new Font("宋体", Font.BOLD, 20));
		jTextField_name = new JTextField(15);
		jPanel1.add(jLabel_zhanghao);
		jPanel1.setOpaque(false);
		jPanel1.add(jTextField_name);
		myPanel_zhuce.add(jPanel1);

		/**
		 * 设置密码
		 */
		JPanel jPanel2 = new JPanel();
		jPanel2.setLayout(new FlowLayout());
		JLabel jLabel_mima = new JLabel("密码", JLabel.RIGHT);
		jLabel_mima.setFont(new Font("宋体", Font.BOLD, 20));
		jPasswordField_password = new JPasswordField(15);
		jPanel2.add(jLabel_mima);
		jPanel2.setOpaque(false);
		jPanel2.add(jPasswordField_password);
		myPanel_zhuce.add(jPanel2);

		/**
		 * 职位选择s
		 */
		ImageIcon imageIcon_shoupiao = new ImageIcon(
				Login.class.getResource("/com/today/images/shoupiaoyuan.png"));
		imageIcon_shoupiao.setImage(imageIcon_shoupiao.getImage()
				.getScaledInstance(30, 30, Image.SCALE_DEFAULT));
//		ImageIcon imageIcon_guanli = new ImageIcon(
//				Login.class.getResource("/com/today/images/guanliyuan.png"));
//		imageIcon_guanli.setImage(imageIcon_guanli.getImage()
//				.getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		JPanel jPanel3 = new JPanel();
		jPanel3.setLayout(new FlowLayout());
		JLabel jLabel_zhiwei = new JLabel("职位", JLabel.RIGHT);
		jLabel_zhiwei.setFont(new Font("宋体", Font.BOLD, 20));
		jPanel3.add(jLabel_zhiwei);
		jComboBox = new JComboBox();
		jComboBox.setMaximumRowCount(2);
		//设置  调用单元格
		jComboBox.setRenderer(new JComboBox_Item());
		jComboBox.setBackground(Color.black);
		jComboBox.setSize(60, 40);
//		jComboBox.addItem(new Object[]{imageIcon_guanli,"经理","today剧院系统管理员"});
		jComboBox.addItem(new Object[]{imageIcon_shoupiao,"售票员","today剧院售票员"});
		jPanel3.add(jComboBox);
		jPanel3.setOpaque(false);
		myPanel_zhuce.add(jPanel3);

		/**
		 * 取消 注册button
		 */
		imageIcon_button.setImage(imageIcon_button.getImage()
				.getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		JPanel jPanel4 = new JPanel();
		jButton_quxiao = new JButton("取消", imageIcon_button);
		jButton_quxiao.setContentAreaFilled(false);
		jButton_zhuce = new JButton("注册", imageIcon_button);
		jButton_zhuce.setContentAreaFilled(false);
		jPanel4.add(jButton_zhuce);
		jPanel4.add(jButton_quxiao);
		jPanel4.setOpaque(false);
		myPanel_zhuce.add(jPanel4);

		myPanel_zhuce.setOpaque(false);
		return myPanel_zhuce;
	}

	/**
	 * 注册界面的外部函数
	 * @return
	 */
	private JPanel gaunbi() {
		JPanel jPanel_waibu = new JPanel();
		Insets insets = new Insets(2, 2, 2, 2);
		// 设置关闭 最小化的布局
		GridBagLayout gridBagLayout = new GridBagLayout();
		jPanel_waibu.setLayout(gridBagLayout);
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.insets = insets;

		ImageIcon imageIcon_zhuce = new ImageIcon(
				Login.class.getResource("/com/today/images/zhuce.png"));
		imageIcon_zhuce.setImage(imageIcon_zhuce.getImage()
				.getScaledInstance(550, 120, Image.SCALE_DEFAULT));
		JLabel jLabel = new JLabel(imageIcon_zhuce);
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.weightx = 1;
		gridBagConstraints.weighty = 6;
		jPanel_waibu.add(jLabel, gridBagConstraints);

		imageIcon_guanbi.setImage(imageIcon_guanbi.getImage()
				.getScaledInstance(40, 40, Image.SCALE_DEFAULT));
		jButton_guanbi = new JButton(imageIcon_guanbi);
		jButton_guanbi.setContentAreaFilled(false);
		jButton_guanbi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("注册的关闭button点击成功");
				jFrame_Registered.dispose();
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
				System.out.println("注册的最小化button点击成功");
				jFrame_Registered.setExtendedState(JFrame.ICONIFIED);
			}
		});

		jPanel_waibu.add(jButton_guanbi);
		jPanel_waibu.add(jButton_zuixiaohua);
		jPanel_waibu.setOpaque(false);
		return jPanel_waibu;
	}

}
