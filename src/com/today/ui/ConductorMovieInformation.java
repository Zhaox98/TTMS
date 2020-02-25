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
import java.math.BigInteger;
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
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import com.today.math.SeatMath;
import com.today.math.TicketMath;
import com.today.ui.AdministratorPlayGuanLi.MyTableModel;
import com.today.ui.AdministratorSchedule.JtableButtonDelet;
import com.today.ui.AdministratorSchedule.JtableButtonxiangqing;
import com.today.ui.AdministratorSchedule.JtableButtonxiugai;
import com.today.ui.AdministratorSchedule.PlayInformationjp;
import com.xy.today.mycontrols.JComboBox_Item;
import com.xy.today.mycontrols.MyPanel;
import com.xy.today.sql.Play;
import com.xy.today.sql.Schedule;
import com.xy.today.sql.Schedule_Time;
import com.xy.today.sql.Studio;
import com.xy.today.util.PlayInformation;
import com.xy.today.util.ScheduleInformation;
import com.xy.today.util.Schedule_TimeInformation;
import com.xy.today.util.StudioInformation;

/**
 * ��ƱԱ�� ��Ӱ��Ϣ�� ����
 *
 * @author lwp940118
 *
 */
public class ConductorMovieInformation extends JTabbedPane {

	/**
	 * ���ҵ� jtextfiled
	 */
	private JTextField jTextField_movie_search;

	/**
	 * ���ҵ� jbutton
	 */
	private JButton jButton_movie_search;
	/**
	 * play���
	 */
	private JTable table_movie;

	/**
	 * ��Ŀ ������Ϣ�Ĳ������
	 */
	private List<Object[]> data_movie = new ArrayList<Object[]>();
	private List<PlayInformation> playInformations_movie = new ArrayList<PlayInformation>();

	/**
	 * �Զ�����ģʽ
	 */
	private MyTableModel_movie model_movie;

	/**
	 * ��Ŀ����� һЩ �ؼ��� ��Ϣ����
	 */
	private JTextField jTextField_xiangqing_name = new JTextField(15);
	private JTextField jTextField_xiangqing_shichang = new JTextField(15);
	private JTextField jTextField_xiangqing_infor = new JTextField(15);
	private JTextField jTextField_xiangqing_piaojia = new JTextField(15);
	private JComboBox jComboBox_xiangqing_leixing = new JComboBox();
	private JComboBox jComboBox_xiangqing_yuyan = new JComboBox();
	private JComboBox jComboBox_xiangqing_zhuangtai = new JComboBox();
	private JButton jButton_xiangqing_image;
	private JButton jButton_xaingqing_goupiao;
	private JLabel jLabel_xiangqing_image;
	private String string_xiangqing_image = "movie.png";

	private String string_goupiao = "";

	private int jiage = 0;
	private int piaojia = 0;
	private String string_yingting = "";
	private String string_shijian = "";
	private String string_yingpianming = "";
	private String string_hang = "";
	private String string_lie = "";

	/**
	 * ӰƱ  ��  �б�
	 */
	private List<MyPanel> jPanels_yingpiao = new ArrayList<MyPanel>();

	/**
	 * Ʊ�۵�չʾ
	 */
	private JLabel jLabel_piaojia;
	/**
	 * ��Ʊ  ��  ����button
	 */
	private JButton jButton_goupiao;
	private JButton jButton_fanhui;

	/**
	 * �ݳ��ƻ� �ı������
	 */
	private List<StudioInformation> studioInformations_Schedule = new ArrayList<StudioInformation>();
	private List<PlayInformation> playInformations_Schedule = new ArrayList<PlayInformation>();
	private List<Schedule_TimeInformation> timeInformations_Schedule = new ArrayList<Schedule_TimeInformation>();
	private JTextField jTextField_search_Schedule;
	private JButton jButton_search_Schedule;
	private JButton jButton_back_Schedule;
	private JTable table_Schedule;
	private List<Object[]> data_Schedule = new ArrayList<Object[]>();
	private List<ScheduleInformation> scheduleInformations_Schedule = new ArrayList<ScheduleInformation>();

	private MyTableModel_Schedule model_Schedule;

	/**
	 * Ʊ��jpnale
	 */
	private JPanel jPanel_piao;
	private JPanel jPanel_infor;
	private int[][] piao;
	private JButton[][] jButtons;
	/**
	 * �ݳ��ƻ�  id
	 */
	private String string_piao_id = "19";


	public ConductorMovieInformation() {
		setOpaque(false);
		setTabPlacement(JTabbedPane.TOP);

		/**
		 * ��Ӱ�б�
		 */
		ImageIcon imageIcon_movieList = new ImageIcon(
				Login.class.getResource("/com/today/images/movieList.png"));
		imageIcon_movieList.setImage(imageIcon_movieList.getImage()
				.getScaledInstance(120, 40, Image.SCALE_DEFAULT));
		addTab("", imageIcon_movieList, jPanel_movieLisrt());
		listJiShiJian();

		/**
		 * ӰƬ����
		 */

		ImageIcon imageIcon_movieinfor = new ImageIcon(
				Login.class.getResource("/com/today/images/movieinfor.png"));
		imageIcon_movieinfor.setImage(imageIcon_movieinfor.getImage()
				.getScaledInstance(120, 40, Image.SCALE_DEFAULT));
		addTab("", imageIcon_movieinfor, jPanel_movieInfor());

		/**
		 * �ݳ��ƻ�
		 */
		addShuJuRuKou();
		ImageIcon imageIcon_Schedule = new ImageIcon(
				Login.class.getResource("/com/today/images/yanchujihua.png"));
		imageIcon_Schedule.setImage(imageIcon_Schedule.getImage()
				.getScaledInstance(120, 40, Image.SCALE_DEFAULT));
		addTab("", imageIcon_Schedule, jPanel_Schedule());
		listDianJiShiJian();

		/**
		 * ��λѡ��
		 */
		ImageIcon imageIcon_seat = new ImageIcon(
				Login.class.getResource("/com/today/images/zuoweixuanze.png"));
		imageIcon_seat.setImage(imageIcon_seat.getImage()
				.getScaledInstance(120, 40, Image.SCALE_DEFAULT));
		addTab("", imageIcon_seat, jPanel_Seat());
		piaoDianji();
	}

	/**
	 * ��Ӱlist
	 *
	 * @return
	 */
	private JPanel jPanel_movieLisrt() {
		JPanel jPanel = new JPanel();
		jPanel.setOpaque(false);
		ImageIcon imageIcon_yuangongzengjia = new ImageIcon(
				Login.class.getResource("/com/today/images/movieList.png"));
		imageIcon_yuangongzengjia.setImage(imageIcon_yuangongzengjia.getImage()
				.getScaledInstance(300, 70, Image.SCALE_DEFAULT));
		Insets insets = new Insets(2, 2, 2, 2);
		GridBagLayout gridBagLayout = new GridBagLayout();
		jPanel.setLayout(gridBagLayout);
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.insets = insets;
		/**
		 * ��Ŀ�޸ĵ�ͼƬ
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
		 * ��Ŀ�޸ĵ� �²�������
		 */
		JPanel jPanel_nei = movie_List();
		jPanel_nei.setOpaque(false);
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.weightx = 200;
		gridBagConstraints.weighty = 200;
		jPanel.add(jPanel_nei, gridBagConstraints);

		return jPanel;
	}

	private JPanel movie_List() {
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
		jTextField_movie_search = new JTextField(20);
		jTextField_movie_search.setOpaque(false);
		jTextField_movie_search.setForeground(Color.red);
		jPanel_wei.add(jTextField_movie_search);
		jButton_movie_search = new JButton(imageIcon_search);
		jButton_movie_search.setContentAreaFilled(false);
		jPanel_wei.add(jButton_movie_search);

		jPanel.add(jPanel_wei, gridBagConstraints);
		/**
		 * Ա�������б�
		 */

		JPanel jPanel_nei = new MovieInformationjp();
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
	 * ӰƬ�ĵ���¼�
	 */
	private void listJiShiJian() {
		/**
		 * ����button�� ����¼�����
		 */
		jButton_movie_search.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String string_search = jTextField_movie_search.getText();
				System.out.println(string_search);
				if (!string_search.equals("")) {
					data_movie.removeAll(data_movie);
					for (int i = 0; i < playInformations_movie.size(); i++) {

						if (playInformations_movie.get(i).getPlay_name()
								.contains(string_search)) {
							Object[] objects = new Object[7];
							objects[5] = new JButton();
							objects[6] = new JButton();
							objects[0] = playInformations_movie.get(i)
									.getPlay_id();
							objects[1] = playInformations_movie.get(i)
									.getPlay_name();
							objects[2] = playInformations_movie.get(i)
									.getPlay_length();
							objects[3] = playInformations_movie.get(i)
									.getPlay_type_id();
							objects[4] = playInformations_movie.get(i)
									.getPlay_lang_id();
							data_movie.add(objects);

						}
					}
					if (data_movie.size() != 0) {
						model_movie.fireTableDataChanged();
					}
				} else {
					data_movie.removeAll(data_movie);
					palyShuJuRuKou();
					model_movie.fireTableDataChanged();

				}
			}
		});

	}

	/**
	 * ��Ŀ����
	 *
	 * @return
	 */
	private JPanel jPanel_movieInfor() {
		JPanel jPanel = new JPanel();
		jPanel.setOpaque(false);
		ImageIcon imageIcon_yuangongzengjia = new ImageIcon(
				Login.class.getResource("/com/today/images/movieinfor.png"));
		imageIcon_yuangongzengjia.setImage(imageIcon_yuangongzengjia.getImage()
				.getScaledInstance(300, 70, Image.SCALE_DEFAULT));
		Insets insets = new Insets(2, 2, 2, 2);
		GridBagLayout gridBagLayout = new GridBagLayout();
		jPanel.setLayout(gridBagLayout);
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.insets = insets;
		/**
		 * ��Ŀ�����ͼƬ
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
		 * ��Ŀ����� �²�������
		 */
		JPanel jPanel_nei = movieInfor();
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
	 * ��Ӱ������Ϣ�� �� ��ʾ����
	 *
	 * @return
	 */
	private JPanel movieInfor() {
		JPanel jPanel = new JPanel();
		jPanel.setLayout(new GridLayout(3, 1));
		/**
		 * ��Ŀ����
		 */
		JPanel jPanelming = new JPanel();
		jPanelming.setOpaque(false);
		jPanelming.setLayout(new FlowLayout());
		// ����ͼƬ
		ImageIcon imageIcon_mingcheng = new ImageIcon(
				Login.class.getResource("/com/today/images/jumuname.png"));
		imageIcon_mingcheng.setImage(imageIcon_mingcheng.getImage()
				.getScaledInstance(160, 40, Image.SCALE_DEFAULT));
		JLabel jLabel_mingchengtu = new JLabel(imageIcon_mingcheng,
				JLabel.RIGHT);
		jPanelming.add(jLabel_mingchengtu);
		jPanelming.add(jTextField_xiangqing_name);

		/**
		 * ����
		 */
		JPanel jPanelyuyan = new JPanel();
		jPanelyuyan.setOpaque(false);
		jPanelyuyan.setLayout(new FlowLayout());
		/**
		 * ����ѡ��s
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

		jComboBox_xiangqing_leixing.setEditable(false);
		jComboBox_xiangqing_yuyan.setEditable(false);
		jComboBox_xiangqing_zhuangtai.setEditable(false);
		jComboBox_xiangqing_yuyan.setMaximumRowCount(2);
		// ���� ���õ�Ԫ��
		jComboBox_xiangqing_yuyan.setRenderer(new JComboBox_Item());
		jComboBox_xiangqing_yuyan.setBackground(Color.black);
		jComboBox_xiangqing_yuyan.setSize(60, 40);
		jComboBox_xiangqing_yuyan.addItem(new Object[] { imageIcon_hanyu, "����",
				"��������" });
		jComboBox_xiangqing_yuyan.addItem(new Object[] { imageIcon_yingyu,
				"Ӣ��", "��������" });
		jPanelyuyan.add(jComboBox_xiangqing_yuyan);

		/**
		 * �Ա�
		 */
		JPanel jPanelxingbie = new JPanel();
		jPanelxingbie.setOpaque(false);
		jPanelxingbie.setLayout(new FlowLayout());
		/**
		 * �Ա�ѡ��s
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
		jComboBox_xiangqing_leixing.setMaximumRowCount(2);
		// ���� ���õ�Ԫ��
		jComboBox_xiangqing_leixing.setRenderer(new JComboBox_Item());
		jComboBox_xiangqing_leixing.setBackground(Color.black);
		jComboBox_xiangqing_leixing.setSize(60, 40);
		jComboBox_xiangqing_leixing.addItem(new Object[] { imageIcon_jingsong,
				"���", "��Ӱ����" });
		jComboBox_xiangqing_leixing.addItem(new Object[] { imageIcon_xiju,
				"ϲ��", "��Ӱ����" });
		jPanelxingbie.add(jComboBox_xiangqing_leixing);

		/**
		 * Ʊ��
		 */
		JPanel jPanelpiaojia = new JPanel();
		jPanelpiaojia.setOpaque(false);
		jPanelpiaojia.setLayout(new FlowLayout());
		// ������ͼƬ
		ImageIcon imageIcon_piaojia = new ImageIcon(
				Login.class.getResource("/com/today/images/piaojia.png"));
		imageIcon_piaojia.setImage(imageIcon_piaojia.getImage()
				.getScaledInstance(80, 40, Image.SCALE_DEFAULT));
		JLabel jLabel_piaojiatu = new JLabel(imageIcon_piaojia, JLabel.RIGHT);
		jPanelpiaojia.add(jLabel_piaojiatu);
		jPanelpiaojia.add(jTextField_xiangqing_piaojia);

		/**
		 * ʱ��
		 */
		JPanel jPanelshichang = new JPanel();
		jPanelshichang.setOpaque(false);
		jPanelshichang.setLayout(new FlowLayout());
		// ʱ��ͼƬ
		ImageIcon imageIcon_shichang = new ImageIcon(
				Login.class.getResource("/com/today/images/shichang.png"));
		imageIcon_shichang.setImage(imageIcon_shichang.getImage()
				.getScaledInstance(80, 40, Image.SCALE_DEFAULT));
		JLabel jLabel_shichangtu = new JLabel(imageIcon_shichang, JLabel.RIGHT);
		jPanelshichang.add(jLabel_shichangtu);
		jPanelshichang.add(jTextField_xiangqing_shichang);

		/**
		 * ״̬
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
		jComboBox_xiangqing_zhuangtai.setMaximumRowCount(3);
		// ���� ���õ�Ԫ��
		jComboBox_xiangqing_zhuangtai.setRenderer(new JComboBox_Item());
		jComboBox_xiangqing_zhuangtai.setBackground(Color.black);
		jComboBox_xiangqing_zhuangtai.setSize(80, 40);
		jComboBox_xiangqing_zhuangtai.addItem(new Object[] {
				imageIcon_daianpai, "������", "today��Ժ��Ŀ״̬" });
		jComboBox_xiangqing_zhuangtai.addItem(new Object[] { imageIcon_yianpai,
				"�Ѱ���", "today��Ժ��Ŀ״̬" });
		jComboBox_xiangqing_zhuangtai.addItem(new Object[] { imageIcon_xiaxian,
				"����", "today��Ժ��Ŀ״̬" });
		jPanelzhuangtai.add(jComboBox_xiangqing_zhuangtai);

		/**
		 * ��Ŀ���
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
		jTextField_xiangqing_infor.setSize(300, 500);
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
		jButton_xiangqing_image = new JButton("����", imageIcon_button);
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

		jButton_xaingqing_goupiao = new JButton("��Ʊ", imageIcon_button);
		jButton_xaingqing_goupiao.setContentAreaFilled(false);
		jButton_xaingqing_goupiao.setForeground(Color.black);
		jButton_xaingqing_goupiao.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				data_Schedule.removeAll(data_Schedule);
				scheduleShuJuRuKou();
				model_Schedule.fireTableDataChanged();
				jPanels_yingpiao.removeAll(jPanels_yingpiao);
				shengchengpiaos(jPanel_infor);
				setSelectedIndex(2);
			}
		});
		jPanelfanhui.add(jButton_xaingqing_goupiao);
		jTextField_xiangqing_infor.setEditable(false);
		jTextField_xiangqing_name.setEditable(false);
		jTextField_xiangqing_piaojia.setEditable(false);
		jTextField_xiangqing_shichang.setEditable(false);
		jPanel.setLayout(new GridLayout(1, 2));
		jPanel.setOpaque(false);

		/**
		 * ���
		 */
		JPanel jPanelyi0 = new JPanel();
		jPanelyi0.setLayout(new GridLayout(3, 1));
		jPanelyi0.setOpaque(false);
		jPanelyi0.add(jLabel_xiangqing_image, FlowLayout.LEFT);
		jPanelyi0.add(jPaneljianjie);
		JPanel jPanelq = new JPanel();
		jPanelq.setOpaque(false);
		jPanelyi0.add(jPanelq);

		/**
		 * �ʱ�
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
	 * �ݳ��ƻ�  �� ����
	 * @return
	 */
	private JPanel jPanel_Schedule(){
		JPanel jPanel = new JPanel();
		jPanel.setOpaque(false);

		ImageIcon imageIcon_yuangongzengjia = new ImageIcon(
				Login.class
						.getResource("/com/today/images/yanchujihua.png"));
		imageIcon_yuangongzengjia.setImage(imageIcon_yuangongzengjia.getImage()
				.getScaledInstance(300, 70, Image.SCALE_DEFAULT));
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
	 * �ݳ��ƻ��ĵ���¼�����
	 */
	private void listDianJiShiJian() {
		/**
		 * ����button�� ����¼�����
		 */
		jButton_search_Schedule.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String string_search = jTextField_search_Schedule.getText();
				System.out.println(string_search);
				if (!string_search.equals("")) {
					data_Schedule.removeAll(data_Schedule);
					for (int i = 0; i < scheduleInformations_Schedule.size(); i++) {
						for (int j = 0; j < playInformations_Schedule.size(); j++) {
							if (playInformations_Schedule.get(j).getPlay_name()
									.contains(string_search)) {
								String id = playInformations_Schedule.get(j)
										.getPlay_id();
								if (scheduleInformations_Schedule.get(i).getPlay_id()
										.equals(id)) {
									Object[] objects = new Object[6];
									objects[5] = new JButton();
									objects[0] = scheduleInformations_Schedule.get(i)
											.getSched_id();
									String fangyinting = scheduleInformations_Schedule
											.get(i).getStudio_id();
									// System.out.println("---->"+scheduleInformations.get(i).getStudio_id());
									for (int q = 0; q < studioInformations_Schedule
											.size(); q++) {
										if (studioInformations_Schedule.get(q)
												.getStudio_id()
												.contains(fangyinting)) {
											objects[1] = studioInformations_Schedule
													.get(q).getStudio_name();
										}
									}

									String jumu = scheduleInformations_Schedule.get(i)
											.getPlay_id();
									for (int q = 0; q < playInformations_Schedule.size(); q++) {

										if (playInformations_Schedule.get(q)
												.getPlay_id().contains(jumu)) {
											objects[2] = playInformations_Schedule
													.get(q).getPlay_name();
										}
									}
									String t = "";
									String time = scheduleInformations_Schedule.get(i).getTime_id();
									for (int q = 0; q < timeInformations_Schedule.size(); q++) {

										if (timeInformations_Schedule.get(q).getTime_id().contains(time)) {
											t = timeInformations_Schedule.get(q).getTime();
										}
									}
									objects[3] = scheduleInformations_Schedule.get(i)
											.getSched_time()+"-"+t;
									objects[4] = scheduleInformations_Schedule.get(i)
											.getSched_ticket_price();
									data_Schedule.add(objects);
								}
							}
						}

					}
					if (data_Schedule.size() != 0) {
						model_Schedule.fireTableDataChanged();
					}
				} else {
					data_Schedule.removeAll(data_Schedule);
					scheduleShuJuRuKou();
					model_Schedule.fireTableDataChanged();

				}
			}
		});

		jButton_back_Schedule.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				setSelectedIndex(0);
			}
		});

	}

	/**
	 * ��λѡ��
	 *
	 * @return
	 */
	private JPanel jPanel_Seat() {

		JPanel jPanel = new JPanel();
		jPanel.setOpaque(false);
		jPanel.setLayout(new GridBagLayout());
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		Insets insets = new Insets(0, 5, 10, 5);
		gridBagConstraints.insets = insets;

		ImageIcon imageIcon_zuoweixuanze = new ImageIcon(
				Login.class
						.getResource("/com/today/images/zuoweiyulan.png"));
		imageIcon_zuoweixuanze.setImage(imageIcon_zuoweixuanze.getImage()
				.getScaledInstance(200, 60, Image.SCALE_DEFAULT));
		JLabel jLabel_niaokantu = new JLabel(imageIcon_zuoweixuanze);
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.weightx = 80;
		gridBagConstraints.weighty = 10;
		jPanel.add(jLabel_niaokantu, gridBagConstraints);

		ImageIcon imageIcon_mingcheng = new ImageIcon(
				Login.class
						.getResource("/com/today/images/xuanpiaozhuangkuang.png"));
		imageIcon_mingcheng.setImage(imageIcon_mingcheng.getImage()
				.getScaledInstance(200, 60, Image.SCALE_DEFAULT));

		JLabel jLabel_xinxi = new JLabel(imageIcon_mingcheng);
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.weightx = 15;
		gridBagConstraints.weighty = 10;
		jLabel_xinxi.setFont(new java.awt.Font("Dialog", 1, 30));
		jLabel_xinxi.setForeground(Color.black);
		jPanel.add(jLabel_xinxi, gridBagConstraints);

		gridBagConstraints.fill = GridBagConstraints.BOTH;

		/**
		 * �ݳ�������λ������Ϣ
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
		gridBagConstraints.weightx = 80;
		gridBagConstraints.weighty = 200;

		jPanel.add(scrollPane, gridBagConstraints);

		/**
		 * Ʊ�Ļ�����Ϣ
		 */
		JPanel jPanel4 = piaoInfor();
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
	 * ѡƱ�Ļ�����Ϣ
	 * @return
	 */
	private JPanel piaoInfor(){

		JPanel jPanel = new JPanel();

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
		/**
		 * Ʊ��״̬��ʾ
		 */
		jPanel_wei.setOpaque(false);
		jPanel_wei.setLayout(new GridLayout(2, 1));
		JPanel jPanelwei0 = new JPanel();
		jPanelwei0.setLayout(new FlowLayout());
		jPanelwei0.setOpaque(false);
		JPanel jPanelwei1 = new JPanel();
		jPanelwei1.setLayout(new FlowLayout());
		jPanelwei1.setOpaque(false);
		ImageIcon imageIcon_daishou = new ImageIcon(
				Login.class.getResource("/com/today/images/piaowei.png"));
		imageIcon_daishou.setImage(imageIcon_daishou.getImage().getScaledInstance(30,
				30, Image.SCALE_DEFAULT));
		JLabel jLabel_daishou = new JLabel(imageIcon_daishou);
		jLabel_daishou.setText(" -- ����  ");
		jLabel_daishou.setFont(new java.awt.Font("Dialog", 1, 20));
		jLabel_daishou.setForeground(Color.green);

		ImageIcon imageIcon_xuanzhong = new ImageIcon(
				Login.class.getResource("/com/today/images/yudingpiao.png"));
		imageIcon_xuanzhong.setImage(imageIcon_xuanzhong.getImage().getScaledInstance(30,
				30, Image.SCALE_DEFAULT));
		JLabel jLabel_xuanzhong = new JLabel(imageIcon_xuanzhong);
		jLabel_xuanzhong.setText(" -- ѡ��  ");
		jLabel_xuanzhong.setFont(new java.awt.Font("Dialog", 1, 20));
		jLabel_xuanzhong.setForeground(Color.decode(Integer.valueOf("960096", 16)
				.toString()));

		ImageIcon imageIcon_yishouchu = new ImageIcon(
				Login.class.getResource("/com/today/images/piaoyishouchu.png"));
		imageIcon_yishouchu.setImage(imageIcon_yishouchu.getImage().getScaledInstance(30,
				30, Image.SCALE_DEFAULT));
		JLabel jLabel_yishouchu = new JLabel(imageIcon_yishouchu);
		jLabel_yishouchu.setText(" -- ���۳�  ");
		jLabel_yishouchu.setFont(new java.awt.Font("Dialog", 1, 20));
		jLabel_yishouchu.setForeground(Color.red);
		jPanelwei0.add(jLabel_daishou);
		jPanelwei0.add(jLabel_xuanzhong);
		jPanelwei1.add(jLabel_yishouchu);
		jPanel_wei.add(jPanelwei0);
		jPanel_wei.add(jPanelwei1);

		jPanel.add(jPanel_wei, gridBagConstraints);

		JScrollPane scrollPane1 = new JScrollPane(
				ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

		scrollPane1.setOpaque(false);
		scrollPane1.getViewport().setOpaque(false);
		jPanel_infor = new JPanel();
		jPanel_infor.revalidate();
		shengchengpiaos(jPanel_infor);
		scrollPane1.setViewportView(jPanel_infor);
		//jPanel_nei.setBackground(Color.red);
		jPanel_infor.setOpaque(false);
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.weightx = 200;
		gridBagConstraints.weighty = 800;
		jPanel.add(scrollPane1, gridBagConstraints);

		/**
		 * Ʊ�ĵ���  ��button����
		 */
		JPanel jPanel_button = new JPanel();
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.weightx = 200;
		gridBagConstraints.weighty = 10;
		jPanel_button.setOpaque(false);
		jPanel_button.setLayout(new GridLayout(2, 1));

		JPanel jPanelbutton2 = new JPanel();
		jPanelbutton2.setOpaque(false);
		jPanelbutton2.setLayout(new FlowLayout());
		jLabel_piaojia = new JLabel();
		jLabel_piaojia.setText("ѡ�� 0 ��   ���� 0 Ԫ");
		jLabel_piaojia.setFont(new java.awt.Font("Dialog", 1, 25));
		jLabel_piaojia.setForeground(Color.red);
		jPanelbutton2.add(jLabel_piaojia);
		jPanel_button.add(jPanelbutton2);

		JPanel jPanelbutton3 = new JPanel();
		jPanelbutton3.setOpaque(false);
		jPanelbutton3.setLayout(new FlowLayout());

		JPanel jPanel40 = new JPanel();
		jPanel40.setOpaque(false);
		jPanel40.setLayout(new FlowLayout(FlowLayout.RIGHT));
		ImageIcon imageIcon_button = new ImageIcon(
				Login.class.getResource("/com/today/images/button.png"));
		imageIcon_button.setImage(imageIcon_button.getImage()
				.getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		jButton_goupiao = new JButton("��Ʊ", imageIcon_button);
		jButton_goupiao.setContentAreaFilled(false);
		jButton_goupiao.setForeground(Color.black);
		jPanel40.add(jButton_goupiao);
		jPanelbutton3.add(jPanel40);
		JPanel jPanel41 = new JPanel();
		jPanel41.setOpaque(false);
		jPanel41.setLayout(new FlowLayout(FlowLayout.LEFT));
		jButton_fanhui = new JButton("����", imageIcon_button);
		jButton_fanhui.setContentAreaFilled(false);
		jButton_fanhui.setForeground(Color.black);
		jPanel41.add(jButton_fanhui);
		jPanelbutton3.add(jPanel41);

		jPanel_button.add(jPanelbutton3);

		jPanel.add(jPanel_button, gridBagConstraints);
		return jPanel;
	}
	/**
	 * ����  Ʊ
	 * @param yingting
	 * @param shijian
	 * @param yingpianming
	 * @param hang
	 * @param lie
	 * @param piaojia
	 * @return
	 */
	private MyPanel shengchengpiao(String yingting,String shijian,String yingpianming
			,String hang,String lie,String piaojia ,String id){

		System.out.println("yingpianming---->"+yingpianming);
		 ImageIcon imageIcon_login_hudie = new ImageIcon(
				Login.class.getResource("/com/today/images/yingpiaobiankuang.png"));
		 imageIcon_login_hudie.setImage(imageIcon_login_hudie.getImage()
					.getScaledInstance(160, 320, Image.SCALE_DEFAULT));
		 MyPanel jPanel = new MyPanel(imageIcon_login_hudie.getImage(), 160, 320);
		jPanel.setOpaque(false);
		jPanel.setName(hang+"+"+lie);
		jPanel.setLayout(new GridLayout(7, 1));
		JPanel jPanel8 = new JPanel();
		jPanel8.setOpaque(false);
		jPanel.add(jPanel8);
		/**
		 * ��Ժ����
		 */
		JPanel jPanel0 = new JPanel();
		jPanel0.setLayout(new FlowLayout());
		jPanel0.setOpaque(false);
		ImageIcon imageIcon_juyuanming = new ImageIcon(
				Login.class.getResource("/com/today/images/juyuanming.png"));
		imageIcon_juyuanming.setImage(imageIcon_juyuanming.getImage()
				.getScaledInstance(200, 50, Image.SCALE_DEFAULT));
		JLabel jLabel_juyuanming = new JLabel(imageIcon_juyuanming);
		jPanel0.add(jLabel_juyuanming);
		jPanel.add(jPanel0);

		/**
		 * Ӱ��  ����λ id
		 */
		JPanel jPanel1 = new JPanel();
		jPanel1.setLayout(new FlowLayout());
		jPanel1.setOpaque(false);
		//Ӱ��
		JPanel jPanel10 = new JPanel();
		jPanel10.setLayout(new FlowLayout());
		jPanel10.setOpaque(false);
		ImageIcon imageIcon_yingting = new ImageIcon(
				Login.class.getResource("/com/today/images/yingting.png"));
		imageIcon_yingting.setImage(imageIcon_yingting.getImage()
				.getScaledInstance(60, 30, Image.SCALE_DEFAULT));
		JLabel jLabel_yingtingtu = new JLabel(imageIcon_yingting);
		jPanel10.add(jLabel_yingtingtu);
		JLabel jLabel_yingting = new JLabel(yingting);
		jLabel_yingting.setFont(new Font("Dialog", 0, 20));
		jLabel_yingting.setForeground(Color.black);
		jPanel10.add(jLabel_yingting);
		jPanel1.add(jPanel10);
		//Ʊid
		JPanel jPanel11 = new JPanel();
		jPanel11.setLayout(new FlowLayout());
		jPanel11.setOpaque(false);
		ImageIcon imageIcon_id = new ImageIcon(
				Login.class.getResource("/com/today/images/id.png"));
		imageIcon_id.setImage(imageIcon_id.getImage()
				.getScaledInstance(60, 30, Image.SCALE_DEFAULT));
		JLabel jLabel_idtu = new JLabel(imageIcon_id);
		jPanel10.add(jLabel_idtu);
		JLabel jLabel_id = new JLabel(id);
		jLabel_id.setFont(new Font("Dialog", 0, 20));
		jLabel_id.setForeground(Color.black);
		jPanel10.add(jLabel_id);
		jPanel1.add(jPanel11);
		jPanel.add(jPanel1);

		/**
		 * ʱ��
		 */
		JPanel jPanel2 = new JPanel();
		jPanel2.setLayout(new FlowLayout());
		jPanel2.setOpaque(false);
		ImageIcon imageIcon_shijian = new ImageIcon(
				Login.class.getResource("/com/today/images/shijian.png"));
		imageIcon_shijian.setImage(imageIcon_shijian.getImage()
				.getScaledInstance(60, 30, Image.SCALE_DEFAULT));
		JLabel jLabel_shijiantu = new JLabel(imageIcon_shijian);
		jPanel2.add(jLabel_shijiantu);
		JLabel jLabel_shijian = new JLabel(shijian);
		jLabel_shijian.setFont(new Font("Dialog", 0, 15));
		jLabel_shijian.setForeground(Color.black);
		jPanel2.add(jLabel_shijian);
		jPanel.add(jPanel2);

		/**
		 * ӰƬ����
		 */
		JPanel jPanel3 = new JPanel();
		jPanel3.setLayout(new FlowLayout());
		jPanel3.setOpaque(false);
		ImageIcon imageIcon_yingming = new ImageIcon(
				Login.class.getResource("/com/today/images/yingming.png"));
		imageIcon_yingming.setImage(imageIcon_yingming.getImage()
				.getScaledInstance(60, 30, Image.SCALE_DEFAULT));
		JLabel jLabel_yingmingtu = new JLabel(imageIcon_yingming);
		jPanel3.add(jLabel_yingmingtu);
		JLabel jLabel_yingming = new JLabel(yingpianming);
		jLabel_yingming.setFont(new Font("Dialog", 0, 15));
		jLabel_yingming.setForeground(Color.black);
		jPanel3.add(jLabel_yingming);
		jPanel.add(jPanel3);

		/**
		 * ��λ ��λ��  �к�  ��
		 */
		JPanel jPanel4 = new JPanel();
		jPanel4.setLayout(new FlowLayout());
		jPanel4.setOpaque(false);
		ImageIcon imageIcon_zuowei = new ImageIcon(
				Login.class.getResource("/com/today/images/weizhi.png"));
		imageIcon_zuowei.setImage(imageIcon_zuowei.getImage()
				.getScaledInstance(60, 30, Image.SCALE_DEFAULT));
		JLabel jLabel_zuoweitu = new JLabel(imageIcon_zuowei);
		jPanel4.add(jLabel_zuoweitu);
		JLabel jLabel_zuowei = new JLabel("��  "+hang+" ��, �� "+lie+" ��");
		jLabel_zuowei.setFont(new Font("Dialog", 0, 15));
		jLabel_zuowei.setForeground(Color.black);
		jPanel4.add(jLabel_zuowei);
		jPanel.add(jPanel4);

		/**
		 * Ʊ��
		 */
		JPanel jPanel5 = new JPanel();
		jPanel5.setLayout(new FlowLayout());
		jPanel5.setOpaque(false);
		ImageIcon imageIcon_piaojia = new ImageIcon(
				Login.class.getResource("/com/today/images/piaojia.png"));
		imageIcon_piaojia.setImage(imageIcon_piaojia.getImage()
				.getScaledInstance(60, 30, Image.SCALE_DEFAULT));
		JLabel jLabel_piaojiatu = new JLabel(imageIcon_piaojia);
		jPanel5.add(jLabel_piaojiatu);
		JLabel jLabel_piaojia = new JLabel(piaojia);
		jLabel_piaojia.setFont(new Font("Dialog", 0, 15));
		jLabel_piaojia.setForeground(Color.black);
		jPanel5.add(jLabel_piaojia);
		jPanel.add(jPanel5);

		return jPanel;
	}

	/**
	 * ��������Ʊ
	 */
	private void shengchengpiaos(JPanel jPanel){
		jPanel_infor.removeAll();
		jPanel.setLayout(new GridLayout(jPanels_yingpiao.size(),1));
		for (int i = 0; i < jPanels_yingpiao.size(); i++) {
			jPanel.add(jPanels_yingpiao.get(i));
		}
		jPanel_infor.updateUI();
		jPanel_infor.validate();
		jPanel_infor.repaint();
	}

	/**
	 * Ʊ�ĵ���¼�
	 */
	private void piaoDianji(){
		jButton_fanhui.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				setSelectedIndex(2);
				jPanels_yingpiao.removeAll(jPanels_yingpiao);
				shengchengpiaos(jPanel_infor);
			}
		});

		jButton_goupiao.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				for (int i = 0; i < jButtons.length; i++) {
					for (int j = 0; j < jButtons[0].length; j++) {
						String s = jButtons[i][j].getName();
						if (s.equals("2")) {
							ImageIcon imageIcon_sun = new ImageIcon(
									Login.class.getResource("/com/today/images/piaoyishouchu.png"));
							imageIcon_sun.setImage(imageIcon_sun.getImage()
									.getScaledInstance(25, 25, Image.SCALE_DEFAULT));
							piao[i][j] = 1;
							jButtons[i][j].setName("1");
							jButtons[i][j].setIcon(imageIcon_sun);
						}else if (s.equals("0")) {
							piao[i][j] = 0;
						}else if (s.equals("1")) {
							piao[i][j] = 1;
						}else {
							piao[i][j] = 6;
						}
					}
				}
				jiage = 0;
				jPanels_yingpiao.removeAll(jPanels_yingpiao);
				shengchengpiaos(jPanel_infor);
				Schedule schedule = new Schedule();
				List<ScheduleInformation> scheduleInformation = new ArrayList<ScheduleInformation>();
				scheduleInformation = schedule.prinfSchedule(string_piao_id);
				TicketMath ticketMath = new TicketMath();
				if (ticketMath.changeticket(piao, string_piao_id,
						scheduleInformation.get(0).getStudio_id())) {
					//System.out.println("------->��Ʊ�ɹ�");
				}
				JOptionPane.showMessageDialog(
						Administrator.jFrame_GuanLi.getContentPane(),
						"��Ʊ�ɹ�", "today��Ʊϵͳ��ʾ",
						JOptionPane.WARNING_MESSAGE);
				jLabel_piaojia.setText("��ѡ�� "+0+"  ����: "+0+" Ԫ" );
				/**
				 * Ʊ�Ĳ���  ������������
				 */
//
			}
		});

	}

	/**
	 * Ʊ�� ���ͼ
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
		 * ��Ŀ�޸ĵ�ͼƬ
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
		 * ѡƱ�ĵ��µĽ���
		 */
		jPanel_piao = new JPanel();
		piao = studioSeat(string_piao_id, jPanel_piao);
		jPanel_piao.setOpaque(false);
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.weightx = 200;
		gridBagConstraints.weighty = 200;
		jPanel.add(jPanel_piao, gridBagConstraints);

		return jPanel;
	}

	/**
	 * ��λ����
	 * @param studio_id
	 * @return
	 */
	public int[][] studioSeat(String sched_id,JPanel jPanel){
		int[][] seat;
		List<ScheduleInformation> ScheduleInformation = new ArrayList<ScheduleInformation>();
		Schedule schedule = new Schedule();
		ScheduleInformation = schedule.prinfSchedule(sched_id);
		jPanel.setOpaque(false);
		List<StudioInformation> studioInformations = new ArrayList<StudioInformation>();
		Studio studio = new Studio();

		studioInformations = studio.prinfStudio(ScheduleInformation.get(0).getStudio_id());
		//System.out.println("size = " + studioInformations.size());
		String keyong = studioInformations.get(0).getStudio_isavailable();
		//System.out.println("keyong"+"--->"+keyong);

		TicketMath ticketMath = new TicketMath();
		seat = ticketMath.ticketArray(sched_id
				, studioInformations.get(0).getStudio_row_count(),
				studioInformations.get(0).getStudio_col_count());

		if (keyong.equals("true")) {
			jPanel.setLayout(new GridLayout(seat.length, seat[0].length,5,5));

			ImageIcon imageIcon_hao = new ImageIcon(
					Login.class.getResource("/com/today/images/piaowei.png"));
			imageIcon_hao.setImage(imageIcon_hao.getImage()
					.getScaledInstance(25, 25, Image.SCALE_DEFAULT));

			ImageIcon imageIcon_sun = new ImageIcon(
					Login.class.getResource("/com/today/images/piaoyishouchu.png"));
			imageIcon_sun.setImage(imageIcon_sun.getImage()
					.getScaledInstance(25, 25, Image.SCALE_DEFAULT));
			jButtons = new JButton[seat.length][seat[0].length];
			jiage = 0;
			for (int i = 0; i < seat.length; i++) {
				for (int j = 0; j < seat[0].length; j++) {
					/**
					 * 0����λ����״̬   ����
					 * 1: ��λ���۳�
					 * 6: ��λ��
					 */
					if (seat[i][j] == 0) {
						jButtons[i][j] = new JButton(imageIcon_hao);
						jButtons[i][j].setContentAreaFilled(false);
						jButtons[i][j].setName("0");
					}else if(seat[i][j] == 1){
						jButtons[i][j] = new JButton(imageIcon_sun);
						jButtons[i][j].setContentAreaFilled(false);
						jButtons[i][j].setName("1");
					}else {
						jButtons[i][j] = new JButton();
						jButtons[i][j].setContentAreaFilled(false);
						jButtons[i][j].setName("6");
					}
					jPanel.add(jButtons[i][j]);

					final int hang = i+1;
					final int lie = j+1;

					jButtons[i][j].addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent arg0) {
							// TODO Auto-generated method stub
							JButton button = (JButton) arg0.getSource();
							String s = button.getName();
							if (s.equals("0")) {
								jiage++;

								jPanels_yingpiao.add(shengchengpiao
										(string_yingting, string_shijian, string_yingpianming,
												hang+"", lie+"", ""+piaojia, ""+(hang*10+lie)));
								shengchengpiaos(jPanel_infor);
								ImageIcon imageIcon_sun1 = new ImageIcon(
										Login.class.getResource("/com/today/images/yudingpiao.png"));
								imageIcon_sun1.setImage(imageIcon_sun1.getImage()
										.getScaledInstance(25, 25, Image.SCALE_DEFAULT));
								button.setIcon(imageIcon_sun1);
								button.setName("2");
							}else if(s.equals("2")){
								jiage--;
								ImageIcon imageIcon_hao1 = new ImageIcon(
										Login.class.getResource("/com/today/images/piaowei.png"));
								imageIcon_hao1.setImage(imageIcon_hao1.getImage()
										.getScaledInstance(25, 25, Image.SCALE_DEFAULT));
								button.setIcon(imageIcon_hao1);
								for (int k = 0; k < jPanels_yingpiao.size(); k++) {
									if (jPanels_yingpiao.get(k).getName().equals(hang+"+"+lie)) {
										jPanels_yingpiao.remove(k);
									}
								}
								shengchengpiaos(jPanel_infor);
								button.setName("0");
							}
							System.out.println("jiage---->"+jiage);
							System.out.println("��--->"+hang);
							System.out.println("��--->"+lie);
							jLabel_piaojia.setText("��ѡ�� "+jiage+"  ����: "+(jiage*piaojia)+" Ԫ" );
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
		jTextField_search_Schedule = new JTextField(20);
		jTextField_search_Schedule.setOpaque(false);
		jTextField_search_Schedule.setForeground(Color.red);
		jPanel_wei.add(jTextField_search_Schedule);
		jButton_search_Schedule = new JButton(imageIcon_search);
		jButton_search_Schedule.setContentAreaFilled(false);
		jPanel_wei.add(jButton_search_Schedule);
		ImageIcon imageIcon_back = new ImageIcon(
				Login.class.getResource("/com/today/images/back.png"));
		imageIcon_back.setImage(imageIcon_back.getImage()
				.getScaledInstance(40, 40, Image.SCALE_DEFAULT));
		jButton_back_Schedule = new JButton(imageIcon_back);
		jButton_back_Schedule.setContentAreaFilled(false);
		jPanel_wei.add(jButton_back_Schedule);
		jPanel.add(jPanel_wei, gridBagConstraints);

		/**
		 * Ա�������б�
		 */
		JPanel jPanel_nei = new PlayInformationjp_Schedule();
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
	 * jbutton �����޸�
	 *
	 * @author lwp940118
	 *
	 */
	class JtableButtongouPiao extends AbstractCellEditor implements
			TableCellEditor, TableCellRenderer, ActionListener {
		// ��ť������״̬
		private JButton rb, eb;
		private int row;
		private JTable table;
		private String text = "��Ʊ";
		private ImageIcon imageIcon_shanchu = new ImageIcon(
				Login.class.getResource("/com/today/images/piao.png"));

		public JtableButtongouPiao() {
		}

		public JtableButtongouPiao(JTable table, int column) {
			super();
			this.table = table;
			imageIcon_shanchu.setImage(imageIcon_shanchu.getImage()
					.getScaledInstance(30, 30, Image.SCALE_DEFAULT));
			rb = new JButton("��Ʊ", imageIcon_shanchu);
			eb = new JButton("��Ʊ", imageIcon_shanchu);
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
			System.out.println("ѡ�е�ֵΪ��" +table.getValueAt(row, 0));
			int v = Integer.valueOf( table.getValueAt(row, 0).toString());
			System.out.println("ѡ�е�ֵΪ��" + v);
			// ���½����� �е�ֵ
			String id = table.getValueAt(row, 0).toString();

			string_goupiao = table.getValueAt(row, 0).toString();
			data_Schedule.removeAll(data_Schedule);
			scheduleShuJuRuKou();
			model_Schedule.fireTableDataChanged();
			setSelectedIndex(2);

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
			string_goupiao = table.getValueAt(row, 0).toString();
			Play play = new Play();
			List<PlayInformation> list = play.prinfPlay(id);

			jTextField_xiangqing_infor.setText(list.get(0)
					.getPlay_introduction());
			jTextField_xiangqing_name.setText(list.get(0).getPlay_name());
			jTextField_xiangqing_piaojia.setText(list.get(0)
					.getPlay_ticket_price());
			jTextField_xiangqing_shichang.setText(list.get(0).getPlay_length());
			String leixing = list.get(0).getPlay_type_id();
			String yuyan = list.get(0).getPlay_lang_id();
			String zhuangtai = list.get(0).getPlay_status();
			if (leixing.equals("���")) {
				jComboBox_xiangqing_leixing.setSelectedIndex(0);
			} else {

				jComboBox_xiangqing_leixing.setSelectedIndex(1);
			}
			if (yuyan.equals("����")) {
				jComboBox_xiangqing_yuyan.setSelectedIndex(0);
			} else {
				jComboBox_xiangqing_yuyan.setSelectedIndex(1);
			}
			if (zhuangtai.equals("������")) {
				jComboBox_xiangqing_zhuangtai.setSelectedIndex(0);
			} else if (zhuangtai.equals("�Ѱ���")) {
				jComboBox_xiangqing_zhuangtai.setSelectedIndex(1);
			} else {
				jComboBox_xiangqing_zhuangtai.setSelectedIndex(3);
			}
			String string = list.get(0).getPlay_image();
			ImageIcon imageIcon_image = new ImageIcon(
					Login.class.getResource("/com/today/images/" + string));
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
			// �༭�У��к�
			this.row = row;
			return eb;
		}
	}

	// �Զ�����ģ��
	class MyTableModel_movie extends AbstractTableModel {
		// ��Ԫ��Ԫ������
		private Class[] cellType = { String.class, String.class, String.class,
				String.class, String.class, JButton.class, JButton.class,
				JButton.class };
		// ��ͷ
		private String title[] = { "��Ŀid", "����", "ʱ��", "����", "����", "����", "��Ʊ" };
		// ģ������
		private List<Object[]> data = new ArrayList<Object[]>();

		public MyTableModel_movie(List<Object[]> data) {
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

	class MovieInformationjp extends JPanel {

		public MovieInformationjp() {
			setOpaque(false);
			setLayout(new BorderLayout());
			/**
			 * Ա���������
			 */
			palyShuJuRuKou();
			model_movie = new MyTableModel_movie(data_movie);
			table_movie = new JTable(model_movie);
			// ���뵥Ԫ��Ԫ�أ������Զ���Ԫ��
			JtableButtonxiangqing xiang = new JtableButtonxiangqing(
					table_movie, 5);
			JtableButtongouPiao xiugai = new JtableButtongouPiao(table_movie, 6);
			table_movie.setRowHeight(50);
			table_movie.getTableHeader().setFont(new Font("Dialog", 0, 30));
			table_movie.getTableHeader().setForeground(Color.blue);
			table_movie.getTableHeader().setOpaque(false);

			table_movie.setFont(new Font("Dialog", 0, 20));
			table_movie.setForeground(Color.black);
			table_movie.setOpaque(false);

			/*
			 * TableColumn column = table.getColumnModel().getColumn(2); // �� 2
			 * �� column.setPreferredWidth(getPreferredWidthForColumn(column));
			 */

			DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
			renderer.setOpaque(false);
			renderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
			table_movie.setDefaultRenderer(Object.class, renderer);
			JScrollPane jsp = new JScrollPane(table_movie);
			jsp.setOpaque(false);
			jsp.getViewport().setOpaque(false);

			add(BorderLayout.CENTER, jsp);

		}
	}

	/**
	 * ��Ŀ�ĺ� �������
	 */
	private void palyShuJuRuKou() {
		Play play = new Play();
		playInformations_movie = play.prinfPlays();

		for (int i = 0; i < playInformations_movie.size(); i++) {
			Object[] objects = new Object[7];
			objects[5] = new JButton();
			objects[6] = new JButton();
			objects[0] = playInformations_movie.get(i).getPlay_id();
			objects[1] = playInformations_movie.get(i).getPlay_name();
			objects[2] = playInformations_movie.get(i).getPlay_length();
			objects[3] = playInformations_movie.get(i).getPlay_type_id();
			objects[4] = playInformations_movie.get(i).getPlay_lang_id();
			data_movie.add(objects);
		}

	}


	/**
	 * �ݳ��ƻ� �ı��
	 */

	/**
	 * jbutton �����޸�
	 *
	 * @author lwp940118
	 *
	 */
	class JtableButton_Schedule extends AbstractCellEditor implements
			TableCellEditor, TableCellRenderer, ActionListener {
		// ��ť������״̬
		private JButton rb, eb;
		private int row;
		private JTable table;
		private String text = "��Ʊ";
		private ImageIcon imageIcon_shanchu = new ImageIcon(
				Login.class.getResource("/com/today/images/piao.png"));

		public JtableButton_Schedule() {

		}

		public JtableButton_Schedule(JTable table, int column) {
			super();
			this.table = table;
			imageIcon_shanchu.setImage(imageIcon_shanchu.getImage()
					.getScaledInstance(30, 30, Image.SCALE_DEFAULT));
			rb = new JButton("��Ʊ", imageIcon_shanchu);
			eb = new JButton("��Ʊ", imageIcon_shanchu);
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



			string_piao_id = table.getValueAt(row, 0).toString();
			System.out.println("Ʊ��"+table.getValueAt(row, 4).toString());
			piaojia = Integer.parseInt(table.getValueAt(row, 4).toString());

			string_yingting = table.getValueAt(row, 1).toString();
			string_yingpianming = table.getValueAt(row, 2).toString();
			string_shijian = table.getValueAt(row, 3).toString();

			jPanel_piao.removeAll();
			piao = studioSeat(string_piao_id, jPanel_piao);
			jLabel_piaojia.setText("ѡ�� 0 ��   ���� 0 Ԫ");
//			jPanel_seat = new StudioSeat(string_infor);
			jPanel_piao.updateUI();
			jPanel_piao.validate();
			jPanel_piao.repaint();

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

	// �Զ�����ģ��
	class MyTableModel_Schedule extends AbstractTableModel {
		// ��Ԫ��Ԫ������
		private Class[] cellType = { String.class, String.class, String.class,
				String.class, String.class, JButton.class, JButton.class,
				JButton.class };
		// ��ͷ
		private String title[] = { "�ݳ��ƻ�id", "��ӳ��", "��Ŀ����", "ʱ��", "Ʊ��", "��Ʊ" };
		// ģ������
		private List<Object[]> data = new ArrayList<Object[]>();

		public MyTableModel_Schedule(List<Object[]> data) {
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

	class PlayInformationjp_Schedule extends JPanel {

		public PlayInformationjp_Schedule() {
			setOpaque(false);
			setLayout(new BorderLayout());
			/**
			 * Ա���������
			 */
			scheduleShuJuRuKou();
			model_Schedule = new MyTableModel_Schedule(data_Schedule);
			table_Schedule = new JTable(model_Schedule);
			// ���뵥Ԫ��Ԫ�أ������Զ���Ԫ��;
			JtableButton_Schedule xiugai = new JtableButton_Schedule(table_Schedule, 5);
			table_Schedule.setRowHeight(50);
			table_Schedule.getTableHeader().setFont(new Font("Dialog", 0, 30));
			table_Schedule.getTableHeader().setForeground(Color.blue);
			table_Schedule.getTableHeader().setOpaque(false);

			table_Schedule.setFont(new Font("Dialog", 0, 20));
			table_Schedule.setForeground(Color.black);
			table_Schedule.setOpaque(false);

			/*
			 * TableColumn column = table.getColumnModel().getColumn(2); // �� 2
			 * �� column.setPreferredWidth(getPreferredWidthForColumn(column));
			 */

			DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
			renderer.setOpaque(false);
			renderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
			table_Schedule.setDefaultRenderer(Object.class, renderer);
			JScrollPane jsp = new JScrollPane(table_Schedule);
			jsp.setOpaque(false);
			jsp.getViewport().setOpaque(false);

			add(BorderLayout.CENTER, jsp);

		}
	}

	/**
	 * ��� ���������
	 */
	private void addShuJuRuKou() {
		Studio studio = new Studio();
		studioInformations_Schedule = studio.prinfStudios();

		Play play = new Play();
		playInformations_Schedule = play.prinfPlays();

		Schedule_Time schedule_Time = new Schedule_Time();
		timeInformations_Schedule = schedule_Time.prinfTimes();


	}

	/**
	 * ��Ŀ�ĺ� �������
	 */
	private void scheduleShuJuRuKou() {
		Schedule schedule = new Schedule();
		scheduleInformations_Schedule = schedule.prinfScheduleMovie(string_goupiao);
		System.out.println("ѡ�е�ӰƬֵ--->"+scheduleInformations_Schedule.size());
		for (int i = 0; i < scheduleInformations_Schedule.size(); i++) {
			Object[] objects = new Object[6];
			objects[5] = new JButton();
			objects[0] = scheduleInformations_Schedule.get(i).getSched_id();
			String fangyinting = scheduleInformations_Schedule.get(i).getStudio_id();
			// System.out.println("---->"+scheduleInformations.get(i).getStudio_id());
			for (int j = 0; j < studioInformations_Schedule.size(); j++) {
				if (studioInformations_Schedule.get(j).getStudio_id()
						.contains(fangyinting)) {
					objects[1] = studioInformations_Schedule.get(j).getStudio_name();
				}
			}

			String jumu = scheduleInformations_Schedule.get(i).getPlay_id();
			for (int j = 0; j < playInformations_Schedule.size(); j++) {

				if (playInformations_Schedule.get(j).getPlay_id().contains(jumu)) {
					objects[2] = playInformations_Schedule.get(j).getPlay_name();
				}
			}
			String t = "";
			String time = scheduleInformations_Schedule.get(i).getTime_id();
			for (int j = 0; j < timeInformations_Schedule.size(); j++) {

				if (timeInformations_Schedule.get(j).getTime_id().contains(time)) {
					t = timeInformations_Schedule.get(j).getTime();
				}
			}
			objects[3] = scheduleInformations_Schedule.get(i).getSched_time()+"-"+t;
			objects[4] = scheduleInformations_Schedule.get(i).getSched_ticket_price();
			data_Schedule.add(objects);
		}

	}

}
