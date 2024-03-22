/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author victor
 */
public class Escritura_Lectura {
    //METODOS LECTURA
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
    //MÉTODOS ESCRITURA
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
