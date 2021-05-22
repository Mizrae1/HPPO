package springhw.scanbeans;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("ra")
@Scope("singleton")
public class Raspisanie{
	private int n = 2;																	// ����������� ����� �������������� ����� ��� ��������
	private int size = 0;																// ��������������� ����������
	private String id = "";																// ������ ���� ����� ������������ id ������, ������� ������ �������
	private String[] real_id;															// ��������������� ����������
	private int j = 0;


	public Raspisanie() {}
	
//	@Autowired
	public void facultativeRaspisanie(Facultative facultative,Obligatory obligatory) {
		//------------������� �� ����� ������ �������������� ��������� � �� �����--------------------------
				System.out.println("������������. ������ �������� ��� �������, ��� � ����� ���� ������ ������� ������ ��������� �� ����� " + n + " �������������� ������� �� �������������� �����������!\n��� ������ ��������� �������������:");
				for (int i = 0; i < facultative.getKolvoObjects(); i++) {
					System.out.println("****" + facultative.getNameDiscipline()[i]);
					calculateSize(facultative.getKolvoDiscipline()[i]);
					System.out.println("� ������� ������� ������������ �������:");
					while (j < size) {
						System.out.println(facultative.getId()[j] + " --- " + facultative.getName()[j]+ " " + facultative.getInfo()[j]);
						j++;
					}

				}
				choice();					// ��������� ����� ������ �������������� ������
				processChoice(facultative,obligatory);			// ��������� ����� ������� 
	}
	
//	@Autowired
	private void choice() {
		//------------����������� ���� �� ����� n ����� ����� �� ������ �������������� �����
				Scanner sc = new Scanner(System.in);
				System.out.println("������� ������ (-�) ����� ������� ��� ����������� (� ������ ����� ������):");
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
			
//	@Autowired
	private void processChoice(Facultative facultative,Obligatory obligatory) {
//------------����������� ��������� ������ � ��������� ����� ������������� ����������
		for (int i = 0; i < real_id.length; i++) {
			for (int j = 0; j < facultative.getKolvoId(); j++) {
				if (real_id[i].equals(facultative.getId()[j])) {
					recalculation(facultative.getKolvoLab()[j],facultative.getKolvoPract()[j],facultative.getObject()[j],obligatory);
				}
			}
		}
	}
	
	public void recalculation(int colvo_lab,int colvo_pract,String name,Obligatory obligatory) {
		for (int i = 0; i < obligatory.getName().length; i++) {
			if (obligatory.getName()[i].equals(name)) {
				obligatory.setKolvoLab(i,colvo_lab);
				obligatory.setKolvoPract(i,colvo_pract);				
			}
		}
	}
	
	private void calculateSize(int a) {this.size += a;}
	
	public void printFacultative(Facultative facultative) {
		for (int i = 0; i < real_id.length; i++) {
			for (int j = 0; j < facultative.getKolvoId(); j++) {
				if (real_id[i].equals(facultative.getId()[j])) {
					System.out.println("** " + facultative.getName()[j]);
				}
			}
		}
	}

}