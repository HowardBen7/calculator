package calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCalculator implements ActionListener {

    // Declare components
    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[4];
    JButton addButton, subButton, mulButton, divButton;
    JButton delButton, clrButton, eqlButton;
    JPanel panel;

    // Variables to perform calculations
    double num1=0, num2=0, result=0;
    char operator;

    public SimpleCalculator() {
        // Create frame
        frame = new JFrame("Calculator");
        // Create text field
        textField = new JTextField();

        // Initialize buttons
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        eqlButton = new JButton("=");
        delButton = new JButton("Delete");
        clrButton = new JButton("Clear");

        // Add function buttons to array
        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;

        // Initialize number buttons and add action listeners
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
        }

        // Add action listeners to function buttons
        for (JButton button : functionButtons) {
            button.addActionListener(this);
        }

        // Add action listeners to delete, clear, and equals buttons
        delButton.addActionListener(this);
        clrButton.addActionListener(this);
        eqlButton.addActionListener(this);

        // Create panel and set layout
        panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        // Add buttons to panel
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(clrButton);
        panel.add(numberButtons[0]);
        panel.add(eqlButton);
        panel.add(divButton);

        // Set bounds for text field and panel
        textField.setBounds(50, 25, 300, 50);
        panel.setBounds(50, 100, 300, 300);

        // Add text field and panel to frame
        frame.add(textField);
        frame.add(panel);

        // Set frame properties
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 450);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // Create calculator
        new SimpleCalculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Append number to text field when number button is pressed
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }

        // Store the first number and set operator
        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }

        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }

        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }

        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }

        // Perform operation
        if (e.getSource() == eqlButton) {
            num2 = Double.parseDouble(textField.getText());
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }
            textField.setText(String.valueOf(result));
            num1 = result;
        }

        // Clear text field
        if (e.getSource() == clrButton) {
            textField.setText("");
        }

        // Delete last character
        if (e.getSource() == delButton) {
            String string = textField.getText();
            textField.setText("");
            for (int i = 0; i < string.length() - 1; i++) {
                textField.setText(textField.getText() + string.charAt(i));
            }
        }
    }
}