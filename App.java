package TrabalhoAlest_CalculadoraExpressões;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();
        Fiscalizador fiscalizador;
        Scanner in = new Scanner(System.in);
        System.out.println("Lista ALEST (1)");
        System.out.println("Inserir uma expressão (2)");
        int x = in.nextInt();
        switch (x) {
            case 1:

                String[] expressoes = 
                { 
                    "{ ( 3  + 7  ) - [ ( 10 - 8 ) + 2  ] }",
                    "{ ( 10 +  6 ] * [ (4   ˆ 3 ) - 8  ] }", 
                    "{ ( 15 - 5  ) + [ ( 6  * 3 ) - 12 ] }",
                    "{ ( 4  * 6  ) / [ ( 20 / 5 ) ˆ 2  ] }",
                    "{ ( 15 / 3  ) - [ )12  - 9 ) / 3  ] }",
                    "{ ( 15 - 5  ) + { ( 6  * 3 ) - 12 ] }",
                    "{ ( 10 / 2  ) * [ ( 9  + 3 ) / 2  ] }",
                    "{ ( 8  - 4  ) + [ ( 7  - 4 ) * 10 ] }",
                    "{ ( 10 / 2  ) * [ ( 9  + 3 ) / 2  } }",
                    "{ ( 2  + 3  ) ˆ [ ( 6  / 2 ) * 5  ] }" ,
                    "{ ( 2  * 1  ) ^ [ ( 17 - 5 ) - 10 ] } ",
                    "{ ( 15 / 3  ) - [ (12  - 9 ) / 3  ] } ",
                    "{ ( 12  ^ 2 ) / [ (5   * 17) - 5  ] } ",
                    "{ [ 3  + 7  ) - [ ( 10 - 8 ) + 2  ] } ",
                    "{ ( 10 +  6 ) * [ (4   ˆ 3 ) - 8  ] } ",
                    "{ ( 2  * 1  ) ^ [ ( 17 - 5 ) - 10 ] ] ",
                    "{ ( 10 / 2  ) * [ ( 9  + 3 ) / 2  ] }"
                };
                   
                for (int cont = 0; cont< expressoes.length; cont++) {
                    System.out.println("Questão " + (cont+1));
                    fiscalizador = new Fiscalizador();
                    fiscalizador.contagemAssociadores(expressoes[cont]);
                    if(fiscalizador.tipoDeErro()) {
                        try {
                            double resultado = calculadora.Calculando(expressoes[cont]);
                            System.out.println("Resultado: "  + resultado);
                        } catch (Exception e) {
                            System.out.println("Erro validando a expressão: " + e.getMessage());
                        } 
                    }
                }
                break;
            
            case 2:
                fiscalizador = new Fiscalizador();
                in.nextLine();
                System.out.println("Insira a sua Expressão:");
                String expressão = in.nextLine();
                fiscalizador.contagemAssociadores(expressão);
                if (fiscalizador.tipoDeErro()) {
                    try {
                        double resultado = calculadora.Calculando(expressão);
                        System.out.println("Resultado: " + resultado);
                    } catch (Exception e) {
                        System.out.println("Erro validando a expressão: " + e.getMessage());
                    } 
                }
                break;

            default:
                break;
        }
        in.close();
    }
}
