package WorkWithRaspisaniem;

import java.util.ArrayList;

import Discipline.Obligatory;


public class Raspisanie {
	private ArrayList<Tasks> list_lab_works= new ArrayList<Tasks>();
	private ArrayList<Tasks> list_pract_works= new ArrayList<Tasks>();
	private ArrayList<Obligatory> list_discipline= new ArrayList<Obligatory>();
	
	public Raspisanie() {createTasks();}
	
	public Raspisanie(ArrayList<Obligatory> arrayList) {
		this.list_discipline = arrayList;
		createTasks();
	}
	
	public void printObligatoryRaspisanie() {
		for (int i = 0; i < list_lab_works.size(); i++) {
			list_discipline.get(i).printPredmet(list_lab_works.get(i).getColichestvo(), list_pract_works.get(i).getColichestvo());
			System.out.println();
		}
	}

	private void createTasks() {
		for (int i = 0; i < list_discipline.size(); i++) {
			list_lab_works.add(new Tasks());
			list_pract_works.add(new Tasks());
		}
	}
	
	public void recalculation(int colvo_lab,int colvo_pract,String name) {
		for (int i = 0; i < list_discipline.size(); i++) {
			if (list_discipline.get(i).getName().equals(name)) {
				list_lab_works.get(i).setColichestvo(colvo_lab);
				list_pract_works.get(i).setColichestvo(colvo_pract);				
			}
		}
	}

}
