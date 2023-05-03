package dev.testproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI {
    public static void main(String[] args) {
        GUI gui = new GUI(3);
        gui.start();
    }

    private int gui;

    public GUI(int i) {
        this.gui = i;
    }

    public void start() {
        switch (gui) {
            case 1 -> {
                gui1();
            }
            case 2 -> {
                gui2();
            }
            case 3 -> {
                gui3();
            }
            default -> {
                return;
            }
        }
    }

    public void gui1() {
        JFrame frame = new JFrame("Basic GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        JMenuItem menuItem1 = new JMenuItem("Option 1");
        JMenuItem menuItem2 = new JMenuItem("Option 2");
        menu.add(menuItem1);
        menu.add(menuItem2);
        menuBar.add(menu);
        frame.setJMenuBar(menuBar);

        JButton button = new JButton("Click me!");
        frame.getContentPane().add(button);
        frame.setVisible(true);
    }

    public void gui2() {
        JFrame frame = new JFrame("Basic GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("File");
        JMenuItem menuItem1 = new JMenuItem("Open");
        JMenuItem menuItem2 = new JMenuItem("Save");
        menu.add(menuItem1);
        menu.add(menuItem2);
        menuBar.add(menu);
        frame.setJMenuBar(menuBar);

        JPanel mainPanel = new JPanel();
        JButton button = new JButton("Click me!");
        mainPanel.add(button);
        frame.getContentPane().add(mainPanel);

        JPanel openPanel = new JPanel();
        JLabel openLabel = new JLabel("Open page");
        openPanel.add(openLabel);

        JPanel savePanel = new JPanel();
        JLabel saveLabel = new JLabel("Save page");
        savePanel.add(saveLabel);

        CardLayout cardLayout = new CardLayout();
        JPanel cardPanel = new JPanel(cardLayout);
        cardPanel.add(mainPanel, "Main");
        cardPanel.add(openPanel, "Open");
        cardPanel.add(savePanel, "Save");

        menuItem1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Open");
            }
        });

        menuItem2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Save");
            }
        });

        frame.getContentPane().add(cardPanel);
        frame.setVisible(true);
    }

    public void gui3() {
        JFrame frame = new JFrame("Basic GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("File");
        JMenuItem menuItem1 = new JMenuItem("Open");
        JMenuItem menuItem2 = new JMenuItem("Save");
        JMenuItem menuItem3 = new JMenuItem("Stocks");
        menu.add(menuItem1);
        menu.add(menuItem2);
        menu.add(menuItem3);
        menuBar.add(menu);
        frame.setJMenuBar(menuBar);

        JPanel mainPanel = new JPanel();
        JButton button = new JButton("Click me!");
        mainPanel.add(button);
        frame.getContentPane().add(mainPanel);

        JPanel openPanel = new JPanel();
        JLabel openLabel = new JLabel("Open page");
        openPanel.add(openLabel);

        JPanel savePanel = new JPanel();
        JLabel saveLabel = new JLabel("Save page");
        savePanel.add(saveLabel);

        JPanel stocksPanel = new JPanel();
        JLabel stocksLabel = new JLabel("Enter stock ticker:");
        JTextField stocksField = new JTextField(10);
        stocksPanel.add(stocksLabel);
        stocksPanel.add(stocksField);

        CardLayout cardLayout = new CardLayout();
        JPanel cardPanel = new JPanel(cardLayout);
        cardPanel.add(mainPanel, "Main");
        cardPanel.add(openPanel, "Open");
        cardPanel.add(savePanel, "Save");
        cardPanel.add(stocksPanel, "Stocks");

        menuItem1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Open");
            }
        });

        menuItem2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Save");
            }
        });

        menuItem3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Stocks");
            }
        });

        frame.getContentPane().add(cardPanel);
        frame.setVisible(true);
    }
}
