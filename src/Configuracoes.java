public class Configuracoes {

    private int duracaoPartida;
    private Controlador[] jogadores;


    public Configuracoes(int duracaoPartida, Controlador[] jogadores){

        this.duracaoPartida = duracaoPartida;
        this.jogadores = jogadores;

    }

    public Controlador[] getJogadores() {
        return jogadores;
    }

    public int getDuracaoPartida() {
        return duracaoPartida;
    }

}
