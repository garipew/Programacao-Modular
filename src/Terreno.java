public class Terreno {

    private Celula[] celulas;
    private final int comprimento;
    private final int largura;


    public Terreno(int comprimento, int largura){

        this.comprimento = comprimento;
        this.largura = largura;
        this.celulas = new Celula[comprimento*largura];

    }


    public Celula buscarCelula(int X, int Y){

        int i = 0;

        if((X >= largura) || (Y >= comprimento))
            return null;

        while((celulas[i].coordenadaX != X) && (celulas[i].coordenadaY != Y)){
            i++;
        }

        return celulas[i];

    }
}
