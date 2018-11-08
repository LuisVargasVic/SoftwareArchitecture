package observable;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class OctalView extends JPanel implements Observer, ActionListener{
    
	ConverterGUI view;
	
    // Components
    JButton btOk, btClear;
    JTextField tfInput;
    
    public OctalView(ConverterGUI view) {
        super();
        this.view = view;
        
        // Configure components
        this.setPreferredSize(new Dimension(300, 200));
        this.tfInput = new JTextField();
        this.tfInput.setPreferredSize(new Dimension(280, 30));
        this.btOk = new JButton("OK");
        this.btClear = new JButton("Clear");
        Border border = BorderFactory.createTitledBorder("Octal Number");
        this.setBorder(border);
        this.add(this.tfInput);
        this.add(this.btClear);
        this.add(this.btOk);
        this.btOk.addActionListener(this);
        this.btClear.addActionListener(this);
    }
    
    public void update() {
    	int decimalValue = this.view.decimalNumber.getValue();
    	this.tfInput.setText(Integer.toOctalString(decimalValue));
    }
    
    public void actionPerformed(ActionEvent e) {
    	String strBtSource = ((JButton) e.getSource()).getText();
    	if(strBtSource == "OK") {
    		String strOctalValue = this.tfInput.getText();
    		int decimalValue = Integer.parseInt(strOctalValue, 8);
    		this.view.decimalNumber.setValue(decimalValue);
    	}
    	else if(strBtSource == "Clear") {
    		this.view.octalView.tfInput.setText("");
    	}
    }
}
