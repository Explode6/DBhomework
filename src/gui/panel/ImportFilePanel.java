package gui.panel;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import gui.listener.ImportListener;
import util.GUIUtil;
import util.ParseUtil;

public class ImportFilePanel extends JPanel {
	public static ImportFilePanel instance = new ImportFilePanel();
	
	public JTextField filePath = new JTextField();
	
	public JButton imp = new JButton("�����ļ�");
	public JButton determine = new JButton("ȷ��");
	
	public String pathName;
	public ImportFilePanel() {
		JPanel p1 = new JPanel();
		p1.setBounds(50, 50, 300, 60);
		filePath.setPreferredSize(new Dimension(350,20));
		determine.setPreferredSize(new Dimension(60,30));
		p1.add(filePath);
		p1.add(imp);
		p1.add(determine);
		
		
		this.add(p1);
		
//		Ϊ��ť��Ӽ�����
		imp.addActionListener(new ImportListener());
		determine.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				pathName = filePath.getText().toString();
				if(pathName.equals(""))
					JOptionPane.showMessageDialog(ImportFilePanel.instance, "��ѡ���ļ�");
				else if(!pathName.endsWith(".xml")) {
					JOptionPane.showMessageDialog(ImportFilePanel.instance, "ֻ����xml�ļ�");
				}
				else {
					try {
						ParseUtil.myParse(pathName);
					} catch (ParserConfigurationException | SAXException | IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
	}
	
	public static void main(String[] args) {
		GUIUtil.showPanel(ImportFilePanel.instance,1);
	}
}
