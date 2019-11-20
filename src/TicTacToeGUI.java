import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A simple Tic Tac Toe game for 2 people
 *
 * @author natasharao
 * @version November 19, 2019
 */
public class TicTacToeGUI extends JFrame {
    private Container pane;
    private String currentPlayer;
    private JButton [][] gameBoard;
    private boolean gameOver;
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem quitGame;
    private JMenuItem newGame;


    public TicTacToeGUI() {
        super();
        pane = getContentPane();
        pane.setLayout(new GridLayout(3, 3));
        setTitle("Tic Tac Toe");
        setSize(500, 500);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        currentPlayer = "x";
        gameBoard = new JButton[3][3];
        gameOver = false;
        initilizeGameBoard();
        initializeMenu();
    }

    private void initializeMenu() {
        menuBar = new JMenuBar();
        menu = new JMenu("File");

        newGame = new JMenuItem("New Game");
        newGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startOverGame();
            }
        });

        quitGame = new JMenuItem("Quit Game");
        quitGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        menu.add(newGame);
        menu.add(quitGame);

        menuBar.add(menu);
        setJMenuBar(menuBar);
    }

    private void startOverGame() {
        currentPlayer = "x";
        gameOver = false;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                gameBoard[i][j].setText("");
            }
        }
    }

    private void initilizeGameBoard() {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                JButton button = new JButton();
                button.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 100));
                gameBoard[i][j] = button;
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                       if (((JButton)e.getSource()).getText().equals("") && !gameOver) {
                           button.setText(currentPlayer);
                           isGameOver();
                           handPlayerTurn();
                       }
                    }
                });
                pane.add(button);
            }
        }

    }

    private void handPlayerTurn() {
        if (currentPlayer.equals("x")) {
            currentPlayer = "o";
        } else  {
            currentPlayer = "x";
        }
    }


    private void isGameOver() {

        // check row
        if (!gameBoard[0][0].getText().equals("") && gameBoard[0][0].getText().equals(gameBoard[0][1].getText()) && gameBoard[0][0].getText().equals(gameBoard[0][2].getText())) {
            JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won the game!");
            gameOver = true;
        } else if (!gameBoard[1][0].getText().equals("") && gameBoard[1][0].getText().equals(gameBoard[1][1].getText()) && gameBoard[1][0].getText().equals(gameBoard[1][2].getText())) {
            JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won the game!");
            gameOver = true;
        } else if (!gameBoard[2][0].getText().equals("") && gameBoard[2][0].getText().equals(gameBoard[2][1].getText()) && gameBoard[2][0].getText().equals(gameBoard[2][2].getText())) {
            JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won the game!");
            gameOver = true;
        }


        //check col
        if (!gameBoard[0][0].getText().equals("") && gameBoard[0][0].getText().equals(gameBoard[1][0].getText()) && gameBoard[0][0].getText().equals(gameBoard[2][0].getText())) {
            JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won the game!");
            gameOver = true;
        } else if (!gameBoard[0][1].getText().equals("") && gameBoard[0][1].getText().equals(gameBoard[1][1].getText()) && gameBoard[0][1].getText().equals(gameBoard[2][1].getText())) {
            JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won the game!");
            gameOver = true;
        } else if (!gameBoard[0][2].getText().equals("") && gameBoard[0][2].getText().equals(gameBoard[1][2].getText()) && gameBoard[0][2].getText().equals(gameBoard[2][2].getText())) {
            JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won the game!");
            gameOver = true;
        }

        //check diagonals
        if (!gameBoard[0][0].getText().equals("") && gameBoard[0][0].getText().equals(gameBoard[1][1].getText()) && gameBoard[0][0].getText().equals(gameBoard[2][2].getText())) {
            JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won the game!");
            gameOver = true;
        } else if (!gameBoard[0][2].getText().equals("") && gameBoard[0][2].getText().equals(gameBoard[1][1].getText()) && gameBoard[0][2].getText().equals(gameBoard[2][1].getText())) {
            JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won the game!");
            gameOver = true;
        }


    }


}
