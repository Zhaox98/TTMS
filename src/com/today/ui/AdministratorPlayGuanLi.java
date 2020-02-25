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
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
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

import com.xy.today.mycontrols.JComboBox_Item;
import com.xy.today.sql.Play;
import com.xy.today.util.PlayInformation;

/**
 * 剧目管理 的界面
 * 
 * @author lwp940118
 * 
 */
public class AdministratorPlayGuanLi extends JTabbedPane {

	/**
	 * 剧目添加的 一些 控件的 信息设置
	 */
	private JTextField jTextField_add_name = new JTextField(15);
	private JTextField jTextField_add_shichang = new JTextField(15);
	private JTextField jTextField_add_infor = new JTextField(15);
	private JTextField jTextField_add_piaojia = new JTextField(15);
	private JComboBox jComboBox_add_leixing;
	private JComboBox jComboBox_add_yuyan;
	private JComboBox jComboBox_add_zhuangtai;
	private JButton jButton_add_add;
	private JButton jButton_add_quxiao;
	private JButton jButton_add_image;
	private JLabel jLabel_add_image;
	private String string_add_image = "movie.png";

	/**
	 * 剧目修改的 一些 控件的 信息设置
	 */
	private JTextField jTextField_xiugai_name = new JTextField(15);
	private JTextField jTextField_xiugai_shichang = new JTextField(15);
	private JTextField jTextField_xiugai_infor = new JTextField(15);
	private JTextField jTextField_xiugai_piaojia = new JTextField(15);
	private JComboBox jComboBox_xiugai_leixing;
	private JComboBox jComboBox_xiugai_yuyan;
	private JComboBox jComboBox_xiugai_zhuangtai;
	private JButton jButton_xiugai_add;
	private JButton jButton_xiugai_quxiao;
	private JButton jButton_xiugai_image;
	private JLabel jLabel_xiugai_image;
	private String string_xiugai_image = "movie.png";
	private String stringid = "";
	
	/**
	 * 剧目详情的 一些 控件的 信息设置
	 */
	private JTextField jTextField_xiangqing_name = new JTextField(15);
	private JTextField jTextField_xiangqing_shichang = new JTextField(15);
	private JTextField jTextField_xiangqing_infor = new JTextField(15);
	private JTextField jTextField_xiangqing_piaojia = new JTextField(15);
	private JComboBox jComboBox_xiangqing_leixing;
	private JComboBox jComboBox_xiangqing_yuyan;
	private JComboBox jComboBox_xiangqing_zhuangtai;
	private JButton jButton_xiangqing_add;
	private JButton jButton_xiangqing_quxiao;
	private JButton jButton_xiangqing_image;
	private JLabel jLabel_xiangqing_image;
	private String string_xiangqing_image = "movie.png";
	private String stringxiangqingid = "";
	
	/**
	 * 查找的 jtextfiled
	 */
	private JTextField jTextField_search;

	/**
	 * 查找的 jbutton
	 */
	private JButton jButton_search;
	private JButton jButton_add;
	/**
	 * play表格
	 */
	private JTable table;

	/**
	 * 剧目 具体信息的操作表格
	 */
	private List<Object[]> data = new ArrayList<Object[]>();
	private List<PlayInformation> playInformations = new ArrayList<PlayInformation>();

	/**
	 * 自定义表格模式
	 */
	private MyTableModel model;

	public AdministratorPlayGuanLi() {
		setOpaque(false);
		setTabPlacement(JTabbedPane.TOP);

		/**
		 * 剧目信息简介
		 */
		ImageIcon imageIcon_palyInfor = new ImageIcon(
				Login.class.getResource("/com/today/images/jumuxinxi.png"));
		imageIcon_palyInfor.setImage(imageIcon_palyInfor.getImage()
				.getScaledInstance(120, 40, Image.SCALE_DEFAULT));
		addTab("", imageIcon_palyInfor, jPanel_xinxi());
		lieBiaoJianJieDianJiShiJian();
		
		/**
		 * 剧目详情简介
		 */
		ImageIcon imageIcon_palyxinagqing = new ImageIcon(
				Login.class.getResource("/com/today/images/jumuxiangqing.png"));
		imageIcon_palyInfor.setImage(imageIcon_palyInfor.getImage()
				.getScaledInstance(120, 40, Image.SCALE_DEFAULT));
		addTab("", imageIcon_palyInfor, jPanel_xiangqing());

		/**
		 * 剧目添加
		 */
		ImageIcon imageIcon_palyAdd = new ImageIcon(
				Login.class.getResource("/com/today/images/tianjiajumu.png"));
		imageIcon_palyAdd.setImage(imageIcon_palyAdd.getImage()
				.getScaledInstance(120, 40, Image.SCALE_DEFAULT));
		addTab("", imageIcon_palyAdd, jPanel_add());
		addDianJi();

		/**
		 * 剧目修改
		 */
		ImageIcon imageIcon_palyxiugai = new ImageIcon(
				Login.class.getResource("/com/today/images/xiugaijumu.png"));
		imageIcon_palyxiugai.setImage(imageIcon_palyxiugai.getImage()
				.getScaledInstance(120, 40, Image.SCALE_DEFAULT));
		addTab("", imageIcon_palyxiugai, jPanel_xiugai());
		xiugaiDianji();

	}

	/**
	 * 剧目添加
	 * 
	 * @return
	 */
	private JPanel jPanel_add() {
		JPanel jPanel = new JPanel();
		jPanel.setOpaque(false);
		ImageIcon imageIcon_yuangongzengjia = new ImageIcon(
				Login.class.getResource("/com/today/images/tianjiajumu.png"));
		imageIcon_yuangongzengjia.setImage(imageIcon_yuangongzengjia.getImage()
				.getScaledInstance(300, 70, Image.SCALE_DEFAULT));
		Insets insets = new Insets(2, 2, 2, 2);
		GridBagLayout gridBagLayout = new GridBagLayout();
		jPanel.setLayout(gridBagLayout);
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.insets = insets;
		/**
		 * 剧目增加的图片
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
		 * 剧目增加的 下操作界面
		 */
		JPanel jPanel_nei = play_add();
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
	 * 剧目增加
	 * 
	 * @return
	 */
	private JPanel play_add() {
		// TODO Auto-generated method stub
		JPanel jPanel = new JPanel();
		jPanel.setLayout(new GridLayout(4, 1));
		/**
		 * 第一行
		 */
		JPanel jPanel0 = new JPanel();
		jPanel0.setOpaque(false);
		jPanel0.setLayout(new GridLayout(1, 3));
		/**
		 * 剧目名称
		 */
		JPanel jPanel00 = new JPanel();
		jPanel00.setOpaque(false);
		jPanel00.setLayout(new FlowLayout());
		// 工号图片
		ImageIcon imageIcon_mingcheng = new ImageIcon(
				Login.class.getResource("/com/today/images/jumuname.png"));
		imageIcon_mingcheng.setImage(imageIcon_mingcheng.getImage()
				.getScaledInstance(160, 40, Image.SCALE_DEFAULT));
		JLabel jLabel_mingchengtu = new JLabel(imageIcon_mingcheng,
				JLabel.RIGHT);
		jPanel00.add(jLabel_mingchengtu);
		jPanel00.add(jTextField_add_name);
		jPanel0.add(jPanel00);

		/**
		 * 语言
		 */
		JPanel jPanel01 = new JPanel();
		jPanel01.setOpaque(false);
		jPanel01.setLayout(new FlowLayout());
		/**
		 * 语言选择s
		 */
		ImageIcon imageIcon_hanyu = new ImageIcon(
				Login.class.getResource("/com/today/images/hanyu.png"));
		imageIcon_hanyu.setImage(imageIcon_hanyu.getImage().getScaledInstance(
				30, 30, Image.SCALE_DEFAULT));
		ImageIcon imageIcon_yingyu = new ImageIcon(
				Login.class.getResource("/com/today/images/yingyu.png"));
		imageIcon_yingyu.setImage(imageIcon_yingyu.getImage()
				.getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		ImageIcon imageIcon_yuyan = new ImageIcon(
				Login.class.getResource("/com/today/images/yuyan.png"));
		imageIcon_yuyan.setImage(imageIcon_yuyan.getImage().getScaledInstance(
				80, 40, Image.SCALE_DEFAULT));
		JLabel jLabel_yuyan = new JLabel(imageIcon_yuyan, JLabel.RIGHT);
		jPanel01.add(jLabel_yuyan);

		jComboBox_add_yuyan = new JComboBox();
		jComboBox_add_yuyan.setMaximumRowCount(2);
		// 设置 调用单元格
		jComboBox_add_yuyan.setRenderer(new JComboBox_Item());
		jComboBox_add_yuyan.setBackground(Color.black);
		jComboBox_add_yuyan.setSize(60, 40);
		jComboBox_add_yuyan.addItem(new Object[] { imageIcon_hanyu, "汉语",
				"人类语言" });
		jComboBox_add_yuyan.addItem(new Object[] { imageIcon_yingyu, "英语",
				"人类语言" });
		jPanel01.add(jComboBox_add_yuyan);
		jPanel0.add(jPanel01);

		/**
		 * 性别
		 */
		JPanel jPanel02 = new JPanel();
		jPanel02.setOpaque(false);
		jPanel02.setLayout(new FlowLayout());
		/**
		 * 性别选择s
		 */
		ImageIcon imageIcon_jingsong = new ImageIcon(
				Login.class.getResource("/com/today/images/jumuleixing.png"));
		imageIcon_jingsong.setImage(imageIcon_jingsong.getImage()
				.getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		ImageIcon imageIcon_xiju = new ImageIcon(
				Login.class.getResource("/com/today/images/xiju.png"));
		imageIcon_xiju.setImage(imageIcon_xiju.getImage().getScaledInstance(30,
				30, Image.SCALE_DEFAULT));
		ImageIcon imageIcon_leixing = new ImageIcon(
				Login.class.getResource("/com/today/images/leixing.png"));
		imageIcon_leixing.setImage(imageIcon_leixing.getImage()
				.getScaledInstance(80, 40, Image.SCALE_DEFAULT));
		JLabel jLabel_xingbie = new JLabel(imageIcon_leixing, JLabel.RIGHT);
		jPanel02.add(jLabel_xingbie);
		jComboBox_add_leixing = new JComboBox();
		jComboBox_add_leixing.setMaximumRowCount(2);
		// 设置 调用单元格
		jComboBox_add_leixing.setRenderer(new JComboBox_Item());
		jComboBox_add_leixing.setBackground(Color.black);
		jComboBox_add_leixing.setSize(60, 40);
		jComboBox_add_leixing.addItem(new Object[] { imageIcon_jingsong, "惊悚",
				"电影类型" });
		jComboBox_add_leixing.addItem(new Object[] { imageIcon_xiju, "喜剧",
				"电影类型" });
		jPanel02.add(jComboBox_add_leixing);
		jPanel0.add(jPanel02);
		jPanel.add(jPanel0);

		/**
		 * 第二行
		 */
		JPanel jPanel1 = new JPanel();
		jPanel1.setOpaque(false);
		jPanel1.setLayout(new GridLayout(1, 3));

		/**
		 * 票价
		 */
		JPanel jPanel10 = new JPanel();
		jPanel10.setOpaque(false);
		jPanel10.setLayout(new FlowLayout());
		// 旧密码图片
		ImageIcon imageIcon_piaojia = new ImageIcon(
				Login.class.getResource("/com/today/images/piaojia.png"));
		imageIcon_piaojia.setImage(imageIcon_piaojia.getImage()
				.getScaledInstance(80, 40, Image.SCALE_DEFAULT));
		JLabel jLabel_piaojiatu = new JLabel(imageIcon_piaojia, JLabel.RIGHT);
		jPanel10.add(jLabel_piaojiatu);
		jPanel10.add(jTextField_add_piaojia);
		jPanel1.add(jPanel10);

		/**
		 * 时长
		 */
		JPanel jPanel11 = new JPanel();
		jPanel11.setOpaque(false);
		jPanel11.setLayout(new FlowLayout());
		// 时长图片
		ImageIcon imageIcon_shichang = new ImageIcon(
				Login.class.getResource("/com/today/images/shichang.png"));
		imageIcon_shichang.setImage(imageIcon_shichang.getImage()
				.getScaledInstance(80, 40, Image.SCALE_DEFAULT));
		JLabel jLabel_shichangtu = new JLabel(imageIcon_shichang, JLabel.RIGHT);
		jPanel11.add(jLabel_shichangtu);
		jPanel11.add(jTextField_add_shichang);
		jPanel1.add(jPanel11);

		/**
		 * 状态
		 */
		JPanel jPanel12 = new JPanel();
		jPanel12.setOpaque(false);
		jPanel12.setLayout(new FlowLayout());
		ImageIcon imageIcon_daianpai = new ImageIcon(
				Login.class.getResource("/com/today/images/jumuzhuangtai.png"));
		imageIcon_daianpai.setImage(imageIcon_daianpai.getImage()
				.getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		ImageIcon imageIcon_yianpai = new ImageIcon(
				Login.class.getResource("/com/today/images/jumuzhuangtai.png"));
		imageIcon_yianpai.setImage(imageIcon_yianpai.getImage()
				.getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		ImageIcon imageIcon_xiaxian = new ImageIcon(
				Login.class.getResource("/com/today/images/jumuzhuangtai.png"));
		imageIcon_xiaxian.setImage(imageIcon_xiaxian.getImage()
				.getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		ImageIcon imageIcon_zhuangtai = new ImageIcon(
				Login.class.getResource("/com/today/images/zhuangtai.png"));
		imageIcon_zhuangtai.setImage(imageIcon_zhuangtai.getImage()
				.getScaledInstance(80, 40, Image.SCALE_DEFAULT));
		JLabel jLabel_zhuangtai = new JLabel(imageIcon_zhuangtai, JLabel.RIGHT);
		jPanel12.add(jLabel_zhuangtai);
		jComboBox_add_zhuangtai = new JComboBox();
		jComboBox_add_zhuangtai.setMaximumRowCount(3);
		// 设置 调用单元格
		jComboBox_add_zhuangtai.setRenderer(new JComboBox_Item());
		jComboBox_add_zhuangtai.setBackground(Color.black);
		jComboBox_add_zhuangtai.setSize(80, 40);
		jComboBox_add_zhuangtai.addItem(new Object[] { imageIcon_daianpai,
				"待安排", "today剧院剧目状态" });
		jComboBox_add_zhuangtai.addItem(new Object[] { imageIcon_yianpai,
				"已安排", "today剧院剧目状态" });
		jComboBox_add_zhuangtai.addItem(new Object[] { imageIcon_xiaxian, "下线",
				"today剧院剧目状态" });
		jPanel12.add(jComboBox_add_zhuangtai);
		jPanel1.add(jPanel12);

		jPanel.add(jPanel1);

		/**
		 * 剧目简介
		 */
		JPanel jPanel2 = new JPanel();
		jPanel2.setLayout(new GridLayout(1, 2));
		jPanel2.setOpaque(false);
		JPanel jPanel20 = new JPanel();
		jPanel20.setLayout(new FlowLayout());
		jPanel20.setOpaque(false);
		ImageIcon imageIcon_jianjie = new ImageIcon(
				Login.class.getResource("/com/today/images/jumujianjie.png"));
		imageIcon_jianjie.setImage(imageIcon_jianjie.getImage()
				.getScaledInstance(160, 40, Image.SCALE_DEFAULT));
		JLabel jLabel_jianjietu = new JLabel(imageIcon_jianjie, JLabel.RIGHT);
		jPanel20.add(jLabel_jianjietu);
		jPanel20.add(jTextField_add_infor);
		jPanel2.add(jPanel20);

		JPanel jPanel21 = new JPanel();
		jPanel21.setLayout(new FlowLayout());
		jPanel21.setOpaque(false);
		ImageIcon imageIcon_image = new ImageIcon(
				Login.class.getResource("/com/today/images/movie.png"));
		imageIcon_image.setImage(imageIcon_image.getImage().getScaledInstance(
				90, 70, Image.SCALE_DEFAULT));
		jLabel_add_image = new JLabel(imageIcon_image);
		jPanel21.add(jLabel_add_image);
		ImageIcon imageIcon_button = new ImageIcon(
				Login.class.getResource("/com/today/images/button.png"));
		imageIcon_button.setImage(imageIcon_button.getImage()
				.getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		jButton_add_image = new JButton("选择图片", imageIcon_button);
		jButton_add_image.setContentAreaFilled(false);
		jButton_add_image.setForeground(Color.black);
		jPanel21.add(jButton_add_image);
		jPanel2.add(jPanel21);
		jPanel.add(jPanel2);
		/**
		 * 第五行
		 */
		JPanel jPanel4 = new JPanel();
		jPanel4.setOpaque(false);
		jPanel4.setLayout(new GridLayout(1, 2));

		/**
		 * 确定按钮
		 */
		JPanel jPanel40 = new JPanel();
		jPanel40.setOpaque(false);
		jPanel40.setLayout(new FlowLayout(FlowLayout.RIGHT));
		imageIcon_button.setImage(imageIcon_button.getImage()
				.getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		jButton_add_add = new JButton("添加", imageIcon_button);
		jButton_add_add.setContentAreaFilled(false);
		jButton_add_add.setForeground(Color.black);
		jPanel40.add(jButton_add_add);
		jPanel4.add(jPanel40);

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
		jPanel4.add(jPanel41);

		jPanel.add(jPanel4);

		return jPanel;
	}

	/**
	 * 添加的点击事件
	 */
	private void addDianJi() {
		jButton_add_quxiao.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				setSelectedIndex(0);
			}
		});

		/**
		 * 添加 jbutton
		 */
		jButton_add_add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String name = jTextField_add_name.getText();
				String shichang = jTextField_add_shichang.getText();
				String infro = jTextField_add_infor.getText();
				String piaojia = jTextField_add_piaojia.getText();
				String leixing = "";
				int lei = jComboBox_add_leixing.getSelectedIndex();
				if (lei == 0) {
					leixing = "惊悚";
				} else {
					leixing = "喜剧";
				}

				String yuyan = "";
				int yu = jComboBox_add_yuyan.getSelectedIndex();
				if (yu == 0) {
					yuyan = "汉语";
				} else {
					yuyan = "英语";
				}
				String zhuangtai = "";
				int zhun = jComboBox_add_zhuangtai.getSelectedIndex();
				if (zhun == 0) {
					zhuangtai = "待安排";
				} else if (zhun == 1) {
					zhuangtai = "已安排";
				} else {
					zhuangtai = "下线";
				}

				if (name.equals("")) {
					JOptionPane.showMessageDialog(
							Administrator.jFrame_GuanLi.getContentPane(),
							"姓名不能为空!", "today加添系统信息",
							JOptionPane.WARNING_MESSAGE);
				} else if (shichang.equals("")) {
					JOptionPane.showMessageDialog(
							Administrator.jFrame_GuanLi.getContentPane(),
							"时长不能为空!", "today加添系统信息",
							JOptionPane.WARNING_MESSAGE);
				} else if (infro.equals("")) {
					JOptionPane.showMessageDialog(
							Administrator.jFrame_GuanLi.getContentPane(),
							"影片简介不能为空!", "today加添系统信息",
							JOptionPane.WARNING_MESSAGE);
				} else if (piaojia.equals("")) {
					JOptionPane.showMessageDialog(
							Administrator.jFrame_GuanLi.getContentPane(),
							"票价不能为空!", "today加添系统信息",
							JOptionPane.WARNING_MESSAGE);
				} else {
					System.out.println("影片  添加成功");
					Play play = new Play();
					if (play.playAdd(leixing, yuyan, name, infro,
							string_add_image, shichang, piaojia, zhuangtai)) {
						JOptionPane.showMessageDialog(
								Administrator.jFrame_GuanLi.getContentPane(),
								"影片添加成功!", "today加添系统信息",
								JOptionPane.WARNING_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(
								Administrator.jFrame_GuanLi.getContentPane(),
								"影片添加失败!", "today加添系统信息",
								JOptionPane.WARNING_MESSAGE);
					}

				}
			}
		});

		/**
		 * 选择图片 的 点击事件
		 */
		jButton_add_image.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFileChooser jfc = new JFileChooser();
				jfc.setCurrentDirectory(new File(
						"D:\\Android Dat\\Movie\\src\\com\\today\\images"));
				jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				jfc.showDialog(new JLabel(), "选择");
				// 多选
				jfc.setMultiSelectionEnabled(false);
				File file = jfc.getSelectedFile();
				if (file.isDirectory()) {
					System.out.println("文件夹:" + file.getAbsolutePath());
				} else if (file.isFile()) {
					System.out.println("文件:" + file.getAbsolutePath());
				}
				string_add_image = jfc.getSelectedFile().getName();
				ImageIcon imageIcon_image = new ImageIcon(Login.class
						.getResource("/com/today/images/" + string_add_image));
				imageIcon_image.setImage(imageIcon_image.getImage()
						.getScaledInstance(90, 70, Image.SCALE_DEFAULT));
				jLabel_add_image.setIcon(imageIcon_image);
			}
		});

	}

	
	/**
	 * 剧目详情
	 * 
	 * @return
	 */
	private JPanel jPanel_xiangqing() {
		JPanel jPanel = new JPanel();
		jPanel.setOpaque(false);
		ImageIcon imageIcon_yuangongzengjia = new ImageIcon(
				Login.class.getResource("/com/today/images/jumuxiangqing.png"));
		imageIcon_yuangongzengjia.setImage(imageIcon_yuangongzengjia.getImage()
				.getScaledInstance(300, 70, Image.SCALE_DEFAULT));
		Insets insets = new Insets(2, 2, 2, 2);
		GridBagLayout gridBagLayout = new GridBagLayout();
		jPanel.setLayout(gridBagLayout);
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.insets = insets;
		/**
		 * 剧目详情的图片
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
		 * 剧目详情的 下操作界面
		 */
		JPanel jPanel_nei = play_xiangqing();
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
	 * 剧目详情的  一些  基本操作。。
	 * @return
	 */
	private JPanel play_xiangqing(){
		JPanel jPanel = new JPanel();
		jPanel.setLayout(new GridLayout(3, 1));
		
		/**
		 * 剧目名称
		 */
		JPanel jPanelming = new JPanel();
		jPanelming.setOpaque(false);
		jPanelming.setLayout(new FlowLayout());
		// 工号图片
		ImageIcon imageIcon_mingcheng = new ImageIcon(
				Login.class.getResource("/com/today/images/jumuname.png"));
		imageIcon_mingcheng.setImage(imageIcon_mingcheng.getImage()
				.getScaledInstance(160, 40, Image.SCALE_DEFAULT));
		JLabel jLabel_mingchengtu = new JLabel(imageIcon_mingcheng,
				JLabel.RIGHT);
		jPanelming.add(jLabel_mingchengtu);
		jPanelming.add(jTextField_xiangqing_name);

		/**
		 * 语言
		 */
		JPanel jPanelyuyan = new JPanel();
		jPanelyuyan.setOpaque(false);
		jPanelyuyan.setLayout(new FlowLayout());
		/**
		 * 语言选择s
		 */
		ImageIcon imageIcon_hanyu = new ImageIcon(
				Login.class.getResource("/com/today/images/hanyu.png"));
		imageIcon_hanyu.setImage(imageIcon_hanyu.getImage().getScaledInstance(
				30, 30, Image.SCALE_DEFAULT));
		ImageIcon imageIcon_yingyu = new ImageIcon(
				Login.class.getResource("/com/today/images/yingyu.png"));
		imageIcon_yingyu.setImage(imageIcon_yingyu.getImage()
				.getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		ImageIcon imageIcon_yuyan = new ImageIcon(
				Login.class.getResource("/com/today/images/yuyan.png"));
		imageIcon_yuyan.setImage(imageIcon_yuyan.getImage().getScaledInstance(
				80, 40, Image.SCALE_DEFAULT));
		JLabel jLabel_yuyan = new JLabel(imageIcon_yuyan, JLabel.RIGHT);
		jPanelyuyan.add(jLabel_yuyan);
		jComboBox_xiangqing_yuyan = new JComboBox();
		jComboBox_xiangqing_yuyan.setMaximumRowCount(2);
		// 设置 调用单元格
		jComboBox_xiangqing_yuyan.setRenderer(new JComboBox_Item());
		jComboBox_xiangqing_yuyan.setBackground(Color.black);
		jComboBox_xiangqing_yuyan.setSize(60, 40);
		jComboBox_xiangqing_yuyan.addItem(new Object[] { imageIcon_hanyu, "汉语",
				"人类语言" });
		jComboBox_xiangqing_yuyan.addItem(new Object[] { imageIcon_yingyu, "英语",
				"人类语言" });
		jPanelyuyan.add(jComboBox_xiangqing_yuyan);
		

		/**
		 * 性别
		 */
		JPanel jPanelxingbie = new JPanel();
		jPanelxingbie.setOpaque(false);
		jPanelxingbie.setLayout(new FlowLayout());
		/**
		 * 性别选择s
		 */
		ImageIcon imageIcon_jingsong = new ImageIcon(
				Login.class.getResource("/com/today/images/jumuleixing.png"));
		imageIcon_jingsong.setImage(imageIcon_jingsong.getImage()
				.getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		ImageIcon imageIcon_xiju = new ImageIcon(
				Login.class.getResource("/com/today/images/xiju.png"));
		imageIcon_xiju.setImage(imageIcon_xiju.getImage().getScaledInstance(30,
				30, Image.SCALE_DEFAULT));
		ImageIcon imageIcon_leixing = new ImageIcon(
				Login.class.getResource("/com/today/images/leixing.png"));
		imageIcon_leixing.setImage(imageIcon_leixing.getImage()
				.getScaledInstance(80, 40, Image.SCALE_DEFAULT));
		JLabel jLabel_xingbie = new JLabel(imageIcon_leixing, JLabel.RIGHT);
		jPanelxingbie.add(jLabel_xingbie);
		jComboBox_xiangqing_leixing = new JComboBox();
		jComboBox_xiangqing_leixing.setMaximumRowCount(2);
		// 设置 调用单元格
		jComboBox_xiangqing_leixing.setRenderer(new JComboBox_Item());
		jComboBox_xiangqing_leixing.setBackground(Color.black);
		jComboBox_xiangqing_leixing.setSize(60, 40);
		jComboBox_xiangqing_leixing.addItem(new Object[] { imageIcon_jingsong,
				"惊悚", "电影类型" });
		jComboBox_xiangqing_leixing.addItem(new Object[] { imageIcon_xiju, "喜剧",
				"电影类型" });
		jPanelxingbie.add(jComboBox_xiangqing_leixing);


		/**
		 * 票价
		 */
		JPanel jPanelpiaojia = new JPanel();
		jPanelpiaojia.setOpaque(false);
		jPanelpiaojia.setLayout(new FlowLayout());
		// 旧密码图片
		ImageIcon imageIcon_piaojia = new ImageIcon(
				Login.class.getResource("/com/today/images/piaojia.png"));
		imageIcon_piaojia.setImage(imageIcon_piaojia.getImage()
				.getScaledInstance(80, 40, Image.SCALE_DEFAULT));
		JLabel jLabel_piaojiatu = new JLabel(imageIcon_piaojia, JLabel.RIGHT);
		jPanelpiaojia.add(jLabel_piaojiatu);
		jPanelpiaojia.add(jTextField_xiangqing_piaojia);

		/**
		 * 时长
		 */
		JPanel jPanelshichang = new JPanel();
		jPanelshichang.setOpaque(false);
		jPanelshichang.setLayout(new FlowLayout());
		// 时长图片
		ImageIcon imageIcon_shichang = new ImageIcon(
				Login.class.getResource("/com/today/images/shichang.png"));
		imageIcon_shichang.setImage(imageIcon_shichang.getImage()
				.getScaledInstance(80, 40, Image.SCALE_DEFAULT));
		JLabel jLabel_shichangtu = new JLabel(imageIcon_shichang, JLabel.RIGHT);
		jPanelshichang.add(jLabel_shichangtu);
		jPanelshichang.add(jTextField_xiangqing_shichang);

		/**
		 * 状态
		 */
		JPanel jPanelzhuangtai = new JPanel();
		jPanelzhuangtai.setOpaque(false);
		jPanelzhuangtai.setLayout(new FlowLayout());
		ImageIcon imageIcon_daianpai = new ImageIcon(
				Login.class.getResource("/com/today/images/jumuzhuangtai.png"));
		imageIcon_daianpai.setImage(imageIcon_daianpai.getImage()
				.getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		ImageIcon imageIcon_yianpai = new ImageIcon(
				Login.class.getResource("/com/today/images/jumuzhuangtai.png"));
		imageIcon_yianpai.setImage(imageIcon_yianpai.getImage()
				.getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		ImageIcon imageIcon_xiaxian = new ImageIcon(
				Login.class.getResource("/com/today/images/jumuzhuangtai.png"));
		imageIcon_xiaxian.setImage(imageIcon_xiaxian.getImage()
				.getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		ImageIcon imageIcon_zhuangtai = new ImageIcon(
				Login.class.getResource("/com/today/images/zhuangtai.png"));
		imageIcon_zhuangtai.setImage(imageIcon_zhuangtai.getImage()
				.getScaledInstance(80, 40, Image.SCALE_DEFAULT));
		JLabel jLabel_zhuangtai = new JLabel(imageIcon_zhuangtai, JLabel.RIGHT);
		jPanelzhuangtai.add(jLabel_zhuangtai);
		jComboBox_xiangqing_zhuangtai = new JComboBox();
		jComboBox_xiangqing_zhuangtai.setMaximumRowCount(3);
		// 设置 调用单元格
		jComboBox_xiangqing_zhuangtai.setRenderer(new JComboBox_Item());
		jComboBox_xiangqing_zhuangtai.setBackground(Color.black);
		jComboBox_xiangqing_zhuangtai.setSize(80, 40);
		jComboBox_xiangqing_zhuangtai.addItem(new Object[] { imageIcon_daianpai,
				"待安排", "today剧院剧目状态" });
		jComboBox_xiangqing_zhuangtai.addItem(new Object[] { imageIcon_yianpai,
				"已安排", "today剧院剧目状态" });
		jComboBox_xiangqing_zhuangtai.addItem(new Object[] { imageIcon_xiaxian,
				"下线", "today剧院剧目状态" });
		jPanelzhuangtai.add(jComboBox_xiangqing_zhuangtai);
		

		/**
		 * 剧目简介
		 */
		JPanel jPaneljianjie = new JPanel();
		jPaneljianjie.setLayout(new GridLayout(2, 1));
		jPaneljianjie.setOpaque(false);
		JPanel jPanel20 = new JPanel();
		jPanel20.setLayout(new FlowLayout());
		jPanel20.setOpaque(false);
		ImageIcon imageIcon_jianjie = new ImageIcon(
				Login.class.getResource("/com/today/images/jumujianjie.png"));
		imageIcon_jianjie.setImage(imageIcon_jianjie.getImage()
				.getScaledInstance(160, 40, Image.SCALE_DEFAULT));
		JLabel jLabel_jianjietu = new JLabel(imageIcon_jianjie, JLabel.CENTER);
		jPaneljianjie.add(jLabel_jianjietu);
		jTextField_xiangqing_infor.setSize(300,500 );
		jPaneljianjie.add(jTextField_xiangqing_infor);

		JPanel jPanelfanhui = new JPanel();
		jPanelfanhui.setLayout(new FlowLayout());
		jPanelfanhui.setOpaque(false);
		ImageIcon imageIcon_image = new ImageIcon(
				Login.class.getResource("/com/today/images/movie.png"));
		imageIcon_image.setImage(imageIcon_image.getImage().getScaledInstance(
				180, 260, Image.SCALE_DEFAULT));
		jLabel_xiangqing_image = new JLabel(imageIcon_image);
		jPanelfanhui.add(jLabel_xiangqing_image);
		ImageIcon imageIcon_button = new ImageIcon(
				Login.class.getResource("/com/today/images/button.png"));
		imageIcon_button.setImage(imageIcon_button.getImage()
				.getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		jButton_xiangqing_image = new JButton("返回", imageIcon_button);
		jButton_xiangqing_image.setContentAreaFilled(false);
		jButton_xiangqing_image.setForeground(Color.black);
		jButton_xiangqing_image.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				setSelectedIndex(0);
			}
		});
		jPanelfanhui.add(jButton_xiangqing_image);
		jTextField_xiangqing_infor.setEditable(false);
		jTextField_xiangqing_name.setEditable(false);
		jTextField_xiangqing_piaojia.setEditable(false);
		jTextField_xiangqing_shichang.setEditable(false);
		jPanel.setLayout(new GridLayout(1, 2));
		jPanel.setOpaque(false);
		
		/**
		 * 左边
		 */
		JPanel jPanelyi0 = new JPanel();
		jPanelyi0.setLayout(new GridLayout(3, 1));
		jPanelyi0.setOpaque(false);
		jPanelyi0.add(jLabel_xiangqing_image,FlowLayout.LEFT);
		jPanelyi0.add(jPaneljianjie);
		JPanel jPanelq = new JPanel();
		jPanelq.setOpaque(false);
		jPanelyi0.add(jPanelq);
		
		/**
		 * 邮编
		 */
		JPanel jPaneler = new JPanel();
		jPaneler.setLayout(new GridLayout(4, 1));
		jPaneler.setOpaque(false);
		
		jPaneler.add(jPanelming);
		
		
		JPanel jPaneler1 = new JPanel();
		jPaneler1.setOpaque(false);
		jPaneler1.setLayout(new GridLayout(1, 2));
		jPaneler1.add(jPanelpiaojia);
		jPaneler1.add(jPanelxingbie);
		jPaneler.add(jPaneler1);
		
		JPanel jPaneler2 = new JPanel();
		jPaneler2.setOpaque(false);
		jPaneler2.setLayout(new GridLayout(1, 2));
		jPaneler2.add(jPanelyuyan);
		jPaneler2.add(jPanelzhuangtai);
		jPaneler.add(jPaneler2);
		
		JPanel jPaneler0 = new JPanel();
		jPaneler0.setOpaque(false);
		jPaneler0.setLayout(new GridLayout(1, 2));	
		jPaneler0.add(jPanelshichang);
		jPaneler0.add(jPanelfanhui);
		jPaneler.add(jPaneler0);
		
		jPanel.add(jPanelyi0);
		jPanel.add(jPaneler);
		return jPanel;
	}
	
	/**
	 * 剧目信息
	 * 
	 * @return
	 */
	private JPanel jPanel_xinxi() {
		JPanel jPanel = new JPanel();
		jPanel.setOpaque(false);
		ImageIcon imageIcon_yuangongzengjia = new ImageIcon(
				Login.class.getResource("/com/today/images/jumuxinxi.png"));
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
		JPanel jPanel_nei = play_xinxi();
		jPanel_nei.setOpaque(false);
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.weightx = 200;
		gridBagConstraints.weighty = 200;
		jPanel.add(jPanel_nei, gridBagConstraints);

		return jPanel;
	}

	private JPanel play_xinxi() {
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

	/**
	 * 人员列表的简介事件
	 */
	private void lieBiaoJianJieDianJiShiJian() {
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
					for (int i = 0; i < playInformations.size(); i++) {

						if (playInformations.get(i).getPlay_name()
								.contains(string_search)) {
							Object[] objects = new Object[8];
							objects[5] = new JButton();
							objects[6] = new JButton();
							objects[7] = new JButton();
							objects[0] = playInformations.get(i).getPlay_id();
							objects[1] = playInformations.get(i).getPlay_name();
							objects[2] = playInformations.get(i).getPlay_length();
							objects[3] = playInformations.get(i).getPlay_type_id();
							objects[4] = playInformations.get(i).getPlay_lang_id();
							data.add(objects);

						}
					}
					if (data.size() != 0) {
						model.fireTableDataChanged();
					}
				} else {
					data.removeAll(data);
					palyShuJuRuKou();
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
	 * 剧目修改
	 * 
	 * @return
	 */
	private JPanel jPanel_xiugai() {
		JPanel jPanel = new JPanel();
		jPanel.setOpaque(false);
		ImageIcon imageIcon_yuangongzengjia = new ImageIcon(
				Login.class.getResource("/com/today/images/xiugaijumu.png"));
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
		JPanel jPanel_nei = play_xiugai();
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
	 * 剧目修改
	 * 
	 * @return
	 */
	private JPanel play_xiugai() {
		// TODO Auto-generated method stub
		JPanel jPanel = new JPanel();

		jPanel.setLayout(new GridLayout(4, 1));
		/**
		 * 第一行
		 */
		JPanel jPanel0 = new JPanel();
		jPanel0.setOpaque(false);
		jPanel0.setLayout(new GridLayout(1, 3));
		/**
		 * 剧目名称
		 */
		JPanel jPanel00 = new JPanel();
		jPanel00.setOpaque(false);
		jPanel00.setLayout(new FlowLayout());
		// 工号图片
		ImageIcon imageIcon_mingcheng = new ImageIcon(
				Login.class.getResource("/com/today/images/jumuname.png"));
		imageIcon_mingcheng.setImage(imageIcon_mingcheng.getImage()
				.getScaledInstance(160, 40, Image.SCALE_DEFAULT));
		JLabel jLabel_mingchengtu = new JLabel(imageIcon_mingcheng,
				JLabel.RIGHT);
		jPanel00.add(jLabel_mingchengtu);
		jPanel00.add(jTextField_xiugai_name);
		jPanel0.add(jPanel00);

		/**
		 * 语言
		 */
		JPanel jPanel01 = new JPanel();
		jPanel01.setOpaque(false);
		jPanel01.setLayout(new FlowLayout());
		/**
		 * 语言选择s
		 */
		ImageIcon imageIcon_hanyu = new ImageIcon(
				Login.class.getResource("/com/today/images/hanyu.png"));
		imageIcon_hanyu.setImage(imageIcon_hanyu.getImage().getScaledInstance(
				30, 30, Image.SCALE_DEFAULT));
		ImageIcon imageIcon_yingyu = new ImageIcon(
				Login.class.getResource("/com/today/images/yingyu.png"));
		imageIcon_yingyu.setImage(imageIcon_yingyu.getImage()
				.getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		ImageIcon imageIcon_yuyan = new ImageIcon(
				Login.class.getResource("/com/today/images/yuyan.png"));
		imageIcon_yuyan.setImage(imageIcon_yuyan.getImage().getScaledInstance(
				80, 40, Image.SCALE_DEFAULT));
		JLabel jLabel_yuyan = new JLabel(imageIcon_yuyan, JLabel.RIGHT);
		jPanel01.add(jLabel_yuyan);
		jComboBox_xiugai_yuyan = new JComboBox();
		jComboBox_xiugai_yuyan.setMaximumRowCount(2);
		// 设置 调用单元格
		jComboBox_xiugai_yuyan.setRenderer(new JComboBox_Item());
		jComboBox_xiugai_yuyan.setBackground(Color.black);
		jComboBox_xiugai_yuyan.setSize(60, 40);
		jComboBox_xiugai_yuyan.addItem(new Object[] { imageIcon_hanyu, "汉语",
				"人类语言" });
		jComboBox_xiugai_yuyan.addItem(new Object[] { imageIcon_yingyu, "英语",
				"人类语言" });
		jPanel01.add(jComboBox_xiugai_yuyan);
		jPanel0.add(jPanel01);

		/**
		 * 性别
		 */
		JPanel jPanel02 = new JPanel();
		jPanel02.setOpaque(false);
		jPanel02.setLayout(new FlowLayout());
		/**
		 * 性别选择s
		 */
		ImageIcon imageIcon_jingsong = new ImageIcon(
				Login.class.getResource("/com/today/images/jumuleixing.png"));
		imageIcon_jingsong.setImage(imageIcon_jingsong.getImage()
				.getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		ImageIcon imageIcon_xiju = new ImageIcon(
				Login.class.getResource("/com/today/images/xiju.png"));
		imageIcon_xiju.setImage(imageIcon_xiju.getImage().getScaledInstance(30,
				30, Image.SCALE_DEFAULT));
		ImageIcon imageIcon_leixing = new ImageIcon(
				Login.class.getResource("/com/today/images/leixing.png"));
		imageIcon_leixing.setImage(imageIcon_leixing.getImage()
				.getScaledInstance(80, 40, Image.SCALE_DEFAULT));
		JLabel jLabel_xingbie = new JLabel(imageIcon_leixing, JLabel.RIGHT);
		jPanel02.add(jLabel_xingbie);
		jComboBox_xiugai_leixing = new JComboBox();
		jComboBox_xiugai_leixing.setMaximumRowCount(2);
		// 设置 调用单元格
		jComboBox_xiugai_leixing.setRenderer(new JComboBox_Item());
		jComboBox_xiugai_leixing.setBackground(Color.black);
		jComboBox_xiugai_leixing.setSize(60, 40);
		jComboBox_xiugai_leixing.addItem(new Object[] { imageIcon_jingsong,
				"惊悚", "电影类型" });
		jComboBox_xiugai_leixing.addItem(new Object[] { imageIcon_xiju, "喜剧",
				"电影类型" });
		jPanel02.add(jComboBox_xiugai_leixing);
		jPanel0.add(jPanel02);
		jPanel.add(jPanel0);

		/**
		 * 第二行
		 */
		JPanel jPanel1 = new JPanel();
		jPanel1.setOpaque(false);
		jPanel1.setLayout(new GridLayout(1, 3));

		/**
		 * 票价
		 */
		JPanel jPanel10 = new JPanel();
		jPanel10.setOpaque(false);
		jPanel10.setLayout(new FlowLayout());
		// 旧密码图片
		ImageIcon imageIcon_piaojia = new ImageIcon(
				Login.class.getResource("/com/today/images/piaojia.png"));
		imageIcon_piaojia.setImage(imageIcon_piaojia.getImage()
				.getScaledInstance(80, 40, Image.SCALE_DEFAULT));
		JLabel jLabel_piaojiatu = new JLabel(imageIcon_piaojia, JLabel.RIGHT);
		jPanel10.add(jLabel_piaojiatu);
		jPanel10.add(jTextField_xiugai_piaojia);
		jPanel1.add(jPanel10);

		/**
		 * 时长
		 */
		JPanel jPanel11 = new JPanel();
		jPanel11.setOpaque(false);
		jPanel11.setLayout(new FlowLayout());
		// 时长图片
		ImageIcon imageIcon_shichang = new ImageIcon(
				Login.class.getResource("/com/today/images/shichang.png"));
		imageIcon_shichang.setImage(imageIcon_shichang.getImage()
				.getScaledInstance(80, 40, Image.SCALE_DEFAULT));
		JLabel jLabel_shichangtu = new JLabel(imageIcon_shichang, JLabel.RIGHT);
		jPanel11.add(jLabel_shichangtu);
		jPanel11.add(jTextField_xiugai_shichang);
		jPanel1.add(jPanel11);

		/**
		 * 状态
		 */
		JPanel jPanel12 = new JPanel();
		jPanel12.setOpaque(false);
		jPanel12.setLayout(new FlowLayout());
		ImageIcon imageIcon_daianpai = new ImageIcon(
				Login.class.getResource("/com/today/images/jumuzhuangtai.png"));
		imageIcon_daianpai.setImage(imageIcon_daianpai.getImage()
				.getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		ImageIcon imageIcon_yianpai = new ImageIcon(
				Login.class.getResource("/com/today/images/jumuzhuangtai.png"));
		imageIcon_yianpai.setImage(imageIcon_yianpai.getImage()
				.getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		ImageIcon imageIcon_xiaxian = new ImageIcon(
				Login.class.getResource("/com/today/images/jumuzhuangtai.png"));
		imageIcon_xiaxian.setImage(imageIcon_xiaxian.getImage()
				.getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		ImageIcon imageIcon_zhuangtai = new ImageIcon(
				Login.class.getResource("/com/today/images/zhuangtai.png"));
		imageIcon_zhuangtai.setImage(imageIcon_zhuangtai.getImage()
				.getScaledInstance(80, 40, Image.SCALE_DEFAULT));
		JLabel jLabel_zhuangtai = new JLabel(imageIcon_zhuangtai, JLabel.RIGHT);
		jPanel12.add(jLabel_zhuangtai);
		jComboBox_xiugai_zhuangtai = new JComboBox();
		jComboBox_xiugai_zhuangtai.setMaximumRowCount(3);
		// 设置 调用单元格
		jComboBox_xiugai_zhuangtai.setRenderer(new JComboBox_Item());
		jComboBox_xiugai_zhuangtai.setBackground(Color.black);
		jComboBox_xiugai_zhuangtai.setSize(80, 40);
		jComboBox_xiugai_zhuangtai.addItem(new Object[] { imageIcon_daianpai,
				"待安排", "today剧院剧目状态" });
		jComboBox_xiugai_zhuangtai.addItem(new Object[] { imageIcon_yianpai,
				"已安排", "today剧院剧目状态" });
		jComboBox_xiugai_zhuangtai.addItem(new Object[] { imageIcon_xiaxian,
				"下线", "today剧院剧目状态" });
		jPanel12.add(jComboBox_xiugai_zhuangtai);
		jPanel1.add(jPanel12);

		jPanel.add(jPanel1);

		/**
		 * 剧目简介
		 */
		JPanel jPanel2 = new JPanel();
		jPanel2.setLayout(new GridLayout(1, 2));
		jPanel2.setOpaque(false);
		JPanel jPanel20 = new JPanel();
		jPanel20.setLayout(new FlowLayout());
		jPanel20.setOpaque(false);
		ImageIcon imageIcon_jianjie = new ImageIcon(
				Login.class.getResource("/com/today/images/jumujianjie.png"));
		imageIcon_jianjie.setImage(imageIcon_jianjie.getImage()
				.getScaledInstance(160, 40, Image.SCALE_DEFAULT));
		JLabel jLabel_jianjietu = new JLabel(imageIcon_jianjie, JLabel.RIGHT);
		jPanel20.add(jLabel_jianjietu);
		jPanel20.add(jTextField_xiugai_infor);
		jPanel2.add(jPanel20);

		JPanel jPanel21 = new JPanel();
		jPanel21.setLayout(new FlowLayout());
		jPanel21.setOpaque(false);
		ImageIcon imageIcon_image = new ImageIcon(
				Login.class.getResource("/com/today/images/movie.png"));
		imageIcon_image.setImage(imageIcon_image.getImage().getScaledInstance(
				90, 70, Image.SCALE_DEFAULT));
		jLabel_xiugai_image = new JLabel(imageIcon_image);
		jPanel21.add(jLabel_xiugai_image);
		ImageIcon imageIcon_button = new ImageIcon(
				Login.class.getResource("/com/today/images/button.png"));
		imageIcon_button.setImage(imageIcon_button.getImage()
				.getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		jButton_xiugai_image = new JButton("选择图片", imageIcon_button);
		jButton_xiugai_image.setContentAreaFilled(false);
		jButton_xiugai_image.setForeground(Color.black);
		jPanel21.add(jButton_xiugai_image);
		jPanel2.add(jPanel21);
		jPanel.add(jPanel2);

		/**
		 * 第五行
		 */
		JPanel jPanel4 = new JPanel();
		jPanel4.setOpaque(false);
		jPanel4.setLayout(new GridLayout(1, 2));

		/**
		 * 确定按钮
		 */
		JPanel jPanel40 = new JPanel();
		jPanel40.setOpaque(false);
		jPanel40.setLayout(new FlowLayout(FlowLayout.RIGHT));
		imageIcon_button.setImage(imageIcon_button.getImage()
				.getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		jButton_xiugai_add = new JButton("修改", imageIcon_button);
		jButton_xiugai_add.setContentAreaFilled(false);
		jButton_xiugai_add.setForeground(Color.black);
		jPanel40.add(jButton_xiugai_add);
		jPanel4.add(jPanel40);

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
		jPanel4.add(jPanel41);

		jPanel.add(jPanel4);

		return jPanel;
	}

	/**
	 * 修改 点击事件 的设置
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
		 * 添加 jbutton
		 */
		jButton_xiugai_add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String name = jTextField_xiugai_name.getText();
				String shichang = jTextField_xiugai_shichang.getText();
				String infro = jTextField_xiugai_infor.getText();
				String piaojia = jTextField_xiugai_piaojia.getText();
				String leixing = "";
				int lei = jComboBox_xiugai_leixing.getSelectedIndex();
				if (lei == 0) {
					leixing = "惊悚";
				} else {
					leixing = "喜剧";
				}

				String yuyan = "";
				int yu = jComboBox_xiugai_yuyan.getSelectedIndex();
				if (yu == 0) {
					yuyan = "汉语";
				} else {
					yuyan = "英语";
				}
				String zhuangtai = "";
				int zhun = jComboBox_xiugai_zhuangtai.getSelectedIndex();
				if (zhun == 0) {
					zhuangtai = "待安排";
				} else if (zhun == 1) {
					zhuangtai = "已安排";
				} else {
					zhuangtai = "下线";
				}

				if (name.equals("")) {
					JOptionPane.showMessageDialog(
							Administrator.jFrame_GuanLi.getContentPane(),
							"姓名不能为空!", "today修改系统信息",
							JOptionPane.WARNING_MESSAGE);
				} else if (shichang.equals("")) {
					JOptionPane.showMessageDialog(
							Administrator.jFrame_GuanLi.getContentPane(),
							"时长不能为空!", "today修改统信息",
							JOptionPane.WARNING_MESSAGE);
				} else if (infro.equals("")) {
					JOptionPane.showMessageDialog(
							Administrator.jFrame_GuanLi.getContentPane(),
							"影片简介不能为空!", "today修改系统信息",
							JOptionPane.WARNING_MESSAGE);
				} else if (piaojia.equals("")) {
					JOptionPane.showMessageDialog(
							Administrator.jFrame_GuanLi.getContentPane(),
							"票价不能为空!", "today修改系统信息",
							JOptionPane.WARNING_MESSAGE);
				} else {
					System.out.println("影片  修改成功");
					Play play = new Play();
					if (play.playXiuGai(leixing, yuyan, name, infro, string_xiugai_image,
							shichang, piaojia, zhuangtai, stringid)) {
						JOptionPane.showMessageDialog(
								Administrator.jFrame_GuanLi.getContentPane(),
								"修改成功!", "today修改系统信息",
								JOptionPane.WARNING_MESSAGE);
					}else {
						JOptionPane.showMessageDialog(
								Administrator.jFrame_GuanLi.getContentPane(),
								"修改失败!", "today修改系统信息",
								JOptionPane.ERROR_MESSAGE);
					}
					setSelectedIndex(0);
					
				}
			}
		});

		/**
		 * 选择图片 的 点击事件
		 */
		jButton_xiugai_image.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFileChooser jfc = new JFileChooser();
				jfc.setCurrentDirectory(new File(
						"D:\\Android Dat\\Movie\\src\\com\\today\\images"));
				jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				jfc.showDialog(new JLabel(), "选择");
				// 多选
				jfc.setMultiSelectionEnabled(false);
				File file = jfc.getSelectedFile();
				if (file.isDirectory()) {
					System.out.println("文件夹:" + file.getAbsolutePath());
				} else if (file.isFile()) {
					System.out.println("文件:" + file.getAbsolutePath());
				}
				string_xiugai_image = jfc.getSelectedFile().getName();
				ImageIcon imageIcon_image = new ImageIcon(Login.class
						.getResource("/com/today/images/" + string_xiugai_image));
				imageIcon_image.setImage(imageIcon_image.getImage()
						.getScaledInstance(90, 70, Image.SCALE_DEFAULT));
				jLabel_xiugai_image.setIcon(imageIcon_image);
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
			ImageIcon imageIcon_xinxixiugai = new ImageIcon(Login.class
					.getResource("/com/today/images/tuichujinggao.png"));
			imageIcon_xinxixiugai.setImage(imageIcon_xinxixiugai.getImage()
					.getScaledInstance(50, 50, Image.SCALE_DEFAULT));
			int option = JOptionPane.showConfirmDialog(null, "确认是否删除",
					"today系统提示", JOptionPane.YES_NO_OPTION,
					JOptionPane.WARNING_MESSAGE, imageIcon_xinxixiugai);
			switch (option) {
			case JOptionPane.YES_NO_OPTION: {
				Play play = new Play();
				if (play.DeletePlay(string)) {
					
					JOptionPane.showMessageDialog(
							Administrator.jFrame_GuanLi.getContentPane(),
							"删除成功!", "today删除系统信息",
							JOptionPane.WARNING_MESSAGE);
				}else{
					JOptionPane.showMessageDialog(
							Administrator.jFrame_GuanLi.getContentPane(),
							"删除失败!", "today删除系统信息",
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
			rb.setForeground(Color.decode(Integer.valueOf("960096",16).toString()));
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
			String  id = table.getValueAt(row, 0).toString();
			stringid = table.getValueAt(row, 0).toString();
			Play play = new Play();
			List<PlayInformation> list = play.prinfPlay(id);
			
			jTextField_xiugai_infor.setText(list.get(0).getPlay_introduction());
			jTextField_xiugai_name.setText(list.get(0).getPlay_name());
			jTextField_xiugai_piaojia.setText(list.get(0).getPlay_ticket_price());
			jTextField_xiugai_shichang.setText(list.get(0).getPlay_length());
			String leixing = list.get(0).getPlay_type_id();
			String yuyan = list.get(0).getPlay_lang_id();
			String zhuangtai = list.get(0).getPlay_status();
			if (leixing.equals("惊悚")) {
				jComboBox_xiugai_leixing.setSelectedIndex(0);
			}else {

				jComboBox_xiugai_leixing.setSelectedIndex(1);
			}
			if (yuyan.equals("汉语")) {
				jComboBox_xiugai_yuyan.setSelectedIndex(0);
			}else {
				jComboBox_xiugai_yuyan.setSelectedIndex(1);
			}
			if (zhuangtai.equals("待安排")) {
				jComboBox_xiugai_zhuangtai.setSelectedIndex(0);
			}else if (zhuangtai.equals("已安排")) {
				jComboBox_xiugai_zhuangtai.setSelectedIndex(1);
			}else{
				jComboBox_xiugai_zhuangtai.setSelectedIndex(3);
			}
			String string = list.get(0).getPlay_image();
			ImageIcon imageIcon_image = new ImageIcon(Login.class
					.getResource("/com/today/images/" + string));
			imageIcon_image.setImage(imageIcon_image.getImage()
					.getScaledInstance(90, 70, Image.SCALE_DEFAULT));
			jLabel_xiugai_image.setIcon(imageIcon_image);
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
			String  id = table.getValueAt(row, 0).toString();
			stringid = table.getValueAt(row, 0).toString();
			Play play = new Play();
			List<PlayInformation> list = play.prinfPlay(id);
			
			jTextField_xiangqing_infor.setText(list.get(0).getPlay_introduction());
			jTextField_xiangqing_name.setText(list.get(0).getPlay_name());
			jTextField_xiangqing_piaojia.setText(list.get(0).getPlay_ticket_price());
			jTextField_xiangqing_shichang.setText(list.get(0).getPlay_length());
			String leixing = list.get(0).getPlay_type_id();
			String yuyan = list.get(0).getPlay_lang_id();
			String zhuangtai = list.get(0).getPlay_status();
			if (leixing.equals("惊悚")) {
				jComboBox_xiangqing_leixing.setSelectedIndex(0);
			}else {

				jComboBox_xiangqing_leixing.setSelectedIndex(1);
			}
			if (yuyan.equals("汉语")) {
				jComboBox_xiangqing_yuyan.setSelectedIndex(0);
			}else {
				jComboBox_xiangqing_yuyan.setSelectedIndex(1);
			}
			if (zhuangtai.equals("待安排")) {
				jComboBox_xiangqing_zhuangtai.setSelectedIndex(0);
			}else if (zhuangtai.equals("已安排")) {
				jComboBox_xiangqing_zhuangtai.setSelectedIndex(1);
			}else{
				jComboBox_xiangqing_zhuangtai.setSelectedIndex(3);
			}
			String string = list.get(0).getPlay_image();
			ImageIcon imageIcon_image = new ImageIcon(Login.class
					.getResource("/com/today/images/" + string));
			imageIcon_image.setImage(imageIcon_image.getImage()
					.getScaledInstance(160, 240, Image.SCALE_DEFAULT));
			jLabel_xiangqing_image.setIcon(imageIcon_image);
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
				String.class, String.class,JButton.class,
				JButton.class, JButton.class };
		// 表头
		private String title[] = { "剧目id", "名称", "时长","类型","语言","修改","详情" , "删除" };
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

	class PlayInformationjp extends JPanel {

		public PlayInformationjp() {
			setOpaque(false);
			setLayout(new BorderLayout());
			/**
			 * 员工数据入口
			 */
			palyShuJuRuKou();
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

			DefaultTableCellRenderer renderer=new DefaultTableCellRenderer();
			renderer.setOpaque(false);
	        renderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
	        table.setDefaultRenderer(Object.class, renderer);
			JScrollPane jsp = new JScrollPane(table);
			jsp.setOpaque(false);
			jsp.getViewport().setOpaque(false);
			
			add(BorderLayout.CENTER,jsp);

		}
	}

	/**
	 * 剧目的和 数据入口
	 */
	private void palyShuJuRuKou() {
		Play play = new Play();
		playInformations = play.prinfPlays();

		for (int i = 0; i < playInformations.size(); i++) {
			Object[] objects = new Object[8];
			objects[5] = new JButton();
			objects[6] = new JButton();
			objects[7] = new JButton();
			objects[0] = playInformations.get(i).getPlay_id();
			objects[1] = playInformations.get(i).getPlay_name();
			objects[2] = playInformations.get(i).getPlay_length();
			objects[3] = playInformations.get(i).getPlay_type_id();
			objects[4] = playInformations.get(i).getPlay_lang_id();
			data.add(objects);
		}

	}

}
