import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class CalculadoraGUI extends JFrame{

    /**
	 * Serial Version
	 */
	private static final long serialVersionUID = 1L;
	private JButton[] btnNumbers, btnOperands;
    private JButton erase, solve;
    private JTextArea txtDisplay;
    // Model
	String operand1, operand2, operator;
	State initState;
    State firstOperandState;
    State secondOperandState;
	State currentState;
	int state;
    
    
    public CalculadoraGUI() {
        super();
		Controller controller = new Controller(this);
		this.initState = new InitState();
		this.firstOperandState = new FirstOperandState();
		this.secondOperandState = new SecondOperandState();
		this.currentState = this.initState;
		this.state = 0;
        this.setTitle("Simple Binary Calculator");
        this.resetCalculator();
        this.setBounds(100, 100, 500, 457);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);
        this.getContentPane().setBackground(Color.decode("#5e5d5d"));
        
        // Number Buttons
        this.btnNumbers = new JButton[11];
        
        int cont = 0;
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 3; j++){
                if(cont >= 10){
                    break;
                }
                this.btnNumbers[cont] = new JButton((cont == 9)? "0":cont+1+"");
                this.btnNumbers[cont].setBounds(40 +j*62, 130+i*62, 60, 60);
                this.btnNumbers[cont].setBackground(Color.decode("#424141"));
                this.btnNumbers[cont].setForeground(Color.black);
                this.btnNumbers[cont].setFocusPainted(false);
                this.btnNumbers[cont].addActionListener(controller);
                this.getContentPane().add(this.btnNumbers[cont++]);
            }
        }
        
        // Operator Buttons
        this.btnOperands = new JButton[5];
        this.btnOperands[0] = new JButton("*");
        this.btnOperands[1] = new JButton("/");
        this.btnOperands[2] = new JButton("+");
        this.btnOperands[3] = new JButton("-");
        this.btnOperands[4] = new JButton("^");
        
        cont = 0;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 2; j++){
                if(cont >= this.btnOperands.length){
                    break;
                }
                this.btnOperands[cont].setBounds(300 +j*62, 192+i*62, 60, 60);
                this.btnOperands[cont].setBackground(Color.decode("#424141"));
                this.btnOperands[cont].setForeground(Color.black);
                this.btnOperands[cont].setFocusPainted(false);
                this.btnOperands[cont].addActionListener(controller);
                this.getContentPane().add(this.btnOperands[cont++]);
            }
        }
        
        // AC and Equal Buttons
        this.erase = new JButton("AC");
        this.erase.setBounds(362, 130, 60, 60);
        this.erase.setBackground(Color.decode("#424141"));
        this.erase.setForeground(Color.black);
        this.erase.setFocusPainted(false);
        this.erase.addActionListener(controller);
        this.getContentPane().add(this.erase);
        
        
        this.solve = new JButton("=");
        this.solve.setBounds(362, 316, 60, 60);
        this.solve.setBackground(Color.decode("#424141"));
        this.solve.setForeground(Color.black);
        this.solve.setFocusPainted(false);
        this.solve.addActionListener(controller);
        this.getContentPane().add(this.solve);
        
        
        // TextField Display
        
        this.txtDisplay = new JTextArea();
        this.txtDisplay.setBounds(43, 25, 400, 85);
        this.txtDisplay.setBackground(Color.decode("#ffffff"));
        this.txtDisplay.setFont(new Font("normal", Font.BOLD, 28));
        getContentPane().add(this.txtDisplay);
        this.txtDisplay.setEditable(false);
        
        this.setVisible(true);
    }
    
    protected void setDisplay(String text) {
    	this.txtDisplay.setText(text);
    }
    
    protected void resetCalculator() {
    	this.operand1 = "";
    	this.operand2 = "";
		this.currentState = this.initState;
		this.state = 0;
	}
	
	protected String getSymbol(String sourceButton) {
		if (sourceButton == "AC") {
			return "clean";
		} else if (sourceButton == "+"
		|| sourceButton == "-"|| sourceButton == "*"
		|| sourceButton == "/"|| sourceButton == "^") {
			return "operator";
		} else if (sourceButton == "=") {
			return "equal";
		} else {
			return "number";
		}
	}
    
    static class Controller implements ActionListener{
    	CalculadoraGUI view;
    	
    	public Controller(CalculadoraGUI view) {
    		this.view = view;
    	}
    	
    	public void actionPerformed(ActionEvent e) {
    		String sourceButton = ((JButton) e.getSource()).getText();
    		switch(this.view.state) {
			case 0:	// Initial State
				this.view.currentState.insertSymbol(this.view, sourceButton);
    			break;
			case 1:	// Capturing First Operand State
				this.view.currentState.insertSymbol(this.view, sourceButton);
    			break;
    		case 2:	// Capturing Second Operand State
				this.view.currentState.insertSymbol(this.view, sourceButton);
    			break;
    		}
		}
    }
    
    public static void main(String[] args) {
        new CalculadoraGUI();
    }
}
