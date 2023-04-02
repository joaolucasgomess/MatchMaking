import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

public class GerenciadorDeArquivos{

  /*public static void <generico extends Iformatacao> Lista<generico> atualizarArquivo(Lista<generico> lista, String nomeDoArquivo){
      try(
         FileWriter fw = new FileWriter(nomeDoArquivo, false);
         BufferedWriter bw = new BufferedWriter(fw)
      ){
         for(Tarefa tarefa : listaDeTarefas){
            bw.write(tarefa.formatarAtributosParaArquivo());
            bw.newLine();
         }
      }catch(IOException e){
         System.out.println("Ocorreu um erro ao tentar adicionar o conteudo ao arquivo.");
         e.printStackTrace();
      }
   }*/
   
   public static Lista carregarDoArquivoTarefa(Lista lista, String nomeDoArquivo){
      try(
         FileReader fr = new FileReader(nomeDoArquivo);
         BufferedReader br = new BufferedReader(fr)
      ){
         String linha;
         while((linha = br.readLine()) != null){
            Jogador elemento = Jogador.formatarParaLista(linha);
            lista.addLast(elemento);
         }
      }catch(IOException e){
         System.out.println("Ocorreu um erro ao tentar ler o conteudo do arquivo.");
         e.printStackTrace();
      }
      return lista;
   }
}