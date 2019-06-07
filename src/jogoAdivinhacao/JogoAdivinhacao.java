/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogoAdivinhacao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Marketing
 */
public class JogoAdivinhacao {
    public void iniciar() {
        Scanner input = new Scanner(System.in);
        Random r = new Random();

        // declara variavel para os nomes
        String playerNome;
        // recebe nome do jogador.
        System.out.println("Bem vindo ao jogo da adivinhação \nAntes de iniciarmos, precisamos configurar o jogo ...\nPor favor, digite seu nome.");
        playerNome = input.next();
        boolean adivJogarDenovo = true;
        do{
            // declara variavel para o número do dado escolhido, Número de Rodadas e Gera pontuação dos dois jogadores.
            int jogadoresQtd, dificuldade, numerosMaximos = 0, numeroSorteado, nRodadas, playerPontuacao = 1000, limite_de_tentativas = 5;
            System.out.println("-----------------------------------------------\nCARREGANDO...\n-----------------------------------------------");
            System.out.println("Começaremos o jogo para você, " + playerNome);
            System.out.println("Qual o nível de dificuldade que deseja? (1 fácil, 5 difícil)");
            dificuldade = input.nextInt();
            switch(dificuldade){
                case 1:
                    numerosMaximos = 30;
                    break;
                case 2:
                    numerosMaximos = 60;
                    break;
                case 3:
                    numerosMaximos = 150;
                    break;
                case 4:
                    numerosMaximos = 300;
                    break;
                case 5:
                    numerosMaximos = 600;
                    break;
                default:
                    System.out.println("Dificuldade invalida!");
            }
            System.out.println("-----------------------------------------------");
            // Número secreto é sorteado
            System.out.println("Escolhendo um número secreto entre 0 e " + (numerosMaximos - 1) + "...");
            numeroSorteado = r.nextInt(numerosMaximos) + 1;
            System.out.println("Escolhido... que tal adivinhar o nosso número secreto?");
            int chutes[] = new int[limite_de_tentativas];
            int playerChute;
            boolean encerrarJogo = true;
            int tentativa = 1;
            // Looping do jogo
            do{
                System.out.println("-----------------------------------------------");
                System.out.print("Tentativa " + tentativa + " de " + limite_de_tentativas + ". -- ");
                System.out.println("Chutes até agora " + tentativa + ".\n" + Arrays.toString(chutes));
                System.out.println(playerNome + ", entre com um número que esteja entre 0 e " + (numerosMaximos - 1));
                playerChute = input.nextInt();
                chutes[tentativa-1] = playerChute;
                System.out.println("\nSerá que acertou? Você chutou " + playerChute);
                if(playerChute == numeroSorteado){
                    System.out.println("\nAcertou! \nPontuação Final : " + playerPontuacao + "\n");
                    encerrarJogo = true;
                }
                else if(tentativa == limite_de_tentativas){
                    if(playerPontuacao < 0)
                        System.out.println("\nGAME OVER! \nPontuação Final : 0\n-----------------------------------------------");
                    else
                        System.out.println("\nGAME OVER! \nPontuação Final : " + playerPontuacao + "\n-----------------------------------------------");
                    encerrarJogo = true;
                }
                else{
                    tentativa += 1;
                    encerrarJogo = false;
                    int pontosPerder = (Math.abs((playerChute - numeroSorteado))*(6-dificuldade)) / 2;
                    playerPontuacao -= pontosPerder;
                    if(numeroSorteado > playerChute){
                        System.out.println("\nErrou, pontos perdidos : " + pontosPerder + "\nPontuação Atual : " + playerPontuacao);
                        System.out.println("\nO número secreto é MAIOR!");
                        System.out.println("-----------------------------------------------");
                    }
                    else{
                        System.out.println("\nErrou, pontos perdidos : " + pontosPerder + "\nPontuação Atual : " + playerPontuacao);
                        System.out.println("\nO número secreto é MENOR!");
                        System.out.println("-----------------------------------------------");
                    }
                }
            } while (!encerrarJogo);
            System.out.println("-----------------------------------------------");
            System.out.println("Deseja continuar jogando este jogo?");
            String continuarSN = input.next();
            if(continuarSN.equalsIgnoreCase("sim") || continuarSN.equalsIgnoreCase("s") || continuarSN.equalsIgnoreCase("yes") || continuarSN.equalsIgnoreCase("si") || continuarSN.equalsIgnoreCase("Sim") || continuarSN.equalsIgnoreCase("SIM") || continuarSN.equalsIgnoreCase("S"))
                    adivJogarDenovo = true;
            if(continuarSN.equalsIgnoreCase("não") || continuarSN.equalsIgnoreCase("nao") || continuarSN.equalsIgnoreCase("n") || continuarSN.equalsIgnoreCase("no") || continuarSN.equalsIgnoreCase("Não") || continuarSN.equalsIgnoreCase("Nao") || continuarSN.equalsIgnoreCase("NÃO") || continuarSN.equalsIgnoreCase("NAO") || continuarSN.equalsIgnoreCase("N"))
                    adivJogarDenovo = false;
        } while (adivJogarDenovo);
    }
}