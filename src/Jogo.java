import java.util.Scanner;

public class Jogo {

    public static void main(String[] args){

        Celula[] celulas = {new Celula(0, 0, 0.2f, 0.1f, 0.5f), new Celula(1, 0, 0.5f, 0.3f, 0.1f), new Celula(2,0, 0.5f, 0.8f, 0.3f), new Celula(3, 0, 0.3f, 0f, 0.7f), new Celula(4, 0, 0.8f, 0.2f, 0.6f),
                new Celula(0, 1, 0f, 0f, 0f), new Celula(1, 1, 0f, 0f, 0f), new Celula(2,1, 0f, 0f, 0f), new Celula(3, 1, 0f, 0f, 0f), new Celula(4, 1, 0f, 0f, 0f)};

        Terreno mapa = new Terreno(celulas, 5, 2);

        Controlador robo = new Controlador("Equipe alfa");

        int tempoDecorrido = 0;
        int duracaoPartida = 100;

        boolean gameLoop = true;

        String acao = " ";

        Scanner sc = new Scanner(System.in);

        System.out.printf("\t\tControles\n" +
                "====================\n" +
                "'anda' -> Caminha na direção que esta olhando\n" +
                "'esquerda' -> Gira 90º à esquerda\n" +
                "'direita' -> Gira 90º à direita\n" +
                "'coleta' -> Coleta o Hélio-3 disponível\n" +
                "'sensores' -> Ativa todos os sensores\n" +
                "'sair' -> Encerra o jogo\n" +
                "=====================\n" +
                "%s\n", robo.getNomeEquipe());
        while(gameLoop){

            acao = sc.nextLine();

            switch(acao){

                case("anda"):
                    robo.anda(mapa);
                    break;
                case("esquerda"):
                    robo.esquerda();
                    break;
                case("direita"):
                    robo.direita();
                    break;
                case("coleta"):
                    robo.coleta(mapa);
                    tempoDecorrido+=2;
                    break;
                case("sensores"):
                    System.out.printf("%d %d\n%d Barril(s)\n%.2f Concentração\n%.2f Rugosidade \n%d s\n",
                    robo.getPosicaoX(),
                    robo.getPosicaoY(),
                    robo.getQuantidadeBarris(),
                    robo.sensorConcentracao(mapa),
                    robo.sensorRugosidade(mapa),
                    robo.sensorTempo(tempoDecorrido));
                    break;
                case("sair"):
                    gameLoop = false;
                    break;
                default:
                    break;
            }


            acao = " ";
            tempoDecorrido++;
            if(tempoDecorrido > duracaoPartida)
                gameLoop = false;
        }

        System.out.printf("%d Barril(s)\n", robo.getQuantidadeBarris());
    }

}
