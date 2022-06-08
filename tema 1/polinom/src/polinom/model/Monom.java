package polinom.model;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Monom {
	
	public int grad;
	public int coeficient;
	public double coefDouble;
	
	public String monom;

	public Monom(String monom) {
		if(regex(monom))  {
			this.monom = monom;
		}
		coefDouble = (double)coeficient;
	}
	
	public Monom(int coeficient, int grad) {
		this.grad = grad;
		this.coeficient = coeficient;
		coefDouble = coeficient;
		
	}
	
	public Monom(double doublecoef, int coeficient, int grad) {
		this.grad = grad;
		this.coeficient = coeficient;
		this.coefDouble = doublecoef;
	}

	public void derivareMonom() {
		if (grad != 0) {
			coefDouble = coefDouble * grad;
			coeficient = (int) coefDouble;
			grad--;
		}
	}
	
	public void integrareMonom() {
		grad++;
		coefDouble = coefDouble / grad;
		coeficient = (int)coefDouble;
	}
	
	public boolean isNegative() {
		return (this.coeficient < 0) ? true : false;
	}
	
	public String getMonom() {
		return (grad == 0) ? Double.toString(coefDouble) : (coefDouble + "x^" + grad);
	}
	
	public void show() {
		System.out.println("Grad: " + grad + " Coeficient: " + coeficient + "\n");
	}
	
	public int getCoeffMonom() {
		return this.coeficient;
	}
	
	public int getGradMonom() {
		return this.grad;
	}

	public double getCoefDouble(double x) {
		return coefDouble * Math.pow(x, grad);
	}
	
	public void addCoef(int x) {
		this.coeficient += x;
		this.coefDouble = (double)coeficient;
	}
	
	public Monom inmultireMonom(Monom mon1) {
		Monom ret;
		double c = this.coefDouble * mon1.coefDouble;
		int d = (int)c;
		int p = this.getGradMonom() + mon1.getGradMonom();
		ret = new Monom(c,d,p);
		return ret;
	}
	
	
	public static Comparator<Monom> compareGrad() {   
		Comparator<Monom> comp = new Comparator<Monom>(){
		    @Override
		    public int compare(Monom s1, Monom s2) {
		    	return Integer.compare(s1.grad, s2.grad);
		    }        
		};
		return comp;
	}  
	
	private String[] string;
	private boolean regex(String monom) {
		if(!monom.matches("^[a-zA-Z0-9\\^\\*\\- ]*")) 
			return false;
		Pattern pattern = Pattern.compile("\\^");
		Matcher m = pattern.matcher(monom);
		String s = new String();
		while(m.find()) {
			s = m.group();
		}
		if(s.isEmpty()) {

			string = monom.split("[a-zA-Z]");
			if(string.length == 0) {
				coeficient = 1;
				grad = 1;
			} else {
				coeficient = (!string[0].isEmpty()) ? Integer.parseInt(string[0]) : 1;
				grad = (string[0] == monom) ? 0 : 1;
			}
		} else {
			string = monom.split("\\^"); 
			try {
				String str = new String();
				
				for(int i = 0; i < string[0].length(); i++){
			        char c = string[0].charAt(i);
			        if(c==45) str += c;
			        if(c > 47 && c < 58)str += c;
			    }
				coeficient = (str.isEmpty()) ? 1 : Integer.parseInt(str);
				grad = Integer.parseInt(string[1]);
			} catch(NumberFormatException e) {      
				System.out.println("Invalid");
			}
		} 
		return true;
	}
}
