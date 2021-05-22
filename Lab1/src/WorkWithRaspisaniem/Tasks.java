package WorkWithRaspisaniem;

public class Tasks {
	private int colichestvo;

	public Tasks() {this.colichestvo = 1 + (int) (Math.random() * 4);}
	
	public Tasks(int n) {this.colichestvo = n;}

	public int getColichestvo() {return colichestvo;}

	public void setColichestvo(int colicestvo) {this.colichestvo -= colicestvo;}
}
