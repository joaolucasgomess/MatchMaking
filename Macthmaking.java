public class Macthmaking{
   private Lista listaJogadoresPendentes;   
   
   public Macthmaking(){
      listaJogadoresPendentes = new Lista();
      listaJogadoresPendentes = GerenciadorDeArquivos.carregarDoArquivoTarefa(listaJogadoresPendentes, "zDaCertoDePrimeira.txt");
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
   
   public void testesParaIniciarPartida(){
      boolean naoEntraPartida = true;
      int inicio = 1;
      
      while(naoEntraPartida){
         int fim = inicio + 5;
         while(testarNivel(inicio, fim)){
            if(testarRole(inicio, fim) == true){
               naoEntraPartida = false;
               Uteis.printar("deu certo");
               iniciarPartida();
            }
            fim++;
         }
         inicio++;
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
      Uteis.printar("deu partida nao ze");  
      return false;
   }
   
   public boolean testarRole(int inicio, int fim){
      Jogador[] jogadoresTestados = transicaoListaVetor(inicio, fim);
      Jogador[][] rolesContadas = contaRoles(jogadoresTestados);
      int contaNulls = 0;
      
      for(Jogador[] role : rolesContadas){
         for(Jogador jogador : role){
            if(jogador == null){
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
   
   public Jogador[][] contaRoles(Jogador[] jogadoresTestados){
      //0 - carregador, 1 - tanker, 2 - suporte, 3 - mago
      Jogador[][] ocorrenciasDeRoles = new Jogador[4][2];
      int indice = 0;
      
      while(indice < 4){
         for(Jogador jogador : jogadoresTestados){
            if(jogador.getRole() == indice){
               if(ocorrenciasDeRoles[indice][0] == null){
                  ocorrenciasDeRoles[indice][0] = jogador;
               }else{
                  ocorrenciasDeRoles[indice][1] = jogador;
               }
            }
         }indice++;
      }
      return ocorrenciasDeRoles;
   }
}