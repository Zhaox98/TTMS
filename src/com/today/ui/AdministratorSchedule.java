package com.today.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
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
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import com.xy.today.mycontrols.MyDateJbutton;
import com.xy.today.sql.Play;
import com.xy.today.sql.Schedule;
import com.xy.today.sql.Schedule_Time;
import com.xy.today.sql.Seat;
import com.xy.today.sql.Studio;
import com.xy.today.sql.Ticket;
import com.xy.today.util.PlayInformation;
import com.xy.today.util.ScheduleInformation;
import com.xy.today.util.Schedule_TimeInformation;
import com.xy.today.util.SeatInformation;
import com.xy.today.util.StudioInformation;

/**
 * �ݳ��ƻ� �� һЩ ���� ��
 *
 */
public class AdministratorSchedule extends JTabbedPane {

	/**
	 * �ݳ��ƻ���� �� һЩ �������
	 */
	private JComboBox jCheckBox_add_fangyingting = new JComboBox();
	private JComboBox jCheckBox_add_jumu = new JComboBox();
	private JComboBox jCheckBox_add_time = new JComboBox();
	private MyDateJbutton dateJbutton_add_shijian = new MyDateJbutton();
	private JTextField jTextField_add_piaojia = new JTextField(8);
	private JButton jButton_add_add;
	private JButton jButton_add_quxiao;

	/**
	 * �ݳ��ƻ��޸� �� һЩ �������
	 */
	private JComboBox jCheckBox_xiugai_fangyingting = new JComboBox();
	private JComboBox jCheckBox_xiugai_jumu = new JComboBox();
	private JComboBox jCheckBox_xiugai_time = new JComboBox();
	private MyDateJbutton dateJbutton_xiugai_shijian = new MyDateJbutton();
	private JTextField jTextField_xiugai_piaojia = new JTextField(8);
	private JButton jButton_xiugai_add;
	private JButton jButton_xiugai_quxiao;
	private JButton jButton_xiugai_seat;
	private String id_xiugai;
	private String xiugai_piaojia;

	/**
	 * �ݳ��ƻ����� �� һЩ �������
	 */
	private JTextField jCheckBox_infor_fangyingting = new JTextField(15);
	private JTextField jCheckBox_infor_jumu = new JTextField(15);
	private JTextField jCheckBox_infor_time = new JTextField(15);
	private MyDateJbutton dateJbutton_infor_shijian = new MyDateJbutton();
	private JTextField jTextField_infor_piaojia = new JTextField(8);
	private JButton jButton_infor_quxiao;
	private String id_infor;
	/**
	 * �ݳ��� ����Ϣ
	 */
	private List<StudioInformation> studioInformations = new ArrayList<StudioInformation>();

	/**
	 * ��Ŀ����Ϣ
	 */
	private List<PlayInformation> playInformations = new ArrayList<PlayInformation>();
	/**
	 * ʱ�� ����Ϣ
	 */
	private List<Schedule_TimeInformation> timeInformations = new ArrayList<Schedule_TimeInformation>();

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
	 * play���
	 */
	private JTable table;

	/**
	 * ��Ŀ ������Ϣ�Ĳ������
	 */
	private List<Object[]> data = new ArrayList<Object[]>();
	private List<ScheduleInformation> scheduleInformations = new ArrayList<ScheduleInformation>();

	/**
	 * �Զ�����ģʽ
	 */
	private MyTableModel model;

	public AdministratorSchedule() {
		setOpaque(false);
		setTabPlacement(JTabbedPane.TOP);

		/**
		 * �ݳ��ƻ��б�
		 */
		addShuJuRuKou();
		ImageIcon imageIcon_ScheduleList = new ImageIcon(
				Login.class.getResource("/com/today/images/yanchujihua.png"));
		imageIcon_ScheduleList.setImage(imageIcon_ScheduleList.getImage()
				.getScaledInstance(120, 40, Image.SCALE_DEFAULT));
		addTab("", imageIcon_ScheduleList, jPanel_scheduleList());
		listDianJiShiJian();

		/**
		 * �ݳ��ƻ����ľ�����Ϣ
		 */
		ImageIcon imageIcon_ScheduleInfor = new ImageIcon(
				Login.class.getResource("/com/today/images/jihuaxiangqing.png"));
		imageIcon_ScheduleInfor.setImage(imageIcon_ScheduleInfor.getImage()
				.getScaledInstance(120, 40, Image.SCALE_DEFAULT));
		addTab("", imageIcon_ScheduleInfor, jPanel_ScheduleInfor());

		/**
		 * �ݳ��ƻ�����Ӳ���
		 */

		ImageIcon imageIcon_ScheduleAdd = new ImageIcon(
				Login.class.getResource("/com/today/images/tianjiajihua.png"));
		imageIcon_ScheduleAdd.setImage(imageIcon_ScheduleAdd.getImage()
				.getScaledInstance(120, 40, Image.SCALE_DEFAULT));
		addTab("", imageIcon_ScheduleAdd, jPanel_ScheduleAdd());
		addDianji();

		/**
		 * �ݳ��ƻ����޸Ĳ���
		 */
		xiugaiShuJuRuKou();
		ImageIcon imageIcon_Schedulexiugai = new ImageIcon(
				Login.class.getResource("/com/today/images/xiugaijihua.png"));
		imageIcon_Schedulexiugai.setImage(imageIcon_Schedulexiugai.getImage()
				.getScaledInstance(120, 40, Image.SCALE_DEFAULT));
		addTab("", imageIcon_Schedulexiugai, jPanel_ScheduleXiugai());
		xiugaiDianji();

	}

	/**
	 * �ݳ��ƻ� ���б� չʾ
	 *
	 * @return
	 */
	private JPanel jPanel_scheduleList() {
		JPanel jPanel = new JPanel();
		jPanel.setOpaque(false);

		ImageIcon imageIcon_yuangongzengjia = new ImageIcon(
				Login.class
						.getResource("/com/today/images/yanchujihualiebiao.png"));
		imageIcon_yuangongzengjia.setImage(imageIcon_yuangongzengjia.getImage()
				.getScaledInstance(480, 70, Image.SCALE_DEFAULT));
		Insets insets = new Insets(2, 2, 2, 2);
		GridBagLayout gridBagLayout = new GridBagLayout();
		jPanel.setLayout(gridBagLayout);
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.insets = insets;
		/**
		 * �ݳ��ƻ��б��չʾ
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
		 * �ݳ��ƻ��б�ĵ��µĲ�������
		 */
		JPanel jPanel_nei = schedule_list();
		jPanel_nei.setOpaque(false);
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.weightx = 200;
		gridBagConstraints.weighty = 200;
		jPanel.add(jPanel_nei, gridBagConstraints);

		return jPanel;
	}

	/**
	 * �ݳ��ƻ��� �б��������
	 *
	 * @return
	 */
	private JPanel schedule_list() {
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
		JPanel jPanel_nei = new PlayInformationjp();
		jPanel_nei.setOpaque(false);
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.weightx = 200;
		gridBagConstraints.weighty = 800;
		jPanel.add(jPanel_nei, gridBagConstraints);

		return jPanel;
	}

	private void listDianJiShiJian() {
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
					for (int i = 0; i < scheduleInformations.size(); i++) {
						for (int j = 0; j < playInformations.size(); j++) {
							if (playInformations.get(j).getPlay_name()
									.contains(string_search)) {
								String id = playInformations.get(j)
										.getPlay_id();
								if (scheduleInformations.get(i).getPlay_id()
										.equals(id)) {
									Object[] objects = new Object[8];
									objects[5] = new JButton();
									objects[6] = new JButton();
									objects[7] = new JButton();
									objects[0] = scheduleInformations.get(i)
											.getSched_id();
									String fangyinting = scheduleInformations
											.get(i).getStudio_id();
									// System.out.println("---->"+scheduleInformations.get(i).getStudio_id());
									for (int q = 0; q < studioInformations
											.size(); q++) {
										if (studioInformations.get(q)
												.getStudio_id()
												.contains(fangyinting)) {
											objects[1] = studioInformations
													.get(q).getStudio_name();
										}
									}

									String jumu = scheduleInformations.get(i)
											.getPlay_id();
									for (int q = 0; q < playInformations.size(); q++) {

										if (playInformations.get(q)
												.getPlay_id().contains(jumu)) {
											objects[2] = playInformations
													.get(q).getPlay_name();
										}
									}
									objects[3] = scheduleInformations.get(i)
											.getSched_time();
									objects[4] = scheduleInformations.get(i)
											.getSched_ticket_price();
									data.add(objects);
								}
							}
						}

					}
					if (data.size() != 0) {
						model.fireTableDataChanged();
					}
				} else {
					data.removeAll(data);
					scheduleShuJuRuKou();
					model.fireTableDataChanged();

				}
			}
		});

		jButton_add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				addShuJuRuKou();
				setSelectedIndex(2);
			}
		});

	}

	/**
	 * �ݳ��ƻ� �� ����������Ϣ������
	 *
	 * @return
	 */
	private JPanel jPanel_ScheduleInfor() {
		JPanel jPanel = new JPanel();
		jPanel.setOpaque(false);

		ImageIcon imageIcon_yuangongzengjia = new ImageIcon(
				Login.class
						.getResource("/com/today/images/yanchujihuaxaingqing.png"));
		imageIcon_yuangongzengjia.setImage(imageIcon_yuangongzengjia.getImage()
				.getScaledInstance(500, 70, Image.SCALE_DEFAULT));
		Insets insets = new Insets(2, 2, 2, 2);
		GridBagLayout gridBagLayout = new GridBagLayout();
		jPanel.setLayout(gridBagLayout);
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.insets = insets;
		/**
		 * yan���ƻ������ͼƬ
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
		 * �ݳ��ƻ��� �²�������
		 */
		JPanel jPanel_nei = scheduleInfor();
		jPanel_nei.setOpaque(false);
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.weightx = 200;
		gridBagConstraints.weighty = 200;
		jPanel.add(jPanel_nei, gridBagConstraints);

		return jPanel;
	}

	/**
	 * �����ݳ��ƻ�����ϸ����
	 *
	 * @return
	 */
	private JPanel scheduleInfor() {
		JPanel jPanel = new JPanel();
		jPanel.setOpaque(false);

		jPanel.setLayout(new GridLayout(3, 1));

		/**
		 * ��һ��
		 */
		JPanel jPanel0 = new JPanel();
		jPanel0.setOpaque(false);
		jPanel0.setLayout(new GridLayout(1, 3));
		/**
		 * ��ӳ������
		 */
		JPanel jPanel00 = new JPanel();
		jPanel00.setOpaque(false);
		jPanel00.setLayout(new FlowLayout());
		jCheckBox_infor_fangyingting.setEditable(false);
		jCheckBox_infor_jumu.setEditable(false);
		jCheckBox_infor_time.setEditable(false);
		// ��ӳ��
		ImageIcon imageIcon_fangyingting = new ImageIcon(
				Login.class.getResource("/com/today/images/fangyingting.png"));
		imageIcon_fangyingting.setImage(imageIcon_fangyingting.getImage()
				.getScaledInstance(120, 40, Image.SCALE_DEFAULT));
		JLabel jLabel_fangyingtingtu = new JLabel(imageIcon_fangyingting,
				JLabel.RIGHT);
		jPanel00.add(jLabel_fangyingtingtu);
		jPanel00.add(jCheckBox_infor_fangyingting);
		jPanel0.add(jPanel00);

		JPanel jPanel01 = new JPanel();
		jPanel01.setOpaque(false);
		jPanel01.setLayout(new FlowLayout());
		// ��ӳ��
		ImageIcon imageIcon_jumu = new ImageIcon(
				Login.class.getResource("/com/today/images/jumu.png"));
		imageIcon_jumu.setImage(imageIcon_jumu.getImage().getScaledInstance(80,
				40, Image.SCALE_DEFAULT));
		JLabel jLabel_jumutu = new JLabel(imageIcon_jumu, JLabel.RIGHT);
		jPanel01.add(jLabel_jumutu);
		jPanel01.add(jCheckBox_infor_jumu);
		jPanel0.add(jPanel01);

		JPanel jPanel02 = new JPanel();
		jPanel02.setOpaque(false);
		jPanel02.setLayout(new FlowLayout());
		// ��ӳ��
		ImageIcon imageIcon_piaojia = new ImageIcon(
				Login.class.getResource("/com/today/images/piaojia.png"));
		imageIcon_piaojia.setImage(imageIcon_piaojia.getImage()
				.getScaledInstance(80, 40, Image.SCALE_DEFAULT));
		JLabel jLabel_piaojiatu = new JLabel(imageIcon_piaojia, JLabel.RIGHT);
		jPanel02.add(jLabel_piaojiatu);
		jPanel02.add(jTextField_infor_piaojia);
		jPanel0.add(jPanel02);

		jPanel.add(jPanel0);

		/**
		 * �ڶ���
		 */
		JPanel jPanel1 = new JPanel();
		jPanel1.setOpaque(false);
		jPanel1.setLayout(new FlowLayout());
		// ʱ��
		ImageIcon imageIcon_shijian = new ImageIcon(
				Login.class.getResource("/com/today/images/shijian.png"));
		imageIcon_shijian.setImage(imageIcon_shijian.getImage()
				.getScaledInstance(80, 40, Image.SCALE_DEFAULT));
		JLabel jLabel_shijiantu = new JLabel(imageIcon_shijian);
		jPanel1.add(jLabel_shijiantu);
		dateJbutton_infor_shijian.setContentAreaFilled(false);
		dateJbutton_infor_shijian.setFont(new java.awt.Font("Dialog", 1, 20));
		dateJbutton_infor_shijian.setForeground(Color.black);
		dateJbutton_infor_shijian.setEnabled(false);
		jPanel1.add(dateJbutton_infor_shijian);
		jPanel1.add(jCheckBox_infor_time);

		jPanel.add(jPanel1);

		/**
		 * ������
		 */
		ImageIcon imageIcon_button = new ImageIcon(
				Login.class.getResource("/com/today/images/button.png"));
		imageIcon_button.setImage(imageIcon_button.getImage()
				.getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		imageIcon_button.setImage(imageIcon_button.getImage()
				.getScaledInstance(30, 30, Image.SCALE_DEFAULT));

		/**
		 * ȡ����ť
		 */
		JPanel jPanel41 = new JPanel();
		jPanel41.setOpaque(false);
		jPanel41.setLayout(new FlowLayout());
		jButton_infor_quxiao = new JButton("����", imageIcon_button);
		jButton_infor_quxiao.setContentAreaFilled(false);
		jButton_infor_quxiao.setForeground(Color.black);
		jPanel41.add(jButton_infor_quxiao);
		jButton_infor_quxiao.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				setSelectedIndex(0);
			}
		});

		jPanel.add(jPanel41);

		return jPanel;
	}

	/**
	 * �ݳ��ƻ� ���޸� ����
	 *
	 * @return
	 */
	private JPanel jPanel_ScheduleXiugai() {
		JPanel jPanel = new JPanel();
		jPanel.setOpaque(false);

		ImageIcon imageIcon_yuangongzengjia = new ImageIcon(
				Login.class
						.getResource("/com/today/images/xiugaiyanchujihua.png"));
		imageIcon_yuangongzengjia.setImage(imageIcon_yuangongzengjia.getImage()
				.getScaledInstance(400, 70, Image.SCALE_DEFAULT));
		Insets insets = new Insets(2, 2, 2, 2);
		GridBagLayout gridBagLayout = new GridBagLayout();
		jPanel.setLayout(gridBagLayout);
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.insets = insets;
		/**
		 * �ݳ��ƻ�xiugai ��ͼƬ
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
		 * �ݳ��ƻ��޸ĵľ�������Ĳ���
		 */
		JPanel jPanel_nei = scheduleXiuGai();
		jPanel_nei.setOpaque(false);
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.weightx = 200;
		gridBagConstraints.weighty = 200;
		jPanel.add(jPanel_nei, gridBagConstraints);

		return jPanel;
	}

	/**
	 * �ݳ��ƻ��� �޸Ĳ�������
	 *
	 * @return
	 */
	private JPanel scheduleXiuGai() {
		JPanel jPanel = new JPanel();
		jPanel.setOpaque(false);
		jPanel.setLayout(new GridLayout(3, 1));

		/**
		 * ��һ��
		 */
		JPanel jPanel0 = new JPanel();
		jPanel0.setOpaque(false);
		jPanel0.setLayout(new GridLayout(1, 3));
		/**
		 * ��ӳ������
		 */
		JPanel jPanel00 = new JPanel();
		jPanel00.setOpaque(false);
		jPanel00.setLayout(new FlowLayout());
		// ��ӳ��
		ImageIcon imageIcon_fangyingting = new ImageIcon(
				Login.class.getResource("/com/today/images/fangyingting.png"));
		imageIcon_fangyingting.setImage(imageIcon_fangyingting.getImage()
				.getScaledInstance(120, 40, Image.SCALE_DEFAULT));
		JLabel jLabel_fangyingtingtu = new JLabel(imageIcon_fangyingting,
				JLabel.RIGHT);
		jPanel00.add(jLabel_fangyingtingtu);
		jCheckBox_xiugai_fangyingting
				.setFont(new java.awt.Font("Dialog", 1, 24));
		jPanel00.add(jCheckBox_xiugai_fangyingting);
		jPanel0.add(jPanel00);

		JPanel jPanel01 = new JPanel();
		jPanel01.setOpaque(false);
		jPanel01.setLayout(new FlowLayout());
		// ��ӳ��
		ImageIcon imageIcon_jumu = new ImageIcon(
				Login.class.getResource("/com/today/images/jumu.png"));
		imageIcon_jumu.setImage(imageIcon_jumu.getImage().getScaledInstance(80,
				40, Image.SCALE_DEFAULT));
		JLabel jLabel_jumutu = new JLabel(imageIcon_jumu, JLabel.RIGHT);
		jPanel01.add(jLabel_jumutu);
		jCheckBox_xiugai_jumu.setFont(new java.awt.Font("Dialog", 1, 24));
		jPanel01.add(jCheckBox_xiugai_jumu);
		jPanel0.add(jPanel01);

		JPanel jPanel02 = new JPanel();
		jPanel02.setOpaque(false);
		jPanel02.setLayout(new FlowLayout());
		// ��ӳ��
		ImageIcon imageIcon_piaojia = new ImageIcon(
				Login.class.getResource("/com/today/images/piaojia.png"));
		imageIcon_piaojia.setImage(imageIcon_piaojia.getImage()
				.getScaledInstance(80, 40, Image.SCALE_DEFAULT));
		JLabel jLabel_piaojiatu = new JLabel(imageIcon_piaojia, JLabel.RIGHT);
		jPanel02.add(jLabel_piaojiatu);
		jPanel02.add(jTextField_xiugai_piaojia);
		jPanel0.add(jPanel02);

		jPanel.add(jPanel0);

		/**
		 * �ڶ���
		 */
		JPanel jPanel1 = new JPanel();
		jPanel1.setOpaque(false);
		jPanel1.setLayout(new FlowLayout());
		// ʱ��
		ImageIcon imageIcon_shijian = new ImageIcon(
				Login.class.getResource("/com/today/images/shijian.png"));
		imageIcon_shijian.setImage(imageIcon_shijian.getImage()
				.getScaledInstance(80, 40, Image.SCALE_DEFAULT));
		JLabel jLabel_shijiantu = new JLabel(imageIcon_shijian);
		jPanel1.add(jLabel_shijiantu);
		dateJbutton_xiugai_shijian.setContentAreaFilled(false);
		dateJbutton_xiugai_shijian.setFont(new java.awt.Font("Dialog", 1, 24));
		dateJbutton_xiugai_shijian.setForeground(Color.black);
		jPanel1.add(dateJbutton_xiugai_shijian);
		jCheckBox_xiugai_time.setFont(new java.awt.Font("Dialog", 1, 20));
		jPanel1.add(jCheckBox_xiugai_time);

		jPanel.add(jPanel1);

		/**
		 * ������
		 */
		JPanel jPanel4 = new JPanel();
		jPanel4.setOpaque(false);
		jPanel4.setLayout(new GridLayout(1, 3));

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
		imageIcon_button.setImage(imageIcon_button.getImage()
				.getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		jButton_xiugai_add = new JButton("�޸�", imageIcon_button);
		jButton_xiugai_add.setContentAreaFilled(false);
		jButton_xiugai_add.setForeground(Color.black);
		jPanel40.add(jButton_xiugai_add);
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

		JPanel jPanel42 = new JPanel();
		jPanel42.setOpaque(false);
		jPanel42.setLayout(new FlowLayout(FlowLayout.LEFT));
		jButton_xiugai_seat = new JButton("������λ", imageIcon_button);
		jButton_xiugai_seat.setContentAreaFilled(false);
		jButton_xiugai_seat.setForeground(Color.black);
		jPanel42.add(jButton_xiugai_seat);
		jPanel4.add(jPanel42);

		jPanel.add(jPanel4);

		return jPanel;
	}

	/**
	 * �޸� ���������
	 */
	private void xiugaiShuJuRuKou() {
		Studio studio = new Studio();
		studioInformations = studio.prinfStudios();
		for (int i = 0; i < studioInformations.size(); i++) {
			jCheckBox_xiugai_fangyingting.addItem(studioInformations.get(i)
					.getStudio_name());
		}
		Play play = new Play();
		playInformations = play.prinfPlays();
		for (int i = 0; i < playInformations.size(); i++) {
			jCheckBox_xiugai_jumu.addItem(playInformations.get(i)
					.getPlay_name());
		}
		Schedule_Time schedule_Time = new Schedule_Time();
		timeInformations = schedule_Time.prinfTimes();
		for (int i = 0; i < timeInformations.size(); i++) {
			jCheckBox_xiugai_time.addItem(timeInformations.get(i).getTime());
		}

	}

	/**
	 * �޸� ����¼� ������
	 */
	private void xiugaiDianji() {

		jButton_xiugai_quxiao.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				setSelectedIndex(0);
			}
		});

		/**
		 * ��� jbutton
		 */
		jButton_xiugai_add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String piaojia = jTextField_xiugai_piaojia.getText();
				if (piaojia.equals("")) {
					JOptionPane.showMessageDialog(
							Administrator.jFrame_GuanLi.getContentPane(),
							"Ʊ�۲���Ϊ��!", "today�޸�ϵͳ��Ϣ",
							JOptionPane.WARNING_MESSAGE);
				} else {
					String studio_id = studioInformations.get(
							jCheckBox_xiugai_fangyingting.getSelectedIndex())
							.getStudio_id();
					String play_id = playInformations.get(
							jCheckBox_xiugai_jumu.getSelectedIndex())
							.getPlay_id();
					String sched_time = dateJbutton_xiugai_shijian.getText();
					String time_id = timeInformations.get(
							jCheckBox_xiugai_time.getSelectedIndex())
							.getTime_id();
					Schedule schedule = new Schedule();
					if (schedule.scheduleXiuGai(studio_id, play_id, sched_time,
							piaojia, time_id, id_xiugai)) {
						JOptionPane.showMessageDialog(
								Administrator.jFrame_GuanLi.getContentPane(),
								"�޸ĳɹ�!", "today�޸�ϵͳ��Ϣ",
								JOptionPane.WARNING_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(
								Administrator.jFrame_GuanLi.getContentPane(),
								"�޸�ʧ��!", "today�޸�ϵͳ��Ϣ",
								JOptionPane.ERROR_MESSAGE);
					}

				}
			}
		});

		jButton_xiugai_seat.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String studio_id = studioInformations.get(
						jCheckBox_xiugai_fangyingting.getSelectedIndex())
						.getStudio_id();
				/**
				 * ������λ��״̬ ������Ʊ
				 */
				Seat seat = new Seat();
				List<SeatInformation> seatInformations =
						new ArrayList<SeatInformation>();
				seatInformations = seat.prinfSeats(studio_id);
				Ticket ticket = new Ticket();
				if (ticket.prinfPlay(id_xiugai).size()==0) {
					for (int i = 0; i < seatInformations.size(); i++) {
						//��ʾ��λ����
						if (seatInformations.get(i).getSeat_status().equals("1")) {
							ticket.tcketAdd(seatInformations.get(i).getSeat_id()
									, id_xiugai, xiugai_piaojia, "0");
						}

					}
					JOptionPane.showMessageDialog(
							Administrator.jFrame_GuanLi.getContentPane(),
							"Ʊ�ɹ����!", "today����ϵͳ��Ϣ",
							JOptionPane.WARNING_MESSAGE);

				}else {
					JOptionPane.showMessageDialog(
							Administrator.jFrame_GuanLi.getContentPane(),
							"�üƻ�Ʊ�����ɹ�!", "today����ϵͳ��Ϣ",
							JOptionPane.WARNING_MESSAGE);
				}

			}
		});
	}

	/**
	 * �ݳ��ƻ� ��tianjia����
	 *
	 * @return
	 */
	private JPanel jPanel_ScheduleAdd() {
		JPanel jPanel = new JPanel();
		jPanel.setOpaque(false);

		ImageIcon imageIcon_yuangongzengjia = new ImageIcon(
				Login.class
						.getResource("/com/today/images/tianjiayanchujihua.png"));
		imageIcon_yuangongzengjia.setImage(imageIcon_yuangongzengjia.getImage()
				.getScaledInstance(400, 70, Image.SCALE_DEFAULT));
		Insets insets = new Insets(2, 2, 2, 2);
		GridBagLayout gridBagLayout = new GridBagLayout();
		jPanel.setLayout(gridBagLayout);
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.insets = insets;
		/**
		 * �ݳ��ƻ� ��ӵ�ͼƬ
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
		 * �ݳ��ƻ���ӵľ�������Ĳ���
		 */
		JPanel jPanel_nei = scheduleAdd();
		jPanel_nei.setOpaque(false);
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.weightx = 200;
		gridBagConstraints.weighty = 200;
		jPanel.add(jPanel_nei, gridBagConstraints);

		return jPanel;
	}

	/**
	 * �ݳ��ƻ��� ��� ��������
	 *
	 * @return
	 */
	private JPanel scheduleAdd() {
		JPanel jPanel = new JPanel();
		jPanel.setOpaque(false);
		jPanel.setLayout(new GridLayout(3, 1));

		/**
		 * ��һ��
		 */
		JPanel jPanel0 = new JPanel();
		jPanel0.setOpaque(false);
		jPanel0.setLayout(new GridLayout(1, 3));
		/**
		 * ��ӳ������
		 */
		JPanel jPanel00 = new JPanel();
		jPanel00.setOpaque(false);
		jPanel00.setLayout(new FlowLayout());
		// ��ӳ��
		ImageIcon imageIcon_fangyingting = new ImageIcon(
				Login.class.getResource("/com/today/images/fangyingting.png"));
		imageIcon_fangyingting.setImage(imageIcon_fangyingting.getImage()
				.getScaledInstance(120, 40, Image.SCALE_DEFAULT));
		JLabel jLabel_fangyingtingtu = new JLabel(imageIcon_fangyingting,
				JLabel.RIGHT);
		jPanel00.add(jLabel_fangyingtingtu);
		jCheckBox_add_fangyingting.setFont(new java.awt.Font("Dialog", 1, 24));
		jPanel00.add(jCheckBox_add_fangyingting);
		jPanel0.add(jPanel00);

		JPanel jPanel01 = new JPanel();
		jPanel01.setOpaque(false);
		jPanel01.setLayout(new FlowLayout());
		// ��ӳ��
		ImageIcon imageIcon_jumu = new ImageIcon(
				Login.class.getResource("/com/today/images/jumu.png"));
		imageIcon_jumu.setImage(imageIcon_jumu.getImage().getScaledInstance(80,
				40, Image.SCALE_DEFAULT));
		JLabel jLabel_jumutu = new JLabel(imageIcon_jumu, JLabel.RIGHT);
		jPanel01.add(jLabel_jumutu);
		jCheckBox_add_jumu.setFont(new java.awt.Font("Dialog", 1, 24));
		jPanel01.add(jCheckBox_add_jumu);
		jPanel0.add(jPanel01);

		JPanel jPanel02 = new JPanel();
		jPanel02.setOpaque(false);
		jPanel02.setLayout(new FlowLayout());
		// ��ӳ��
		ImageIcon imageIcon_piaojia = new ImageIcon(
				Login.class.getResource("/com/today/images/piaojia.png"));
		imageIcon_piaojia.setImage(imageIcon_piaojia.getImage()
				.getScaledInstance(80, 40, Image.SCALE_DEFAULT));
		JLabel jLabel_piaojiatu = new JLabel(imageIcon_piaojia, JLabel.RIGHT);
		jPanel02.add(jLabel_piaojiatu);
		jPanel02.add(jTextField_add_piaojia);
		jPanel0.add(jPanel02);

		jPanel.add(jPanel0);

		/**
		 * �ڶ���
		 */
		JPanel jPanel1 = new JPanel();
		jPanel1.setOpaque(false);
		jPanel1.setLayout(new FlowLayout());
		// ʱ��
		ImageIcon imageIcon_shijian = new ImageIcon(
				Login.class.getResource("/com/today/images/shijian.png"));
		imageIcon_shijian.setImage(imageIcon_shijian.getImage()
				.getScaledInstance(80, 40, Image.SCALE_DEFAULT));
		JLabel jLabel_shijiantu = new JLabel(imageIcon_shijian);
		jPanel1.add(jLabel_shijiantu);
		dateJbutton_add_shijian.setContentAreaFilled(false);
		dateJbutton_add_shijian.setFont(new java.awt.Font("Dialog", 1, 24));
		dateJbutton_add_shijian.setForeground(Color.black);
		jPanel1.add(dateJbutton_add_shijian);
		jCheckBox_add_time.setFont(new java.awt.Font("Dialog", 1, 20));
		jPanel1.add(jCheckBox_add_time);

		jPanel.add(jPanel1);

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
		imageIcon_button.setImage(imageIcon_button.getImage()
				.getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		jButton_add_add = new JButton("���", imageIcon_button);
		jButton_add_add.setContentAreaFilled(false);
		jButton_add_add.setForeground(Color.black);
		jPanel40.add(jButton_add_add);
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
	 * ��� ���������
	 */
	@SuppressWarnings("unchecked")
	private void addShuJuRuKou() {
		Studio studio = new Studio();
		studioInformations = studio.prinfStudios();
		jCheckBox_add_fangyingting.removeAllItems();
		jCheckBox_add_jumu.removeAllItems();
		jCheckBox_add_time.removeAllItems();
		for (int i = 0; i < studioInformations.size(); i++) {
			jCheckBox_add_fangyingting.addItem(studioInformations.get(i)
					.getStudio_name());
		}
		Play play = new Play();
		playInformations = play.prinfPlays();
		for (int i = 0; i < playInformations.size(); i++) {
			jCheckBox_add_jumu.addItem(playInformations.get(i).getPlay_name());
		}
		Schedule_Time schedule_Time = new Schedule_Time();
		timeInformations = schedule_Time.prinfTimes();
		for (int i = 0; i < timeInformations.size(); i++) {
			jCheckBox_add_time.addItem(timeInformations.get(i).getTime());
		}

	}

	/**
	 * ��� �ĵ���¼�����
	 */
	private void addDianji() {

		jButton_add_quxiao.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				setSelectedIndex(0);
			}
		});

		jButton_add_add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String piaojia = jTextField_add_piaojia.getText();
				if (piaojia.equals("")) {
					JOptionPane.showMessageDialog(
							Administrator.jFrame_GuanLi.getContentPane(),
							"Ʊ�۲���Ϊ��!", "today����ϵͳ��Ϣ",
							JOptionPane.WARNING_MESSAGE);
				} else {
					String studio_id = studioInformations.get(
							jCheckBox_add_fangyingting.getSelectedIndex())
							.getStudio_id();
					String play_id = playInformations.get(
							jCheckBox_add_jumu.getSelectedIndex()).getPlay_id();
					String sched_time = dateJbutton_add_shijian.getText();
					String time_id = timeInformations.get(
							jCheckBox_add_time.getSelectedIndex()).getTime_id();
					Schedule schedule = new Schedule();
					if (schedule.scheduleAdd(studio_id, play_id, sched_time,
							piaojia, time_id)) {

						JOptionPane.showMessageDialog(
								Administrator.jFrame_GuanLi.getContentPane(),
								"��ӳɹ�!", "today����ϵͳ��Ϣ",
								JOptionPane.WARNING_MESSAGE);
					} else {

						JOptionPane.showMessageDialog(
								Administrator.jFrame_GuanLi.getContentPane(),
								"���ʧ��!", "today����ϵͳ��Ϣ",
								JOptionPane.ERROR_MESSAGE);
					}
				}

			}
		});

		jCheckBox_add_jumu.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				int jumu = jCheckBox_add_jumu.getSelectedIndex();
				jTextField_add_piaojia.setText(playInformations.get(jumu)
						.getPlay_ticket_price());
			}
		});
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
			eb.setFont(new Font("Dialog", 0, 20));
			eb.setForeground(Color.black);
			rb.setFont(new Font("Dialog", 0, 20));
			rb.setForeground(Color.orange);
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
			String string = table.getValueAt(row, 0).toString();
			ImageIcon imageIcon_xinxixiugai = new ImageIcon(
					Login.class
							.getResource("/com/today/images/tuichujinggao.png"));
			imageIcon_xinxixiugai.setImage(imageIcon_xinxixiugai.getImage()
					.getScaledInstance(50, 50, Image.SCALE_DEFAULT));
			int option = JOptionPane.showConfirmDialog(null, "ȷ���Ƿ�ɾ��",
					"todayϵͳ��ʾ", JOptionPane.YES_NO_OPTION,
					JOptionPane.WARNING_MESSAGE, imageIcon_xinxixiugai);
			switch (option) {
			case JOptionPane.YES_NO_OPTION: {
				Schedule schedule = new Schedule();
				if (schedule.DeleteSchedule(string)) {
					Ticket ticket = new Ticket();
					if (ticket.deleteTcket(string)) {

						JOptionPane.showMessageDialog(
								Administrator.jFrame_GuanLi.getContentPane(),
								"ɾ���ɹ�!", "todayɾ��ϵͳ��Ϣ",
								JOptionPane.WARNING_MESSAGE);
					}
				} else {
					JOptionPane
							.showMessageDialog(Administrator.jFrame_GuanLi
									.getContentPane(), "ɾ��ʧ��!", "todayɾ��ϵͳ��Ϣ",
									JOptionPane.WARNING_MESSAGE);
				}
				break;
			}
			case JOptionPane.NO_OPTION: {
				System.out.println("���˳��ɹ�");
				break;
			}
			}

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
			eb.setFocusPainted(false);
			eb.setFont(new Font("Dialog", 0, 20));
			eb.setForeground(Color.black);
			rb.setFont(new Font("Dialog", 0, 20));
			rb.setForeground(Color.decode(Integer.valueOf("960096", 16)
					.toString()));
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
			id_xiugai = table.getValueAt(row, 0).toString();
			xiugai_piaojia = table.getValueAt(row, 4).toString();
			Schedule schedule = new Schedule();
			scheduleInformations = schedule.prinfSchedule(id);
			// ��ӳ��
			for (int i = 0; i < studioInformations.size(); i++) {
				if (studioInformations.get(i).getStudio_id()
						.equals(scheduleInformations.get(0).getStudio_id())) {
					jCheckBox_xiugai_fangyingting
							.setSelectedItem(studioInformations.get(i)
									.getStudio_name());
				}
			}
			// ��Ŀ
			for (int i = 0; i < playInformations.size(); i++) {
				if (playInformations.get(i).getPlay_id()
						.equals(scheduleInformations.get(0).getPlay_id())) {
					jCheckBox_xiugai_jumu.setSelectedItem(playInformations.get(
							i).getPlay_name());
				}
			}
			jTextField_xiugai_piaojia.setText(scheduleInformations.get(0)
					.getSched_ticket_price());
			// ʱ��
			dateJbutton_xiugai_shijian.setText(scheduleInformations.get(0)
					.getSched_time());
			for (int i = 0; i < timeInformations.size(); i++) {
				if (timeInformations.get(i).getTime_id()
						.equals(scheduleInformations.get(0).getTime_id())) {
					jCheckBox_xiugai_time.setSelectedItem(timeInformations.get(
							i).getTime());
				}
			}

			setSelectedIndex(3);

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
	 * jbutton ��������
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
			eb.setFocusPainted(false);
			eb.addActionListener(this);
			eb.setFont(new Font("Dialog", 0, 20));
			eb.setForeground(Color.black);
			rb.setFont(new Font("Dialog", 0, 20));
			rb.setForeground(Color.GREEN);
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

			id_infor = table.getValueAt(row, 0).toString();
			Schedule schedule = new Schedule();
			scheduleInformations = schedule.prinfSchedule(id);
			// ��ӳ��
			for (int i = 0; i < studioInformations.size(); i++) {
				if (studioInformations.get(i).getStudio_id()
						.equals(scheduleInformations.get(0).getStudio_id())) {
					jCheckBox_infor_fangyingting.setText(studioInformations
							.get(i).getStudio_name());
				}
			}
			// ��Ŀ
			for (int i = 0; i < playInformations.size(); i++) {
				if (playInformations.get(i).getPlay_id()
						.equals(scheduleInformations.get(0).getPlay_id())) {
					jCheckBox_infor_jumu.setText(playInformations.get(i)
							.getPlay_name());
//					System.out.println("-------------------");
//					System.out.println(playInformations.get(i)
//							.getPlay_name());
				}
			}
			jTextField_infor_piaojia.setText(scheduleInformations.get(0)
					.getSched_ticket_price());
			// ʱ��
			dateJbutton_infor_shijian.setText(scheduleInformations.get(0)
					.getSched_time());
			for (int i = 0; i < timeInformations.size(); i++) {
				if (timeInformations.get(i).getTime_id()
						.equals(scheduleInformations.get(0).getTime_id())) {
					jCheckBox_infor_time.setText(timeInformations.get(i)
							.getTime());
				}
			}

			setSelectedIndex(1);

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
				String.class, String.class, JButton.class, JButton.class,
				JButton.class };
		// ��ͷ
		private String title[] = { "�ݳ��ƻ�id", "��ӳ��", "��Ŀ����", "ʱ��", "Ʊ��", "�޸�",
				"����", "ɾ��" };
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

	class PlayInformationjp extends JPanel {

		public PlayInformationjp() {
			setOpaque(false);
			setLayout(new BorderLayout());
			/**
			 * Ա���������
			 */
			scheduleShuJuRuKou();
			model = new MyTableModel(data);
			table = new JTable(model);
			// ���뵥Ԫ��Ԫ�أ������Զ���Ԫ��
			JtableButtonxiangqing xiang = new JtableButtonxiangqing(table, 6);
			JtableButtonDelet delet = new JtableButtonDelet(table, 7);
			JtableButtonxiugai xiugai = new JtableButtonxiugai(table, 5);
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

	/**
	 * ��Ŀ�ĺ� �������
	 */
	private void scheduleShuJuRuKou() {
		Schedule schedule = new Schedule();
		scheduleInformations = schedule.prinfSchedules();

		for (int i = 0; i < scheduleInformations.size(); i++) {
			Object[] objects = new Object[8];
			objects[5] = new JButton();
			objects[6] = new JButton();
			objects[7] = new JButton();
			objects[0] = scheduleInformations.get(i).getSched_id();
			String fangyinting = scheduleInformations.get(i).getStudio_id();
			// System.out.println("---->"+scheduleInformations.get(i).getStudio_id());
			for (int j = 0; j < studioInformations.size(); j++) {
				if (studioInformations.get(j).getStudio_id()
						.contains(fangyinting)) {
					objects[1] = studioInformations.get(j).getStudio_name();
				}
			}

			String jumu = scheduleInformations.get(i).getPlay_id();
			System.out.println("aaa"+playInformations.size());
			for (int j = 1; j < playInformations.size(); j++) {

				if (playInformations.get(j).getPlay_id().contains(jumu)) {
					System.out.println(playInformations.get(j).getPlay_id());
					objects[2] = playInformations.get(j).getPlay_name();
				}
			}
			objects[3] = scheduleInformations.get(i).getSched_time();
			objects[4] = scheduleInformations.get(i).getSched_ticket_price();
			data.add(objects);
		}

	}

}
