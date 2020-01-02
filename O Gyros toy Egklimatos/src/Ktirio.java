import java.awt.Graphics;
import java.util.ArrayList;

public class Ktirio extends Koutaki{
	
	private int poso;
	private int xronos_anamonis;
	private int Zoes_ktiriou;

	public Ktirio(String onoma, int poso, int xronos_anamonis, int zoes_ktiriou) {
		super(onoma);
		this.poso = poso;
		this.xronos_anamonis = xronos_anamonis;
		Zoes_ktiriou = zoes_ktiriou;
	}

	public int getPoso() {
		return poso;
	}

	public int getXronos_anamonis() {
		return xronos_anamonis;
	}

	public int getZoes_ktiriou() {
		return Zoes_ktiriou;
	}
	public void DecZoes(){
		this.Zoes_ktiriou--;
	}
	
	public boolean diarkia_anamonis_ktiriou()
	{
		if (xronos_anamonis > 0)
		{
			xronos_anamonis --;
			return false;
		}
		else return true;
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
	public void epilogi_1or2or3(Paiktis p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int EktelesiKartas(int arithmos_kartas, Paiktis paiktis,String karta) {
		return 0;
		// TODO Auto-generated method stub
		
	}

}
