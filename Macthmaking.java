public class Macthmaking{
   private Lista listaJogadoresPendentes;   
   
   public Macthmaking(){
      listaJogadoresPendentes = new Lista();
      listaJogadoresPendentes = GerenciadorDeArquivos.carregarDoArquivoTarefa(listaJogadoresPendentes, "zDaCertoDePrimeirajogadores.txt");
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
   
   public void iniciarPartida(){
      testarNivel();
      //testar role
   }
   
   public void testarNivel(){
      int inicio = 1;
      int fim  = 6;
      while(fim <= listaJogadoresPendentes.getSize()){
         Jogador[] jogadoresTestados = transicaoListaVetor(inicio, fim);
         int balanciamento = jogadoresTestados[5].getPontuacao() - jogadoresTestados[0].getPontuacao();
      
         if(balanciamento <= 1000){
            testarRole(jogadoresTestados);
         }
         inicio++;
         fim++;
      }
      Uteis.printar("deu partida nao ze");  
   }
   
   public Jogador[] transicaoListaVetor(int inicio, int fim){
      Jogador[] jogadoresTestados = new Jogador[6];
      int indice = 0;
   
      for(int atual = inicio; atual <= fim; atual++){
         NoDuplo noTransicao = this.listaJogadoresPendentes.getAt(atual);
         jogadoresTestados[indice] = noTransicao.getJogadorPendente();
         indice++;
      }
      return jogadoresTestados;
   }
   
   public void testarRole(Jogador[] jogadoresTestados){
      int[] rolesContadas = contaRoles(jogadoresTestados);
      
      for(int role : rolesContadas){
         if(role > 2){
            Uteis.printar("deu ruim as roles");
            break;
         }
      }
   }
   
   public int[] contaRoles(Jogador[] jogadoresTestados){
      //0 - carregador, 1 - tanker, 2 - suporte, 3 - mago
      int[] contagemDeRoles = new int[4];
      
      for(Jogador jogador : jogadoresTestados){
         if(jogador.getRole() == 0){
            contagemDeRoles[0]++;
         }else if(jogador.getRole() == 1){
            contagemDeRoles[1]++;
         }else if(jogador.getRole() == 2){
            contagemDeRoles[2]++;
         }else{
            contagemDeRoles[3]++;
         }
      }
      return contagemDeRoles;
   }
}