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
 * ����todayע��  ���棬��
 * ��ui����Ϣ  ��ȡ�����ݵ� ����һϵ�в����� ���ݿ���
 * @author lwp940118
 *
 */
public class Registered {

	/**
	 * ע��ui��Jfrmae
	 */
	private JFrame jFrame_Registered = new JFrame();
	/**
	 * ע���ͼƬ�߿�
	 */
	private ImageIcon imageIcon_Registered = new ImageIcon(
			Login.class.getResource("/com/today/images/Registered.gif"));
	private MyPanel jPanel_Registered;
	/**
	 * button��ͼƬ
	 */
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
	 * �رպ���С����ť
	 */
	private JButton jButton_guanbi;
	private JButton jButton_zuixiaohua;
	/**
	 * ����
	 */
	private JTextField jTextField_name;
	/**
	 * ����
	 */
	private JPasswordField jPasswordField_password;
	/**
	 * ְλ��ѡ��
	 */
	private JComboBox jComboBox;

	private JButton jButton_zhuce;
	private JButton jButton_quxiao;


	public static void main(String args[]){
		new Registered();
	}

	public Registered(){
		jFrame_Registered.setSize(900, 600);

		// ��һ��Ƕ�ף�login�����
		jPanel_Registered = registered_Jpanel();
		jPanel_Registered.setOpaque(false);

		jFrame_Registered.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame_Registered.setUndecorated(true);
		//AWTUtilities.setWindowOpaque(jFrame_login, false);
		jFrame_Registered.setContentPane(jPanel_Registered);
		// ���õ���¼�
		dianji();
		jFrame_Registered.setBackground(Color.black);
		jFrame_Registered.setLocationRelativeTo(null); // ���ô������
		jFrame_Registered.setVisible(true);
	}
	/**
	 * ����ע�����ĵ���¼�
	 */
	private void dianji() {

		jButton_quxiao.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("ȡ��button����ɹ�");
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
					string_zhiwei = "����";
				}else {
					string_zhiwei = "��ƱԱ";
				}
				if (string_name.equals("")) {

					int num = 10;// ��������
					Point point = jFrame_Registered.getLocation();// ����λ��
					for (int i = 10; i > 0; i--) {
						// ���� ���
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
							"��������Ϊ��!", "today��¼ϵͳ��Ϣ", JOptionPane.WARNING_MESSAGE);
				}else if(string_password.equals("")){
					int num = 10;// ��������
					Point point = jFrame_Registered.getLocation();// ����λ��
					for (int i = 10; i > 0; i--) {
						// ���� ���
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
							"���벻��Ϊ��!", "today��¼ϵͳ��Ϣ", JOptionPane.WARNING_MESSAGE);
				}else{
					Employee employee = new Employee();
					String string = employee.employeeRegistered(string_name,
							string_password, string_zhiwei);
					JOptionPane.showMessageDialog(jFrame_Registered.getContentPane(),
							"��ϲ����today��Ժע��ɹ�\n"+"����ע�����˺��ǣ�\n\t"+string+
							"\n���μǣ�������ʧ����ϵ���ܣ�18240800871"
							, "today��¼ϵͳ��Ϣ", JOptionPane.WARNING_MESSAGE);
					jFrame_Registered.dispose();
					new Login();
				}
			}
		});
	}

	/**
	 * jpanel����  Ƕ�׵�����
	 * @return
	 */
	private MyPanel registered_Jpanel(){
		MyPanel myPanel = new MyPanel(imageIcon_Registered.getImage(), 400, 800);

		Insets insets = new Insets(0, 0, 0, 0);
		myPanel.setBorder(new EmptyBorder(10, 100, 10, 100));
		// ���ùر� ��С���Ĳ���
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
	 * ע����������  ����s
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private JPanel zhuce() {
		// TODO Auto-generated method stub
		JPanel myPanel_zhuce = new JPanel();
		myPanel_zhuce.setLayout(new GridLayout(6,1));

		/**
		 * ��jpanelռ�ÿռ�
		 */
		JPanel jPanel0 = new JPanel();
		jPanel0.setOpaque(false);
		myPanel_zhuce.add(jPanel0);

		/**
		 * ��������
		 */
		JPanel jPanel1 = new JPanel();
		jPanel1.setLayout(new FlowLayout());
		JLabel jLabel_zhanghao = new JLabel("����", JLabel.RIGHT);
		jLabel_zhanghao.setFont(new Font("����", Font.BOLD, 20));
		jTextField_name = new JTextField(15);
		jPanel1.add(jLabel_zhanghao);
		jPanel1.setOpaque(false);
		jPanel1.add(jTextField_name);
		myPanel_zhuce.add(jPanel1);

		/**
		 * ��������
		 */
		JPanel jPanel2 = new JPanel();
		jPanel2.setLayout(new FlowLayout());
		JLabel jLabel_mima = new JLabel("����", JLabel.RIGHT);
		jLabel_mima.setFont(new Font("����", Font.BOLD, 20));
		jPasswordField_password = new JPasswordField(15);
		jPanel2.add(jLabel_mima);
		jPanel2.setOpaque(false);
		jPanel2.add(jPasswordField_password);
		myPanel_zhuce.add(jPanel2);

		/**
		 * ְλѡ��s
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
		JLabel jLabel_zhiwei = new JLabel("ְλ", JLabel.RIGHT);
		jLabel_zhiwei.setFont(new Font("����", Font.BOLD, 20));
		jPanel3.add(jLabel_zhiwei);
		jComboBox = new JComboBox();
		jComboBox.setMaximumRowCount(2);
		//����  ���õ�Ԫ��
		jComboBox.setRenderer(new JComboBox_Item());
		jComboBox.setBackground(Color.black);
		jComboBox.setSize(60, 40);
//		jComboBox.addItem(new Object[]{imageIcon_guanli,"����","today��Ժϵͳ����Ա"});
		jComboBox.addItem(new Object[]{imageIcon_shoupiao,"��ƱԱ","today��Ժ��ƱԱ"});
		jPanel3.add(jComboBox);
		jPanel3.setOpaque(false);
		myPanel_zhuce.add(jPanel3);

		/**
		 * ȡ�� ע��button
		 */
		imageIcon_button.setImage(imageIcon_button.getImage()
				.getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		JPanel jPanel4 = new JPanel();
		jButton_quxiao = new JButton("ȡ��", imageIcon_button);
		jButton_quxiao.setContentAreaFilled(false);
		jButton_zhuce = new JButton("ע��", imageIcon_button);
		jButton_zhuce.setContentAreaFilled(false);
		jPanel4.add(jButton_zhuce);
		jPanel4.add(jButton_quxiao);
		jPanel4.setOpaque(false);
		myPanel_zhuce.add(jPanel4);

		myPanel_zhuce.setOpaque(false);
		return myPanel_zhuce;
	}

	/**
	 * ע�������ⲿ����
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
				System.out.println("ע��Ĺر�button����ɹ�");
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
				System.out.println("ע�����С��button����ɹ�");
				jFrame_Registered.setExtendedState(JFrame.ICONIFIED);
			}
		});

		jPanel_waibu.add(jButton_guanbi);
		jPanel_waibu.add(jButton_zuixiaohua);
		jPanel_waibu.setOpaque(false);
		return jPanel_waibu;
	}

}
