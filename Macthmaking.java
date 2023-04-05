public class Macthmaking{
   private Lista listaJogadoresPendentes;   
   
   public Macthmaking(){
      listaJogadoresPendentes = new Lista();
      preencherJogadores();
   }
   
   public Lista getListaJogadoresPendentes(){
      return listaJogadoresPendentes;
   }
   
   public void setListaJogadoresPendentes(Lista listaJogadoresPendentes){
      this.listaJogadoresPendentes = listaJogadoresPendentes;
   }
   
   public void preencherJogadores(){
      this.listaJogadoresPendentes = GerenciadorDeArquivos.carregarDoArquivoTarefa(listaJogadoresPendentes, "ynuncaDaCertojogadores.txt");
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
            break;
         }else{
            inicio++;
            fim++;
         }
      }  
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
      //TODO
   }
}