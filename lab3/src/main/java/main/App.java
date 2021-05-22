package main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import springhw.scanbeans.Raspisanie;
import springhw.scanbeans.Facultative;
import springhw.scanbeans.Obligatory;

public class App {

	public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("appAutoscanContext.xml");
        
        System.out.println("Обязательное расписание для Вас:");
        Obligatory obligatory = ctx.getBean("ob",Obligatory.class);
        obligatory.printer();
        Facultative facultative = ctx.getBean("fa",Facultative.class);
        Raspisanie araspisanie = ctx.getBean("ra",Raspisanie.class);
        araspisanie.facultativeRaspisanie(facultative,obligatory);
        System.out.println("Окончательное расписание для Вас:");
        obligatory.printer();
        araspisanie.printFacultative(facultative);
        ctx.close();
	}

}
