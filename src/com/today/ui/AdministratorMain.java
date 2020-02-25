package com.today.ui;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;

/**
 * ������Ҫд  ����Ա�������棬��
 * Ȼ��  ����  һЩ  ��Ӧ�Ĳ���
 *
 *
 */
public class AdministratorMain extends JTabbedPane{
	/**
	 * ����Ա  ������  �� tablepanel
	 */


	public AdministratorMain(){
		setOpaque(false);

		/**
		 * ��Ժ���
		 */
		ImageIcon imageIcon_juyaunjianjie = new ImageIcon(
				Login.class.getResource("/com/today/images/juyuanjianjie.png"));
		imageIcon_juyaunjianjie.setImage(imageIcon_juyaunjianjie.getImage()
				.getScaledInstance(120, 50, Image.SCALE_DEFAULT));
		JTabbedPane jTabbedPane_juyuanjianjie = jTabbedPane_JuYuanJianJie();
		addTab("",imageIcon_juyaunjianjie, jTabbedPane_juyuanjianjie);

		/**
		 * �ݳ�������
		 */
		ImageIcon imageIcon_yanchutingguanli = new ImageIcon(
				Login.class.getResource("/com/today/images/yanchuting.png"));
		imageIcon_yanchutingguanli.setImage(imageIcon_yanchutingguanli.getImage()
				.getScaledInstance(150, 50, Image.SCALE_DEFAULT));
		JTabbedPane jTabbedPane_yanchutingguanli = jTabbedPane_YanChuTingGuanLi();
		addTab("",imageIcon_yanchutingguanli, jTabbedPane_yanchutingguanli);

		/**
		 * ��Ŀ�ݳ��ƻ�
		 */
		ImageIcon imageIcon_yanchujihua = new ImageIcon(
				Login.class.getResource("/com/today/images/yanchujihua.png"));
		imageIcon_yanchujihua.setImage(imageIcon_yanchujihua.getImage()
				.getScaledInstance(120, 50, Image.SCALE_DEFAULT));
		JTabbedPane jTabbedPane_yanchuyanchujihua = jTabbedPane_YanChuJiHua();
		addTab("",imageIcon_yanchujihua, jTabbedPane_yanchuyanchujihua);

		/**
		 * ��Ŀ����
		 */
		ImageIcon imageIcon_jumuguanli = new ImageIcon(
				Login.class.getResource("/com/today/images/jumugaunli .png"));
		imageIcon_jumuguanli.setImage(imageIcon_jumuguanli.getImage()
				.getScaledInstance(120, 50, Image.SCALE_DEFAULT));
		JTabbedPane jTabbedPane_jumuguanli = jTabbedPane_JuMuGuanLi();
		addTab("",imageIcon_jumuguanli, jTabbedPane_jumuguanli);

		/**
		 * Ա������
		 */
		ImageIcon imageIcon_yuangongguanli = new ImageIcon(
				Login.class.getResource("/com/today/images/yuangongguanli.png"));
		imageIcon_yuangongguanli.setImage(imageIcon_yuangongguanli.getImage()
				.getScaledInstance(120, 50, Image.SCALE_DEFAULT));
		JTabbedPane jTabbedPane_yuangongguanli = jTabbedPane_yuangongguanliGuanLi();
		addTab("",imageIcon_yuangongguanli, jTabbedPane_yuangongguanli);

		/**
		 * ��������
		 */
		ImageIcon imageIcon_gerenzhongxin = new ImageIcon(
				Login.class.getResource("/com/today/images/gerenzhongxin.png"));
		imageIcon_gerenzhongxin.setImage(imageIcon_gerenzhongxin.getImage()
				.getScaledInstance(120, 50, Image.SCALE_DEFAULT));
		JTabbedPane jTabbedPane_gerenzhongxin = jTabbedPane_GeRenZhongXin();
		addTab("",imageIcon_gerenzhongxin, jTabbedPane_gerenzhongxin);
		//UIManager.put("TabbedPane.selected", Color.r);
		setBackground( new Color(1,1,0,0.0f));

	}

	/**
	 * Ա������
	 * @return
	 */
	private JTabbedPane jTabbedPane_yuangongguanliGuanLi() {
		JTabbedPane jTabbedPane = new AdministratorYuanGongGuanLi();
		jTabbedPane.setOpaque(false);
		jTabbedPane.setBackground( new Color(1,1,0,0.0f));

		return jTabbedPane;
	}

	/**
	 * ��Ŀ����
	 * @return
	 */
	private JTabbedPane jTabbedPane_JuMuGuanLi() {
		JTabbedPane jTabbedPane = new AdministratorPlayGuanLi();
		jTabbedPane.setOpaque(false);
		jTabbedPane.setBackground( new Color(1,1,0,0.0f));

		return jTabbedPane;
	}


	/**
	 * �ݳ��ƻ�  �İ���
	 * @return
	 */
	private JTabbedPane jTabbedPane_YanChuJiHua() {
		JTabbedPane jTabbedPane = new AdministratorSchedule();
		jTabbedPane.setOpaque(false);
		jTabbedPane.setBackground( new Color(1,1,0,0.0f));

		return jTabbedPane;
	}

	/**
	 * ��Ժ���
	 * @return
	 */
	private JTabbedPane jTabbedPane_JuYuanJianJie(){
		JTabbedPane jTabbedPane = new AdministratorJuYuanJianJie();
		jTabbedPane.setOpaque(false);
		jTabbedPane.setBackground( new Color(1,1,0,0.0f));

		return jTabbedPane;
	}

	/**
	 * ��������
	 * @return
	 */
	private JTabbedPane jTabbedPane_GeRenZhongXin(){
		JTabbedPane jTabbedPane = new AdministratorGeRenXinXi();
		jTabbedPane.setOpaque(false);
		jTabbedPane.setBackground( new Color(1,1,0,0.0f));

		return jTabbedPane;
	}

	/**
	 * �ݳ��� ����
	 * @return
	 */
	private JTabbedPane jTabbedPane_YanChuTingGuanLi(){
		JTabbedPane jTabbedPane = new AdministratorStudio();
		jTabbedPane.setOpaque(false);
		jTabbedPane.setBackground( new Color(1,1,0,0.0f));

		return jTabbedPane;
	}


}
