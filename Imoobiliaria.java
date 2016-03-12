import java.util.ArrayList;

/**
 * \\ TODO: Receber
 *
 * @author (seu nome)
 * @version (número de versão ou data)
 */
public class Imoobiliaria {

    private ArrayList<Actor> users;

    public boolean verificaUtilizador(Actor user) {
        if (user == null) {
            return false;
        }
        return users.contains(user);
    }

    public void registarUtilizador(Actor user) throws UtilizadorExistenteException {
        if (verificaUtilizador(user)) {
            users.add(user);

        } else {
            throw new UtilizadorExistenteException();
        }


    }


    public void iniciaSessao(String email, String password) throws SemAutorizacaoException {
        for (Actor actor : users) {
            if (email == actor.getEmail()) {
                if (password == actor.getPassword()) {
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