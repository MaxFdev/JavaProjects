package dev.testproject;

import java.lang.reflect.Type;
import java.util.*;

public class OOP_TTT {
    public static void main(String[] args) {
        startUp();
        OOP_TTT game = new OOP_TTT();
        game.chooseMode();
        game.chooseTurnOrder();
        game.startGame();
    }
    
    public static void startUp() {
        // make a start up screen
    }

    public static void clear() {
        System.out.println(""); // clear the terminal
    }
    
    private Scanner scanner;
    private boolean againstBot;
    private boolean defaultOrder;
    private Board board;
    
    public OOP_TTT() {
        this.scanner = new Scanner(System.in);
        this.againstBot = false;
        this.defaultOrder = true;
        this.board = new Board();
    }

    public void chooseMode() {
        System.out.println("Do you want to pkay against a bot?[y/n]: ");
        String input = this.scanner.nextLine();
        input = input.toLowerCase();
        if (input.matches("[yn]") && input.length() == 1) {
            switch (input) {
                case "y" -> {
                    this.againstBot = true;
                }
                case "n" -> {
                    this.againstBot = false;
                }
            }
        } else {
            System.out.println("Input was invalid, please try again.");
            chooseMode();
        }
    }
    
    private void chooseTurnOrder() {
        System.out.println("Who goes first? Enter x for player one or y for player two/bot.[x/y]: ");
        String input = scanner.nextLine();
        input = input.toLowerCase();
        if (input.matches("[xy]") && input.length() == 1) {
            switch (input) {
                case "x" -> {
                    this.defaultOrder = true;
                }
                case "y" -> {
                    this.defaultOrder = false;
                }
            }
        } else {
            System.out.println("Input was invalid, please try again.");
            chooseTurnOrder();
        }
    }
    
    public void startGame() {
        clear();
        // print board
        // get input/turn
        // check for problems
        // process
        // check for wins (after 3 turns)
        // back to input
    }

    public class Board {
        private BoardEntry[][] board;

        public Board() {
            this.board = new BoardEntry[3][3];
        }

        public void setEntry(BoardEntry boardEntry) {
            int x = boardEntry.getPosition()[0];
            int y = boardEntry.getPosition()[1];
            this.board[x][y] = boardEntry;
        }

        public BoardEntry getEntry(int x, int y) {
            return this.board[x][y];
        }
    }

    public interface BoardEntry {
        public void setPositon(int x, int y);

        public int[] getPosition();

        public boolean isBoardType(Type type);
    }
    
    public class O implements BoardEntry {
        private int[] position;

        public O(int x, int y) {
            this.position = new int[2];
            setPositon(x, y);
        }

        @Override
        public void setPositon(int x, int y) {
            this.position[0] = x;
            this.position[1] = y;
        }

        @Override
        public int[] getPosition() {
            return this.position;
        }

        @Override
        public boolean isBoardType(Type type) {
            return getClass().equals(type);
        }

        @Override
        public boolean equals(Object other) {
            if (other instanceof O) {
                return this.position.equals(((O) other).getPosition());
            } else
                return false;
        }
    }
    
    public class X implements BoardEntry {
        private int[] position;

        public X(int x, int y) {
            this.position = new int[2];
            setPositon(x, y);
        }

        @Override
        public void setPositon(int x, int y) {
            this.position[0] = x;
            this.position[1] = y;
        }

        @Override
        public int[] getPosition() {
            return this.position;
        }

        @Override
        public boolean isBoardType(Type type) {
            return getClass().equals(type);
        }

        @Override
        public boolean equals(Object other) {
            if (other instanceof X) {
                return this.position.equals(((X) other).getPosition());
            } else
                return false;
        }
    }
}
