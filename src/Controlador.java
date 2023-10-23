public class Controlador {


    private String nomeEquipe;
    private int posicaoX = 0;
    private int posicaoY = 0;
    private int[] direcao = {0, 1};

    private int quantidadeBarris = 0;

    private String estado = "livre";

    private int tempoInicioAcao = -1;


    public Controlador(String nomeEquipe){

        this.nomeEquipe = nomeEquipe;

    }


    public void anda(Terreno terreno, int tempo){

        estado = "andando";
        tempoInicioAcao = tempo;

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

    public void esquerda(int tempo){

        estado = "girando";
        tempoInicioAcao = tempo;

        int direcaoPrevia = direcao[0];

        direcao[0] = direcao[1] * -1;
        direcao[1] = direcaoPrevia;

    }


    public void direita(int tempo){

        estado = "girando";
        tempoInicioAcao = tempo;

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

    public String getEstado(){
        return estado;
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


    public void coleta(Terreno terreno, int tempo){

        estado = "coletando";
        tempoInicioAcao = tempo;


        float concentracaoHelio3 = terreno.buscarCelula(posicaoX, posicaoY).concentracaoHelio;
        float coeficienteErro = terreno.buscarCelula(posicaoX, posicaoY).coeficienteErro;

        quantidadeBarris += (int)(((1-coeficienteErro) * concentracaoHelio3) * 10);


    }


    public void atualizaAcao(Terreno mapa, String acao, int tempoDecorrido){

        switch(acao){

            case("anda"):
                anda(mapa, tempoDecorrido);
                break;
            case("esquerda"):
                esquerda(tempoDecorrido);
                break;
            case("direita"):
                direita(tempoDecorrido);
                break;
            case("coleta"):
                coleta(mapa, tempoDecorrido);
                break;
            case("sensores"):
                System.out.printf("===========\n%d %d\n%.2f Concentração\n%.2f Rugosidade \n%d s\n==========\n",
                        getPosicaoX(),
                        getPosicaoY(),
                        sensorConcentracao(mapa),
                        sensorRugosidade(mapa),
                        sensorTempo(tempoDecorrido));
                break;
            default:
                break;
        }
    }


    public void atualizaEstado(int tempoDecorrido){


        int duracaoAcao = 0;

        switch(estado){
            case "livre":
                break;
            case "andando":
                duracaoAcao = 2;
                break;
            case "girando":
                duracaoAcao = 1;
                break;
            case "coletando":
                duracaoAcao = 4;
                break;
        }

        if(tempoDecorrido >= tempoInicioAcao + duracaoAcao){
            estado = "livre";
            tempoInicioAcao = -1;
        }

    }


}
