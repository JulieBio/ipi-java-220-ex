package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "Coucou";
		String s2 = "Coucou";
		String s3 = new String("Coucou");
		
		if(s == s2) {
			System.out.println("Références s et s2 égales");
		}
		if(s3 == s2) {
			System.out.println("Références s3 et s2 égales");
		}
		else {
			System.out.println("Références s3 et s2 différentes");
		}
		if(s.equals(s2)) {
			System.out.println("Contenu s et s2 sont égaux");
		}
		
		Integer i = 127;
		Integer i2 = 127;
		
		if(i == i2) {
			System.out.println("Références i et i2 égales");
		}
		Integer i3 = 128;
		Integer i4 = 128;
		
		if(i3 == i4) {
			System.out.println("Références i3 et i4 égales");
		}

		Entreprise ent = new Entreprise();


		
		System.out.println(Entreprise.SALAIRE_BASE);


	}

}
