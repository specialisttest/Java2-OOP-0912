package ru.specialist.mylib;

import java.util.Date;

public class LibClass {
	
	public void run () {
		Date dt = new Date();
		System.out.println(dt);
		
		var dbDate = new java.sql.Date(dt.getTime());
		System.out.println(dbDate);
	}

}
