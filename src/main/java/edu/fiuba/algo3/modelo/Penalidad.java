package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Penalidad extends TipoPenalidad {
    int modificadorCorrecto;
    int modificadorIncorrecto;
    public Penalidad(){
        modificadorCorrecto = 1;
        modificadorIncorrecto = -1;
    }
    @Override
    public void calcularpuntaje(Respuesta respuesta, ArrayList<Integer> correctas){
        int puntos = 0;
        for (int i : respuesta.verRespuestaJugador()) {
            if (correctas.contains(i)) {
                puntos += modificadorCorrecto;
            } else {
                puntos += modificadorIncorrecto;
            }
        }
        respuesta.modificarpuntaje(puntos);
    }
}
