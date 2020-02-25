package com.today.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

import com.xy.today.mycontrols.AnimationImagePanel;

/**
 * 管理员  的   剧院简介  。。。
 * 为了  让我院的  工作人员 忍辱密切的了解我
 * @author lwp940118
 *
 */
public class AdministratorJuYuanJianJie extends JTabbedPane{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<String> imagePaths;
	
	public AdministratorJuYuanJianJie(){
		/**
		 * 剧院简介
		 */
		ImageIcon imageIcon_jianjie = new ImageIcon(
				Login.class.getResource("/com/today/images/jianjie.png"));
		imageIcon_jianjie.setImage(imageIcon_jianjie.getImage()
				.getScaledInstance(120, 40, Image.SCALE_DEFAULT));
		JPanel jPanel = jianJie();
		JScrollPane scrollPane = new JScrollPane(
                ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
		jPanel.setPreferredSize(new Dimension(jPanel.getWidth(), 2150));
		jPanel.revalidate();
        scrollPane.setViewportView(jPanel);
		addTab("", imageIcon_jianjie,scrollPane);
		
		/**
		 * 历史精髓
		 */
		ImageIcon imageIcon_lishijingsui = new ImageIcon(
				Login.class.getResource("/com/today/images/lishijingsui.png"));
		imageIcon_lishijingsui.setImage(imageIcon_lishijingsui.getImage()
				.getScaledInstance(120, 40, Image.SCALE_DEFAULT));
		addTab("", imageIcon_lishijingsui,jingDianDianYing());
		setTabPlacement(JTabbedPane.TOP);
		
	}
	
	private JPanel jianJie(){
		JPanel jPanel = new JPanel();
		jPanel.setOpaque(false);
		
		ImageIcon imageIcon_jianjie0 = new ImageIcon(
				Login.class.getResource("/com/today/images/jianjie0.png"));
		imageIcon_jianjie0.setImage(imageIcon_jianjie0.getImage()
				.getScaledInstance(700, 90, Image.SCALE_DEFAULT));
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
		JLabel jLabel0 = new JLabel(imageIcon_jianjie0);
		jPanel_wei.add(jLabel0);
		jPanel.add(jPanel_wei, gridBagConstraints);

		JPanel jPanel_nei = juyuanjianjie();
		jPanel_nei.setOpaque(false);
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.weightx = 200;
		gridBagConstraints.weighty = 800;
		jPanel.add(jPanel_nei, gridBagConstraints);
		
		/*JPanel jPanel1 = new JPanel();
		jPanel1.setOpaque(false);
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.weightx = 200;
		gridBagConstraints.weighty = 10;
		jPanel.add(jPanel1, gridBagConstraints);*/
		
		return jPanel;
	}
	
	/**
	 * 剧院简介
	 * @return
	 */
	private JPanel juyuanjianjie(){
		

		ImageIcon imageIcon_jianjie1 = new ImageIcon(
				Login.class.getResource("/com/today/images/jianjie1.png"));
		imageIcon_jianjie1.setImage(imageIcon_jianjie1.getImage()
				.getScaledInstance(900, 2000, Image.SCALE_DEFAULT));
		JLabel jLabel_jianjie1 = new JLabel(imageIcon_jianjie1);
		JPanel jPanel = new JPanel();
		jPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		jPanel.add(jLabel_jianjie1);
		
		return jPanel;
	}
	
	/**
	 * 历史电影简介
	 * @return
	 */
	private JPanel jingDianDianYing(){
		
		imagePaths = new ArrayList<String>();
		
		/**
		 *
		 */
		imagePaths.add("com/today/movie1/dianying1.jpg");
		imagePaths.add("com/today/movie1/dianying2.jpg");
		imagePaths.add("com/today/movie1/dianying3.jpg");
		imagePaths.add("com/today/movie1/dianying4.jpg");
		imagePaths.add("com/today/movie1/dianying5.jpg");
		imagePaths.add("com/today/movie1/dianying6.jpg");
		imagePaths.add("com/today/movie1/dianying7.jpg");
		imagePaths.add("com/today/movie1/dianying8.jpg");
		imagePaths.add("com/today/movie1/dianying9.jpg");
		imagePaths.add("com/today/movie1/dianying10.jpg");
		imagePaths.add("com/today/movie1/dianying11.jpg");
		imagePaths.add("com/today/movie1/dianying12.jpg");
		imagePaths.add("com/today/movie1/dianying13.jpg");
		imagePaths.add("com/today/movie1/dianying14.jpg");
		imagePaths.add("com/today/movie1/dianying15.jpg");
		imagePaths.add("com/today/movie1/dianying16.jpg");
		imagePaths.add("com/today/movie1/dianying17.jpg");
		imagePaths.add("com/today/movie1/dianying18.jpg");
		imagePaths.add("com/today/movie1/dianying19.jpg");
		imagePaths.add("com/today/movie1/dianying20.jpg");
		imagePaths.add("com/today/movie1/dianying21.jpg");
		imagePaths.add("com/today/movie1/dianying22.jpg");
		imagePaths.add("com/today/movie1/dianying23.jpg");
		imagePaths.add("com/today/movie1/dianying24.jpg");
		imagePaths.add("com/today/movie1/dianying25.jpg");
		imagePaths.add("com/today/movie1/dianying26.jpg");
		imagePaths.add("com/today/movie1/dianying27.jpg");
		imagePaths.add("com/today/movie1/dianying28.jpg");
		imagePaths.add("com/today/movie1/dianying29.jpg");
		imagePaths.add("com/today/movie1/dianying30.jpg");
		imagePaths.add("com/today/movie1/dianying31.jpg");
		imagePaths.add("com/today/movie1/dianying32.jpg");
		imagePaths.add("com/today/movie1/dianying33.jpg");
		imagePaths.add("com/today/movie1/dianying34.jpg");
		imagePaths.add("com/today/movie1/dianying35.jpg");
		imagePaths.add("com/today/movie1/dianying36.jpg");
		imagePaths.add("com/today/movie1/dianying37.jpg");
		imagePaths.add("com/today/movie1/dianying38.jpg");
		imagePaths.add("com/today/movie1/dianying39.jpg");
		imagePaths.add("com/today/movie1/dianying40.jpg");
		imagePaths.add("com/today/movie1/dianying41.jpg");
		imagePaths.add("com/today/movie1/dianying42.jpg");
		imagePaths.add("com/today/movie1/dianying43.jpg");
		imagePaths.add("com/today/movie1/dianying44.jpg");
		imagePaths.add("com/today/movie1/dianying45.jpg");
		imagePaths.add("com/today/movie1/dianying46.jpg");
		imagePaths.add("com/today/movie1/dianying47.jpg");
		imagePaths.add("com/today/movie1/dianying48.jpg");
		imagePaths.add("com/today/movie1/dianying49.jpg");
		imagePaths.add("com/today/movie1/dianying50.jpg");
		imagePaths.add("com/today/movie1/dianying51.jpg");
		imagePaths.add("com/today/movie1/dianying52.jpg");
		
		
		JPanel jPanel = new AnimationImagePanel(imagePaths);
		jPanel.setOpaque(false);
		jPanel.setBorder(new EmptyBorder(0, 80, 0, 120));
		//jPanel.setBackground(Color.black);
		return jPanel;
	}
	
}
