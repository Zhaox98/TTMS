package com.today.ui;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;

/**
 * 需求：主要写  售票员  的主界面，，
 * 然后  进行  一些  相应的操作
 *
 *
 */
public class ConductorMain extends JTabbedPane{
	/**
	 * 管理员  主界面  的 tablepanel
	 */


	public ConductorMain(){
		setOpaque(false);

		/**
		 * 剧院简介
		 */
		ImageIcon imageIcon_juyaunjianjie = new ImageIcon(
				Login.class.getResource("/com/today/images/juyuanjianjie.png"));
		imageIcon_juyaunjianjie.setImage(imageIcon_juyaunjianjie.getImage()
				.getScaledInstance(120, 50, Image.SCALE_DEFAULT));
		JTabbedPane jTabbedPane_juyuanjianjie = jTabbedPane_JuYuanJianJie();
		addTab("",imageIcon_juyaunjianjie, jTabbedPane_juyuanjianjie);


		/**
		 * 影片信息
		 */
		ImageIcon imageIcon_yingpianxinxi = new ImageIcon(
				Login.class.getResource("/com/today/images/yingpianxinxi.png"));
		imageIcon_yingpianxinxi.setImage(imageIcon_yingpianxinxi.getImage()
				.getScaledInstance(120, 50, Image.SCALE_DEFAULT));
		JTabbedPane jTabbedPane_yingpianxinxi = jTabbedPane_yingPianXinXi();
		addTab("",imageIcon_yingpianxinxi, jTabbedPane_yingpianxinxi);

		/**
		 * 退票窗口
		 */
		ImageIcon imageIcon_tuipiaochuangkou = new ImageIcon(
				Login.class.getResource("/com/today/images/tuipiaochaungkou.png"));
		imageIcon_tuipiaochuangkou.setImage(imageIcon_tuipiaochuangkou.getImage()
				.getScaledInstance(120, 50, Image.SCALE_DEFAULT));
		JTabbedPane jTabbedPane_tuipiaochuangkou = jTabbedPane_TuiPiaoChuangKou();
		addTab("",imageIcon_tuipiaochuangkou, jTabbedPane_tuipiaochuangkou);

		/**
		 * 个人中心
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
	 * 影片信息
	 * @return
	 */
	private JTabbedPane jTabbedPane_yingPianXinXi() {
		JTabbedPane jTabbedPane = new ConductorMovieInformation();
		jTabbedPane.setOpaque(false);
		jTabbedPane.setBackground( new Color(1,1,0,0.0f));

		return jTabbedPane;
	}

	/**
	 * 剧院简介
	 * @return
	 */
	private JTabbedPane jTabbedPane_JuYuanJianJie(){
		/**
		 * 复用管理员的  剧院简介  的界面
		 */
		JTabbedPane jTabbedPane = new ConductorJuYuanJianJie();
		jTabbedPane.setOpaque(false);
		jTabbedPane.setBackground( new Color(1,1,0,0.0f));

		return jTabbedPane;
	}

	/**
	 * 剧院简介
	 * @return
	 */
	private JTabbedPane jTabbedPane_TuiPiaoChuangKou(){
		/**
		 * 复用管理员的  剧院简介  的界面
		 */
		JTabbedPane jTabbedPane = new ConductorTuiPiaoChuangKou();
		jTabbedPane.setOpaque(false);
		jTabbedPane.setBackground( new Color(1,1,0,0.0f));

		return jTabbedPane;
	}

	/**
	 * 个人中心
	 * @return
	 */
	private JTabbedPane jTabbedPane_GeRenZhongXin(){
		JTabbedPane jTabbedPane = new ConductorGeRenXinXi();
		jTabbedPane.setOpaque(false);
		jTabbedPane.setBackground( new Color(1,1,0,0.0f));

		return jTabbedPane;
	}

}

