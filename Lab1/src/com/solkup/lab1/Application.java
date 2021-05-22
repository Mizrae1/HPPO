package com.solkup.lab1;


import java.util.ArrayList;
import Discipline.Facultative;
import Discipline.Obligatory;
import Discipline.FacultativeProject;
import Student.Student;
import WorkWithRaspisaniem.AdjustmentRaspisanie;
import WorkWithRaspisaniem.Raspisanie;

public class Application {
	
	public static void main(String[] args) {
//------------������� ������ ������� -------------------------------------
		Student accountStudent = new Student();
		
		
//------------������� ������ �������������� ���������---------------------		
		ArrayList<Facultative> list_facultatives = new ArrayList<Facultative>();
		Facultative robotics = new Facultative("������������� - ���������� �����, ������������ ����������� ������������������ ����������� ������.",2);
		Facultative ads = new Facultative("��������� � ��������� ������.",2);
		list_facultatives.add(robotics);
		list_facultatives.add(ads);

//------------������� ������ �������������� �����-------------------------
		ArrayList<Facultative> tasks_facultatives = new ArrayList<Facultative>();
		FacultativeProject roboticsProject1 = new FacultativeProject(" ��� �������� ������� ������ ������ ��� ������ ���� ������������ �� �������� �������� ��������.", "�������� ������ � �������������� ��� � �������� �������.","r486vy","�������� ��������",1,0);
		FacultativeProject roboticsProject2 = new FacultativeProject(" ��� �������� ������� ������ ������ ��� ������ ���� ������������ ������ �� �������� ����.","����������� � ������������ �� ������� ������ �-�������.","r846cu","����",0,1);
		FacultativeProject adsProject1= new FacultativeProject(" ��� �������� ������� ������ ������ ��� ������ ���� ������������ �� �������� ����.","������ ������, ������������ �������������","a312bg","����",1,0);
		FacultativeProject adsProject2= new FacultativeProject(" ��� �������� ������� ������ ������ ��� ������ ���� ������������ ������ �� �������� ���������� ��������.","������ � OpenCV.","a764ih","�������� ��������",0,1);
		tasks_facultatives.add(roboticsProject1);
		tasks_facultatives.add(roboticsProject2);
		tasks_facultatives.add(adsProject1);
		tasks_facultatives.add(adsProject2);
		
//------------������� ������ ������������ ���������----------------------
		ArrayList<Obligatory> list_obligatory= new ArrayList<Obligatory>();
		String[] lab_topic = new String[] {"1)���������� ����� ���������� ������������ ���� �� ������ �������� �������������� GoF","2)Spring Framework","3)���������� ������������� ���������� � ������� Concurrency","4)���������� �����-��������������� ���������� � java akka"};
		String[] pract_topic = new String[] {"1) �������� ������� ��������������","2) ����������� ������� ��������������","3) ����������� ������� ��������������","4) ������������� ������� ��������������","5) ������������� ������� ��������������"};
		Obligatory hppo = new Obligatory("����",lab_topic,pract_topic);
		lab_topic = new String[] {"1) ������ ������ � ������� Pandas","2) �������� ���������","3) ������� �������","4) ����� ���������� ����"};
		pract_topic = new String[] {"1) ������� �������� ����� �������������","2) ������������� ������. ����� ���������","3) ������� ������ � �������� ��������","4) ��������� �������������"};
		Obligatory machineLearning = new Obligatory("�������� ��������",lab_topic,pract_topic);
		list_obligatory.add(hppo);
		list_obligatory.add(machineLearning);
		
//------------������� ������ ������������� ����������--------------------
		Raspisanie raspisanie= new Raspisanie(list_obligatory);
		
//------------������� ������ ��������������� ����������------------------
		AdjustmentRaspisanie facultative = new AdjustmentRaspisanie(list_facultatives, tasks_facultatives,raspisanie);
		
		
/////////////////////////////////////////////////////////////////////////////////////////////////////////		
		accountStudent.initialization();                                   // �������������� ��������
		System.out.println("������������ ���������� ��� ���:");
		raspisanie.printObligatoryRaspisanie();                            // ������� ������������ ����������
		facultative.facultativeRaspisanie();                               // ������� ������ �������������, ���������� ������� ������ � ������������ ����������             
		System.out.println();
		System.out.println("������������� ���������� ��� ���:");
		raspisanie.printObligatoryRaspisanie();                            // ������ ������������� ����������
		facultative.printFacultative();
	}

}
