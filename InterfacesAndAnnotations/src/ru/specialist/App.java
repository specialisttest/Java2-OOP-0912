package ru.specialist;

import java.lang.annotation.Annotation;
import java.util.Arrays;

import ru.specialist.graph.*;

public class App {
	
	public static void main(String[] args) {
		var scene = new Scene();
		
		scene.add(new Point(10, 20, "green"));
		scene.add(new Circle(100, 200, 50, "pink"));
		
		// new Shape().draw(); // ???
		Scaleable.scaleScene(scene);
		
		scene.draw();
		
		scene.scale(1.5);
		scene.draw();
		
		Course[] courses = {
				new Course("Java 1. Intro", 40),
				new Course("Java 2. OOP", 40),
				new Course("Java 3. Client Server", 40),
				new Course("GIT Intro", 16),
				new Course("OOP Pattern", 24),
				new Course("C language", 48)
		};
		
		Arrays.sort(courses);
		
		for(Course c : courses)
			System.out.println(c);
		
		// scene
		System.out.println("Scene annotations:");
		Class descriptor = scene.getClass(); // Scene.class
		Annotation[] anns =  descriptor.getAnnotations();
		for(Annotation an : anns) {
			System.out.printf("Annotation type: %s\n", an.annotationType().getName());
			if (an instanceof Developer d)
				System.out.printf("\t%s : %s\n", d.name(), d.date());
		}
		
	}

}
