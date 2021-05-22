package springhw.scanbeans;

import java.util.Scanner;
import java.util.ArrayList;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("ra")
@Scope("singleton")
public class Raspisanie{
	private int n = 2;																	// Минимальное число факультативных задач для студента
	private int size = 0;																// Вспомогательная переменная
	private String id = "";																// Строка куда будут записываться id задачи, которые выбрал студент
	private static String[] real_id;													// Вспомогательная переменная
	private int j = 0;


	public Raspisanie() {}
	

	public void facultativeRaspisanie(Facultative facultative,Obligatory obligatory) {
		//------------Выводит на экран список факультативных дисциплин и их задач--------------------------
				System.out.println("Здравствуйте. Спешим сообщить Вам новость, что с этого года каждый студент должен выполнять не менее " + n + " дополнительные занятий по факультативным дисциплинам!\nВот список доступных факультативов:");
				for (int i = 0; i < facultative.getKolvoObjects(); i++) {
					System.out.println("****" + facultative.getNameDiscipline()[i]);
					calculateSize(facultative.getKolvoDiscipline()[i]);
					System.out.println("К задачам данного факультатива относят:");
					while (j < size) {
						System.out.println(facultative.getId()[j] + " --- " + facultative.getName()[j]+ " " + facultative.getInfo()[j]);
						j++;
					}

				}
				choice();					// Запускает метод выбора факультативной задачи
				processChoice(facultative,obligatory);			// Запускает метод анализа 
	}
	

	private void choice() {
		//------------Запрашивает ввод не менее n числа задач из списка факультативных задач
				Scanner sc = new Scanner(System.in);
				System.out.println("Введите индекс (-ы) задач которые вам понравились (в строку через пробел):");
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
			

	private void processChoice(Facultative facultative,Obligatory obligatory) {
//------------Анализирует выбранные задачи и запускает метод корректировки расписания
		ArrayList<Thread> thread_list = new ArrayList<>();
		for (int i = 0; i < real_id.length; i++) {
			for (int j = 0; j < facultative.getKolvoId(); j++) {
				if (real_id[i].equals(facultative.getId()[j])) {
					thread_list.add(new Thread(new RaspisanieThread(facultative.getKolvoLab()[j],facultative.getKolvoPract()[j],facultative.getObject()[j],obligatory)));
					}
				}
			}
		for (Thread thread : thread_list) {
			thread.start();
		}
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {}
		
		for (Thread thread : thread_list) {
			thread.interrupt();
		}
	}
	
//	public void recalculation(int colvo_lab,int colvo_pract,String name,Obligatory obligatory) {
//		for (int i = 0; i < obligatory.getName().length; i++) {
//			if (obligatory.getName()[i].equals(name)) {
//				obligatory.setKolvoLab(i,colvo_lab);
//				obligatory.setKolvoPract(i,colvo_pract);				
//			}
//		}
//	}
	
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
