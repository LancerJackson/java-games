package jogoBlackJack;
//Handles player turn + deal turn and the rules of the game
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class JogoBlackJack {
    //Initial setup

    ArrayList<Carta> cards = new ArrayList<Carta>();
    int vitorias;
    int derrotas;
    int jogadorFichas;
    int fichasApostadas;
    String jogadorNome;

	//creates a new deck each session, keeps the game going after a win/loss and prompts user what to do next. 
    //restarts program after game but still tracks wins/losses
    public void playGame() {
        Scanner input = new Scanner(System.in);
        System.out.println("Bem vindo ao BlackJack, antes de iniciarmos, por favor informe seu nome.");
        jogadorNome = input.next();
        System.out.println("-----------------------------------------------");
        System.out.println("Quantas fichas deseja comprar?\nExemplo: Se quiser iniciar com o total de 100$ em fichas, digite 100");
        jogadorFichas = input.nextInt();
        
        Baralho.defineCartas();
        boolean continuarJogo = true;
        do{
            iniciarAposta();
            System.out.println(jogadorNome + ", deseja continuar jogando?\nSIM - PARA CONTINUAR JOGANDO.\nNAO - PARA VOLTAR AO MENU DE JOGOS.");
            String continuarSN = input.next();
            // possiveis respostas para SIM/TRUE, e colocar o boolean para true;
            if(continuarSN.equalsIgnoreCase("sim") || continuarSN.equalsIgnoreCase("s") || continuarSN.equalsIgnoreCase("yes") || continuarSN.equalsIgnoreCase("si") || continuarSN.equalsIgnoreCase("Sim") || continuarSN.equalsIgnoreCase("SIM") || continuarSN.equalsIgnoreCase("S"))
                continuarJogo = true;
            // possiveis respostas para NAO/FALSE, e colocar o boolean para false;
            if(continuarSN.equalsIgnoreCase("não") || continuarSN.equalsIgnoreCase("nao") || continuarSN.equalsIgnoreCase("n") || continuarSN.equalsIgnoreCase("no") || continuarSN.equalsIgnoreCase("Não") || continuarSN.equalsIgnoreCase("Nao") || continuarSN.equalsIgnoreCase("NÃO") || continuarSN.equalsIgnoreCase("NAO") || continuarSN.equalsIgnoreCase("N"))
                continuarJogo = false;
            if(jogadorFichas <= 0){
                System.out.println("-----------------------------------------------");
                System.out.println(jogadorNome + ", seu saldo de Fichas é de : " + jogadorFichas + ".\nDeseja adicionar mais fichas ?");
                String adicionarFichas = input.next();
                if(adicionarFichas.equalsIgnoreCase("sim") || adicionarFichas.equalsIgnoreCase("s") || adicionarFichas.equalsIgnoreCase("yes") || adicionarFichas.equalsIgnoreCase("si") || adicionarFichas.equalsIgnoreCase("Sim") || adicionarFichas.equalsIgnoreCase("SIM") || adicionarFichas.equalsIgnoreCase("S")){
                    System.out.println("Quantas fichas deseja comprar?");
                    jogadorFichas = input.nextInt();
                }
                if(adicionarFichas.equalsIgnoreCase("não") || adicionarFichas.equalsIgnoreCase("nao") || adicionarFichas.equalsIgnoreCase("n") || adicionarFichas.equalsIgnoreCase("no") || adicionarFichas.equalsIgnoreCase("Não") || adicionarFichas.equalsIgnoreCase("Nao") || adicionarFichas.equalsIgnoreCase("NÃO") || adicionarFichas.equalsIgnoreCase("NAO") || adicionarFichas.equalsIgnoreCase("N")){
                    continuarJogo = false;
                }
            }
        } while (continuarJogo);
        System.out.println("-----------------------------------------------");
        System.out.println("Você decidiu sair, total de fichas Final : " + jogadorFichas);
    }
    public void iniciarAposta(){
        System.out.println("-----------------------------------------------");
        System.out.println("Você possui R$" + jogadorFichas + " fichas.\nQuantas fichas você deseja apostar nessa rodada?");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            fichasApostadas = Integer.parseInt(br.readLine());
            if(fichasApostadas > jogadorFichas) {
                System.out.println("");
                System.out.println("Você está tentando adicionar uma quantidade maior do que possui.\nVocê possui apenas : " + jogadorFichas);
                iniciarAposta();
            }
            else if(fichasApostadas <= 0) {
                System.out.println("");
                System.out.println("Não é possivel apostar 0 ou menos de 0.");
            }
            else {
                jogadorFichas = jogadorFichas - fichasApostadas;
                inicarRodada();
            }
        }catch(IOException ioe) {
            System.out.println("");
            System.out.println("IO error na tentativa de ler o comando de input!\r\n");
            System.exit(1);
        }
    }
    public void inicarRodada() {
        Scanner input = new Scanner(System.in);
        //Embaralha as cartas da mão a cada rodada.
        int dealerMinValor = 0;
        int dealerMaxValor = 0;
        int jogadorMinValor = 0;
        int jogadorMaxValor = 0;
        System.out.println("-----------------------------------------------");
        System.out.println("Embaralhando Cartas... Distribuindo Cartas\n");
        // Array que possui as cartas do Dealer
        ArrayList<Carta> dealerCartas = new ArrayList<Carta>();
        // Array que possui as cartas do Jogador
        ArrayList<Carta> jogadorCartas = new ArrayList<Carta>();
        //Dealers -> primeira compra de carta.
        dealerCartas.add(Baralho.recebeCarta());
        System.out.println("O dealer recebeu a carta : " + dealerCartas.get(0).recebeTexto());
        int[] dealerMaoValor = Mao.recebeValores(dealerCartas);
        dealerMinValor = dealerMaoValor[0];
        dealerMaxValor = dealerMaoValor[1];
        if (dealerMinValor == dealerMaxValor) {
            System.out.println("O Dealer possui : " + dealerMinValor);
        } else {
            //Dealer -> Encerra primeira compra.
            System.out.println("O Dealer possui : " + dealerMinValor + " ou " + dealerMaxValor + " devido ao Às.");
        }
        boolean fimRound = false;
        boolean fimTurnoJogador = false;
        
        //[INICIO] TURNO DO JOGADOR
        //Jogador recebe 2 cards
        jogadorCartas.add(Baralho.recebeCarta());
        jogadorCartas.add(Baralho.recebeCarta());
        //Define a array da mão do jogador com 2 valores, [jogadorMinValor] [jogadorMaxValor]
        int[] jogadorValorMao = Mao.recebeValores(jogadorCartas);
        jogadorMinValor = jogadorValorMao[0];
        jogadorMaxValor = jogadorValorMao[1];
        // Jogador olha as 2 cartas recebidas.
        System.out.println("\nVocê recebeu a carta : " + jogadorCartas.get(0).recebeTexto());
        System.out.println("Você recebeu a carta : " + jogadorCartas.get(1).recebeTexto());
        // Informa pontuação do jogador.
        if (jogadorMinValor == jogadorMaxValor) {
            System.out.println("Você possui : " + jogadorMinValor);
        } else {
            System.out.println("Você possui : " + jogadorMinValor + " ou " + jogadorMaxValor + " devido ao Às.");
            System.out.println("-----------------------------------------------");
        }
        // Caso jogador Possuir um BlackJack inicial.
        if (jogadorMaxValor == 21) {
            System.out.println("você possui um BlackJack!\nVocê Ganhou.");
            vitorias++;
            jogadorFichas = jogadorFichas + (fichasApostadas * 2);
            System.out.println("Você ganhou " + (jogadorFichas + (fichasApostadas * 2)) + "\n Fichas Atuais :" + jogadorFichas);
            System.out.println("Vitórias: " + vitorias);
            System.out.println("Derrotas: " + derrotas);

            fimRound = true;
            fimTurnoJogador = true;
        }
        String position = "";
        if (!fimTurnoJogador && !fimRound) {
            System.out.println("-----------------------------------------------");
            System.out.println("Escolha uma ação.");
            System.out.println("1. Hit / Pedir Nova Carta.");
            System.out.println("2. Stand / Encerrar / Manter.");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            try {
                int acao = Integer.parseInt(br.readLine());
                if(acao < 0 || acao > 2) {
                    System.out.println("Ação Incorreta /ou Inexistente.\r\n");
                }
                else {
                    if(acao == 1)
                        position = "1";
                    if(acao == 2)
                        position = "2";
                }
            }
            catch (IOException ioe) {
                System.out.println("");
                System.out.println("IO error na tentativa de ler o comando de input!\r\n");
                System.exit(1);
            }
        }
        //Caso o jogador escolher HIT / PEDIR NOVA CARTA, é entregue uma nova carta do baralho, a ele.
        while (!fimTurnoJogador && !fimRound) {
            if (position.equals("1")) {
                jogadorCartas.add(Baralho.recebeCarta());
                jogadorValorMao = Mao.recebeValores(jogadorCartas);
                jogadorMinValor = jogadorValorMao[0];
                jogadorMaxValor = jogadorValorMao[1];
                System.out.println("Você recebeu a carta : " + jogadorCartas.get(jogadorCartas.size() - 1).recebeTexto());
                //Caso possuir um Às na mão, o jogador possuirá 2 valores devido ao Às valer 1 ou 11 pontos, caso contrário apenas 1.
                if (jogadorMinValor == jogadorMaxValor) {
                    System.out.println("Você possui : " + jogadorMinValor);
                } else {
                    System.out.println("Você possui : " + jogadorMinValor + " ou " + jogadorMaxValor + " devido ao Às.");
                }
                //Caso a compra deu uma nova carta do jogador, fizer a pontuação do jogador estourar, o jogo se encerra.
                if (jogadorMaxValor > 21) {
                    fimRound = true;
                    fimTurnoJogador = true;
                    System.out.println("-----------------------------------------------");
                    System.out.println("Sua pontuação estourou.\nVocê Perdeu.");
                    derrotas++;
                    System.out.println("Você perdeu " + fichasApostadas + "\t--\tFichas Atuais :" + jogadorFichas);
                    System.out.println("-----------------------------------------------");
                    System.out.println("Vitorias : " + vitorias);
                    System.out.println("Derrotas : " + derrotas);
                    System.out.println("-----------------------------------------------");
                }
                // Caso a compra fizer o jogador conseguir 21 pontos, é dado a vitória para ele ( BlackJack ).
                if (jogadorMaxValor == 21) {
                    fimRound = true;
                    fimTurnoJogador = true;
                    System.out.println("-----------------------------------------------");
                    System.out.println("Você possui um BlackJack!\nVocê Ganhou.");
                    vitorias++;
                    jogadorFichas = jogadorFichas + (fichasApostadas * 2);
                    System.out.println("Você ganhou " + (jogadorFichas + (fichasApostadas * 2)) + "\t--\tFichas Atuais :" + jogadorFichas);
                    System.out.println("-----------------------------------------------");
                    System.out.println("Vitorias : " + vitorias);
                    System.out.println("Derrotas : " + derrotas);
                    System.out.println("-----------------------------------------------");
                }
            }
            //Caso o jogador Selecionar a opção Stand.
            if (position.equalsIgnoreCase("2")) {
                System.out.println("-----------------------------------------------");
                System.out.println("Você manteve/encerrou.");
                fimTurnoJogador = true;
            }
            //Caso o jogador não tiver estourado e nem conseguido 21 pontos, o menu de ações irá aparecer novamente.
            if (!fimTurnoJogador) {
                System.out.println("-----------------------------------------------");
                System.out.println("Escolha uma ação.");
                System.out.println("1. Hit / Pedir Nova Carta.");
                System.out.println("2. Stand / Encerrar / Manter.");
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                try {
                    int acao = Integer.parseInt(br.readLine());
                    if(acao < 0 || acao > 2) {
                        System.out.println("Ação Incorreta /ou Inexistente.\r\n");
                    }
                    else {
                        if(acao == 1)
                            position = "1";
                        if(acao == 2)
                            position = "2";
                    }
                }
                catch (IOException ioe) {
                    System.out.println("");
                    System.out.println("IO error na tentativa de ler o comando de input!\r\n");
                    System.exit(1);
                }
            }
        }
        //[FIM] TURNO DO JOGADOR
        //[INICIO] TURNO DO DEALER
        boolean fimTurnoDealer = false;
        while (!fimTurnoDealer && !fimRound) {
            /*O loop irá continuar acontecendo caso o valor da mão do Dealer (dealerMaoValor) estiver abaixo de 17.
            E caso o valor da mão do Dealer (dealerMaoValor) estiver >=17(maior ou igual a 17) irá realizar as ações a seguir, até atingir um valor maior que 16.*/
            dealerCartas.add(Baralho.recebeCarta());
            System.out.println("\nO dealer recebeu a carta : " + dealerCartas.get(dealerCartas.size() - 1).recebeTexto());
            //Define a array da mão do dealer com 2 valores, [dealerMinValor] [dealerMaxValor]
            dealerMaoValor = Mao.recebeValores(dealerCartas);
            dealerMinValor = dealerMaoValor[0];
            dealerMaxValor = dealerMaoValor[1];
            //Caso possuir um Às na mão, o dealer possuirá 2 valores devido ao Às valer 1 ou 11 pontos, caso contrário apenas 1.
            if (dealerMinValor == dealerMaxValor) {
                System.out.println("O Dealer possui : " + dealerMinValor);
            } else {
                System.out.println("O Dealer possui : " + dealerMinValor + " ou " + dealerMaxValor + " devido ao Às.");
            }
            if (dealerMaxValor >= 17 && dealerMaxValor < 22) {
                if (dealerMaxValor == 21) {
                    System.out.println("-----------------------------------------------");
                    System.out.println("Dealer possui um BlackJack.\nVocê Perdeu.");
                    derrotas++;
                    System.out.println("Você perdeu " + fichasApostadas + "\t--\tFichas Atuais :" + jogadorFichas);
                    System.out.println("-----------------------------------------------");
                    System.out.println("Vitorias : " + vitorias);
                    System.out.println("Derrotas : " + derrotas);
                    System.out.println("-----------------------------------------------");
                    fimTurnoDealer = true;
                    fimRound = true;
                }
                //O Dealer decidiu parar, mas possui uma pontuação menor que a do jogador.
                else if (dealerMaxValor < jogadorMaxValor) {
                    System.out.println("-----------------------------------------------");
                    System.out.println("Você possui uma pontuação mais alta que o Dealer.\nVocê Ganhou.");
                    vitorias++;
                    jogadorFichas = jogadorFichas + (fichasApostadas * 2);
                    System.out.println("Você ganhou " + (jogadorFichas + (fichasApostadas * 2)) + "\t--\tFichas Atuais :" + jogadorFichas);
                    System.out.println("-----------------------------------------------");
                    System.out.println("Vitorias : " + vitorias);
                    System.out.println("Derrotas : " + derrotas);
                    System.out.println("-----------------------------------------------");

                    fimTurnoDealer = true;
                    fimRound = true;
                }
                //O Dealer e o jogador possuem uma mão com pontuação igual. De acordo com as regras do Cassino a vitória é do Dealer.
                else if (dealerMaxValor == jogadorMaxValor) {
                    System.out.println("-----------------------------------------------");
                    System.out.println("Você empatou com o Dealer.\nDevido as regras da casa, você perdeu.");
                    derrotas++;
                    System.out.println("Você perdeu " + fichasApostadas + "\t--\tFichas Atuais :" + jogadorFichas);
                    System.out.println("-----------------------------------------------");
                    System.out.println("Vitorias : " + vitorias);
                    System.out.println("Derrotas : " + derrotas);
                    System.out.println("-----------------------------------------------");
                    fimTurnoDealer = true;
                    fimRound = true;
                }
                else {
                    System.out.println("-----------------------------------------------");
                    System.out.println("O Dealer possui uma pontuação mais alta que você.\nVocê Perdeu.");
                    derrotas++;
                    System.out.println("Você perdeu " + fichasApostadas + "\t--\tFichas Atuais :" + jogadorFichas);
                    System.out.println("-----------------------------------------------");
                    System.out.println("Vitorias : " + vitorias);
                    System.out.println("Derrotas : " + derrotas);
                    System.out.println("-----------------------------------------------");
                    fimTurnoDealer = true;
                    fimRound = true;
                }

            }
            //Caso o Dealer tiver estourado a pontuação.
            if (dealerMaxValor > 21) {
                System.out.println("-----------------------------------------------");
                System.out.println("A pontuação do Dealer estourou.\nVocê Ganhou!");
                vitorias++;
                jogadorFichas = jogadorFichas + (fichasApostadas * 2);
                System.out.println("Você ganhou " + (jogadorFichas + (fichasApostadas * 2)) + "\t--\tFichas Atuais :" + jogadorFichas);
                System.out.println("-----------------------------------------------");
                System.out.println("Vitorias : " + vitorias);
                System.out.println("Derrotas : " + derrotas);
                System.out.println("-----------------------------------------------");
                fimTurnoDealer = true;
                fimRound = true;
            }
        }
    }
}
