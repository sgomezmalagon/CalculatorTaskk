package com.example.calculadora;

import java.util.Stack;

public class CalculatorEngine {

    private StringBuilder currentExpression;
    private String result;
    private boolean lastWasOperator;
    private boolean showingResult;

    public CalculatorEngine() {
        currentExpression = new StringBuilder();
        result = "";
        lastWasOperator = false;
        showingResult = false;
    }

    public void appendNumber(String number) {
        // Si estamos mostrando un resultado, limpiar y empezar nueva operación
        if (showingResult) {
            currentExpression.setLength(0);
            showingResult = false;
        }

        // Manejar punto decimal
        if (number.equals(".")) {
            // Evitar múltiples puntos decimales en el mismo número
            String lastNumber = getLastNumber();
            if (lastNumber.contains(".")) {
                return;
            }
            // Si es el primer carácter o después de un operador, agregar 0.
            if (currentExpression.length() == 0 || lastWasOperator) {
                currentExpression.append("0");
            }
        }

        currentExpression.append(number);
        lastWasOperator = false;
    }

    public void appendOperator(String operator) {
        // Si estamos mostrando un resultado, usar ese resultado para la siguiente operación
        if (showingResult && !result.equals("Error")) {
            currentExpression.setLength(0);
            currentExpression.append(result);
            showingResult = false;
        }

        // No permitir operadores al inicio (excepto paréntesis y menos)
        if (currentExpression.length() == 0 && !operator.equals("(") && !operator.equals("-")) {
            return;
        }

        // Manejar paréntesis
        if (operator.equals("(") || operator.equals(")")) {
            currentExpression.append(operator);
            lastWasOperator = operator.equals("(");
            return;
        }

        // No permitir operadores consecutivos (excepto después de paréntesis de cierre)
        if (lastWasOperator && currentExpression.length() > 0) {
            char lastChar = currentExpression.charAt(currentExpression.length() - 1);
            if (lastChar != ')') {
                // Reemplazar el último operador
                currentExpression.setLength(currentExpression.length() - 1);
            }
        }

        currentExpression.append(operator);
        lastWasOperator = true;
    }

    public void calculate() {
        if (currentExpression.length() == 0) {
            return;
        }

        try {
            String expression = currentExpression.toString();
            double res = evaluateExpression(expression);

            // Formatear el resultado
            if (res == (long) res) {
                result = String.valueOf((long) res);
            } else {
                result = String.valueOf(res);
            }

            showingResult = true;
            lastWasOperator = false;
        } catch (Exception e) {
            result = "Error";
            showingResult = true;
        }
    }

    public void clear() {
        currentExpression.setLength(0);
        result = "";
        lastWasOperator = false;
        showingResult = false;
    }

    public String getDisplayText() {
        if (showingResult) {
            return result;
        }
        return currentExpression.length() > 0 ? currentExpression.toString() : "0";
    }

    private String getLastNumber() {
        String expr = currentExpression.toString();
        int i = expr.length() - 1;

        while (i >= 0) {
            char c = expr.charAt(i);
            if (c == '+' || c == '-' || c == '*' || c == '/' || c == '(' || c == ')') {
                break;
            }
            i--;
        }

        return expr.substring(i + 1);
    }

    // Evaluar expresión matemática usando el algoritmo Shunting Yard
    private double evaluateExpression(String expression) throws Exception {
        // Convertir expresión infija a postfija
        String postfix = infixToPostfix(expression);
        // Evaluar expresión postfija
        return evaluatePostfix(postfix);
    }

    private String infixToPostfix(String expression) throws Exception {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            // Si es un dígito o punto decimal, agregarlo al resultado
            if (Character.isDigit(c) || c == '.') {
                result.append(c);
            }
            // Si es un paréntesis izquierdo, agregarlo a la pila
            else if (c == '(') {
                result.append(' ');
                stack.push(c);
            }
            // Si es un paréntesis derecho
            else if (c == ')') {
                result.append(' ');
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop()).append(' ');
                }
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    throw new Exception("Paréntesis no balanceados");
                }
            }
            // Si es un operador
            else if (isOperator(c)) {
                result.append(' ');
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    result.append(stack.pop()).append(' ');
                }
                stack.push(c);
            }
        }

        // Agregar espacio final para el último número
        result.append(' ');

        // Vaciar la pila
        while (!stack.isEmpty()) {
            char op = stack.pop();
            if (op == '(' || op == ')') {
                throw new Exception("Paréntesis no balanceados");
            }
            result.append(op).append(' ');
        }

        return result.toString().trim();
    }

    private double evaluatePostfix(String expression) throws Exception {
        Stack<Double> stack = new Stack<>();
        String[] tokens = expression.split("\\s+");

        for (String token : tokens) {
            if (token.isEmpty()) {
                continue;
            }

            // Si es un número, agregarlo a la pila
            if (token.matches("-?\\d+(\\.\\d+)?")) {
                stack.push(Double.parseDouble(token));
            }
            // Si es un operador
            else if (isOperator(token.charAt(0))) {
                if (stack.size() < 2) {
                    throw new Exception("Expresión inválida");
                }

                double b = stack.pop();
                double a = stack.pop();
                double result = 0;

                switch (token.charAt(0)) {
                    case '+':
                        result = a + b;
                        break;
                    case '-':
                        result = a - b;
                        break;
                    case '*':
                        result = a * b;
                        break;
                    case '/':
                        if (b == 0) {
                            throw new Exception("División por cero");
                        }
                        result = a / b;
                        break;
                }

                stack.push(result);
            }
        }

        if (stack.size() != 1) {
            throw new Exception("Expresión inválida");
        }

        return stack.pop();
    }

    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    private int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return 0;
        }
    }
}

