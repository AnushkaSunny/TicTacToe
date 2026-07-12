package Game;

import Game.UI.HomeScreen;

import javax.swing.SwingUtilities;

public class GameMain {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new HomeScreen();
        });


    }

}