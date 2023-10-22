public class Celula {

    int coordenadaX;
    int coordenadaY;

    float concentracaoHelio;
    float coeficienteErro;
    float rugosidade;


    public Celula(int X, int Y, float concentracaoHelio, float coeficienteErro, float rugosidade){

        this.coordenadaX = X;
        this.coordenadaY = Y;
        this.concentracaoHelio = concentracaoHelio;
        this.coeficienteErro = coeficienteErro;
        this.rugosidade = rugosidade;

    }
}
