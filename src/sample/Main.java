package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.Random;

import static com.sun.javafx.scene.control.skin.Utils.layout;

public class Main extends Application implements EventHandler<ActionEvent> {

    Button play;
    Label text;
    Label printscore;
    TextField player1;
    TextField result;
    private int partie = 0;
    private int score1 = 0;
    private int score2 = 0;
    private String a = null;
    private int p = 0 ;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        StackPane layout = null;
        Scene scene = new Scene(layout, 500, 700);
        primaryStage.setScene(scene);
        primaryStage.show();

        layout = new StackPane();
        primaryStage.setTitle(" Game ");

        text = new Label(" Rock-Paper-Scissors Game ");
        layout.getChildren().add(text);
        text.setTranslateY(-200);
        text.setAlignment(Pos.CENTER);
        text.setFont(Font.font(50));

        // as its name reffers to : this prints out the score, at the end you have a if / else for this
        printscore = new Label(" ");
        layout.getChildren().add(printscore);
        printscore.setTranslateY(-100);
        printscore.setAlignment(Pos.CENTER);
        printscore.setFont(Font.font(50));

        // textfield1
        player1 = new TextField();
        player1.setPromptText("enter 1 or 2 or 3");
        layout.getChildren().add(player1);
        player1.setTranslateY(-50);
        player1.setAlignment(Pos.CENTER);

        // convert player input into integer and put it in variable p
        p = Integer.valueOf(player1.getPromptText());

        // button play
        play = new Button();
        play.setText("Play");
        play.setOnAction(this);
        play.setTranslateX(-200);
        play.setTranslateY(0);
        layout.getChildren().add(play);


        // textfield 3
        result = new TextField();
        result.setPromptText("result");
        layout.getChildren().add(result);
        result.setTranslateY(200);
        result.setAlignment(Pos.CENTER);

    }

    @Override
    public void handle(ActionEvent event) {

        // method when u click on play , the result prints this
        if (event.getSource() == play) {
            while (partie < 6 ) {
                Random rand = new Random();
                int b = rand.nextInt(4);
                partie++;
                switch (p) {
                    case 1:
                        a = "Rock";
                        switch (b) {
                            case 1:
                                result.setText("It's a tie");
                                break;
                            case 2:
                                result.setText("The computer wins");
                                score2++;
                                break;
                            case 3:
                                result.setText("The player wins");
                                score1++;
                                break;
                        }
                        break;
                    case 2:
                        a = "Paper";
                        switch (b) {
                            case 1:
                                result.setText("The player wins");
                                score1++;
                                break;
                            case 2:
                                result.setText("It's a tie");
                                break;
                            case 3:
                                result.setText("The computer wins");
                                score2++;
                                break;
                        }
                        break;
                    case 3:
                        a = "Scissors";
                        switch (b) {
                            case 1:
                                result.setText("The computer wins");
                                score2++;
                                break;
                            case 2:
                                result.setText("The player wins");
                                score1++;
                                break;
                            case 3:
                                result.setText("It's a tie");
                                break;
                        }
                        break;
                }


            }


            if (score1>score2) {
                printscore.setText("The Player wins this round ");
            }
            else {
                printscore.setText("The Computer wins this round ");
            }



        }

    }

}

