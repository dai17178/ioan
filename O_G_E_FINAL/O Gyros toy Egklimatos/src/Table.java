import javax.swing.JFrame;
import  sun.audio.*;    //import the sun.audio package
import  java.io.*;
import javax.swing.JButton;

import java.awt.BasicStroke;
import java.awt.BorderLayout;

import javax.jws.soap.SOAPBinding.Style;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

public class Table extends JFrame{
	private Pawn pawn;             // Περιέχει την εικόνα του ταμπλό και το πιόνι
	private tablo t;
	private int num_svisimo=0;
	private int last_player=5;
	ArrayList<Integer> pointx=new ArrayList<Integer>();                  //Oi listes xrisimopoiounte gia ta svismena ktiria
	ArrayList<Integer> pointy=new ArrayList<Integer>();
	ArrayList<Integer> pleura=new ArrayList<Integer>();
	private Music music;
	private JTextField textField;
	private JButton buttonzari;
	private JButton buttonmenu;
	private JButton buttonbathm;
	private int number=0;        //Δείχνει τον παίκτη που έχει σειρά

	
	public Table(tablo tablPaix) {
		t=tablPaix;
		
		 music=new Music("1.wav");      //backround music
	
		pawn=new Pawn();
		this.setContentPane(pawn);
		
		
		JButton buttonmenu = new JButton("\u039C\u0395\u039D\u039F\u03A5");
		buttonmenu.setForeground(Color.WHITE);
		buttonmenu.setFont(new Font("Tahoma", Font.BOLD, 17));
		buttonmenu.setBackground(Color.RED);
		buttonmenu.setBounds(10, 11, 98, 43);
		getContentPane().add(buttonmenu);
		buttonmenu.setActionCommand("MENU");
		
		JButton buttonzari = new JButton("\u03A1\u0399\u039E\u0395");
		buttonzari.setFont(new Font("Tahoma", Font.BOLD, 15));
		buttonzari.setBackground(Color.GREEN);
		buttonzari.setBounds(226, 280, 89, 23);
		getContentPane().add(buttonzari);
		buttonzari.setActionCommand("ZARI");
		
		JButton buttonbathm = new JButton("\u0392\u0391\u0398\u039C\u039F\u039B\u039F\u0393\u0399\u0391");
		buttonbathm.setForeground(Color.WHITE);
		buttonbathm.setFont(new Font("Tahoma", Font.BOLD, 15));
		buttonbathm.setBackground(Color.RED);
		buttonbathm.setBounds(711, 637, 138, 43);
		getContentPane().add(buttonbathm);
		buttonbathm.setActionCommand("BATHMOLOGIA");
		
		
		textField = new JTextField();
		textField.setForeground(Color.WHITE);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField.setBackground(new Color(128, 0, 0));
		textField.setBounds(305, 320, 42, 32);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		
		
		ButtonListener listener = new ButtonListener();
		buttonmenu.addActionListener(listener);
		buttonzari.addActionListener(listener);
		buttonbathm.addActionListener(listener);
		
		this.setResizable(false);
		this.setVisible(true);   //κάνει το παράθυρο ορατό στην οθόνη
		this.setSize(865,720);  //διαστάσεις
		this.setTitle("Ο γύρος του εγκλήματος"); //ονομασία
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);

		
	}
	
	public void Listia(int trexonKtirio){
		if(t.getTabloPaixnidiou().get(trexonKtirio) instanceof Stratopedo){
			 int f = JOptionPane.showConfirmDialog(
	                 null,
	                 "Ληστεύεις?",
	                 "Ερώτηση",
	                 JOptionPane.YES_NO_OPTION);// το yes αντιστοιχει στο 0,το no στπο 1
             if(f==0){
            	 t.getTabloPaixnidiou().get(trexonKtirio).epilogi_1or2or3(t.getPaiktes().get(number));
            	 if(t.getPaiktes().get(number).PaiktisIsDead()){                                         //h periptosi poy o kleftis pethenei sto stratopedo
            		 JFrame pan4=new JFrame();
            		 pan4.setUndecorated(true);
            		 pan4.setResizable(false);
            		 pan4.setBounds(475,230, 400, 320);
            		 pan4.setVisible(true);
            		 pan4.setLocationRelativeTo(null);
            		 JLabel lblNewLabel4 = new JLabel("New label");
            			lblNewLabel4.setIcon(new ImageIcon(tablo.class.getResource("/images/dead.png")));
            			lblNewLabel4.setBounds(0, 0, 401, 309);
            			pan4.getContentPane().add(lblNewLabel4);
            			music.IxitikoEffe("dead.wav");
            			if(t.TelosPaixnidiou(number)){
            				pan4.setVisible(false);
            				pan4.dispose();
            			}
            			 pan4.addMouseListener(new MouseAdapter() {
            			     @Override
            			     public void mousePressed(MouseEvent e) {
            			        pan4.setVisible(false);
            			        pan4.dispose();
            			     }
            			  });
             }
             }
		}
		if(t.getTabloPaixnidiou().get(trexonKtirio) instanceof Ktirio)
	      {
		     if(t.getTabloPaixnidiou().get(trexonKtirio).getZoes_ktiriou() != 0 && t.getPaiktes().get(number).getArithmos_listiwn()<3 )
	          {
		 
		 		 
		         int n = JOptionPane.showConfirmDialog(
		                 null,
		                 "Ληστεύεις?",
		                 "Ερώτηση",
		                 JOptionPane.YES_NO_OPTION);// το yes αντιστοιχει στο 0,το no στπο 1
                 if(n==0)
                  {
          	       t.getTabloPaixnidiou().get(trexonKtirio).DecZoes();
          	       int posoListias =  t.getTabloPaixnidiou().get(trexonKtirio).getPoso();
          	       t.getPaiktes().get(number).IncTrexonPoso(t.getTabloPaixnidiou().get(trexonKtirio).getPoso());
          	       t.getPaiktes().get(number).IncArithmosListeiwn();
          	       t.getPaiktes().get(number).setAnamoni(t.getTabloPaixnidiou().get(trexonKtirio).getXronos_anamonis());
          	       if(t.getTabloPaixnidiou().get(trexonKtirio).getZoes_ktiriou()==0){
          	    	 num_svisimo++;
          	    	 if(num_svisimo==24)
          	    		 last_player=number;
      				if(t.getPaiktes().get(number).getThesi()<7){
      					pleura.add(1);
      					pointx.add(t.getPaiktes().get(number).getX()-number);
          				pointy.add(t.getPaiktes().get(number).getY()-number);
      				}
      				else if(t.getPaiktes().get(number).getThesi()<16){
      					pleura.add(2);
      					pointx.add(t.getPaiktes().get(number).getX()-number);
          				pointy.add(t.getPaiktes().get(number).getY()-number);
      				}
      				else if(t.getPaiktes().get(number).getThesi()<23){
      					pleura.add(3);
      					pointx.add(t.getPaiktes().get(number).getX()-number);
          				pointy.add(t.getPaiktes().get(number).getY()-number);
      				}
      				else
      				{	
      					pleura.add(4);
      					pointx.add(t.getPaiktes().get(number).getX()-number);
          				pointy.add(t.getPaiktes().get(number).getY()-number);
      				}
      					
          	       }
     				
                  }  
	       }
		     

	   }
	}
	
	

	
	
	
	class Pawn extends JLabel{
		
		public void paint(Graphics g){
			JLabel lblNewLabel = new JLabel("New label"); 																//eikona tou tablo
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setIcon(new ImageIcon(Table.class.getResource("/images/\u03A4\u03B1\u03BC\u03C0\u03BB\u03CC.jpg")));
			lblNewLabel.setBounds(0, 0, 867, 694);
			getContentPane().add(lblNewLabel);
			
			Graphics2D g2=(Graphics2D) g;
		
			super.paint(g);
			Font myFont = new Font("Serif", Font.BOLD, 17);                                                 //Ta pionia twn paiktwn
			g.setFont(myFont);
			if(number==0||number==2)
				g2.setColor(Color.RED);
			else 
				g2.setColor(Color.BLUE);
			g2.drawString("Σειρά του παίκτη: "+t.getPaiktes().get(number).getName(), 350, 20);
			if (!t.getPaiktes().get(0).PaiktisIsDead()){
				g.setColor(Color.RED);
				g.fillOval(t.getPaiktes().get(0).getX(),t.getPaiktes().get(0).getY(), 30, 30);
				g.setColor(Color.BLACK);
				if(t.getPaiktes().get(0).getTrexon_poso()>0)
					g.setColor(Color.YELLOW);
				g.drawOval(t.getPaiktes().get(0).getX(),t.getPaiktes().get(0).getY(), 30, 30);
				g.drawString("1",t.getPaiktes().get(0).getX()+12, t.getPaiktes().get(0).getY()+20);
			}
			if(!t.getPaiktes().get(1).PaiktisIsDead()){
				g.setColor(Color.BLUE);
				g.fillOval(t.getPaiktes().get(1).getX(), t.getPaiktes().get(1).getY(), 30, 30);
				g.setColor(Color.BLACK);
				g.drawOval(t.getPaiktes().get(1).getX(), t.getPaiktes().get(1).getY(), 30, 30);
				g.drawString("1",t.getPaiktes().get(1).getX()+12, t.getPaiktes().get(1).getY()+20);
			}
			if(!t.getPaiktes().get(2).PaiktisIsDead()){
				g.setColor(Color.RED);
				g.fillOval(t.getPaiktes().get(2).getX(), t.getPaiktes().get(2).getY(), 30, 30);
				g.setColor(Color.BLACK);
				if(t.getPaiktes().get(2).getTrexon_poso()>0)
					g.setColor(Color.YELLOW);
				g.drawOval(t.getPaiktes().get(2).getX(), t.getPaiktes().get(2).getY(), 30, 30);
				g.drawString("2",t.getPaiktes().get(2).getX()+12, t.getPaiktes().get(2).getY()+20);
			}
			if(!t.getPaiktes().get(3).PaiktisIsDead()){
				g.setColor(Color.BLUE);
				g.fillOval(t.getPaiktes().get(3).getX(), t.getPaiktes().get(3).getY(), 30, 30);
				g.setColor(Color.BLACK);
				g.drawOval(t.getPaiktes().get(3).getX(), t.getPaiktes().get(3).getY(), 30, 30);
				g.drawString("2",t.getPaiktes().get(3).getX()+12, t.getPaiktes().get(3).getY()+20); 
				
			}
			
			
			
			for (int i=0; i<num_svisimo; i++){
				g2.setStroke(new BasicStroke(2));                                                           //Ta svismena Ktiria
				Color color=new Color(1,0,0,0.50f);
				g2.setColor(color);
				if(pleura.get(i)==1)
					g2.drawLine(pointx.get(i)+41,pointy.get(i),pointx.get(i)+41,pointy.get(i)+40);
				else if(pleura.get(i)==2)
					g2.drawLine(pointx.get(i),pointy.get(i)+42,pointx.get(i)+40,pointy.get(i)+42);
				else if(pleura.get(i)==3)
					g2.drawLine(pointx.get(i)-2,pointy.get(i),pointx.get(i)-2,pointy.get(i)+40);
				else
					g2.drawLine(pointx.get(i),pointy.get(i)-5,pointx.get(i)+40,pointy.get(i)-5);
				
			}
		}
	
		
		
		public void setXYCoordinates(int dice,int number) {		//Ενημερώνει τις συντεταγμένες x και y
			int Corner1=7;        //  ΟΙ ΓΩΝΙΕΣ ΤΟΥ ΠΑΙΧΝΙΔΙΟΥ
			int Corner2=16;
			int Corner3=23;
			int Corner4=32;
			int newx=0,newy=0;
			
			newx=t.getPaiktes().get(number).getX();       //posa koutakia proxwran se kathe aksona
			newy=t.getPaiktes().get(number).getY();
																										//oi paiktes exoun diaforetikes sintetagmenes
			if(t.getPaiktes().get(number).getThesi()<Corner1) {										    //sta idia koutakia gia na ksexorizoun an pesoun mazi
				if(dice<=Corner1-t.getPaiktes().get(number).getThesi()) {
					newx=newx;
					newy=newy-(dice*60);
				}
				else {
					int moveY=Corner1-t.getPaiktes().get(number).getThesi();
					int moveX=dice-moveY;
					newy=newy-(moveY*60);
					newx=newx+(moveX*65);
				}
			}
			else if(t.getPaiktes().get(number).getThesi()<Corner2)
			{
				if (dice<=Corner2-t.getPaiktes().get(number).getThesi()) {
					newy=newy;
					newx=newx+(dice*65);
				}
				else {
					int moveX=Corner2-t.getPaiktes().get(number).getThesi();
					int moveY=dice-moveX;
					newy=newy+(moveY*60);
					newx=newx+(moveX*65);
						
				}
			}
			else if(t.getPaiktes().get(number).getThesi()<Corner3) {
					
					if (dice<=Corner3-t.getPaiktes().get(number).getThesi()) {
						newy=newy+(dice*60);
						newx=newx;
					}
					else {
						int moveY=Corner3-t.getPaiktes().get(number).getThesi();
						int moveX=dice-moveY;
						newy=newy+(moveY*60);
						newx=newx-(moveX*65);
							
					}
					
			}
			else {
				if (dice<=Corner4-t.getPaiktes().get(number).getThesi()){
					newy=newy;
					newx=newx-(dice*65);
				}
				else {
					int moveX=Corner4-t.getPaiktes().get(number).getThesi();
					int moveY=dice-moveX;
					newy=newy-(moveY*60);
					newx=newx-(moveX*65);
				}
			}
				
			t.getPaiktes().get(number).EnimerosiXY(newx ,newy);
				
				
			
		
		}
		
		public void setXY_dromaki(int dice,int number)                         //O paiktis proxwraei mesa sto dromaki
		{
			if(t.getPaiktes().get(number).getThesi()==33)
				t.getPaiktes().get(number).EnimerosiXY(526,216);
			else if (t.getPaiktes().get(number).getThesi()==34)
				t.getPaiktes().get(number).EnimerosiXY(586,308);
			else if(t.getPaiktes().get(number).getThesi()==35)
				t.getPaiktes().get(number).EnimerosiXY(619,395);
			else if (t.getPaiktes().get(number).getThesi()==36)
				t.getPaiktes().get(number).EnimerosiXY(583,475);
			else if (t.getPaiktes().get(number).getThesi()==37)
			{
				t.getPaiktes().get(number).EnimerosiThesis(20);             //phgainei ton paikti stin thesi 25 
				if (number==1)
					t.getPaiktes().get(number).EnimerosiXY(570,545);
				else
					t.getPaiktes().get(number).EnimerosiXY(572,547);
				
			}
			else if(t.getPaiktes().get(number).getThesi()==39)
			{
				t.getPaiktes().get(number).EnimerosiXY(614,234);
			}
			else if(t.getPaiktes().get(number).getThesi()==40)
			{
				t.getPaiktes().get(number).EnimerosiXY(484,323);
			}
			else if(t.getPaiktes().get(number).getThesi()==41)
			{
				t.getPaiktes().get(number).EnimerosiXY(487,447);
			}
			else if(t.getPaiktes().get(number).getThesi()==42)
			{
				t.getPaiktes().get(number).EnimerosiThesis(16);            //phgainei ton paikti stin thesi 26 
				
				if (number==0)
					t.getPaiktes().get(number).EnimerosiXY(505,548);
				else
					t.getPaiktes().get(number).EnimerosiXY(507,550);
			}
			
			
		}
	}
	
	
	
	class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			ButtonListener so =new ButtonListener();
			
			if(e.getActionCommand().equals("MENU")){
				
				JFrame pan=new JFrame();
				 pan.setResizable(false);
				 pan.setBounds(475,230, 400, 320);
				 pan.setVisible(true);
				 pan.setLocationRelativeTo(null);
				 
				JButton button = new JButton("\u039A\u0391\u039D\u039F\u039D\u0395\u03A3");
				button.setForeground(Color.WHITE);
				button.setBackground(new Color(102, 0, 0));
				button.setFont(new Font("Tahoma", Font.BOLD, 11));
				button.setBounds(127, 106, 147, 33);
				pan.getContentPane().add(button);
				button.setActionCommand("ΚΑΝΟΝΕΣ");
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent ee) {
						if(ee.getActionCommand().equals("ΚΑΝΟΝΕΣ")) {
							
							JFrame pan2=new JFrame();
							 pan2.setResizable(false);
							 pan2.setBounds(475,230, 800, 450);
							 pan2.setVisible(true);
							 pan2.setLocationRelativeTo(null);
							JTextPane textPane = new JTextPane();
							textPane.setBackground(new Color(0, 0, 128));
							textPane.setForeground(new Color(255, 255, 255));
							textPane.setFont(new Font("Tahoma", Font.PLAIN, 12));
							textPane.setText("\u03A4\u03BF \u03C0\u03B1\u03B9\u03C7\u03BD\u03AF\u03B4\u03B9 \u03C0\u03B1\u03AF\u03B6\u03B5\u03C4\u03B1\u03B9 \u03B1\u03BA\u03C1\u03B9\u03B2\u03CE\u03C2 \u03BC\u03B5 \u03C4\u03AD\u03C3\u03C3\u03B5\u03C1\u03B9\u03C2 \u03C0\u03B1\u03AF\u03BA\u03C4\u03B5\u03C2, \u03B4\u03CD\u03BF \u03B1\u03C3\u03C4\u03C5\u03BD\u03BF\u03BC\u03B9\u03BA\u03BF\u03CD\u03C2 \u03BA\u03B1\u03B9 \u03B4\u03CD\u03BF \u03BA\u03BB\u03AD\u03C6\u03C4\u03B5\u03C2. \u038C\u03BB\u03BF\u03B9 \u03BE\u03B5\u03BA\u03B9\u03BD\u03BF\u03CD\u03BD \u03BC\u03B5 \u03C4\u03AD\u03C3\u03C3\u03B5\u03C1\u03B9\u03C2 \u03B6\u03C9\u03AD\u03C2. \u039F\u03B9 \u03C0\u03B1\u03AF\u03BA\u03C4\u03B5\u03C2 \u03BA\u03B9\u03BD\u03BF\u03CD\u03BD\u03C4\u03B1\u03B9 \u03BC\u03AD\u03C3\u03B1 \u03C3\u03C4\u03BF \u03C4\u03B1\u03BC\u03C0\u03BB\u03CC \u03B4\u03B5\u03BE\u03B9\u03CC\u03C3\u03C4\u03C1\u03BF\u03C6\u03B1 \u03C7\u03C1\u03B7\u03C3\u03B9\u03BC\u03BF\u03C0\u03BF\u03B9\u03CE\u03BD\u03C4\u03B1\u03C2 \u03AD\u03BD\u03B1 \u03B6\u03AC\u03C1\u03B9 \u03C4\u03BF \u03BF\u03C0\u03BF\u03AF\u03BF \u03C0\u03B1\u03AF\u03C1\u03BD\u03B5\u03B9 \u03C4\u03B9\u03BC\u03AD\u03C2 \u03B1\u03C0\u03CC \u03C4\u03BF 1 \u03BC\u03AD\u03C7\u03C1\u03B9 \u03C4\u03BF 5.\r\n\r\n\u03A3\u03BA\u03BF\u03C0\u03CC\u03C2 \u03C4\u03C9\u03BD \u03BA\u03BB\u03B5\u03C6\u03C4\u03CE\u03BD \u03B5\u03AF\u03BD\u03B1\u03B9 \u03BD\u03B1 \u03BB\u03B7\u03C3\u03C4\u03AD\u03C8\u03BF\u03C5\u03BD \u03CC\u03BB\u03B1 \u03C4\u03B1 \u03BA\u03C4\u03AE\u03C1\u03B9\u03B1 \u03C4\u03B7\u03C2 \u03C0\u03CC\u03BB\u03B7\u03C2 \u03BA\u03B1\u03B9 \u03BD\u03B1 \u03BC\u03B1\u03B6\u03AD\u03C8\u03BF\u03C5\u03BD \u03C7\u03C1\u03AE\u03BC\u03B1\u03C4\u03B1. \u039E\u03B5\u03BA\u03B9\u03BD\u03CE\u03BD\u03C4\u03B1\u03C2 \u03B1\u03C0\u03CC \u03C4\u03B7\u03BD \u03A6\u03B1\u03B2\u03AD\u03BB\u03B1 , \u03AD\u03C7\u03BF\u03C5\u03BD \u03C4\u03BF \u03B4\u03B9\u03BA\u03B1\u03AF\u03C9\u03BC\u03B1 \u03BD\u03B1 \u03BA\u03BB\u03AD\u03C8\u03BF\u03C5\u03BD \u03C4\u03C1\u03AF\u03B1 \u03BA\u03C4\u03AE\u03C1\u03B9\u03B1 \u03BC\u03AD\u03C7\u03C1\u03B9 \u03BD\u03B1 \u03C6\u03C4\u03AC\u03C3\u03BF\u03C5\u03BD \u03BE\u03B1\u03BD\u03AC \u03C3\u03B5 \u03B1\u03C5\u03C4\u03AE\u03BD. \u039C\u03CC\u03BB\u03B9\u03C2 \u03C0\u03B5\u03C1\u03AC\u03C3\u03BF\u03C5\u03BD \u03B1\u03C0\u03CC \u03C4\u03B7 \u03A6\u03B1\u03B2\u03AD\u03BB\u03B1 \u03C4\u03B1 \u03C7\u03C1\u03AE\u03BC\u03B1\u03C4\u03B1 \u03C0\u03BF\u03C5 \u03AD\u03C7\u03BF\u03C5\u03BD \u03BA\u03BB\u03AD\u03C8\u03B5\u03B9 \u03C3\u03C4\u03BF\u03BD \u03B3\u03CD\u03C1\u03BF \u03C0\u03BF\u03C5 \u03C0\u03C1\u03BF\u03B7\u03B3\u03AE\u03B8\u03B7\u03BA\u03B5 \u03B5\u03AF\u03BD\u03B1\u03B9 \u03C0\u03BB\u03AD\u03BF\u03BD \u03B1\u03C3\u03C6\u03B1\u03BB\u03AE \u03BA\u03B1\u03B9 \u03B4\u03B5 \u03BC\u03C0\u03BF\u03C1\u03B5\u03AF \u03BD\u03B1 \u03C4\u03BF\u03C5\u03C2 \u03C4\u03B1 \u03C0\u03AC\u03C1\u03B5\u03B9 \u03BA\u03AC\u03C0\u03BF\u03B9\u03BF\u03C2 \u03B1\u03C3\u03C4\u03C5\u03BD\u03BF\u03BC\u03B9\u03BA\u03CC\u03C2. \u038C\u03BB\u03B1 \u03C4\u03B1 \u03BA\u03C4\u03AE\u03C1\u03B9\u03B1 \u03BC\u03C0\u03BF\u03C1\u03BF\u03CD\u03BD \u03BD\u03B1 \u03BB\u03B7\u03C3\u03C4\u03B5\u03C5\u03C4\u03BF\u03CD\u03BD \u03BC\u03CC\u03BD\u03BF \u03BC\u03B9\u03B1 \u03C6\u03BF\u03C1\u03AC \u03B5\u03BA\u03C4\u03CC\u03C2 \u03B1\u03C0\u03CC \u03C4\u03B7\u03BD \u03C4\u03C1\u03AC\u03C0\u03B5\u03B6\u03B1 \u03C0\u03BF\u03C5 \u03BC\u03C0\u03BF\u03C1\u03B5\u03AF \u03BD\u03B1 \u03BB\u03B7\u03C3\u03C4\u03B5\u03C5\u03B8\u03B5\u03AF \u03B4\u03CD\u03BF \u03BA\u03B1\u03B9 \u03AD\u03C7\u03B5\u03B9 \u03C7\u03C1\u03CC\u03BD\u03BF \u03B1\u03BD\u03B1\u03BC\u03BF\u03BD\u03AE\u03C2 3 \u03B3\u03CD\u03C1\u03BF\u03C5\u03C2 (\u03B4\u03B7\u03BB\u03B1\u03B4\u03AE \u03BF \u03C0\u03B1\u03AF\u03BA\u03C4\u03B7\u03C2 \u03C7\u03AC\u03BD\u03B5\u03B9 \u03C4\u03B7 \u03C3\u03B5\u03B9\u03C1\u03AC \u03C4\u03BF\u03C5 3 \u03C6\u03BF\u03C1\u03AD\u03C2 \u03B5\u03AC\u03BD \u03B5\u03C0\u03B9\u03BB\u03AD\u03BE\u03B5\u03B9 \u03BD\u03B1 \u03BB\u03B7\u03C3\u03C4\u03AD\u03C8\u03B5\u03B9).\u03A7\u03C1\u03CC\u03BD\u03BF \u03B1\u03BD\u03B1\u03BC\u03BF\u03BD\u03AE\u03C2 \u03AD\u03C7\u03B5\u03B9 \u03BA\u03B1\u03B9 \u03C4\u03BF \u03BA\u03B1\u03B6\u03AF\u03BD\u03BF 2 \u03B3\u03CD\u03C1\u03BF\u03C5\u03C2. \u0393\u03B9\u03B1 \u03BD\u03B1 \u03C6\u03C4\u03AC\u03C3\u03BF\u03C5\u03BD \u03C0\u03B9\u03BF \u03B3\u03C1\u03AE\u03B3\u03BF\u03C1\u03B1 \u03C3\u03C4\u03B7 \u03A6\u03B1\u03B2\u03AD\u03BB\u03B1 \u03BA\u03B1\u03B9 \u03BD\u03B1 \u03BE\u03B5\u03C6\u03CD\u03B3\u03BF\u03C5\u03BD \u03B1\u03C0\u03CC \u03C4\u03BF\u03C5\u03C2 \u03B1\u03C3\u03C4\u03C5\u03BD\u03BF\u03BC\u03B9\u03BA\u03BF\u03CD\u03C2 \u03BC\u03C0\u03BF\u03C1\u03BF\u03CD\u03BD \u03BD\u03B1 \u03B5\u03C0\u03B9\u03BB\u03AD\u03BE\u03BF\u03C5\u03BD \u03BD\u03B1 \u03B1\u03BA\u03BF\u03BB\u03BF\u03C5\u03B8\u03AE\u03C3\u03BF\u03C5\u03BD \u03C4\u03BF \u03BC\u03C5\u03C3\u03C4\u03B9\u03BA\u03CC \u03B4\u03C1\u03BF\u03BC\u03AC\u03BA\u03B9, \u03C0\u03BF\u03C5 \u03C5\u03C0\u03AC\u03C1\u03C7\u03B5\u03B9 \u03B1\u03C0\u03BF\u03BA\u03BB\u03B5\u03B9\u03C3\u03C4\u03B9\u03BA\u03AC \u03BA\u03B1\u03B9 \u03BC\u03CC\u03BD\u03BF \u03B3\u03B9\u03B1 \u03C4\u03BF\u03C5\u03C2 \u03BA\u03BB\u03AD\u03C6\u03C4\u03B5\u03C2 , \u03C7\u03AC\u03BD\u03BF\u03BD\u03C4\u03B1\u03C2 \u03CC\u03BC\u03C9\u03C2 \u03AD\u03C4\u03C3\u03B9 \u03C4\u03BF 40% \u03C4\u03C9\u03BD \u03C7\u03C1\u03B7\u03BC\u03AC\u03C4\u03C9\u03BD \u03C0\u03BF\u03C5 \u03AD\u03C7\u03BF\u03C5\u03BD \u03BC\u03B1\u03B6\u03AF \u03C4\u03BF\u03C5\u03C2 \u03B5\u03BA\u03B5\u03AF\u03BD\u03B7 \u03C4\u03B7 \u03C3\u03C4\u03B9\u03B3\u03BC\u03AE. \u0395\u03C0\u03AF\u03C3\u03B7\u03C2, \u03B5\u03AC\u03BD \u03BF\u03B9 \u03BA\u03BB\u03AD\u03C6\u03C4\u03B5\u03C2 \u03C0\u03AD\u03C3\u03BF\u03C5\u03BD \u03C3\u03C4\u03BF \u03B1\u03C3\u03C4\u03C5\u03BD\u03BF\u03BC\u03B9\u03BA\u03CC \u03C4\u03BC\u03AE\u03BC\u03B1 \u03C4\u03CC\u03C4\u03B5 \u03C7\u03AC\u03BD\u03BF\u03C5\u03BD \u03BC\u03B9\u03B1 \u03B6\u03C9\u03AE \u03BA\u03B1\u03B9 \u03C4\u03B1 \u03C7\u03C1\u03AE\u03BC\u03B1\u03C4\u03B1 \u03C0\u03BF\u03C5 \u03AD\u03C7\u03BF\u03C5\u03BD \u03BC\u03B1\u03B6\u03AD\u03C8\u03B5\u03B9 \u03BA\u03B1\u03B9 \u03B4\u03B5\u03BD \u03AD\u03C7\u03BF\u03C5\u03BD \u03B5\u03BE\u03B1\u03C3\u03C6\u03B1\u03BB\u03B9\u03C3\u03C4\u03B5\u03AF \u03B1\u03C0\u03CC \u03C4\u03B7\u03BD  \u03A6\u03B1\u03B2\u03AD\u03BB\u03B1. \u0395\u03AC\u03BD \u03BF\u03B9 \u03BA\u03BB\u03AD\u03C6\u03C4\u03B5\u03C2 \u03C0\u03AD\u03C3\u03BF\u03C5\u03BD \u03C0\u03AC\u03BD\u03C9 \u03C3\u03B5 \u03B1\u03C3\u03C4\u03C5\u03BD\u03BF\u03BC\u03B9\u03BA\u03CC , \u03C4\u03CC\u03C4\u03B5 \u03C7\u03AC\u03BD\u03BF\u03C5\u03BD \u03BC\u03B9\u03B1 \u03B6\u03C9\u03AE \u03BA\u03B1\u03B9 \u03C4\u03B1 \u03C7\u03C1\u03AE\u03BC\u03B1\u03C4\u03B1 \u03C0\u03BF\u03C5 \u03AD\u03C7\u03BF\u03C5\u03BD \u03BC\u03B1\u03B6\u03AD\u03C8\u03B5\u03B9 \u03BA\u03B1\u03B9 \u03B4\u03B5\u03BD \u03AD\u03C7\u03BF\u03C5\u03BD \u03B5\u03BE\u03B1\u03C3\u03C6\u03B1\u03BB\u03B9\u03C3\u03C4\u03B5\u03AF \u03B1\u03C0\u03CC \u03C4\u03B7\u03BD \u03A6\u03B1\u03B2\u03AD\u03BB\u03B1.\r\n\r\n\u03A3\u03BA\u03BF\u03C0\u03CC\u03C2 \u03C4\u03C9\u03BD \u03B1\u03C3\u03C4\u03C5\u03BD\u03BF\u03BC\u03B9\u03BA\u03CE\u03BD \u03B5\u03AF\u03BD\u03B1\u03B9 \u03BD\u03B1 \u03C0\u03B9\u03AC\u03C3\u03BF\u03C5\u03BD \u03C4\u03BF\u03C5\u03C2 \u03BA\u03BB\u03AD\u03C6\u03C4\u03B5\u03C2 \u03C0\u03C1\u03BF\u03C4\u03BF\u03CD \u03BB\u03B7\u03C3\u03C4\u03AD\u03C8\u03BF\u03C5\u03BD \u03CC\u03BB\u03B7 \u03C4\u03B7\u03BD \u03C0\u03CC\u03BB\u03B7. \u039E\u03B5\u03BA\u03B9\u03BD\u03CE\u03BD\u03C4\u03B1\u03C2 \u03B1\u03C0\u03CC \u03C4\u03BF \u03B1\u03C3\u03C4\u03C5\u03BD\u03BF\u03BC\u03B9\u03BA\u03CC \u03C4\u03BC\u03AE\u03BC\u03B1 \u03C0\u03C1\u03BF\u03C3\u03C0\u03B1\u03B8\u03BF\u03CD\u03BD \u03BD\u03B1 \u03C0\u03AD\u03C3\u03BF\u03C5\u03BD \u03C0\u03AC\u03BD\u03C9 \u03C3\u03C4\u03BF\u03C5\u03C2 \u03BA\u03BB\u03AD\u03C6\u03C4\u03B5\u03C2 \u03AD\u03C4\u03C3\u03B9 \u03CE\u03C3\u03C4\u03B5 \u03BD\u03B1 \u03C0\u03AC\u03C1\u03BF\u03C5\u03BD \u03C4\u03B1 \u03C7\u03C1\u03AE\u03BC\u03B1\u03C4\u03B1 \u03C0\u03BF\u03C5 \u03AD\u03C7\u03BF\u03C5\u03BD \u03BA\u03BB\u03AD\u03C8\u03B5\u03B9 \u03C3\u03C4\u03BF\u03BD \u03C3\u03C5\u03B3\u03BA\u03B5\u03BA\u03C1\u03B9\u03BC\u03AD\u03BD\u03BF \u03B3\u03CD\u03C1\u03BF \u03BA\u03B1\u03B9 \u03BD\u03B1 \u03C4\u03BF\u03C5\u03C2 \u03B1\u03C6\u03B1\u03B9\u03C1\u03AD\u03C3\u03BF\u03C5\u03BD \u03BC\u03B9\u03B1 \u03B6\u03C9\u03AE. \u03A0\u03C1\u03BF\u03C3\u03BF\u03C7\u03AE! \u0391\u03BD \u03C0\u03AD\u03C3\u03BF\u03C5\u03BD \u03C0\u03AC\u03BD\u03C9 \u03C3\u03B5 \u03BA\u03BB\u03AD\u03C6\u03C4\u03B5\u03C2 \u03C0\u03BF\u03C5 \u03B1\u03BA\u03CC\u03BC\u03B1 \u03B4\u03B5\u03BD \u03AD\u03C7\u03BF\u03C5\u03BD \u03BA\u03BB\u03AD\u03C8\u03B5\u03B9 \u03BA\u03AC\u03C0\u03BF\u03B9\u03BF \u03BA\u03C4\u03AE\u03C1\u03B9\u03BF, \u03C4\u03CC\u03C4\u03B5 \u03C7\u03AC\u03BD\u03BF\u03C5\u03BD \u03BF\u03B9 \u03B1\u03C3\u03C4\u03C5\u03BD\u03BF\u03BC\u03B9\u03BA\u03BF\u03AF \u03BC\u03B9\u03B1 \u03B6\u03C9\u03AE. \u0391\u03C6\u03BF\u03CD \u03C7\u03B1\u03B8\u03B5\u03AF \u03BC\u03B9\u03B1 \u03B6\u03C9\u03AE \u03B5\u03C0\u03B9\u03C3\u03C4\u03C1\u03AD\u03C6\u03BF\u03C5\u03BD \u03C3\u03C4\u03BF \u03B1\u03C3\u03C4\u03C5\u03BD\u03BF\u03BC\u03B9\u03BA\u03CC \u03C4\u03BC\u03AE\u03BC\u03B1 \u03BA\u03B1\u03B9 \u03C3\u03C5\u03BD\u03B5\u03C7\u03AF\u03B6\u03BF\u03C5\u03BD \u03B1\u03C0\u03CC \u03B5\u03BA\u03B5\u03AF. \u0388\u03BD\u03B1 \u03B1\u03BD\u03C4\u03AF\u03C3\u03C4\u03BF\u03B9\u03C7\u03BF \u03B4\u03C1\u03BF\u03BC\u03AC\u03BA\u03B9 \u03CC\u03C0\u03C9\u03C2 \u03C4\u03C9\u03BD \u03BA\u03BB\u03B5\u03C6\u03C4\u03CE\u03BD \u03C5\u03C0\u03AC\u03C1\u03C7\u03B5\u03B9 \u03BA\u03B1\u03B9 \u03B3\u03B9\u03B1 \u03C4\u03BF\u03C5\u03C2 \u03B1\u03C3\u03C4\u03C5\u03BD\u03BF\u03BC\u03B9\u03BA\u03BF\u03CD\u03C2, \u03C7\u03C9\u03C1\u03AF\u03C2 \u03CC\u03BC\u03C9\u03C2 \u03BD\u03B1 \u03B5\u03C0\u03B9\u03B2\u03B1\u03C1\u03CD\u03BD\u03BF\u03BD\u03C4\u03B1\u03B9 \u03B1\u03C0\u03CC \u03BA\u03AC\u03C4\u03B9. \u0395\u03C0\u03AF\u03C3\u03B7\u03C2, \u03CC\u03C4\u03B1\u03BD \u03BF\u03B9 \u03B1\u03C3\u03C4\u03C5\u03BD\u03BF\u03BC\u03B9\u03BA\u03BF\u03AF \u03C0\u03AD\u03C6\u03C4\u03BF\u03C5\u03BD \u03C3\u03C4\u03B7 \u03C6\u03B1\u03B2\u03AD\u03BB\u03B1 \u03C4\u03CC\u03C4\u03B5 \u03C7\u03AC\u03BD\u03BF\u03C5\u03BD \u03BC\u03B9\u03B1 \u03B6\u03C9\u03AE.\r\n\u039C\u03AD\u03C3\u03B1 \u03C3\u03C4\u03BF \u03C0\u03B1\u03B9\u03C7\u03BD\u03AF\u03B4\u03B9 \u03C5\u03C0\u03AC\u03C1\u03C7\u03BF\u03C5\u03BD \u03C4\u03C1\u03AF\u03B1 \u03B5\u03B9\u03B4\u03B9\u03BA\u03AC \u03C4\u03B5\u03C4\u03C1\u03AC\u03B3\u03C9\u03BD\u03B1 \u03C0\u03BF\u03C5 \u03B5\u03BC\u03C6\u03B1\u03BD\u03AF\u03B6\u03BF\u03C5\u03BD \u03BA\u03AC\u03C1\u03C4\u03B5\u03C2 \u03BA\u03B1\u03B9 \u03AD\u03BD\u03B1 \u03B1\u03BA\u03CC\u03BC\u03B1 \u03C0\u03BF\u03C5 \u03BF\u03BD\u03BF\u03BC\u03AC\u03B6\u03B5\u03C4\u03B1\u03B9 \u03C3\u03C4\u03C1\u03B1\u03C4\u03CC\u03C0\u03B5\u03B4\u03BF \u03BA\u03B1\u03B9 \u03AD\u03C7\u03B5\u03B9 \u03BD\u03CC\u03B7\u03BC\u03B1 \u03CD\u03C0\u03B1\u03C1\u03BE\u03B7\u03C2 \u03BC\u03CC\u03BD\u03BF \u03B3\u03B9\u03B1 \u03C4\u03BF\u03C5\u03C2 \u03BA\u03BB\u03AD\u03C6\u03C4\u03B5\u03C2. \u0391\u03BD \u03BB\u03BF\u03B9\u03C0\u03CC\u03BD \u03AD\u03BD\u03B1\u03C2 \u03BA\u03BB\u03AD\u03C6\u03C4\u03B7\u03C2 \u03C0\u03AD\u03C3\u03B5\u03B9 \u03C0\u03AC\u03BD\u03C9 \u03C3\u03C4\u03BF \u03C3\u03C4\u03C1\u03B1\u03C4\u03CC\u03C0\u03B5\u03B4\u03BF \u03BA\u03B1\u03B9 \u03B5\u03C0\u03B9\u03BB\u03AD\u03BE\u03B5\u03B9 \u03BD\u03B1 \u03C4\u03BF \u03BB\u03B7\u03C3\u03C4\u03AD\u03C8\u03B5\u03B9, \u03C4\u03C1\u03AF\u03B1 \u03C0\u03C1\u03AC\u03B3\u03BC\u03B1\u03C4\u03B1 \u03BC\u03C0\u03BF\u03C1\u03B5\u03AF \u03BD\u03B1 \u03C3\u03C5\u03BC\u03B2\u03BF\u03CD\u03BD, \u03B5\u03AF\u03C4\u03B5 \u03B8\u03B1 \u03BA\u03B5\u03C1\u03B4\u03AF\u03C3\u03B5\u03B9 500.000 \u03B5\u03C5\u03C1\u03CE, \u03B5\u03AF\u03C4\u03B5 \u03B8\u03B1 \u03C7\u03AC\u03C3\u03B5\u03B9 \u03BC\u03B9\u03B1 \u03B6\u03C9\u03AE, \u03B5\u03AF\u03C4\u03B5 \u03B4\u03B5 \u03B8\u03B1 \u03C3\u03C5\u03BC\u03B2\u03B5\u03AF \u03C4\u03AF\u03C0\u03BF\u03C4\u03B1 \u03BA\u03B1\u03B9 \u03B8\u03B1 \u03C3\u03C5\u03BD\u03B5\u03C7\u03B9\u03C3\u03C4\u03B5\u03AF \u03C4\u03BF \u03C0\u03B1\u03B9\u03C7\u03BD\u03AF\u03B4\u03B9 \u03C7\u03C9\u03C1\u03AF\u03C2 \u03BA\u03B1\u03BC\u03AF\u03B1 \u03B1\u03BB\u03BB\u03B1\u03B3\u03AE.\u03A0\u03C1\u03BF\u03C3\u03BF\u03C7\u03AE! \u0397 \u03B4\u03C5\u03BD\u03B1\u03C4\u03CC\u03C4\u03B7\u03C4\u03B1 \u03BB\u03B7\u03C3\u03C4\u03B5\u03AF\u03B1\u03C2 \u03C4\u03BF\u03C5 \u03B4\u03B5\u03BD \u03B5\u03C0\u03B7\u03C1\u03B5\u03AC\u03B6\u03B5\u03C4\u03B1\u03B9 \u03B1\u03C0\u03CC \u03C4\u03BF\u03BD \u03B1\u03C1\u03B9\u03B8\u03BC\u03CC \u03BB\u03B7\u03C3\u03C4\u03B5\u03B9\u03CE\u03BD \u03C0\u03BF\u03C5 \u03B5\u03C7\u03BF\u03C5\u03BD \u03C0\u03C1\u03B1\u03B3\u03BC\u03B1\u03C4\u03BF\u03C0\u03BF\u03B9\u03B7\u03B8\u03B5\u03AF \u03C3\u03C4\u03BF\u03BD \u03C3\u03C5\u03B3\u03BA\u03B5\u03BA\u03C1\u03B9\u03BC\u03AD\u03BD\u03BF\u03BD \u03B3\u03C5\u03C1\u03BF.\r\n\r\n\u03A3\u03C4\u03B7\u03BD \u03C0\u03B5\u03C1\u03AF\u03C0\u03C4\u03C9\u03C3\u03B7 \u03C0\u03BF\u03C5 \u03BA\u03AC\u03C0\u03BF\u03B9\u03BF\u03C2 \u03C0\u03B1\u03AF\u03BA\u03C4\u03B7\u03C2 \u03C7\u03AC\u03C3\u03B5\u03B9 \u03BA\u03B1\u03B9 \u03C4\u03B9\u03C2 \u03C4\u03AD\u03C3\u03C3\u03B5\u03C1\u03B9\u03C2 \u03B6\u03C9\u03AD\u03C2 \u03C4\u03BF\u03C5, \u03B2\u03B3\u03B1\u03AF\u03BD\u03B5\u03B9 \u03B1\u03C0\u03CC \u03C4\u03BF \u03C0\u03B1\u03B9\u03C7\u03BD\u03AF\u03B4\u03B9. \u0391\u03BD \u03B2\u03B3\u03BF\u03C5\u03BD \u03CC\u03BB\u03BF\u03B9 \u03BF\u03B9 \u03BA\u03BB\u03AD\u03C6\u03C4\u03B5\u03C2 \u03B1\u03C0\u03CC \u03C4\u03BF \u03C0\u03B1\u03B9\u03C7\u03BD\u03AF\u03B4\u03B9 \u03C4\u03CC\u03C4\u03B5 \u03BD\u03B9\u03BA\u03B7\u03C4\u03AD\u03C2 \u03B5\u03AF\u03BD\u03B1\u03B9 \u03BF\u03B9 \u03B1\u03C3\u03C4\u03C5\u03BD\u03BF\u03BC\u03B9\u03BA\u03BF\u03AF \u03BA\u03B1\u03B9 \u03C0\u03C1\u03CE\u03C4\u03BF\u03C2 \u03B5\u03AF\u03BD\u03B1\u03B9 \u03B1\u03C5\u03C4\u03CC\u03C2 \u03C0\u03BF\u03C5 \u03AD\u03C7\u03B5\u03B9 \u03C3\u03C5\u03B3\u03BA\u03B5\u03BD\u03C4\u03C1\u03CE\u03C3\u03B5\u03B9 \u03C4\u03B1 \u03C0\u03B5\u03C1\u03B9\u03C3\u03C3\u03CC\u03C4\u03B5\u03C1\u03B1 \u03BA\u03BB\u03B5\u03BC\u03BC\u03AD\u03BD\u03B1 \u03C7\u03C1\u03AE\u03BC\u03B1\u03C4\u03B1. \u0391\u03BD \u03B2\u03B3\u03BF\u03C5\u03BD \u03CC\u03BB\u03BF\u03B9 \u03BF\u03B9 \u03B1\u03C3\u03C4\u03C5\u03BD\u03BF\u03BC\u03B9\u03BA\u03BF\u03AF \u03B1\u03C0\u03CC \u03C4\u03BF \u03C0\u03B1\u03B9\u03C7\u03BD\u03AF\u03B4\u03B9 \u03AE \u03BB\u03B7\u03C3\u03C4\u03B5\u03C5\u03B8\u03BF\u03CD\u03BD \u03CC\u03BB\u03B1 \u03C4\u03B1 \u03BA\u03C4\u03AE\u03C1\u03B9\u03B1 \u03C4\u03CC\u03C4\u03B5 \u03BD\u03B9\u03BA\u03B7\u03C4\u03AD\u03C2 \u03B5\u03AF\u03BD\u03B1\u03B9 \u03BF\u03B9 \u03BA\u03BB\u03AD\u03C6\u03C4\u03B5\u03C2 \u03BA\u03B1\u03B9 \u03C0\u03C1\u03CE\u03C4\u03BF\u03C2 \u03B5\u03AF\u03BD\u03B1\u03B9 \u03B1\u03C5\u03C4\u03CC\u03C2 \u03C0\u03BF\u03C5 \u03AD\u03C7\u03B5\u03B9 \u03BA\u03BB\u03AD\u03C8\u03B5\u03B9 \u03C4\u03B1 \u03C0\u03B9\u03BF \u03C0\u03BF\u03BB\u03BB\u03AC \u03C7\u03C1\u03AE\u03BC\u03B1\u03C4\u03B1.\r\n");
							textPane.setBounds(0, 0, 649, 488);
							pan2.getContentPane().add(textPane);
						}
					}
				});
				JButton button_1 = new JButton("\u0395\u039E\u039F\u0394\u039F\u03A3 \u03A0\u0391\u0399\u03A7\u039D\u0399\u0394\u0399\u039F\u03A5");
				
				button_1.setForeground(Color.WHITE);
				button_1.setFont(new Font("Tahoma", Font.BOLD, 11));
				button_1.setBackground(new Color(102, 0, 0));
				button_1.setBounds(107, 177, 187, 33);
				button_1.setActionCommand("ΕΞΟΔΟΣ");
				pan.getContentPane().add(button_1);
				
				button_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent ee) {
						if(ee.getActionCommand().equals("ΕΞΟΔΟΣ")) {
								System.exit(0);
						}
					}
				});
				
				JLabel lblNewLabel = new JLabel("New label");
				lblNewLabel.setIcon(new ImageIcon(Table.class.getResource("/images/\u03BC\u03B5\u03BD\u03BF\u03C5.png")));
				lblNewLabel.setBounds(0, 0, 401, 297);
				pan.getContentPane().add(lblNewLabel);
				
			}
			
		
			if(e.getActionCommand().equals("BATHMOLOGIA")){
				Vathmologia_tablo vathm =new Vathmologia_tablo(t,0);
			}
		
			if(e.getActionCommand().equals("ZARI"))
			{
				 music.IxitikoEffe("button-3.wav");
				 Random rand = new Random();
				 int dice = rand.nextInt(5) + 1;
				 
				 textField.setText(""+dice); 
				 
				
				 
				 for (int i=1; i<=dice; i++)                                                      //Proxorame ton paikti mia mia tis theseis
				 {
					
					 if (t.getPaiktes().get(number) instanceof Astinomikos){
						 if(t.getPaiktes().get(number).getThesi()==15 && dice>=i  && i==1)       // An einai  stin thesi 15 prin riksei to zari
						 {
							 
							 int d = JOptionPane.showConfirmDialog(
							            null,
							            "Θέλεις να ακολουθήσεις το δρομάκι;",
							            "",
							            JOptionPane.YES_NO_OPTION);
							 if(d==JOptionPane.YES_OPTION){
								 t.getPaiktes().get(number).DromakiAstinomou();
								 i=1;
							 }
						 }
						 if(t.getPaiktes().get(number).getThesi()>=32)						//Gia oso vriskete sto dromaki
						 {
							t.getPaiktes().get(number).EnimerosiThesiDromaki(1);
							pawn.setXY_dromaki(1,number);
							pawn.repaint();
						 }
						 else{
						
							
							
							 pawn.setXYCoordinates(1,number);
							 pawn.repaint();
							 t.getPaiktes().get(number).EnimerosiThesis(1);
							
						 }
						 if(t.getPaiktes().get(number).getThesi()==15 && dice>i )
						 {
							 
							 int d = JOptionPane.showConfirmDialog(
							            null,
							            "Θέλεις να ακολουθήσεις το δρομάκι;",
							            "",
							            JOptionPane.YES_NO_OPTION);
							 if(d==JOptionPane.YES_OPTION){
								 t.getPaiktes().get(number).DromakiAstinomou();
							 }
						 }
						 
					 }
					 else
						 
					 {
						 if (t.getPaiktes().get(number).getThesi()==17 && dice>=i  && i==1)
						 {	
							 
							 int d = JOptionPane.showConfirmDialog(
							            null,
							            "Θέλεις να ακολουθήσεις το δρoμάκι;"
							            + "Θυμήσου οτι θα χάσεις το 40% του ποσού που κουβαλάς",
							            "",
							            JOptionPane.YES_NO_OPTION);
							 if(d==JOptionPane.YES_OPTION){
								 t.getPaiktes().get(number).DromakiKlefti();
								 t.getPaiktes().get(number).DromakiMiosi();
								 i=1;
								 
							 }
						 }
						 if(t.getPaiktes().get(number).getThesi()>=38)
						 {
							
							t.getPaiktes().get(number).EnimerosiThesiDromaki(1);
							pawn.setXY_dromaki(1,number);
							pawn.repaint();
						 }
						 else{
						
							 pawn.setXYCoordinates(1,number);
							 pawn.repaint(); 
							 t.getPaiktes().get(number).EnimerosiThesis(1);
						 }
						
						 if(t.getPaiktes().get(number).getThesi()==17 && dice>i )		 
						 {
							 int d = JOptionPane.showConfirmDialog(
							            null,
							            "Θέλεις να ακολουθήσεις το δρωμάκι;"
							            + "Θυμήσου οτι θα χάσεις το 40% του ποσού που κουβαλάς",
							            "",
							            JOptionPane.YES_NO_OPTION);
							 if(d==JOptionPane.YES_OPTION){                                      //o kleftis epilegei to dromaki
								 t.getPaiktes().get(number).DromakiKlefti();	
								 t.getPaiktes().get(number).DromakiMiosi();
							 }
							
						 }
						
						 if(t.getPaiktes().get(number).getThesi()==0)                   // O kleftis pernaei apo tin favela
						 {
							 t.getPaiktes().get(number).PerasmaFavela();
							 JPanel panel= new JPanel();
							 JOptionPane.showMessageDialog(panel,"Έφτασες στην φαβέλα! Διασφαλίζεις τα χρήματα σου");
						 }
					 }
					 
					
				 }
				// o paiktis vriskete sti nea toy thesi
			
				 pawn.repaint();
				 if(t.getPaiktes().get(number).getThesi()<32 && t.getTabloPaixnidiou().get(t.getPaiktes().get(number).getThesi()) instanceof Karta){               //tyxainei se karta
					int r=t.getTabloPaixnidiou().get(t.getPaiktes().get(number).getThesi()).Epilogi_Kartas(t.getPaiktes().get(number));
					
					if(t.getPaiktes().get(number) instanceof Kleftis){
						if(r<4){
							pawn.setXYCoordinates(r, number);
							t.getPaiktes().get(number).EnimerosiThesis(r);
						}
						else if(r==4){
							t.getPaiktes().get(number).PerasmaFavela();
							t.getPaiktes().get(number).EnimerosiThesis(32-t.getPaiktes().get(number).getThesi());
							t.getPaiktes().get(number).EnimerosiXY(113+number,549+number);
						}
						else if(r==5){
							t.getPaiktes().get(number).setAnamoni(1);
						}
						else if(r==6){
							t.getPaiktes().get(number).setTrexon_poso(t.getPaiktes().get(number).getTrexon_poso()-(t.getPaiktes().get(number).getTrexon_poso()*0.25));
						}
						else if(r==7){
							t.getPaiktes().get(number).setTrexon_poso(t.getPaiktes().get(number).getTrexon_poso()+(t.getPaiktes().get(number).getTrexon_poso()*0.20));
						}
						else if(r==8){
							t.getPaiktes().get(number).EnimerosiXY(698+number, 189+number);
							t.getPaiktes().get(number).EnimerosiThesis(17-t.getPaiktes().get(number).getThesi());
						}
					}
					else{
						if(r<4){
							pawn.setXYCoordinates(r, number);
							t.getPaiktes().get(number).EnimerosiThesis(r);
						}
						else if(r==4){
							t.getPaiktes().get(number).EnimerosiXY(375+number-1, 550+number-1);
							t.getPaiktes().get(number).EnimerosiThesis(28-t.getPaiktes().get(number).getThesi());
						}else if(r==5){
							t.getPaiktes().get(number).setAnamoni(1);
						}
						else if(r==6){
							t.getPaiktes().get(number).EnimerosiXY(115+number-1, 130+number-1);
							t.getPaiktes().get(number).EnimerosiThesis(7-t.getPaiktes().get(number).getThesi()); 	                                           //epilegi tin gwnia 1
						}
						else if(r==7){
							t.getPaiktes().get(number).EnimerosiXY(700+number-1, 550+number-1);
							t.getPaiktes().get(number).EnimerosiThesis(23-t.getPaiktes().get(number).getThesi()); 										   //epilegei tin gwnia 2
						}
					}
					
				 }
				 pawn.repaint();
				 
				 
				 
 
				 if(t.getPaiktes().get(number) instanceof Astinomikos) {
					 if(t.getPaiktes().get(number).getThesi()==0){                    //O astinomos peftei stin favela
						 t.getPaiktes().get(number).DecZoes();
						 if(t.getPaiktes().get(number).PaiktisIsDead()){
							 if(t.getPaiktes().get(number).PaiktisIsDead()){
								 JFrame pan=new JFrame();
								 pan.setUndecorated(true);
								 pan.setResizable(false);
								 pan.setBounds(475,230, 400, 320);
								 pan.setVisible(true);
								 pan.setLocationRelativeTo(null);
								 JLabel lblNewLabel = new JLabel("New label");
									lblNewLabel.setIcon(new ImageIcon(Table.class.getResource("/images/dead.png")));
									lblNewLabel.setBounds(0, 0, 401, 309);
									pan.getContentPane().add(lblNewLabel);
									 music.IxitikoEffe("dead.wav");
									 pan.addMouseListener(new MouseAdapter() {
									     @Override
									     public void mousePressed(MouseEvent e) {
									        pan.setVisible(false);
									        pan.dispose();
									     }
									  });
									 if(t.TelosPaixnidiou(number))
										 pan.dispose();
							 }
						 }
						 else{
							
							 JFrame pan=new JFrame();
							 pan.setUndecorated(true);
							 pan.setResizable(false);
							 pan.setBounds(475,230, 400, 320);
							 pan.setVisible(true);
							 pan.setLocationRelativeTo(null);
							 
							 JLabel lblNewLabel = new JLabel("New label");
							 
						     lblNewLabel.setIcon(new ImageIcon(Table.class.getResource("/images/\u03AD\u03C0\u03B5\u03C3\u03B5\u03C2 \u03C3\u03C4\u03B7\u03BD \u03C6\u03B1\u03B2\u03AD\u03BB\u03B1.png")));
							 lblNewLabel.setBounds(0, 0, 401, 282);
							 pan.getContentPane().add(lblNewLabel);
							 music.IxitikoEffe("machineguns.wav");
							 pan.addMouseListener(new MouseAdapter() {
							     @Override
							     public void mousePressed(MouseEvent e) {
							        pan.setVisible(false);
							        pan.dispose();
							     }
							  });
							
						 }
						 

					 }
					 else if(t.getPaiktes().get(number).getThesi()==t.getPaiktes().get(0).getThesi() && t.getPaiktes().get(number).getThesi()==t.getPaiktes().get(2).getThesi() && t.getPaiktes().get(0).getTrexon_poso()>0 && t.getPaiktes().get(2).getTrexon_poso()>0 ) //An o batsos piasei kai tous 2 kleftes me posa
					 {
						 
						 if(number==1)
							 t.getPaiktes().get(number).EnimerosiXY(700,130);    // stelnoyme ton astinomo kai tous 2 kleftes sto AT
						 else 
							 t.getPaiktes().get(number).EnimerosiXY(702,132);
						 t.getPaiktes().get(0).EnimerosiXY(698, 128);
						 t.AstinomosPianeiKlefti(t.getPaiktes().get(number), t.getPaiktes().get(0),number);
						 t.getPaiktes().get(2).EnimerosiXY(700,130);
						 t.AstinomosPianeiKlefti(t.getPaiktes().get(number), t.getPaiktes().get(2),number);
					 }
					 else if (t.getPaiktes().get(number).getThesi()==t.getPaiktes().get(0).getThesi() && t.getPaiktes().get(0).getTrexon_poso()>0) 	//An o batsos piasei ton klefti 1
					 {
						 
						 if(number==1)
							 t.getPaiktes().get(number).EnimerosiXY(700,130);    // stelnoyme ton astinomo kai ton klefti pou piastike sto AT
						 else 
							 t.getPaiktes().get(number).EnimerosiXY(702,132);
						 t.getPaiktes().get(0).EnimerosiXY(698, 128);
						 t.AstinomosPianeiKlefti(t.getPaiktes().get(number), t.getPaiktes().get(0),number);
					 }
					 else if (t.getPaiktes().get(number).getThesi()==t.getPaiktes().get(2).getThesi()&& t.getPaiktes().get(2).getTrexon_poso()>0)                   //An o batsos piasei ton klefti 2
					 {
						
						 if(number==1)
							 t.getPaiktes().get(number).EnimerosiXY(700,130);    // stelnoyme ton astinomo kai ton klefti pou piastike sto AT
						 else 
							 t.getPaiktes().get(number).EnimerosiXY(702,132);
						 t.getPaiktes().get(2).EnimerosiXY(700,130);
						 t.AstinomosPianeiKlefti(t.getPaiktes().get(number), t.getPaiktes().get(2),number);
						
					 }
				 }
				 
				 
				 if(t.getPaiktes().get(number) instanceof Kleftis && t.getPaiktes().get(number).getThesi()<32 && t.getPaiktes().get(number).getThesi()!=t.getPaiktes().get(1).getThesi() && t.getPaiktes().get(number).getThesi()!=t.getPaiktes().get(3).getThesi()){
					 Listia(t.getPaiktes().get(number).getThesi());
				 }

				 
				 if(t.getPaiktes().get(number) instanceof Kleftis){
					 if(t.getPaiktes().get(number).getTrexon_poso()>0)             //An kouvalaei trexon poso
					 {
						 if(t.getPaiktes().get(number).getThesi()==t.getPaiktes().get(1).getThesi())   //an pesei ston astinomo1
						 {
							 
							 if(number==1)
								 t.getPaiktes().get(number).EnimerosiXY(698,128);    // stelnoyme ton astinomo1 kai ton klefti pou piastike sto AT
							 else 
								 t.getPaiktes().get(number).EnimerosiXY(700,130);
							 t.getPaiktes().get(1).EnimerosiXY(700,130);
							 t.AstinomosPianeiKlefti(t.getPaiktes().get(1), t.getPaiktes().get(number),number);
						 }
						 else if(t.getPaiktes().get(number).getThesi()==t.getPaiktes().get(3).getThesi())      //an pesei ston astinomo2
						 {
							 if(number==1)
								 t.getPaiktes().get(number).EnimerosiXY(698,128);    // stelnoyme ton astinomo2 kai ton klefti pou piastike sto AT
							 else 
								 t.getPaiktes().get(number).EnimerosiXY(700,130);
							 t.getPaiktes().get(3).EnimerosiXY(702,132);
							 t.AstinomosPianeiKlefti(t.getPaiktes().get(3), t.getPaiktes().get(number),number);
						 }
						 
					 }
					 else                          //xanei zwi o astinomos
					 {
						 if(t.getPaiktes().get(number).getThesi()!=16 && t.getPaiktes().get(number).getThesi()==t.getPaiktes().get(1).getThesi()&&t.getPaiktes().get(number).getThesi()==t.getPaiktes().get(3).getThesi()){
							 t.getPaiktes().get(1).DecZoes();
							 t.getPaiktes().get(1).PigeneAT();
							 t.getPaiktes().get(1).setAnamoni(1);               //pianei kai toys dyo astinomous!
							 t.getPaiktes().get(1).EnimerosiXY(700,130);
							 t.getPaiktes().get(3).DecZoes();
							 t.getPaiktes().get(3).PigeneAT();
							 t.getPaiktes().get(3).setAnamoni(1);
							 t.getPaiktes().get(3).EnimerosiXY(702,132);
						
							 
							 if(t.getPaiktes().get(1).PaiktisIsDead() || t.getPaiktes().get(3).PaiktisIsDead()){
								 JFrame pan2=new JFrame();
								 pan2.setUndecorated(true);
								 pan2.setResizable(false);
								 pan2.setBounds(475,230, 400, 320);
								 pan2.setVisible(true);
								 pan2.setLocationRelativeTo(null);
								 JLabel lblNewLabel2 = new JLabel("New label");
									lblNewLabel2.setIcon(new ImageIcon(Table.class.getResource("/images/dead.png")));
									lblNewLabel2.setBounds(0, 0, 401, 309);
									pan2.getContentPane().add(lblNewLabel2);
									 music.IxitikoEffe("dead.wav");
									 pan2.addMouseListener(new MouseAdapter() {
									     @Override
									     public void mousePressed(MouseEvent e) {
									        pan2.setVisible(false);
									        pan2.dispose();
									     }
									  });
									 if(t.TelosPaixnidiou(number))
										 pan2.dispose();
							 }
							 else{
								 JFrame pan=new JFrame();
								 pan.setUndecorated(true);
								 pan.setResizable(false);
								 pan.setBounds(475,230, 400, 320);
								 pan.setVisible(true);
								 pan.setLocationRelativeTo(null);
								 JLabel lblNewLabel = new JLabel("New label");
									lblNewLabel.setIcon(new ImageIcon(Table.class.getResource("/images/\u03B5\u03BD\u03AD\u03B4\u03C1\u03B1.png")));
									lblNewLabel.setBounds(0, 0, 401, 296);
									pan.getContentPane().add(lblNewLabel);
									 music.IxitikoEffe("machineguns.wav");
									 pan.addMouseListener(new MouseAdapter() {
									     @Override
									     public void mousePressed(MouseEvent e) {
									        pan.setVisible(false);
									        pan.dispose();
									     }
									  });
							 }
						 }
						 else if(t.getPaiktes().get(number).getThesi()!=16 && t.getPaiktes().get(number).getThesi()==t.getPaiktes().get(1).getThesi())   
						 {
							 t.getPaiktes().get(1).DecZoes();
							 t.getPaiktes().get(1).PigeneAT();
							 t.getPaiktes().get(1).setAnamoni(1);
							 t.getPaiktes().get(1).EnimerosiXY(700,130); 
							
							 
							 if(t.getPaiktes().get(1).PaiktisIsDead()){
								 JFrame pan2=new JFrame();
								 pan2.setUndecorated(true);
								 pan2.setResizable(false);
								 pan2.setBounds(475,230, 400, 320);
								 pan2.setVisible(true);
								 pan2.setLocationRelativeTo(null);
								 JLabel lblNewLabel2 = new JLabel("New label");
									lblNewLabel2.setIcon(new ImageIcon(Table.class.getResource("/images/dead.png")));
									lblNewLabel2.setBounds(0, 0, 401, 309);
									pan2.getContentPane().add(lblNewLabel2);
									music.IxitikoEffe("dead.wav");
									 pan2.addMouseListener(new MouseAdapter() {
									     @Override
									     public void mousePressed(MouseEvent e) {
									        pan2.setVisible(false);
									        pan2.dispose();
									     }
									  });
									 if(t.TelosPaixnidiou(number))
										 pan2.dispose();
							 }
							 else{
								
								 JFrame pan=new JFrame();
								 pan.setUndecorated(true);
								 pan.setResizable(false);
								 pan.setBounds(475,230, 400, 320);
								 pan.setVisible(true);
								 pan.setLocationRelativeTo(null);
								 JLabel lblNewLabel = new JLabel("New label");
									lblNewLabel.setIcon(new ImageIcon(Table.class.getResource("/images/\u03B5\u03BD\u03AD\u03B4\u03C1\u03B1.png")));
									lblNewLabel.setBounds(0, 0, 401, 296);
									pan.getContentPane().add(lblNewLabel);
									 music.IxitikoEffe("machineguns.wav");
									 pan.addMouseListener(new MouseAdapter() {
									     @Override
									     public void mousePressed(MouseEvent e) {
									        pan.setVisible(false);
									        pan.dispose();
									     }
									  });
							 }
							
						 }
						 else if(t.getPaiktes().get(number).getThesi()!=16 && t.getPaiktes().get(number).getThesi()==t.getPaiktes().get(3).getThesi())   
						 {
							 t.getPaiktes().get(3).DecZoes();
							 t.getPaiktes().get(3).PigeneAT();
							 t.getPaiktes().get(3).setAnamoni(1);
							 t.getPaiktes().get(3).EnimerosiXY(702,132);
							
							 
							 if(t.getPaiktes().get(3).PaiktisIsDead()){
								 JFrame pan2=new JFrame();
								 pan2.setUndecorated(true);
								 pan2.setResizable(false);
								 pan2.setBounds(475,230, 400, 320);
								 pan2.setVisible(true);
								 pan2.setLocationRelativeTo(null);
								 JLabel lblNewLabel2 = new JLabel("New label");
									lblNewLabel2.setIcon(new ImageIcon(Table.class.getResource("/images/dead.png")));
									lblNewLabel2.setBounds(0, 0, 401, 309);
									pan2.getContentPane().add(lblNewLabel2);
									music.IxitikoEffe("dead.wav");
									 pan2.addMouseListener(new MouseAdapter() {
									     @Override
									     public void mousePressed(MouseEvent e) {
									        pan2.setVisible(false);
									        pan2.dispose();
									     }
									  });
									 if(t.TelosPaixnidiou(number))
										 pan2.dispose();
							 }
							 else{
								 JFrame pan=new JFrame();
								 pan.setUndecorated(true);
								 pan.setResizable(false);
								 pan.setBounds(475,230, 400, 320);
								 pan.setVisible(true);
								 pan.setLocationRelativeTo(null);
								 JLabel lblNewLabel = new JLabel("New label");
									lblNewLabel.setIcon(new ImageIcon(Table.class.getResource("/images/\u03B5\u03BD\u03AD\u03B4\u03C1\u03B1.png")));
									lblNewLabel.setBounds(0, 0, 401, 296);
									pan.getContentPane().add(lblNewLabel);
									 music.IxitikoEffe("machineguns.wav");
									 pan.addMouseListener(new MouseAdapter() {
									     @Override
									     public void mousePressed(MouseEvent e) {
									        pan.setVisible(false);
									        pan.dispose();
									     }
									  });
							 }
								
						 } 
					 }
					 if(t.getPaiktes().get(number).getThesi()==16 && t.getPaiktes().get(number).getAnamoni()==0){ 
						 											//o kleftis peftei sto at
						
						 t.getPaiktes().get(number).DecZoes();
						 t.getPaiktes().get(number).Midenismos_Arithmos_listion();
						 t.getPaiktes().get(number).Midenismos_Trexon_Poso();
						 t.getPaiktes().get(number).setAnamoni(1);
						 if(t.getPaiktes().get(number).PaiktisIsDead()){
							 JFrame pan2=new JFrame();
							 pan2.setUndecorated(true);
							 pan2.setResizable(false);
							 pan2.setBounds(475,230, 400, 320);
							 pan2.setVisible(true);
							 pan2.setLocationRelativeTo(null);
							 JLabel lblNewLabel2 = new JLabel("New label");
								lblNewLabel2.setIcon(new ImageIcon(Table.class.getResource("/images/dead.png")));
								lblNewLabel2.setBounds(0, 0, 401, 309);
								pan2.getContentPane().add(lblNewLabel2);
								 music.IxitikoEffe("dead.wav");
								 pan2.addMouseListener(new MouseAdapter() {
								     @Override
								     public void mousePressed(MouseEvent e) {
								        pan2.setVisible(false);
								        pan2.dispose();
								     }
								  });
								 if(t.TelosPaixnidiou(number))
									 pan2.dispose();
						 }
						 else{
							 JFrame pan=new JFrame();
							 pan.setUndecorated(true);
							 pan.setResizable(false);
							 pan.setBounds(475,230, 400, 320);
							 pan.setVisible(true);
							 pan.setLocationRelativeTo(null);
							 JLabel lblNewLabel = new JLabel();
							 lblNewLabel.setIcon(new ImageIcon(Table.class.getResource("/images/\u03BF \u03BA\u03BB \u03C0\u03B9\u03B1\u03BD\u03B5\u03C4\u03B1\u03B9.png")));
							 lblNewLabel.setBounds(0, 0, 401, 320);
						   	pan.getContentPane().add(lblNewLabel);
						    music.IxitikoEffe("Woop woop.wav");
						    pan.addMouseListener(new MouseAdapter() {
							     @Override
							     public void mousePressed(MouseEvent e) {
							        pan.setVisible(false);
							        pan.dispose();
							     }
							  });
						 }
						
					 }
					
				 }
				 
				 
				 
				 
				 pawn.repaint();
				 number=((number+1)%4);
				 
				 int test=num_svisimo;
				 if(num_svisimo==24&& t.getPaiktes().get(last_player).getTrexon_poso()==0) {
					 	 test=num_svisimo+1;																		//an exoune listeytei ola ta ktiria kai o paiktis pou to listepse xasei to trexon poso tou 
				 }
					
				 if(t.TelosPaixnidiou(test))                                 //teleiwnei to paixnidi
				 {
					 
					 JOptionPane jp=new JOptionPane();
					 JOptionPane.showMessageDialog(null,"Τέλος Παιχνιδιού!");
						
					 Vathmologia_tablo vathm = new Vathmologia_tablo(t,1);
					 
					 music.stop();
					
					 setVisible(false);
					 dispose();
					 
				 }

				 if(t.getPaiktes().get(number).PaiktisIsDead()){                  //4 elegxoi gia na maste sigouroi!
					 number=((number+1)%4);
				 }
				 if(t.getPaiktes().get(number).PaiktisIsDead())
				 {
					 number=((number+1)%4);
				 }
				 if(t.getPaiktes().get(number).PaiktisIsDead())
				 {
					 number=((number+1)%4);
				 } 
				 if(t.getPaiktes().get(number).PaiktisIsDead())
				 {
					 number=((number+1)%4);
				 } 
				 
				 pawn.repaint();
				 
				while(t.getPaiktes().get(number).PaiktisIsDead()||t.getPaiktes().get(number).getAnamoni()>0){
					 if(t.getPaiktes().get(number).getAnamoni()>0){	 														//Xaneis tin seira soy
						 t.getPaiktes().get(number).DecAnamoni(); 
					 } 
					 number=((number+1)%4);
				}
				
				
				 pawn.repaint();
			
			   
				 
				 			 
				 
				 
			}
	
			
			
		
		}
		public void timea(){
			try {
				Thread.sleep(2000);
			} catch (java.lang.InterruptedException iex) {
				System.out.println(iex);
			}
		}
		
	
	}

	
	
}