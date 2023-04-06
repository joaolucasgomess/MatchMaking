import java.util.*;

public class Main{
  public static void main(String[] args) {
  Scanner leia = new Scanner(System.in);
  Macthmaking matchmaking = new Macthmaking();
   while(true){
      System.out.print("---- MATCHMAKING MENU -----");
      System.out.println("\nOpcoes: ");
      System.out.println("1 - Adicionar jogador");
      System.out.println("2 - Ver jogadores em espera");
      System.out.println("3 - Ver partidas em andamento");
      System.out.println("4 - Sair");
      System.out.print("\nSeleione uma opcao: ");
      int opcao = leia.nextInt();
         
      switch (opcao){
            case 1:
               matchmaking.testesParaIniciarPartida();
               //exemplo.adicionarJogador();
               break;
               
            case 2:
               matchmaking.exibirJogadoresPendentes();
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