import java.util.List;

public class View implements IView{
    /**
     * Construtor vazio de View
     */
    public View(){
    }

    /**
     * Mostrar o menu principal
     */
    public void mostrarMenuPrincipal(){
            clearScreen();
            Menu menu = new Menu();
            menu.setTitulo("Football Manager âŊ");
            menu.adicionaOpcao("Consultar equipas đĨ");
            menu.adicionaOpcao("Consultar jogadores âšī¸â");
            menu.adicionaOpcao("Consultar jogos đĨ");
            menu.adicionaOpcao("Adicionar equipa âđĨ");
            menu.adicionaOpcao("Adicionar jogador ââšī¸");
            menu.adicionaOpcao("Transferir jogador âĄī¸ âšī¸");
            menu.adicionaOpcao("Jogar đŽâ");
            menu.adicionaOpcao("Carregar estado đĨī¸");
            menu.adicionaOpcao("Guardar estado đž");
            menu.adicionaOpcao("Remover Jogador ââšī¸");
            menu.adicionaOpcao("Remover Equipa âđĨ");
            menu.adicionaOpcao("Sair â");
            menu.show(true);
    }

    /**
     * Mostrar o menu de consulta de jogadores
     */
    public void mostrarMenuDeConsultaDeJogador(){
        clearScreen();
        Menu menu = new Menu();
        menu.adicionaOpcao("Procurar jogador nos planteis đ");
        menu.adicionaOpcao("Ver detalhes do jogador đ");
        menu.adicionaOpcao("Voltar");
        menu.setTitulo("Consultar jogadores âŊ");
        menu.show(true);
    }

    /**
     * Mostrar os jogos carregados no momento
     */
    public void showJogos(IModel model){
        clearScreen();
        for (IJogo jogo : model.getJogos()) {
            System.out.println("Jogo realizado em " + jogo.getTempoJogo()+ ": " + jogo.getEqCasa().getNome() + " " + jogo.getGolosCasa() + " : "
                                + jogo.getGolosVisitante() + " " +jogo.getEqVisitante().getNome());
            System.out.println("-----------------------------------------------------------------");
        }
    }
    
    /**
     * Mostrar o menu de consulta de equipas
     */
    public void mostrarMenuDeConsultaDeEquipas(){
        clearScreen();
        Menu menu = new Menu();
        menu.adicionaOpcao("Procurar por nome đ");
        menu.adicionaOpcao("Consultar lista đ");
        menu.adicionaOpcao("Voltar");
        menu.setTitulo("Consultar equipas âŊ");
        menu.show(true);
    }

    /**
     * Mostrar o as equipas lidas no momento como um menu
     */
    public void mostrarEquipas(IModel model){
        clearScreen();
        Menu menuEquipas = new Menu();
        menuEquipas.setTitulo("Selecione uma equipa");
            for (IEquipa e : model.getEquipas().values()) {
                menuEquipas.adicionaOpcao(e.getNome());
            }
        menuEquipas.show(true);
    }

    /**
     * Mostrar uma lista de equipas que tenham 11 ou mais jogadores como menu 
     */
    public void mostrarEquipasComOnzeOuMaisJogadores(IModel model){
        clearScreen();
        System.out.println("[Equipas com menos de 11 jogadores nÃŖo podem realizar jogos e nÃŖo aparecem na lista]");
        Menu menuEquipas = new Menu();
        menuEquipas.setTitulo("Selecione uma equipa");
        for (IEquipa e : model.getEquipas().values()) {
            if(e.getplantel().size()>=11) menuEquipas.adicionaOpcao(e.getNome());
        }
        menuEquipas.show(true);
    }
    

    /**
     * Mostrar o menu para escolha da posiÃ§ÃŖo do jogador
     */
    public void mostrarSelecaoDePosicaoJogador(){
        Menu menu = new Menu();
        menu.setTitulo("Selecione a posiÃ§ÃŖo");
        menu.adicionaOpcao("Medio");
        menu.adicionaOpcao("Lateral");
        menu.adicionaOpcao("Defesa");
        menu.adicionaOpcao("Guarda-Redes");
        menu.adicionaOpcao("AvanÃ§ado");
        menu.show(true);
    }

    /**
     * Mostrar uma lista de jogadores como menu
     */
    public void mostrarListaJogadoresComoMenu(List<IJogador> l){
        Menu menu = new Menu();
        menu.setTitulo("Selecione o jogador");
        for (IJogador jogador : l) {
            menu.adicionaOpcao(jogador.getNomeAtleta() + " [" + jogador.getEquipas().get(jogador.getEquipas().size()-1).getNome() + "]");
        }
        menu.show(true);
    }

    /**
     * Mostrar o titulo do jogo
     */
    public void showInicioJogo(IEquipa equipaCasa, IEquipa equipaVisitante){
        clearScreen();
        System.out.println("\u001B[36mJogo entre " + equipaCasa.getNome() + " e " + equipaVisitante.getNome() + "\u001B[0m");
        System.out.println("-----------------------------------------");
        System.out.println("Bola ao meio campo");
    }

    /**
     * Mostrar o resultado final de um jogo
     */
    public void showFimJogo(IJogo j){
        System.out.println("\u001B[32mResultado final: " + j.getEqCasa().getNome() + " " + j.getGolosCasa() + " : " + j.getGolosVisitante() + " " + j.getEqVisitante().getNome()+"\u001B[0m");
    }

    /**
     * Mostrar uma mensagem personalizada
     */
    public void mostraMensagem(String msg){
        System.out.println(msg);
    }

    /**
     * Mostrar uma mensagem personalizada sem mudar de linha
     */
    public void mostraMensagemSemNewLine(String msg){
        System.out.print(msg);
    }

    /**
     * Limpar o ecrÃŖ
     */
    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    } 

    /**
     * Mostrar uma mensagem de pressionar enter para continuar e esperar que o utilizador pressione enter
     */
    public static void pressEnterToContinue(IInput input){
        System.out.println(" --- press enter ---");
        input.InputString();
    }
}

