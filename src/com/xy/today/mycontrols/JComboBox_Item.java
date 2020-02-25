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
		setIcon((Icon) cell[0]);// ����ͼƬ
		setText((cell[1].toString()));// �����ı�
		setToolTipText(cell[2].toString());// ������ʾ�ı�
		setBorder(new LineBorder(Color.gray));// ���Ʊ߿�
		if (sel){
			setForeground(Color.blue);// ��ǰ��ɫΪ��ɫ
		} else{
			setForeground(list.getForeground());// ��ǰ��ɫΪĬ��
		}
		return this;
	}
}