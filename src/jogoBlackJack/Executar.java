package jogoBlackJack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Executar {

    public void iniciar() {
        // MENU OPCOES
        System.out.println("Menu BlackJack:");
        System.out.println("1. Iniciar Jogo");
        System.out.println("2. Ver Regras");
        System.out.println("3. Sair do Jogo");
        System.out.println("");
        // RECEBE A OPCAO SELECIONADA
        System.out.print("Por favor, selecione uma opção/jogo de 1-5\r\n");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int input = Integer.parseInt(br.readLine());
            // CASO USUARIO TECLAR UMA OPCAO INVALIDA ( OU SEJA UM NÚMERO QUE NÃO ESTEJA ENTRE 1-5 )
            if (input < 0 || input > 3) {
                System.out.println("");
                System.out.println("Você tentou acessar uma opção invalida, por favor tente novamente.\r\n");
                System.out.println("-----------------------------------------------");
            } // CASO O USUARIO QUISER FINALIZAR O PROGRAMA.
            else if (input == 3) {
                System.out.println("");
                System.out.println("Saindo do Black Jack e voltando ao menu... \r\n");
                System.out.println("-----------------------------------------------");
                return;
            } // RESPOSTA PARA CADA OPCÃO DE JOGO
            else {
                if (input == 1) {
                    System.out.println("Iniciaremos o jogo para você.");
                    System.out.println("-----------------------------------------------");
                    JogoBlackJack carregar = new JogoBlackJack();
                    carregar.playGame();
                }
                if (input == 2) {
                    System.out.println("");
                    System.out.println("#1 : Modo Unico single player(1 Jogador).\nRegra de Cassino : Em caso de empate, a vitória é da casa(dealer).");
                    System.out.println("#2 : A principio você recebe 2 cartas e o Dealer recebe 1. Você poderá decidir se quer continuar recebendo cartas (hit) ou se quer encerrar (stand).");
                    System.out.println("#3 : Você pode pedir quantas cartas forem necessárias, contato que não ultrapasse 21 pontos.");
                    System.out.println("#4 : Se o jogador conseguir um BlackJack no inicio, ou seja, após virar somente 2 cartas, e no caso elas forem um Às e outro 10/J/Q/K, a vitória é do jogador, sem nenhuma chance para o Dealer tentar conseguir um BlackJack.");
                    System.out.println("#5 : O Dealer encerra(stand) em caso de pontuação de 17 ou maior.");
                    System.out.println("#6 : Com apostas e sistema de contagem de vitórias e derrotas.");
                    System.out.println("-----------------------------------------------");
                    System.out.println("Funções/Regras em criação(NÃO DISPONIVEIS NO MOMENTO): ");
                    System.out.println("[EM BREVE]Criação de mais 2 jogadores controlados pela CPU.");
                    System.out.println("[EM BREVE]Função Double ( para dobrar as apostas ).");
                    System.out.println("[EM BREVE]Função Splitter ( para caso você receber 2 cartas iguais, poder separar elas em duas mãos e apostar o mesmo valor inicial em cada uma).");
                    System.out.println("[EM BREVE]Função Safe ( caso a carta inicial do Dealer for um Às o jogador poderá diminuir a aposta inicial para a metade).");
                    System.out.println("[EM BREVE]Função Surrender ( desistir ).");
                    System.out.println("[EM BREVE]Melhorar o valor ganho da aposta em caso de BlackJack inicial para apenas 1,5x a aposta inicial (#4).");
                    System.out.println("-----------------------------------------------");
                    JogoBlackJack carregar = new JogoBlackJack();
                    carregar.playGame();
                }
            }
        } // CASO OCORRER ALGUM ERRO INESPERADO.
        catch (IOException ioe) {
            System.out.println("");
            System.out.println("IO error na tentativa de ler o comando de input!\r\n");
            System.out.println("-----------------------------------------------");
            System.exit(1);
        }
    }
}
