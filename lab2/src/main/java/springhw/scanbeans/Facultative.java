package springhw.scanbeans;

import java.awt.List;
import java.lang.reflect.Array;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("fa") 
@Scope("singleton")
public class Facultative{
	private String[] info;
	private String[] name;
	private String[] id; 
	private String[] object;
	private String[] name_discipline;
	private int[] kolvo_lab = new int[]{ 1,0,1,0};
	private int[] kolvo_pract = new int[]{ 0,1,0,1};
	private int[] kolvo_discipline = new int[] {2,2};
	
	
	public int getKolvoObjects() {
		return name_discipline.length;
	}
	
	public String[] getName() {
		return name;
	}
	
	public int getKolvoId() {
		return id.length;
	}
	
	public String[] getId() {
		return id;
	}
	
	public String[] getInfo() {
		return info;
	}
	
	public String[] getObject() {
		return object;
	}
	
	public  int[] getKolvoLab() {
		return kolvo_lab;
	}
	
	public int[] getKolvoPract() {
		return kolvo_pract;
	}
	
	public String[] getNameDiscipline() {
		return name_discipline;
	}
	
	public int[] getKolvoDiscipline() {
		return kolvo_discipline;
	}
	
	
//	@Value("${facultative.name}")
	@Value("#{'${facultative.name}'.split(',')}")
	public void setName(String[] name) {
		this.name = name;
	}
	
	@Value("#{'${facultative.main.name}'.split(',')}")
	public void setNameDiscipline(String[] name_discipline) {
		this.name_discipline = name_discipline;
	}
		
	@Value("#{'${facultative.id}'.split(',')}")
//	@Value("${facultative.id}")
	public void setId(String[] id) {
		this.id = id;
	}
	
	@Value("#{'${facultative.info}'.split(',')}")
//	@Value("${facultative.info}")
	public void setInfo(String[] info) {
		this.info = info;
	}
	
	@Value("#{'${facultative.object}'.split(',')}")
//	@Value("${facultative.object}")
	public void setObject(String[] object) {
		this.object = object;
	}
	
//	@Value("${facultative.lab}")
//	public void setKolvoLab(ArrayList<Integer> kolvo_lab) {
//		this.kolvo_lab = kolvo_lab;
//	}
//	
//	@Value("${facultative.pract}")
//	public void setKolvoPract(ArrayList<Integer> kolvo_pract) {
//		this.kolvo_pract = kolvo_pract;
//	}

}
