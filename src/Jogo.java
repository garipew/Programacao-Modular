public class Jogo {

    int tempoDecorrido = 0;
    int duracaoPartida;


    public void main(String[] args){

        boolean gameLoop = true;


        while(gameLoop){

            tempoDecorrido += 1;

            if(tempoDecorrido > duracaoPartida)
                gameLoop = false;
        }

    }

}
