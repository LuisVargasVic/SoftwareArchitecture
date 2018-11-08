import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class HexView extends JPanel implements ActionListener {
	ConverterGUI view;
	
    // Components
    JButton btOk, btClear;
    JTextField tfInput;
    
    public HexView(ConverterGUI view) {
        super();
        this.view = view;
        
        // Configure components
        this.setPreferredSize(new Dimension(300, 200));
        this.tfInput = new JTextField();
        this.tfInput.setPreferredSize(new Dimension(280, 30));
        this.btOk = new JButton("OK");
        this.btClear = new JButton("Clear");
        Border border = BorderFactory.createTitledBorder("Hex Number");
        this.setBorder(border);
        this.add(this.tfInput);
        this.add(this.btClear);
        this.add(this.btOk);
        this.btOk.addActionListener(this);
        this.btClear.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e) {
    	String strBtSource = ((JButton) e.getSource()).getText();
    	if(strBtSource == "OK") {
    		String strHexValue = this.tfInput.getText();
    		int decimalValue = Integer.parseInt(strHexValue, 16);
    		this.view.decimalView.tfInput.setText(String.valueOf(decimalValue));
    		this.view.binaryView.tfInput.setText(Integer.toBinaryString(decimalValue));
    	}
    	else if(strBtSource == "Clear") {
    		this.view.binaryView.tfInput.setText("");
    	}
    }
}
