public class Controlador {


    private String nomeEquipe;
    private int posicaoX;
    private int posicaoY;
    private int[] direcao = {0, 1};

    private int quantidadeBarris = 0;


    public Controlador(String nomeEquipe){

        this.nomeEquipe = nomeEquipe;

    }


    public void anda(){

        posicaoX += direcao[0];
        posicaoY += direcao[1];

    }

    public void esquerda(){

        int direcaoPrevia = direcao[0];

        direcao[0] = direcao[1] * -1;
        direcao[1] = direcaoPrevia;

    }


    public void direita(){

        int direcaoPrevia = direcao[1];

        direcao[1] = direcao[0] * -1;
        direcao[0] = direcaoPrevia;

    }



    public String getNomeEquipe(){

        return nomeEquipe;

    }
    public int getPosicaoX(){
        return posicaoX;
    }

    public int getPosicaoY(){
        return posicaoY;
    }


    public int getQuantidadeBarris() {
        return quantidadeBarris;
    }

    public float sensorConcentracao(Terreno terreno){

        return terreno.buscarCelula(posicaoX, posicaoY).concentraçãoHelio;

    }

    public float sensorRugosidade(Terreno terreno){

        return terreno.buscarCelula(posicaoX, posicaoY).rugosidade;

    }


    public int sensorTempo(Jogo mestre){

        return mestre.tempoDecorrido;

    }


    public void coleta(Terreno terreno){

        float concentracaoHelio3 = terreno.buscarCelula(posicaoX, posicaoY).concentraçãoHelio;
        float coeficienteErro = terreno.buscarCelula(posicaoX, posicaoY).coeficienteErro;

        quantidadeBarris += (int)(((1-coeficienteErro) * concentracaoHelio3) * 10);

    }

}
