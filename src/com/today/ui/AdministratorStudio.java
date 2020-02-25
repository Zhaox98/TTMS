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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import com.today.math.SeatMath;
import com.xy.today.mycontrols.JComboBox_Item;
import com.xy.today.sql.Seat;
import com.xy.today.sql.Studio;
import com.xy.today.util.StudioInformation;

/**
 * 演出厅 管理 的 具体的信息 的操作

 */
public class AdministratorStudio extends JTabbedPane {

	/**
	 * 演出厅添加 的一些信息
	 */
	private JTextArea jTextField_add_infor = new JTextArea();
	private JTextField jTextField_add_mingcheng = new JTextField(15);
	private JTextField jTextField_add_hang = new JTextField(10);
	private JTextField jTextField_add_lie = new JTextField(10);
	private JComboBox jComboBox_add_keyou;
	private JButton jButton_add_add;
	private JButton jButton_add_quxiao;

	/**
	 * 演出厅修改 的一些信息
	 */
	private JTextArea jTextField_xiugai_infor = new JTextArea();
	private JTextField jTextField_xiugai_mingcheng = new JTextField(15);
	private JTextField jTextField_xiugai_hang = new JTextField(10);
	private JTextField jTextField_xiugai_lie = new JTextField(10);
	private JComboBox jComboBox_xiugai_keyou = new JComboBox();;
	private JButton jButton_xiugai_xiugai;
	private JButton jButton_xiugai_quxiao;
	private String string_xiugai;

	/**
	 * 演出厅详细信息
	 */
	private JTextArea jTextField_infor_infor = new JTextArea();
	private JTextField jTextField_infor_mingcheng = new JTextField(10);
	private JTextField jTextField_infor_hang = new JTextField(5);
	private JTextField jTextField_infor_lie = new JTextField(5);
	private JTextField jTextField_infor_keyong = new JTextField(10);
	private JButton jButton_infor_quxiao;
	private JButton jButton_infor_xiugai;
	private String string_infor = "6";
	private JPanel jPanel_seat;

	/**
	 * 座位的  jbutton  和int数组
	 */
	private JButton[][] jButtons;
	private int[][] seat;

	/**
	 * 放映厅的具体信息设置
	 */
	private JLabel jLabel_niaokantu;
	private JLabel jLabel_xinxi;

	/**
	 * 座位的信息
	 */

	/**
	 * 查找的 jtextfiled
	 */
	private JTextField jTextField_search;

	/**
	 * 查找的 jbutton
	 */
	private JButton jButton_search;
	private JButton jButton_add;

	private List<StudioInformation> studioInformations = new ArrayList<StudioInformation>();
	/**
	 * 员工 具体信息的操作表格
	 */
	private List<Object[]> data = new ArrayList<Object[]>();

	/**
	 * 自定义表格模式
	 */
	private MyTableModel model;
	/**
	 * 员工表格
	 */
	private JTable table;

	public AdministratorStudio() {
		setOpaque(false);
		setTabPlacement(JTabbedPane.TOP);

		/**
		 * 演出厅列表
		 */
		ImageIcon imageIcon_ScheduleList = new ImageIcon(
				Login.class
						.getResource("/com/today/images/yanchutingliebiao.png"));
		imageIcon_ScheduleList.setImage(imageIcon_ScheduleList.getImage()
				.getScaledInstance(120, 40, Image.SCALE_DEFAULT));
		addTab("", imageIcon_ScheduleList, jPanel_ScheduleList());
		listDian();

		/**
		 * 演出厅具体的信息简介
		 */
		ImageIcon imageIcon_ScheduleInfor = new ImageIcon(
				Login.class
						.getResource("/com/today/images/yanchutingxinxi.png"));
		imageIcon_ScheduleInfor.setImage(imageIcon_ScheduleInfor.getImage()
				.getScaledInstance(120, 40, Image.SCALE_DEFAULT));
		addTab("", imageIcon_ScheduleInfor, jPanel_ScheduleInfor());
		formationDinaJi();
		inforDinaJI();

		/**
		 * 演出厅添加
		 */
		ImageIcon imageIcon_ScheduleAdd = new ImageIcon(
				Login.class
						.getResource("/com/today/images/yanchutingtianjia.png"));
		imageIcon_ScheduleAdd.setImage(imageIcon_ScheduleAdd.getImage()
				.getScaledInstance(120, 40, Image.SCALE_DEFAULT));
		addTab("", imageIcon_ScheduleAdd, jPanel_ScheduleAdd());
		AddDianji();

		/**
		 * 演出厅修改
		 */
		ImageIcon imageIcon_Schedulexiugai = new ImageIcon(
				Login.class
						.getResource("/com/today/images/yanchutingxiugai.png"));
		imageIcon_Schedulexiugai.setImage(imageIcon_Schedulexiugai.getImage()
				.getScaledInstance(120, 40, Image.SCALE_DEFAULT));
		addTab("", imageIcon_Schedulexiugai, jPanel_ScheduleXiugai());
		xiugaiDianji();

	}

	/**
	 * 演出厅列表
	 *
	 * @return
	 */
	private JPanel jPanel_ScheduleList() {
		JPanel jPanel = new JPanel();
		jPanel.setOpaque(false);

		ImageIcon imageIcon_yuangongzengjia = new ImageIcon(
				Login.class
						.getResource("/com/today/images/yanchutingxinxiliebiao.png"));
		imageIcon_yuangongzengjia.setImage(imageIcon_yuangongzengjia.getImage()
				.getScaledInstance(560, 70, Image.SCALE_DEFAULT));
		Insets insets = new Insets(2, 2, 2, 2);
		GridBagLayout gridBagLayout = new GridBagLayout();
		jPanel.setLayout(gridBagLayout);
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.insets = insets;
		/**
		 * 剧目列表的图片
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
		 * 剧目列表的 下操作界面
		 */
		JPanel jPanel_nei = studio_list();
		jPanel_nei.setOpaque(false);
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.weightx = 200;
		gridBagConstraints.weighty = 200;
		jPanel.add(jPanel_nei, gridBagConstraints);

		return jPanel;
	}

	private JPanel studio_list() {
		// TODO Auto-generated method stub
		JPanel jPanel = new JPanel();

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
		 * 添加图片
		 */
		ImageIcon imageIcon_shanchu = new ImageIcon(
				Login.class.getResource("/com/today/images/tianjia.png"));
		imageIcon_shanchu.setImage(imageIcon_shanchu.getImage()
				.getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		jButton_add = new JButton("添加", imageIcon_shanchu);
		jButton_add.setContentAreaFilled(false);
		jPanel_wei.add(jButton_add);
		jPanel.add(jPanel_wei, gridBagConstraints);

		/**
		 * 员工简介的列表
		 */
		JPanel jPanel_nei = new StudioInformationjp();
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
	 * 放映厅列表的简介事件
	 */
	private void listDian() {
		/**
		 * 搜索button的 点击事件设置
		 */
		jButton_search.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String string_search = jTextField_search.getText();
				System.out.println(string_search);
				if (!string_search.equals("")) {
					data.removeAll(data);
					for (int i = 0; i < studioInformations.size(); i++) {

						if (studioInformations.get(i).getStudio_name()
								.contains(string_search)) {
							Object[] objects = new Object[8];
							objects[5] = new JButton();
							objects[6] = new JButton();
							objects[7] = new JButton();
							objects[0] = studioInformations.get(i)
									.getStudio_id();
							objects[1] = studioInformations.get(i)
									.getStudio_name();
							objects[2] = studioInformations.get(i)
									.getStudio_row_count();
							objects[3] = studioInformations.get(i)
									.getStudio_col_count();
							objects[4] = studioInformations.get(i)
									.getStudio_isavailable();
							data.add(objects);

						}
					}
					if (data.size() != 0) {
						model.fireTableDataChanged();
					}
				} else {
					data.removeAll(data);
					studioShuJuRuKou();
					model.fireTableDataChanged();

				}
			}
		});

		jButton_add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setSelectedIndex(2);
			}
		});

	}

	/**
	 * 演出厅信息的 简介
	 *
	 * @return
	 */
	private JPanel jPanel_ScheduleInfor() {

		JPanel jPanel = new JPanel();
		jPanel.setOpaque(false);
		jPanel.setLayout(new GridBagLayout());
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		Insets insets = new Insets(0, 5, 10, 5);
		gridBagConstraints.insets = insets;

		jLabel_niaokantu = new JLabel("1号演出厅鸟瞰图");
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.weightx = 60;
		gridBagConstraints.weighty = 10;
		jLabel_niaokantu.setFont(new java.awt.Font("Dialog", 1, 50));
		jLabel_niaokantu.setForeground(Color.blue);
		jPanel.add(jLabel_niaokantu, gridBagConstraints);

		ImageIcon imageIcon_mingcheng = new ImageIcon(
				Login.class
						.getResource("/com/today/images/yanchutingjutixinxi.png"));
		imageIcon_mingcheng.setImage(imageIcon_mingcheng.getImage()
				.getScaledInstance(200, 60, Image.SCALE_DEFAULT));

		jLabel_xinxi = new JLabel(imageIcon_mingcheng);
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.weightx = 15;
		gridBagConstraints.weighty = 10;
		jLabel_xinxi.setFont(new java.awt.Font("Dialog", 1, 30));
		jLabel_xinxi.setForeground(Color.black);
		jPanel.add(jLabel_xinxi, gridBagConstraints);

		gridBagConstraints.fill = GridBagConstraints.BOTH;

		/**
		 * 演出厅的座位界面信息
		 */
		JScrollPane scrollPane = new JScrollPane(
				ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
		JPanel zuowei = zuowei();

		zuowei.revalidate();
		scrollPane.setViewportView(zuowei);
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.weightx = 60;
		gridBagConstraints.weighty = 200;

		jPanel.add(scrollPane, gridBagConstraints);

		/**
		 * 演出厅的信息 具体
		 */
		JScrollPane scrollPaneinfor = new JScrollPane(
				ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

		scrollPaneinfor.setOpaque(false);
		scrollPaneinfor.getViewport().setOpaque(false);
		JPanel jPanel4 = studioinformation();
		jPanel4.revalidate();
		scrollPaneinfor.setViewportView(jPanel4);
		jPanel4.setOpaque(false);
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		gridBagConstraints.weightx = 0;
		gridBagConstraints.weighty = 0;
		gridBagConstraints.weightx = 15;
		gridBagConstraints.weighty = 200;
		jPanel.add(jPanel4, gridBagConstraints);

		return jPanel;
	}

	/**
	 * 座位 的 鸟瞰图
	 *
	 * @return
	 */
	private JPanel zuowei() {
		// TODO Auto-generated method stub
		JPanel jPanel = new JPanel();
		jPanel.setOpaque(false);

		ImageIcon imageIcon_yuangongzengjia = new ImageIcon(
				Login.class.getResource("/com/today/images/yinmu.png"));
		imageIcon_yuangongzengjia.setImage(imageIcon_yuangongzengjia.getImage()
				.getScaledInstance(300, 70, Image.SCALE_DEFAULT));
		Insets insets = new Insets(2, 2, 2, 2);
		GridBagLayout gridBagLayout = new GridBagLayout();
		jPanel.setLayout(gridBagLayout);
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.insets = insets;
		/**
		 * 剧目修改的图片
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
		 * 剧目修改的 下操作界面
		 */
		jPanel_seat = new JPanel();
		seat = studioSeat(string_infor, jPanel_seat);
		jPanel_seat.setOpaque(false);
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.weightx = 200;
		gridBagConstraints.weighty = 200;
		jPanel.add(jPanel_seat, gridBagConstraints);

		return jPanel;
	}

	/**
	 * 座位生成
	 * @param studio_id
	 * @return
	 */
	public int[][] studioSeat(String studio_id,JPanel jPanel){
		int[][] seat;
		jPanel.setOpaque(false);
		List<StudioInformation> studioInformations = new ArrayList<StudioInformation>();
		Studio studio = new Studio();
		studioInformations = studio.prinfStudio(studio_id);
		String keyong = studioInformations.get(0).getStudio_isavailable();
		System.out.println(keyong);
		SeatMath seatMath = new SeatMath();
		seat = seatMath.seatMath(studioInformations.get(0).getStudio_id()
				, studioInformations.get(0).getStudio_row_count(),
				studioInformations.get(0).getStudio_col_count());

		if (keyong.equals("true")) {
			jPanel.setLayout(new GridLayout(seat.length, seat[0].length,5,5));
			jButtons = new JButton[seat.length][seat[0].length];
			for (int i = 0; i < seat.length; i++) {
				for (int j = 0; j < seat[0].length; j++) {
					if (seat[i][j] == 1) {
						ImageIcon imageIcon_hao = new ImageIcon(
								Login.class.getResource("/com/today/images/sunhuaizuowei.png"));
						imageIcon_hao.setImage(imageIcon_hao.getImage()
								.getScaledInstance(30, 30, Image.SCALE_DEFAULT));
						jButtons[i][j] = new JButton(imageIcon_hao);
						jButtons[i][j].setContentAreaFilled(false);
						jButtons[i][j].setName("1");
					}else {
						ImageIcon imageIcon_sun = new ImageIcon(
								Login.class.getResource("/com/today/images/zhengchangzuowei.png"));
						imageIcon_sun.setImage(imageIcon_sun.getImage()
								.getScaledInstance(30, 30, Image.SCALE_DEFAULT));
						jButtons[i][j] = new JButton(imageIcon_sun);
						jButtons[i][j].setContentAreaFilled(false);
						jButtons[i][j].setName("0");
					}
					jPanel.add(jButtons[i][j]);
					jButtons[i][j].addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent arg0) {
							// TODO Auto-generated method stub
							JButton button = (JButton) arg0.getSource();
							String s = button.getName();
							if (s.equals("1")) {
								ImageIcon imageIcon_sun = new ImageIcon(
										Login.class.getResource("/com/today/images/zuoweixuanzhong.png"));
								imageIcon_sun.setImage(imageIcon_sun.getImage()
										.getScaledInstance(30, 30, Image.SCALE_DEFAULT));
								button.setIcon(imageIcon_sun);
								button.setName("2");
							}else if(s.equals("2")){
								ImageIcon imageIcon_hao = new ImageIcon(
										Login.class.getResource("/com/today/images/sunhuaizuowei.png"));
								imageIcon_hao.setImage(imageIcon_hao.getImage()
										.getScaledInstance(30, 30, Image.SCALE_DEFAULT));
								button.setIcon(imageIcon_hao);
								button.setName("0");
							}else if(s.equals("0")){
								ImageIcon imageIcon_hao = new ImageIcon(
										Login.class.getResource("/com/today/images/sunhuaizuowei.png"));
								imageIcon_hao.setImage(imageIcon_hao.getImage()
										.getScaledInstance(30, 30, Image.SCALE_DEFAULT));
								button.setIcon(imageIcon_hao);
								button.setName("1");
							}

						}
					});

				}

			}
		}else {
			jPanel.setLayout(new GridLayout(3, 1));
			JPanel jPanel2 = new JPanel();
			jPanel2.setOpaque(false);
			ImageIcon imageIcon_hao = new ImageIcon(
					Login.class.getResource("/com/today/images/zanbukaifang.png"));
			imageIcon_hao.setImage(imageIcon_hao.getImage()
					.getScaledInstance(400, 70, Image.SCALE_DEFAULT));
			JLabel jLabel = new JLabel(imageIcon_hao);
			jPanel.add(jLabel);
		}
		return seat;
	}

	/**
	 * 座位的点击修改事件
	 */
	private void inforDinaJI(){
		/**
		 * 座位修改的点击事件设置
		 */
		jButton_infor_xiugai.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				for (int i = 0; i < jButtons.length; i++) {
					for (int j = 0; j < jButtons[0].length; j++) {
						String s = jButtons[i][j].getName();
						if (s.equals("2")) {
							ImageIcon imageIcon_sun = new ImageIcon(
									Login.class.getResource("/com/today/images/zhengchangzuowei.png"));
							imageIcon_sun.setImage(imageIcon_sun.getImage()
									.getScaledInstance(30, 30, Image.SCALE_DEFAULT));
							seat[i][j] = 0;
							jButtons[i][j].setIcon(imageIcon_sun);
						}else if (s.equals("0")) {
							ImageIcon imageIcon_sun = new ImageIcon(
									Login.class.getResource("/com/today/images/zhengchangzuowei.png"));
							imageIcon_sun.setImage(imageIcon_sun.getImage()
									.getScaledInstance(30, 30, Image.SCALE_DEFAULT));
							jButtons[i][j].setIcon(imageIcon_sun);
							seat[i][j] = 0;
						}else {
							ImageIcon imageIcon_sun = new ImageIcon(
									Login.class.getResource("/com/today/images/sunhuaizuowei.png"));
							imageIcon_sun.setImage(imageIcon_sun.getImage()
									.getScaledInstance(30, 30, Image.SCALE_DEFAULT));
							jButtons[i][j].setIcon(imageIcon_sun);
							seat[i][j] = 1;
						}
					}
				}
				SeatMath math = new SeatMath();
				if (math.changeSeat(seat, string_infor)) {
					JOptionPane.showMessageDialog(
							Administrator.jFrame_GuanLi.getContentPane(),
							"座位信修改成功!", "today修改系统信息",
							JOptionPane.WARNING_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(
							Administrator.jFrame_GuanLi.getContentPane(),
							"座位信修改失败!", "today修改系统信息",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});
	}

	/**
	 * 演出厅的 具体信息
	 *
	 * @return
	 */
	private JPanel studioinformation() {

		JPanel jPanel = new JPanel();
		jPanel.setLayout(new GridLayout(9, 1));

		/**
		 * 演出厅名称
		 */
		JPanel jPanelyou0 = new JPanel();
		jPanelyou0.setLayout(new FlowLayout());
		jPanelyou0.setOpaque(false);
		ImageIcon imageIcon_mingcheng = new ImageIcon(
				Login.class
						.getResource("/com/today/images/yanchutingmingcheng.png"));
		imageIcon_mingcheng.setImage(imageIcon_mingcheng.getImage()
				.getScaledInstance(200, 40, Image.SCALE_DEFAULT));
		JLabel jLabel_mingchengtu = new JLabel(imageIcon_mingcheng,
				JLabel.RIGHT);
		jPanelyou0.add(jLabel_mingchengtu);
		jPanelyou0.add(jTextField_infor_mingcheng);
		jPanel.add(jPanelyou0);

		jTextField_infor_hang.setEditable(false);
		jTextField_infor_infor.setEditable(false);
		jTextField_infor_lie.setEditable(false);
		jTextField_infor_keyong.setEditable(false);
		jTextField_infor_mingcheng.setEditable(false);
		/**
		 * 行数和列数
		 */
		// 行
		JPanel jPanel2 = new JPanel();
		jPanel2.setOpaque(false);
		jPanel2.setLayout(new GridLayout(1, 2));
		JPanel jPanelyou1 = new JPanel();
		jPanelyou1.setLayout(new FlowLayout());
		jPanelyou1.setOpaque(false);
		ImageIcon imageIcon_hang = new ImageIcon(
				Login.class.getResource("/com/today/images/hangshu.png"));
		imageIcon_hang.setImage(imageIcon_hang.getImage().getScaledInstance(80,
				40, Image.SCALE_DEFAULT));
		JLabel jLabel_hangtu = new JLabel(imageIcon_hang, JLabel.RIGHT);
		jPanelyou1.add(jLabel_hangtu);
		jPanelyou1.add(jTextField_infor_hang);
		jPanel2.add(jPanelyou1);
		// 列
		JPanel jPanelyou2 = new JPanel();
		jPanelyou2.setLayout(new FlowLayout());
		jPanelyou2.setOpaque(false);

		ImageIcon imageIcon_lie = new ImageIcon(
				Login.class.getResource("/com/today/images/lieshu.png"));
		imageIcon_lie.setImage(imageIcon_lie.getImage().getScaledInstance(80,
				40, Image.SCALE_DEFAULT));
		JLabel jLabel_lietu = new JLabel(imageIcon_lie, JLabel.RIGHT);
		jPanelyou2.add(jLabel_lietu);
		jPanelyou2.add(jTextField_infor_lie);
		jPanel2.add(jPanelyou2);
		jPanel.add(jPanel2);

		/**
		 * 是否可用 及其返回button
		 */
		JPanel jPanel3 = new JPanel();
		jPanel3.setOpaque(false);
		jPanel3.setLayout(new GridLayout(1, 2));
		// 是否可用
		JPanel jPanelyou3 = new JPanel();
		jPanelyou3.setLayout(new FlowLayout());
		jPanelyou3.setOpaque(false);
		ImageIcon imageIcon_keyong = new ImageIcon(
				Login.class.getResource("/com/today/images/keyong.png"));
		imageIcon_keyong.setImage(imageIcon_keyong.getImage()
				.getScaledInstance(80, 40, Image.SCALE_DEFAULT));
		JLabel jLabel_keyongtu = new JLabel(imageIcon_keyong, JLabel.RIGHT);
		jPanelyou3.add(jLabel_keyongtu);
		jPanelyou3.add(jTextField_infor_keyong);
		jPanel3.add(jPanelyou3);
		// 返回button
		/**
		 * 取消按钮
		 */
		JPanel jPanel41 = new JPanel();
		jPanel41.setOpaque(false);
		ImageIcon imageIcon_button = new ImageIcon(
				Login.class.getResource("/com/today/images/button.png"));
		imageIcon_button.setImage(imageIcon_button.getImage()
				.getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		jPanel41.setLayout(new FlowLayout(FlowLayout.LEFT));
		jButton_infor_quxiao = new JButton("返回", imageIcon_button);
		jButton_infor_quxiao.setContentAreaFilled(false);
		jButton_infor_quxiao.setForeground(Color.black);
		jPanel41.add(jButton_infor_quxiao);
		jPanelyou3.add(jPanel41);
		jPanel.add(jPanel3);

		// 简介
		ImageIcon imageIcon_yuangongzengjia = new ImageIcon(
				Login.class
						.getResource("/com/today/images/yanchutingjianjie.png"));
		imageIcon_yuangongzengjia.setImage(imageIcon_yuangongzengjia.getImage()
				.getScaledInstance(180, 40, Image.SCALE_DEFAULT));
		JLabel jLabel0 = new JLabel(imageIcon_yuangongzengjia);
		jPanel.add(jLabel0);

		// 边界框
		jPanel.add(jTextField_infor_infor);

		/**
		 * 座位的 状态 的
		 */
		ImageIcon imageIcon_hao = new ImageIcon(
				Login.class.getResource("/com/today/images/sunhuaizuowei.png"));
		imageIcon_hao.setImage(imageIcon_hao.getImage().getScaledInstance(50,
				50, Image.SCALE_DEFAULT));
		JLabel jLabel_hao = new JLabel(imageIcon_hao);
		jLabel_hao.setText(" ---- 座位正常");
		jLabel_hao.setFont(new java.awt.Font("Dialog", 1, 30));
		jLabel_hao.setForeground(Color.green);

		jPanel.add(jLabel_hao);

		ImageIcon imageIcon_sun = new ImageIcon(
				Login.class
						.getResource("/com/today/images/zhengchangzuowei.png"));
		imageIcon_sun.setImage(imageIcon_sun.getImage().getScaledInstance(50,
				50, Image.SCALE_DEFAULT));
		JLabel jLabel_sun = new JLabel(imageIcon_sun);
		jLabel_sun.setText(" ---- 座位损坏");
		jLabel_sun.setFont(new java.awt.Font("Dialog", 1, 30));
		jLabel_sun.setForeground(Color.red);

		jPanel.add(jLabel_sun);

		ImageIcon imageIcon_zhong = new ImageIcon(
				Login.class
						.getResource("/com/today/images/zuoweixuanzhong.png"));
		imageIcon_zhong.setImage(imageIcon_zhong.getImage().getScaledInstance(
				50, 50, Image.SCALE_DEFAULT));
		JLabel jLabel_zhong = new JLabel(imageIcon_zhong);
		jLabel_zhong.setText(" ---- 选中座位");
		jLabel_zhong.setFont(new java.awt.Font("Dialog", 1, 30));
		jLabel_zhong.setForeground(Color.green);

		jPanel.add(jLabel_zhong);

		JPanel jPanel42 = new JPanel();
		jPanel42.setOpaque(false);
		jPanel42.setLayout(new FlowLayout());
		jButton_infor_xiugai = new JButton("确认座位的修改", imageIcon_button);
		jButton_infor_xiugai.setContentAreaFilled(false);
		jButton_infor_xiugai.setForeground(Color.black);
		jButton_infor_xiugai.setFont(new java.awt.Font("Dialog", 1, 25));
		jPanel42.add(jButton_infor_xiugai);
		jPanel.add(jPanel42);

		return jPanel;
	}

	/**
	 * 剧院详细信息的点击事件
	 */
	private void formationDinaJi() {
		jButton_infor_quxiao.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

				setSelectedIndex(0);
			}
		});

		jButton_infor_xiugai.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});

	}

	/**
	 * 演出厅添加的 简介
	 *
	 * @return
	 */
	private JPanel jPanel_ScheduleAdd() {
		JPanel jPanel = new JPanel();
		jPanel.setOpaque(false);

		ImageIcon imageIcon_yuangongzengjia = new ImageIcon(
				Login.class
						.getResource("/com/today/images/yanchutingtianjia.png"));
		imageIcon_yuangongzengjia.setImage(imageIcon_yuangongzengjia.getImage()
				.getScaledInstance(400, 70, Image.SCALE_DEFAULT));
		Insets insets = new Insets(2, 2, 2, 2);
		GridBagLayout gridBagLayout = new GridBagLayout();
		jPanel.setLayout(gridBagLayout);
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.insets = insets;
		/**
		 * 演出厅添加的具体信息
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
		 * 演出厅添加的 信息
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
	 * 演出厅添加的 基本界面操作
	 *
	 * @return
	 */
	private JPanel scheduleAdd() {
		JPanel jPanel = new JPanel();
		jPanel.setLayout(new GridLayout(1, 2));

		JPanel jPanelzuo = new JPanel();
		jPanelzuo.setOpaque(false);
		ImageIcon imageIcon_yuangongzengjia = new ImageIcon(
				Login.class
						.getResource("/com/today/images/yanchutingjianjie.png"));
		imageIcon_yuangongzengjia.setImage(imageIcon_yuangongzengjia.getImage()
				.getScaledInstance(300, 70, Image.SCALE_DEFAULT));
		Insets insets = new Insets(2, 2, 2, 2);
		GridBagLayout gridBagLayout = new GridBagLayout();
		jPanelzuo.setLayout(gridBagLayout);
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.insets = insets;
		/**
		 * 演出厅标题
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
		jPanelzuo.add(jPanel_wei, gridBagConstraints);
		/**
		 * 演出厅添加的 信息
		 */

		gridBagConstraints.fill = GridBagConstraints.BOTH;
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.weightx = 200;
		gridBagConstraints.weighty = 200;
		jTextField_add_infor.setFont(new Font("Dialog", 0, 25));
		jPanelzuo.add(jTextField_add_infor, gridBagConstraints);
		jPanel.add(jPanelzuo);

		JPanel jPanel_you = new JPanel();
		jPanel_you.setLayout(new GridLayout(5, 1));
		jPanel_you.setOpaque(false);
		/**
		 * 名称
		 */
		JPanel jPanelyou0 = new JPanel();
		jPanelyou0.setLayout(new FlowLayout());
		jPanelyou0.setOpaque(false);
		ImageIcon imageIcon_mingcheng = new ImageIcon(
				Login.class
						.getResource("/com/today/images/yanchutingmingcheng.png"));
		imageIcon_mingcheng.setImage(imageIcon_mingcheng.getImage()
				.getScaledInstance(200, 40, Image.SCALE_DEFAULT));
		JLabel jLabel_mingchengtu = new JLabel(imageIcon_mingcheng,
				JLabel.RIGHT);
		jPanelyou0.add(jLabel_mingchengtu);
		jPanelyou0.add(jTextField_add_mingcheng);
		jPanel_you.add(jPanelyou0);
		/**
		 * 第er行
		 */
		JPanel jPanelyou1 = new JPanel();
		jPanelyou1.setLayout(new FlowLayout());
		jPanelyou1.setOpaque(false);
		ImageIcon imageIcon_hang = new ImageIcon(
				Login.class.getResource("/com/today/images/hangshu.png"));
		imageIcon_hang.setImage(imageIcon_hang.getImage().getScaledInstance(80,
				40, Image.SCALE_DEFAULT));
		JLabel jLabel_hangtu = new JLabel(imageIcon_hang, JLabel.RIGHT);
		jPanelyou1.add(jLabel_hangtu);
		jPanelyou1.add(jTextField_add_hang);

		jPanel_you.add(jPanelyou1);
		/**
		 * 第san行
		 */
		JPanel jPanelyou2 = new JPanel();
		jPanelyou2.setLayout(new FlowLayout());
		jPanelyou2.setOpaque(false);

		ImageIcon imageIcon_lie = new ImageIcon(
				Login.class.getResource("/com/today/images/lieshu.png"));
		imageIcon_lie.setImage(imageIcon_lie.getImage().getScaledInstance(80,
				40, Image.SCALE_DEFAULT));
		JLabel jLabel_lietu = new JLabel(imageIcon_lie, JLabel.RIGHT);
		jPanelyou2.add(jLabel_lietu);
		jPanelyou2.add(jTextField_add_lie);
		jPanel_you.add(jPanelyou2);

		/**
		 * 第四行
		 */
		JPanel jPanelyou3 = new JPanel();
		jPanelyou3.setLayout(new FlowLayout());
		jPanelyou3.setOpaque(false);
		ImageIcon imageIcon_keyong = new ImageIcon(
				Login.class.getResource("/com/today/images/keyong.png"));
		imageIcon_keyong.setImage(imageIcon_keyong.getImage()
				.getScaledInstance(80, 40, Image.SCALE_DEFAULT));
		JLabel jLabel_keyongtu = new JLabel(imageIcon_keyong, JLabel.RIGHT);
		jPanelyou3.add(jLabel_keyongtu);

		ImageIcon imageIcon_keyong1 = new ImageIcon(
				Login.class.getResource("/com/today/images/jckeyong.png"));
		imageIcon_keyong1.setImage(imageIcon_keyong1.getImage()
				.getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		ImageIcon imageIcon_bukeyong = new ImageIcon(
				Login.class.getResource("/com/today/images/jcbukeyong.png"));
		imageIcon_bukeyong.setImage(imageIcon_bukeyong.getImage()
				.getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		jComboBox_add_keyou = new JComboBox();
		jComboBox_add_keyou.setMaximumRowCount(2);
		// 设置 调用单元格
		jComboBox_add_keyou.setRenderer(new JComboBox_Item());
		jComboBox_add_keyou.setBackground(Color.black);
		jComboBox_add_keyou.setSize(60, 40);
		jComboBox_add_keyou.addItem(new Object[] { imageIcon_keyong1, "可用",
				"放映厅是否可以正常使用" });
		jComboBox_add_keyou.addItem(new Object[] { imageIcon_bukeyong, "不可用",
				"放映厅是否可以正常使用" });

		jPanelyou3.add(jComboBox_add_keyou);

		jPanel_you.add(jPanelyou3);

		/**
		 * 第五行
		 */
		JPanel jPanelyou4 = new JPanel();
		jPanelyou4.setLayout(new FlowLayout());
		jPanelyou4.setOpaque(false);
		jPanel_you.add(jPanelyou4);
		JPanel jPanel40 = new JPanel();
		jPanel40.setOpaque(false);
		jPanel40.setLayout(new FlowLayout(FlowLayout.RIGHT));
		ImageIcon imageIcon_button = new ImageIcon(
				Login.class.getResource("/com/today/images/button.png"));
		imageIcon_button.setImage(imageIcon_button.getImage()
				.getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		jButton_add_add = new JButton("添加", imageIcon_button);
		jButton_add_add.setContentAreaFilled(false);
		jButton_add_add.setForeground(Color.black);
		jPanel40.add(jButton_add_add);
		jPanelyou4.add(jPanel40);

		/**
		 * 取消按钮
		 */
		JPanel jPanel41 = new JPanel();
		jPanel41.setOpaque(false);
		jPanel41.setLayout(new FlowLayout(FlowLayout.LEFT));
		jButton_add_quxiao = new JButton("取消", imageIcon_button);
		jButton_add_quxiao.setContentAreaFilled(false);
		jButton_add_quxiao.setForeground(Color.black);
		jPanel41.add(jButton_add_quxiao);
		jPanelyou4.add(jPanel41);

		jPanel_you.add(jPanelyou4);
		jPanel.add(jPanel_you);
		return jPanel;
	}

	/**
	 * 演出厅添加的点击事件
	 */
	private void AddDianji() {
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
				String infor = jTextField_add_infor.getText();
				String name = jTextField_add_mingcheng.getText();
				String hang = jTextField_add_hang.getText();
				String lie = jTextField_add_lie.getText();
				boolean keyong = false;
				int a = jComboBox_add_keyou.getSelectedIndex();
				if (a == 0) {
					keyong = true;
				} else {
					keyong = false;
				}
				if (infor.equals("")) {
					JOptionPane.showMessageDialog(
							Administrator.jFrame_GuanLi.getContentPane(),
							"简介不能为空!", "today加添系统信息",
							JOptionPane.WARNING_MESSAGE);
				} else if (name.equals("")) {
					JOptionPane.showMessageDialog(
							Administrator.jFrame_GuanLi.getContentPane(),
							"名称不能为空!", "today加添系统信息",
							JOptionPane.WARNING_MESSAGE);
				} else if (hang.equals("")) {
					JOptionPane.showMessageDialog(
							Administrator.jFrame_GuanLi.getContentPane(),
							"行号不能为空!", "today加添系统信息",
							JOptionPane.WARNING_MESSAGE);
				} else if (lie.equals("")) {
					JOptionPane.showMessageDialog(
							Administrator.jFrame_GuanLi.getContentPane(),
							"列数不能为空!", "today加添系统信息",
							JOptionPane.WARNING_MESSAGE);
				} else {
					System.out.println("演出厅添加成功");
					Studio studio = new Studio();
					String studio_id = studio.studioAdd(name, hang, lie, infor, keyong);

						Seat seat = new Seat();
						for (int i = 1; i <= Integer.parseInt(hang); i++) {
							for (int j = 1; j <= Integer.parseInt(lie); j++) {
								if (seat.seatAdd(studio_id, ""+i, ""+j,""+ 1)) {
									System.out.println(studio_id+"--->座位添加成功");
								}
							}
						}

						JOptionPane.showMessageDialog(
								Administrator.jFrame_GuanLi.getContentPane(),
								"放映厅添加成功!", "today加添系统信息",
								JOptionPane.WARNING_MESSAGE);

				}

			}
		});
	}

	/**
	 * 演出厅修改
	 *
	 * @return
	 */
	private JPanel jPanel_ScheduleXiugai() {
		JPanel jPanel = new JPanel();
		jPanel.setOpaque(false);

		ImageIcon imageIcon_yuangongzengjia = new ImageIcon(
				Login.class
						.getResource("/com/today/images/yanchutingxiugai.png"));
		imageIcon_yuangongzengjia.setImage(imageIcon_yuangongzengjia.getImage()
				.getScaledInstance(420, 70, Image.SCALE_DEFAULT));
		Insets insets = new Insets(2, 2, 2, 2);
		GridBagLayout gridBagLayout = new GridBagLayout();
		jPanel.setLayout(gridBagLayout);
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.insets = insets;
		/**
		 * 剧目修改的图片
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
		 * 剧目修改的 下操作界面
		 */
		JPanel jPanel_nei = schedulexiugai();
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
	 * 演出厅修改的 基本界面操作
	 *
	 * @return
	 */
	private JPanel schedulexiugai() {
		JPanel jPanel = new JPanel();
		jPanel.setLayout(new GridLayout(1, 2));

		JPanel jPanelzuo = new JPanel();
		jPanelzuo.setOpaque(false);
		ImageIcon imageIcon_yuangongzengjia = new ImageIcon(
				Login.class
						.getResource("/com/today/images/yanchutingxiugai.png"));
		imageIcon_yuangongzengjia.setImage(imageIcon_yuangongzengjia.getImage()
				.getScaledInstance(300, 70, Image.SCALE_DEFAULT));
		Insets insets = new Insets(2, 2, 2, 2);
		GridBagLayout gridBagLayout = new GridBagLayout();
		jPanelzuo.setLayout(gridBagLayout);
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.insets = insets;
		/**
		 * 演出厅标题
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
		jPanelzuo.add(jPanel_wei, gridBagConstraints);
		/**
		 * 演出厅添加的 信息
		 */

		gridBagConstraints.fill = GridBagConstraints.BOTH;
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.weightx = 200;
		gridBagConstraints.weighty = 200;
		jTextField_xiugai_infor.setFont(new Font("Dialog", 0, 25));
		jPanelzuo.add(jTextField_xiugai_infor, gridBagConstraints);
		jPanel.add(jPanelzuo);

		JPanel jPanel_you = new JPanel();
		jPanel_you.setLayout(new GridLayout(5, 1));
		jPanel_you.setOpaque(false);
		/**
		 * 名称
		 */
		JPanel jPanelyou0 = new JPanel();
		jPanelyou0.setLayout(new FlowLayout());
		jPanelyou0.setOpaque(false);
		ImageIcon imageIcon_mingcheng = new ImageIcon(
				Login.class
						.getResource("/com/today/images/yanchutingmingcheng.png"));
		imageIcon_mingcheng.setImage(imageIcon_mingcheng.getImage()
				.getScaledInstance(200, 40, Image.SCALE_DEFAULT));
		JLabel jLabel_mingchengtu = new JLabel(imageIcon_mingcheng,
				JLabel.RIGHT);
		jPanelyou0.add(jLabel_mingchengtu);
		jPanelyou0.add(jTextField_xiugai_mingcheng);
		jPanel_you.add(jPanelyou0);
		/**
		 * 第er行
		 */
		JPanel jPanelyou1 = new JPanel();
		jPanelyou1.setLayout(new FlowLayout());
		jPanelyou1.setOpaque(false);
		ImageIcon imageIcon_hang = new ImageIcon(
				Login.class.getResource("/com/today/images/hangshu.png"));
		imageIcon_hang.setImage(imageIcon_hang.getImage().getScaledInstance(80,
				40, Image.SCALE_DEFAULT));
		JLabel jLabel_hangtu = new JLabel(imageIcon_hang, JLabel.RIGHT);
		jPanelyou1.add(jLabel_hangtu);
		jPanelyou1.add(jTextField_xiugai_hang);

		jPanel_you.add(jPanelyou1);
		/**
		 * 第san行
		 */
		JPanel jPanelyou2 = new JPanel();
		jPanelyou2.setLayout(new FlowLayout());
		jPanelyou2.setOpaque(false);

		ImageIcon imageIcon_lie = new ImageIcon(
				Login.class.getResource("/com/today/images/lieshu.png"));
		imageIcon_lie.setImage(imageIcon_lie.getImage().getScaledInstance(80,
				40, Image.SCALE_DEFAULT));
		JLabel jLabel_lietu = new JLabel(imageIcon_lie, JLabel.RIGHT);
		jPanelyou2.add(jLabel_lietu);
		jPanelyou2.add(jTextField_xiugai_lie);
		jPanel_you.add(jPanelyou2);

		/**
		 * 第四行
		 */
		JPanel jPanelyou3 = new JPanel();
		jPanelyou3.setLayout(new FlowLayout());
		jPanelyou3.setOpaque(false);
		ImageIcon imageIcon_keyong = new ImageIcon(
				Login.class.getResource("/com/today/images/keyong.png"));
		imageIcon_keyong.setImage(imageIcon_keyong.getImage()
				.getScaledInstance(80, 40, Image.SCALE_DEFAULT));
		JLabel jLabel_keyongtu = new JLabel(imageIcon_keyong, JLabel.RIGHT);
		jPanelyou3.add(jLabel_keyongtu);

		ImageIcon imageIcon_keyong1 = new ImageIcon(
				Login.class.getResource("/com/today/images/jckeyong.png"));
		imageIcon_keyong1.setImage(imageIcon_keyong1.getImage()
				.getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		ImageIcon imageIcon_bukeyong = new ImageIcon(
				Login.class.getResource("/com/today/images/jcbukeyong.png"));
		imageIcon_bukeyong.setImage(imageIcon_bukeyong.getImage()
				.getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		jComboBox_xiugai_keyou.setMaximumRowCount(2);
		// 设置 调用单元格
		jComboBox_xiugai_keyou.setRenderer(new JComboBox_Item());
		jComboBox_xiugai_keyou.setBackground(Color.black);
		jComboBox_xiugai_keyou.setSize(60, 40);
		jComboBox_xiugai_keyou.addItem(new Object[] { imageIcon_keyong1, "可用",
				"放映厅是否可以正常使用" });
		jComboBox_xiugai_keyou.addItem(new Object[] { imageIcon_bukeyong,
				"不可用", "放映厅是否可以正常使用" });

		jPanelyou3.add(jComboBox_xiugai_keyou);
		jPanel_you.add(jPanelyou3);

		/**
		 * 第五行
		 */
		JPanel jPanelyou4 = new JPanel();
		jPanelyou4.setLayout(new FlowLayout());
		jPanelyou4.setOpaque(false);
		jPanel_you.add(jPanelyou4);
		JPanel jPanel40 = new JPanel();
		jPanel40.setOpaque(false);
		jPanel40.setLayout(new FlowLayout(FlowLayout.RIGHT));
		ImageIcon imageIcon_button = new ImageIcon(
				Login.class.getResource("/com/today/images/button.png"));
		imageIcon_button.setImage(imageIcon_button.getImage()
				.getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		jButton_xiugai_xiugai = new JButton("修改", imageIcon_button);
		jButton_xiugai_xiugai.setContentAreaFilled(false);
		jButton_xiugai_xiugai.setForeground(Color.black);
		jPanel40.add(jButton_xiugai_xiugai);
		jPanelyou4.add(jPanel40);

		/**
		 * 取消按钮
		 */
		JPanel jPanel41 = new JPanel();
		jPanel41.setOpaque(false);
		jPanel41.setLayout(new FlowLayout(FlowLayout.LEFT));
		jButton_xiugai_quxiao = new JButton("取消", imageIcon_button);
		jButton_xiugai_quxiao.setContentAreaFilled(false);
		jButton_xiugai_quxiao.setForeground(Color.black);
		jPanel41.add(jButton_xiugai_quxiao);
		jPanelyou4.add(jPanel41);

		jPanel_you.add(jPanelyou4);
		jPanel.add(jPanel_you);
		return jPanel;
	}

	/**
	 * 修改的点击事件
	 */
	private void xiugaiDianji() {
		// 修改的点击事件
		jButton_xiugai_quxiao.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				setSelectedIndex(0);
			}
		});

		jButton_xiugai_xiugai.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String infor = jTextField_xiugai_infor.getText();
				String name = jTextField_xiugai_mingcheng.getText();
				String hang = jTextField_xiugai_hang.getText();
				String lie = jTextField_xiugai_lie.getText();
				String keyong = "" + false;
				int a = jComboBox_xiugai_keyou.getSelectedIndex();
				if (a == 0) {
					keyong = "" + true;
				} else {
					keyong = "" + false;
				}
				if (infor.equals("")) {
					JOptionPane.showMessageDialog(
							Administrator.jFrame_GuanLi.getContentPane(),
							"简介不能为空!", "today修改系统信息",
							JOptionPane.WARNING_MESSAGE);
				} else if (name.equals("")) {
					JOptionPane.showMessageDialog(
							Administrator.jFrame_GuanLi.getContentPane(),
							"名称不能为空!", "today修改系统信息",
							JOptionPane.WARNING_MESSAGE);
				} else if (hang.equals("")) {
					JOptionPane.showMessageDialog(
							Administrator.jFrame_GuanLi.getContentPane(),
							"行号不能为空!", "today修改系统信息",
							JOptionPane.WARNING_MESSAGE);
				} else if (lie.equals("")) {
					JOptionPane.showMessageDialog(
							Administrator.jFrame_GuanLi.getContentPane(),
							"列数不能为空!", "today修改系统信息",
							JOptionPane.WARNING_MESSAGE);
				} else {
					System.out.println("演出厅修改成功");
					Studio studio = new Studio();
					if (studio.studioXiuGai(name, hang, lie, infor, keyong,
							string_xiugai)) {
						System.out.println("string_xiugai = "+ string_xiugai);
						JOptionPane.showMessageDialog(
								Administrator.jFrame_GuanLi.getContentPane(),
								"放映厅修改成功!", "today修改系统信息",
								JOptionPane.WARNING_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(
								Administrator.jFrame_GuanLi.getContentPane(),
								"放映厅修改失败!", "today修改系统信息",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
	}

	/**
	 * jbutton 表格的删除
	 *
	 * @author lwp940118
	 *
	 */
	class JtableButtonDelet extends AbstractCellEditor implements
			TableCellEditor, TableCellRenderer, ActionListener {
		// 按钮的两种状态
		private JButton rb, eb;
		private int row;
		private JTable table;
		private String text = "删除";
		private ImageIcon imageIcon_shanchu = new ImageIcon(
				Login.class.getResource("/com/today/images/shanchu.png"));

		public JtableButtonDelet() {
		}

		public JtableButtonDelet(JTable table, int column) {
			super();
			this.table = table;
			imageIcon_shanchu.setImage(imageIcon_shanchu.getImage()
					.getScaledInstance(30, 30, Image.SCALE_DEFAULT));
			rb = new JButton("删除", imageIcon_shanchu);
			eb = new JButton("删除", imageIcon_shanchu);
			rb.setContentAreaFilled(false);
			eb.setContentAreaFilled(false);
			eb.setFont(new Font("Dialog", 0, 20));
			eb.setForeground(Color.black);
			rb.setFont(new Font("Dialog", 0, 20));
			rb.setForeground(Color.orange);
			eb.setFocusPainted(false);
			eb.addActionListener(this);
			// 设置该单元格渲染和编辑样式
			TableColumnModel columnModel = table.getColumnModel();
			columnModel.getColumn(column).setCellRenderer(this);
			columnModel.getColumn(column).setCellEditor(this);
		}

		@Override
		public Object getCellEditorValue() {
			// TODO Auto-generated method stub
			return null;
		}

		// 监听器方法
		@Override
		public void actionPerformed(ActionEvent arg0) {
			int v = Integer.parseInt(table.getValueAt(row, 0).toString());
			System.out.println("选中的值为：" + v);
			// 更新进度条 列的值
			String string = table.getValueAt(row, 0).toString();
			ImageIcon imageIcon_xinxixiugai = new ImageIcon(
					Login.class
							.getResource("/com/today/images/tuichujinggao.png"));
			imageIcon_xinxixiugai.setImage(imageIcon_xinxixiugai.getImage()
					.getScaledInstance(50, 50, Image.SCALE_DEFAULT));
			int option = JOptionPane.showConfirmDialog(null, "确认是否删除",
					"today系统提示", JOptionPane.YES_NO_OPTION,
					JOptionPane.WARNING_MESSAGE, imageIcon_xinxixiugai);
			switch (option) {
			case JOptionPane.YES_NO_OPTION: {
				Studio studio = new Studio();
				// System.out.println(string_xiugai);
				if (studio.DeleteStudio(string)) {
					 Seat seat = new Seat();
					 seat.DeleteSeat(string);
					JOptionPane
							.showMessageDialog(Administrator.jFrame_GuanLi
									.getContentPane(), "删除成功!", "today删除系统信息",
									JOptionPane.WARNING_MESSAGE);
				} else {
					JOptionPane
							.showMessageDialog(Administrator.jFrame_GuanLi
									.getContentPane(), "删除失败!", "today删除系统信息",
									JOptionPane.WARNING_MESSAGE);
				}
				break;
			}
			case JOptionPane.NO_OPTION: {
				System.out.println("不退出成功");
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
			// 编辑行，行号
			this.row = row;
			return eb;
		}
	}

	/**
	 * jbutton 表格的修改
	 *
	 * @author lwp940118
	 *
	 */
	class JtableButtonxiugai extends AbstractCellEditor implements
			TableCellEditor, TableCellRenderer, ActionListener {
		// 按钮的两种状态
		private JButton rb, eb;
		private int row;
		private JTable table;
		private String text = "修改";
		private ImageIcon imageIcon_shanchu = new ImageIcon(
				Login.class.getResource("/com/today/images/xiugai.png"));

		public JtableButtonxiugai() {
		}

		public JtableButtonxiugai(JTable table, int column) {
			super();
			this.table = table;
			imageIcon_shanchu.setImage(imageIcon_shanchu.getImage()
					.getScaledInstance(30, 30, Image.SCALE_DEFAULT));
			rb = new JButton("修改", imageIcon_shanchu);
			eb = new JButton("修改", imageIcon_shanchu);
			rb.setContentAreaFilled(false);
			eb.setContentAreaFilled(false);
			eb.setFocusPainted(false);
			eb.setFont(new Font("Dialog", 0, 20));
			eb.setForeground(Color.black);
			rb.setFont(new Font("Dialog", 0, 20));
			rb.setForeground(Color.decode(Integer.valueOf("960096", 16)
					.toString()));
			eb.addActionListener(this);
			// 设置该单元格渲染和编辑样式
			TableColumnModel columnModel = table.getColumnModel();
			columnModel.getColumn(column).setCellRenderer(this);
			columnModel.getColumn(column).setCellEditor(this);
		}

		@Override
		public Object getCellEditorValue() {
			// TODO Auto-generated method stub
			return null;
		}

		// 监听器方法
		@Override
		public void actionPerformed(ActionEvent arg0) {
			int v = Integer.parseInt(table.getValueAt(row, 0).toString());
			System.out.println("选中的值为：" + v);
			// 更新进度条 列的值
			String id = table.getValueAt(row, 0).toString();
			string_xiugai = table.getValueAt(row, 0).toString();
			Studio studio = new Studio();
			List<StudioInformation> list = studio.prinfStudio(id);

			jTextField_xiugai_infor.setText(list.get(0)
					.getStudio_introduction());
			jTextField_xiugai_mingcheng.setText(list.get(0).getStudio_name());
			jTextField_xiugai_hang.setText(list.get(0).getStudio_row_count());
			jTextField_xiugai_lie.setText(list.get(0).getStudio_col_count());
			String leixing = list.get(0).getStudio_isavailable();
			if (leixing.equals("true")) {
				jComboBox_xiugai_keyou.setSelectedIndex(0);
			} else {

				jComboBox_xiugai_keyou.setSelectedIndex(1);
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
			// 编辑行，行号
			this.row = row;
			return eb;
		}
	}

	/**
	 * jbutton 表格的详情
	 *
	 * @author lwp940118
	 *
	 */
	class JtableButtonxiangqing extends AbstractCellEditor implements
			TableCellEditor, TableCellRenderer, ActionListener {
		// 按钮的两种状态
		private JButton rb, eb;
		private int row;
		private JTable table;
		private String text = "详情";
		private ImageIcon imageIcon_shanchu = new ImageIcon(
				Login.class.getResource("/com/today/images/jumxiangqing.png"));

		public JtableButtonxiangqing() {
		}

		public JtableButtonxiangqing(JTable table, int column) {
			super();
			this.table = table;
			imageIcon_shanchu.setImage(imageIcon_shanchu.getImage()
					.getScaledInstance(30, 30, Image.SCALE_DEFAULT));
			rb = new JButton("详情", imageIcon_shanchu);
			eb = new JButton("详情", imageIcon_shanchu);
			rb.setContentAreaFilled(false);
			eb.setContentAreaFilled(false);
			eb.setFocusPainted(false);
			eb.addActionListener(this);
			eb.setFont(new Font("Dialog", 0, 20));
			eb.setForeground(Color.black);
			rb.setFont(new Font("Dialog", 0, 20));
			rb.setForeground(Color.GREEN);
			// 设置该单元格渲染和编辑样式
			TableColumnModel columnModel = table.getColumnModel();
			columnModel.getColumn(column).setCellRenderer(this);
			columnModel.getColumn(column).setCellEditor(this);
		}

		@Override
		public Object getCellEditorValue() {
			// TODO Auto-generated method stub
			return null;
		}

		// 监听器方法
		@Override
		public void actionPerformed(ActionEvent arg0) {
			int v = Integer.parseInt(table.getValueAt(row, 0).toString());
			System.out.println("选中的值为：" + v);
			// 更新进度条 列的值
			String id = table.getValueAt(row, 0).toString();
			string_infor = table.getValueAt(row, 0).toString();
			Studio studio = new Studio();
			List<StudioInformation> list = studio.prinfStudio(id);
			jLabel_niaokantu.setText(list.get(0).getStudio_name()+"放映厅鸟瞰图");
			jTextField_infor_infor
					.setText(list.get(0).getStudio_introduction());
			jTextField_infor_mingcheng.setText(list.get(0).getStudio_name());
			jTextField_infor_hang.setText(list.get(0).getStudio_row_count());
			jTextField_infor_lie.setText(list.get(0).getStudio_col_count());
			jTextField_infor_keyong
					.setText(list.get(0).getStudio_isavailable());
			jPanel_seat.removeAll();
			seat = studioSeat(string_infor,jPanel_seat);
////			jPanel_seat = new StudioSeat(string_infor);
			jPanel_seat.updateUI();
			jPanel_seat.validate();
			jPanel_seat.repaint();
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
			// 编辑行，行号
			this.row = row;
			return eb;
		}
	}

	// 自定义表格模型
	class MyTableModel extends AbstractTableModel {
		// 单元格元素类型
		private Class[] cellType = { String.class, String.class, String.class,
				String.class, String.class, JButton.class, JButton.class,
				JButton.class };
		// 表头
		private String title[] = { "放映厅id", "名称", "行数", "列数", "是否可用", "修改",
				"详情", "删除" };
		// 模拟数据
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

		// 重写isCellEditable方法
		public boolean isCellEditable(int r, int c) {
			return true;
		}

		// 重写setValueAt方法
		public void setValueAt(Object value, int r, int c) {
			data.get(r)[c] = value;
			this.fireTableCellUpdated(r, c);
		}
	}

	class StudioInformationjp extends JPanel {

		public StudioInformationjp() {
			setOpaque(false);
			setLayout(new BorderLayout());
			/**
			 * 员工数据入口
			 */
			studioShuJuRuKou();
			model = new MyTableModel(data);
			table = new JTable(model);
			// 插入单元格元素，采用自定义元素
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
			 * TableColumn column = table.getColumnModel().getColumn(2); // 第 2
			 * 列 column.setPreferredWidth(getPreferredWidthForColumn(column));
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
	 * 剧目的和 数据入口
	 */
	private void studioShuJuRuKou() {
		Studio studio = new Studio();
		studioInformations = studio.prinfStudios();

		for (int i = 0; i < studioInformations.size(); i++) {
			Object[] objects = new Object[8];
			objects[5] = new JButton();
			objects[6] = new JButton();
			objects[7] = new JButton();
			objects[0] = studioInformations.get(i).getStudio_id();
			objects[1] = studioInformations.get(i).getStudio_name();
			objects[2] = studioInformations.get(i).getStudio_row_count();
			objects[3] = studioInformations.get(i).getStudio_col_count();
			objects[4] = studioInformations.get(i).getStudio_isavailable();
			data.add(objects);
		}

	}

}
