package WorkWithRaspisaniem;

import java.util.ArrayList;
import java.util.Scanner;

import Discipline.Facultative;

public class AdjustmentRaspisanie{
	private ArrayList<Facultative> facultatives = new ArrayList<Facultative>();       	// Список факультативных дисциплин
	private ArrayList<Facultative> tasts_facultatives = new ArrayList<Facultative>(); 	// Список задач по факультативным дисциплинам
	private Raspisanie raspisanie;														// Обязательное расписание
	private int n = 2;																	// Минимальное число факультативных задач для студента
	private int size = 0;																// Вспомогательная переменная
	private String id = "";																// Строка куда будут записываться id задачи, которые выбрал студент
	private String[] real_id;															// Вспомогательная переменная
	private int j = 0;																	// Вспомогательная переменная
	
	public AdjustmentRaspisanie() {}
	
	public AdjustmentRaspisanie(ArrayList<Facultative> facultatives,ArrayList<Facultative> tasts_facultatives,Raspisanie raspisanie1) {
		this.facultatives = facultatives;
		this.tasts_facultatives = tasts_facultatives;
		this.raspisanie = raspisanie1;
	}
	
	public void facultativeRaspisanie() {
//------------Выводит на экран список факультативных дисциплин и их задач--------------------------
		System.out.println("Здравствуйте. Спешим сообщить Вам новость, что с этого года каждый студент должен выполнять не менее " + n + " дополнительные занятий по факультативным дисциплинам!\nВот список доступных факультативов:");
		for (int i = 0; i < facultatives.size(); i++) {
			System.out.println("****" + facultatives.get(i).getName());
			calculateSize(facultatives.get(i).getCountTasks());
			System.out.println("К задачам данного факультатива относят:");
			for ( int j ; this.j < size ; this.j++) {
				System.out.println(tasts_facultatives.get(this.j).getId() + " --- " + tasts_facultatives.get(this.j).getName() + tasts_facultatives.get(this.j).getInfo());
			}
		}

		choice();					// Запускает метод выбора факультативной задачи
		processChoice();			// Запускает метод анализа 
	}
	
	private void choice() {
//------------Запрашивает ввод не менее n числа задач из списка факультативных задач
		Scanner sc = new Scanner(System.in);
		System.out.println("Введите индекс (-ы) задач которые вам понрвились (в строку через пробел):");
		while ("".equals(id) == true) {
			id = sc.nextLine();	
		}
		
		real_id = id.split("\\s");
				
		if (real_id.length < n) {
			System.out.println("Вы выбрали меньше " + n + " факультативов. Попробуйте снова.");
			id = "";
			choice();
		}
	}
	
	
	private void processChoice() {
//------------Анализирует выбранные задачи и запускает метод корректировки расписания
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
