public class Celula {

    private int coordenadaX;
    private int coordenadaY;

    private float concentracaoHelio;
    private float coeficienteErro;
    private float rugosidade;


    public boolean celulaOcupada = false;

    public float getRugosidade() {
        return rugosidade;
    }

    public float getCoeficienteErro() {
        return coeficienteErro;
    }

    public float getConcentracaoHelio() {
        return concentracaoHelio;
    }

    public int getCoordenadaX() {
        return coordenadaX;
    }

    public int getCoordenadaY() {
        return coordenadaY;
    }

    public Celula(int X, int Y, float concentracaoHelio, float coeficienteErro, float rugosidade){

        this.coordenadaX = X;
        this.coordenadaY = Y;
        this.concentracaoHelio = concentracaoHelio;
        this.coeficienteErro = coeficienteErro;
        this.rugosidade = rugosidade;

    }
}
