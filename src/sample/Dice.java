package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Random;
public class Dice extends ImageView {

    private Image[] images = new Image[]{new Image("DiceImages/Dice1.png"), new Image("DiceImages/Dice2.png"), new Image("DiceImages/Dice3.png"),
            new Image("DiceImages/Dice4.png"), new Image("DiceImages/Dice5.png"), new Image("DiceImages/Dice6.png")};


    private int diceValue;

    private boolean hold = false;
    private int counter = 0;



    public boolean isHeld() {
        return hold;
    }

    public void setHold(boolean hold) {
        this.hold = hold;
    }

    public int getValue() {
        return diceValue;
    }

    public void setValue(int value) {
        diceValue = value;
    }

    public ImageView roll() {
        if (hold == false && counter < 3) {
            int val = (int) (6 * Math.random() );
            setValue(val);
            if (val == 0) {
                this.setImage(images[0]);
            }
            if (val == 1) {
                this.setImage(images[1]);
            }
            if (val == 2) {
                this.setImage(images[2]);
            }
            if (val == 3) {
                this.setImage(images[3]);
            }
            if (val == 4) {
                this.setImage(images[4]);
            }
            if (val == 5) {
                this.setImage(images[5]);
            }
            counter++;
        }
        return this;
    }


}