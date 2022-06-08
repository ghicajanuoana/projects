package main.java.model;

public class Planta {
	 private String nume;
	 private String tip;
	 private String specie;
	 private String zona;

	    public Planta() {
	    }

	    public Planta(String nume, String tip, String specie, String zona) {
	        this.setNume(nume);
	        this.setSpecie(specie);
	        this.setZona(zona);
	        this.setTip(tip);
	    }

	    public Planta(Planta planta) {
	        new Planta(planta.getNume(), planta.getTip(), planta.getSpecie(), planta.getZona());
	    }

		public String getNume() {
			return nume;
		}

		public void setNume(String nume) {
			this.nume = nume;
		}

		public String getTip() {
			return tip;
		}

		public void setTip(String tip) {
			this.tip = tip;
		}

		public String getSpecie() {
			return specie;
		}

		public void setSpecie(String specie) {
			this.specie = specie;
		}

		public String getZona() {
			return zona;
		}

		public void setZona(String zona) {
			this.zona = zona;
		}
		
		public String[] toStringAn() {
	        return new String[]{nume, tip,specie,zona};
	    }

	    @Override
	    public String toString() {
	        return "Planta{" +
	                "nume='" + nume + '\'' +
	                ", tip='" + tip + '\'' +
	                ", specie='" + specie + '\'' +
	                ", zona='" + zona + '\'' +
	                '}';
	    }
}
