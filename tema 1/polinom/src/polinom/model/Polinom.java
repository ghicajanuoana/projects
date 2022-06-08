package polinom.model;
import java.util.*; 
public class Polinom {
	String[] stringMonom;
	ArrayList<Monom> polinom = new ArrayList<Monom>();
	int p1;
	public Polinom(String[] m) {
		this.stringMonom = m;
		for(int i=0; i<m.length; i++) {
			System.out.println(m[i]);
			polinom.add(new Monom(m[i]));
		}
		for (int i = 0; i < polinom.size(); i++) {
		    Monom m1 = polinom.get(i);
		    m1.show();
		}
	}
	
	private Polinom(int p1) {
		this.p1 = p1;
	}
	
	public String afisarePolinom() {
		String polinomafisat = new String("");
		for(int i=0;i<polinom.size();i++) {
			if(polinom.get(i).coeficient < 0) {
				polinomafisat += polinom.get(i).getMonom();
			} else {
				polinomafisat += (0 == i) ? polinom.get(i).getMonom() : "+" + polinom.get(i).getMonom();		
			}
		}
		return polinomafisat;
	}

	public int getGrad() {
		int grad=-1; 
		for(int i=0;i<polinom.size();i++) {
			if(grad < polinom.get(i).getGradMonom()) 
				grad = polinom.get(i).getGradMonom();
		}
		return grad;
	}

	public void deriv() {
		for(int i=0;i<this.polinom.size();i++) {
			this.polinom.get(i).derivareMonom();
		}
	}
	
	public void integ() {
		for(int i=0;i<this.polinom.size();i++) {
			this.polinom.get(i).integrareMonom();
		}
	}
	
	public Polinom addPolinom(Polinom p) {
		Polinom rezPolinom = new Polinom(p1);
		
		for(int i=0;i<this.polinom.size();i++) {
			int grad1 = this.polinom.get(i).getGradMonom();
			int coef1 = this.polinom.get(i).getCoeffMonom();
			
			int gradpol = p.comparaGradPol(grad1 );
			if(gradpol == -1) {
				rezPolinom.polinom.add(new Monom(coef1, grad1)); //pol1
			} else {
				
				int grad2 = p.polinom.get(gradpol).getGradMonom();
				int coef2 = p.polinom.get(gradpol).getCoeffMonom();
				rezPolinom.polinom.add(new Monom(coef1+coef2, grad2)); //pol1+pol2
				p.polinom.remove(gradpol);
			}
		}

		for(int j=0;j<p.polinom.size();j++) {
			int g2 = p.polinom.get(j).getGradMonom();
			int c2 = p.polinom.get(j).getCoeffMonom();
			rezPolinom.polinom.add(new Monom(c2, g2));
		}
		return rezPolinom;
	}
	
	public Polinom inmultestePol(Polinom poli2) {
		Polinom rezPol = new Polinom(p1);
		for(int i=0;i<this.polinom.size();i++) {
			Monom m1 = this.polinom.get(i);
			for(int j=0;j<poli2.polinom.size();j++) {
				Monom m2 = poli2.polinom.get(j);
				Monom rezMonom = m1.inmultireMonom(m2);
				rezPol.polinom.add(rezMonom);
			}
		}
	
		return rezPol;
	}
	
	public Polinom scadePolinom(Polinom poli2) {
		Polinom rezPol;
		for(int i=0;i<poli2.polinom.size();i++) {
			poli2.polinom.get(i).coeficient = poli2.polinom.get(i).coeficient*(-1);
		}
		rezPol = this.addPolinom(poli2);
		return rezPol;
	}
	
	private int comparaGradPol(int grad) {
		for(int i=0;i<polinom.size();i++) {
			Monom mon = polinom.get(i);
			if(grad == mon.getGradMonom()) 
				return i;
		}
		return -1;
	}
}
