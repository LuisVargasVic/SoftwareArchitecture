public class InitState implements State {
	public void insertSymbol(CalculadoraGUI view, String sourceButton) {
    	
        if (view.getSymbol(sourceButton) == "number") {
            view.resetCalculator();
            view.operand1 = view.operand1 + sourceButton;
            view.setDisplay(view.operand1);
            view.currentState = view.firstOperandState;
            view.state = 1;
        } else if (view.getSymbol(sourceButton) == "clean") {
            view.setDisplay("");
            view.resetCalculator();
        }
	}
}