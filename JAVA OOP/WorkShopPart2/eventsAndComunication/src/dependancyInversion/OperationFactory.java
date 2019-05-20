package dependancyInversion;

public class OperationFactory {

    public Operation produce(String operator) {
        Operation operation = null;
        if (operator.equalsIgnoreCase("+")) {
            operation = new Addition();
        } else if (operator.equalsIgnoreCase("-")) {
            operation = new Substract();
        }else if (operator.equalsIgnoreCase("*")) {
            operation = new Multyplication();
        }else if (operator.equalsIgnoreCase("/")) {
            operation = new Division();
        }

        return operation;

    }
}
