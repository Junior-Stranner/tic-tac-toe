import java.util.Scanner;

public class JogoDaVelha {
    public static void main(String []args){

    Scanner in = new Scanner(System.in);
      Campo[][] velha = new Campo[3][3];
      char simboloAtual = 'x';
      boolean game = true;
      String vitoria = "";

      while (game) {
        desenhaJogo(velha);
        vitoria=verificaVitoria(velha);
        if(!vitoria.equals("")){
            System.out.printf("Jogador %s venceu%c",vitoria);
            break;
        }
        try {

            if(verificaJogada(velha, jogar(in,simboloAtual), simboloAtual)){
                if(simboloAtual == 'x'){
                    simboloAtual = '0';
                }else{
                    simboloAtual = 'X';
                }
            }
            
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Erro !");
        }
      }
      System.out.println("Dim do Jogo ");
    }

    public static void desenhaJogo(Campo[][] velha){
     //limparTela();
     try {
        
        System.out.println("---------------------");
        System.out.print( "0   1   2 \n");
        System.out.print("0   " + "%c | %c | %c %n"+ velha[0][0].getSimbolo() + velha[0][1].getSimbolo() + velha[0][2].getSimbolo());
        System.out.println("----------------------");
        System.out.print("1   " + "%c | %c | %c %n"+ velha[1][0].getSimbolo() + velha[1][1].getSimbolo() + velha[1][2].getSimbolo());
        System.out.println("----------------------");
        System.out.print("2   " + "%c | %c | %c %n"+ velha[2][0].getSimbolo() + velha[2][1].getSimbolo() + velha[2][2].getSimbolo());
        System.out.println("----------------------");
   
     } catch (NullPointerException e) {
        // TODO: handle exception
        System.out.println("Erro ao montar o desenho do Jogo !");
      }
 }

    public static void limpartTela(){
        for(int count= 0 ; count <200 ; count++){
            System.out.println("");
        }
    }

    public static int[] jogar(Scanner in, char sa){
         int p[] = new int[2];
         System.out.println(" quem joga ? " +sa);
         System.out.println("Informe a linha (0, 1 ou 2): ");
         p[0] = in.nextInt() - 1;
         System.out.println("Informe a coluna (0, 1 ou 2): ");
         p[1] = in.nextInt() -1 ;

        return p;
    }

    public static boolean verificaJogada(Campo[][] velha, int[] posicao, char simboloAtual) {
        if (posicao[0] >= 0 && posicao[0] < velha.length && posicao[1] >= 0 && posicao[1] < velha[0].length) {
            if (velha[posicao[0]][posicao[1]].getSimbolo() == ' ') {
                velha[posicao[0]][posicao[1]].setSimbolo(simboloAtual);
                return true;
            } else {
                System.out.println("Posição ocupada, escolha outra!");
            }
        } else {
            System.out.println("Posição inválida, escolha novamente!");
        }
        return false;
    }

    public static String verificaVitoria(Campo[][] velha){
        return "";
    }
}
