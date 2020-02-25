package com.xy.today.mycontrols;

import java.awt.Color;
import java.awt.Component;

import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class JComboBox_Item extends JLabel implements ListCellRenderer {
	public Component getListCellRendererComponent(JList list, Object obj,
			int row, boolean sel, boolean hasFocus) {
		Object[] cell = (Object[]) obj;
		setIcon((Icon) cell[0]);// 设置图片
		setText((cell[1].toString()));// 设置文本
		setToolTipText(cell[2].toString());// 设置提示文本
		setBorder(new LineBorder(Color.gray));// 绘制边框
		if (sel){
			setForeground(Color.blue);// 设前景色为蓝色
		} else{
			setForeground(list.getForeground());// 设前景色为默认
		}
		return this;
	}
}