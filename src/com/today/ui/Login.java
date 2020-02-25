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
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.xy.today.mycontrols.MyPanel;
import com.xy.today.sql.Employee;

/**
 * ����ʵ��today��Ժ����ϵͳ�ĵ�½����
 *
 *
 */

public class Login {

	/**
	 * ��ס����
	 */
	private JCheckBox jCheckBox_jizhu;
	/**
	 * ��������
	 */
	private JLabel jLabel_wangji;
	private MyPanel jPanel_login;
	/**
	 * ��½��ͼƬ
	 */
	private ImageIcon imageIcon_login_bg = new ImageIcon(
			Login.class.getResource("/com/today/images/denglu.gif"));
	private ImageIcon imageIcon_login_hudie = new ImageIcon(
			Login.class.getResource("/com/today/images/hudie.gif"));
	private ImageIcon imageIcon_button = new ImageIcon(
			Login.class.getResource("/com/today/images/button.png"));
	/**
	 * �رյ�ͼƬ
	 */
	private ImageIcon imageIcon_guanbi = new ImageIcon(
			Login.class.getResource("/com/today/images/guanbi.png"));
	/**
	 * ��С��ͼƬ
	 */
	private ImageIcon imageIcon_zuixiaohua = new ImageIcon(
			Login.class.getResource("/com/today/images/zuixiaohua.png"));
	/**
	 * ��½����
	 */
	private JFrame jFrame_login = new JFrame();

	/**
	 * ��½button
	 */
	private JButton jButton_denglu;
	/**
	 * ע��button
	 */
	private JButton jbButton_zhuce;
	/**
	 * �˺������
	 */
	private JTextField jTextField_zhanghao;
	/**
	 * ���������
	 */
	private JPasswordField jPasswordField_mima;

	private JButton jButton_guanbi;
	private JButton jButton_zuixiaohua;

	public static void main(String args[]) {
		new Login();
	}

	public Login() {
		jFrame_login.setSize(900, 700);

		// ��һ��Ƕ�ף�login�����
		jPanel_login = login_panel();
		jPanel_login.setOpaque(false);

		jFrame_login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame_login.setUndecorated(true);
		// AWTUtilities.setWindowOpaque(jFrame_login, false);
		jFrame_login.setContentPane(jPanel_login);
		// ���õ���¼�
		Dianji();
		jFrame_login.setBackground(Color.black);
		jFrame_login.setLocationRelativeTo(null); // ���ô������
		jFrame_login.setVisible(true);
	}

	/**
	 * ���� log������
	 *
	 * @return
	 */
	public MyPanel login_panel() {

		imageIcon_login_hudie.setImage(imageIcon_login_hudie.getImage()
				.getScaledInstance(800, 700, Image.SCALE_DEFAULT));
		MyPanel jPanel = new MyPanel(imageIcon_login_hudie.getImage(), 800, 700);

		Insets insets = new Insets(0, 0, 0, 0);
		jPanel.setBorder(new EmptyBorder(20, 100, 150, 100));
		// ���ùر� ��С���Ĳ���
		GridBagLayout gridBagLayout = new GridBagLayout();
		jPanel.setLayout(gridBagLayout);
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.insets = insets;

		JPanel jPanel_wei = gaunbi();
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.weightx = 200;
		gridBagConstraints.weighty = 10;
		jPanel.add(jPanel_wei, gridBagConstraints);

		MyPanel jPanel_nei = denglu();
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.weightx = 200;
		gridBagConstraints.weighty = 200;
		jPanel.add(jPanel_nei, gridBagConstraints);
		return jPanel;
	}

	private MyPanel denglu() {
		imageIcon_login_bg.setImage(imageIcon_login_bg.getImage()
				.getScaledInstance(600, 500, Image.SCALE_DEFAULT));
		MyPanel jPane_denlu = new MyPanel(imageIcon_login_bg.getImage(), 600,
				600);
		jPane_denlu.setLayout(new GridLayout(6, 1));

		/**
		 * ��jpanelռ�õط�
		 */
		JPanel jPanel0 = new JPanel();
		jPane_denlu.add(jPanel0);
		jPanel0.setOpaque(false);

		/**
		 * jpanel1�����˺�
		 */
		JPanel jPanel1 = new JPanel();
		jPanel1.setLayout(new FlowLayout());
		JLabel jLabel_zhanghao = new JLabel("�˺�", JLabel.RIGHT);
		jLabel_zhanghao.setFont(new Font("����", Font.BOLD, 20));
		jTextField_zhanghao = new JTextField(15);
		jPanel1.add(jLabel_zhanghao);
		jPanel1.setOpaque(false);
		jPanel1.add(jTextField_zhanghao);
		jPane_denlu.add(jPanel1);

		/**
		 * jpanel��������
		 */
		JPanel jPanel2 = new JPanel();
		jPanel2.setLayout(new FlowLayout());
		JLabel jLabel_mima = new JLabel("����", JLabel.RIGHT);
		jLabel_mima.setFont(new Font("����", Font.BOLD, 20));
		jPanel2.add(jLabel_mima);
		jPasswordField_mima = new JPasswordField(15);
		jPanel2.add(jPasswordField_mima);
		jPanel2.setOpaque(false);
		jPane_denlu.add(jPanel2);


		//JPanel jPanel3 = new JPanel();
		//jPanel3.setLayout(new FlowLayout(FlowLayout.CENTER));
		//jCheckBox_jizhu = new JCheckBox("��ס����");
		//jCheckBox_jizhu.setOpaque(false);
		//jPanel3.add(jCheckBox_jizhu);
		//jLabel_wangji = new JLabel("��������");
		//jLabel_wangji.setFont(new Font("����", Font.BOLD, 15));
		//jPanel3.add(jLabel_wangji);
		//jPane_denlu.add(jPanel3);
		//jPanel3.setOpaque(false);

		/**
		 * ��½ ע��button
		 */
		imageIcon_button.setImage(imageIcon_button.getImage()
				.getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		JPanel jPanel4 = new JPanel();
		jButton_denglu = new JButton("��¼", imageIcon_button);
		jButton_denglu.setContentAreaFilled(false);
		jPanel4.add(jButton_denglu);
		jbButton_zhuce = new JButton("ע��", imageIcon_button);
		jbButton_zhuce.setContentAreaFilled(false);
		jPanel4.add(jbButton_zhuce);
		jPanel4.setOpaque(false);
		jPane_denlu.add(jPanel4);

		jPane_denlu.setOpaque(false);
		return jPane_denlu;
	}

	/**
	 * ��½ ע�� �¼���� ����
	 */
	private void Dianji() {
		/**
		 * ��¼���¼����
		 */
		jButton_denglu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				//System.out.println("��¼����ɹ�");
				String string_zhanghao = jTextField_zhanghao.getText();
				String string_mima = jPasswordField_mima.getText();
				if (string_mima.equals("") || string_zhanghao.equals("")) {
					int num = 10;// ��������
					Point point = jFrame_login.getLocation();// ����λ��
					for (int i = 10; i > 0; i--) {
						// ���� ���
						for (int j = num; j > 0; j--) {
							point.y += i;
							jFrame_login.setLocation(point);
							point.x += i;
							jFrame_login.setLocation(point);
							point.y -= i;
							jFrame_login.setLocation(point);
							point.x -= i;
							jFrame_login.setLocation(point);

						}
					}
					/**
					 * ϵͳ������Ϣ
					 */
					JOptionPane.showMessageDialog(
							jFrame_login.getContentPane(), "������˺Ų���Ϊ��!",
							"today��¼ϵͳ��Ϣ", JOptionPane.WARNING_MESSAGE);
					//System.out.println("������˺Ų���Ϊ��");
				} else {
					Employee employee = new Employee();
					System.out.println(string_zhanghao+string_mima);
					if (employee.loginin(string_zhanghao, string_mima)) {

						String zhiwei = employee
								.employeeZhiWei(string_zhanghao);

						AdministratorGeRenXinXi.string_Gonghao = string_zhanghao;
						ConductorGeRenXinXi.string_Gonghao = string_zhanghao;
						/**
						 * ͨ����¼ �˺����� Ȼ������ݿ��� ��ȡְλ�� ����Ա���� ��ƱԱ Ȼ�� ���� ����� ѡ���¼
						 */
						jFrame_login.dispose();

						new LoginJProgressBar();
						//System.out.println(zhiwei);
						if (zhiwei.equals("��ƱԱ")) {
							LoginJProgressBar.tag = 1;

							 new Conductor();
						} else {

							 new Administrator();
							LoginJProgressBar.tag = 2;
						}

					} else {
						int num = 10;// ��������
						Point point = jFrame_login.getLocation();// ����λ��
						for (int i = 10; i > 0; i--) {
							// ���� ���
							for (int j = num; j > 0; j--) {
								point.y += i;
								jFrame_login.setLocation(point);
								point.x += i;
								jFrame_login.setLocation(point);
								point.y -= i;
								jFrame_login.setLocation(point);
								point.x -= i;
								jFrame_login.setLocation(point);

							}
						}
						/**
						 * ϵͳ������ʾ��Ϣ
						 */
						JOptionPane.showMessageDialog(
								jFrame_login.getContentPane(), "������˺Ŵ��󣬵�¼ʧ��!",
								"today��¼ϵͳ��Ϣ", JOptionPane.ERROR_MESSAGE);
						System.out.println("��¼ʧ��");

					}
				}
			}
		});
		/**
		 * ע����¼��������
		 */
		jbButton_zhuce.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jFrame_login.dispose();
				new Registered();
				//System.out.println("ע�����ɹ�");
			}
		});



	}

	/**
	 * �رյ�Jpanel
	 *
	 * @return
	 */
	private JPanel gaunbi() {
		JPanel jPanel_waibu = new JPanel();

		Insets insets = new Insets(2, 2, 2, 2);
		// ���ùر� ��С���Ĳ���
		GridBagLayout gridBagLayout = new GridBagLayout();
		jPanel_waibu.setLayout(gridBagLayout);
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.insets = insets;

		ImageIcon imageIcon_denglu = new ImageIcon(
				Login.class.getResource("/com/today/images/denglu.png"));
		imageIcon_denglu.setImage(imageIcon_denglu.getImage()
				.getScaledInstance(550, 120, Image.SCALE_DEFAULT));
		JLabel jLabel = new JLabel(imageIcon_denglu);
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
				System.out.println("login�Ĺر�button����ɹ�");
				jFrame_login.dispose();
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
				//System.out.println("login����С��button����ɹ�");
				jFrame_login.setExtendedState(JFrame.ICONIFIED);
			}
		});

		jPanel_waibu.add(jButton_guanbi);
		jPanel_waibu.add(jButton_zuixiaohua);
		jPanel_waibu.setOpaque(false);
		return jPanel_waibu;
	}

}
