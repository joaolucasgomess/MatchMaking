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
      //0 - carregador, 1 - tanker, 2 - suporte, 3 - mago
      Jogador[] jogadoresTestados = transicaoListaVetor(inicio, fim);
      Jogador[] carregador = new Jogador[2];
      Jogador[] tanker = new Jogador[2];
      Jogador[] suporte = new Jogador[2];
      Jogador[] mago = new Jogador[2];
      
      for(Jogador jogadorTestado : jogadoresTestados){
          if(jogadorTestado.getRole() == 0){
            if(carregador[0] == null){
               carregador[0] = jogadorTestado;
            }else{
               carregador[1] = jogadorTestado;
            }
         }else if(jogadorTestado.getRole() == 1){
           if(tanker[0] == null){
               tanker[0] = jogadorTestado;
            }else{
               tanker[1] = jogadorTestado;
            }
         }else if(jogadorTestado.getRole() == 2){
           if(suporte[0] == null){
               suporte[0] = jogadorTestado;
            }else{
               suporte[1] = jogadorTestado;
            }
         }else{
           if(mago[0] == null){
               mago[0] = jogadorTestado;
            }else{
               mago[1] = jogadorTestado;
            }
        }
      }
      if(testarNull(carregador, tanker, suporte, mago) == true){
         
         return true;
      }else{
         return false;
      }
   }
   
   public void iniciarPartida(Jogador[] carregadores, Jogador[] tankers, Jogador[] suportes, Jogador[] magos){
      Jogador[] equipe1 = new Jogador[3];
      Jogador[] equipe2 = new Jogador[3];
      int indice = 0;
      for(Jogador integrante : equipe1){
         if(integrante == null){
            if(equipe1[2] != null){
               break;
            }
            for(Jogador carregador : carregadores){
               if(carregador != null){
                  if(!existeARole(equipe1, 0)){
                     equipe1[indice] = carregador;
                     if(carregador[0] != null){
                        carregador[0] = null;
                     }else if(carregador[1] != null){
                        carregador[1] = null;
                     }
                     indice++;
                  }
               }
            }
            if(equipe1[2] != null){
               break;
            }
            for(Jogador tanker : tankers){
               if(tanker != null){
                  if(!existeARole(equipe1, 1)){
                     equipe1[indice] = tanker;
                     indice++;
                     if(tanker[0] != null){
                        tanker[0] = null;
                     }else if(tanker[1] != null){
                        tanker[1] = null;
                     }
                  }
               }
            }
            if(equipe1[2] != null){
               break;
            }
            for(Jogador suporte : suportes){
               if(suporte != null){
                  if(!existeARole(equipe1, 2)){
                     equipe1[indice] = suporte;
                     indice++;
                     if(suporte[0] != null){
                        suporte[0] = null;
                     }else if(suporte[1] != null){
                        suporte[1] = null;
                     }
                  }
               }
            }
            if(equipe1[2] != null){
               break;
            }
            for(Jogador mago : magos){
               if(mago != null){
                  if(!existeARole(equipe1, 3)){
                     equipe1[indice] = mago;
                     indice++;
                     if(mago[0] != null){
                        mago[0] = null;
                     }else if(mago[1] != null){
                        mago[1] = null;
                     }
                  }
               }
            }
         }
      }
      for(Jogador integrante : equipe2){
         if(integrante == null){
            if(equipe2[2] != null){
               break;
            }
            for(Jogador carregador : carregadores){
               if(carregador != null){
                  if(!existeARole(equipe2, 0)){
                     equipe2[indice] = carregador;
                     if(carregador[0] != null){
                        carregador[0] = null;
                     }else if(carregador[1] != null){
                        carregador[1] = null;
                     }
                     indice++;
                  }
               }
            }
            if(equipe2[2] != null){
               break;
            }
            for(Jogador tanker : tankers){
               if(tanker != null){
                  if(!existeARole(equipe2, 1)){
                     equipe2[indice] = tanker;
                     indice++;
                     if(tanker[0] != null){
                        tanker[0] = null;
                     }else if(tanker[1] != null){
                        tanker[1] = null;
                     }
                  }
               }
            }
            if(equipe2[2] != null){
               break;
            }
            for(Jogador suporte : suportes){
               if(suporte != null){
                  if(!existeARole(equipe2, 2)){
                     equipe2[indice] = suporte;
                     indice++;
                     if(suporte[0] != null){
                        suporte[0] = null;
                     }else if(suporte[1] != null){
                        suporte[1] = null;
                     }
                  }
               }
            }
            if(equipe2[2] != null){
               break;
            }
            for(Jogador mago : magos){
               if(mago != null){
                  if(!existeARole(equipe2, 3)){
                     equipe2[indice] = mago;
                     indice++;
                     if(mago[0] != null){
                        mago[0] = null;
                     }else if(mago[1] != null){
                        mago[1] = null;
                     }
                  }
               }
            }
         }
      }  
   }
   
   public boolean existeNoArray(Jogador[] arrayTeste, Jogador testado){
      boolean existeNoArray = false;
      for(Jogador jogador : arrayTeste){
         if(jogador == null){
            break;
         }
         else if(jogador.equals(testado)){
            existeNoArray =  true;
         }
      }return existeNoArray;
   }
   
   public boolean existeARole(Jogador[] arrayTeste, int role){
      boolean existeARole = false;
      for(Jogador jogador : arrayTeste){
         if(jogador == null){
            break;
         }
         else if(jogador.getRole() == role){
            existeARole = true;
         }
      }return existeARole;
   }
   
   public boolean testarNull(Jogador[] carregador, Jogador[] tanker, Jogador[] suporte, Jogador[] mago){
      int count = 0; 

      if (carregador.length == 0) {
         count++; 
      }
      if (tanker.length == 0) {
         count++; 
      }
      if (suporte.length == 0) {
         count++; 
      }
      if (mago.length == 0) {
         count++; 
      }

      if (count == 1 || count == 0) {
         iniciarPartida(carregador, tanker, suporte, mago);
         return true;
      } else{
         return false;
      }
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
}