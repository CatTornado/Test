import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Threads extends Application {
    private int i = 100;

    @Override
    public void start(Stage primaryStage) {

        final ProgressBar progressBar1 = new ProgressBar(0);
        final ProgressBar progressBar2 = new ProgressBar(0);

        final Button startButton = new Button("Go");

        startButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                startButton.setDisable(true);
                progressBar1.setProgress(0);
                progressBar2.setProgress(0);
                progressBar1.setStyle("-fx-accent: #90ee90");
                progressBar2.setStyle("-fx-accent: #ffb6c1");

                Addition addition1 = new Addition(i, progressBar1, 1);
                Addition addition3 = new Addition(i, progressBar2, 3);

                Thread first = new Thread(addition1.getAddition());
                Thread second = new Thread(addition3.getAddition());
                first.start();
                second.start();
            }
        });


        FlowPane root = new FlowPane();
        root.setPadding(new Insets(10));
        root.setHgap(10);

        root.getChildren().addAll(progressBar1, progressBar2, startButton);

        Scene scene = new Scene(root, 170, 60);
        primaryStage.setTitle("Threads");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}
