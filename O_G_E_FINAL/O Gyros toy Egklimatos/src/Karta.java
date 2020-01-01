import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Karta extends Koutaki {
private ArrayList <String> kartes_klefti;
private ArrayList <String> kartes_astunomou;

	
	public Karta(String onoma,ArrayList <String> kartesKlefti,ArrayList <String> kartesAstunomou) {
		super(onoma);
		this.kartes_klefti=kartesKlefti;
		this.kartes_astunomou=kartesAstunomou;
	}


	public ArrayList<String> getKartes_klefti() {
		return kartes_klefti;
	}


	public ArrayList<String> getKartes_astunomou() {
		return kartes_astunomou;
	}
	public int Epilogi_Kartas( Paiktis p)
	{
		int apotelesma=0;
		String epilegmeni_karta=null;
		if(p instanceof Kleftis)
		{
			int arithmosKartwn= kartes_klefti.size();
			
			Random rand = new Random();
			apotelesma = rand.nextInt(arithmosKartwn);              //1?
			
			epilegmeni_karta=kartes_klefti.get(apotelesma);
			
		}
	
		
		if(p instanceof Astinomikos)
		{
			int arithmosKartwn= kartes_astunomou.size();
			
			Random rand = new Random();
			apotelesma = rand.nextInt(arithmosKartwn);
			
			epilegmeni_karta= kartes_astunomou.get(apotelesma);
			
		}
	
		int r=EktelesiKartas( apotelesma, p,epilegmeni_karta);
		return r;
		
	}
	
	
	public int EktelesiKartas (int arithmos_kartas,Paiktis paiktis,String karta)
	{	
		JFrame pan=new JFrame();
	    pan.setUndecorated(true);
	    pan.setResizable(false);
	    pan.setBounds(475,230, 400, 320);
	    pan.setVisible(true); 
	    pan.setLocationRelativeTo(null);
	    
	    
	    
		
		if(paiktis instanceof Kleftis){
			 Font font=new Font("Tahoma",Font.PLAIN,20);
			 getContentPane().setLayout(null);
				
				JLabel lblNewLabel = new JLabel("New label");
				lblNewLabel.setIcon(new ImageIcon(Karta.class.getResource("/images/\u03BA\u03AC\u03C1\u03C4\u03B1 \u03BA\u03BB\u03AD\u03C6\u03C4\u03B7.png")));
				lblNewLabel.setBounds(0, 0, 400, 320);
				pan.getContentPane().add(lblNewLabel);
				 JPanel panel;
				switch(arithmos_kartas){
				case 0: case 3:
					  panel= new JPanel();
						 JOptionPane.showMessageDialog(panel,karta);
						 pan.setVisible(false);
					     pan.dispose();
					return 3;
				case 1: case 4:
					  panel= new JPanel();
						 JOptionPane.showMessageDialog(panel,karta);
						 pan.setVisible(false);
					     pan.dispose();
					return 2;
				case 2: case 5:
					  panel= new JPanel();
						 JOptionPane.showMessageDialog(panel,karta);
						 pan.setVisible(false);
					     pan.dispose();
					return 1;
				case 6: case 9:
					  panel= new JPanel();
						 JOptionPane.showMessageDialog(panel,karta);
						 pan.setVisible(false);
					     pan.dispose();
					return -3;
				case 7: case 10:
					  panel= new JPanel();
						 JOptionPane.showMessageDialog(panel,karta);
						 pan.setVisible(false);
					     pan.dispose();
					return -2;
				case 8: case 11:
					  panel= new JPanel();
						 JOptionPane.showMessageDialog(panel,karta);
						 pan.setVisible(false);
					     pan.dispose();
					return -1;
				case 12:
					  panel= new JPanel();
						 JOptionPane.showMessageDialog(panel,karta);
						 pan.setVisible(false);
					     pan.dispose();
					return 4;   //paei stin favela
				case 13:
					  panel= new JPanel();
						 JOptionPane.showMessageDialog(panel,karta);
						 pan.setVisible(false);
					     pan.dispose();
					return 5;  //xanei gyro
				case 14:
					  panel= new JPanel();
						 JOptionPane.showMessageDialog(panel,karta);
						 pan.setVisible(false);
					     pan.dispose();
					return 6;  //-25%
				case 15:
					  panel= new JPanel();
						 JOptionPane.showMessageDialog(panel,karta);
						 pan.setVisible(false);
					     pan.dispose();
					return 7; //+20%
				case 16:
					  panel= new JPanel();
						 JOptionPane.showMessageDialog(panel,karta);
						 pan.setVisible(false);
					     pan.dispose();
					return 8; //paei dimarxeio 
				}
				 
			
		}
		else{
			getContentPane().setLayout(null);
			 Font font=new Font("Tahoma",Font.PLAIN,20);
			JLabel lblNewLabel = new JLabel("New label");
			lblNewLabel.setIcon(new ImageIcon(Karta.class.getResource("/images/\u03BA\u03AC\u03C1\u03C4\u03B1 \u03B1\u03C3\u03C4\u03C5\u03BD\u03BF\u03BC\u03B9\u03BA\u03BF\u03CD.png")));
			lblNewLabel.setBounds(0, 0, 401, 261);
			pan.getContentPane().add(lblNewLabel);
			 JPanel panel;	   
				switch(arithmos_kartas){
				case 0:
				case 3:
					  panel= new JPanel();
					 JOptionPane.showMessageDialog(panel,karta);
					 pan.setVisible(false);
					 this.add(panel);
				     pan.dispose();
					return 3;
				case 1:
				case 4:
					  panel= new JPanel();
					 JOptionPane.showMessageDialog(panel,karta);
					 pan.setVisible(false);
				     pan.dispose();
					return 2;
				case 2:
				case 5:
					  panel= new JPanel();
					  
					 JOptionPane.showMessageDialog(panel,karta);
					 panel.setBounds(200, 300, 100, 50);
					 pan.setVisible(false);
				     pan.dispose();
					return 1;
				case 6:
				case 9:
					panel= new JPanel();
					 JOptionPane.showMessageDialog(panel,karta);
					 pan.setVisible(false);
				     pan.dispose();
					return -3;
				case 7:
				case 10:
					panel= new JPanel();
					 JOptionPane.showMessageDialog(panel,karta);
					 pan.setVisible(false);
				     pan.dispose();
					return -2;
				case 8:
				case 11:
					panel= new JPanel();
					 JOptionPane.showMessageDialog(panel,karta);
					 pan.setVisible(false);
				     pan.dispose();
					return -1;
				case 12:
					panel= new JPanel();
					 JOptionPane.showMessageDialog(panel,karta);
					 pan.setVisible(false);
				     pan.dispose();
					return 4;   //paei stratopedo
				case 13 :case 14:
					panel= new JPanel();
					 JOptionPane.showMessageDialog(panel,karta);
					 pan.setVisible(false);
				     pan.dispose();
					return 5;
				case 15:case 16:
					 String[] options = new String[] {"1", "2",};									//epilogi eleytheris stathmeysis
					    int response = JOptionPane.showOptionDialog(null, karta, "",
					        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
					        null, options, options[0]);
					    if(response==1 || response==0){
					    	pan.setVisible(false);
					    	pan.dispose();
					    }
					return 6+response;  
				}
		}
		return 0;
	}
	
	
	public int getPoso() {
		return 0;
	}

	public int getXronos_anamonis() {
		return 0;
	}

	public int getZoes_ktiriou() {
		return 0;
	}
	
	public boolean diarkia_anamonis_ktiriou()
	{
		return false;
	}


	@Override
	public void epilogi_1or2or3(Paiktis p) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void DecZoes() {
		// TODO Auto-generated method stub
		
	}
}
