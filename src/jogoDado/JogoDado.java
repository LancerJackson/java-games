/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogoDado;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import menu.*;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Marketing
 */
public class JogoDado {
    Random r = new Random();
    Scanner input = new Scanner(System.in);
    // declara variavel para os nomes
    String player1, player2;
    // declara variavel para o número do dado escolhido, Número de Rodadas e Gera pontuação dos dois jogadores.
    int player1Choice, player2Choice, nRodadas, player1Pontuacao = 1000, player2Pontuacao = 1000;

    public void iniciar() {
        // recebe nome do jogador 1.
        System.out.println("Jogador 1, digite seu nome");
        player1 = input.next();
        // recebe nome do jogador 2.
        System.out.println("\nJogador 2, digite seu nome");
        player2 = input.next();
        boolean dadoJogarDenovo = true;
        do {
            iniciarRodada();
            System.out.println("Deseja continuar jogando este jogo?");
            String continuarSN = input.next();
            if (continuarSN.equalsIgnoreCase("sim") || continuarSN.equalsIgnoreCase("s") || continuarSN.equalsIgnoreCase("yes") || continuarSN.equalsIgnoreCase("si") || continuarSN.equalsIgnoreCase("Sim") || continuarSN.equalsIgnoreCase("SIM") || continuarSN.equalsIgnoreCase("S")) {
                dadoJogarDenovo = true;
            }
            if (continuarSN.equalsIgnoreCase("não") || continuarSN.equalsIgnoreCase("nao") || continuarSN.equalsIgnoreCase("n") || continuarSN.equalsIgnoreCase("no") || continuarSN.equalsIgnoreCase("Não") || continuarSN.equalsIgnoreCase("Nao") || continuarSN.equalsIgnoreCase("NÃO") || continuarSN.equalsIgnoreCase("NAO") || continuarSN.equalsIgnoreCase("N")) {
                dadoJogarDenovo = false;
            }
        } while (dadoJogarDenovo);
    }
    public void jogador1Escolhe(){
        System.out.println("\n" + player1 + ", escolha um lado/número do dado de 1 a 6");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            player1Choice = Integer.parseInt(br.readLine());
            if(player1Choice < 1 || player1Choice > 6) {
                System.out.println("-----------------------------------------------");
                System.out.println(player1 + "Você tentou acessar um jogo invalido, por favor tente novamente.");
                System.out.println("-----------------------------------------------");
                jogador1Escolhe();
            }
            else {
                if(player1Choice >= 1){
                    System.out.print("");
                }
                if(player1Choice <= 6){
                    System.out.print("");
                }
            }
        }
        catch (IOException ioe) {
            System.out.println("");
            System.out.println("IO error na tentativa de ler o comando de input!\r\n");
            System.exit(1);
        }
    }
    public void jogador2Escolhe(){
        System.out.println("\n" + player2 + ", escolha um lado/número do dado de 1 a 6");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            player2Choice = Integer.parseInt(br.readLine());
            if(player2Choice < 1 || player2Choice > 6) {
                System.out.println("");
                System.out.println(player2 + "Você tentou acessar um jogo invalido, por favor tente novamente.\r\n");
                jogador2Escolhe();
            }
            else {
                if(player2Choice >= 1){
                    System.out.print("");
                }
                if(player2Choice <= 6){
                    System.out.print("");
                }
            }
        }
        catch (IOException ioe) {
            System.out.println("");
            System.out.println("IO error na tentativa de ler o comando de input!\r\n");
            System.exit(1);
        }
    }
    public void iniciarRodada() {
        // recebe o número de rodadas.
        System.out.println("\nEscolha o número de rodadas.");
        nRodadas = input.nextInt();

        for (int i = 0; i < nRodadas; i++) {
            System.out.println("\n###########\n\nRodada " + (i + 1));
            
            jogador1Escolhe();
            jogador2Escolhe();
            
            int dadoJogado = r.nextInt(6) + 1;
            if (dadoJogado == player1Choice) {
                System.out.println("\n#" + player1 + ", acertou o número do dado");
                player1Pontuacao += ((100 / nRodadas) * 6);
            } else {
                if ((player1Choice + 1) == dadoJogado && (player1Choice + 1) <= 6 || (player1Choice - 1) == dadoJogado && (player1Choice - 1) >= 1) {
                    player1Pontuacao -= ((100 / nRodadas) * 1);
                }
                if ((player1Choice + 2) == dadoJogado && (player1Choice + 2) <= 6 || (player1Choice - 2) == dadoJogado && (player1Choice - 2) >= 1) {
                    player1Pontuacao -= ((100 / nRodadas) * 2);
                }
                if ((player1Choice + 3) == dadoJogado && (player1Choice + 3) <= 6 || (player1Choice - 3) == dadoJogado && (player1Choice - 3) >= 1) {
                    player1Pontuacao -= ((100 / nRodadas) * 3);
                }
                if ((player1Choice + 4) == dadoJogado && (player1Choice + 4) <= 6 || (player1Choice - 4) == dadoJogado && (player1Choice - 4) >= 1) {
                    player1Pontuacao -= ((100 / nRodadas) * 4);
                }
                if ((player1Choice + 5) == dadoJogado && (player1Choice + 5) <= 6 || (player1Choice - 5) == dadoJogado && (player1Choice - 5) >= 1) {
                    player1Pontuacao -= ((100 / nRodadas) * 5);
                }
            }
            // Calcula pontuação do JOGADOR 2 ( caso, ganhar 
            if (dadoJogado == player2Choice) {
                System.out.println("\n#" + player2 + ", acertou o número do dado");
                player2Pontuacao += ((100 / nRodadas) * 6);
            } else {
                if ((player2Choice + 1) == dadoJogado && (player2Choice + 1) <= 6 || (player2Choice - 1) == dadoJogado && (player2Choice - 1) >= 1) {
                    player2Pontuacao -= ((100 / nRodadas) * 1);
                }
                if ((player2Choice + 2) == dadoJogado && (player2Choice + 2) <= 6 || (player2Choice - 2) == dadoJogado && (player2Choice - 2) >= 1) {
                    player2Pontuacao -= ((100 / nRodadas) * 2);
                }
                if ((player2Choice + 3) == dadoJogado && (player2Choice + 3) <= 6 || (player2Choice - 3) == dadoJogado && (player2Choice - 3) >= 1) {
                    player2Pontuacao -= ((100 / nRodadas) * 3);
                }
                if ((player2Choice + 4) == dadoJogado && (player2Choice + 4) <= 6 || (player2Choice - 4) == dadoJogado && (player2Choice - 4) >= 1) {
                    player2Pontuacao -= ((100 / nRodadas) * 4);
                }
                if ((player2Choice + 5) == dadoJogado && (player2Choice + 5) <= 6 || (player2Choice - 5) == dadoJogado && (player2Choice - 5) >= 1) {
                    player2Pontuacao -= ((100 / nRodadas) * 5);
                }
            }
            if (player1Pontuacao <= 0 || player2Pontuacao <= 0) {
                break;
            }
            // mostra número aleatório do dado
            System.out.println("\n# Dado girado : " + dadoJogado);
            // mostra pontuação
            System.out.println("# Pontuação do " + player1 + " : " + player1Pontuacao + "\n# Pontuação do " + player2 + " : " + player2Pontuacao + "\n\n...\n...");
        }
        System.out.println("\nPontuação Final do " + player1 + " é de : " + player1Pontuacao);
        System.out.println("Pontuação Final do " + player2 + " é de : " + player2Pontuacao + "\n");
        if (player1Pontuacao > player2Pontuacao) {
            System.out.println(player1 + " é o vencedor !!\n");
        } else if (player1Pontuacao < player2Pontuacao) {
            System.out.println(player2 + " é o vencedor !!\n");
        } else {
            System.out.println("EMPATE!!\n");
        }
    }
}
