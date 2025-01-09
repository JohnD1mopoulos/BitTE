package com.BitTE.OptimizationProject;

import java.util.InputMismatchException;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CreateSuitcase {

    private static CreateSuitcase instance;
    private double maxVolume;
    private double maxWeight;
    private JFrame frame;
    private JTextField weightField, lengthField, widthField, heightField;
    private JButton submitButton;
    
    public CreateSuitcase() {
        createAndShowGUI();
        maxVolume = 0;
        maxWeight = 0;
    }
    
    private void createAndShowGUI() {
        frame = new JFrame("Create Suitcase");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(5, 2));

        weightField = new JTextField(10);
        lengthField = new JTextField(10);
        widthField = new JTextField(10);
        heightField = new JTextField(10);

        // Adding a focus listener to validate the weight input
        weightField.addFocusListener(new FocusAdapter() {
            public void focusLost(FocusEvent e) {
                try {
                    double maxWeight = Double.parseDouble(weightField.getText());
                    if (maxWeight <= 0) {
                        JOptionPane.showMessageDialog(frame, "Please enter a positive value for weight.", "Input Error", JOptionPane.ERROR_MESSAGE);
                        weightField.requestFocus();
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid number for weight.", "Input Error", JOptionPane.ERROR_MESSAGE);
                    weightField.requestFocus();
                }
            }
        });

        frame.add(new JLabel("Weight (grams):"));
        frame.add(weightField);
        frame.add(new JLabel("Length (cm):"));
        frame.add(lengthField);
        frame.add(new JLabel("Width (cm):"));
        frame.add(widthField);
        frame.add(new JLabel("Height (cm):"));
        frame.add(heightField);

        submitButton = new JButton("Calculate Volume and Weight");
        submitButton.addActionListener(e -> calculateVolumeAndWeight());
        frame.add(submitButton);

        frame.pack();
        frame.setVisible(true);
    }
    
    private void calculateVolumeAndWeight() {
        try {
            double maxWeight = Double.parseDouble(weightField.getText());
            double length = Double.parseDouble(lengthField.getText());
            double width = Double.parseDouble(widthField.getText());
            double height = Double.parseDouble(heightField.getText());
            if (maxWeight > 0 && length > 0 && width > 0 && height > 0) {
                double maxVolume = length * width * height;
                JOptionPane.showMessageDialog(frame, "Max Weight: " + maxWeight + " grams\nMax Volume: " + maxVolume + " cubic cm");
            } else {
                JOptionPane.showMessageDialog(frame, "Please enter positive values for weight, length, width, and height.", "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Please enter valid numbers", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static CreateSuitcase getInstance() {
        if (instance == null) {
            instance = new CreateSuitcase();
        }
        return instance;
    }

    public double getMaxVolume() {
        return maxVolume;
    }

    public double getMaxWeight() {
        return maxWeight;
    }
}