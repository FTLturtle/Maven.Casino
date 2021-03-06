package io.zipcoder.casino;


import io.zipcoder.casino.Models.GuestAccount;
import io.zipcoder.casino.utilities.ImageUtilities;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{
    public static Display startingDisplay = new Display();
    public static CasinoGamesDisplay casinoGamesDisplay = new CasinoGamesDisplay();
    public static Stage mainStage;
    public static Stage secondStage = new Stage();
    public static Casino casino = new Casino();
    public ImageUtilities imageUtilities = new ImageUtilities();

    public static void main(String[] args) {

        //setUpforDisplayTesting();
        String choice = consoleOrGUI();
        if(choice.equals("retro")) {
            casino.startCasinoExperience();
        }else{
            launch(args);
        }
    }

    @Override
    public void start(Stage stage) throws Exception {

        this.mainStage = stage;
        mainStage.setTitle("Casino Royale");
        this.mainStage.setScene(new Scene(startingDisplay.createContent()));
        this.mainStage.show();
/*
        this.mainStage = stage;
        this.mainStage.setTitle("Casino Royale");
        this.mainStage.setScene(new Scene(casinoDisplay.createCasinoContent()));
        this.mainStage.show();

        this.mainStage = stage;
        this.mainStage.setTitle("Casino Royale");
        this.mainStage.setScene(new Scene(casinoGamesDisplay.createCasinoGamesContent()));
        this.mainStage.show();
*/

    }

    public static String consoleOrGUI(){

        while(true) {
            String choice = (casino.console.getStringInput("Would you like to gamble using the <Retro> or <Modern> Interface").toLowerCase());
            if (choice.equals("modern") || choice.equals("retro")) {
                return choice;
            } else {
                return casino.console.getStringInput("Incorrect input, please try again. <Retro> or <Modern>").toLowerCase();
            }
        }

    }

    public static void setUpforDisplayTesting(){
        GuestAccount newGuestAccount = new GuestAccount("Marshilla Brahma", 1,10000.00);
        casino.setGuest("Marshilla Brahma", newGuestAccount);
    }
}
