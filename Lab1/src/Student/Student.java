package Student;

import java.util.Scanner;


public class Student {
	private String name = "Student";
	private String group;
	private String id;
	

	public Student(String name, String group, String id) {
		this.setName(name);
		this.group = group;
		this.id = id;
	}

	public Student() {}
	
	public void initialization() {
		Scanner sc = new Scanner(System.in);
		System.out.print("¬ведите им€:");
		name = sc.nextLine();
		System.out.print("¬ведите название группы:");
		group = sc.nextLine();
		System.out.print("¬ведите номер студенческого билета :");
		id = sc.nextLine();
	}
	
	public String getName() {return name;}

	public void setName(String name) {this.name = name;}
	
	public String getGroup() {return group;}
	
}
