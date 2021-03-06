package edu.fiuba.algo3.javafx.vistas;
import edu.fiuba.algo3.javafx.controladores.AccionExclusividadPuntaje;
import edu.fiuba.algo3.javafx.controladores.AccionNinguno;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class VistaExclusividad {

    private Stage window;

    public VistaExclusividad(Stage stage) {
        this.window = stage;
    }

    public void desplegar(Pregunta pregunta, Jugador jugador, VistaPregunta vistaPregunta) {
        if (!jugador.tieneExclusividad()) {
            vistaPregunta.mostrarPregunta(pregunta);
            return;
        }

        Label nombreJugadorLabel = new Label(jugador.verNombre() + " elegí si queres activar exclusividad de puntaje para esta pregunta");
        nombreJugadorLabel.setFont(new Font("Arial", 16));
        Label puntosActuales = new Label("Puntaje actual:"+ jugador.puntaje().getPuntaje());
        Button ninguno = new Button("Ninguno");
        Efectos efectoBoton = new Efectos();
        efectoBoton.agregarEfecto(ninguno);
        ninguno.setOnAction(new AccionNinguno(pregunta, vistaPregunta));

        Button exclusividadPuntaje = new Button("Activar exclusividad de puntaje");
        efectoBoton.agregarEfecto(exclusividadPuntaje);
        exclusividadPuntaje.setOnAction(new AccionExclusividadPuntaje(pregunta, jugador, vistaPregunta));

        if (!jugador.tieneExclusividad()) {
            exclusividadPuntaje.setDisable(true);
        }
            VBox layoutExclusividad = new VBox();
            layoutExclusividad.setBackground(new Background(new BackgroundFill(Color.SKYBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
            layoutExclusividad.getChildren().add(nombreJugadorLabel);
            layoutExclusividad.getChildren().add(puntosActuales);
            layoutExclusividad.getChildren().add(exclusividadPuntaje);
            layoutExclusividad.getChildren().add(ninguno);

            layoutExclusividad.setAlignment(Pos.CENTER);
            layoutExclusividad.setSpacing(10);

            window.getScene().setRoot(layoutExclusividad);
            window.sizeToScene();
            window.show();
    }

}