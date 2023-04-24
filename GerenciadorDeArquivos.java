import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

public class GerenciadorDeArquivos extends Uteis{

  public static void atualizarArquivoPendentes(Lista lista, String nomeDoArquivo){
      try(
         FileWriter fw = new FileWriter(nomeDoArquivo, false);
         BufferedWriter bw = new BufferedWriter(fw)
      ){
         int indice = 1;
         while(indice <= lista.getSize()){
            Jogador jogador = lista.getAt(indice);
            bw.write(jogador.formatarParaArquivo());
            bw.newLine();
            indice++;
         }
      }catch(IOException e){
         printar("Ocorreu um erro ao tentar adicionar o conteudo ao arquivo.");
         e.printStackTrace();
      }
   }
   
   public static Lista carregarDoArquivoPendentes(Lista lista, String nomeDoArquivo){
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
         printar("Ocorreu um erro ao tentar ler o conteudo do arquivo.");
         e.printStackTrace();
      }
      return lista;
   }
}