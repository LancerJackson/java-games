/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogoQuiz;
import menu.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import Palavra.Palavra;

/**
 *
 * @author Marketing
 */
public class JogoQuiz {
    public void iniciar() {
        Scanner input = new Scanner(System.in);
        Random r = new Random();
        boolean quizJogarDenovo = true;
        do{
            // OPCAO PARA CASO A PESSOA DECIDIR SE QUER VOLTAR AO MENU OU FECHAR O PROGRAMA.
            
            List<Palavra> palavras = IniciarPrograma();
            String continuarSN;
            boolean deveCriar = false;
            
            do {

                System.out.println("Deseja cadastrar alguma palavra adicional?");
                continuarSN = input.next();
            	
            	if(continuarSN.equalsIgnoreCase("sim") || continuarSN.equalsIgnoreCase("s") || continuarSN.equalsIgnoreCase("yes") || continuarSN.equalsIgnoreCase("si") || continuarSN.equalsIgnoreCase("Sim") || continuarSN.equalsIgnoreCase("SIM") || continuarSN.equalsIgnoreCase("S"))
            	{
            		deveCriar = true;
            		
            		System.out.println("Informe a palavra:");
            		String palavra = input.next();
            		
            		System.out.println("Informe a primeira dica: ");
            		String dica1 = input.next();
            		
            		System.out.println("Informe a segunda dica: ");
            		String dica2 = input.next();
            		
            		System.out.println("Informe a terceira dica: ");
            		String dica3 = input.next();
            		
            		Palavra object = new Palavra(palavra, dica1, dica2, dica3);
            		palavras.add(object);
            		
            		System.out.println("A nova palavra foi cadastrada com sucesso!");
            	}
            	else
            		deveCriar = false;
            	
            } while(deveCriar);
            
            int pontos = 0;
            
            System.out.println("Vamos configurar o jogo...");
            System.out.println("Temos o total de " + palavras.size() + " palavras. Deseja jogar com quantas palavras?");
            
            int numeroPalavras = input.nextInt();
            
            for(int i = 0; i < numeroPalavras; i++) 
            {
            	Palavra palavraEscolhida = palavras.get(r.nextInt(palavras.size()));
            	if(!palavraEscolhida.JaFoiUtilizada()) 
            	{          		
            		String palavraDigitada;
	            	
	            	System.out.println("Dica 1, valendo 10 pontos:");
	            	System.out.println(palavraEscolhida.GetDica1());
	            	
	            	palavraDigitada = input.next();
	            	
	
	            	if(palavraEscolhida.GetPalavra().equalsIgnoreCase(palavraDigitada)) {
	            		System.out.println("Parabéns, você acertou! +10 pontos!!!");
	            		pontos += 10;
	            	}
	            	else 
	            	{
	            		System.out.println("Você errou... Vamos para a dica 2, valendo 9 pontos");
	            		System.out.println(palavraEscolhida.GetDica2());
	            		
	            		palavraDigitada = input.next();
	            		
	            		if(palavraEscolhida.GetPalavra().equalsIgnoreCase(palavraDigitada)) 
	            		{
	            			System.out.println("Parabéns, você acertou! +9 pontos!!!");
	            			pontos += 9;
	            		}
	            		else 
	            		{
	            			System.out.println("Você errou... Vamos para a dica 3, valendo 8 pontos");
	            			System.out.println(palavraEscolhida.GetDica3());
	            		
	            			palavraDigitada = input.next();
	            		
	            			if(palavraEscolhida.GetPalavra().equalsIgnoreCase(palavraDigitada)) 
	            			{
	            				System.out.println("Parabéns, você acertou! +8 pontos!!!");
	            				pontos += 8;
	            			}
	            			else 
	            				System.out.println("Você errou... Vamos para a próxima palavra ");
	            		}
	            	}
            	}
            }
            
            System.out.println("O jogo terminou. Sua pontuação foi de " + pontos + " pontos.");
                       	
            System.out.println("Deseja continuar jogando?");
            continuarSN = input.next();
            // possiveis respostas para SIM/TRUE, e colocar o boolean para true;
            if(continuarSN.equalsIgnoreCase("sim") || continuarSN.equalsIgnoreCase("s") || continuarSN.equalsIgnoreCase("yes") || continuarSN.equalsIgnoreCase("si") || continuarSN.equalsIgnoreCase("Sim") || continuarSN.equalsIgnoreCase("SIM") || continuarSN.equalsIgnoreCase("S"))
                    quizJogarDenovo = true;
            // possiveis respostas para NAO/FALSE, e colocar o boolean para false;
            if(continuarSN.equalsIgnoreCase("não") || continuarSN.equalsIgnoreCase("nao") || continuarSN.equalsIgnoreCase("n") || continuarSN.equalsIgnoreCase("no") || continuarSN.equalsIgnoreCase("Não") || continuarSN.equalsIgnoreCase("Nao") || continuarSN.equalsIgnoreCase("NÃO") || continuarSN.equalsIgnoreCase("NAO") || continuarSN.equalsIgnoreCase("N"))
                    quizJogarDenovo = false;
        } while (quizJogarDenovo);
    }
    
    public List<Palavra> IniciarPrograma() {
    	List<Palavra> palavras = new ArrayList<Palavra>();

    	Palavra palavra0 = new Palavra("SBT", "Canal TV", "Aberto", "Silvio Santos");
    	palavras.add(palavra0);

    	Palavra palavra1 = new Palavra("Gorila", "Mamífero", "Primata", "Forte");
    	palavras.add(palavra1);

    	Palavra palavra2 = new Palavra("Leopardo", "Mamífero", "Felino", "Rapido");
    	palavras.add(palavra2);

    	Palavra palavra3 = new Palavra("Esponja", "É macia", "Usa no banho", "Usa no rosto");
    	palavras.add(palavra3);

    	Palavra palavra4 = new Palavra("Sacola", "Usa na feira", "Usa no lixo", "Tem no mercado");
    	palavras.add(palavra4);

    	Palavra palavra5 = new Palavra("Semaforo", "O carro para", "O carro anda", "Quando chove, não funciona");
    	palavras.add(palavra5);

    	Palavra palavra6 = new Palavra("Chaves", "Tem na porta", "Tem no automóvel", "Passa até hoje no SBT");
    	palavras.add(palavra6);

    	Palavra palavra7 = new Palavra("Lousa", "É preto ou branco", "Escola", "Giz ou canetão");
    	palavras.add(palavra7);

    	Palavra palavra8 = new Palavra("Açougue", "Comércio", "Usa facão", "Tem balança");
    	palavras.add(palavra8);

    	Palavra palavra9 = new Palavra("Empada", "Tem de frango", "Tem de carne", "Massa seca");
    	palavras.add(palavra9);
    	
    	return palavras;
    }
}

