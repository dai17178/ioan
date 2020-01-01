
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class tablo {
 private ArrayList<Koutaki> tabloPaixnidiou = new ArrayList<Koutaki>();
 private String name;	
 private ArrayList<Paiktis> paiktes = new ArrayList<Paiktis>();
 

 
 public tablo (String name)
 {
	 this.name= name;
 }
  
 public void addKoutaki(Koutaki e)
 {
	 tabloPaixnidiou.add(e);
 }
 
 
 public void addPlayer(Paiktis p)
 {
	 paiktes.add(p);
 }
 
 
 
 public ArrayList<Koutaki> getTabloPaixnidiou() {
	return tabloPaixnidiou;
}

public String getName() {
	return name;
}

public ArrayList<Paiktis> getPaiktes() {
	return paiktes;
}

public void AstinomosPianeiKlefti(Paiktis a,Paiktis k,int num)             
{
    Music music=new Music("");
	k.PigeneAT();
	k.DecZoes();
	a.IncPoso(k.getTrexon_poso());
	a.PigeneAT();
	k.Midenismos_Trexon_Poso();
	k.Midenismos_Arithmos_listion();
	k.setAnamoni(1);     
	 if(k.PaiktisIsDead()){                                                      //o paiktis pethenei
		 JFrame pan=new JFrame();
		 pan.setUndecorated(true);
		 pan.setResizable(false);
		 pan.setBounds(475,230, 400, 320);
		 pan.setVisible(true);
		 pan.setLocationRelativeTo(null);
		 JLabel lblNewLabel = new JLabel("New label");
			lblNewLabel.setIcon(new ImageIcon(tablo.class.getResource("/images/dead.png")));
			lblNewLabel.setBounds(0, 0, 401, 309);
			pan.getContentPane().add(lblNewLabel);
			music.IxitikoEffe("dead.wav");
			if(TelosPaixnidiou(num)){
				pan.setVisible(false);
				pan.dispose();
			}
			 pan.addMouseListener(new MouseAdapter() {
			     @Override
			     public void mousePressed(MouseEvent e) {
			        pan.setVisible(false);
			        pan.dispose();
			     }
			  });
	 }
	 else
	 {
		 JFrame pan=new JFrame();
		 pan.setUndecorated(true);
		 pan.setResizable(false);
		 pan.setBounds(475,230, 400, 320);
		 pan.setVisible(true);
		 pan.setLocationRelativeTo(null);
		 JLabel lblNewLabel = new JLabel();
		 lblNewLabel.setIcon(new ImageIcon(tablo.class.getResource("/images/\u03BF \u03BA\u03BB \u03C0\u03B9\u03B1\u03BD\u03B5\u03C4\u03B1\u03B9.png")));
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

public boolean TelosPaixnidiou(int num){
	if(paiktes.get(0).PaiktisIsDead() && paiktes.get(2).PaiktisIsDead())
		return true;
	else if(paiktes.get(1).PaiktisIsDead() && paiktes.get(3).PaiktisIsDead())
		return true;
	else if (num==25)         //24+1
		return true;
	else 
		return false;
	
}
	 
	
}
	 
