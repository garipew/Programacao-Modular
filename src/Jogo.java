import java.util.Scanner;

public class Jogo {

    public static void main(String[] args){

        Celula[] celulas = {new Celula(0, 0, 0.2f, 0.1f, 0.5f), new Celula(1, 0, 0.5f, 0.3f, 0.1f), new Celula(2,0, 0.5f, 0.8f, 0.3f), new Celula(3, 0, 0.3f, 0f, 0.7f), new Celula(4, 0, 0.8f, 0.2f, 0.6f),
                new Celula(0, 1, 0.8f, 0.3f, 0f), new Celula(1, 1, 0.5f, 0.1f, 0f), new Celula(2,1, 0f, 0f, 0f), new Celula(3, 1, 0f, 0f, 0f), new Celula(4, 1, 0f, 0f, 0f)};

        Terreno mapa = new Terreno(celulas, 5, 2);

        Controlador[] jogadores = {
                new Controlador("Equipe Alfa", 0, 0),
                new Controlador("Equipe Beta", 0, 1)
        };

        int duracaoPartida = 100;

        Configuracoes configuracoes = new Configuracoes(duracaoPartida, jogadores);

        int tempoDecorrido = 0;

        boolean gameLoop = true;

        String acao;

        Scanner sc = new Scanner(System.in);

        System.out.print("""
                \t\tControles
                ====================
                'anda' -> Caminha na direção que esta olhando
                'esquerda' -> Gira 90º à esquerda
                'direita' -> Gira 90º à direita
                'coleta' -> Coleta o Hélio-3 disponível
                'sensores' -> Ativa todos os sensores
                'sair' -> Encerra o jogo
                =====================
                """);

        while(gameLoop){

            System.out.printf("%d s\n", tempoDecorrido);

            for (Controlador jogador : configuracoes.getJogadores()) {

                System.out.printf("%s\n%d Barril(s)\n", jogador.getNomeEquipe(), jogador.getQuantidadeBarris());

                if (jogador.getEstado().equals("livre")) {
                    jogador.sensores(mapa, tempoDecorrido);
                    System.out.print("Digite a proxima ação: ");
                    acao = sc.nextLine();
                    if (acao.equals("sair"))
                        System.exit(-1);
                    jogador.atualizaAcao(mapa, acao, tempoDecorrido);
                }

                jogador.atualizaEstado(tempoDecorrido);

            }

            tempoDecorrido++;
            if(tempoDecorrido > configuracoes.getDuracaoPartida())
                gameLoop = false;
        }


    }

}
