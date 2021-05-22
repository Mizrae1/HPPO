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
//------------Создаем объект студент -------------------------------------
		Student accountStudent = new Student();
		
		
//------------Создаем список факультативных предметов---------------------		
		ArrayList<Facultative> list_facultatives = new ArrayList<Facultative>();
		Facultative robotics = new Facultative("Робототехника - прикладная наука, занимающаяся разработкой автоматизированных технических систем.",2);
		Facultative ads = new Facultative("Алгоритмы и структуры данных.",2);
		list_facultatives.add(robotics);
		list_facultatives.add(ads);

//------------Создаем список факультативных задач-------------------------
		ArrayList<Facultative> tasks_facultatives = new ArrayList<Facultative>();
		FacultativeProject roboticsProject1 = new FacultativeProject(" При успешном решении данной задачи Вам зачтут одну лабораторную по предмету Машинное обучение.", "Машинное зрение и распрознавание лиц в реальном времени.","r486vy","Машинное обучение",1,0);
		FacultativeProject roboticsProject2 = new FacultativeProject(" При успешном решении данной задачи Вам зачтут одну практическую работу по предмету ШППО.","Оптимизация и переобучение на примере мктода К-соседей.","r846cu","ШППО",0,1);
		FacultativeProject adsProject1= new FacultativeProject(" При успешном решении данной задачи Вам зачтут одну лабораторную по предмету ШППО.","Анализ данных, визуализация классификация","a312bg","ШППО",1,0);
		FacultativeProject adsProject2= new FacultativeProject(" При успешном решении данной задачи Вам зачтут одну практическую работу по предмету Машинномое обучение.","Работа с OpenCV.","a764ih","Машинное обучение",0,1);
		tasks_facultatives.add(roboticsProject1);
		tasks_facultatives.add(roboticsProject2);
		tasks_facultatives.add(adsProject1);
		tasks_facultatives.add(adsProject2);
		
//------------Создаем список обязательных предметов----------------------
		ArrayList<Obligatory> list_obligatory= new ArrayList<Obligatory>();
		String[] lab_topic = new String[] {"1)Разработка слабо связанного программного кода на основе шаблонов проектирования GoF","2)Spring Framework","3)разработка многопоточных приложений с помощью Concurrency","4)Разработка актор-ориентированных приложений в java akka"};
		String[] pract_topic = new String[] {"1) Основные шаблоны проектирования","2) Порождающие шаблоны проектирования","3) Структурные шаблоны проектирования","4) Поведенческие шаблоны проектирования","5) Архитектурные шаблоны проектирования"};
		Obligatory hppo = new Obligatory("ШППО",lab_topic,pract_topic);
		lab_topic = new String[] {"1) Анализ данных с помошью Pandas","2) Линейная регрессия","3) Деревья решений","4) Метод случайного леса"};
		pract_topic = new String[] {"1) Метрики качества задач классификации","2) Предобработка данных. Отбор признаков","3) Функции ошибок в машинном обучении","4) Алгоритмы кластеризации"};
		Obligatory machineLearning = new Obligatory("Машинное обучение",lab_topic,pract_topic);
		list_obligatory.add(hppo);
		list_obligatory.add(machineLearning);
		
//------------Создаем объект обязательного расписания--------------------
		Raspisanie raspisanie= new Raspisanie(list_obligatory);
		
//------------Создаем объект факультативного расписания------------------
		AdjustmentRaspisanie facultative = new AdjustmentRaspisanie(list_facultatives, tasks_facultatives,raspisanie);
		
		
/////////////////////////////////////////////////////////////////////////////////////////////////////////		
		accountStudent.initialization();                                   // Инициализируем студента
		System.out.println("Обязательное расписание для Вас:");
		raspisanie.printObligatoryRaspisanie();                            // Выводим обязательное расписание
		facultative.facultativeRaspisanie();                               // Выводим список факультативов, предлагаем выбрать задачи и корректируем расписание             
		System.out.println();
		System.out.println("Окончательное расписание для Вас:");
		raspisanie.printObligatoryRaspisanie();                            // Выводи окончательное расписание
		facultative.printFacultative();
	}

}
