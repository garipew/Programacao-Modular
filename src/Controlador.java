public class Controlador {


    private String nomeEquipe;
    private int posicaoX = 0;
    private int posicaoY = 0;
    private int[] direcao = {0, 1};

    private int quantidadeBarris = 0;

    private String estado = "livre";

    private int tempoInicioAcao = -1;


    public Controlador(String nomeEquipe, int posicaoX, int posicaoY){

        this.nomeEquipe = nomeEquipe;
        this.posicaoX = posicaoX;
        this.posicaoY = posicaoY;


    }


    public void anda(Terreno terreno, int tempo){

        Celula antigaCelula = terreno.buscarCelula(posicaoX, posicaoY);
        Celula novaCelula;

        int novaPosicaoX = posicaoX + direcao[0];
        int novaPosicaoY = posicaoY + direcao[1];

        novaCelula = terreno.buscarCelula(novaPosicaoX, novaPosicaoY);

        estado = "andando";
        tempoInicioAcao = tempo;

        int largura = terreno.getLargura();
        int comprimento = terreno.getComprimento();


        if(novaPosicaoX < 0)
            novaPosicaoX = 0;
        if(novaPosicaoY < 0)
            novaPosicaoY = 0;

        if(novaPosicaoX >= largura)
            novaPosicaoX = largura-1;
        if(novaPosicaoY >= comprimento)
            novaPosicaoY = comprimento-1;

        if(!novaCelula.celulaOcupada){

            novaCelula.celulaOcupada = true;
            System.out.printf("%d %d OCUPADA\n", novaCelula.getCoordenadaX(), novaCelula.getCoordenadaY());
            antigaCelula.celulaOcupada = false;

            posicaoX = novaPosicaoX;
            posicaoY = novaPosicaoY;
        }


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

        return terreno.buscarCelula(posicaoX, posicaoY).getConcentracaoHelio();

    }

    public float sensorRugosidade(Terreno terreno){

        return terreno.buscarCelula(posicaoX, posicaoY).getRugosidade();

    }


    public int sensorTempo(int tempo){

        return tempo;

    }


    public void sensores(Terreno mapa, int tempoDecorrido){
        System.out.printf("===========\n%s\n%d %d\n%.2f Concentração\n%.2f Rugosidade \n%d s\nOlhando para: %d %d\n==========\n",
                getNomeEquipe(),
                getPosicaoX(),
                getPosicaoY(),
                sensorConcentracao(mapa),
                sensorRugosidade(mapa),
                sensorTempo(tempoDecorrido),
                direcao[0],
                direcao[1]);
    }


    public void coleta(Terreno terreno, int tempo){

        estado = "coletando";
        tempoInicioAcao = tempo;


        float concentracaoHelio3 = terreno.buscarCelula(posicaoX, posicaoY).getConcentracaoHelio();
        float coeficienteErro = terreno.buscarCelula(posicaoX, posicaoY).getCoeficienteErro();

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
