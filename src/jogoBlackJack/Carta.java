package jogoBlackJack;
public class Carta {
    //Variaveis iniciais
    private String naipe;
    private String nome;
    private int valor;
    /* Atributos/parametros das cartas, cada carta possui 3 atributos/parametros. 
     Naipe(para possuir 4 cartas de msm valor com Naipe diferente,
     Nome(para saber qual carta é, um, dois, tres ... dez, valete, dama, rei, às)
     valor(para poder fazer a contagem do blackjack */
    public Carta(String naipe, String nome, int valor) {
        this.naipe = naipe;
        this.nome = nome;
        this.valor = valor;
    }
    //Criar retorno para printar/exibir no jogo o texto completo ( NOME/VALOR DA CARTA + de + NAIPE -- Exemplo : Dez de Ouro )
    public String recebeTexto() {
        String fullName = nome + " de " + naipe;
        return fullName;
    }
    public int recebeValor() {
        return valor;
    }
}
