package com.altias.mic_autenticacion.usuario;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import jakarta.persistence.GenerationType;

@Entity
@Data

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido_paterno;
    private String apellido_materno;
    private String email;
    private LocalDate fecha_nacimiento;

    public String getNombre() {
        return nombre;
    }
    public String getEmail() {
        return email;
    }

}
