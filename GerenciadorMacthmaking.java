public class GerenciadorMacthmaking{
   private Lista listaJogadoresPendentes;   
   
   public GerenciadorMacthmaking(){
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
      this.listaJogadoresPendentes = GerenciadorDeArquivos.carregarDoArquivoTarefa(listaJogadoresPendentes, "zjogadores.txt");
   }
   
   public void exibirJogadoresPendentes(){
      listaJogadoresPendentes.print();
   }
   
   public void testarNivel(){
      //TODO
   }
}