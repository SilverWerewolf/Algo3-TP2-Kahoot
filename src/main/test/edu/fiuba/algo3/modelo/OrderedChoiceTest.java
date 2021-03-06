package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.excepciones.MultipleChoiceCantidadDeOpcionesEsIncorrectaException;
import edu.fiuba.algo3.modelo.excepciones.OrderedChoiceCantidadDeOpcionesEsIncorrectaException;
import edu.fiuba.algo3.modelo.modalidades.ModalidadClasico;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import edu.fiuba.algo3.modelo.opciones.OpcionBooleana;
import edu.fiuba.algo3.modelo.opciones.OpcionOrdered;
import edu.fiuba.algo3.modelo.preguntas.MultipleChoice;
import edu.fiuba.algo3.modelo.preguntas.OrderedChoice;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class OrderedChoiceTest {

    @Test
    public void test06_1SeCreaOrderedChoiceConOpcionesOrdenadasCorrectamente(){

        //Ordenar de mayor a menor
        OpcionOrdered opcion1 = new OpcionOrdered("4",0);
        OpcionOrdered opcion2 = new OpcionOrdered("7",1);
        OpcionOrdered opcion3 = new OpcionOrdered("9",2);
        OpcionOrdered opcion4 = new OpcionOrdered("10",3);
        OpcionOrdered opcion5 = new OpcionOrdered("25",4);

        Jugador jugador = new Jugador("Ivan");
        ArrayList<Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);
        opciones.add(opcion4);
        opciones.add(opcion5);

        ArrayList<Opcion> opcionesJugador = new ArrayList<Opcion>();
        opcion1.elegirPosicion(0, opcionesJugador);
        opcion2.elegirPosicion(1, opcionesJugador);
        opcion3.elegirPosicion(2, opcionesJugador);
        opcion4.elegirPosicion(3, opcionesJugador);
        opcion5.elegirPosicion(4, opcionesJugador);

        Respuesta respuesta = new Respuesta(opcionesJugador,jugador.puntaje());
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuesta);

        OrderedChoice preguntaTest = new OrderedChoice("Ordenar de menor a mayor", opciones);
        preguntaTest.responderPregunta(respuestas);

        assertEquals(1,jugador.puntaje().getPuntaje());

    }

    @Test
    public void test06_2OrderedChoiceConAlgunasOrdenadasCorrectamente(){

        //Ordenar de mayor a menor
        OpcionOrdered opcion1 = new OpcionOrdered("4",0);
        OpcionOrdered opcion2 = new OpcionOrdered("7",1);
        OpcionOrdered opcion3 = new OpcionOrdered("9",2);
        OpcionOrdered opcion4 = new OpcionOrdered("10",3);
        OpcionOrdered opcion5 = new OpcionOrdered("25",4);

        Jugador jugador = new Jugador("Ivan");
        ArrayList<Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);
        opciones.add(opcion4);
        opciones.add(opcion5);

        ArrayList<Opcion> opcionesJugador1 = new ArrayList<Opcion>();
        opcion1.elegirPosicion(0, opcionesJugador1);
        opcion2.elegirPosicion(1, opcionesJugador1);
        opcion3.elegirPosicion(3, opcionesJugador1);
        opcion4.elegirPosicion(2, opcionesJugador1);
        opcion5.elegirPosicion(4, opcionesJugador1);

        Respuesta respuesta = new Respuesta(opcionesJugador1,jugador.puntaje());
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuesta);

        OrderedChoice preguntaTest = new OrderedChoice("Ordenar de menor a mayor", opciones);
        preguntaTest.responderPregunta(respuestas);

        assertEquals(0,jugador.puntaje().getPuntaje());

    }

    @Test
    public void test06_3OrderedChoiceConDosJugadoresConUnoTodasCorrectasYOtrasTodasIncorrectas(){

        //Ordenar de mayor a menor
        OpcionOrdered opcion1 = new OpcionOrdered("4",0);
        OpcionOrdered opcion2 = new OpcionOrdered("7",1);
        OpcionOrdered opcion3 = new OpcionOrdered("9",2);
        OpcionOrdered opcion4 = new OpcionOrdered("10",3);
        OpcionOrdered opcion5 = new OpcionOrdered("25",4);

        Jugador jugador1 = new Jugador("Ivan");
        Jugador jugador2 = new Jugador("Enrique");

        ArrayList<Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);
        opciones.add(opcion4);
        opciones.add(opcion5);

        ArrayList<Opcion> opcionesJugador1 = new ArrayList<Opcion>();
        opcion1.elegirPosicion(0, opcionesJugador1);
        opcion2.elegirPosicion(1, opcionesJugador1);
        opcion3.elegirPosicion(3, opcionesJugador1);
        opcion4.elegirPosicion(2, opcionesJugador1);
        opcion5.elegirPosicion(4, opcionesJugador1);

        ArrayList<Opcion> opcionesJugador2 = new ArrayList<Opcion>();
        opcion1.elegirPosicion(0, opcionesJugador2);
        opcion2.elegirPosicion(1, opcionesJugador2);
        opcion3.elegirPosicion(2, opcionesJugador2);
        opcion4.elegirPosicion(3, opcionesJugador2);
        opcion5.elegirPosicion(4, opcionesJugador2);

        Respuesta respuestaJugador1 = new Respuesta(opcionesJugador1,jugador1.puntaje());
        Respuesta respuestaJugador2 = new Respuesta(opcionesJugador2,jugador2.puntaje());

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);

        OrderedChoice preguntaTest = new OrderedChoice("Ordenar de menor a mayor", opciones);
        preguntaTest.responderPregunta(respuestas);

        assertEquals(0,jugador1.puntaje().getPuntaje());
        assertEquals(1, jugador2.puntaje().getPuntaje());

    }

    @Test
    public void test06_4UnJugadorRespondeOrderedChoiceySeAsignaPuntajesCorrectamenteConExclusividadPuntaje(){

        //Ordenar de mayor a menor
        OpcionOrdered opcion1 = new OpcionOrdered("4",0);
        OpcionOrdered opcion2 = new OpcionOrdered("7",1);
        OpcionOrdered opcion3 = new OpcionOrdered("9",2);
        OpcionOrdered opcion4 = new OpcionOrdered("10",3);
        OpcionOrdered opcion5 = new OpcionOrdered("25",4);

        Jugador jugador1 = new Jugador("Ivan");
        Jugador jugador2 = new Jugador("Enrique");

        ArrayList<Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);
        opciones.add(opcion4);
        opciones.add(opcion5);

        ArrayList<Opcion> opcionesJugador1 = new ArrayList<Opcion>();
        opcion1.elegirPosicion(0, opcionesJugador1);
        opcion2.elegirPosicion(1, opcionesJugador1);
        opcion3.elegirPosicion(3, opcionesJugador1);
        opcion4.elegirPosicion(2, opcionesJugador1);
        opcion5.elegirPosicion(4, opcionesJugador1);

        ArrayList<Opcion> opcionesJugador2 = new ArrayList<Opcion>();
        opcion1.elegirPosicion(0, opcionesJugador2);
        opcion2.elegirPosicion(1, opcionesJugador2);
        opcion3.elegirPosicion(2, opcionesJugador2);
        opcion4.elegirPosicion(3, opcionesJugador2);
        opcion5.elegirPosicion(4, opcionesJugador2);

        Respuesta respuestaJugador1 = new Respuesta(opcionesJugador1,jugador1.puntaje());
        Respuesta respuestaJugador2 = new Respuesta(opcionesJugador2,jugador2.puntaje());

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);

        OrderedChoice preguntaTest = new OrderedChoice("Ordenar de menor a mayor", opciones);

        preguntaTest.usarExclusividad(jugador2);
        preguntaTest.responderPregunta(respuestas);

        assertEquals(0,jugador1.puntaje().getPuntaje());
        assertEquals(2, jugador2.puntaje().getPuntaje());

    }

    @Test
    public void test06_5ResponderOrderedChoiceyAsignarPuntajesCorrectamenteConExclusividadPuntajeActivadaParaLosDosJugadores(){

        //Ordenar de mayor a menor
        OpcionOrdered opcion1 = new OpcionOrdered("4",0);
        OpcionOrdered opcion2 = new OpcionOrdered("7",1);
        OpcionOrdered opcion3 = new OpcionOrdered("9",2);
        OpcionOrdered opcion4 = new OpcionOrdered("10",3);
        OpcionOrdered opcion5 = new OpcionOrdered("25",4);

        Jugador jugador1 = new Jugador("Ivan");
        Jugador jugador2 = new Jugador("Enrique");

        ArrayList<Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);
        opciones.add(opcion4);
        opciones.add(opcion5);

        ArrayList<Opcion> opcionesJugador1 = new ArrayList<Opcion>();
        opcion1.elegirPosicion(0, opcionesJugador1);
        opcion2.elegirPosicion(1, opcionesJugador1);
        opcion3.elegirPosicion(3, opcionesJugador1);
        opcion4.elegirPosicion(2, opcionesJugador1);
        opcion5.elegirPosicion(4, opcionesJugador1);

        ArrayList<Opcion> opcionesJugador2 = new ArrayList<Opcion>();
        opcion1.elegirPosicion(0, opcionesJugador2);
        opcion2.elegirPosicion(1, opcionesJugador2);
        opcion3.elegirPosicion(2, opcionesJugador2);
        opcion4.elegirPosicion(3, opcionesJugador2);
        opcion5.elegirPosicion(4, opcionesJugador2);

        Respuesta respuestaJugador1 = new Respuesta(opcionesJugador1,jugador1.puntaje());
        Respuesta respuestaJugador2 = new Respuesta(opcionesJugador2,jugador2.puntaje());

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);

        OrderedChoice preguntaTest = new OrderedChoice("Ordenar de menor a mayor", opciones);

        preguntaTest.usarExclusividad(jugador1);
        preguntaTest.usarExclusividad(jugador2);
        preguntaTest.responderPregunta(respuestas);

        assertEquals(0,jugador1.puntaje().getPuntaje());
        assertEquals(4, jugador2.puntaje().getPuntaje());

    }
    @Test
    public void test06_6OrderedChoiceConMasDeCincoOpcionesLanzaExcepcion(){

        OpcionOrdered opcion1 = new OpcionOrdered("4",0);
        OpcionOrdered opcion2 = new OpcionOrdered("7",1);
        OpcionOrdered opcion3 = new OpcionOrdered("9",2);
        OpcionOrdered opcion4 = new OpcionOrdered("10",3);
        OpcionOrdered opcion5 = new OpcionOrdered("25",4);
        OpcionOrdered opcion6 = new OpcionOrdered("26",5);

        ArrayList<Opcion> todasLasOpciones = new ArrayList<Opcion>();
        todasLasOpciones.add(opcion1);
        todasLasOpciones.add(opcion2);
        todasLasOpciones.add(opcion3);
        todasLasOpciones.add(opcion4);
        todasLasOpciones.add(opcion5);
        todasLasOpciones.add(opcion6);

        assertThrows(OrderedChoiceCantidadDeOpcionesEsIncorrectaException.class, () ->
        {new OrderedChoice("Es Tomas su primer nombre?", todasLasOpciones);
        });



    }
    @Test
    public void test06_7OrderedChoiceConMenosDeDosOpcionesLanzaExcepcion(){

        OpcionOrdered opcion1 = new OpcionOrdered("4",0);

        ArrayList<Opcion> todasLasOpciones = new ArrayList<Opcion>();
        todasLasOpciones.add(opcion1);

        assertThrows(OrderedChoiceCantidadDeOpcionesEsIncorrectaException.class, () ->
        {new OrderedChoice("Es Tomas su primer nombre?", todasLasOpciones);
        });
    }


}