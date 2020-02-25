package com.today.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import com.mysql.jdbc.EscapeTokenizer;
import com.xy.today.mycontrols.JComboBox_Item;
import com.xy.today.sql.Employee;
import com.xy.today.util.EmployeeInformation;

/**
 * ����Ա�ĸ�����Ϣ tabpanel ��Ҫ ���� jatablepanel

 */
public class AdministratorGeRenXinXi extends JTabbedPane {

	public static String string_Gonghao = "04163155";
	private String string_Xingming = "xxn";
	private String string_Nianling = "18";
	private String string_Xingbie = "Ů";
	private String string_Dianhua = "15691756779";
	private String string_Dizhi = "����ʡ";
	private String string_Zhiwei = "����";
	private String string_Youxiang = "2870466010@qq.com";
	private String string_Ruzhishijian = "2018/6/30";
	private String string_Yuexin = "16K";
	private String string_Yilinggongzi = "288K";
	private String string_Qingjiatianshu = "29";
	private String string_Password = "123456";

	private JLabel jLabel_tuichudenglu;

	private JLabel jLabel_Xingming;
	private JLabel jLabel_Nianling;
	private JLabel jLabel_Xingbei;
	private JLabel jLabel_youxiang;
	private JLabel jLabel_dizhi;
	private JLabel jLabel_zhiwei;
	private JLabel jLabel_dianhua;

	/**
	 * �ؼ�����
	 */
	private JPasswordField jPasswordField_jiumima = new JPasswordField(15);
	private JPasswordField jPasswordField_xinmima = new JPasswordField(15);
	private JPasswordField jPasswordField_xinmima2 = new JPasswordField(15);
	private JButton jButton_querenxiugai;
	private JLabel jLabel_wangjimima;

	private JTextField jTextField_xingming = new JTextField(10);
	private JTextField jTextField_nianling = new JTextField(10);;
	private JTextField jTextField_dianhua = new JTextField(15);;
	private JTextField jTextField_youxiang = new JTextField(15);;
	private JTextField jTextField_dizhi = new JTextField(15);;

	/**
	 * ְλ��ѡ��
	 */
	private JComboBox jComboBox_zhiwei;
	private JComboBox jComboBox_xingbie;
	private JButton jButton_xinxixiugai;

	public AdministratorGeRenXinXi() {
		/**
		 * ������Ϣ
		 */

		// ������Ϣ���ݵ����
		geRenXinxiRuKou();

		ImageIcon imageIcon_gerenxinxi = new ImageIcon(
				Login.class.getResource("/com/today/images/gerenxinxi.png"));
		imageIcon_gerenxinxi.setImage(imageIcon_gerenxinxi.getImage()
				.getScaledInstance(120, 40, Image.SCALE_DEFAULT));
		addTab("", imageIcon_gerenxinxi, geRenXinXi());

		/**
		 * ��Ϣ�޸�
		 */
		// �޸���Ϣ���������
		ImageIcon imageIcon_xinxixiugai = new ImageIcon(
				Login.class.getResource("/com/today/images/xinxixiugai.png"));
		imageIcon_xinxixiugai.setImage(imageIcon_xinxixiugai.getImage()
				.getScaledInstance(120, 40, Image.SCALE_DEFAULT));
		addTab("", imageIcon_xinxixiugai, xiuXiXiuGai());
		setTabPlacement(JTabbedPane.TOP);
		xiuGanXinXiShuJuRuKou();
	}

	/**
	 * ������Ϣ չʾ
	 *
	 * @return
	 */
	private JPanel geRenXinXi() {
		JPanel jPanel = new JPanel();
		jPanel.setBackground(Color.black);
		jPanel.setOpaque(false);
		jPanel.setLayout(new GridLayout(6, 1));

		// �� ռλ��
		JPanel jPanel4 = new JPanel();
		jPanel4.setOpaque(false);
		jPanel.add(jPanel4);

		// ���� ��һ������
		JPanel jPanel0 = geRen0();
		jPanel0.setOpaque(false);
		jPanel.add(jPanel0);

		// �绰 �ڶ���
		JPanel jPanel1 = geRen1();
		jPanel1.setOpaque(false);
		jPanel.add(jPanel1);

		// ���� ������
		JPanel jPanel2 = geRen2();
		jPanel2.setOpaque(false);
		jPanel.add(jPanel2);

		// ��н ������
		JPanel jPanel3 = geRen3();
		jPanel3.setOpaque(false);
		jPanel.add(jPanel3);

		xinxidianji();

		return jPanel;
	}

	private void xinxidianji() {
		// TODO Auto-generated method stub
		/**
		 * �˳���¼�� ����¼�����
		 */
		jLabel_tuichudenglu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println("�˳���¼  ����ɹ�");
				ImageIcon imageIcon_xinxixiugai = new ImageIcon(Login.class
						.getResource("/com/today/images/tuichujinggao.png"));
				imageIcon_xinxixiugai.setImage(imageIcon_xinxixiugai.getImage()
						.getScaledInstance(50, 50, Image.SCALE_DEFAULT));
				int option = JOptionPane.showConfirmDialog(null, "ȷ���Ƿ��˳�",
						"todayϵͳ��ʾ", JOptionPane.YES_NO_OPTION,
						JOptionPane.WARNING_MESSAGE, imageIcon_xinxixiugai);
				switch (option) {
				case JOptionPane.YES_NO_OPTION: {
					Administrator.jFrame_GuanLi.dispose();
					new Login();
					break;
				}
				case JOptionPane.NO_OPTION: {
					System.out.println("���˳��ɹ�");
					break;
				}

				}
			}
		});
	}

	/**
	 * ������Ϣ �� ��һ��
	 *
	 * @return
	 */
	private JPanel geRen0() {

		JPanel jPanel = new JPanel();
		jPanel.setLayout(new GridLayout(1, 5));

		/**
		 * ����
		 */
		JPanel jPanel0 = new JPanel();
		jPanel0.setOpaque(false);
		jPanel0.setLayout(new FlowLayout());
		// ����ͼƬ
		ImageIcon imageIcon_gonghao = new ImageIcon(
				Login.class.getResource("/com/today/images/gonghao.png"));
		imageIcon_gonghao.setImage(imageIcon_gonghao.getImage()
				.getScaledInstance(80, 40, Image.SCALE_DEFAULT));
		JLabel jLabel_gonghaotu = new JLabel(imageIcon_gonghao, JLabel.RIGHT);
		// ����
		JLabel jLabel_gonghao = new JLabel(string_Gonghao, JLabel.LEFT);
		jLabel_gonghao.setFont(new Font("����", Font.BOLD, 20));
		jLabel_gonghao.setForeground(Color.black);
		jPanel0.add(jLabel_gonghaotu);
		jPanel0.add(jLabel_gonghao);
		jPanel.add(jPanel0);

		/**
		 * ����
		 */
		JPanel jPanel1 = new JPanel();
		jPanel1.setOpaque(false);
		jPanel1.setLayout(new FlowLayout());
		// ����ͼƬ
		ImageIcon imageIcon_Xingming = new ImageIcon(
				Login.class.getResource("/com/today/images/xingming.png"));
		imageIcon_Xingming.setImage(imageIcon_Xingming.getImage()
				.getScaledInstance(80, 40, Image.SCALE_DEFAULT));
		JLabel jLabel_Xingmingtu = new JLabel(imageIcon_Xingming, JLabel.RIGHT);
		// ����
		jLabel_Xingming = new JLabel(string_Xingming, JLabel.LEFT);
		jLabel_Xingming.setFont(new Font("����", Font.BOLD, 20));
		jLabel_Xingming.setForeground(Color.black);
		jPanel1.add(jLabel_Xingmingtu);
		jPanel1.add(jLabel_Xingming);
		jPanel.add(jPanel1);

		/**
		 * ����
		 */
		JPanel jPanel2 = new JPanel();
		jPanel2.setOpaque(false);
		jPanel2.setLayout(new FlowLayout());
		// ����ͼƬ
		ImageIcon imageIcon_Nianling = new ImageIcon(
				Login.class.getResource("/com/today/images/nianling.png"));
		imageIcon_Nianling.setImage(imageIcon_Nianling.getImage()
				.getScaledInstance(80, 40, Image.SCALE_DEFAULT));
		JLabel jLabel_Nianlingtu = new JLabel(imageIcon_Nianling, JLabel.RIGHT);
		// ����
		jLabel_Nianling = new JLabel(string_Nianling, JLabel.LEFT);
		jLabel_Nianling.setFont(new Font("����", Font.BOLD, 20));
		jLabel_Nianling.setForeground(Color.black);
		jPanel2.add(jLabel_Nianlingtu);
		jPanel2.add(jLabel_Nianling);
		jPanel.add(jPanel2);

		/**
		 * �Ա�
		 */
		JPanel jPanel3 = new JPanel();
		jPanel3.setOpaque(false);
		jPanel3.setLayout(new FlowLayout());
		// ����ͼƬ
		ImageIcon imageIcon_Xingbei = new ImageIcon(
				Login.class.getResource("/com/today/images/xingbie.png"));
		imageIcon_Xingbei.setImage(imageIcon_Xingbei.getImage()
				.getScaledInstance(80, 40, Image.SCALE_DEFAULT));
		JLabel jLabel_Xingbeitu = new JLabel(imageIcon_Xingbei, JLabel.RIGHT);
		// ����
		 jLabel_Xingbei = new JLabel(string_Xingbie, JLabel.LEFT);
		jLabel_Xingbei.setFont(new Font("����", Font.BOLD, 20));
		jLabel_Xingbei.setForeground(Color.black);
		jPanel3.add(jLabel_Xingbeitu);
		jPanel3.add(jLabel_Xingbei);
		jPanel.add(jPanel3);

		/**
		 * �˳���¼
		 */
		JPanel jPanel4 = new JPanel();
		jPanel4.setOpaque(false);
		jPanel4.setLayout(new FlowLayout());
		// ͼƬ
		ImageIcon imageIcon_tuichudenglu = new ImageIcon(
				Login.class.getResource("/com/today/images/tuichudenglu.png"));
		imageIcon_tuichudenglu.setImage(imageIcon_tuichudenglu.getImage()
				.getScaledInstance(160, 40, Image.SCALE_DEFAULT));
		jLabel_tuichudenglu = new JLabel(imageIcon_tuichudenglu, JLabel.RIGHT);
		jPanel4.add(jLabel_tuichudenglu);
		jPanel.add(jPanel4);

		return jPanel;

	}

	/**
	 * ������Ϣ �� ��er��
	 *
	 * @return
	 */
	private JPanel geRen1() {

		JPanel jPanel = new JPanel();
		jPanel.setLayout(new GridLayout(1, 3));

		/**
		 * �绰
		 */
		JPanel jPanel0 = new JPanel();
		jPanel0.setOpaque(false);
		jPanel0.setLayout(new FlowLayout());
		// �绰ͼƬ
		ImageIcon imageIcon_gonghao = new ImageIcon(
				Login.class.getResource("/com/today/images/dianhua.png"));
		imageIcon_gonghao.setImage(imageIcon_gonghao.getImage()
				.getScaledInstance(80, 40, Image.SCALE_DEFAULT));
		JLabel jLabel_gonghaotu = new JLabel(imageIcon_gonghao, JLabel.RIGHT);
		// �绰
		jLabel_dianhua = new JLabel(string_Dianhua, JLabel.LEFT);
		jLabel_dianhua.setFont(new Font("����", Font.BOLD, 20));
		jLabel_dianhua.setForeground(Color.black);
		jPanel0.add(jLabel_gonghaotu);
		jPanel0.add(jLabel_dianhua);
		jPanel.add(jPanel0);

		/**
		 * ��ַ
		 */
		JPanel jPanel1 = new JPanel();
		jPanel1.setOpaque(false);
		jPanel1.setLayout(new FlowLayout());
		// ��ַͼƬ
		ImageIcon imageIcon_Xingming = new ImageIcon(
				Login.class.getResource("/com/today/images/dizhi.png"));
		imageIcon_Xingming.setImage(imageIcon_Xingming.getImage()
				.getScaledInstance(80, 40, Image.SCALE_DEFAULT));
		JLabel jLabel_Xingmingtu = new JLabel(imageIcon_Xingming, JLabel.RIGHT);
		// ��ַ
		jLabel_dizhi = new JLabel(string_Dizhi, JLabel.LEFT);
		jLabel_dizhi.setFont(new Font("����", Font.BOLD, 20));
		jLabel_dizhi.setForeground(Color.black);
		jPanel1.add(jLabel_Xingmingtu);
		jPanel1.add(jLabel_dizhi);
		jPanel.add(jPanel1);

		/**
		 * ְλ
		 */
		JPanel jPanel2 = new JPanel();
		jPanel2.setOpaque(false);
		jPanel2.setLayout(new FlowLayout());
		// ְλͼƬ
		ImageIcon imageIcon_Nianling = new ImageIcon(
				Login.class.getResource("/com/today/images/zhiwei.png"));
		imageIcon_Nianling.setImage(imageIcon_Nianling.getImage()
				.getScaledInstance(80, 40, Image.SCALE_DEFAULT));
		JLabel jLabel_Nianlingtu = new JLabel(imageIcon_Nianling, JLabel.RIGHT);
		// ְλ
		jLabel_zhiwei = new JLabel(string_Zhiwei, JLabel.LEFT);
		jLabel_zhiwei.setFont(new Font("����", Font.BOLD, 20));
		jLabel_zhiwei.setForeground(Color.black);
		jPanel2.add(jLabel_Nianlingtu);
		jPanel2.add(jLabel_zhiwei);
		jPanel.add(jPanel2);

		return jPanel;

	}

	/**
	 * ������Ϣ �� ��san��
	 *
	 * @return
	 */
	private JPanel geRen2() {

		JPanel jPanel = new JPanel();
		jPanel.setLayout(new GridLayout(1, 2));
		/**
		 * ����
		 */
		JPanel jPanel0 = new JPanel();
		jPanel0.setOpaque(false);
		jPanel0.setLayout(new FlowLayout());
		// ����ͼƬ
		ImageIcon imageIcon_gonghao = new ImageIcon(
				Login.class.getResource("/com/today/images/youxiang.png"));
		imageIcon_gonghao.setImage(imageIcon_gonghao.getImage()
				.getScaledInstance(80, 40, Image.SCALE_DEFAULT));
		JLabel jLabel_gonghaotu = new JLabel(imageIcon_gonghao, JLabel.RIGHT);
		// ����
		jLabel_youxiang = new JLabel(string_Youxiang, JLabel.LEFT);
		jLabel_youxiang.setFont(new Font("����", Font.BOLD, 20));
		jLabel_youxiang.setForeground(Color.black);
		jPanel0.add(jLabel_gonghaotu);
		jPanel0.add(jLabel_youxiang);
		jPanel.add(jPanel0);

		/**
		 * ��ְʱ��
		 */
		JPanel jPanel1 = new JPanel();
		jPanel1.setOpaque(false);
		jPanel1.setLayout(new FlowLayout());
		// ��ְʱ��ͼƬ
		ImageIcon imageIcon_Xingming = new ImageIcon(
				Login.class.getResource("/com/today/images/ruzhishijian.png"));
		imageIcon_Xingming.setImage(imageIcon_Xingming.getImage()
				.getScaledInstance(160, 40, Image.SCALE_DEFAULT));
		JLabel jLabel_Xingmingtu = new JLabel(imageIcon_Xingming, JLabel.RIGHT);
		// ��ְʱ��
		JLabel jLabel_Xingming = new JLabel(string_Ruzhishijian, JLabel.LEFT);
		jLabel_Xingming.setFont(new Font("����", Font.BOLD, 20));
		jLabel_Xingming.setForeground(Color.black);
		jPanel1.add(jLabel_Xingmingtu);
		jPanel1.add(jLabel_Xingming);
		jPanel.add(jPanel1);

		return jPanel;

	}

	/**
	 * ������Ϣ �� ��si��
	 *
	 * @return
	 */
	private JPanel geRen3() {

		JPanel jPanel = new JPanel();

		jPanel.setLayout(new GridLayout(1, 3));

		/**
		 * ��н
		 */
		JPanel jPanel0 = new JPanel();
		jPanel0.setOpaque(false);
		jPanel0.setLayout(new FlowLayout());
		// ��нͼƬ
		ImageIcon imageIcon_gonghao = new ImageIcon(
				Login.class.getResource("/com/today/images/yuexin.png"));
		imageIcon_gonghao.setImage(imageIcon_gonghao.getImage()
				.getScaledInstance(80, 40, Image.SCALE_DEFAULT));
		JLabel jLabel_gonghaotu = new JLabel(imageIcon_gonghao, JLabel.RIGHT);
		// ��н
		JLabel jLabel_gonghao = new JLabel(string_Yuexin, JLabel.LEFT);
		jLabel_gonghao.setFont(new Font("����", Font.BOLD, 20));
		jLabel_gonghao.setForeground(Color.black);
		jPanel0.add(jLabel_gonghaotu);
		jPanel0.add(jLabel_gonghao);
		jPanel.add(jPanel0);

		/**
		 * ���칤��
		 */
		JPanel jPanel1 = new JPanel();
		jPanel1.setOpaque(false);
		jPanel1.setLayout(new FlowLayout());
		// ���칤��ͼƬ
		ImageIcon imageIcon_Xingming = new ImageIcon(
				Login.class.getResource("/com/today/images/yilingxinzi.png"));
		imageIcon_Xingming.setImage(imageIcon_Xingming.getImage()
				.getScaledInstance(160, 40, Image.SCALE_DEFAULT));
		JLabel jLabel_Xingmingtu = new JLabel(imageIcon_Xingming, JLabel.RIGHT);
		// ���칤��
		JLabel jLabel_Xingming = new JLabel(string_Yilinggongzi, JLabel.LEFT);
		jLabel_Xingming.setFont(new Font("����", Font.BOLD, 20));
		jLabel_Xingming.setForeground(Color.black);
		jPanel1.add(jLabel_Xingmingtu);
		jPanel1.add(jLabel_Xingming);
		jPanel.add(jPanel1);

		/**
		 * �������
		 */
		JPanel jPanel2 = new JPanel();
		jPanel2.setOpaque(false);
		jPanel2.setLayout(new FlowLayout());
		// �������ͼƬ
		ImageIcon imageIcon_Nianling = new ImageIcon(
				Login.class.getResource("/com/today/images/qingjiatianshu.png"));
		imageIcon_Nianling.setImage(imageIcon_Nianling.getImage()
				.getScaledInstance(160, 40, Image.SCALE_DEFAULT));
		JLabel jLabel_Nianlingtu = new JLabel(imageIcon_Nianling, JLabel.RIGHT);
		// �������
		JLabel jLabel_Nianling = new JLabel(string_Qingjiatianshu, JLabel.LEFT);
		jLabel_Nianling.setFont(new Font("����", Font.BOLD, 20));
		jLabel_Nianling.setForeground(Color.black);
		jPanel2.add(jLabel_Nianlingtu);
		jPanel2.add(jLabel_Nianling);
		jPanel.add(jPanel2);
		return jPanel;

	}

	/**
	 * ������Ϣ�����ݻ�ȡ
	 */
	private void geRenXinxiRuKou() {
		List<EmployeeInformation> employees = new ArrayList<EmployeeInformation>();
		Employee employee = new Employee();
		employees = employee.prinfEmployee(string_Gonghao);
		string_Dianhua = employees.get(0).getEmp_Tel_Num();
		string_Dizhi = employees.get(0).getEmp_Addr();
		string_Nianling = employees.get(0).getEmp_Age();
		string_Qingjiatianshu = employees.get(0).getEmp_Holiday();
		string_Ruzhishijian = employees.get(0).getEmp_Induction_Time();
		string_Xingbie = employees.get(0).getEmp_Sex();
		string_Xingming = employees.get(0).getEmp_Name();
		string_Yilinggongzi = employees.get(0).getEmp_Sum_Money();
		string_Youxiang = employees.get(0).getEmp_Email();
		string_Yuexin = employees.get(0).getEmp_Month_Money();
		string_Zhiwei = employees.get(0).getEmp_Position();
		string_Password = employees.get(0).getEmp_Password();


	}

	/**
	 * ��Ϣ�޸�
	 *
	 * @return
	 */
	private JTabbedPane xiuXiXiuGai() {
		JTabbedPane jTabbedPane = new JTabbedPane();
		jTabbedPane.setOpaque(false);
		jTabbedPane.setBackground(new Color(1,1,0,0));
		jTabbedPane.setTabPlacement(JTabbedPane.RIGHT);

		/**
		 * ������Ϣ�޸�
		 */
		ImageIcon imageIcon_gerenxinxi = new ImageIcon(
				Login.class
						.getResource("/com/today/images/gerenxinxixiugai.png"));
		imageIcon_gerenxinxi.setImage(imageIcon_gerenxinxi.getImage()
				.getScaledInstance(150, 30, Image.SCALE_DEFAULT));
		jTabbedPane.addTab("", imageIcon_gerenxinxi, geRenXinXiXiuGai());
		xinxiXiuGaiDianJi();

		/**
		 * �����޸�
		 */
		ImageIcon imageIcon_xinxixiugai = new ImageIcon(
				Login.class.getResource("/com/today/images/mimaxiugai.png"));
		imageIcon_xinxixiugai.setImage(imageIcon_xinxixiugai.getImage()
				.getScaledInstance(100, 30, Image.SCALE_DEFAULT));
		jTabbedPane.addTab("", imageIcon_xinxixiugai, mimaxiugai());
		jTabbedPane.setBackground(new Color(1, 1, 0, 0));
		mimaDianji();

		return jTabbedPane;
	}

	/**
	 * �޸���Ϣ ���������
	 */
	private void xiuGanXinXiShuJuRuKou() {
		// TODO Auto-generated method stub
		jTextField_dianhua.setText(string_Dianhua);
		jTextField_dizhi.setText(string_Dizhi);
		jTextField_nianling.setText(string_Nianling);
		jTextField_xingming.setText(string_Xingming);
		jTextField_youxiang.setText(string_Youxiang);
		String xing = string_Xingbie;
		String zhiwei =string_Zhiwei;
		if (zhiwei.equals("����")) {
			jComboBox_zhiwei.setSelectedIndex(0);
		}else {

			jComboBox_zhiwei.setSelectedIndex(1);
		}
		if (xing.equals("��")) {
			jComboBox_xingbie.setSelectedIndex(0);
		}else {
			jComboBox_xingbie.setSelectedIndex(1);
		}
	}

	/**
	 * ��Ϣ�޸ĵ���¼��� ����
	 */
	private void xinxiXiuGaiDianJi() {
		// TODO Auto-generated method stub
		jButton_xinxixiugai.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("��Ϣ�޸ĵ���¼�");
				String string_xingming = jTextField_xingming.getText();
				String string_nianling = jTextField_nianling.getText();
				String string_dianhua = jTextField_dianhua.getText();
				String string_youxiang = jTextField_youxiang.getText();
				String string_dizhi = jTextField_dizhi.getText();
				String string_sex = "����";
				String string_zhiwei = "Ů";
				int zhiwei = jComboBox_zhiwei.getSelectedIndex();
				if (zhiwei == 0) {
					string_zhiwei = "����";
				} else {
					string_zhiwei = "��ƱԱ";
				}
				int sex = jComboBox_zhiwei.getSelectedIndex();
				if (sex == 0) {
					string_sex = "��";
				} else {
					string_sex = "Ů";
				}
				Employee employee = new Employee();
				if (employee.geRenXinXiXiuGai(string_xingming, string_nianling,
						string_dianhua, string_youxiang, string_dizhi,
						string_sex, string_zhiwei, string_Gonghao)) {
					/**
					 * ϵͳ������Ϣ
					 */
					JOptionPane.showMessageDialog(
							Administrator.jFrame_GuanLi.getContentPane(),
							"�޸���Ϣ�ɹ���", "today�޸�ϵͳ��Ϣ",
							JOptionPane.WARNING_MESSAGE);
					jLabel_dianhua.setText(string_dianhua);
					jLabel_dizhi.setText(string_dizhi);
					jLabel_Nianling.setText(string_nianling);
					jLabel_Xingbei.setText(string_sex);
					jLabel_Xingming.setText(string_xingming);
					jLabel_youxiang.setText(string_youxiang);
					jLabel_zhiwei.setText(string_zhiwei);

					System.out.println("������Ϣ�޸ĳɹ���");
				} else {
					JOptionPane.showMessageDialog(
							Administrator.jFrame_GuanLi.getContentPane(),
							"�޸���Ϣʧ�ܣ�", "today�޸�ϵͳ��Ϣ",
							JOptionPane.WARNING_MESSAGE);
					System.out.println("������Ϣ�޸�ʧ�ܣ�");
				}
			}
		});
	}

	/**
	 * �������¼��� ����
	 */
	private void mimaDianji() {
		// TODO Auto-generated method stub
		// ��������ĵ���¼�������
		jLabel_wangjimima.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println("�����������ɹ�");
			}
		});

		// ȷ�������޸ĵĵ���¼�������
		jButton_querenxiugai.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String string_xinmima = jPasswordField_xinmima.getText();
				String string_jiumima = jPasswordField_jiumima.getText();
				String string_xinmima2 = jPasswordField_xinmima2.getText();
				if (string_jiumima.equals("")) {
					JOptionPane.showMessageDialog(
							Administrator.jFrame_GuanLi.getContentPane(),
							"�����벻��Ϊ��!", "today�����޸�ϵͳ��ʾ",
							JOptionPane.WARNING_MESSAGE);
				} else if (string_xinmima.equals("")) {
					JOptionPane.showMessageDialog(
							Administrator.jFrame_GuanLi.getContentPane(),
							"�����벻��Ϊ��!", "today�����޸�ϵͳ��ʾ",
							JOptionPane.WARNING_MESSAGE);
				} else if (string_xinmima2.equals("")) {
					JOptionPane.showMessageDialog(
							Administrator.jFrame_GuanLi.getContentPane(),
							"��������������벻��Ϊ��!", "today�����޸�ϵͳ��ʾ",
							JOptionPane.WARNING_MESSAGE);
				} else if (!string_xinmima.equals(string_xinmima2)) {
					JOptionPane.showMessageDialog(
							Administrator.jFrame_GuanLi.getContentPane(),
							"������������벻һ��������������!", "today�����޸�ϵͳ��ʾ",
							JOptionPane.WARNING_MESSAGE);
				} else {
					String string_newPass = jPasswordField_xinmima.getText();
					String string_pass = jPasswordField_jiumima.getText();
					Employee employee = new Employee();
					if (employee.loginin(string_Gonghao, string_pass)) {
						if (employee.miMaXiuGai(string_newPass, string_Gonghao)) {
							/**
							 * ϵͳ������Ϣ
							 */
							JOptionPane.showMessageDialog(
									Administrator.jFrame_GuanLi
											.getContentPane(), "�����޸ĳɹ���",
									"today�޸�ϵͳ��Ϣ", JOptionPane.WARNING_MESSAGE);
						}else{
							JOptionPane.showMessageDialog(
									Administrator.jFrame_GuanLi
											.getContentPane(), "�����޸�ʧ�ܣ�",
									"today�޸�ϵͳ��Ϣ", JOptionPane.WARNING_MESSAGE);
						}
					}else {
						JOptionPane.showMessageDialog(
								Administrator.jFrame_GuanLi
										.getContentPane(), "�������",
								"today�޸�ϵͳ��Ϣ", JOptionPane.WARNING_MESSAGE);
					}
					System.out.println("�ɹ�");
				}

			}
		});
	}

	/**
	 * �����޸� jpanel
	 *
	 * @return
	 */
	private JPanel mimaxiugai() {
		// TODO Auto-generated method stub
		JPanel jPanel = new JPanel();
		jPanel.setOpaque(false);
		jPanel.setLayout(new GridLayout(6, 1));

		/**
		 * �����޸� ͼƬS
		 */
		ImageIcon imageIcon_xinxixiugai = new ImageIcon(
				Login.class.getResource("/com/today/images/mimaxiugai.png"));
		imageIcon_xinxixiugai.setImage(imageIcon_xinxixiugai.getImage()
				.getScaledInstance(300, 70, Image.SCALE_DEFAULT));
		JPanel jPanel0 = new JPanel();
		jPanel0.setLayout(new FlowLayout());
		JLabel jLabel_tu = new JLabel(imageIcon_xinxixiugai);
		jPanel0.add(jLabel_tu);
		jPanel0.setOpaque(false);
		jPanel.add(jPanel0);

		/**
		 * ������
		 */
		JPanel jPanel1 = new JPanel();
		jPanel1.setLayout(new FlowLayout());
		// ������ͼƬ
		ImageIcon imageIcon_jiumima = new ImageIcon(
				Login.class.getResource("/com/today/images/jiumima.png"));
		imageIcon_jiumima.setImage(imageIcon_jiumima.getImage()
				.getScaledInstance(120, 40, Image.SCALE_DEFAULT));
		JLabel jLabel_jiumimatu = new JLabel(imageIcon_jiumima, JLabel.RIGHT);
		// �����������
		jPasswordField_jiumima = new JPasswordField(15);
		jPanel1.add(jLabel_jiumimatu);
		jPanel1.add(jPasswordField_jiumima);
		jPanel1.setOpaque(false);
		jPanel.add(jPanel1);

		/**
		 * ������
		 */
		JPanel jPanel2 = new JPanel();
		jPanel2.setLayout(new FlowLayout());
		// ������ͼƬ
		ImageIcon imageIcon_xinmima = new ImageIcon(
				Login.class.getResource("/com/today/images/xinmima.png"));
		imageIcon_xinmima.setImage(imageIcon_xinmima.getImage()
				.getScaledInstance(120, 40, Image.SCALE_DEFAULT));
		JLabel jLabel_xinmimatu = new JLabel(imageIcon_xinmima, JLabel.RIGHT);
		// �����������
		jPanel2.add(jLabel_xinmimatu);
		jPanel2.add(jPasswordField_xinmima);
		jPanel2.setOpaque(false);
		jPanel.add(jPanel2);

		/**
		 * �ٴ���������
		 */
		JPanel jPanel3 = new JPanel();
		jPanel3.setLayout(new FlowLayout());
		// �ٴ���������ͼƬ
		ImageIcon imageIcon_xinmima2 = new ImageIcon(
				Login.class
						.getResource("/com/today/images/zaicishuruxinmima.png"));
		imageIcon_xinmima2.setImage(imageIcon_xinmima2.getImage()
				.getScaledInstance(240, 40, Image.SCALE_DEFAULT));
		JLabel jLabel_xinmima2tu = new JLabel(imageIcon_xinmima2, JLabel.RIGHT);
		// �ٴ��������������
		jPasswordField_xinmima2 = new JPasswordField(15);
		jPanel3.add(jLabel_xinmima2tu);
		jPanel3.add(jPasswordField_xinmima2);
		jPanel3.setOpaque(false);
		jPanel.add(jPanel3);

		/**
		 * ȷ���޸� ��ť
		 */
		JPanel jPanel4 = new JPanel();
		jPanel4.setLayout(new FlowLayout());
		ImageIcon imageIcon_button = new ImageIcon(
				Login.class.getResource("/com/today/images/button.png"));
		imageIcon_button.setImage(imageIcon_button.getImage()
				.getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		jButton_querenxiugai = new JButton("ȷ���޸�", imageIcon_button);
		jButton_querenxiugai.setContentAreaFilled(false);
		jButton_querenxiugai.setForeground(Color.black);
		jPanel4.setOpaque(false);
		jPanel4.add(jButton_querenxiugai);
		jPanel.add(jPanel4);

		/**
		 * ��������LABLE
		 */
		JPanel jPanel5 = new JPanel();
		jPanel5.setLayout(new FlowLayout(FlowLayout.RIGHT));
		ImageIcon imageIcon_wangjimima = new ImageIcon(
				Login.class.getResource("/com/today/images/wangjimima.png"));
		imageIcon_wangjimima.setImage(imageIcon_wangjimima.getImage()
				.getScaledInstance(150, 50, Image.SCALE_DEFAULT));
		jLabel_wangjimima = new JLabel(imageIcon_wangjimima, JLabel.RIGHT);
		jPanel5.add(jLabel_wangjimima);
		jPanel5.setOpaque(false);
		jPanel.add(jPanel5);

		return jPanel;
	}

	/**
	 * ������Ϣ�޸�jpanle
	 *
	 * @return
	 */
	private JPanel geRenXinXiXiuGai() {
		// TODO Auto-generated method stub
		JPanel jPanel = new JPanel();
		jPanel.setOpaque(false);
		jPanel.setLayout(new GridLayout(5, 1));

		/**
		 * ������Ϣ�޸� ͼƬS
		 */
		ImageIcon imageIcon_xinxixiugai = new ImageIcon(
				Login.class
						.getResource("/com/today/images/gerenxinxixiugai.png"));
		imageIcon_xinxixiugai.setImage(imageIcon_xinxixiugai.getImage()
				.getScaledInstance(450, 70, Image.SCALE_DEFAULT));
		JPanel jPanel0 = new JPanel();
		jPanel0.setLayout(new FlowLayout());
		JLabel jLabel_tu = new JLabel(imageIcon_xinxixiugai);
		jPanel0.add(jLabel_tu);
		jPanel0.setOpaque(false);
		jPanel.add(jPanel0);

		/**
		 * ������Ϣ�޸� �ĵ�һ��
		 */
		JPanel jPanel1 = new JPanel();
		jPanel1.setOpaque(false);
		jPanel1.setLayout(new GridLayout(1, 3));
		/**
		 * ����
		 */
		JPanel jPanel10 = new JPanel();
		jPanel10.setOpaque(false);
		jPanel10.setLayout(new FlowLayout());
		ImageIcon imageIcon_xingming = new ImageIcon(
				Login.class.getResource("/com/today/images/xingming.png"));
		imageIcon_xingming.setImage(imageIcon_xingming.getImage()
				.getScaledInstance(80, 40, Image.SCALE_DEFAULT));
		JLabel jLabel_xingming = new JLabel(imageIcon_xingming, JLabel.RIGHT);
		jPanel10.add(jLabel_xingming);
		jPanel10.add(jTextField_xingming);
		jPanel1.add(jPanel10);
		/**
		 * ����
		 */
		JPanel jPanel11 = new JPanel();
		jPanel11.setOpaque(false);
		jPanel11.setLayout(new FlowLayout());
		ImageIcon imageIcon_nianling = new ImageIcon(
				Login.class.getResource("/com/today/images/nianling.png"));
		imageIcon_nianling.setImage(imageIcon_nianling.getImage()
				.getScaledInstance(80, 40, Image.SCALE_DEFAULT));
		JLabel jLabel_nianling = new JLabel(imageIcon_nianling, JLabel.RIGHT);
		// jTextField_nianling
		jPanel11.add(jLabel_nianling);
		jPanel11.add(jTextField_nianling);
		jPanel1.add(jPanel11);
		/**
		 * �Ա�
		 */
		JPanel jPanel12 = new JPanel();
		jPanel12.setOpaque(false);
		jPanel12.setLayout(new FlowLayout());
		/**
		 * �Ա�ѡ��s
		 */
		ImageIcon imageIcon_nan = new ImageIcon(
				Login.class.getResource("/com/today/images/nan.png"));
		imageIcon_nan.setImage(imageIcon_nan.getImage().getScaledInstance(30,
				30, Image.SCALE_DEFAULT));
		ImageIcon imageIcon_nv = new ImageIcon(
				Login.class.getResource("/com/today/images/nv.png"));
		imageIcon_nv.setImage(imageIcon_nv.getImage().getScaledInstance(30, 30,
				Image.SCALE_DEFAULT));
		ImageIcon imageIcon_xingbie = new ImageIcon(
				Login.class.getResource("/com/today/images/xingbie.png"));
		imageIcon_xingbie.setImage(imageIcon_xingbie.getImage()
				.getScaledInstance(80, 40, Image.SCALE_DEFAULT));
		JLabel jLabel_xingbie = new JLabel(imageIcon_xingbie, JLabel.RIGHT);
		jPanel12.add(jLabel_xingbie);
		jComboBox_xingbie = new JComboBox();
		jComboBox_xingbie.setMaximumRowCount(2);
		// ���� ���õ�Ԫ��
		jComboBox_xingbie.setRenderer(new JComboBox_Item());
		jComboBox_xingbie.setBackground(Color.black);
		jComboBox_xingbie.setSize(60, 40);
		jComboBox_xingbie.addItem(new Object[] { imageIcon_nan, "��", "�����Ա���" });
		jComboBox_xingbie.addItem(new Object[] { imageIcon_nv, "Ů", "�����Ա�Ů" });
		jPanel12.add(jComboBox_xingbie);
		jPanel1.add(jPanel12);
		jPanel.add(jPanel1);

		/**
		 * ������Ϣ�޸ĵĵڶ���
		 */
		JPanel jPanel2 = new JPanel();
		jPanel2.setOpaque(false);
		jPanel2.setLayout(new GridLayout(1, 2));
		/**
		 * �绰
		 */
		JPanel jPanel20 = new JPanel();
		jPanel20.setOpaque(false);
		jPanel20.setLayout(new FlowLayout());
		ImageIcon imageIcon_dianhua = new ImageIcon(
				Login.class.getResource("/com/today/images/dianhua.png"));
		imageIcon_dianhua.setImage(imageIcon_dianhua.getImage()
				.getScaledInstance(80, 40, Image.SCALE_DEFAULT));
		JLabel jLabel_dianhua = new JLabel(imageIcon_dianhua, JLabel.RIGHT);
		// jTextField_dianhua
		jPanel20.add(jLabel_dianhua);
		jPanel20.add(jTextField_dianhua);
		jPanel2.add(jPanel20);
		/**
		 * ְλ
		 */
		JPanel jPanel21 = new JPanel();
		jPanel21.setOpaque(false);
		jPanel21.setLayout(new FlowLayout());
		/**
		 * ְλѡ��s
		 */
		ImageIcon imageIcon_shoupiao = new ImageIcon(
				Login.class.getResource("/com/today/images/shoupiaoyuan.png"));
		imageIcon_shoupiao.setImage(imageIcon_shoupiao.getImage()
				.getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		ImageIcon imageIcon_guanli = new ImageIcon(
				Login.class.getResource("/com/today/images/guanliyuan.png"));
		imageIcon_guanli.setImage(imageIcon_guanli.getImage()
				.getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		ImageIcon imageIcon_zhiwei = new ImageIcon(
				Login.class.getResource("/com/today/images/zhiwei.png"));
		imageIcon_zhiwei.setImage(imageIcon_zhiwei.getImage()
				.getScaledInstance(80, 40, Image.SCALE_DEFAULT));
		JLabel jLabel_zhiwei = new JLabel(imageIcon_zhiwei, JLabel.RIGHT);
		jPanel21.add(jLabel_zhiwei);
		jComboBox_zhiwei = new JComboBox();
		jComboBox_zhiwei.setMaximumRowCount(2);
		// ���� ���õ�Ԫ��
		jComboBox_zhiwei.setRenderer(new JComboBox_Item());
		jComboBox_zhiwei.setBackground(Color.black);
		jComboBox_zhiwei.setSize(60, 40);
		jComboBox_zhiwei.addItem(new Object[] { imageIcon_guanli, "����",
				"today��Ժϵͳ����Ա" });
		jComboBox_zhiwei.addItem(new Object[] { imageIcon_shoupiao, "��ƱԱ",
				"today��Ժ��ƱԱ" });
		jPanel21.add(jComboBox_zhiwei);
		jPanel2.add(jPanel21);
		jPanel.add(jPanel2);

		/**
		 * ������Ϣ�޸ĵĵ�����
		 */
		JPanel jPanel3 = new JPanel();
		jPanel3.setOpaque(false);
		jPanel3.setLayout(new GridLayout(1, 2));
		/**
		 * ����
		 */
		JPanel jPanel30 = new JPanel();
		jPanel30.setOpaque(false);
		jPanel30.setLayout(new FlowLayout());
		ImageIcon imageIcon_youxiang = new ImageIcon(
				Login.class.getResource("/com/today/images/youxiang.png"));
		imageIcon_youxiang.setImage(imageIcon_youxiang.getImage()
				.getScaledInstance(80, 40, Image.SCALE_DEFAULT));
		JLabel jLabel_youxiang = new JLabel(imageIcon_youxiang, JLabel.RIGHT);
		// jTextField_youxiang
		jPanel30.add(jLabel_youxiang);
		jPanel30.add(jTextField_youxiang);
		jPanel3.add(jPanel30);
		/**
		 * ��ַ
		 */
		JPanel jPanel31 = new JPanel();
		jPanel31.setOpaque(false);
		jPanel31.setLayout(new FlowLayout());
		ImageIcon imageIcon_dizhi = new ImageIcon(
				Login.class.getResource("/com/today/images/dizhi.png"));
		imageIcon_dizhi.setImage(imageIcon_dizhi.getImage().getScaledInstance(
				80, 40, Image.SCALE_DEFAULT));
		JLabel jLabel_dizhi = new JLabel(imageIcon_dizhi, JLabel.RIGHT);
		// jTextField_dizhi
		jPanel31.add(jLabel_dizhi);
		jPanel31.add(jTextField_dizhi);
		jPanel3.add(jPanel31);
		jPanel.add(jPanel3);

		/**
		 * ������ ȷ���޸�
		 */
		/**
		 * ȷ���޸� ��ť
		 */
		JPanel jPanel4 = new JPanel();
		jPanel4.setLayout(new FlowLayout());
		ImageIcon imageIcon_button = new ImageIcon(
				Login.class.getResource("/com/today/images/button.png"));
		imageIcon_button.setImage(imageIcon_button.getImage()
				.getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		jButton_xinxixiugai = new JButton("ȷ���޸�", imageIcon_button);
		jButton_xinxixiugai.setContentAreaFilled(false);
		jButton_xinxixiugai.setForeground(Color.black);
		jPanel4.setOpaque(false);
		jPanel4.add(jButton_xinxixiugai);
		jPanel.add(jPanel4);

		return jPanel;
	}

}
