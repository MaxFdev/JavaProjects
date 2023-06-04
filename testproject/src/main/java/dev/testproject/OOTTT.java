package dev.testproject;

import java.lang.reflect.Type;
import java.util.*;

public class OOTTT {
    public static void main(String[] args) {
        startUp();
        OOTTT game = new OOTTT();
        game.chooseMode();
        game.chooseTurnOrder();
        game.chooseHelp();
        game.startGame();
    }
    
    public static void startUp() {
        String print = 
        " ________  __                  ________                          ________                   " + "\n" +
        "|        \\|  \\                |        \\                        |        \\                  " + "\n" +
        " \\$$$$$$$$ \\$$  _______        \\$$$$$$$$______    _______        \\$$$$$$$$______    ______  " + "\n" +
        "   | $$   |  \\ /       \\         | $$  |      \\  /       \\         | $$  /      \\  /      \\ " + "\n" +
        "   | $$   | $$|  $$$$$$$         | $$   \\$$$$$$\\|  $$$$$$$         | $$ |  $$$$$$\\|  $$$$$$\\" + "\n" +
        "   | $$   | $$| $$               | $$  /      $$| $$               | $$ | $$  | $$| $$    $$" + "\n" +
        "   | $$   | $$| $$_____          | $$ |  $$$$$$$| $$_____          | $$ | $$__/ $$| $$$$$$$$" + "\n" +
        "   | $$   | $$ \\$$     \\         | $$  \\$$    $$ \\$$     \\         | $$  \\$$    $$ \\$$     \\" + "\n" +
        "    \\$$    \\$$  \\$$$$$$$          \\$$   \\$$$$$$$  \\$$$$$$$          \\$$   \\$$$$$$   \\$$$$$$$" + "\n\n";
        System.out.print("\u001B[32m");
        for (char c : print.toCharArray()) {
            System.out.print(c);
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
                throw new RuntimeException("Something went wrong.");
            }
        }
        System.out.print("\033[0m");
    }

    public static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    
    private Scanner scanner;
    private boolean againstBot;
    private boolean hardBot;
    private boolean defaultOrder;
    private boolean needHelp;
    private Board board;
    
    public OOTTT() {
        this.scanner = new Scanner(System.in);
        this.againstBot = false;
        this.defaultOrder = true;
        this.board = new Board();
    }

    public void chooseMode() {
        System.out.println("Do you want to play against a bot?[y/n]: ");
        String input = this.scanner.nextLine();
        input = input.toLowerCase();
        if (input.matches("[yn]") && input.length() == 1) {
            switch (input) {
                case "y" -> {
                    this.againstBot = true;
                    getBotDiffculty();
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

    public void getBotDiffculty() {
        System.out.println("Do you want to play against the hard bot?[y/n]: ");
        String input = this.scanner.nextLine();
        input = input.toLowerCase();
        if (input.matches("[yn]") && input.length() == 1) {
            switch (input) {
                case "y" -> {
                    this.hardBot = true;
                }
                case "n" -> {
                    this.hardBot = false;
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

    public void chooseHelp() {
        System.out.println("Do you want to learn how to play?[y/n]: ");
        String input = this.scanner.nextLine();
        input = input.toLowerCase();
        if (input.matches("[yn]") && input.length() == 1) {
            switch (input) {
                case "y" -> {
                    this.needHelp = true;
                }
                case "n" -> {
                    this.needHelp = false;
                }
            }
        } else {
            System.out.println("Input was invalid, please try again.");
            chooseHelp();
        }
    }
    
    public void startGame() {
        clear();
        if (this.needHelp) {
            help();
        }
        // print board
        // get input/turn (make bot, easy and hard version)
        // check for problems
        // process
        // check for wins (after 3 turns)
        // back to input or end game
        // restart or exit
    }

    public void help() {
        // make a help screen
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
            } else {
                return false;
            }
        }

        @Override
        public String toString() {
            return "O";
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
            } else{
                return false;
            }
        }

        @Override
        public String toString() {
            return "X";
        }
    }
}
