package jogoBlackJack;
import java.util.ArrayList;

public class Mao {
    public static int[] recebeValores(ArrayList<Carta> list) {
        //Procura o valor minimo da mão.
        int countMin = 0;
        for (Carta x : list) {
            countMin = countMin + x.recebeValor();
        }
        //procura o valor máximo da mão e checa se o Às pode ser usado.
        int countMax = 0;
        boolean usarOnze = false;
        for (Carta y : list) {
            if (y.recebeValor() == 1 && !usarOnze) {
                // Verifica se existe um Às na mão, e se é preciso usar o Às como 11.
                countMax = countMax + 11;
                usarOnze = true;
            } else {
                countMax = countMax + y.recebeValor();
            }
        }
        //Verifica se countMax pode ser aplicado ( não da game over ). Se Às = 11 resultar em gameover, voltar o valor de Às = 1.
        if (countMax > 21) {
            countMax = countMin;
        }
        //Coloca o valor em uma array e envia de volta para o jogo.
        int[] valorMao = {countMin, countMax};
        return valorMao;
    }
}