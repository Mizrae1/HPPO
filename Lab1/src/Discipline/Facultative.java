package Discipline;

public class Facultative extends Discipline {
	private String name;
	private String info;
	private String id;
	private String object;
	private int count_tasks = 0;
	
	public Facultative() {}
	
	public Facultative(String name, int count_tasks) {
		this.name = name;
		this.count_tasks = count_tasks;
	}
	
	public String getName() {return name;}
	
	public String getInfo() {return info;}
	
	public String getId() {return id;}
	
	public String getObject() {return object;}
	
	public int getCountTasks() {return count_tasks;}
	
	public int getLabWorks() {return 0;}
	
	public int getPractWorks() {return 0;}
}
