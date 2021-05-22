package WorkWithRaspisaniem;

import java.util.ArrayList;
import java.util.Scanner;

import Discipline.Facultative;

public class AdjustmentRaspisanie{
	private ArrayList<Facultative> facultatives = new ArrayList<Facultative>();       	// ������ �������������� ���������
	private ArrayList<Facultative> tasts_facultatives = new ArrayList<Facultative>(); 	// ������ ����� �� �������������� �����������
	private Raspisanie raspisanie;														// ������������ ����������
	private int n = 2;																	// ����������� ����� �������������� ����� ��� ��������
	private int size = 0;																// ��������������� ����������
	private String id = "";																// ������ ���� ����� ������������ id ������, ������� ������ �������
	private String[] real_id;															// ��������������� ����������
	private int j = 0;																	// ��������������� ����������
	
	public AdjustmentRaspisanie() {}
	
	public AdjustmentRaspisanie(ArrayList<Facultative> facultatives,ArrayList<Facultative> tasts_facultatives,Raspisanie raspisanie1) {
		this.facultatives = facultatives;
		this.tasts_facultatives = tasts_facultatives;
		this.raspisanie = raspisanie1;
	}
	
	public void facultativeRaspisanie() {
//------------������� �� ����� ������ �������������� ��������� � �� �����--------------------------
		System.out.println("������������. ������ �������� ��� �������, ��� � ����� ���� ������ ������� ������ ��������� �� ����� " + n + " �������������� ������� �� �������������� �����������!\n��� ������ ��������� �������������:");
		for (int i = 0; i < facultatives.size(); i++) {
			System.out.println("****" + facultatives.get(i).getName());
			calculateSize(facultatives.get(i).getCountTasks());
			System.out.println("� ������� ������� ������������ �������:");
			for ( int j ; this.j < size ; this.j++) {
				System.out.println(tasts_facultatives.get(this.j).getId() + " --- " + tasts_facultatives.get(this.j).getName() + tasts_facultatives.get(this.j).getInfo());
			}
		}

		choice();					// ��������� ����� ������ �������������� ������
		processChoice();			// ��������� ����� ������� 
	}
	
	private void choice() {
//------------����������� ���� �� ����� n ����� ����� �� ������ �������������� �����
		Scanner sc = new Scanner(System.in);
		System.out.println("������� ������ (-�) ����� ������� ��� ���������� (� ������ ����� ������):");
		while ("".equals(id) == true) {
			id = sc.nextLine();	
		}
		
		real_id = id.split("\\s");
				
		if (real_id.length < n) {
			System.out.println("�� ������� ������ " + n + " �������������. ���������� �����.");
			id = "";
			choice();
		}
	}
	
	
	private void processChoice() {
//------------����������� ��������� ������ � ��������� ����� ������������� ����������
		for (int i = 0; i < real_id.length; i++) {
			for (int j = 0; j < tasts_facultatives.size(); j++) {
				if (real_id[i].equals(tasts_facultatives.get(j).getId())) {
					raspisanie.recalculation(tasts_facultatives.get(j).getLabWorks(),tasts_facultatives.get(j).getPractWorks(),tasts_facultatives.get(j).getObject());
				}
			}
		}
	}
	
	public void printFacultative() {
		for (int i = 0; i < real_id.length; i++) {
			for (int j = 0; j < tasts_facultatives.size(); j++) {
				if (real_id[i].equals(tasts_facultatives.get(j).getId())) {
					System.out.println("** " + tasts_facultatives.get(j).getName());
				}
			}
		}
	}
	private void calculateSize(int a) {this.size += a;}
	
}
