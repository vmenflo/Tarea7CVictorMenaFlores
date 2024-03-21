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
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

/**
 *
 * @author victor
 */
public class Metodo {

    //Métodos
    //Leer el fichero para extraer los datos
    public static List<String> extraerDatos() {
        List<String> lineas = new ArrayList<>();
        try {
            lineas = Files.readAllLines(Paths.get("personas.csv"),
                    StandardCharsets.UTF_8);
        } catch (IOException ex) {
            System.out.println("Error leyendo el fichero");
        }
        lineas.remove(0);
        return lineas;
    }

    //Método para almacenar las Personas en la listaPersonas
    public static List<Persona> generarListaPersona() {
        //En esta lista almacenamos los datos del fichero
        List<String> lista = extraerDatos();
        //En esta lista almacenamos las personas
        List<Persona> listaPersona = new ArrayList<>();
        //Bucle para recorrer los datos y convertislos en Personas
        // y almacenarlso en la lista de personas
        for (int i = 0; i < lista.size() - 1; i++) {
            String datos[] = lista.get(i).split(",");
            //Formateamos la fecha de String a fecha
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate fecha = LocalDate.parse(datos[5], formatter);
            //Creamos una variable temporal de Persona para almacenarla
            Persona temporal = new Persona(datos[0], datos[1], datos[2], datos[3], datos[4], fecha, Boolean.parseBoolean(datos[6]), datos[7]);
            listaPersona.add(temporal);
        }
        return listaPersona;
    }
    
    //Método para almacenar los géneros en un conjunto
    public static Set<String> conjuntoGeneros(List<Persona> lista){
        Set<String> conjuntoGeneros = new HashSet();
        for(int i=0;i<lista.size();i++){
            conjuntoGeneros.add(lista.get(i).genero());
        }
       return conjuntoGeneros;
    }
    //Método para gener un fichero a raiz del conjunto
    public static void generarFicheroGeneros(Set<String> lista){
        // Almacenamos los datos del set en una array
        String[] generos=lista.toArray(new String[lista.size()-1]);
        // Bucle para crear el archivo
        for (int i = 0; i < generos.length; i++) {
            try {
                Files.write(Paths.get("generos.txt"), (generos[i] + "\n").getBytes(StandardCharsets.UTF_8),
                        StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            } catch (IOException ex) {
                System.out.println("Error creando el fichero");
            }
        }
    }
    // Método para generar un map con el número de personas de cada género
    public static Map<String,Integer> generarMapContador(List<Persona> lista){
        Map<String,Integer> listado = new HashMap();
        for(int i=0;i<lista.size();i++){
            if(listado.containsKey(lista.get(i).genero())){
                listado.replace(lista.get(i).genero(),listado.get(lista.get(i).genero())+1);
            }else{
                listado.put(lista.get(i).genero(), 1);
            }
            
        }
        return listado;
    }
    
    //Método para crear fichero con el numero de generos
    public static void generarFicheroContador(Map<String,Integer> lista){
        List<String> generos = new ArrayList<>();
        
        // Almacenamos los datos del map en una array
        lista.forEach((clave,valor)-> generos.add(clave+","+valor));
        // Bucle para crear el archivo
        for (int i = 0; i < generos.size(); i++) {
            try {
                Files.write(Paths.get("contadorGeneros.csv"), (generos.get(i) + "\n").getBytes(StandardCharsets.UTF_8),
                        StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            } catch (IOException ex) {
                System.out.println("Error creando el fichero");
            }
        }
    }
}
