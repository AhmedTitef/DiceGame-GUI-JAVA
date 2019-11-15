package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.stage.Stage;

import java.util.Random;

public class Main extends Application {
    private int counter;

    Random random = new Random();
    Dice dice1 = new Dice();
    Dice dice2 = new Dice();
    Dice dice3 = new Dice();
    Dice dice4 = new Dice();
    Dice dice5 = new Dice();

    private Label overallScore;
    private Label roundScore;
    private Label rollsRemaining;
    private Button rolldiceButton;


    private Image imageHeld[];
    private int roundScoreValue;
    private int overallScoreValue;


    @Override
    public void start(Stage primaryStage) throws Exception {

        overallScore = new Label("Overall Score: ");
        roundScore = new Label("Round Score: ");
        rollsRemaining = new Label("Rolls Remaining: 3");

        rolldiceButton = new Button("Roll Dice");


        imageHeld = new Image[6];


        imageHeld[0] = new Image("DiceImages/Dice1Held.png");
        imageHeld[1] = new Image("DiceImages/Dice2Held.png");
        imageHeld[2] = new Image("DiceImages/Dice3held.png");
        imageHeld[3] = new Image("DiceImages/Dice4held.png");
        imageHeld[4] = new Image("DiceImages/Dice5held.png");
        imageHeld[5] = new Image("DiceImages/Dice6held.png");


        dice1.setImage(new Image("DiceImages/Dice1.png"));
        dice2.setImage(new Image("DiceImages/Dice1.png"));
        dice3.setImage(new Image("DiceImages/Dice1.png"));
        dice4.setImage(new Image("DiceImages/Dice1.png"));
        dice5.setImage(new Image("DiceImages/Dice1.png"));

        rolldiceButton.setStyle("-fx-font-size: 24pt");


        dice1.setFitWidth(100);
        dice1.setFitHeight(100);
        dice1.setPreserveRatio(true);

        dice2.setFitWidth(100);
        dice2.setFitHeight(100);
        dice2.setPreserveRatio(true);

        dice3.setFitWidth(100);
        dice3.setFitHeight(100);
        dice3.setPreserveRatio(true);

        dice4.setFitWidth(100);
        dice4.setFitHeight(100);
        dice4.setPreserveRatio(true);

        dice5.setFitWidth(100);
        dice5.setFitHeight(100);
        dice5.setPreserveRatio(true);


        HBox hBox = new HBox(5, dice1, dice2, dice3, dice4, dice5);

        hBox.setAlignment(Pos.CENTER);
        overallScore.setAlignment(Pos.CENTER);
        roundScore.setAlignment(Pos.CENTER);
        rollsRemaining.setAlignment(Pos.CENTER);
        rolldiceButton.setAlignment(Pos.CENTER);


        VBox vBox = new VBox(20, overallScore, hBox, rolldiceButton, roundScore, rollsRemaining);
        vBox.setAlignment(Pos.CENTER);
        vBox.setStyle("-fx-background-color: lavender");


        rolldiceButton.setOnAction(event -> {

            if (dice1.isHeld() == false) {
                dice1.roll();
            }
            if (dice2.isHeld() == false) {
                dice2.roll();
            }
            if (dice3.isHeld() == false) {
                dice3.roll();
            }
            if (dice4.isHeld() == false) {
                dice4.roll();
            }
            if (dice5.isHeld() == false) {
                dice5.roll();
            }

            counter++;
            if (counter == 3) {
                rolldiceButton.setText("Result");
            }
            if (counter == 4) {
                gettingOverallScore();
                rolldiceButton.setText("Play Again?");
            }
            if (counter == 5) {


                primaryStage.close();
                Platform.runLater(() -> {
                    try {
                        new Main().start(primaryStage);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });

            }


            if (counter <= 3) {
                rollsRemaining.setText("Rolls Remaining: " + (3 - counter));
            }

            kinds(); //2 3 and 4
            straight();
            fullhouse();

            roundScore.setText("Your Score: " + roundScoreValue);
            overallScore.setText("Overall Score: " + overallScoreValue);


        });
        holdingDicePosition();
        primaryStage.setTitle("Dice Game");
        Scene myScene = new Scene(vBox, 600, 500);
        primaryStage.setScene(myScene);


        myScene.getStylesheets().add("myStyles.css");
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    private int[] countCommonValues() {
        int ones = 0;
        if (dice1.getValue() == 1) {
            ones++;
        }
        if (dice2.getValue() == 1) {
            ones++;
        }
        if (dice3.getValue() == 1) {
            ones++;
        }
        if (dice4.getValue() == 1) {
            ones++;
        }
        if (dice5.getValue() == 1) {
            ones++;
        }


        int twos = 0;
        if (dice1.getValue() == 2) {
            twos++;
        }
        if (dice2.getValue() == 2) {
            twos++;
        }
        if (dice3.getValue() == 2) {
            twos++;
        }
        if (dice4.getValue() == 2) {
            twos++;
        }
        if (dice5.getValue() == 2) {
            twos++;
        }


        int threes = 0;
        if (dice1.getValue() == 3) {
            threes++;
        }
        if (dice2.getValue() == 3) {
            threes++;
        }
        if (dice3.getValue() == 3) {
            threes++;
        }
        if (dice4.getValue() == 3) {
            threes++;
        }
        if (dice5.getValue() == 3) {
            threes++;
        }


        int fours = 0;
        if (dice1.getValue() == 4) {
            fours++;
        }
        if (dice2.getValue() == 4) {
            fours++;
        }
        if (dice3.getValue() == 4) {
            fours++;
        }
        if (dice4.getValue() == 4) {
            fours++;
        }
        if (dice5.getValue() == 4) {
            fours++;
        }


        int fives = 0;
        if (dice1.getValue() == 5) {
            fives++;
        }
        if (dice2.getValue() == 5) {
            fives++;
        }
        if (dice3.getValue() == 5) {
            fives++;
        }
        if (dice4.getValue() == 5) {
            fives++;
        }
        if (dice5.getValue() == 5) {
            fives++;
        }


        int sixes = 0;
        if (dice1.getValue() == 6) {
            sixes++;
        }
        if (dice2.getValue() == 6) {
            sixes++;
        }
        if (dice3.getValue() == 6) {
            sixes++;
        }
        if (dice4.getValue() == 6) {
            sixes++;
        }
        if (dice5.getValue() == 6) {
            sixes++;
        }


        return new int[]{ones, twos, threes, fours, fives, sixes};
    }

    private int straight() {
        if ((countCommonValues()[0] >= 1
                && countCommonValues()[1] >= 1
                && countCommonValues()[2] >= 1
                && countCommonValues()[3] >= 1
                && countCommonValues()[4] >= 1)
                || (countCommonValues()[1] >= 1
                && countCommonValues()[2] >= 1
                && countCommonValues()[3] >= 1
                && countCommonValues()[4] >= 1
                && countCommonValues()[5] >= 1)) {
            return roundScoreValue = 8;
        }
        return 0;
    }


    private int kinds() {
        if (countCommonValues()[0] == 2 && counter == 4) {
            rollsRemaining.setText(countCommonValues()[0] + " of a kind");
            return roundScoreValue = 1;
        }
        if (countCommonValues()[0] == 3 && counter == 4) {
            rollsRemaining.setText(countCommonValues()[0] + " of a kind");
            return roundScoreValue = 5;
        }
        if (countCommonValues()[0] == 4 && counter == 4) {
            rollsRemaining.setText(countCommonValues()[0] + " of a kind");
            return roundScoreValue = 7;
        }
        if (countCommonValues()[0] == 5 && counter == 4) {
            rollsRemaining.setText(countCommonValues()[0] + " of a kind");
            return roundScoreValue = 10;
        }


        if (countCommonValues()[1] == 2 && counter == 4) {
            rollsRemaining.setText(countCommonValues()[1] + " of a kind");
            return roundScoreValue = 1;
        }
        if (countCommonValues()[1] == 3 && counter == 4) {
            rollsRemaining.setText(countCommonValues()[1] + " of a kind");
            return roundScoreValue = 5;
        }
        if (countCommonValues()[1] == 4 && counter == 4) {
            rollsRemaining.setText(countCommonValues()[1] + " of a kind");
            return roundScoreValue = 7;
        }
        if (countCommonValues()[1] == 5 && counter == 4) {
            rollsRemaining.setText(countCommonValues()[1] + " of a kind");
            return roundScoreValue = 10;
        }
        if (countCommonValues()[2] == 2 && counter == 4) {
            rollsRemaining.setText(countCommonValues()[2] + " of a kind");
            return roundScoreValue = 1;
        }
        if (countCommonValues()[2] == 3 && counter == 4) {
            rollsRemaining.setText(countCommonValues()[2] + " of a kind");
            return roundScoreValue = 5;
        }
        if (countCommonValues()[2] == 4 && counter == 4) {
            rollsRemaining.setText(countCommonValues()[2] + " of a kind");
            return roundScoreValue = 7;
        }
        if (countCommonValues()[2] == 5 && counter == 4) {
            rollsRemaining.setText(countCommonValues()[2] + " of a kind");
            return roundScoreValue = 10;
        }
        if (countCommonValues()[3] == 2 && counter == 4) {
            rollsRemaining.setText(countCommonValues()[3] + " of a kind");
            return roundScoreValue = 1;
        }
        if (countCommonValues()[3] == 3 && counter == 4) {
            rollsRemaining.setText(countCommonValues()[3] + " of a kind");
            return roundScoreValue = 5;
        }
        if (countCommonValues()[3] == 4 && counter == 4) {
            rollsRemaining.setText(countCommonValues()[3] + " of a kind");
            return roundScoreValue = 7;
        }
        if (countCommonValues()[3] == 5 && counter == 4) {
            rollsRemaining.setText(countCommonValues()[3] + " of a kind");
            return roundScoreValue = 10;
        }
        if (countCommonValues()[4] == 2 && counter == 4) {
            rollsRemaining.setText(countCommonValues()[4] + " of a kind");
            return roundScoreValue = 1;
        }
        if (countCommonValues()[4] == 3 && counter == 4) {
            rollsRemaining.setText(countCommonValues()[4] + " of a kind");
            return roundScoreValue = 5;
        }
        if (countCommonValues()[4] == 4 && counter == 3) {
            rollsRemaining.setText(countCommonValues()[4] + " of a kind");
            return roundScoreValue = 7;
        }
        if (countCommonValues()[4] == 5 && counter == 4) {
            rollsRemaining.setText(countCommonValues()[4] + " of a kind");
            return roundScoreValue = 10;
        }
        if (countCommonValues()[5] == 2 && counter == 4) {
            rollsRemaining.setText(countCommonValues()[5] + " of a kind");
            return roundScoreValue = 1;
        }
        if (countCommonValues()[5] == 3 && counter == 4) {
            rollsRemaining.setText(countCommonValues()[5] + " of a kind");
            return roundScoreValue = 5;
        }
        if (countCommonValues()[5] == 4 && counter == 4) {
            rollsRemaining.setText(countCommonValues()[5] + " of a kind");
            return roundScoreValue = 7;
        }
        if (countCommonValues()[5] == 5 && counter == 4) {
            rollsRemaining.setText(countCommonValues()[5] + " of a kind");
            return roundScoreValue = 10;
        }
        return roundScoreValue;
    }


    void holdingDicePosition() {
        dice1.setOnMouseClicked(event -> {
            if (dice1.isHeld() == false && (counter == 1 || counter == 3 || counter == 2)) {
                dice1.setHold(true);
                dice1.setImage(imageHeld[dice1.getValue()]);
            } else {
                dice1.setHold(false);
            }
        });
        dice2.setOnMouseClicked(event -> {
            if (dice2.isHeld() == false && (counter == 1 || counter == 2 || counter == 3)) {
                dice2.setHold(true);
                dice2.setImage(imageHeld[dice2.getValue()]);
            } else {
                dice2.setHold(false);
            }
        });
        dice3.setOnMouseClicked(event -> {
            if (dice3.isHeld() == false && (counter == 1 || counter == 2 || counter == 3)) {
                dice3.setHold(true);
                dice3.setImage(imageHeld[dice3.getValue()]);
            } else {
                dice3.setHold(false);
            }
        });
        dice4.setOnMouseClicked(event -> {
            if (dice4.isHeld() == false && (counter == 1 || counter == 2 || counter == 3)) {
                dice4.setHold(true);
                dice4.setImage(imageHeld[dice4.getValue()]);
            } else {
                dice4.setHold(false);
            }
        });
        dice5.setOnMouseClicked(event -> {
            if (dice5.isHeld() == false && (counter == 1 || counter == 2 || counter == 3)) {
                dice5.setHold(true);
                dice5.setImage(imageHeld[dice5.getValue()]);
            } else {
                dice5.setHold(false);
            }
        });


    }


    private int fullhouse() {
        if (countCommonValues()[0] == 3 && counter == 4 && countCommonValues()[1] == 2) {
            rollsRemaining.setText("Full House");
            return roundScoreValue = 6;
        }
        if (countCommonValues()[0] == 3 && counter == 4 && countCommonValues()[2] == 2) {
            rollsRemaining.setText("Full House");
            return roundScoreValue = 6;
        }
        if (countCommonValues()[0] == 3 && counter == 4 && countCommonValues()[3] == 2) {
            rollsRemaining.setText("Full House");
            return roundScoreValue = 6;
        }
        if (countCommonValues()[0] == 3 && counter == 4 && countCommonValues()[4] == 2) {
            rollsRemaining.setText("Full House");
            return roundScoreValue = 6;
        }
        if (countCommonValues()[0] == 3 && counter == 4 && countCommonValues()[5] == 2) {
            rollsRemaining.setText("Full House");
            return roundScoreValue = 6;
        }
        //////
        if (countCommonValues()[1] == 3 && counter == 4 && countCommonValues()[0] == 2) {
            rollsRemaining.setText("Full House");
            return roundScoreValue = 6;
        }
        if (countCommonValues()[1] == 3 && counter == 4 && countCommonValues()[2] == 2) {
            rollsRemaining.setText("Full House");
            return roundScoreValue = 6;
        }
        if (countCommonValues()[1] == 3 && counter == 4 && countCommonValues()[3] == 2) {
            rollsRemaining.setText("Full House");
            return roundScoreValue = 6;
        }
        if (countCommonValues()[1] == 3 && counter == 4 && countCommonValues()[4] == 2) {
            rollsRemaining.setText("Full House");
            return roundScoreValue = 6;
        }
        if (countCommonValues()[1] == 3 && counter == 4 && countCommonValues()[5] == 2) {
            rollsRemaining.setText("Full House");
            return roundScoreValue = 6;
        }
        //////
        if (countCommonValues()[2] == 3 && counter == 4 && countCommonValues()[0] == 2) {
            rollsRemaining.setText("Full House");
            return roundScoreValue = 6;
        }
        if (countCommonValues()[2] == 3 && counter == 4 && countCommonValues()[1] == 2) {
            rollsRemaining.setText("Full House");
            return roundScoreValue = 6;
        }
        if (countCommonValues()[2] == 3 && counter == 4 && countCommonValues()[3] == 2) {
            rollsRemaining.setText("Full House");
            return roundScoreValue = 6;
        }
        if (countCommonValues()[2] == 3 && counter == 4 && countCommonValues()[4] == 2) {
            rollsRemaining.setText("Full House");
            return roundScoreValue = 6;
        }
        if (countCommonValues()[2] == 3 && counter == 4 && countCommonValues()[5] == 2) {
            rollsRemaining.setText("Full House");
            return roundScoreValue = 6;
        }
        ///////
        if (countCommonValues()[3] == 3 && counter == 3 && countCommonValues()[0] == 2) {
            rollsRemaining.setText("Full House");
            return roundScoreValue = 6;
        }
        if (countCommonValues()[3] == 3 && counter == 4 && countCommonValues()[1] == 2) {
            rollsRemaining.setText("Full House");
            return roundScoreValue = 6;
        }
        if (countCommonValues()[3] == 3 && counter == 4 && countCommonValues()[2] == 2) {
            rollsRemaining.setText("Full House");
            return roundScoreValue = 6;
        }
        if (countCommonValues()[3] == 3 && counter == 4 && countCommonValues()[4] == 2) {
            rollsRemaining.setText("Full House");
            return roundScoreValue = 6;
        }
        if (countCommonValues()[3] == 3 && counter == 4 && countCommonValues()[5] == 2) {
            rollsRemaining.setText("Full House");
            return roundScoreValue = 6;
        }
        /////
        if (countCommonValues()[4] == 3 && counter == 4 && countCommonValues()[0] == 2) {
            rollsRemaining.setText("Full House");
            return roundScoreValue = 6;
        }
        if (countCommonValues()[4] == 3 && counter == 4 && countCommonValues()[1] == 2) {
            rollsRemaining.setText("Full House");
            return roundScoreValue = 6;
        }
        if (countCommonValues()[4] == 3 && counter == 4 && countCommonValues()[2] == 2) {
            rollsRemaining.setText("Full House");
            return roundScoreValue = 6;
        }
        if (countCommonValues()[4] == 3 && counter == 4 && countCommonValues()[3] == 2) {
            rollsRemaining.setText("Full House");
            return roundScoreValue = 6;
        }
        if (countCommonValues()[4] == 3 && counter == 4 && countCommonValues()[5] == 2) {
            rollsRemaining.setText("Full House");
            return roundScoreValue = 6;
        }
        /////
        if (countCommonValues()[5] == 3 && counter == 4 && countCommonValues()[0] == 2) {
            rollsRemaining.setText("Full House");
            return roundScoreValue = 6;
        }
        if (countCommonValues()[5] == 3 && counter == 4 && countCommonValues()[1] == 2) {
            rollsRemaining.setText("Full House");
            return roundScoreValue = 6;
        }
        if (countCommonValues()[5] == 3 && counter == 3 && countCommonValues()[2] == 2) {
            rollsRemaining.setText("Full House");
            return roundScoreValue = 6;
        }
        if (countCommonValues()[5] == 3 && counter == 4 && countCommonValues()[3] == 2) {
            rollsRemaining.setText("Full House");
            return roundScoreValue = 6;
        }
        if (countCommonValues()[5] == 3 && counter == 4 && countCommonValues()[4] == 2) {
            rollsRemaining.setText("Full House");
            return roundScoreValue = 6;
        }


        return roundScoreValue;
    }


    void gettingOverallScore() {


        if (dice1.getImage() == imageHeld[0] || dice1.getImage() == imageHeld[1] || dice1.getImage() == imageHeld[2] || dice1.getImage() == imageHeld[3] || dice1.getImage() == imageHeld[4] || dice1.getImage() == imageHeld[5]) {
            overallScoreValue += dice1.getValue() + 1;
        }
        if (dice2.getImage() == imageHeld[0] || dice2.getImage() == imageHeld[1] || dice2.getImage() == imageHeld[2] || dice2.getImage() == imageHeld[3] || dice2.getImage() == imageHeld[4] || dice2.getImage() == imageHeld[5]) {
            overallScoreValue += dice2.getValue() + 1;
        }
        if (dice3.getImage() == imageHeld[0] || dice3.getImage() == imageHeld[1] || dice3.getImage() == imageHeld[2] || dice3.getImage() == imageHeld[3] || dice3.getImage() == imageHeld[4] || dice3.getImage() == imageHeld[5]) {
            overallScoreValue += dice3.getValue() + 1;
        }
        if (dice4.getImage() == imageHeld[0] || dice4.getImage() == imageHeld[1] || dice4.getImage() == imageHeld[2] || dice4.getImage() == imageHeld[3] || dice4.getImage() == imageHeld[4] || dice4.getImage() == imageHeld[5]) {
            overallScoreValue += dice4.getValue() + 1;
        }
        if (dice5.getImage() == imageHeld[0] || dice5.getImage() == imageHeld[1] || dice5.getImage() == imageHeld[2] || dice5.getImage() == imageHeld[3] || dice5.getImage() == imageHeld[4] || dice5.getImage() == imageHeld[5]) {
            overallScoreValue += dice5.getValue() + 1;
        }

    }
}


