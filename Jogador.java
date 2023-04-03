import java.util.*;

public class Jogador{

   private int id;
   private int role;
   private int pontuacao;
   
   public Jogador(int id, int role, int pontuacao){
      this.id = id;
      this.role = role;
      this.pontuacao = pontuacao;
   }
   
   public int getId(){
      return id;
   }
   
   public void setId(int id){
      this.id = id;
   }
   
   public int getRole(){
      return role;
   }
   
   public void setRole(int role){
      this.role = role;
   }
   
   public int getPontuacao(){
      return pontuacao;
   }
   
   public void setPontuacao(int pontuacao){
      this.pontuacao = pontuacao;
   }
   
   public String roleString(){
      if(this.role == 0){
         return " carregador ";
      }else if(this.role == 1){
         return " tanker ";
      }else if(this.role == 2){
         return " suporte ";
      }else{
         return " mago ";
      }
   }
   
   @Override
   public String toString(){
      return("ID: " + this.id
         + " - Role:" + roleString()
         + " - Pontuacao de habilidade: " + this.pontuacao
         );
   }
   
   public String formatarParaArquivo(){
      String atributosFormatados = this.id + ";"
            + this.role + ";"
            + this.pontuacao;
      return atributosFormatados;
   }
   
   public static Jogador formatarParaLista(String linha){
      String[] atributos = linha.split(";");
      int id = Integer.parseInt(atributos[0]);
      int role = Integer.parseInt(atributos[1]);
      int pontuacao = Integer.parseInt(atributos[2]);
      return new Jogador(id, role, pontuacao);
   } 
}