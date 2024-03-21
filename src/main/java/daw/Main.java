/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author victor
 */
public class Main {
    public static void main(String[] args) {
        List<Persona> lista = Metodo.generarListaPersona();
        
        for (Persona persona : lista) {
            System.out.println(persona);
        }
    }
}
