/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;

import jogoDado.JogoDado;
import jogoQuiz.JogoQuiz;
import jogoAdivinhacao.JogoAdivinhacao;
import jogoBlackJack.Executar;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Marketing
 */
public class Menu {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean usuarioEscolherJogo = true;
        do{
            // MENU OPCOES
            System.out.println("Menu de jogos:");
            System.out.println("1. Iniciar QUIZ");
            System.out.println("2. Iniciar Jogo de DADO");
            System.out.println("3. Iniciar Jogo do ADIVINHAÇÃO");
            System.out.println("4. Iniciar BLACKJACK");
            System.out.println("5. Sair do Jogo");
            System.out.println("");
            // RECEBE A OPCAO SELECIONADA
            System.out.print("Por favor, selecione uma opção/jogo de 1-5\r\n");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            try {
                int input = Integer.parseInt(br.readLine());
                // CASO USUARIO TECLAR UMA OPCAO INVALIDA ( OU SEJA UM NÚMERO QUE NÃO ESTEJA ENTRE 1-5 )
                if(input < 0 || input > 5) {
                    System.out.println("");
                    System.out.println("Você tentou acessar um jogo invalido, por favor tente novamente.\r\n");
                }
                // CASO O USUARIO QUISER FINALIZAR O PROGRAMA.
                else if(input == 5) {
                    System.out.println("");
                    System.out.println("Você está saindo do jogo. Gostariamos de ve-lo novamente, até a próxima. \r\n");
                    System.exit(1);
                }
                // RESPOSTA PARA CADA OPCÃO DE JOGO
                else {
                    if(input == 1){
                        System.out.println("");
                        System.out.println("Você está entrando no jogo " + input + " : QUIZ.\r\n");
                        JogoQuiz carregar = new JogoQuiz();
                        carregar.iniciar();
                    }
                    if(input == 2){
                        System.out.println("");
                        System.out.println("Você está entrando no jogo " + input + " : Dado.\r\n");
                        JogoDado carregar = new JogoDado();
                        carregar.iniciar();
                    }
                    if(input == 3){
                        System.out.println("");
                        System.out.println("Você está entrando no jogo " + input + " : Adivinhação.\r\n");
                        JogoAdivinhacao carregar = new JogoAdivinhacao();
                        carregar.iniciar();
                    }
                    if(input == 4){
                        System.out.println("");
                        System.out.println("Você está entrando no jogo " + input + " : BLACKJACK.\r\n");
                        Executar carregar = new Executar();
                        carregar.iniciar();
                    }
                }
            }
            // CASO OCORRER ALGUM ERRO INESPERADO.
            catch (IOException ioe) {
                System.out.println("");
                System.out.println("IO error na tentativa de ler o comando de input!\r\n");
                System.exit(1);
            }
            // OPCAO PARA CASO A PESSOA DECIDIR SE QUER VOLTAR AO MENU OU FECHAR O PROGRAMA.
            Scanner input = new Scanner(System.in);
            System.out.println("Deseja escolher outro jogo?");
            String continuarSN = input.next();
            // possiveis respostas para SIM/TRUE, e colocar o boolean para true;
            if(continuarSN.equalsIgnoreCase("sim") || continuarSN.equalsIgnoreCase("s") || continuarSN.equalsIgnoreCase("yes") || continuarSN.equalsIgnoreCase("si") || continuarSN.equalsIgnoreCase("Sim") || continuarSN.equalsIgnoreCase("SIM") || continuarSN.equalsIgnoreCase("S"))
                    usuarioEscolherJogo = true;
            // possiveis respostas para NAO/FALSE, e colocar o boolean para false;
            if(continuarSN.equalsIgnoreCase("não") || continuarSN.equalsIgnoreCase("nao") || continuarSN.equalsIgnoreCase("n") || continuarSN.equalsIgnoreCase("no") || continuarSN.equalsIgnoreCase("Não") || continuarSN.equalsIgnoreCase("Nao") || continuarSN.equalsIgnoreCase("NÃO") || continuarSN.equalsIgnoreCase("NAO") || continuarSN.equalsIgnoreCase("N")){
                usuarioEscolherJogo = false;
                System.out.println("Você está saindo do jogo. Gostariamos de ve-lo novamente, até a próxima. \r\n");
            }
        } while (usuarioEscolherJogo);
    }
}