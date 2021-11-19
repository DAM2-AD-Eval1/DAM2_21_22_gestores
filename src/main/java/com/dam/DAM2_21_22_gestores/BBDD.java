package com.dam.DAM2_21_22_gestores;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.stream.Stream;

public class BBDD {
	
	static String driver, ruta, usuario, password;
	
	public static void obtenerResultados(String bd) throws IOException, ClassNotFoundException, SQLException {
		
		
		BufferedReader br = Files.newBufferedReader(Paths.get("D:\\PRUEBAS\\gestores.properties"));
		Stream<String> lineas = br.lines();
		lineas.forEach(l->{
			String[] lineaDividida = l.split("=");
			if (lineaDividida[0].equals("driver" + bd)) {
				driver = lineaDividida[1];
			}else if (lineaDividida[0].equals("ruta" + bd)) {
				ruta = lineaDividida[1];
			}else if (lineaDividida[0].equals("usuario" + bd)) {
				usuario = lineaDividida[1];
			}else if (lineaDividida[0].equals("password" + bd)) {
				password = lineaDividida[1];
			}	
		});	
		
		conexionBBDD(driver, ruta, usuario, password);
		
	}
	
	private static void conexionBBDD(String driver, String ruta, String usuario, String password) throws ClassNotFoundException, SQLException {
		
		Class.forName(driver);
		
		Connection conexion = DriverManager.getConnection(ruta, usuario, password);
		
		Statement sentencia = conexion.createStatement();
		ResultSet resultados = sentencia.executeQuery("SELECT * FROM videojuegos");
		
		while(resultados.next()) {
			System.out.println("Código: " + resultados.getInt(1) + " ;Título: " + resultados.getString(2) + 
																	" ;Estudio: " + resultados.getString(3));
		}
	}

}
