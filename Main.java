import java.util.*;

public class Main{
  public static void main(String[] args) {
  Scanner leia = new Scanner(System.in);
   while(true){
      System.out.println("\nOpcoes: ");
      System.out.println("1 - Adicionar jogador");
      System.out.println("2 - Ver jogadores em espera");
      System.out.println("3 - Ver partidas em andamento");
      System.out.println("4 - Sair");
      int opcao = leia.nextInt();
         
      switch (opcao){
            case 1:
               //exemplo.adicionarJogador();
               break;
               
            case 2:
               //exemplo.exibirJogadores();
               break;
            
            case 3:
               //exemplo.exibirPartidas();
               break;
               
            case 4:
               Uteis.printar("Volte sempre!");
               System.exit(0);
               break;
         }
      }
   }
}