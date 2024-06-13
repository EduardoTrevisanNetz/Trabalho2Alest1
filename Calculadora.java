package TrabalhoAlest_CalculadoraExpressões;
import java.util.Scanner;

public class Calculadora {
    private Pilha<Double> values = new Pilha<>();
    private Pilha<Character> operators = new Pilha<>();

    public double Calculando(String expression) {
        //transforma a expressao inteira em um array de caracteres
        char[] tokens = expression.toCharArray();
        for (int i = 0; i < tokens.length; i++) {
            // ignora espaços em branco
            if (tokens[i] == ' ')
                continue;
            if (tokens[i] >= '0' && tokens[i] <= '9') {
                StringBuilder String = new StringBuilder();
                while (i < tokens.length && (tokens[i] >= '0' && tokens[i] <= '9' || tokens[i] == '.'))
                 String.append(tokens[i++]);
                values.push(Double.parseDouble(String.toString()));
                i--;
            } else if (tokens[i] == '(') {
                operators.push(tokens[i]);
            } else if (tokens[i] == ')') {
                while (operators.peek() != '(')
                    values.push(Operacoes(operators.pop(), values.pop(), values.pop()));
                operators.pop();
            } else if (tokens[i] == '^' || tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*' || tokens[i] == '/') {
                while (!operators.isEmpty() && Prioritario(tokens[i], operators.peek()))
                    values.push(Operacoes(operators.pop(), values.pop(), values.pop()));
                operators.push(tokens[i]);
            }
        }
        while (!operators.isEmpty())
            values.push(Operacoes(operators.pop(), values.pop(), values.pop()));
        return values.pop();
    }

    private boolean Prioritario(char op1, char op2) {
        if (op2 == '(' || op2 == ')')
            return false;
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
            return false;
        else
            return true;
    }

    private double Operacoes(char op, double b, double a) {
        switch (op) {
            case '^':
                return Math.pow(a, b);
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0)
                    throw new UnsupportedOperationException("Não é possivel divisão por 0");
                return a / b;
        }
        return 0;
    }
}
