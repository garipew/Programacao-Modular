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

        while((celulas[i].coordenadaX != X) && (celulas[i].coordenadaY != Y)){
            i++;
        }

        return celulas[i];

    }
}
