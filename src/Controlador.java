public class Controlador {


    private String nomeEquipe;
    private int posicaoX = 0;
    private int posicaoY = 0;
    private int[] direcao = {0, 1};

    private int quantidadeBarris = 0;


    public Controlador(String nomeEquipe){

        this.nomeEquipe = nomeEquipe;

    }


    public void anda(Terreno terreno){


        int largura = terreno.getLargura();
        int comprimento = terreno.getComprimento();

        posicaoX += direcao[0];
        posicaoY += direcao[1];

        if(posicaoX < 0)
            posicaoX = 0;
        if(posicaoY < 0)
            posicaoY = 0;

        if(posicaoX >= largura)
            posicaoX = largura-1;
        if(posicaoY >= comprimento)
            posicaoY = comprimento-1;


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

        return terreno.buscarCelula(posicaoX, posicaoY).concentracaoHelio;

    }

    public float sensorRugosidade(Terreno terreno){

        return terreno.buscarCelula(posicaoX, posicaoY).rugosidade;

    }


    public int sensorTempo(int tempo){

        return tempo;

    }


    public void coleta(Terreno terreno){

        float concentracaoHelio3 = terreno.buscarCelula(posicaoX, posicaoY).concentracaoHelio;
        float coeficienteErro = terreno.buscarCelula(posicaoX, posicaoY).coeficienteErro;

        quantidadeBarris += (int)(((1-coeficienteErro) * concentracaoHelio3) * 10);


    }


}
