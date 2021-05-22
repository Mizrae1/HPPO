package Discipline;

public class Obligatory extends Discipline {
	private String name;
	private String[] lab_topic;
	private String[] pract_topic;
	
	public Obligatory(String name,String[] lap_topic,String[] pract_topic) {
		this.name = name;
		this.lab_topic = lap_topic;
		this.pract_topic = pract_topic;
	}

	public String getName() {return name;}
	
	public String[] getLabTopic() {return lab_topic;}
	
	public String[] getPractTopic() {return pract_topic;}
	
	private void printTopic(String[] topic, int n) {
		for (int i = 0; i < n; i++) {
			System.out.println(topic[i]);
		}
	}
	
	public void printPredmet(int n, int m) {
		System.out.println("   ѕо предмету " + name + " у вас запланировано:\n** " + n + " лабораторных работ:");
		printTopic(lab_topic, n);
		System.out.println("** " + m + " практических работ:");
		printTopic(pract_topic, m);
	}
}
