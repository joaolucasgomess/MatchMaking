public class Lista extends Uteis{
   private NoDuplo head;
   private NoDuplo end;
   private int size;
   
   public Lista(){
      head = new NoDuplo();
      end = new NoDuplo();
      size = 0;  
      
      head.setProximo(end);
      end.setAnterior(head);
   }
   
   public int getSize(){
      return this.size;
   }
   
   public void addFirst(Jogador novoJogador){
      NoDuplo jogadorPendente = new NoDuplo();
      jogadorPendente.setJogadorPendente(novoJogador);
      jogadorPendente.setAnterior(head);
      jogadorPendente.setProximo(head.getProximo());
      
      head.getProximo().setAnterior(jogadorPendente);
      head.setProximo(jogadorPendente);
      size++;
   }
   
   public void addLast(Jogador novoJogador){
      NoDuplo novoJogadorPendente = new NoDuplo();
      novoJogadorPendente.setJogadorPendente(novoJogador);
      novoJogadorPendente.setProximo(end);
      novoJogadorPendente.setAnterior(end.getAnterior());
      
      end.getAnterior().setProximo(novoJogadorPendente);
      end.setAnterior(novoJogadorPendente);
      size++;  
   }
   
   public void print(){
      if(size !=0){
         for(NoDuplo atual = head.getProximo(); atual != end; atual = atual.getProximo()){   
            Uteis.printar(atual.getJogadorPendente().toString());
         }
      }
   }
   
   public Jogador getAt(int indiceProcurado){
      if(indiceProcurado > this.size){
         printar("A lista e menor.");
         Jogador jogador = head.getJogadorPendente();
         return jogador;
      }else{
         int indicePercorrido = 0;
         NoDuplo atual = head;
         while(indicePercorrido < indiceProcurado){
            atual = atual.getProximo();
            indicePercorrido++;
         }
         return atual.getJogadorPendente();
      }
   }
   
   public void addOrder(Jogador jogadorAdd){
      NoDuplo atual = head.getProximo();
      Jogador jogadorAtual = atual.getJogadorPendente();
      while(atual != end){
         if(jogadorAtual.getPontuacao() <= jogadorAdd.getPontuacao()){
            atual = atual.getProximo();
            jogadorAtual = atual.getJogadorPendente();
         }else{
            break;
         }
      }
      NoDuplo jogadorPendente = new NoDuplo();
      jogadorPendente.setJogadorPendente(jogadorAdd);
      jogadorPendente.setProximo(atual);
      jogadorPendente.setAnterior(atual.getAnterior());
      
      atual.getAnterior().setProximo(jogadorPendente);
      atual.setAnterior(jogadorPendente);
      size++;
   }
}