import java.util.*;

public class Macthmaking extends Uteis{
   private Lista listaJogadoresPendentes;   
   
   public Macthmaking(){
      listaJogadoresPendentes = new Lista();
      listaJogadoresPendentes = GerenciadorDeArquivos.carregarDoArquivoPendentes(listaJogadoresPendentes, "zDaCertoDePrimeira.txt");
      criarPartida();
   }
   
   public Lista getListaJogadoresPendentes(){
      return listaJogadoresPendentes;
   }
   
   public void setListaJogadoresPendentes(Lista listaJogadoresPendentes){
      this.listaJogadoresPendentes = listaJogadoresPendentes;
   }
   
   public void exibirJogadoresPendentes(){
      listaJogadoresPendentes.print();
   }
   
   public void adicionarJogador(){
      Scanner leia = new Scanner(System.in);
      System.out.print("Digite seu id: ");
      int id = leia.nextInt();
      if(!usuarioExiste(id)){
         printar("Escolha a role desejada: \n1 - carregador\n2 - tanker\n3 - suporte\n4 - mago");
         int role = (leia.nextInt() - 1);
         System.out.print("Digite a pontuacao: ");
         int pontuacao = leia.nextInt();
         Jogador jogadorAdicionado = new Jogador(id, role, pontuacao);
         listaJogadoresPendentes.addOrder(jogadorAdicionado);
         GerenciadorDeArquivos.atualizarArquivoPendentes(listaJogadoresPendentes, "zDaCertoDePrimeira.txt");
         printar("Jogador adicionado com sucesso à lista de espera.");
         criarPartida();
      }
   }
   
   public boolean usuarioExiste(int id){
      boolean usuarioExiste = false;
      int indice = 1;
      while(indice <= listaJogadoresPendentes.getSize()){
         Jogador jogadorTestado = listaJogadoresPendentes.getAt(indice);
         if(jogadorTestado.getId() == id){
           usuarioExiste = true;
           printar("Usuario ja existe!");
           break;
         }indice++;
      }return usuarioExiste; 
   }
   
   public void criarPartida(){
      if(listaJogadoresPendentes.getSize() >= 6){
         boolean naoEntraPartida = true;
         int inicio = 1;
         while(naoEntraPartida){
            int fim = inicio + 5;
            if(fim > listaJogadoresPendentes.getSize()){
               printar("Todos os jogadores ja foram testados.");
               break;
            }else{
               while(testarNivel(inicio, fim)){
                  if(testarRole(inicio, fim) == true){
                     naoEntraPartida = false;
                     printar("deu certo");
                     iniciarPartida();
                  }
                  fim++;
               }
               inicio++;
            }
         }
      }else{
         printar("Nao ha jogadores o suficiente.");
      }
   }
   
   public void iniciarPartida(){
      //TODO
   }
   
   public boolean testarNivel(int inicio, int fim){
      Jogador jogadorInicio = listaJogadoresPendentes.getAt(inicio);
      Jogador jogadorFim = listaJogadoresPendentes.getAt(fim);
      int balanciamento = jogadorFim.getPontuacao() - jogadorInicio.getPontuacao();
      
      if(balanciamento <= 1000){
         return true;
      }
      printar("deu partida nao ze");  
      return false;
   }
   
   public boolean testarRole(int inicio, int fim){
      Jogador[] jogadoresTestados = transicaoListaVetor(inicio, fim);
      int[][] rolesContadas = contaRoles(jogadoresTestados);
      int contaNulls = 0;
      
      for(int[] role : rolesContadas){
         for(int id : role){
            if(id == 0){
               contaNulls++;
            }
         }
      }
      if(contaNulls > 2){
         return false;
      }
      return true;
   }
   
   public Jogador[] transicaoListaVetor(int inicio, int fim){
      Jogador[] jogadoresTestados = new Jogador[fim];
      int indice = 0;
   
      for(int atual = inicio; atual <= fim; atual++){
         jogadoresTestados[indice] = this.listaJogadoresPendentes.getAt(atual);
         indice++;
      }
      return jogadoresTestados;
   }
   
   public int[][] contaRoles(Jogador[] jogadoresTestados){
      //0 - carregador, 1 - tanker, 2 - suporte, 3 - mago
      int[][] ocorrenciasDeRoles = new int[4][2];
      int indice = 0;
      
      while(indice < 4){
         for(Jogador jogador : jogadoresTestados){
            if(jogador.getRole() == indice){
               if(ocorrenciasDeRoles[indice][0] == 0){
                  ocorrenciasDeRoles[indice][0] = jogador.getId();
               }else{
                  ocorrenciasDeRoles[indice][1] = jogador.getId();
               }
            }
         }indice++;
      }
      return ocorrenciasDeRoles;
   }
}