package com.today.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.swing.AbstractCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.xml.ws.soap.AddressingFeature;

import com.xy.today.mycontrols.JComboBox_Item;
import com.xy.today.mycontrols.MyDateJbutton;
import com.xy.today.sql.Employee;
import com.xy.today.util.EmployeeInformation;

/**
 * Ա������ ��jtablepane
 *
 * @author lwp940118
 *
 */
public class AdministratorYuanGongGuanLi extends JTabbedPane {

	/**
	 * ���ҵ� jtextfiled
	 */
	private JTextField jTextField_search;

	/**
	 * ���ҵ� jbutton
	 */
	private JButton jButton_search;
	private JButton jButton_add;

	/**
	 * Ա�� ������Ϣ�Ĳ������
	 */
	private List<Object[]> data = new ArrayList<Object[]>();

	/**
	 * �Զ�����ģʽ
	 */
	private MyTableModel model;

	/**
	 * ���Ա����һЩ�ռ���Ϣ
	 */
	private JButton jButton_add_queding;
	private JButton jButton_add_quxiao;
	private JComboBox jComboBox_add_zhiwei;
	private JComboBox jComboBox_add_xingbie;
	private JTextField jTextField_add_gonghao = new JTextField(15);
	private JTextField jTextField_add_xingming = new JTextField(15);
	private JTextField jTextField_add_nainling = new JTextField(15);
	private MyDateJbutton jTextField_add_ruzhishijian = new MyDateJbutton();
	private JTextField jTextField_add_jiaqi = new JTextField(15);
	private JTextField jTextField_add_yuxin = new JTextField(15);
	private JTextField jTextField_add_mima = new JTextField(15);

	/**
	 * Ա��������Ϣ
	 */
	private JButton jButton_xiangqing_queding;
	private JButton jButton_xiangqing_quxiao;
	private  JTextField jComboBox_xiangqing_zhiwei= new JTextField(10);
	private  JTextField jComboBox_xiangqing_xingbie= new JTextField(10);
	private JTextField jTextField_xiangqing_gonghao = new JTextField(15);
	private JTextField jTextField_xiangqing_xingming = new JTextField(15);
	private JTextField jTextField_xiangqing_nainling = new JTextField(15);
	private MyDateJbutton jTextField_xiangqing_ruzhishijian = new MyDateJbutton();
	private JTextField jTextField_xiangqing_jiaqi = new JTextField(15);
	private JTextField jTextField_xiangqing_yuxin = new JTextField(15);
	private JTextField jTextField_xiangqing_mima = new JTextField(15);

	/**
	 * Ա����ɾ���ľ�����Ϣ�ľ�����Ϣ
	 */
	private JTextField jTextField_delete_gonghao = new JTextField(15);
	private JTextField jTextField_delete_xingming = new JTextField(15);
	private JTextField jTextField_delete_zhiwei = new JTextField(15);
	private JButton jButton_delete_delete;
	private JButton jButton_delete_quxiao;
	private String string_delete_xingming;
	private String string_delete_gonghao;
	private String string_delete_zhiwei;

	/**
	 * Ա������Ϣ�޸ĵ�һЩ����
	 */
	private JButton jButton_xiugai_queding;
	private JButton jButton_xiugai_quxiao;
	private JComboBox jComboBox_xiugai_zhiwei;
	private JComboBox jComboBox_xiugai_xingbie;
	private JTextField jTextField_xiugai_gonghao = new JTextField(15);
	private JTextField jTextField_xiugai_xingming = new JTextField(15);
	private JTextField jTextField_xiugai_nainling = new JTextField(15);
	private MyDateJbutton jTextField_xiugai_ruzhishijian = new MyDateJbutton();
	private JTextField jTextField_xiugai_jiaqi = new JTextField(15);
	private JTextField jTextField_xiugai_yuxin = new JTextField(15);
	private JTextField jTextField_xiugai_mima = new JTextField(15);

	/**
	 * Ա�����
	 */
	private JTable table;

	/**
	 * ��Ա�� tag���
	 */
	private int renyuantag = 0;
	/**
	 * ������Ϣ��
	 */
	private JTabbedPane jTabbedPane;

	private List<EmployeeInformation> listEmployees = new ArrayList<EmployeeInformation>();

	public AdministratorYuanGongGuanLi() {
		setTabPlacement(JTabbedPane.TOP);
		/**
		 * Ա����Ϣ���
		 */
		ImageIcon imageIcon_yuangongxinxi = new ImageIcon(
				Login.class.getResource("/com/today/images/yuangongxinxi.png"));
		imageIcon_yuangongxinxi.setImage(imageIcon_yuangongxinxi.getImage()
				.getScaledInstance(120, 40, Image.SCALE_DEFAULT));
		addTab("", imageIcon_yuangongxinxi, yuanGongXinXi());

		/**
		 * ҵ����Ϣ
		 */
		ImageIcon imageIcon_yewuxinxi = new ImageIcon(
				Login.class.getResource("/com/today/images/yewuxinxi.png"));
		imageIcon_yewuxinxi.setImage(imageIcon_yewuxinxi.getImage()
				.getScaledInstance(120, 40, Image.SCALE_DEFAULT));
		addTab("", imageIcon_yewuxinxi, yeWuXinXi());
	}

	/**
	 * Ա����Ϣ���
	 *
	 * @return
	 */
	private JTabbedPane yuanGongXinXi() {
		// TODO Auto-generated method stub
		jTabbedPane = new JTabbedPane();
		jTabbedPane.setBackground(new Color(1, 1, 0, 0.0f));
		jTabbedPane.setTabPlacement(JTabbedPane.RIGHT);
		/**
		 * ��Ϣ���
		 */
		ImageIcon imageIcon_xinxijianjie = new ImageIcon(
				Login.class
						.getResource("/com/today/images/gerenxinxixiugai.png"));
		imageIcon_xinxijianjie.setImage(imageIcon_xinxijianjie.getImage()
				.getScaledInstance(100, 30, Image.SCALE_DEFAULT));
		jTabbedPane.addTab("", imageIcon_xinxijianjie, yuanGongJianJie());
		// ���õ���¼�
		lieBiaoJianJieDianJiShiJian();

		/**
		 * Ա������
		 */
		ImageIcon imageIcon_yuangongzengjia = new ImageIcon(
				Login.class
						.getResource("/com/today/images/yuangongzengjia.png"));
		imageIcon_yuangongzengjia.setImage(imageIcon_yuangongzengjia.getImage()
				.getScaledInstance(100, 30, Image.SCALE_DEFAULT));
		jTabbedPane.addTab("", imageIcon_yuangongzengjia, yuanGongZengJia());
		addDianJi();

		/**
		 * Ա��ɾ��
		 */
		ImageIcon imageIcon_yuangongshanchu = new ImageIcon(
				Login.class
						.getResource("/com/today/images/yuangongshanchu.png"));
		imageIcon_yuangongshanchu.setImage(imageIcon_yuangongshanchu.getImage()
				.getScaledInstance(100, 30, Image.SCALE_DEFAULT));
		jTabbedPane.addTab("", imageIcon_yuangongshanchu, yuanGongShanChu());
		deleteDianJi();

		/**
		 * Ա���޸�
		 */
		ImageIcon imageIcon_yuangongxiugai = new ImageIcon(
				Login.class.getResource("/com/today/images/yuangongxiugai.png"));
		imageIcon_yuangongxiugai.setImage(imageIcon_yuangongxiugai.getImage()
				.getScaledInstance(100, 30, Image.SCALE_DEFAULT));
		jTabbedPane.addTab("", imageIcon_yuangongxiugai, yuanGongXiuGai());
		xiugaiDianJi();

		/**
		 * Ա������
		 */
		ImageIcon imageIcon_yuangongxiangqing = new ImageIcon(
				Login.class
						.getResource("/com/today/images/yuangongxiangqing.png"));
		imageIcon_yuangongxiangqing.setImage(imageIcon_yuangongxiangqing
				.getImage().getScaledInstance(100, 30, Image.SCALE_DEFAULT));
		jTabbedPane
				.addTab("", imageIcon_yuangongxiangqing, yuanGongxiangqing());
		xiangqingDianJi();

		return jTabbedPane;
	}

	/**
	 * ��Ϣ���
	 *
	 * @return
	 */
	private JPanel yuanGongJianJie() {
		// TODO Auto-generated method stub
		JPanel jPanel = new JPanel();
		jPanel.setOpaque(false);

		ImageIcon imageIcon_yuangongjianjie = new ImageIcon(
				Login.class
						.getResource("/com/today/images/gongzuorenyuanxinxi.png"));
		imageIcon_yuangongjianjie.setImage(imageIcon_yuangongjianjie.getImage()
				.getScaledInstance(700, 90, Image.SCALE_DEFAULT));
		Insets insets = new Insets(2, 2, 2, 2);
		GridBagLayout gridBagLayout = new GridBagLayout();
		jPanel.setLayout(gridBagLayout);
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.insets = insets;

		/**
		 * Ա����� ͼƬ
		 */
		JPanel jPanel_wei = new JPanel();
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.weightx = 200;
		gridBagConstraints.weighty = 10;
		jPanel_wei.setOpaque(false);
		jPanel_wei.setLayout(new FlowLayout());
		JLabel jLabel0 = new JLabel(imageIcon_yuangongjianjie);
		jPanel_wei.add(jLabel0);
		jPanel.add(jPanel_wei, gridBagConstraints);

		/**
		 * Ա�������б�
		 */
		JPanel jPanel_nei = yuanGongLieBiao();
		jPanel_nei.setOpaque(false);
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.weightx = 200;
		gridBagConstraints.weighty = 800;
		jPanel.add(jPanel_nei, gridBagConstraints);

		return jPanel;
	}

	/**
	 * today ��Ժ��Ա���� �� ��Ϣ�б� ���� һ������ʽչ�ֳ���
	 *
	 * @return
	 */
	private JPanel yuanGongLieBiao() {
		JPanel jPanel = new JPanel();
		jPanel.setOpaque(false);

		ImageIcon imageIcon_search = new ImageIcon(
				Login.class.getResource("/com/today/images/search.png"));
		imageIcon_search.setImage(imageIcon_search.getImage()
				.getScaledInstance(40, 40, Image.SCALE_DEFAULT));
		Insets insets = new Insets(2, 2, 2, 2);
		GridBagLayout gridBagLayout = new GridBagLayout();
		jPanel.setLayout(gridBagLayout);
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.insets = insets;
		/**
		 * ���ҵ� jpanel ���� idettext�� button
		 */
		JPanel jPanel_wei = new JPanel();
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.weightx = 200;
		gridBagConstraints.weighty = 10;
		jPanel_wei.setOpaque(false);
		jPanel_wei.setLayout(new FlowLayout());
		jTextField_search = new JTextField(20);
		jTextField_search.setOpaque(false);
		jTextField_search.setForeground(Color.red);
		jPanel_wei.add(jTextField_search);
		jButton_search = new JButton(imageIcon_search);
		jButton_search.setContentAreaFilled(false);
		jPanel_wei.add(jButton_search);
		/**
		 * ���ͼƬ
		 */
		ImageIcon imageIcon_shanchu = new ImageIcon(
				Login.class.getResource("/com/today/images/tianjia.png"));
		imageIcon_shanchu.setImage(imageIcon_shanchu.getImage()
				.getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		jButton_add = new JButton("���", imageIcon_shanchu);
		jButton_add.setContentAreaFilled(false);
		jPanel_wei.add(jButton_add);
		jPanel.add(jPanel_wei, gridBagConstraints);

		/**
		 * Ա�������б�
		 */
		JPanel jPanel_nei = new EmployeesInformation();
		jPanel_nei.setOpaque(false);
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.weightx = 200;
		gridBagConstraints.weighty = 800;
		jPanel.add(jPanel_nei, gridBagConstraints);

		return jPanel;
	}

	/**
	 * ��Ա�б�ļ���¼�
	 */
	private void lieBiaoJianJieDianJiShiJian() {
		/**
		 * ����button�� ����¼�����
		 */
		jButton_search.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String string_search = jTextField_search.getText();
				System.out.println(string_search);
				if (!string_search.equals("")) {
					data.removeAll(data);
					for (int i = 0; i < listEmployees.size(); i++) {

						if (listEmployees.get(i).getEmp_Name()
								.contains(string_search)) {
							Object[] objects = new Object[6];
							objects[3] = new JButton();
							objects[4] = new JButton();
							objects[5] = new JButton();
							objects[0] = listEmployees.get(i).getEmp_No();
							objects[1] = listEmployees.get(i).getEmp_Name();
							objects[2] = listEmployees.get(i).getEmp_Position();
							data.add(objects);

						}
					}
					if (data.size() != 0) {
						model.fireTableDataChanged();
					}
				} else {
					data.removeAll(data);
					YuanGongShuJuRuKou();
					model.fireTableDataChanged();

				}
			}
		});

		jButton_add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jTabbedPane.setSelectedIndex(1);
			}
		});

	}

	/**
	 * Ա��ɾ��
	 *
	 * @return
	 */
	private JPanel yuanGongShanChu() {
		// TODO Auto-generated method stub
		JPanel jPanel = new JPanel();
		jPanel.setOpaque(false);

		ImageIcon imageIcon_yuangongshanchu = new ImageIcon(
				Login.class.getResource("/com/today/images/renyuanshanchu.png"));
		imageIcon_yuangongshanchu.setImage(imageIcon_yuangongshanchu.getImage()
				.getScaledInstance(700, 70, Image.SCALE_DEFAULT));
		Insets insets = new Insets(2, 2, 2, 2);
		GridBagLayout gridBagLayout = new GridBagLayout();
		jPanel.setLayout(gridBagLayout);
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.insets = insets;
		/**
		 * Ա��ɾ�� ͼƬ
		 */
		JPanel jPanel_wei = new JPanel();
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.weightx = 200;
		gridBagConstraints.weighty = 10;
		jPanel_wei.setOpaque(false);
		jPanel_wei.setLayout(new FlowLayout());
		JLabel jLabel0 = new JLabel(imageIcon_yuangongshanchu);
		jPanel_wei.add(jLabel0);
		jPanel.add(jPanel_wei, gridBagConstraints);

		/**
		 * Ա��ɾ���� ���� �½���
		 */
		JPanel jPanel_nei = jPanel_Delete();
		jPanel_nei.setOpaque(false);
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.weightx = 200;
		gridBagConstraints.weighty = 800;
		jPanel.add(jPanel_nei, gridBagConstraints);

		return jPanel;
	}

	/**
	 * Ա����ɾ������ ���������һЩ��������
	 *
	 * @return
	 */
	private JPanel jPanel_Delete() {
		JPanel jPanel = new JPanel();
		jPanel.setLayout(new GridLayout(6, 1));

		/**
		 * ��jpanel ռλ����
		 */

		JPanel jPanel5 = new JPanel();
		jPanel5.setOpaque(false);
		jPanel.add(jPanel5);

		/**
		 * ����
		 */
		JPanel jPanel0 = new JPanel();
		jPanel0.setLayout(new FlowLayout());
		jPanel0.setOpaque(false);
		// ����ͼƬ
		ImageIcon imageIcon_gonghao = new ImageIcon(
				Login.class.getResource("/com/today/images/gonghao.png"));
		imageIcon_gonghao.setImage(imageIcon_gonghao.getImage()
				.getScaledInstance(100, 50, Image.SCALE_DEFAULT));
		JLabel jLabel_gonghaotu = new JLabel(imageIcon_gonghao, JLabel.RIGHT);
		jPanel0.add(jLabel_gonghaotu);
		jTextField_delete_gonghao.setEditable(false);
		jPanel0.add(jTextField_delete_gonghao);
		jPanel.add(jPanel0);

		/**
		 * ����
		 */
		JPanel jPanel1 = new JPanel();
		jPanel1.setLayout(new FlowLayout());
		jPanel1.setOpaque(false);
		// ����ͼƬ
		ImageIcon imageIcon_Xingming = new ImageIcon(
				Login.class.getResource("/com/today/images/xingming.png"));
		imageIcon_Xingming.setImage(imageIcon_Xingming.getImage()
				.getScaledInstance(80, 40, Image.SCALE_DEFAULT));
		JLabel jLabel_Xingmingtu = new JLabel(imageIcon_Xingming, JLabel.RIGHT);
		jPanel1.add(jLabel_Xingmingtu);
		jTextField_delete_xingming.setEditable(false);
		jPanel1.add(jTextField_delete_xingming);
		jPanel.add(jPanel1);

		/**
		 * ְλ
		 */
		JPanel jPanel2 = new JPanel();
		jPanel2.setLayout(new FlowLayout());
		jPanel2.setOpaque(false);
		// ְλͼƬ
		ImageIcon imageIcon_zhiwei = new ImageIcon(
				Login.class.getResource("/com/today/images/zhiwei.png"));
		imageIcon_zhiwei.setImage(imageIcon_zhiwei.getImage()
				.getScaledInstance(80, 40, Image.SCALE_DEFAULT));
		JLabel jLabel_zhiwei = new JLabel(imageIcon_zhiwei, JLabel.RIGHT);
		jPanel2.add(jLabel_zhiwei);
		jTextField_delete_zhiwei.setEditable(false);
		jPanel2.add(jTextField_delete_zhiwei);
		jPanel.add(jPanel2);

		/**
		 * ɾ�� �����ӵ�button
		 */
		JPanel jPanel3 = new JPanel();
		jPanel3.setLayout(new FlowLayout());
		jPanel3.setOpaque(false);
		/**
		 * ȷ����ť
		 */
		JPanel jPanel40 = new JPanel();
		jPanel40.setOpaque(false);
		jPanel40.setLayout(new FlowLayout(FlowLayout.RIGHT));
		ImageIcon imageIcon_button = new ImageIcon(
				Login.class.getResource("/com/today/images/button.png"));
		imageIcon_button.setImage(imageIcon_button.getImage()
				.getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		jButton_delete_delete = new JButton("ɾ��", imageIcon_button);
		jButton_delete_delete.setContentAreaFilled(false);
		jButton_delete_delete.setForeground(Color.black);
		jPanel40.add(jButton_delete_delete);
		jPanel3.add(jPanel40);

		/**
		 * ȡ����ť
		 */
		JPanel jPanel41 = new JPanel();
		jPanel41.setOpaque(false);
		jPanel41.setLayout(new FlowLayout(FlowLayout.LEFT));
		jButton_delete_quxiao = new JButton("ȡ��", imageIcon_button);
		jButton_delete_quxiao.setContentAreaFilled(false);
		jButton_delete_quxiao.setForeground(Color.black);
		jPanel41.add(jButton_delete_quxiao);
		jPanel3.add(jPanel41);
		jPanel.add(jPanel3);

		return jPanel;
	}

	/**
	 * dɾ���ĵ���¼�����
	 */
	private void deleteDianJi() {
		// ȡ��������
		jButton_delete_quxiao.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				jTabbedPane.setSelectedIndex(0);
			}
		});
		// ɾ���ĵ���¼�
		jButton_delete_delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Employee employee = new Employee();
				if (employee.DeleteEmployee(string_delete_gonghao)) {
					JOptionPane.showMessageDialog(
							Administrator.jFrame_GuanLi.getContentPane(),
							"ɾ���ɹ�����������!", "todayɾ��ϵͳ��Ϣ",
							JOptionPane.WARNING_MESSAGE);
					jTabbedPane.setSelectedIndex(0);
				} else {
					JOptionPane.showMessageDialog(
							Administrator.jFrame_GuanLi.getContentPane(),
							"ɾ��ʧ�ܣ���Ա����ɾ��!", "todayɾ��ϵͳ��Ϣ",
							JOptionPane.WARNING_MESSAGE);
					jTabbedPane.setSelectedIndex(0);
				}
			}
		});
	}

	/**
	 * Ա������
	 *
	 * @return
	 */
	private JPanel yuanGongZengJia() {
		// TODO Auto-generated method stub
		JPanel jPanel = new JPanel();
		jPanel.setOpaque(false);

		ImageIcon imageIcon_yuangongzengjia = new ImageIcon(
				Login.class.getResource("/com/today/images/renyuanzengjia.png"));
		imageIcon_yuangongzengjia.setImage(imageIcon_yuangongzengjia.getImage()
				.getScaledInstance(700, 70, Image.SCALE_DEFAULT));
		Insets insets = new Insets(2, 2, 2, 2);
		GridBagLayout gridBagLayout = new GridBagLayout();
		jPanel.setLayout(gridBagLayout);
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.insets = insets;
		/**
		 * Ա�����ӵ�ͼƬ
		 */
		JPanel jPanel_wei = new JPanel();
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.weightx = 200;
		gridBagConstraints.weighty = 10;
		jPanel_wei.setOpaque(false);
		jPanel_wei.setLayout(new FlowLayout());
		JLabel jLabel0 = new JLabel(imageIcon_yuangongzengjia);
		jPanel_wei.add(jLabel0);
		jPanel.add(jPanel_wei, gridBagConstraints);
		/**
		 * Ԫ�����ӵ� �²�������
		 */
		JPanel jPanel_nei = jPanel_ZengJia();
		jPanel_nei.setOpaque(false);
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.weightx = 200;
		gridBagConstraints.weighty = 800;
		jPanel.add(jPanel_nei, gridBagConstraints);

		return jPanel;
	}

	/**
	 * Ա������ ��jpnel
	 *
	 * @return
	 */
	private JPanel jPanel_ZengJia() {
		JPanel jPanel = new JPanel();
		jPanel.setLayout(new GridLayout(5, 1));
		/**
		 * ��һ��
		 */
		JPanel jPanel0 = new JPanel();
		jPanel0.setOpaque(false);
		jPanel0.setLayout(new GridLayout(1, 3));
		/**
		 * ����
		 */
		JPanel jPanel00 = new JPanel();
		jPanel00.setOpaque(false);
		jPanel00.setLayout(new FlowLayout());
		// ����ͼƬ
		ImageIcon imageIcon_gonghao = new ImageIcon(
				Login.class.getResource("/com/today/images/gonghao.png"));
		imageIcon_gonghao.setImage(imageIcon_gonghao.getImage()
				.getScaledInstance(100, 50, Image.SCALE_DEFAULT));
		JLabel jLabel_gonghaotu = new JLabel(imageIcon_gonghao, JLabel.RIGHT);
		jPanel00.add(jLabel_gonghaotu);
		jTextField_add_gonghao.setEditable(false);
		jPanel00.add(jTextField_add_gonghao);
		jPanel0.add(jPanel00);

		/**
		 * ����
		 */
		JPanel jPanel01 = new JPanel();
		jPanel01.setOpaque(false);
		jPanel01.setLayout(new FlowLayout());
		// ����ͼƬ
		// ����ͼƬ
		ImageIcon imageIcon_Xingming = new ImageIcon(
				Login.class.getResource("/com/today/images/xingming.png"));
		imageIcon_Xingming.setImage(imageIcon_Xingming.getImage()
				.getScaledInstance(80, 40, Image.SCALE_DEFAULT));
		JLabel jLabel_Xingmingtu = new JLabel(imageIcon_Xingming, JLabel.RIGHT);
		jPanel01.add(jLabel_Xingmingtu);
		jPanel01.add(jTextField_add_xingming);
		jPanel0.add(jPanel01);

		/**
		 * �Ա�
		 */
		JPanel jPanel02 = new JPanel();
		jPanel02.setOpaque(false);
		jPanel02.setLayout(new FlowLayout());
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
		jPanel02.add(jLabel_xingbie);
		jComboBox_add_xingbie = new JComboBox();
		jComboBox_add_xingbie.setMaximumRowCount(2);
		// ���� ���õ�Ԫ��
		jComboBox_add_xingbie.setRenderer(new JComboBox_Item());
		jComboBox_add_xingbie.setBackground(Color.black);
		jComboBox_add_xingbie.setSize(60, 40);
		jComboBox_add_xingbie.addItem(new Object[] { imageIcon_nan, "��",
				"�����Ա���" });
		jComboBox_add_xingbie
				.addItem(new Object[] { imageIcon_nv, "Ů", "�����Ա�Ů" });
		jPanel02.add(jComboBox_add_xingbie);
		jPanel0.add(jPanel02);

		jPanel.add(jPanel0);

		/**
		 * �ڶ���
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
		// ������ͼƬ
		ImageIcon imageIcon_jiumima = new ImageIcon(
				Login.class.getResource("/com/today/images/mima.png"));
		imageIcon_jiumima.setImage(imageIcon_jiumima.getImage()
				.getScaledInstance(80, 40, Image.SCALE_DEFAULT));
		JLabel jLabel_jiumimatu = new JLabel(imageIcon_jiumima, JLabel.RIGHT);
		jPanel10.add(jLabel_jiumimatu);
		jPanel10.add(jTextField_add_mima);
		jPanel1.add(jPanel10);

		/**
		 * ����
		 */
		JPanel jPanel11 = new JPanel();
		jPanel11.setOpaque(false);
		jPanel11.setLayout(new FlowLayout());
		// ����ͼƬ
		ImageIcon imageIcon_Nianling = new ImageIcon(
				Login.class.getResource("/com/today/images/nianling.png"));
		imageIcon_Nianling.setImage(imageIcon_Nianling.getImage()
				.getScaledInstance(80, 40, Image.SCALE_DEFAULT));
		JLabel jLabel_Nianlingtu = new JLabel(imageIcon_Nianling, JLabel.RIGHT);
		jPanel11.add(jLabel_Nianlingtu);
		jPanel11.add(jTextField_add_nainling);
		jPanel1.add(jPanel11);

		/**
		 * ְλ
		 */
		JPanel jPanel12 = new JPanel();
		jPanel12.setOpaque(false);
		jPanel12.setLayout(new FlowLayout());
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
		jPanel12.add(jLabel_zhiwei);
		jComboBox_add_zhiwei = new JComboBox();
		jComboBox_add_zhiwei.setMaximumRowCount(2);
		// ���� ���õ�Ԫ��
		jComboBox_add_zhiwei.setRenderer(new JComboBox_Item());
		jComboBox_add_zhiwei.setBackground(Color.black);
		jComboBox_add_zhiwei.setSize(60, 40);
		jComboBox_add_zhiwei.addItem(new Object[] { imageIcon_guanli, "����",
				"today��Ժϵͳ����Ա" });
		jComboBox_add_zhiwei.addItem(new Object[] { imageIcon_shoupiao, "��ƱԱ",
				"today��Ժ��ƱԱ" });
		jPanel12.add(jComboBox_add_zhiwei);
		jPanel1.add(jPanel12);

		jPanel.add(jPanel1);

		/**
		 * ������
		 */
		JPanel jPanel2 = new JPanel();
		jPanel2.setOpaque(false);
		jPanel2.setLayout(new GridLayout(1, 2));

		/**
		 * ��н
		 */
		JPanel jPanel20 = new JPanel();
		jPanel20.setOpaque(false);
		jPanel20.setLayout(new FlowLayout());
		// ��нͼƬ
		ImageIcon imageIcon_yuexin = new ImageIcon(
				Login.class.getResource("/com/today/images/yuexin.png"));
		imageIcon_yuexin.setImage(imageIcon_yuexin.getImage()
				.getScaledInstance(80, 40, Image.SCALE_DEFAULT));
		JLabel jLabel_yuexintu = new JLabel(imageIcon_yuexin, JLabel.RIGHT);
		jPanel20.add(jLabel_yuexintu);
		jPanel20.add(jTextField_add_yuxin);
		jPanel2.add(jPanel20);

		/**
		 * ��ٰ�����
		 */
		JPanel jPanel21 = new JPanel();
		jPanel21.setOpaque(false);
		jPanel21.setLayout(new FlowLayout());
		// �������ͼƬ
		ImageIcon imageIcon_qingjia = new ImageIcon(
				Login.class.getResource("/com/today/images/qingjiatianshu.png"));
		imageIcon_qingjia.setImage(imageIcon_qingjia.getImage()
				.getScaledInstance(160, 40, Image.SCALE_DEFAULT));
		JLabel jLabel_qingjiatu = new JLabel(imageIcon_qingjia, JLabel.RIGHT);
		jPanel21.add(jLabel_qingjiatu);
		jPanel21.add(jTextField_add_jiaqi);
		jPanel2.add(jPanel21);

		jPanel.add(jPanel2);

		/**
		 * ������
		 */
		JPanel jPanel3 = new JPanel();
		jPanel3.setOpaque(false);
		jPanel3.setLayout(new FlowLayout());
		/**
		 * ��ְʱ��
		 */
		// ��ְʱ��ͼƬ
		ImageIcon imageIcon_shijian = new ImageIcon(
				Login.class.getResource("/com/today/images/ruzhishijian.png"));
		imageIcon_shijian.setImage(imageIcon_shijian.getImage()
				.getScaledInstance(160, 40, Image.SCALE_DEFAULT));
		JLabel jLabel_shijiantu = new JLabel(imageIcon_shijian, JLabel.RIGHT);
		jPanel3.add(jLabel_shijiantu);
		jTextField_add_ruzhishijian.setContentAreaFilled(false);
		jTextField_add_ruzhishijian.setFont(new java.awt.Font("Dialog", 1, 24));
		jTextField_add_ruzhishijian.setForeground(Color.black);
		jPanel3.add(jTextField_add_ruzhishijian);

		jPanel.add(jPanel3);

		/**
		 * ������
		 */
		JPanel jPanel4 = new JPanel();
		jPanel4.setOpaque(false);
		jPanel4.setLayout(new GridLayout(1, 2));

		/**
		 * ȷ����ť
		 */
		JPanel jPanel40 = new JPanel();
		jPanel40.setOpaque(false);
		jPanel40.setLayout(new FlowLayout(FlowLayout.RIGHT));
		ImageIcon imageIcon_button = new ImageIcon(
				Login.class.getResource("/com/today/images/button.png"));
		imageIcon_button.setImage(imageIcon_button.getImage()
				.getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		jButton_add_queding = new JButton("���", imageIcon_button);
		jButton_add_queding.setContentAreaFilled(false);
		jButton_add_queding.setForeground(Color.black);
		jPanel40.add(jButton_add_queding);
		jPanel4.add(jPanel40);

		/**
		 * ȡ����ť
		 */
		JPanel jPanel41 = new JPanel();
		jPanel41.setOpaque(false);
		jPanel41.setLayout(new FlowLayout(FlowLayout.LEFT));
		jButton_add_quxiao = new JButton("ȡ��", imageIcon_button);
		jButton_add_quxiao.setContentAreaFilled(false);
		jButton_add_quxiao.setForeground(Color.black);
		jPanel41.add(jButton_add_quxiao);
		jPanel4.add(jPanel41);

		jPanel.add(jPanel4);

		return jPanel;
	}

	/**
	 * ��ӵĵ���¼�
	 */
	private void addDianJi() {
		/**
		 * ȡ��
		 */
		jButton_add_quxiao.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				jTabbedPane.setSelectedIndex(0);
			}
		});

		jButton_add_queding.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String name = jTextField_add_xingming.getText();
				String xingbie = "";
				String zhiwei = "";
				String mima = jTextField_add_mima.getText();
				String nianling = jTextField_add_nainling.getText();
				String yuexin = jTextField_add_yuxin.getText();
				String ruzhishijjian = jTextField_add_ruzhishijian.getText();
				String jiaqi = jTextField_add_jiaqi.getText();
				int a = jComboBox_add_zhiwei.getSelectedIndex();
				if (a == 0) {
					zhiwei = "����";
				} else {
					zhiwei = "��ƱԱ";
				}
				int b = jComboBox_add_xingbie.getSelectedIndex();
				if (b == 0) {
					xingbie = "��";
				} else {
					xingbie = "Ů";
				}
				if (name.equals("")) {
					JOptionPane.showMessageDialog(
							Administrator.jFrame_GuanLi.getContentPane(),
							"��������Ϊ��!", "today����ϵͳ��Ϣ",
							JOptionPane.WARNING_MESSAGE);
				} else if (mima.equals("")) {
					JOptionPane.showMessageDialog(
							Administrator.jFrame_GuanLi.getContentPane(),
							"���ܲ���Ϊ��!", "today����ϵͳ��Ϣ",
							JOptionPane.WARNING_MESSAGE);
				} else {
					Employee employee = new Employee();
					String gong = employee.employeeAdd(name, mima, zhiwei,
							xingbie, nianling, yuexin, jiaqi, ruzhishijjian);
					JOptionPane.showMessageDialog(
							Administrator.jFrame_GuanLi.getContentPane(),
							"��ӳɹ�\n" + "�˺��ǣ�\n\t" + gong
									+ "\n���μǣ�������ʧ����ϵ���ܣ�18240800871",
							"today��Ա���ϵͳ��Ϣ", JOptionPane.WARNING_MESSAGE);
					jTextField_add_gonghao.setText(gong);
				}

			}
		});

	}

	/**
	 * Ա���޸�
	 *
	 * @return
	 */
	private JPanel yuanGongXiuGai() {
		// TODO Auto-generated method stub
		JPanel jPanel = new JPanel();
		jPanel.setOpaque(false);

		ImageIcon imageIcon_renyuanxiugai = new ImageIcon(
				Login.class.getResource("/com/today/images/renyuanxiugai.png"));
		imageIcon_renyuanxiugai.setImage(imageIcon_renyuanxiugai.getImage()
				.getScaledInstance(700, 70, Image.SCALE_DEFAULT));
		Insets insets = new Insets(2, 2, 2, 2);
		GridBagLayout gridBagLayout = new GridBagLayout();
		jPanel.setLayout(gridBagLayout);
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.insets = insets;
		/**
		 * Ա���޸ĵ�ͼƬ
		 */
		JPanel jPanel_wei = new JPanel();
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.weightx = 200;
		gridBagConstraints.weighty = 10;
		jPanel_wei.setOpaque(false);
		jPanel_wei.setLayout(new FlowLayout());
		JLabel jLabel0 = new JLabel(imageIcon_renyuanxiugai);
		jPanel_wei.add(jLabel0);
		jPanel.add(jPanel_wei, gridBagConstraints);
		/**
		 * Ա���޸ĵ��²�������
		 */
		JPanel jPanel_nei = jPanel_Xiugai();
		jPanel_nei.setOpaque(false);
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.weightx = 200;
		gridBagConstraints.weighty = 800;
		jPanel.add(jPanel_nei, gridBagConstraints);

		return jPanel;
	}

	/**
	 * Ա�����޸� �������
	 *
	 * @return
	 */
	/**
	 * Ա������ ��jpnel
	 *
	 * @return
	 */
	private JPanel jPanel_Xiugai() {
		JPanel jPanel = new JPanel();
		jPanel.setLayout(new GridLayout(5, 1));
		/**
		 * ��һ��
		 */
		JPanel jPanel0 = new JPanel();
		jPanel0.setOpaque(false);
		jPanel0.setLayout(new GridLayout(1, 3));
		/**
		 * ����
		 */
		JPanel jPanel00 = new JPanel();
		jPanel00.setOpaque(false);
		jPanel00.setLayout(new FlowLayout());
		// ����ͼƬ
		ImageIcon imageIcon_gonghao = new ImageIcon(
				Login.class.getResource("/com/today/images/gonghao.png"));
		imageIcon_gonghao.setImage(imageIcon_gonghao.getImage()
				.getScaledInstance(100, 50, Image.SCALE_DEFAULT));
		JLabel jLabel_gonghaotu = new JLabel(imageIcon_gonghao, JLabel.RIGHT);
		jPanel00.add(jLabel_gonghaotu);
		jTextField_xiugai_gonghao.setEditable(false);
		jPanel00.add(jTextField_xiugai_gonghao);
		jPanel0.add(jPanel00);

		/**
		 * ����
		 */
		JPanel jPanel01 = new JPanel();
		jPanel01.setOpaque(false);
		jPanel01.setLayout(new FlowLayout());
		// ����ͼƬ
		// ����ͼƬ
		ImageIcon imageIcon_Xingming = new ImageIcon(
				Login.class.getResource("/com/today/images/xingming.png"));
		imageIcon_Xingming.setImage(imageIcon_Xingming.getImage()
				.getScaledInstance(80, 40, Image.SCALE_DEFAULT));
		JLabel jLabel_Xingmingtu = new JLabel(imageIcon_Xingming, JLabel.RIGHT);
		jPanel01.add(jLabel_Xingmingtu);
		jPanel01.add(jTextField_xiugai_xingming);
		jPanel0.add(jPanel01);

		/**
		 * �Ա�
		 */
		JPanel jPanel02 = new JPanel();
		jPanel02.setOpaque(false);
		jPanel02.setLayout(new FlowLayout());
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
		jPanel02.add(jLabel_xingbie);
		jComboBox_xiugai_xingbie = new JComboBox();
		jComboBox_xiugai_xingbie.setMaximumRowCount(2);
		// ���� ���õ�Ԫ��
		jComboBox_xiugai_xingbie.setRenderer(new JComboBox_Item());
		jComboBox_xiugai_xingbie.setBackground(Color.black);
		jComboBox_xiugai_xingbie.setSize(60, 40);
		jComboBox_xiugai_xingbie.addItem(new Object[] { imageIcon_nan, "��",
				"�����Ա���" });
		jComboBox_xiugai_xingbie.addItem(new Object[] { imageIcon_nv, "Ů",
				"�����Ա�Ů" });
		jPanel02.add(jComboBox_xiugai_xingbie);
		jPanel0.add(jPanel02);

		jPanel.add(jPanel0);

		/**
		 * �ڶ���
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
		// ������ͼƬ
		ImageIcon imageIcon_jiumima = new ImageIcon(
				Login.class.getResource("/com/today/images/mima.png"));
		imageIcon_jiumima.setImage(imageIcon_jiumima.getImage()
				.getScaledInstance(80, 40, Image.SCALE_DEFAULT));
		JLabel jLabel_jiumimatu = new JLabel(imageIcon_jiumima, JLabel.RIGHT);
		jPanel10.add(jLabel_jiumimatu);
		jPanel10.add(jTextField_xiugai_mima);
		jPanel1.add(jPanel10);

		/**
		 * ����
		 */
		JPanel jPanel11 = new JPanel();
		jPanel11.setOpaque(false);
		jPanel11.setLayout(new FlowLayout());
		// ����ͼƬ
		ImageIcon imageIcon_Nianling = new ImageIcon(
				Login.class.getResource("/com/today/images/nianling.png"));
		imageIcon_Nianling.setImage(imageIcon_Nianling.getImage()
				.getScaledInstance(80, 40, Image.SCALE_DEFAULT));
		JLabel jLabel_Nianlingtu = new JLabel(imageIcon_Nianling, JLabel.RIGHT);
		jPanel11.add(jLabel_Nianlingtu);
		jPanel11.add(jTextField_xiugai_nainling);
		jPanel1.add(jPanel11);

		/**
		 * ְλ
		 */
		JPanel jPanel12 = new JPanel();
		jPanel12.setOpaque(false);
		jPanel12.setLayout(new FlowLayout());
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
		jPanel12.add(jLabel_zhiwei);
		jComboBox_xiugai_zhiwei = new JComboBox();
		jComboBox_xiugai_zhiwei.setMaximumRowCount(2);
		// ���� ���õ�Ԫ��
		jComboBox_xiugai_zhiwei.setRenderer(new JComboBox_Item());
		jComboBox_xiugai_zhiwei.setBackground(Color.black);
		jComboBox_xiugai_zhiwei.setSize(60, 40);
		jComboBox_xiugai_zhiwei.addItem(new Object[] { imageIcon_guanli, "����",
				"today��Ժϵͳ����Ա" });
		jComboBox_xiugai_zhiwei.addItem(new Object[] { imageIcon_shoupiao,
				"��ƱԱ", "today��Ժ��ƱԱ" });
		jPanel12.add(jComboBox_xiugai_zhiwei);
		jPanel1.add(jPanel12);

		jPanel.add(jPanel1);

		/**
		 * ������
		 */
		JPanel jPanel2 = new JPanel();
		jPanel2.setOpaque(false);
		jPanel2.setLayout(new GridLayout(1, 2));

		/**
		 * ��н
		 */
		JPanel jPanel20 = new JPanel();
		jPanel20.setOpaque(false);
		jPanel20.setLayout(new FlowLayout());
		// ��нͼƬ
		ImageIcon imageIcon_yuexin = new ImageIcon(
				Login.class.getResource("/com/today/images/yuexin.png"));
		imageIcon_yuexin.setImage(imageIcon_yuexin.getImage()
				.getScaledInstance(80, 40, Image.SCALE_DEFAULT));
		JLabel jLabel_yuexintu = new JLabel(imageIcon_yuexin, JLabel.RIGHT);
		jPanel20.add(jLabel_yuexintu);
		jPanel20.add(jTextField_xiugai_yuxin);
		jPanel2.add(jPanel20);

		/**
		 * ��ٰ�����
		 */
		JPanel jPanel21 = new JPanel();
		jPanel21.setOpaque(false);
		jPanel21.setLayout(new FlowLayout());
		// �������ͼƬ
		ImageIcon imageIcon_qingjia = new ImageIcon(
				Login.class.getResource("/com/today/images/qingjiatianshu.png"));
		imageIcon_qingjia.setImage(imageIcon_qingjia.getImage()
				.getScaledInstance(160, 40, Image.SCALE_DEFAULT));
		JLabel jLabel_qingjiatu = new JLabel(imageIcon_qingjia, JLabel.RIGHT);
		jPanel21.add(jLabel_qingjiatu);
		jPanel21.add(jTextField_xiugai_jiaqi);
		jPanel2.add(jPanel21);

		jPanel.add(jPanel2);

		/**
		 * ������
		 */
		JPanel jPanel3 = new JPanel();
		jPanel3.setOpaque(false);
		jPanel3.setLayout(new FlowLayout());
		/**
		 * ��ְʱ��
		 */
		// ��ְʱ��ͼƬ
		ImageIcon imageIcon_shijian = new ImageIcon(
				Login.class.getResource("/com/today/images/ruzhishijian.png"));
		imageIcon_shijian.setImage(imageIcon_shijian.getImage()
				.getScaledInstance(160, 40, Image.SCALE_DEFAULT));
		JLabel jLabel_shijiantu = new JLabel(imageIcon_shijian, JLabel.RIGHT);
		jPanel3.add(jLabel_shijiantu);
		jTextField_xiugai_ruzhishijian.setContentAreaFilled(false);
		jTextField_xiugai_ruzhishijian.setFont(new java.awt.Font("Dialog", 1,
				24));
		jTextField_xiugai_ruzhishijian.setForeground(Color.black);
		jPanel3.add(jTextField_xiugai_ruzhishijian);

		jPanel.add(jPanel3);

		/**
		 * ������
		 */
		JPanel jPanel4 = new JPanel();
		jPanel4.setOpaque(false);
		jPanel4.setLayout(new GridLayout(1, 2));

		/**
		 * ȷ����ť
		 */
		JPanel jPanel40 = new JPanel();
		jPanel40.setOpaque(false);
		jPanel40.setLayout(new FlowLayout(FlowLayout.RIGHT));
		ImageIcon imageIcon_button = new ImageIcon(
				Login.class.getResource("/com/today/images/button.png"));
		imageIcon_button.setImage(imageIcon_button.getImage()
				.getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		jButton_xiugai_queding = new JButton("�޸�", imageIcon_button);
		jButton_xiugai_queding.setContentAreaFilled(false);
		jButton_xiugai_queding.setForeground(Color.black);
		jPanel40.add(jButton_xiugai_queding);
		jPanel4.add(jPanel40);

		/**
		 * ȡ����ť
		 */
		JPanel jPanel41 = new JPanel();
		jPanel41.setOpaque(false);
		jPanel41.setLayout(new FlowLayout(FlowLayout.LEFT));
		jButton_xiugai_quxiao = new JButton("ȡ��", imageIcon_button);
		jButton_xiugai_quxiao.setContentAreaFilled(false);
		jButton_xiugai_quxiao.setForeground(Color.black);
		jPanel41.add(jButton_xiugai_quxiao);
		jPanel4.add(jPanel41);

		jPanel.add(jPanel4);

		return jPanel;
	}

	/**
	 * ��ӵĵ���¼�
	 */
	private void xiugaiDianJi() {
		/**
		 * ȡ��
		 */
		jButton_xiugai_quxiao.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				jTabbedPane.setSelectedIndex(0);
			}
		});

		jButton_xiugai_queding.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String name = jTextField_xiugai_xingming.getText();
				String xingbie = "";
				String zhiwei = "";
				String mima = jTextField_xiugai_mima.getText();
				String nianling = jTextField_xiugai_nainling.getText();
				String yuexin = jTextField_xiugai_yuxin.getText();
				String ruzhishijjian = jTextField_xiugai_ruzhishijian.getText();
				String jiaqi = jTextField_xiugai_jiaqi.getText();
				String id = jTextField_xiugai_gonghao.getText();
				int a = jComboBox_xiugai_zhiwei.getSelectedIndex();
				if (a == 0) {
					zhiwei = "����";
				} else {
					zhiwei = "��ƱԱ";
				}
				int b = jComboBox_xiugai_xingbie.getSelectedIndex();
				if (b == 0) {
					xingbie = "��";
				} else {
					xingbie = "Ů";
				}
				if (name.equals("")) {
					JOptionPane.showMessageDialog(
							Administrator.jFrame_GuanLi.getContentPane(),
							"��������Ϊ��!", "today�޸�ϵͳ��Ϣ",
							JOptionPane.WARNING_MESSAGE);
				} else if (mima.equals("")) {
					JOptionPane.showMessageDialog(
							Administrator.jFrame_GuanLi.getContentPane(),
							"���ܲ���Ϊ��!", "today�޸�ϵͳ��Ϣ",
							JOptionPane.WARNING_MESSAGE);
				} else {
					Employee employee = new Employee();
					if (employee.yuanGongXinXiXiuGai(name, nianling,
							ruzhishijjian, jiaqi, yuexin, xingbie, zhiwei,
							mima, id)) {
						JOptionPane.showMessageDialog(
								Administrator.jFrame_GuanLi.getContentPane(),
								"�޸ĳɹ�!", "today�޸�ϵͳ��Ϣ",
								JOptionPane.WARNING_MESSAGE);
						jTabbedPane.setSelectedIndex(0);
					} else {
						JOptionPane.showMessageDialog(
								Administrator.jFrame_GuanLi.getContentPane(),
								"�޸�ʧ��!", "today�޸�ϵͳ��Ϣ",
								JOptionPane.ERROR_MESSAGE);
					}

				}

			}
		});

	}

	/**
	 * Ա���޸�
	 *
	 * @return
	 */
	private JPanel yuanGongxiangqing() {
		// TODO Auto-generated method stub
		JPanel jPanel = new JPanel();
		jPanel.setOpaque(false);

		ImageIcon imageIcon_renyuanxiugai = new ImageIcon(
				Login.class
						.getResource("/com/today/images/yuangongxiangqing.png"));
		imageIcon_renyuanxiugai.setImage(imageIcon_renyuanxiugai.getImage()
				.getScaledInstance(300, 70, Image.SCALE_DEFAULT));
		Insets insets = new Insets(2, 2, 2, 2);
		GridBagLayout gridBagLayout = new GridBagLayout();
		jPanel.setLayout(gridBagLayout);
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.insets = insets;
		/**
		 * Ա���޸ĵ�ͼƬ
		 */
		JPanel jPanel_wei = new JPanel();
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.weightx = 200;
		gridBagConstraints.weighty = 10;
		jPanel_wei.setOpaque(false);
		jPanel_wei.setLayout(new FlowLayout());
		JLabel jLabel0 = new JLabel(imageIcon_renyuanxiugai);
		jPanel_wei.add(jLabel0);
		jPanel.add(jPanel_wei, gridBagConstraints);
		/**
		 * Ա���޸ĵ��²�������
		 */
		JPanel jPanel_nei = jPanel_xiangqing();
		jPanel_nei.setOpaque(false);
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.weightx = 200;
		gridBagConstraints.weighty = 800;
		jPanel.add(jPanel_nei, gridBagConstraints);

		return jPanel;
	}

	/**
	 * Ա�����޸� �������
	 *
	 * @return
	 */
	/**
	 * Ա������ ��jpnel
	 *
	 * @return
	 */
	private JPanel jPanel_xiangqing() {
		JPanel jPanel = new JPanel();
		jPanel.setLayout(new GridLayout(5, 1));
		/**
		 * ��һ��
		 */
		JPanel jPanel0 = new JPanel();
		jPanel0.setOpaque(false);
		jPanel0.setLayout(new GridLayout(1, 3));
		/**
		 * ����
		 */
		jTextField_xiangqing_gonghao.setEditable(false);
		jTextField_xiangqing_jiaqi.setEditable(false);
		jTextField_xiangqing_mima.setEditable(false);
		jTextField_xiangqing_nainling.setEditable(false);
		jTextField_xiangqing_ruzhishijian.setEnabled(false);
		jTextField_xiangqing_xingming.setEditable(false);
		jTextField_xiangqing_yuxin.setEditable(false);

		JPanel jPanel00 = new JPanel();
		jPanel00.setOpaque(false);
		jPanel00.setLayout(new FlowLayout());
		// ����ͼƬ
		ImageIcon imageIcon_gonghao = new ImageIcon(
				Login.class.getResource("/com/today/images/gonghao.png"));
		imageIcon_gonghao.setImage(imageIcon_gonghao.getImage()
				.getScaledInstance(100, 50, Image.SCALE_DEFAULT));
		JLabel jLabel_gonghaotu = new JLabel(imageIcon_gonghao, JLabel.RIGHT);
		jPanel00.add(jLabel_gonghaotu);
		jTextField_xiangqing_gonghao.setEditable(false);
		jPanel00.add(jTextField_xiangqing_gonghao);
		jPanel0.add(jPanel00);

		/**
		 * ����
		 */
		JPanel jPanel01 = new JPanel();
		jPanel01.setOpaque(false);
		jPanel01.setLayout(new FlowLayout());
		// ����ͼƬ
		// ����ͼƬ
		ImageIcon imageIcon_Xingming = new ImageIcon(
				Login.class.getResource("/com/today/images/xingming.png"));
		imageIcon_Xingming.setImage(imageIcon_Xingming.getImage()
				.getScaledInstance(80, 40, Image.SCALE_DEFAULT));
		JLabel jLabel_Xingmingtu = new JLabel(imageIcon_Xingming, JLabel.RIGHT);
		jPanel01.add(jLabel_Xingmingtu);
		jPanel01.add(jTextField_xiangqing_xingming);
		jPanel0.add(jPanel01);

		/**
		 * �Ա�
		 */
		JPanel jPanel02 = new JPanel();
		jPanel02.setOpaque(false);
		jPanel02.setLayout(new FlowLayout());
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
		jPanel02.add(jLabel_xingbie);
		jPanel02.add(jComboBox_xiangqing_xingbie);
		jPanel0.add(jPanel02);

		jPanel.add(jPanel0);

		/**
		 * �ڶ���
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
		// ������ͼƬ
		ImageIcon imageIcon_jiumima = new ImageIcon(
				Login.class.getResource("/com/today/images/mima.png"));
		imageIcon_jiumima.setImage(imageIcon_jiumima.getImage()
				.getScaledInstance(80, 40, Image.SCALE_DEFAULT));
		JLabel jLabel_jiumimatu = new JLabel(imageIcon_jiumima, JLabel.RIGHT);
		jPanel10.add(jLabel_jiumimatu);
		jPanel10.add(jTextField_xiangqing_mima);
		jPanel1.add(jPanel10);

		/**
		 * ����
		 */
		JPanel jPanel11 = new JPanel();
		jPanel11.setOpaque(false);
		jPanel11.setLayout(new FlowLayout());
		// ����ͼƬ
		ImageIcon imageIcon_Nianling = new ImageIcon(
				Login.class.getResource("/com/today/images/nianling.png"));
		imageIcon_Nianling.setImage(imageIcon_Nianling.getImage()
				.getScaledInstance(80, 40, Image.SCALE_DEFAULT));
		JLabel jLabel_Nianlingtu = new JLabel(imageIcon_Nianling, JLabel.RIGHT);
		jPanel11.add(jLabel_Nianlingtu);
		jPanel11.add(jTextField_xiangqing_nainling);
		jPanel1.add(jPanel11);

		/**
		 * ְλ
		 */
		JPanel jPanel12 = new JPanel();
		jPanel12.setOpaque(false);
		jPanel12.setLayout(new FlowLayout());
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
		jPanel12.add(jLabel_zhiwei);
		jPanel12.add(jComboBox_xiangqing_zhiwei);
		jPanel1.add(jPanel12);

		jPanel.add(jPanel1);

		/**
		 * ������
		 */
		JPanel jPanel2 = new JPanel();
		jPanel2.setOpaque(false);
		jPanel2.setLayout(new GridLayout(1, 2));

		/**
		 * ��н
		 */
		JPanel jPanel20 = new JPanel();
		jPanel20.setOpaque(false);
		jPanel20.setLayout(new FlowLayout());
		// ��нͼƬ
		ImageIcon imageIcon_yuexin = new ImageIcon(
				Login.class.getResource("/com/today/images/yuexin.png"));
		imageIcon_yuexin.setImage(imageIcon_yuexin.getImage()
				.getScaledInstance(80, 40, Image.SCALE_DEFAULT));
		JLabel jLabel_yuexintu = new JLabel(imageIcon_yuexin, JLabel.RIGHT);
		jPanel20.add(jLabel_yuexintu);
		jPanel20.add(jTextField_xiangqing_yuxin);
		jPanel2.add(jPanel20);

		/**
		 * ��ٰ�����
		 */
		JPanel jPanel21 = new JPanel();
		jPanel21.setOpaque(false);
		jPanel21.setLayout(new FlowLayout());
		// �������ͼƬ
		ImageIcon imageIcon_qingjia = new ImageIcon(
				Login.class.getResource("/com/today/images/qingjiatianshu.png"));
		imageIcon_qingjia.setImage(imageIcon_qingjia.getImage()
				.getScaledInstance(160, 40, Image.SCALE_DEFAULT));
		JLabel jLabel_qingjiatu = new JLabel(imageIcon_qingjia, JLabel.RIGHT);
		jPanel21.add(jLabel_qingjiatu);
		jPanel21.add(jTextField_xiangqing_jiaqi);
		jPanel2.add(jPanel21);

		jPanel.add(jPanel2);

		/**
		 * ������
		 */
		JPanel jPanel3 = new JPanel();
		jPanel3.setOpaque(false);
		jPanel3.setLayout(new FlowLayout());
		/**
		 * ��ְʱ��
		 */
		// ��ְʱ��ͼƬ
		ImageIcon imageIcon_shijian = new ImageIcon(
				Login.class.getResource("/com/today/images/ruzhishijian.png"));
		imageIcon_shijian.setImage(imageIcon_shijian.getImage()
				.getScaledInstance(160, 40, Image.SCALE_DEFAULT));
		JLabel jLabel_shijiantu = new JLabel(imageIcon_shijian, JLabel.RIGHT);
		jPanel3.add(jLabel_shijiantu);
		jTextField_xiangqing_ruzhishijian.setContentAreaFilled(false);
		jTextField_xiangqing_ruzhishijian.setFont(new java.awt.Font("Dialog", 1,
				24));
		jTextField_xiangqing_ruzhishijian.setForeground(Color.black);
		jPanel3.add(jTextField_xiangqing_ruzhishijian);

		jPanel.add(jPanel3);

		/**
		 * ������
		 */
		JPanel jPanel4 = new JPanel();
		jPanel4.setOpaque(false);
		jPanel4.setLayout(new GridLayout(1, 2));

		/**
		 * ȷ����ť
		 */
		JPanel jPanel40 = new JPanel();
		jPanel40.setOpaque(false);
		jPanel40.setLayout(new FlowLayout(FlowLayout.RIGHT));
		ImageIcon imageIcon_button = new ImageIcon(
				Login.class.getResource("/com/today/images/button.png"));
		imageIcon_button.setImage(imageIcon_button.getImage()
				.getScaledInstance(30, 30, Image.SCALE_DEFAULT));

		/**
		 * ȡ����ť
		 */
		JPanel jPanel41 = new JPanel();
		jPanel41.setOpaque(false);
		jPanel41.setLayout(new FlowLayout(FlowLayout.CENTER));
		jButton_xiangqing_quxiao = new JButton("����", imageIcon_button);
		jButton_xiangqing_quxiao.setContentAreaFilled(false);
		jButton_xiangqing_quxiao.setForeground(Color.black);
		jPanel41.add(jButton_xiangqing_quxiao);
		jPanel4.add(jPanel41);

		jPanel.add(jPanel4);

		return jPanel;
	}

	/**
	 * ��ӵĵ���¼�
	 */
	private void xiangqingDianJi() {
		/**
		 * ȡ��
		 */
		jButton_xiangqing_quxiao.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				jTabbedPane.setSelectedIndex(0);
			}
		});

	}

	/**
	 * Ա���� �������
	 */
	private void YuanGongShuJuRuKou() {
		Employee employee = new Employee();
		listEmployees = employee.prinfEmployees();

		for (int i = 0; i < listEmployees.size(); i++) {
			Object[] objects = new Object[6];
			objects[3] = new JButton();
			objects[4] = new JButton();
			objects[5] = new JButton();
			objects[0] = listEmployees.get(i).getEmp_No();
			objects[1] = listEmployees.get(i).getEmp_Name();
			objects[2] = listEmployees.get(i).getEmp_Position();
			data.add(objects);
		}

	}

	/**
	 * Ա��ҵ����Ϣ
	 *
	 * @return
	 */
	private JTabbedPane yeWuXinXi() {
		// TODO Auto-generated method stub
		JTabbedPane jTabbedPane = new JTabbedPane();
		jTabbedPane.setBackground(new Color(1, 1, 0, 0.0f));
		jTabbedPane.setTabPlacement(JTabbedPane.RIGHT);

		return jTabbedPane;
	}

	/**
	 * jbutton ����ɾ��
	 *
	 * @author lwp940118
	 *
	 */
	class JtableButtonDelet extends AbstractCellEditor implements
			TableCellEditor, TableCellRenderer, ActionListener {
		// ��ť������״̬
		private JButton rb, eb;
		private int row;
		private JTable table;
		private String text = "ɾ��";
		private ImageIcon imageIcon_shanchu = new ImageIcon(
				Login.class.getResource("/com/today/images/shanchu.png"));

		public JtableButtonDelet() {
		}

		public JtableButtonDelet(JTable table, int column) {
			super();
			this.table = table;
			imageIcon_shanchu.setImage(imageIcon_shanchu.getImage()
					.getScaledInstance(30, 30, Image.SCALE_DEFAULT));
			rb = new JButton("ɾ��", imageIcon_shanchu);
			eb = new JButton("ɾ��", imageIcon_shanchu);
			rb.setContentAreaFilled(false);
			eb.setContentAreaFilled(false);
			eb.setFocusPainted(false);
			eb.setFont(new Font("Dialog", 0, 20));
			eb.setForeground(Color.black);
			rb.setFont(new Font("Dialog", 0, 20));
			rb.setForeground(Color.orange);
			eb.addActionListener(this);
			// ���øõ�Ԫ����Ⱦ�ͱ༭��ʽ
			TableColumnModel columnModel = table.getColumnModel();
			columnModel.getColumn(column).setCellRenderer(this);
			columnModel.getColumn(column).setCellEditor(this);
		}

		@Override
		public Object getCellEditorValue() {
			// TODO Auto-generated method stub
			return null;
		}

		// ����������
		@Override
		public void actionPerformed(ActionEvent arg0) {
			int v = Integer.parseInt(table.getValueAt(row, 0).toString());
			System.out.println("ѡ�е�ֵΪ��" + v);
			// ���½����� �е�ֵ
			string_delete_gonghao = table.getValueAt(row, 0).toString();
			string_delete_xingming = table.getValueAt(row, 1).toString();
			string_delete_zhiwei = table.getValueAt(row, 2).toString();
			jTextField_delete_gonghao.setText(string_delete_gonghao);
			jTextField_delete_xingming.setText(string_delete_xingming);
			jTextField_delete_zhiwei.setText(string_delete_zhiwei);
			jTabbedPane.setSelectedIndex(2);

		}

		@Override
		public Component getTableCellRendererComponent(JTable arg0,
				Object value, boolean arg2, boolean arg3, int arg4, int arg5) {
			rb.setText(text);
			return rb;
		}

		@Override
		public Component getTableCellEditorComponent(JTable table,
				Object value, boolean isSelected, int row, int column) {
			eb.setText(text);
			// �༭�У��к�
			this.row = row;
			return eb;
		}
	}

	/**
	 * jbutton �����޸�
	 *
	 * @author lwp940118
	 *
	 */
	class JtableButtonxiangqing extends AbstractCellEditor implements
			TableCellEditor, TableCellRenderer, ActionListener {
		// ��ť������״̬
		private JButton rb, eb;
		private int row;
		private JTable table;
		private String text = "����";
		private ImageIcon imageIcon_shanchu = new ImageIcon(
				Login.class.getResource("/com/today/images/jumxiangqing.png"));

		public JtableButtonxiangqing() {
		}

		public JtableButtonxiangqing(JTable table, int column) {
			super();
			this.table = table;
			imageIcon_shanchu.setImage(imageIcon_shanchu.getImage()
					.getScaledInstance(30, 30, Image.SCALE_DEFAULT));
			rb = new JButton("����", imageIcon_shanchu);
			eb = new JButton("����", imageIcon_shanchu);
			rb.setContentAreaFilled(false);
			eb.setContentAreaFilled(false);
			eb.setFont(new Font("Dialog", 0, 20));
			eb.setForeground(Color.black);
			rb.setFont(new Font("Dialog", 0, 20));
			rb.setForeground(Color.green);
			eb.setFocusPainted(false);
			eb.addActionListener(this);
			// ���øõ�Ԫ����Ⱦ�ͱ༭��ʽ
			TableColumnModel columnModel = table.getColumnModel();
			columnModel.getColumn(column).setCellRenderer(this);
			columnModel.getColumn(column).setCellEditor(this);
		}

		@Override
		public Object getCellEditorValue() {
			// TODO Auto-generated method stub
			return null;
		}

		// ����������
		@Override
		public void actionPerformed(ActionEvent arg0) {
			int v = Integer.parseInt(table.getValueAt(row, 0).toString());
			System.out.println("ѡ�е�ֵΪ��" + v);
			// ���½����� �е�ֵ
			String id = table.getValueAt(row, 0).toString();
			Employee employee = new Employee();
			List<EmployeeInformation> list = employee.prinfEmployee(id);
			System.out.println(11111);
			jTextField_xiangqing_gonghao.setText(list.get(0).getEmp_No());
			jTextField_xiangqing_xingming.setText(list.get(0).getEmp_Name());
			jTextField_xiangqing_nainling.setText(list.get(0).getEmp_Age());
			jTextField_xiangqing_ruzhishijian.setText(list.get(0)
					.getEmp_Induction_Time());
			jTextField_xiangqing_jiaqi.setText(list.get(0).getEmp_Holiday());
			jTextField_xiangqing_yuxin
					.setText(list.get(0).getEmp_Month_Money());
			jTextField_xiangqing_mima.setText(list.get(0).getEmp_Password());
			String xing = list.get(0).getEmp_Sex();
			String zhiwei = list.get(0).getEmp_Position();
			jComboBox_xiangqing_zhiwei.setText(list.get(0).getEmp_Position());

			jComboBox_xiangqing_xingbie.setText(list.get(0).getEmp_Sex());

			jTabbedPane.setSelectedIndex(4);

		}

		@Override
		public Component getTableCellRendererComponent(JTable arg0,
				Object value, boolean arg2, boolean arg3, int arg4, int arg5) {
			rb.setText(text);
			return rb;
		}

		@Override
		public Component getTableCellEditorComponent(JTable table,
				Object value, boolean isSelected, int row, int column) {
			eb.setText(text);
			// �༭�У��к�
			this.row = row;
			return eb;
		}
	}

	/**
	 * jbutton �����޸�
	 *
	 * @author lwp940118
	 *
	 */
	class JtableButtonxiugai extends AbstractCellEditor implements
			TableCellEditor, TableCellRenderer, ActionListener {
		// ��ť������״̬
		private JButton rb, eb;
		private int row;
		private JTable table;
		private String text = "�޸�";
		private ImageIcon imageIcon_shanchu = new ImageIcon(
				Login.class.getResource("/com/today/images/xiugai.png"));

		public JtableButtonxiugai() {
		}

		public JtableButtonxiugai(JTable table, int column) {
			super();
			this.table = table;
			imageIcon_shanchu.setImage(imageIcon_shanchu.getImage()
					.getScaledInstance(30, 30, Image.SCALE_DEFAULT));
			rb = new JButton("�޸�", imageIcon_shanchu);
			eb = new JButton("�޸�", imageIcon_shanchu);
			rb.setContentAreaFilled(false);
			eb.setContentAreaFilled(false);
			eb.setFont(new Font("Dialog", 0, 20));
			eb.setForeground(Color.black);
			rb.setFont(new Font("Dialog", 0, 20));
			rb.setForeground(Color.decode(Integer.valueOf("960096", 16)
					.toString()));
			eb.setFocusPainted(false);
			eb.addActionListener(this);
			// ���øõ�Ԫ����Ⱦ�ͱ༭��ʽ
			TableColumnModel columnModel = table.getColumnModel();
			columnModel.getColumn(column).setCellRenderer(this);
			columnModel.getColumn(column).setCellEditor(this);
		}

		@Override
		public Object getCellEditorValue() {
			// TODO Auto-generated method stub
			return null;
		}

		// ����������
		@Override
		public void actionPerformed(ActionEvent arg0) {
			int v = Integer.parseInt(table.getValueAt(row, 0).toString());
			System.out.println("ѡ�е�ֵΪ��" + v);
			// ���½����� �е�ֵ
			String id = table.getValueAt(row, 0).toString();
			Employee employee = new Employee();
			List<EmployeeInformation> list = employee.prinfEmployee(id);

			jTextField_xiugai_gonghao.setText(list.get(0).getEmp_No());
			jTextField_xiugai_xingming.setText(list.get(0).getEmp_Name());
			jTextField_xiugai_nainling.setText(list.get(0).getEmp_Age());
			jTextField_xiugai_ruzhishijian.setText(list.get(0)
					.getEmp_Induction_Time());
			jTextField_xiugai_jiaqi.setText(list.get(0).getEmp_Holiday());
			jTextField_xiugai_yuxin.setText(list.get(0).getEmp_Month_Money());
			jTextField_xiugai_mima.setText(list.get(0).getEmp_Password());
			String xing = list.get(0).getEmp_Sex();
			String zhiwei = list.get(0).getEmp_Position();
			if (zhiwei.equals("����")) {
				jComboBox_xiugai_zhiwei.setSelectedIndex(0);
			} else {

				jComboBox_xiugai_zhiwei.setSelectedIndex(1);
			}
			if (xing.equals("��")) {
				jComboBox_xiugai_xingbie.setSelectedIndex(0);
			} else {
				jComboBox_xiugai_xingbie.setSelectedIndex(1);
			}

			jTabbedPane.setSelectedIndex(3);

		}

		@Override
		public Component getTableCellRendererComponent(JTable arg0,
				Object value, boolean arg2, boolean arg3, int arg4, int arg5) {
			rb.setText(text);
			return rb;
		}

		@Override
		public Component getTableCellEditorComponent(JTable table,
				Object value, boolean isSelected, int row, int column) {
			eb.setText(text);
			// �༭�У��к�
			this.row = row;
			return eb;
		}
	}

	// �Զ�����ģ��
	class MyTableModel extends AbstractTableModel {
		// ��Ԫ��Ԫ������
		private Class[] cellType = { String.class, String.class, String.class,
				JButton.class, JButton.class, JButton.class };
		// ��ͷ
		private String title[] = { "����", "����", "ְλ", "�޸�", "ɾ��", "����" };
		// ģ������
		private List<Object[]> data = new ArrayList<Object[]>();

		public MyTableModel(List<Object[]> data) {
			this.data = data;
			fireTableDataChanged();
		}

		@Override
		public Class<?> getColumnClass(int arg0) {
			// TODO Auto-generated method stub
			return cellType[arg0];
		}

		@Override
		public String getColumnName(int arg0) {
			// TODO Auto-generated method stub
			return title[arg0];
		}

		@Override
		public int getColumnCount() {
			// TODO Auto-generated method stub
			return title.length;
		}

		@Override
		public int getRowCount() {
			// TODO Auto-generated method stub
			return data.size();
		}

		@Override
		public Object getValueAt(int r, int c) {
			// TODO Auto-generated method stub
			return data.get(r)[c];
		}

		// ��дisCellEditable����
		public boolean isCellEditable(int r, int c) {
			return true;
		}

		// ��дsetValueAt����
		public void setValueAt(Object value, int r, int c) {
			data.get(r)[c] = value;
			this.fireTableCellUpdated(r, c);
		}
	}

	class EmployeesInformation extends JPanel {

		public EmployeesInformation() {
			setOpaque(false);
			setLayout(new BorderLayout());
			/**
			 * Ա���������
			 */
			YuanGongShuJuRuKou();
			model = new MyTableModel(data);
			table = new JTable(model);
			// ���뵥Ԫ��Ԫ�أ������Զ���Ԫ��
			JtableButtonxiangqing xiangqing = new JtableButtonxiangqing(table,
					5);
			JtableButtonDelet delet = new JtableButtonDelet(table, 4);
			JtableButtonxiugai xiugai = new JtableButtonxiugai(table, 3);
			table.setRowHeight(50);

			table.getTableHeader().setFont(new Font("Dialog", 0, 30));
			table.getTableHeader().setForeground(Color.blue);
			table.getTableHeader().setOpaque(false);

			table.setFont(new Font("Dialog", 0, 20));
			table.setForeground(Color.black);
			table.setOpaque(false);

			/*
			 * TableColumn column = table.getColumnModel().getColumn(2); // �� 2
			 * �� column.setPreferredWidth(getPreferredWidthForColumn(column));
			 */
			DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
			renderer.setOpaque(false);
			renderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
			table.setDefaultRenderer(Object.class, renderer);
			JScrollPane jsp = new JScrollPane(table);
			jsp.setOpaque(false);
			jsp.getViewport().setOpaque(false);

			add(BorderLayout.CENTER, jsp);

		}
	}

}
