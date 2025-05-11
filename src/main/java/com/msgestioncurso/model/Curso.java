package com.msgestioncurso.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class Curso {

    private String idCurso;
    private String nombreCurso;
    private String descCurso;
    private int cantParticipantes;


}
