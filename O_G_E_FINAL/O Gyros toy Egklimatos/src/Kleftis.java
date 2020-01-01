public class Kleftis extends Paiktis{
private double trexon_poso;
private int arithmos_listiwn;
	
 
 public Kleftis(String name, int thesi, double poso, int zoes, double trexon_poso,int arithmos_listwn,int cordX,int cordY) {
	super(name, thesi, poso, zoes,cordX,cordY);	
    this.arithmos_listiwn=arithmos_listiwn;
    this.trexon_poso=trexon_poso;
 }

public void printInfo()
{
	super.printInfo();
}
 
public double getTrexon_poso() {
	return trexon_poso;
}

public void setTrexon_poso(double x){
	trexon_poso=x;
}


public int getArithmos_listiwn() {
	return arithmos_listiwn;
}

public void IncTrexonPoso(double poso_listias)
 {
	 trexon_poso= trexon_poso+poso_listias;
 }
	
 public void IncArithmosListeiwn()
 {
	 arithmos_listiwn = arithmos_listiwn +1; 
 }

 public void Midenismos_Trexon_Poso()
 {
	 trexon_poso=0;
 }

 public void Midenismos_Arithmos_listion()
 {
	 arithmos_listiwn=0;
 }

public void PerasmaFavela()
{
	arithmos_listiwn=0;
	this.IncPoso(trexon_poso);
	trexon_poso=0;
}

public void DromakiMiosi(){                           //pairnei to dromaki
	trexon_poso=trexon_poso-(0.4*trexon_poso);
}

}
