package gui.panel;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import gui.model.AnalyTableModel;
import util.GUIUtil;
import util.TableViewRenderer;

public class AnalysisPanel extends JPanel {
public static AnalysisPanel instance = new AnalysisPanel();
	
//	���ñ����ʾͳ����Ϣ
	String columnNames[] = new String[] {"�ؼ���","���ִ���"};
	public AnalyTableModel atm = new AnalyTableModel();
	public JTable t = new JTable(atm);
	
	public AnalysisPanel() {
		// TODO Auto-generated constructor stub
		t.setRowHeight(40);
		t.setDefaultRenderer(Object.class,new TableViewRenderer());
		JScrollPane p = new JScrollPane(t);
		this.setLayout(new BorderLayout());
		this.add(p,BorderLayout.CENTER);
	}
	
	public static void main(String[] args) {
		GUIUtil.showPanel(AnalysisPanel.instance,1);
	}
}
