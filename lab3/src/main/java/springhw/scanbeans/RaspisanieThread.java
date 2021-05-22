package springhw.scanbeans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

public class RaspisanieThread implements Runnable{
	private int colvo_lab;
	private int colvo_pract;
	private String name;
	Obligatory obligatory = new Obligatory();
	
	
	public RaspisanieThread() {
		super();
	}
	
	public RaspisanieThread(int colvo_lab,int colvo_pract,String name,Obligatory obligatory) {
		super();
		this.colvo_lab = colvo_lab;
		this.colvo_pract = colvo_pract;
		this.name = name;
		this.obligatory = obligatory;
	}

	@Override
	public void run() {
		if (!Thread.currentThread().isInterrupted()) {
			for (int i = 0; i < obligatory.getName().length; i++) {
				if (obligatory.getName()[i].equals(name)) {
					obligatory.setKolvoLab(i,colvo_lab);
					obligatory.setKolvoPract(i,colvo_pract);
				}
			}
		}
	}
}