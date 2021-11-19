package com.dam.DAM2_21_22_gestores;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException {
		
		Scanner datoEntrada = new Scanner(System.in);
		int eleccion = -1;
		
		while(eleccion!=3) {
			
			System.out.println("1. MySQL");
			System.out.println("2. PostGreSQL");
			System.out.println("3. Salir");
			
			eleccion = datoEntrada.nextInt();
			
			switch (eleccion) {
			case 1: //MySQL
					BBDD.obtenerResultados("MySQL");
					break;
			case 2: //PostGreSQL
				    BBDD.obtenerResultados("Postgres");
				    break;
			case 3: //Salir
				    eleccion=3;
				    break;
			default: System.out.println("Elección no válida");
					 
				
			}
		}
		

	}

}
