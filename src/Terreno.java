public class Terreno {

    private Celula[] celulas;

    private int comprimento;
    private int largura;


    public Terreno(Celula[] celulas, int largura, int comprimento){

        this.celulas = celulas;
        this.comprimento = comprimento;
        this.largura = largura;

    }

    public int getComprimento() {
        return comprimento;
    }

    public int getLargura() {
        return largura;
    }

    public Celula buscarCelula(int X, int Y){

        int i = 0;

        while(i < celulas.length){
            if((celulas[i].getCoordenadaX() == X) && (celulas[i].getCoordenadaY() == Y))
                break;
            i++;
        }

        return celulas[i];

    }
}
