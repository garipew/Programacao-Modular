import java.util.Scanner;

public class Jogo {

    public static void main(String[] args){

        Celula[] celulas = {new Celula(0, 0, 0.2f, 0.1f, 0.5f), new Celula(1, 0, 0.5f, 0.3f, 0.1f), new Celula(2,0, 0.5f, 0.8f, 0.3f), new Celula(3, 0, 0.3f, 0f, 0.7f), new Celula(4, 0, 0.8f, 0.2f, 0.6f),
                new Celula(0, 1, 0.8f, 0.3f, 0f), new Celula(1, 1, 0.5f, 0.1f, 0f), new Celula(2,1, 0f, 0f, 0f), new Celula(3, 1, 0f, 0f, 0f), new Celula(4, 1, 0f, 0f, 0f)};

        Terreno mapa = new Terreno(celulas, 5, 2);

        Controlador robo = new Controlador("Equipe Alfa");

        Controlador robo2 = new Controlador("Equipe Beta");

        int tempoDecorrido = 0;
        int duracaoPartida = 100;

        boolean gameLoop = true;

        String acao = " ";

        Scanner sc = new Scanner(System.in);

        System.out.print("\t\tControles\n" +
                "====================\n" +
                "'anda' -> Caminha na direção que esta olhando\n" +
                "'esquerda' -> Gira 90º à esquerda\n" +
                "'direita' -> Gira 90º à direita\n" +
                "'coleta' -> Coleta o Hélio-3 disponível\n" +
                "'sensores' -> Ativa todos os sensores\n" +
                "'sair' -> Encerra o jogo\n" +
                "=====================\n");

        while(gameLoop){

            System.out.printf("%d s\n%d Barril(s) %s\n%d Barril(s) %s\n",
                    tempoDecorrido, robo.getQuantidadeBarris(), robo.getNomeEquipe(),
                    robo2.getQuantidadeBarris(), robo2.getNomeEquipe());

            if(robo.getEstado().equals("livre")){
                System.out.printf("Digite a proxima ação %s: ", robo.getNomeEquipe());
                acao = sc.nextLine();
                if(acao.equals("sair"))
                    break;
                robo.atualizaAcao(mapa, acao, tempoDecorrido);
            }

            if(robo2.getEstado().equals("livre")){
                System.out.printf("Digite a proxima ação %s: ", robo2.getNomeEquipe());
                acao = sc.nextLine();
                if(acao.equals("sair"))
                    break;
                robo2.atualizaAcao(mapa, acao, tempoDecorrido);
            }


            acao = " ";
            tempoDecorrido++;
            robo.atualizaEstado(tempoDecorrido);
            robo2.atualizaEstado(tempoDecorrido);
            if(tempoDecorrido > duracaoPartida)
                gameLoop = false;
        }

        System.out.printf("%d Barril(s)\n", robo.getQuantidadeBarris());
    }

}
