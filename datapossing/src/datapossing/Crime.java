package datapossing;

public class Crime {
      private String classfication;
      private int salin;
      private int gangdo;
      private int ganggan;
      private int juldo;
      private int pokhang;
	public String getClassfication() {
		return classfication;
	}
	public void setClassfication(String classfication) {
		this.classfication = classfication;
	}
	public int getSalin() {
		return salin;
	}
	public void setSalin(int salin) {
		this.salin = salin;
	}
	public int getGangdo() {
		return gangdo;
	}
	public void setGangdo(int gangdo) {
		this.gangdo = gangdo;
	}
	public int getGanggan() {
		return ganggan;
	}
	public void setGanggan(int ganggan) {
		this.ganggan = ganggan;
	}
	public int getJuldo() {
		return juldo;
	}
	public void setJuldo(int juldo) {
		this.juldo = juldo;
	}
	public int getPokhang() {
		return pokhang;
	}
	public void setPokhang(int pokhang) {
		this.pokhang = pokhang;
	}
	@Override
	public String toString() {
		return "Crime [classfication=" + classfication + ", salin=" + salin + ", gangdo=" + gangdo + ", ganggan="
				+ ganggan + ", juldo=" + juldo + ", pokhang=" + pokhang + "]";
	}
      
}
