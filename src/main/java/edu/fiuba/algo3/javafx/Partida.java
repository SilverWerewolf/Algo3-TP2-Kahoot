package edu.fiuba.algo3.javafx;
import edu.fiuba.algo3.javafx.controladores.ToggleSwitch;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Respuesta;
import edu.fiuba.algo3.modelo.Turno;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import edu.fiuba.algo3.modelo.opciones.OpcionOrdered;
import edu.fiuba.algo3.modelo.preguntas.GroupChoice;
import edu.fiuba.algo3.modelo.preguntas.OrderedChoice;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import java.util.ArrayList;

public class Partida {

    static final int JUGADOR1 = 0;
    static final int JUGADOR2 = 1;
    private Turno turnoActual;
    private Pregunta preguntaActual;
    private ArrayList<Opcion> opcionesJugador1 = new ArrayList<Opcion>();
    private ArrayList<Opcion> opcionesJugador2 = new ArrayList<Opcion>();
    private ArrayList<ToggleSwitch> respuestasJugadorGroup = new ArrayList<ToggleSwitch>();

    //private ArrayList<Jugador> jugadores;
    //private int indiceJugadorActual = 0;

    public Partida(ArrayList<Jugador> jugadores) {
        this.turnoActual = new Turno(jugadores);
    }


    /*
    public boolean seContestoPregunta() {
        if (indiceJugadorActual == JUGADOR2) {
            return true;
        }
        indiceJugadorActual += 1;
        return false;
    }

     */

    public boolean seContestoPregunta() {
        return turnoActual.finPregunta();
    }

    /*
    public Jugador obtenerJugadorActual() {
        return jugadores.get(indiceJugadorActual);
    }
     */

    public Jugador obtenerJugadorActual(){
        return turnoActual.getJugadorActual();
    }

    public void setPreguntaActual(Pregunta preguntaActual){
        this.preguntaActual = preguntaActual;
    }

    public void agregarRespuestaJugador(Opcion opcion, Jugador jugador) {
        if (turnoActual.esJugador1(jugador)){
            agregarRespuesta(opcionesJugador1, opcion);
        }else{
            agregarRespuesta(opcionesJugador2, opcion);
        }
    }

    public void agregarRespuesta(ArrayList<Opcion> opcionesJugador, Opcion opcion) {
        if(preguntaActual instanceof OrderedChoice) {
                OpcionOrdered opcionEstructurada = (OpcionOrdered) opcion;
                opcionEstructurada.elegirPosicion(opcionesJugador.size() + 1, opcionesJugador);
        }else{
            opcionesJugador.add(opcion);
        }
}

    public void responderPregunta(){
        Respuesta respuestaJugador1 = new Respuesta(opcionesJugador1, jugadores.get(JUGADOR1).puntaje());
        Respuesta respuestaJugador2 = new Respuesta(opcionesJugador2, jugadores.get(JUGADOR2).puntaje());
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);
        preguntaActual.responderPregunta(respuestas);
        opcionesJugador1 = new ArrayList<Opcion>();
        opcionesJugador2 = new ArrayList<Opcion>();
        //indiceJugadorActual = 0;
    }

    public void agregarRespuestaJugadorGroup(ToggleSwitch interruptor){
        respuestasJugadorGroup.add(interruptor);
    }

    public void recolectarRespuestasGroup(Jugador jugadorActual){
        for(ToggleSwitch interruptor : respuestasJugadorGroup){
            if(turnoActual.esJugador1(jugadorActual)){
                interruptor.respuestaJugador(opcionesJugador1);
            }else {
                interruptor.respuestaJugador(opcionesJugador2);
            }
        }
        respuestasJugadorGroup = new ArrayList<ToggleSwitch>();
    }

}