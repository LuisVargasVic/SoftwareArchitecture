public class FirstOperandState implements State {
	public void insertSymbol(CalculadoraGUI view, String sourceButton) {
        if (view.getSymbol(sourceButton) == "number") {
            view.operand1 = view.operand1 + sourceButton;
            view.setDisplay(view.operand1);
        } else if (view.getSymbol(sourceButton) == "operator") {
            view.operator = sourceButton;
            view.setDisplay(view.operand1 + view.operator);
            view.currentState = view.secondOperandState;
            view.state = 2;
        }else if (view.getSymbol(sourceButton) == "clean") {
            view.setDisplay("");
            view.resetCalculator();
        }
    }
}