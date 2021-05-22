package springhw.scanbeans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component("ob")
@Scope("singleton")
@PropertySource("topicpart.properties")
public class Obligatory{	
	private String[] name;
	private String[] lab_topic;
	private String[] pract_topic;
	int[] kolvo_lab = new int[]{4,4};
	int[] kolvo_pract = new int[]{5,4};

	public String[] getName() {
		return name;
	}
	public String[] getLab_topic() {
		return lab_topic;
	}
	
	public int[] getKolvo_lab() {
		return kolvo_lab;
	}
	
	public int[] getKolvo_pract() {
		return kolvo_pract;
	}
	
	public String[] getPract_topic() {
		return pract_topic;
	}
	
	@Value("#{'${obligatory.lab_topic}'.split(',')}")
//	@Value("${tp.pract_topic}")
	public void setLabTopic(String[] lab_topic) {
		this.lab_topic = lab_topic;
	}
	
	@Value("#{'${obligatory.pract_topic}'.split(',')}")
	public void setPractTopic(String[] pract_topic) {
		this.pract_topic = pract_topic;

	}
	
	@Value("#{'${obligatory.name}'.split(',')}")
//	@Value("${obligatory.name}")
	public void setName(String[] name) {
		this.name = name;
	}

	public void setKolvoLab(int i, int kolvo_lab) {
		this.kolvo_lab[i] = this.kolvo_lab[i] - kolvo_lab;
	}
	
	public void setKolvoPract(int i, int kolvo_pract) {
		this.kolvo_pract[i] = this.kolvo_pract[i] - kolvo_pract;
	}
	
	public void printer() {
		int g = 0;
		int h = 0; 
		for (int i = 0; i < name.length; i++) {
			System.out.println("   ѕо предмету " + name[i] + " у вас запланировано:\n** " + kolvo_lab[i] + " лабораторных работ:");
			for (int j = 0; j < kolvo_lab[i]; j++) {
				System.out.println(lab_topic[g]);
				g++;
			}
			System.out.println("\n** " + kolvo_pract[i] + " практических работ:");
			for (int j = 0; j < kolvo_pract[i]; j++) {
				System.out.println(pract_topic[h]);
				h++;
			}
		}
		
	}
	
}
