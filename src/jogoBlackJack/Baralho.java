package jogoBlackJack;
import java.util.ArrayList;
public class Baralho {
    static ArrayList<Carta> cartas = new ArrayList<Carta>();
    /* Pega um valor randomico entre 0-1 usando MathRandom e multiplica por 52
    Exemplo: 0,6 * 52 = 31,2, e depois será arredondada para com o MathCeil e a 32° carta será distribuida. */
    public static Carta recebeCarta() {
        double cartaAleatoria = Math.ceil(Math.random() * 52);
        int cartaNumero = (int) cartaAleatoria;
        return cartas.get(cartaNumero - 1);
    }
    public static void defineCartas() {
        //Declarado os 4 Naipes
        String[] naipes = {"Paus", "Ouros", "Copas", "Espadas"};
        
        /* Na lógica é feito um loop para criar 4 cartas ( contador começa em 1 e acaba no 4, já que quando i(contador) = 5 é parado o loop.
        É pego da lista de cartas ( ArrayList<Carta> no qual é tratada igual um tabela e adiciona os valores de :
        Naipe --> naipes[i - 1] (é selecionado um naipe e posicionado na posição calculada, i = 1 forma o calculo 1-1, ou seja indice 0 da array, i = 2, 2 - 1 = 1, indice 1 ...
        Nome ---> cada repetição possui um nome exclusivo, para poder criar 4 cartas com o mesmo nome, mas naipe diferente.
        Valor --> e por fim o valor que aquela carta vai possuir, assim como o nome, cada repetição tera um valor fixo, mas com naipe diferente.*/
        //Cria 4 Às, 1 de cada Naipe com valor 1, No qual no também pode se transformar em 11 ( de acordo com a situação das regras ).
        for (int i = 1; i < 5; i++) {
            cartas.add(new Carta(naipes[i - 1], "Às", 1));
        }
        //Cria 4 Valetes, 1 de cada Naipe com valor 10
        for (int i = 1; i < 5; i++) {
            cartas.add(new Carta(naipes[i - 1], "Valete", 10));
        }
        //Cria 4 Damas, 1 de cada Naipe com valor 10
        for (int i = 1; i < 5; i++) {
            cartas.add(new Carta(naipes[i - 1], "Dama", 10));
        }
        //Cria 4 Reis, 1 de cada Naipe com valor 10
        for (int i = 1; i < 5; i++) {
            cartas.add(new Carta(naipes[i - 1], "Rei", 10));
        }

        //Cria 4 Dois
        for (int i = 1; i < 5; i++) {
            cartas.add(new Carta(naipes[i - 1], "Dois", 2));
        }
        //Cria 4 Tres
        for (int i = 1; i < 5; i++) {
            cartas.add(new Carta(naipes[i - 1], "Tres", 3));
        }
        //Cria 4 Quatro
        for (int i = 1; i < 5; i++) {
            cartas.add(new Carta(naipes[i - 1], "Quatro", 4));
        }
        //Cria 4 Cinco
        for (int i = 1; i < 5; i++) {
            cartas.add(new Carta(naipes[i - 1], "Cinco", 5));
        }
        //Cria 4 Seis
        for (int i = 1; i < 5; i++) {
            cartas.add(new Carta(naipes[i - 1], "Seis", 6));
        }
        //Cria 4 Sete
        for (int i = 1; i < 5; i++) {
            cartas.add(new Carta(naipes[i - 1], "Sete", 7));
        }
        //Cria 4 Oito
        for (int i = 1; i < 5; i++) {
            cartas.add(new Carta(naipes[i - 1], "Oito", 8));
        }
        //Cria 4 Nove
        for (int i = 1; i < 5; i++) {
            cartas.add(new Carta(naipes[i - 1], "Nove", 9));
        }
        //Cria 4 Dez
        for (int i = 1; i < 5; i++) {
            cartas.add(new Carta(naipes[i - 1], "Dez", 10));
        }
    }
}