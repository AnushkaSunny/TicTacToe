package Game.UI;

import Game.Theme;
import Game.logic.Difficulty;
import Game.logic.GameMode;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class HomeScreen extends JFrame {

    private MenuButton pvpButton;
    private MenuButton pvcButton;
    private MenuButton playButton;

    private MenuButton easyButton;
    private MenuButton mediumButton;
    private MenuButton hardButton;

    private JLabel difficultyLabel;
    private JPanel difficultyPanel;

    private GameMode selectedMode = GameMode.PLAYER_VS_PLAYER;
    private Difficulty selectedDifficulty = Difficulty.EASY;

    public HomeScreen() {
        initializeUI();
    }

    private void initializeUI() {

        setTitle("Tic Tac Toe");
        setSize(550,550);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getContentPane().setBackground(Theme.BACKGROUND);

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Theme.BACKGROUND);
        mainPanel.setBorder(new EmptyBorder(30,30,30,30));
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));



        //---------------- TITLE ----------------//

        JLabel title = new JLabel("TIC TAC TOE");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setFont(Theme.TITLE_FONT);
        title.setForeground(Theme.TITLE);

        mainPanel.add(title);
        mainPanel.add(Box.createRigidArea(new Dimension(0,50)));



        //---------------- PLAYER VS PLAYER ----------------//

        pvpButton = new MenuButton("PLAYER VS PLAYER");
        pvpButton.setSelectedButton(true);

        mainPanel.add(pvpButton);
        mainPanel.add(Box.createRigidArea(new Dimension(0,20)));



        //---------------- PLAYER VS COMPUTER ----------------//

        pvcButton = new MenuButton("PLAYER VS COMPUTER");

        mainPanel.add(pvcButton);
        mainPanel.add(Box.createRigidArea(new Dimension(0,25)));



        //---------------- DIFFICULTY ----------------//

        difficultyLabel = new JLabel("DIFFICULTY");
        difficultyLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        difficultyLabel.setForeground(Theme.TEXT);
        difficultyLabel.setFont(Theme.BUTTON_FONT);
        difficultyLabel.setVisible(false);

        mainPanel.add(difficultyLabel);
        mainPanel.add(Box.createRigidArea(new Dimension(0,15)));



        //---------------- DIFFICULTY BUTTONS ----------------//

        easyButton = new MenuButton("EASY", true);
        mediumButton = new MenuButton("MEDIUM", true);
        hardButton = new MenuButton("HARD", true);
        easyButton.setSelectedButton(true);

        Dimension difficultySize = new Dimension(130,50);

        easyButton.setPreferredSize(difficultySize);
        easyButton.setMaximumSize(difficultySize);

        mediumButton.setPreferredSize(difficultySize);
        mediumButton.setMaximumSize(difficultySize);

        hardButton.setPreferredSize(difficultySize);
        hardButton.setMaximumSize(difficultySize);

        difficultyPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,10,0));
        difficultyPanel.setOpaque(false);
        difficultyPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        difficultyPanel.add(easyButton);
        difficultyPanel.add(mediumButton);
        difficultyPanel.add(hardButton);

        difficultyPanel.setVisible(false);

        mainPanel.add(difficultyPanel);

        mainPanel.add(Box.createVerticalGlue());



        //---------------- PLAY BUTTON ----------------//

        playButton = new MenuButton("PLAY");

        mainPanel.add(playButton);

        add(mainPanel);



        //---------------- LISTENERS ----------------//

        pvpButton.addActionListener(e -> {

            selectedMode = GameMode.PLAYER_VS_PLAYER;

            pvpButton.setSelectedButton(true);
            pvcButton.setSelectedButton(false);

            difficultyLabel.setVisible(false);
            difficultyPanel.setVisible(false);

        });

        pvcButton.addActionListener(e -> {

            selectedMode = GameMode.PLAYER_VS_COMPUTER;

            pvcButton.setSelectedButton(true);
            pvpButton.setSelectedButton(false);

            difficultyLabel.setVisible(true);
            difficultyPanel.setVisible(true);

        });

        easyButton.addActionListener(e -> {

            selectedDifficulty = Difficulty.EASY;

            easyButton.setSelectedButton(true);
            mediumButton.setSelectedButton(false);
            hardButton.setSelectedButton(false);

        });

        mediumButton.addActionListener(e -> {

            selectedDifficulty = Difficulty.MEDIUM;

            easyButton.setSelectedButton(false);
            mediumButton.setSelectedButton(true);
            hardButton.setSelectedButton(false);

        });

        hardButton.addActionListener(e -> {

            selectedDifficulty = Difficulty.HARD;

            easyButton.setSelectedButton(false);
            mediumButton.setSelectedButton(false);
            hardButton.setSelectedButton(true);

        });

        playButton.addActionListener(e -> {

            new PlayerSetupScreen(selectedMode, selectedDifficulty);

            dispose();

        });

        setVisible(true);

    }

}