package com.today.ui;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;

/**
 * ������Ҫд  ��ƱԱ  �������棬��
 * Ȼ��  ����  һЩ  ��Ӧ�Ĳ���
 *
 *
 */
public class ConductorMain extends JTabbedPane{
	/**
	 * ����Ա  ������  �� tablepanel
	 */


	public ConductorMain(){
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
		 * ӰƬ��Ϣ
		 */
		ImageIcon imageIcon_yingpianxinxi = new ImageIcon(
				Login.class.getResource("/com/today/images/yingpianxinxi.png"));
		imageIcon_yingpianxinxi.setImage(imageIcon_yingpianxinxi.getImage()
				.getScaledInstance(120, 50, Image.SCALE_DEFAULT));
		JTabbedPane jTabbedPane_yingpianxinxi = jTabbedPane_yingPianXinXi();
		addTab("",imageIcon_yingpianxinxi, jTabbedPane_yingpianxinxi);

		/**
		 * ��Ʊ����
		 */
		ImageIcon imageIcon_tuipiaochuangkou = new ImageIcon(
				Login.class.getResource("/com/today/images/tuipiaochaungkou.png"));
		imageIcon_tuipiaochuangkou.setImage(imageIcon_tuipiaochuangkou.getImage()
				.getScaledInstance(120, 50, Image.SCALE_DEFAULT));
		JTabbedPane jTabbedPane_tuipiaochuangkou = jTabbedPane_TuiPiaoChuangKou();
		addTab("",imageIcon_tuipiaochuangkou, jTabbedPane_tuipiaochuangkou);

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
	 * ӰƬ��Ϣ
	 * @return
	 */
	private JTabbedPane jTabbedPane_yingPianXinXi() {
		JTabbedPane jTabbedPane = new ConductorMovieInformation();
		jTabbedPane.setOpaque(false);
		jTabbedPane.setBackground( new Color(1,1,0,0.0f));

		return jTabbedPane;
	}

	/**
	 * ��Ժ���
	 * @return
	 */
	private JTabbedPane jTabbedPane_JuYuanJianJie(){
		/**
		 * ���ù���Ա��  ��Ժ���  �Ľ���
		 */
		JTabbedPane jTabbedPane = new ConductorJuYuanJianJie();
		jTabbedPane.setOpaque(false);
		jTabbedPane.setBackground( new Color(1,1,0,0.0f));

		return jTabbedPane;
	}

	/**
	 * ��Ժ���
	 * @return
	 */
	private JTabbedPane jTabbedPane_TuiPiaoChuangKou(){
		/**
		 * ���ù���Ա��  ��Ժ���  �Ľ���
		 */
		JTabbedPane jTabbedPane = new ConductorTuiPiaoChuangKou();
		jTabbedPane.setOpaque(false);
		jTabbedPane.setBackground( new Color(1,1,0,0.0f));

		return jTabbedPane;
	}

	/**
	 * ��������
	 * @return
	 */
	private JTabbedPane jTabbedPane_GeRenZhongXin(){
		JTabbedPane jTabbedPane = new ConductorGeRenXinXi();
		jTabbedPane.setOpaque(false);
		jTabbedPane.setBackground( new Color(1,1,0,0.0f));

		return jTabbedPane;
	}

}

