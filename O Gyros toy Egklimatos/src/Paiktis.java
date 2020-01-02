
public abstract class Paiktis {

private String name;
private int thesi;
private int zoes;
private double poso;
private int x;
private int y;
private int anamoni;


public Paiktis(String name,int thesi,double poso,int zoes,int cordX,int cordY)
{
	this.name=name;
	this.thesi=thesi;
	this.poso=poso;
	this.zoes=zoes;
	this.x=cordX;
	this.y=cordY;
	this.anamoni=0;
}


public String getName() {
	return name;
}


public int getThesi() {
	return thesi;
}


public int getZoes() {
	return zoes;
}


public double getPoso() {
	return poso;
}

public int getX(){
	return x;
}

public int getY(){
	return y;
}

public int getAnamoni(){
	return anamoni;
}
public void setAnamoni(int a){
	this.anamoni=a;
}
public void DecAnamoni(){
	if (anamoni>0)
		anamoni--;
}
public void  DecZoes()
{
	zoes= zoes-1;
}

public void IncPoso(double p)
{
	poso=poso + p;
}

public void EnimerosiThesis(int zari)
{
  thesi=(thesi+zari) % 32;	
}

public void PigeneAT()
{
	thesi=16;
}


public void printInfo()
{
	
	System.out.println("the name of player is:" +getName());
}
public void EnimerosiXY(int Cord_x,int Cord_y){
	x=Cord_x;
	y=Cord_y;
}

public void DromakiAstinomou()
{
	thesi=32;
}
public void DromakiKlefti(){
	thesi=38;
}
public void EnimerosiThesiDromaki(int zari){
	thesi=thesi+zari;
}

public boolean PaiktisIsDead(){
	if(zoes>0){
		return false;
	}else 
	{
		if(this instanceof Kleftis){
			thesi=60;                 //thetoume tin thesi toy pakti ena megalo noymero gia na mn exoyme provlima stis sygkriseis 
		}else
			thesi=70;
		
		return true;
	}
}

// abstrac μέθοδοι

abstract public double getTrexon_poso();
abstract public void setTrexon_poso(double x);
abstract public int getArithmos_listiwn();
abstract public void IncTrexonPoso(double poso_listias);
abstract public void IncArithmosListeiwn();
abstract public void Midenismos_Trexon_Poso();
abstract public void Midenismos_Arithmos_listion();
abstract public void PerasmaFavela();
abstract public void DromakiMiosi();


}
