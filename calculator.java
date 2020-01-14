package cp213;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 * public class calculator that contains various instance variables
 * 
 * @author voig4620
 *
 */
public class calculator {

	// instance variables for the calculator
	static double left;
	static double right;
	static double a;
	static String values[] = new String[2];
	static String operator;
	static String out;

	/**
	 * main method that runs all the calculator code (could have been done in the
	 * class but ran into problems with instance variables)
	 * 
	 * @param args
	 */
	public static void main(String args[]) {

		// making the JFrame
		final JFrame f = new JFrame("Calculator");
		f.setSize(600, 750);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// all of the operation buttons needed for calculator
		JButton equalButton = new JButton("=");
		JButton clearButton = new JButton("C");
		JButton plusButton = new JButton("+");
		JButton minusButton = new JButton("-");
		JButton multiplyButton = new JButton("*");
		JButton divideButton = new JButton("/");

		// all of the number buttons needed for calculator
		JButton oneButton = new JButton("1");
		JButton twoButton = new JButton("2");
		JButton threeButton = new JButton("3");
		JButton fourButton = new JButton("4");
		JButton fiveButton = new JButton("5");
		JButton sixButton = new JButton("6");
		JButton sevenButton = new JButton("7");
		JButton eightButton = new JButton("8");
		JButton nineButton = new JButton("9");
		JButton zeroButton = new JButton("0");

		// making a border to make it easier to distinguish the two panels
		Border blackline = BorderFactory.createLineBorder(Color.black);

		// a section of calculator for the equation
		JPanel equation = new JPanel();
		equation.setPreferredSize(new Dimension(200, 250));
		equation.setBorder(blackline);
		equation.setBackground(Color.lightGray);
		JLabel eq = new JLabel();
		eq.setFont(new Font("Lucida Sans", Font.PLAIN, 50));
		equation.add(eq);
		f.add(equation, BorderLayout.PAGE_START);

		// a section of calculator for the answer
		JPanel answer = new JPanel();
		answer.setPreferredSize(new Dimension(200, 250));
		answer.setBorder(blackline);
		answer.setBackground(Color.lightGray);
		JLabel ans = new JLabel();
		ans.setFont(new Font("Lucida Sans", Font.PLAIN, 50));
		answer.add(ans);
		f.add(answer, BorderLayout.CENTER);

		// a section of calculator for the buttons
		JPanel buttons = new JPanel(new GridLayout(4, 5));
		buttons.setPreferredSize(new Dimension(200, 250));

		// row 1 of buttons
		buttons.add(sevenButton);
		buttons.add(eightButton);
		buttons.add(nineButton);
		buttons.add(divideButton);
		buttons.add(clearButton);

		// row 2 of buttons
		buttons.add(fourButton);
		buttons.add(fiveButton);
		buttons.add(sixButton);
		buttons.add(multiplyButton);
		buttons.add(new JButton());

		// row 3 of buttons
		buttons.add(oneButton);
		buttons.add(twoButton);
		buttons.add(threeButton);
		buttons.add(minusButton);
		buttons.add(new JButton());

		// row 4 of buttons
		buttons.add(new JButton());
		buttons.add(zeroButton);
		buttons.add(new JButton());
		buttons.add(plusButton);
		buttons.add(equalButton);

		// adding the final panel to frame and setting the frame to visible
		f.add(buttons, BorderLayout.PAGE_END);
		f.setVisible(true);

		/**
		 * the action listener for the number 0
		 */
		zeroButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String input = eq.getText() + zeroButton.getText();
				eq.setText(input);
			}
		});

		/**
		 * the action listener for the number 1
		 */
		oneButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String input = eq.getText() + oneButton.getText();
				eq.setText(input);
			}
		});

		/**
		 * the action listener for the number 2
		 */
		twoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String input = eq.getText() + twoButton.getText();
				eq.setText(input);
			}
		});

		/**
		 * the action listener for the number 3
		 */
		threeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String input = eq.getText() + threeButton.getText();
				eq.setText(input);
			}
		});

		/**
		 * the action listener for the number 4
		 */
		fourButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String input = eq.getText() + fourButton.getText();
				eq.setText(input);
			}
		});

		/**
		 * the action listener for the number 5
		 */
		fiveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String input = eq.getText() + fiveButton.getText();
				eq.setText(input);
			}
		});

		/**
		 * the action listener for the number 6
		 */
		sixButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String input = eq.getText() + sixButton.getText();
				eq.setText(input);
			}
		});

		/**
		 * the action listener for the number 7
		 */
		sevenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String input = eq.getText() + sevenButton.getText();
				eq.setText(input);
			}
		});

		/**
		 * the action listener for the number 8
		 */
		eightButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String input = eq.getText() + eightButton.getText();
				eq.setText(input);
			}
		});

		/**
		 * the action listener for the number 9
		 */
		nineButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String input = eq.getText() + nineButton.getText();
				eq.setText(input);
			}
		});

		/**
		 * the action listener for the operator plus
		 */
		plusButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					left = Double.parseDouble(eq.getText());
				} catch (NumberFormatException ex) {
					System.out.println("Invalid input, please only enter two numbers seperated by an operator.");
					eq.setText("");
				}
				eq.setText(left + "+");
				operator = "+";
			}
		});

		/**
		 * the action listener for the operator minus
		 */
		minusButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					left = Double.parseDouble(eq.getText());
				} catch (NumberFormatException ex) {
					System.out.println("Invalid input, please only enter two numbers seperated by an operator.");
					eq.setText("");
				}
				eq.setText(left + "-");
				operator = "-";
			}
		});

		/**
		 * the action listener for the operator multiply
		 */
		multiplyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					left = Double.parseDouble(eq.getText());
				} catch (NumberFormatException ex) {
					System.out.println("Invalid input, please only enter two numbers seperated by an operator.");
					eq.setText("");
				}
				eq.setText(left + "×");
				operator = "*";
			}
		});

		/**
		 * the action listener for the operator divide
		 */
		divideButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					left = Double.parseDouble(eq.getText());
				} catch (NumberFormatException ex) {
					System.out.println("Invalid input, please only enter two numbers seperated by an operator.");
					eq.setText("");
				}
				eq.setText(left + "÷");
				operator = "/";
			}
		});

		/**
		 * the action listener for the clear button
		 */
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eq.setText("");
				ans.setText("");
			}
		});

		/**
		 * the action listener for the equal button
		 */
		equalButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// if statements for each possible operator that prints the computation and sets
				// the first number back to 0 (in the case where someone clicks an operator
				// first)
				if (operator.equals("+")) {
					values = eq.getText().split("\\+");
					right = Double.parseDouble(values[1]);
					a = left + right;
					out = Double.toString(a);
					ans.setText(out);
					left = 0;
				} else if (operator.equals("-")) {
					values = eq.getText().split("-");
					right = Double.parseDouble(values[1]);
					a = left - right;
					out = Double.toString(a);
					ans.setText(out);
					left = 0;
				} else if (operator.equals("*")) {
					values = eq.getText().split("×");
					right = Double.parseDouble(values[1]);
					a = left * right;
					out = Double.toString(a);
					ans.setText(out);
					left = 0;
				} else if (operator.equals("/")) {
					values = eq.getText().split("÷");
					right = Double.parseDouble(values[1]);
					a = left / right;
					out = Double.toString(a);
					ans.setText(out);
					left = 0;
				}
			}
		});
	}
}
