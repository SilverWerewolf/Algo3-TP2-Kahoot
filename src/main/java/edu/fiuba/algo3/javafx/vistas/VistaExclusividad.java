package edu.fiuba.algo3.javafx.vistas;

import edu.fiuba.algo3.javafx.controladores.AccionExclusividadPuntaje;
import edu.fiuba.algo3.javafx.controladores.AccionMultiplicadorNinguno;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VistaExclusividad {
    private Stage window;

    public VistaExclusividad(Stage stage) {
        this.window = stage;
    }

    public void desplegar(Pregunta pregunta, Jugador jugador, VistaPregunta vistaPregunta) {
        if (!jugador.tieneExclusividad()) {
            vistaPregunta.mostrarPregunta(pregunta, jugador);
            return;
        }

        System.out.println("hay exclusividad");
        Label nombreJugadorLabel = new Label(jugador.verNombre() + " elige si queres activar exclusividad de puntaje para esta pregunta");
        Button ninguno = new Button("Ninguno");
        ninguno.setOnAction(new AccionMultiplicadorNinguno(pregunta, jugador, vistaPregunta));

        Button exclusividadPuntaje = new Button("Activar exclusividad de puntaje");
        exclusividadPuntaje.setOnAction(new AccionExclusividadPuntaje(pregunta, jugador, vistaPregunta));

        if (!jugador.tieneExclusividad()) {
            exclusividadPuntaje.setDisable(true);
        }
            VBox layoutMultiplicador = new VBox();
            layoutMultiplicador.getChildren().add(nombreJugadorLabel);
            layoutMultiplicador.getChildren().add(exclusividadPuntaje);
            layoutMultiplicador.getChildren().add(ninguno);
            window.getScene().setRoot(layoutMultiplicador);
            window.sizeToScene();
            window.show();
            System.out.println("Se construyo ventana multiplicador");
    }
}

