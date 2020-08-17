package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.puntaje.*;


public class Jugador {

    private PuntajeSwitcher puntaje;
    private String nombre;
    private Multiplicador multiplicadorX2;
    private Multiplicador multiplicadorX3;
    private int cantExclusividad;

    public Jugador(String nombre){
        this();
        this.nombre = nombre;
        /*
        this.puntaje = new PuntajeSwitcher();
        this.multiplicadorX2 = new Multiplicador(2);
        this.multiplicadorX3 = new Multiplicador(3);
        this.cantExclusividad = 2;
         */
    }

    public Jugador(){
        //this.nombre = nombre;
        this.puntaje = new PuntajeSwitcher();
        this.multiplicadorX2 = new Multiplicador(2);
        this.multiplicadorX3 = new Multiplicador(3);
        this.cantExclusividad = 2;
    }

    public Puntaje puntaje(){
        return puntaje;
    }

    public void usarMultiplicadorX2(Pregunta pregunta) {
        if (pregunta.tienePenalidad()) {
            puntaje.setMultiplicador(multiplicadorX2);
        }
    }

    public void usarMultiplicadorX3(Pregunta pregunta){
        if (pregunta.tienePenalidad()) {
            puntaje.setMultiplicador(multiplicadorX3);
        }
    }

    public boolean tieneMultiplicadorx2(){
        return !multiplicadorX2.seUtilizo();

    }

    public boolean tieneMultiplicadorx3(){
        return !multiplicadorX3.seUtilizo();
    }

    public String verNombre(){
        return this.nombre;
    }

    public boolean activarExclusividad(){
        if(cantExclusividad > 0){
            cantExclusividad -= 1;
            return true;
        }
        return false;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

}