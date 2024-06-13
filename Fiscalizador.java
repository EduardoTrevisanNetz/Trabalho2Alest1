package TrabalhoAlest_CalculadoraExpressões;
public class Fiscalizador {
    //contadores parenteses
    private int qtdParI = 0; 
    private int qtdParV = 0;
    //contadores colchetes
    private int qtdColI = 0;
    private int qtdColV = 0;
    //contadores chaves
    private int qtdChaI = 0;
    private int qtdChaV = 0;
    // variáveis de erro
    private int erroPar;
    private int erroCol;
    private int erroCha;

    //percorrer a equação e levantar a qtd de (, ), [, ], { e }
    public void contagemAssociadores(String equação){
        for (int i = 0; i < equação.length(); i++) {
            char caractere = equação.charAt(i);
            switch(caractere) {
                case '(':
                    qtdParI++;
                    break;

                case ')':
                    qtdParV++;
                    break;

                case '{':
                    qtdChaI++;
                    break;

                case '}':
                    qtdChaV++;
                    break;

                case '[':
                    qtdColI++;
                    break;

                case ']':
                    qtdColV++;
                    break;

                default:
                    break;
            }
        }
        //atualizar as variaveis pra posteriormente identificar o erro
        erroPar = qtdParI - qtdParV;
        erroCol = qtdColI - qtdColV;
        erroCha = qtdChaI - qtdChaV;
    }

    public boolean tipoDeErro() {
        if ((erroPar == 0) && (erroCol == 0) && (erroCha == 0)) { // 000
            System.out.println("Os sinais de associação estão justos");
            return true;
        } else if ((erroPar == 0) && (erroCol == 0) && (erroCha > 0)) { // 00>0
            System.out.println("Há { sem }.");
            return false;
        } else if ((erroPar == 0) && (erroCol == 0) && (erroCha < 0)) { // 00<0
            System.out.println("Há } sem {.");
            return false;
        } else if ((erroPar == 0) && (erroCol > 0) && (erroCha == 0)) { // 0>00
            System.out.println("Há [ sem ].");
            return false;
        } else if ((erroPar == 0) && (erroCol < 0) && (erroCha == 0)) { // 0<00
            System.out.println("Há ] sem [.");
            return false;
        } else if ((erroPar == 0) && (erroCol > 0) && (erroCha > 0)) { // 0>0>0
            System.out.println("Há [ sem ] e { sem }.");
            return false;
        } else if ((erroPar == 0) && (erroCol < 0) && (erroCha < 0)) { // 0<0<0
            System.out.println("Há ] sem [ e } sem {.");
            return false;
        } else if ((erroPar == 0) && (erroCol > 0) && (erroCha < 0)) { // 0>0<0
            System.out.println("Possivelmente há [ no lugar de {.");
            return false;
        } else if ((erroPar == 0) && (erroCol < 0) && (erroCha > 0)) { // 0<0>0
            System.out.println("Possivelmente há { no lugar de [.");
            return false;
        } else if ((erroPar > 0) && (erroCol == 0) && (erroCha == 0)) { // >000
            System.out.println("Há ( sem ).");
            return false;
        } else if ((erroPar < 0) && (erroCol == 0) && (erroCha == 0)) { // <000
            System.out.println("Há ) sem (.");
            return false;
        } else if ((erroPar > 0) && (erroCol == 0) && (erroCha > 0)) { // >00>0
            System.out.println("Há ( sem ) e { sem }.");
            return false;
        } else if ((erroPar < 0) && (erroCol == 0) && (erroCha < 0)) { // <00<0
            System.out.println("Há ) sem ( e } sem {.");
            return false;
        } else if ((erroPar > 0) && (erroCol == 0) && (erroCha < 0)) { // >00<0
            System.out.println("Possivelmente há ( no lugar de }.");
            return false;
        } else if ((erroPar < 0) && (erroCol == 0) && (erroCha > 0)) { // <00>0
            System.out.println("Possivelmente há { no lugar de (.");
            return false;
        } else if ((erroPar > 0) && (erroCol > 0) && (erroCha == 0)) { // >0>00
            System.out.println("Há ( sem ) e [ sem ].");
            return false;
        } else if ((erroPar < 0) && (erroCol < 0) && (erroCha == 0)) { // <0<00
            System.out.println("Há ) sem ( e ] sem [.");
            return false;
        } else if ((erroPar > 0) && (erroCol < 0) && (erroCha == 0)) { // >0<00
            System.out.println("Possivelmente há ( no lugar de [.");
            return false;
        } else if ((erroPar < 0) && (erroCol > 0) && (erroCha == 0)) { // <0>00
            System.out.println("Possivelmente há [ no lugar de (.");
            return false;
        } else if ((erroPar > 0) && (erroCol > 0) && (erroCha > 0)) { // >0>0>0
            System.out.println("Há ( sem ), [ sem ] e { sem }.");
            return false;
        } else if ((erroPar > 0) && (erroCol > 0) && (erroCha < 0)) { // >0>0<0
            System.out.println("Possivelmente há ( e/ou [ no lugar de {.");
            return false;
        } else if ((erroPar > 0) && (erroCol < 0) && (erroCha > 0)) { // >0<0>0
            System.out.println("Possivelmente há ( e/ou { no lugar de [.");
            return false;
        } else if ((erroPar > 0) && (erroCol < 0) && (erroCha < 0)) { // >0<0<0
            System.out.println("Possivelmente há ( no lugar de [ e/ou {.");
            return false;
        } else if ((erroPar < 0) && (erroCol > 0) && (erroCha > 0)) { // <0>0>0
            System.out.println("Possivelmente há [ e/ou { no lugar de (.");
            return false;
        } else if ((erroPar < 0) && (erroCol > 0) && (erroCha < 0)) { // <0>0<0
            System.out.println("Possivelmente há [ no lugar de ( e/ou {.");
            return false;
        } else if ((erroPar < 0) && (erroCol < 0) && (erroCha > 0)) { // <0<0>0
            System.out.println("Possivelmente há { no lugar de ( e/ou [.");
            return false;
        } else if ((erroPar < 0) && (erroCol < 0) && (erroCha < 0)) { // <0<0<0
            System.out.println("Há ) sem (, ] sem [ e } sem {.");
            return false;
        }
        return false;
    }

}
