import java.util.*;

public class Main extends Uteis{
  public static void main(String[] args) {
  Scanner leia = new Scanner(System.in);
  Macthmaking matchmaking = new Macthmaking();
   while(true){
      printar("---- MATCHMAKING MENU -----");
      printar("\nOpcoes: ");
      printar("1 - Adicionar jogador");
      printar("2 - Ver jogadores em espera");
      printar("3 - Ver partidas em andamento");
      printar("4 - Sair");
      printar("\nSeleione uma opcao: ");
      int opcao = leia.nextInt();
         
      switch (opcao){
            case 1:
               matchmaking.adicionarJogador();
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