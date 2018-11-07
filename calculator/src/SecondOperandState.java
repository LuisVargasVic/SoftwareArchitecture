public class SecondOperandState implements State {
	public void insertSymbol(CalculadoraGUI view, String sourceButton) {
        if (view.getSymbol(sourceButton) == "number") {    
            view.operand2 = view.operand2 + sourceButton;
            view.setDisplay(view.operand1 + view.operator + view.operand2);
        } else if (view.getSymbol(sourceButton) == "equal") {
            view.setDisplay(view.operand1 + view.operator + view.operand2 + "=" + doOperation(view));
    		view.resetCalculator();
        } else if (view.getSymbol(sourceButton) == "clean") {
            view.setDisplay("");
    		view.resetCalculator();
        }
    }

    protected String doOperation(CalculadoraGUI view) {
        int oper1 = Integer.valueOf(view.operand1);
        int oper2 = Integer.valueOf(view.operand2);
        String result = "";
        switch(view.operator) {
        case "+":
            result = Integer.toString(oper1 + oper2);
            break;
        case "-":
            result = Integer.toString(oper1 - oper2);
            break;
        case "*":
            result = Integer.toString(oper1 * oper2);
            break;
        case "/":
            if(oper2 == 0) {
                result = "INF";
            }	
            else {
                result = Integer.toString(oper1 / oper2);
            }
            break;
        case "^":
            result = Integer.toString(oper1 ^ oper2);
            break;
        }
        return result;
}
}