public class NoDuplo{
   private Jogador jogadorPendente;
   private NoDuplo anterior;
   private NoDuplo proximo;
   
   public void setJogadorPendente(Jogador jogadorPendente){
      this.jogadorPendente = jogadorPendente;
   }
   
   public Jogador getJogadorPendente(){
      return this.jogadorPendente;
   }
   
   public NoDuplo getAnterior(){
      return this.anterior;
   }
   
   public NoDuplo getProximo(){
      return this.proximo;
   }
   
   public void setAnterior(NoDuplo anterior){
      this.anterior = anterior;
   }
   
   public void setProximo(NoDuplo proximo){
      this.proximo = proximo;
   }
   
}