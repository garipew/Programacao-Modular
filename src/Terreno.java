public class Terreno {

    private Celula[] celulas;


    public Terreno(Celula[] celulas){

        this.celulas = celulas;

    }


    public Celula buscarCelula(int X, int Y){

        int i = 0;

        while((celulas[i].coordenadaX != X) && (celulas[i].coordenadaY != Y)){
            i++;
        }

        return celulas[i];

    }
}
