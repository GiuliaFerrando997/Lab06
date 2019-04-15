package it.polito.tdp.meteo.model;

import java.time.Month;

public class TestModel {

	public static void main(String[] args) {

		Model m = new Model();
		
		System.out.println(m.getUmiditaMedia(Month.of(12)));
		
		System.out.println(m.trovaSequenza(5));
		
//		System.out.println(m.trovaSequenza(4));
	}

}
