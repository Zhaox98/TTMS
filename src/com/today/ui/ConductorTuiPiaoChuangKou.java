package com.today.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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

import com.today.ui.AdministratorSchedule.JtableButtonDelet;
import com.today.ui.AdministratorSchedule.JtableButtonxiangqing;
import com.today.ui.AdministratorSchedule.JtableButtonxiugai;
import com.today.ui.AdministratorSchedule.MyTableModel;
import com.today.ui.AdministratorSchedule.PlayInformationjp;
import com.today.ui.AdministratorYuanGongGuanLi.EmployeesInformation;
import com.xy.today.sql.Employee;
import com.xy.today.sql.Play;
import com.xy.today.sql.Schedule;
import com.xy.today.sql.Schedule_Time;
import com.xy.today.sql.Studio;
import com.xy.today.sql.Ticket;
import com.xy.today.util.PlayInformation;
import com.xy.today.util.ScheduleInformation;
import com.xy.today.util.Schedule_TimeInformation;
import com.xy.today.util.StudioInformation;
import com.xy.today.util.TcketInformation;

/**
 * 退票窗口的一些 信息
 *
 * @author lwp940118
 *
 */
public class ConductorTuiPiaoChuangKou extends JTabbedPane {

	/**
	 * 演出厅 的信息
	 */
	private List<StudioInformation> studioInformations = new ArrayList<StudioInformation>();

	/**
	 * 剧目的信息
	 */
	private List<PlayInformation> playInformations = new ArrayList<PlayInformation>();
	/**
	 * 时间 的信息
	 */
	private List<Schedule_TimeInformation> timeInformations = new ArrayList<Schedule_TimeInformation>();

	/**
	 * 查找的 jtextfiled
	 */
	private JTextField jTextField_search;

	/**
	 * 查找的 jbutton
	 */
	private JButton jButton_search;
	/**
	 * play表格
	 */
	private JTable table;

	/**
	 * 剧目 具体信息的操作表格
	 */
	private List<Object[]> data = new ArrayList<Object[]>();
	private List<ScheduleInformation> scheduleInformations = new ArrayList<ScheduleInformation>();

	private List<TcketInformation> tcketInformations = new ArrayList<TcketInformation>();
	/**
	 * 自定义表格模式
	 */
	private MyTableModel model;

	private String xiangqing_id;
	private String xiangqing_mingcheng;
	// //------>
	/**
	 * 查找的 jtextfiled
	 */
	private JTextField jTextField_search_tui;

	/**
	 * 查找的 jbutton
	 */
	private JButton jButton_search_tui;

	/**
	 * 员工 具体信息的操作表格
	 */
	private List<Object[]> data_tui = new ArrayList<Object[]>();

	/**
	 * 自定义表格模式
	 */
	private MyTableModel_tui model_tui;
	/**
	 *
	 */
	private JTable table_tui;
	private JButton jButton_back_Schedule;

	/**
	 * 退票窗口的设置 分为 卖出票查看 和 退票 的 两个窗口
	 */
	public ConductorTuiPiaoChuangKou() {

		/**
		 * 售票情况的列表展示
		 */
		addShuJuRuKou();
		ImageIcon imageIcon_shoupiaoqingkuang = new ImageIcon(
				Login.class
						.getResource("/com/today/images/shoupiaoqingkuang.png"));
		imageIcon_shoupiaoqingkuang.setImage(imageIcon_shoupiaoqingkuang
				.getImage().getScaledInstance(120, 40, Image.SCALE_DEFAULT));
		addTab("", imageIcon_shoupiaoqingkuang, jPanel_shoupiaoQingkuang());
		listDianJiShiJian();
		/**
		 * 场次买票详情
		 */
		ImageIcon imageIcon_maipiao = new ImageIcon(
				Login.class.getResource("/com/today/images/maipiao.png"));
		imageIcon_maipiao.setImage(imageIcon_maipiao.getImage()
				.getScaledInstance(120, 40, Image.SCALE_DEFAULT));
		addTab("", imageIcon_maipiao, jPanel_maipiao());
		lieBiaoJianJieDianJiShiJian();

	}

	/**
	 * 售票的展示界面
	 *
	 * @return
	 */
	private JPanel jPanel_shoupiaoQingkuang() {
		JPanel jPanel = new JPanel();
		jPanel.setOpaque(false);

		ImageIcon imageIcon_yuangongzengjia = new ImageIcon(
				Login.class
						.getResource("/com/today/images/shoupiaoqingkuangliebiao.png"));
		imageIcon_yuangongzengjia.setImage(imageIcon_yuangongzengjia.getImage()
				.getScaledInstance(460, 70, Image.SCALE_DEFAULT));
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
	 * 演出额详情
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
		/**
		 * 查找的 jpanel 剥壳 idettext和 button
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
		jPanel.add(jPanel_wei, gridBagConstraints);

		/**
		 * 员工简介的列表
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
					Ticket ticket = new Ticket();
					for (int i = 0; i < scheduleInformations.size(); i++) {
						for (int j = 0; j < playInformations.size(); j++) {
							if (playInformations.get(j).getPlay_name()
									.contains(string_search)) {
								String id = playInformations.get(j)
										.getPlay_id();
								if (scheduleInformations.get(i).getPlay_id()
										.equals(id)) {
									Object[] objects = new Object[7];
									objects[6] = new JButton();
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
									tcketInformations.remove(tcketInformations);
									tcketInformations = ticket
											.prinfmaipiao(scheduleInformations
													.get(i).getSched_id());
									objects[5] = tcketInformations.size() + "";
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

	}

	/**
	 * 买票详情
	 *
	 * @return
	 */
	private JPanel jPanel_maipiao() {
		JPanel jPanel = new JPanel();
		jPanel.setOpaque(false);

		ImageIcon imageIcon_yuangongzengjia = new ImageIcon(
				Login.class.getResource("/com/today/images/maipiao.png"));
		imageIcon_yuangongzengjia.setImage(imageIcon_yuangongzengjia.getImage()
				.getScaledInstance(320, 70, Image.SCALE_DEFAULT));
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
		JPanel jPanel_nei = yuanGongLieBiao();
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
	 * 添加 的数据入口
	 */
	private void addShuJuRuKou() {
		Studio studio = new Studio();
		studioInformations = studio.prinfStudios();

		Play play = new Play();
		playInformations = play.prinfPlays();

		Schedule_Time schedule_Time = new Schedule_Time();
		timeInformations = schedule_Time.prinfTimes();

	}


	/**
	 * today 剧院人员管理 的 信息列表 及其 一表格的形式展现出来
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
		 * 查找的 jpanel 剥壳 idettext和 button
		 */
		JPanel jPanel_wei = new JPanel();
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.weightx = 200;
		gridBagConstraints.weighty = 10;
		jPanel_wei.setOpaque(false);
		jPanel_wei.setLayout(new FlowLayout());
		jTextField_search_tui = new JTextField(20);
		jTextField_search_tui.setOpaque(false);
		jTextField_search_tui.setForeground(Color.red);
		jPanel_wei.add(jTextField_search_tui);
		jButton_search_tui = new JButton(imageIcon_search);
		jButton_search_tui.setContentAreaFilled(false);
		jPanel_wei.add(jButton_search_tui);
		/**
		 * 添加图片
		 */
		ImageIcon imageIcon_back = new ImageIcon(
				Login.class.getResource("/com/today/images/back.png"));
		imageIcon_back.setImage(imageIcon_back.getImage()
				.getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		jButton_back_Schedule = new JButton(imageIcon_back);
		jButton_back_Schedule.setContentAreaFilled(false);
		jPanel_wei.add(jButton_back_Schedule);
		jPanel.add(jPanel_wei, gridBagConstraints);

		/**
		 * 员工简介的列表
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

	// 自定义表格模型
	class MyTableModel extends AbstractTableModel {
		// 单元格元素类型
		private Class[] cellType = { String.class, String.class, String.class,
				String.class, String.class, JButton.class };
		// 表头
		private String title[] = { "演出计划id", "放映厅", "剧目名称", "时间", "票价", "售票数",
				"详情" };
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
			xiangqing_id = table.getValueAt(row, 0).toString();
			xiangqing_mingcheng = table.getValueAt(row, 1).toString();
			data_tui.removeAll(data_tui);
			YuanGongShuJuRuKou();
			model_tui.fireTableDataChanged();

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

	class PlayInformationjp extends JPanel {

		public PlayInformationjp() {
			setOpaque(false);
			setLayout(new BorderLayout());
			/**
			 * 员工数据入口
			 */
			scheduleShuJuRuKou();
			model = new MyTableModel(data);
			table = new JTable(model);
			// 插入单元格元素，采用自定义元素
			JtableButtonxiangqing xiang = new JtableButtonxiangqing(table, 6);
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
	private void scheduleShuJuRuKou() {
		Schedule schedule = new Schedule();
		scheduleInformations = schedule.prinfSchedules();
		Ticket ticket = new Ticket();
		for (int i = 0; i < scheduleInformations.size(); i++) {
			Object[] objects = new Object[7];
			objects[6] = new JButton();
			objects[0] = scheduleInformations.get(i).getSched_id();
			String fangyinting = scheduleInformations.get(i).getStudio_id();
			// System.out.println("---->"+scheduleInformations.get(i).getStudio_id());
			for (int j = 0; j < studioInformations.size(); j++) {
				if (studioInformations.get(j).getStudio_id()
						.contains(fangyinting)) {
					objects[1] = studioInformations.get(j).getStudio_name();
				}
			}
			tcketInformations = ticket.prinfmaipiao(scheduleInformations.get(i)
					.getSched_id());
			objects[5] = tcketInformations.size() + "";

			String jumu = scheduleInformations.get(i).getPlay_id();
			//System.out.println("???"+jumu);
			for (int j = 1; j < playInformations.size(); j++) {

				if (playInformations.get(j).getPlay_id().contains(jumu)) {
					objects[2] = playInformations.get(j).getPlay_name();
				}
			}
			objects[3] = scheduleInformations.get(i).getSched_time();
			objects[4] = scheduleInformations.get(i).getSched_ticket_price();
			data.add(objects);
		}

	}

	// 自定义表格模型
	class MyTableModel_tui extends AbstractTableModel {
		// 单元格元素类型
		private Class[] cellType = { String.class, String.class, String.class,
				JButton.class };
		// 表头
		private String title[] = { "票号","电影名称", "票价", "退票" };
		// 模拟数据
		private List<Object[]> data = new ArrayList<Object[]>();

		public MyTableModel_tui(List<Object[]> data) {
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

	/**
	 * jbutton 表格的删除
	 *
	 * @author lwp940118
	 *
	 */
	class JtableButtonDelet_tui extends AbstractCellEditor implements
			TableCellEditor, TableCellRenderer, ActionListener {
		// 按钮的两种状态
		private JButton rb, eb;
		private int row;
		private JTable table;
		private String text = "退票";
		private ImageIcon imageIcon_shanchu = new ImageIcon(
				Login.class.getResource("/com/today/images/shanchu.png"));

		public JtableButtonDelet_tui() {
		}

		public JtableButtonDelet_tui(JTable table, int column) {
			super();
			this.table = table;
			imageIcon_shanchu.setImage(imageIcon_shanchu.getImage()
					.getScaledInstance(30, 30, Image.SCALE_DEFAULT));
			rb = new JButton("退票", imageIcon_shanchu);
			eb = new JButton("退票", imageIcon_shanchu);
			rb.setContentAreaFilled(false);
			eb.setContentAreaFilled(false);
			eb.setFocusPainted(false);
			eb.setFont(new Font("Dialog", 0, 20));
			eb.setForeground(Color.black);
			rb.setFont(new Font("Dialog", 0, 20));
			rb.setForeground(Color.orange);
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
			String ticket_id = table.getValueAt(row, 0).toString();
			// 更新进度条 列的值
			Ticket ticket = new Ticket();
			if (ticket.ticketTuipiao(ticket_id)) {
				JOptionPane.showMessageDialog(
						Administrator.jFrame_GuanLi.getContentPane(),
						"退票成功\n您将获得 "+table.getValueAt(row, 2).toString()+
						" 元！", "today退票系统信息",
						JOptionPane.WARNING_MESSAGE);

				data_tui.removeAll(data_tui);
				YuanGongShuJuRuKou();
				model_tui.fireTableDataChanged();
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

	class EmployeesInformation extends JPanel {

		public EmployeesInformation() {
			setOpaque(false);
			setLayout(new BorderLayout());
			/**
			 * 员工数据入口
			 */
			YuanGongShuJuRuKou();
			model_tui = new MyTableModel_tui(data_tui);
			table_tui = new JTable(model_tui);
			// 插入单元格元素，采用自定义元素
			//JtableButtonxiangqing_tui xiangqing = new JtableButtonxiangqing(table_tui,
					//5);
			JtableButtonDelet_tui delet = new JtableButtonDelet_tui(table_tui, 3);
			table_tui.setRowHeight(50);

			table_tui.getTableHeader().setFont(new Font("Dialog", 0, 30));
			table_tui.getTableHeader().setForeground(Color.blue);
			table_tui.getTableHeader().setOpaque(false);

			table_tui.setFont(new Font("Dialog", 0, 20));
			table_tui.setForeground(Color.black);
			table_tui.setOpaque(false);

			/*
			 * TableColumn column = table.getColumnModel().getColumn(2); // 第 2
			 * 列 column.setPreferredWidth(getPreferredWidthForColumn(column));
			 */
			DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
			renderer.setOpaque(false);
			renderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
			table_tui.setDefaultRenderer(Object.class, renderer);
			JScrollPane jsp = new JScrollPane(table_tui);
			jsp.setOpaque(false);
			jsp.getViewport().setOpaque(false);

			add(BorderLayout.CENTER, jsp);

		}
	}

	/**
	 * 人员列表的简介事件
	 */
	private void lieBiaoJianJieDianJiShiJian() {
		/**
		 * 搜索button的 点击事件设置
		 */
		jButton_search_tui.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String string_search = jTextField_search_tui.getText();

				if (!string_search.equals("")) {
					data_tui.removeAll(data_tui);
					for (int i = 0; i < tcketInformations.size(); i++) {
						if (tcketInformations.get(i).getTicket_id()
								.contains(string_search)){
						Object[] objects = new Object[4];
						objects[3] = new JButton();
						objects[0] = tcketInformations.get(i).getTicket_id();

						objects[1] = xiangqing_mingcheng;
						objects[2] = tcketInformations.get(i).getTicket_price();
						data_tui.add(objects);
						}
					}
					if (data_tui.size() != 0) {
						model_tui.fireTableDataChanged();
					}
				} else {
					data_tui.removeAll(data_tui);
					YuanGongShuJuRuKou();
					model_tui.fireTableDataChanged();

				}
			}
		});

		jButton_back_Schedule.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setSelectedIndex(0);
			}
		});

	}

	/**
	 * 员工和 数据入口
	 */
	private void YuanGongShuJuRuKou() {
		Ticket ticket = new Ticket();
		tcketInformations = ticket.prinfmaipiao(xiangqing_id);
		for (int i = 0; i < tcketInformations.size(); i++) {
			Object[] objects = new Object[4];
			objects[3] = new JButton();
			objects[0] = tcketInformations.get(i).getTicket_id();

			objects[1] = xiangqing_mingcheng;
			objects[2] = tcketInformations.get(i).getTicket_price();
			data_tui.add(objects);
		}

	}


}
