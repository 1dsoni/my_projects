/*
project code for RAT institute.
calculator :: operations on POSITIVE integers only !!
author :: diwanshu soni
 */

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class SimpleCalcForRAT extends JFrame {

	private JPanel contentPane;
	private String inputExpression="",temp = "";
	private JTextArea text ;
	private int flagA=0,flagS=0,flagM=0,flagD=0,flagMod=0,flagPow=0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SimpleCalcForRAT frame = new SimpleCalcForRAT();
					frame.setTitle("Simple Calc by RAT student");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SimpleCalcForRAT() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 353, 382);
		contentPane = new JPanel();
		contentPane.setForeground(Color.GREEN);
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setContentPane(contentPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Cambria Math", Font.PLAIN, 18));
		textArea.setBackground(Color.LIGHT_GRAY);
		textArea.setEditable(false);
		
		JButton btnNewButton = new JButton("c");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				temp="";
				setTextboxValue("");
			}
		});
		
		JButton btnNewButton_1 = new JButton("1");
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setTextboxValue(arg0.getActionCommand());
			}
		});
		
		JButton btnNewButton_2 = new JButton("4");
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setTextboxValue(arg0.getActionCommand());
			}
		});
		
		JButton btnNewButton_3 = new JButton("7");
		btnNewButton_3.setBackground(Color.WHITE);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setTextboxValue(arg0.getActionCommand());
			}
		});
		
		JButton btnNewButton_4 = new JButton("2");
		btnNewButton_4.setBackground(Color.WHITE);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setTextboxValue(arg0.getActionCommand());
			}
		});
		
		JButton btnNewButton_5 = new JButton("5");
		btnNewButton_5.setBackground(Color.WHITE);
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setTextboxValue(arg0.getActionCommand());
			}
		});
		
		JButton btnNewButton_6 = new JButton("8");
		btnNewButton_6.setBackground(Color.WHITE);
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setTextboxValue(arg0.getActionCommand());
			}
		});
		
		JButton btnNewButton_7 = new JButton("3");
		btnNewButton_7.setBackground(Color.WHITE);
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setTextboxValue(arg0.getActionCommand());
			}
		});
		
		JButton btnNewButton_8 = new JButton("6");
		btnNewButton_8.setBackground(Color.WHITE);
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setTextboxValue(arg0.getActionCommand());
			}
		});
		
		JButton btnNewButton_9 = new JButton("9");
		btnNewButton_9.setBackground(Color.WHITE);
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setTextboxValue(arg0.getActionCommand());
			}
		});
		
		JButton btnNewButton_11 = new JButton("0");
		btnNewButton_11.setBackground(Color.WHITE);
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setTextboxValue(arg0.getActionCommand());
			}
		});
		
		JButton btnNewButton_12 = new JButton("+");
		btnNewButton_12.setBackground(Color.WHITE);
		btnNewButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				flagA++;
				checkIt();
				setTextboxValue(arg0.getActionCommand());
			}
		});
		
		JButton btnNewButton_13 = new JButton("x");
		btnNewButton_13.setBackground(Color.WHITE);
		btnNewButton_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				flagM++;
				checkIt();
				setTextboxValue(arg0.getActionCommand());
			}
		});
		
		JButton btnNewButton_14 = new JButton("-");
		btnNewButton_14.setBackground(Color.WHITE);
		btnNewButton_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				flagS++;
				checkIt();
				setTextboxValue(arg0.getActionCommand());
			}
		});
		
		JButton btnNewButton_15 = new JButton("/");
		btnNewButton_15.setBackground(Color.WHITE);
		btnNewButton_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				flagD++;
				checkIt();
				setTextboxValue(arg0.getActionCommand());
			}
		});
		JButton btnNewButton_16 = new JButton("%");
		btnNewButton_16.setBackground(Color.WHITE);
		btnNewButton_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				flagMod++;
				checkIt();
				setTextboxValue(arg0.getActionCommand());
			}
		});
		
		JButton btnNewButton_17 = new JButton("^");
		btnNewButton_17.setBackground(Color.WHITE);
		btnNewButton_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				flagPow++;
				checkIt();
				setTextboxValue(arg0.getActionCommand());
			}
		});
		
		JButton btnNewButton_10 = new JButton("=");
		btnNewButton_10.setBackground(Color.GREEN);
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(flagA+flagS+flagM+flagD+flagMod+flagPow==1){
				parseExpression();
				flagA=0;flagS=0;flagM=0;flagD=0;flagMod=0;flagPow=0;
				}else{
					text.setText("error in Syntax! press C to clear");
				}
			}
		});
		
		text = textArea;
		
		JLabel lblNewLabel = new JLabel("works on POSITIVE INTEGERS ONLY\r\n");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel_1 = new JLabel("CALC v1");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(21)
							.addComponent(btnNewButton))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(66)
							.addComponent(btnNewButton_11)
							.addGap(6)
							.addComponent(btnNewButton_10))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(21)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnNewButton_1)
									.addGap(6)
									.addComponent(btnNewButton_4)
									.addGap(6)
									.addComponent(btnNewButton_7))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnNewButton_2)
									.addGap(6)
									.addComponent(btnNewButton_5)
									.addGap(6)
									.addComponent(btnNewButton_8))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnNewButton_3)
									.addGap(6)
									.addComponent(btnNewButton_6)
									.addGap(6)
									.addComponent(btnNewButton_9)))
							.addGap(46)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnNewButton_16, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnNewButton_12, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnNewButton_13, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnNewButton_14, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton_15, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton_17, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(58)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(21)
							.addComponent(textArea)))
					.addContainerGap(31, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(131, Short.MAX_VALUE)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
					.addGap(135))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(22)
					.addComponent(textArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(btnNewButton)
					.addGap(24)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton_4)
						.addComponent(btnNewButton_7)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnNewButton_13)
							.addComponent(btnNewButton_15)))
					.addGap(6)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton_2)
						.addComponent(btnNewButton_5)
						.addComponent(btnNewButton_8)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnNewButton_12)
							.addComponent(btnNewButton_14)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnNewButton_3)
								.addComponent(btnNewButton_6)
								.addComponent(btnNewButton_9))
							.addGap(6)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnNewButton_11)
								.addComponent(btnNewButton_10, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnNewButton_16)
							.addComponent(btnNewButton_17)))
					.addPreferredGap(ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel)
					.addGap(20))
		);
		contentPane.setLayout(gl_contentPane);
	}
	//-----------------------------------------------design done---------------------------------------------------//
	
	//for checking the correct syntax::not more than single operator to be used at a time.
	private void checkIt(){
		if(flagA+flagS+flagM+flagD+flagMod>1){
			text.setText("Syntax error! press C to clear");
			flagA=0;flagS=0;flagM=0;flagD=0;flagMod=0;
			return;
		}
	}
	
	//this checks for operator and calculates the result
	//by separating the string into 2 double values; num1 and num2 and carries out the math
	private void parseExpression(){
		double num1=0,num2=0;
		String operator="";
		if(temp.indexOf("+")!=-1){
			operator="+";
		}
		else if(temp.indexOf("-")!=-1){
			operator="-";
		}
		else if(temp.indexOf("x")!=-1){
			operator="x";
		}
		else if(temp.indexOf("/")!=-1){
			operator="/";
		}
		else if(temp.indexOf("%")!=-1){
			operator="%";
		}
		else if(temp.indexOf("^")!=-1){
			operator="^";
		}
		else{
			return;
		}
		if(temp.indexOf(operator)==0){
			text.setText("Syntax error! C to clear");
			return;
		}
		if(temp.indexOf(operator)==(temp.length()-1)){
			text.setText("Syntax error! C to clear");
			return;
		}
		num1=Double.parseDouble(temp.substring(0,temp.indexOf(operator)));
		num2=Double.parseDouble(temp.substring(temp.indexOf(operator)+1));
		solveExpression(operator, num1, num2);
	}
	private void setTextboxValue(String exp){
		temp=temp+exp;
		inputExpression=temp;
		text.setText(temp);
	}
	private void solveExpression(String operator,double num1,double num2){
		
		switch(operator){
		case "+":
			temp=""+(num1+num2);
			break;
		case "-":
			temp=""+(num1-num2);
			break;
		case "x":
			temp=""+(num1*num2);
			break;
		case "/":
			try{
				temp=""+(num1/num2);
			}
			catch(Exception e){
				text.setText(inputExpression+" = "+"error division by zero!");
				return;
			}
			
			break;
		case "%":
			temp=""+(Math.abs(num1)%Math.abs(num2));
			break;
		case "^":
			temp=""+(Math.pow(num1, num2));
			break;
		default :
			System.out.println("err");
		}
		text.setText(inputExpression+" = "+temp);
	}
}
