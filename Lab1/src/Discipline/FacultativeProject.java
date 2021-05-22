package Discipline;

import WorkWithRaspisaniem.Tasks;
//import Tasks.LabWorks;
//import Tasks.PractWorks;

public class FacultativeProject extends Facultative{
	private String info;
	private String name;
	private String id; 
	private String object; 
	private int count_tasks;
	private Tasks labWorks;
	private Tasks practWorks;
	
	public FacultativeProject() { }
	
	
	public FacultativeProject(String info, String name, String id, String object,int kolvo_lab,int kolvo_pract) {
		this.labWorks = new Tasks(kolvo_lab);
		this.practWorks = new Tasks(kolvo_pract);
		this.info = info;
		this.name = name;
		this.id = id;
		this.object = object;
	}
	
	public String getName() {return name;}
	
	public String getInfo() {return info;}
	
	public String getId() {return id;}
	
	public String getObject() {return object;}
	
	public int getCountTasks() {return count_tasks;}
		
	@Override
	public int getLabWorks() {return labWorks.getColichestvo();}
	
	@Override
	public int getPractWorks() {return practWorks.getColichestvo();}
	
}
