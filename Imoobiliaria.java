import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;
import java.util.Map;
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
        } else if (cmd.equals("logout")) {
            imobiliaria.fechaSessao();
            System.out.println("Sessão terminada.");
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

    public static Utilizador loginUI(String[] params) {
        return null;
    }

    public static Utilizador registarUI(String[] params) {
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

    public void iniciaSessao(String email, String password) throws SemAutorizacaoException {
        // TODO: Há 3 razões pela qual esta função deve falhar:
        //      O utilizador não existe;
        //      Password errada;
        //      Utilizador já autenticado
        // E mesmo assim porquê é que só mandamos 1 erro?
        if (loggedUser == null) {
            for (Utilizador utilizador : users) {
                if (email.equals(utilizador.getEmail())) {
                    if (password.equals(utilizador.getPassword())) {
                        loggedUser = utilizador;
                    } else {
                        // password errada
                        throw new SemAutorizacaoException();
                    }
                }
            }
            // Não há utilizador registado na aplicação;
        } else {

            // Utilizador já autenticado
        }

    }

    public void fechaSessao() {
        loggedUser = null;
    }


    public void registarUtilizador(Utilizador user) throws UtilizadorExistenteException {
        if (verificaUtilizador(user)) {
            users.add(user);

        } else {
            throw new UtilizadorExistenteException();
        }


    }

    public boolean verificaUtilizador(Utilizador user) {
        if (user == null) {
            return false;
        }
        // TODO: Aqui provavelmente é melhor simplesmente verificar se existe algum user com email igual.
        return users.contains(user);
    }

    public void registaImovel(Imovel im) throws ImovelExisteException, SemAutorizacaoException {
        if (im != null) {
            imoveis.add(im);
        }
    }

    public List<Consulta> getConsultas() throws SemAutorizacaoException {
        return null;
    }

    public void setEstado(String idImovel, String estado)
            throws ImovelInexistenteException,
            SemAutorizacaoException,
            EstadoInvalidoException {

    }


    public Set<String> getTopImoveis(int n) {
        return null;
    }

    public List<Imovel> getImovel(String classe, int preco) {
        return null;
    }


    public List<Habitavel> getHabitaveis(int preco) {
        return null;
    }

    public Map<Imovel, Vendedor> getMapeamentoImoveis() {
        return null;
    }

    public void setFavorito(String idImovel) throws ImovelInexistenteException, SemAutorizacaoException {
    }

    public TreeSet<Imovel> getFavoritos() throws SemAutorizacaoException {
        return null;
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

class ImovelInexistenteException extends Exception {
    public ImovelInexistenteException() {
        super();
    }
}

class EstadoInvalidoException extends Exception {
    public EstadoInvalidoException() {
        super();
    }
}

class ImovelExisteException extends Exception {
    public ImovelExisteException() {
        super();
    }
}