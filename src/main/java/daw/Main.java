/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author victor
 */
public class Main {
    public static void main(String[] args) {
        //En esta lista almacenamos las personas
        List<Persona> lista = Metodo.generarListaPersona();
        //Lo mostramos
        System.out.println("Mostramos lista de personas: ");
        for (Persona persona : lista) {
            System.out.println(persona);
        }
        
        //Creamos el Set con todos los generos
        System.out.println("Muestro el set");
        Set<String> conjuntoGeneros = Metodo.conjuntoGeneros(lista);
        for (Object c : conjuntoGeneros) {
            System.out.println(c);
        }
        
        //Generamos el fichero de generos
        Metodo.generarFicheroGeneros(conjuntoGeneros);
        
        //Generamos un map con los contadores
        Map<String,Integer> contadorGeneros = Metodo.generarMapContador(lista);
        
        //Lo enseñamos
        System.out.println("Muestro el map");
        contadorGeneros.forEach((clave, valor) -> System.out.println("Género: " + clave + " -- cantidad: " + valor));
        //Generamos el fichero
        Metodo.generarFicheroContador(contadorGeneros);
    }
}
