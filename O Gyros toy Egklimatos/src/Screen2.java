import javax.swing.JFrame;

import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;



import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Screen2 extends JFrame{
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JButton btnEnarksi;
	private JButton btnPiso;
	private tablo tablPaix;
	private Music music;
	
	public Screen2(tablo t) {
		tablPaix=t;
		setSize(new Dimension(875, 730));
		music=new Music("start.wav");
		
		getContentPane().setLayout(null);
		
		JButton btnPiso = new JButton("\u03A0\u0399\u03A3\u03A9");
		btnPiso.setForeground(Color.WHITE);
		btnPiso.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnPiso.setBackground(Color.RED);
		btnPiso.setBounds(55, 571, 106, 59);
		getContentPane().add(btnPiso);
		btnPiso.setActionCommand("PISO");
		
		
		JButton btnEnarksi = new JButton("\u0395\u039D\u0391\u03A1\u039E\u0397");
		btnEnarksi.setForeground(Color.WHITE);
		btnEnarksi.setBackground(Color.RED);
		btnEnarksi.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnEnarksi.setBounds(708, 571, 106, 59);
		getContentPane().add(btnEnarksi);
		btnEnarksi.setActionCommand("ENARXI");
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textField.setBackground(SystemColor.activeCaption);
		textField.setBounds(316, 250, 396, 40);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textField_1.setBackground(SystemColor.activeCaption);
		textField_1.setBounds(316, 301, 396, 40);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textField_2.setColumns(10);
		textField_2.setBackground(SystemColor.activeCaption);
		textField_2.setBounds(316, 352, 396, 43);
		getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textField_3.setColumns(10);
		textField_3.setBackground(SystemColor.activeCaption);
		textField_3.setBounds(316, 406, 396, 40);
		getContentPane().add(textField_3);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Screen2.class.getResource("/images/\u039F\u03B8\u03CC\u03BD\u03B7\u039F\u03BD\u03BF\u03BC\u03AC\u03C4\u03C9\u03BD.png")));
		lblNewLabel.setBounds(0, 0, 859, 691);
		getContentPane().add(lblNewLabel);
		
		ButtonListener listener = new ButtonListener();
		btnEnarksi.addActionListener(listener);
		btnPiso.addActionListener(listener);
		
		this.setResizable(false);
		this.setVisible(true);   //����� �� �������� ����� ���� �����
		this.setSize(865,720);  //����������
		
		this.setTitle("� ����� ��� ����������"); //��������
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);

	}
	

	class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
		
			
			ArrayList<String> names = new ArrayList<String>();
			ArrayList<Paiktis> paiktes = new ArrayList<Paiktis>();
			
			String name1 = textField.getText();            
			String name2 = textField_1.getText();
			String name3 = textField_2.getText();
			String name4 = textField_3.getText();
			
			names.add(name1);
			names.add(name2);
			names.add(name3);
			names.add(name4);
			
			//��������� ������� ��� �� ��� �� ������� ����� ����� �������
			boolean isThenamestrue = true;
			
			if(name1.length()<=1 || name1.length()>=9)
			{
				textField.setText(null);
				isThenamestrue=false;
			}
			
			if(name2.length()<=1 || name2.length()>=9)
			{
				textField_1.setText(null);
				isThenamestrue=false;
			}
			
			if(name3.length()<=1 || name3.length()>=9)
			{
				textField_2.setText(null);
				isThenamestrue=false;
			}

			if(name4.length()<=1 || name4.length()>=9)
			{
				textField_3.setText(null);
				isThenamestrue=false;
			}
			
			
			
       
       	
			if(e.getActionCommand().equals("ENARXI")) {
				if(isThenamestrue == false)
				 {
				    JOptionPane.showMessageDialog(null, "�� ����� ������ �� ���� ��� 2 ��� 8 ����������! ", "Error", JOptionPane.ERROR_MESSAGE);
					//JOptionPane.showMessageDialog(null, "������ �����.");
				 }
				if(isThenamestrue){
				Astinomikos astinomikos1 = new Astinomikos (name1,16,0,4,0,0); //�������� ��������
				Astinomikos astinomikos2 = new Astinomikos (name2,16,0,4,0,0); 

				Kleftis kleftis1 = new Kleftis(name3,0,0,4,0,0,0,0);
				Kleftis kleftis2 = new Kleftis(name4,0,0,4,0,0,0,0);
				
				tablPaix.addPlayer(kleftis1);
				tablPaix.addPlayer(astinomikos1);
				tablPaix.addPlayer(kleftis2);
				tablPaix.addPlayer(astinomikos2);
				tablPaix.getPaiktes().get(0).EnimerosiXY(113, 549);          //������� ������������� �������
				tablPaix.getPaiktes().get(1).EnimerosiXY(700, 130);
				tablPaix.getPaiktes().get(2).EnimerosiXY(115, 551);
				tablPaix.getPaiktes().get(3).EnimerosiXY(702, 132);
				
				

					
				new Table(tablPaix);
				music.stop();
				setVisible(false);
				dispose();
	
				}
			}
			if(e.getActionCommand().equals("PISO")){
			    new Screen1(tablPaix);
			    music.stop();
			    setVisible(false);
			    dispose();
			    }
	
            //  for(int i=0; i<paiktes.size(); i++) {
            	//  paiktes.get(i).printInfo();}
            
			
			
		}
	}
	
	
	
	
	
}