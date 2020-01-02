import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Stratopedo extends Koutaki{

	public Stratopedo(String onoma) {
		super(onoma);
	}
	
	public void epilogi_1or2or3(Paiktis p) {
		Random rand = new Random();
		int apotelesma = rand.nextInt(3) + 1;
		
	    if(apotelesma == 1 ) {
			 JOptionPane.showMessageDialog(null,"Κέρδισες 500.000 $");
			 p.IncTrexonPoso(500000);
			 p.IncArithmosListeiwn();
		}
		else if(apotelesma ==2 ) {
			JOptionPane.showMessageDialog(null,"Έχασες μια ζωή");
			p.DecZoes();
		}
		else if(apotelesma ==3 ) {
			JOptionPane.showMessageDialog(null,"Συνεχίζεις το παιχνίδι");
		}
	    
	}

	@Override
	public int getPoso() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getXronos_anamonis() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getZoes_ktiriou() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean diarkia_anamonis_ktiriou() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<String> getKartes_klefti() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<String> getKartes_astunomou() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int Epilogi_Kartas(Paiktis p) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void DecZoes() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int EktelesiKartas(int arithmos_kartas, Paiktis paiktis,String karta) {
		return 0;
		// TODO Auto-generated method stub
		
	}
}
