import java.util.ArrayList;
import java.util.Scanner;

public class Imoobiliaria {

    private ArrayList<Imovel> imoveis;
    private ArrayList<Utilizador> users;

    private Utilizador loggedUser;


    // Métodos estáticos

    public static void main(String[] args) {

        Imoobiliaria imobiliaria = new Imoobiliaria();

        Scanner scan = new Scanner(System.in);
        String line;

        while (scan.hasNextLine()) {
            System.out.println("> ");
            line = scan.nextLine().trim(); // remove leading spaces and check for empty

            if (line.isEmpty()) {
                continue;
            }

            run_commands(imobiliaria, line);
        }
    }

    public static void run_commands(Imoobiliaria imobiliaria, String line) {

        String[] parameters;
        String cmd;

        parameters = line.split("\\s+");
        cmd = parameters[0];

        if (cmd.equals("quit") || cmd.equals("exit")) {
            System.exit(0);
        } else if (cmd.equals("login")) {
            imobiliaria.loggedUser = loginUI(parameters);

        } else if (cmd.equals("registar")) {
            try {
                imobiliaria.registarUtilizador(registarUI(parameters));
            } catch (UtilizadorExistenteException e) {

            }
        } else if (cmd.equals("listar")) {
            listarUI();
        } else if (cmd.equals("listarHabitaveis")) {
            // TODO: Professor tem que dizer o quê que é um imóvel habitável. (Rodapé pag6 Enunciado).
        } else if (cmd.equals("contactos")) {
            contactosUI();
        } else {
            System.out.println("Invalid command.");
        }
    }

    public static Utilizador registarUI(String[] params) {
        return null;
    }

    public static Utilizador loginUI(String[] params) {
        return null;
    }

    public static void listarUI() {
    }

    public static void contactosUI() {
    }


    // Métodos de instância
    public Imoobiliaria() {
        imoveis = new ArrayList<>();
        users = new ArrayList<>();

        loggedUser = null;
    }

    public boolean verificaUtilizador(Utilizador user) {
        if (user == null) {
            return false;
        }
        // TODO: Aqui provavelmente é melhor simplesmente verificar se existe algum user com email igual.
        return users.contains(user);
    }

    public void registarUtilizador(Utilizador user) throws UtilizadorExistenteException {
        if (verificaUtilizador(user)) {
            users.add(user);

        } else {
            throw new UtilizadorExistenteException();
        }


    }

    public void iniciaSessao(String email, String password) throws SemAutorizacaoException {
        for (Utilizador utilizador : users) {
            if (email == utilizador.getEmail()) {
                if (password == utilizador.getPassword()) {
                    // inicia a sessão;
                } else {
                    // password errada
                }
            }
        }
        throw new SemAutorizacaoException();
        // não há utilizador;
    }

    public void fechaSessao() {
        // falta cenas
    }

}

class UtilizadorExistenteException extends Exception {
    public UtilizadorExistenteException() {
        super();
    }
}

class SemAutorizacaoException extends Exception {
    public SemAutorizacaoException() {
        super();
    }
}