/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author victor
 */
public class Metodo {
    //Métodos
    //Leer el fichero para extraer los datos
    public static List<String> cargarDatos() {
        List<String> lineas=new ArrayList<>();
        try {
            lineas = Files.readAllLines(Paths.get("personas.csv"),
                    StandardCharsets.UTF_8);
        } catch (IOException ex) {
            System.out.println("Error leyendo el fichero");
        }
        lineas.remove(0);
        return lineas;
    }
    
    public static List<Persona> generarListaPersona(){
        List<String> lista = cargarDatos();
        List<Persona> listaPersona=new ArrayList<>();

        
        //Bucle para recorrer los datos y convertislos en lista de personas
        for(int i=0;i<lista.size()-1;i++){
           String datos[]=lista.get(i).split(",");
                //Formateamos la fecha de String a fecha
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                LocalDate fecha = LocalDate.parse(datos[5], formatter);
     
           Persona temporal = new Persona(datos[0], datos[1], datos[2], datos[3], datos[4], fecha, Boolean.parseBoolean(datos[6]), datos[7]);
           listaPersona.add(temporal);
        }
        
        return listaPersona;
    
    }
}
