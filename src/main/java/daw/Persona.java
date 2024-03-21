/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package daw;

import java.time.LocalDate;

/**
 *
 * @author victor
 */
public record Persona(String id,String nombre,String apellido, String email, String genero, LocalDate fecha_nacimiento, boolean jubilado, String ciudad) {

}
