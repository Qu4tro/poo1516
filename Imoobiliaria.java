
/**
 * Escreva a descrição da classe Imoobiliaria aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;
import java.util.Map;
import java.lang.String;


public class Imoobiliaria {

    private ArrayList<Imovel> imoveis;
    private ArrayList<Utilizador> users;

    private Utilizador loggedUser;


    // Métodos estáticos
    public static void main(String[] args) {

        Imoobiliaria imobiliaria = new Imoobiliaria();

        initial_menu(imobiliaria);
    }

    public static void initial_menu(Imoobiliaria imobiliaria) {

        Menu m = new Menu();
        List<String> params;

        int choice;

        m.addField("Autenticar");
        m.addField("Registar");
        m.addField("Continuar sem autenticação");

        choice = m.presentChoices();

        switch (choice) {
            case 1:
                params = loginUI();
                try {
                    imobiliaria.iniciaSessao(params.get(0), params.get(1));
                } catch (SemAutorizacaoException e) {
                    //TODO - se ele tentar inicar sessão e falhar
                }
                break;

            case 2:
                params = registarUI();
                try {
                    params = registarUI();
                    // criar Utilizador aqui com os params recebidos
                    imobiliaria.registarUtilizador(null);
                } catch (UtilizadorExistenteException e) {
                    //TODO - se ele tentar registar e falhar
                }
                break;

            case 3:
                ;
                break;

        }
    }


    public static List<String> loginUI() {
        Menu menu = new Menu();
        menu.addField("Email");
        menu.addField("Password");

        return menu.getParams();
    }

    public static List<String> registarUI() {
        //TODO - separar isto em 2 metodos registarUIVendedor registarUIComprador
        // nesta função vai estar o menu de decidir entre vendedor e comprador
        Menu menu = new Menu();
        menu.addField("Email");
        menu.addField("Nome");
        menu.addField("Password");
        menu.addField("Morada");
        menu.addField("Data de Nascimento");

        return menu.getParams();

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
    
    //Validar o acesso à aplicação utilizando as credenciais(email e password)
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
                        throw new SemAutorizacaoException("Password errada");
                    }
                }
                else throw new SemAutorizacaoException("O utilizado "+email+" não existe");
            }
            // Não há utilizador registado na aplicação;
        } 
        else {
            throw new SemAutorizacaoException("O utilizador já iniciou sessão");
        }
            // Utilizador já autenticado
    }

    public void fechaSessao() {
        loggedUser = null;
    }

    //Registar um utilizador, quer vendedor, quer comprador
    public void registarUtilizador(Utilizador user) throws UtilizadorExistenteException {
        if (verificaUtilizador(user)) {
            users.add(user);

        } else {
            throw new UtilizadorExistenteException("Este utilizador já existe");
        }


    }

    public boolean verificaUtilizador(Utilizador user) {
        if (user == null) {
            return false;
        }
        // TODO: Aqui provavelmente é melhor simplesmente verificar se existe algum user com email igual.
        return users.contains(user);
    }
    
    //Vendedores(é necessário estarem previamente autenticados)
    //Colocar um imóvel à venda;
    public void registaImovel(Imovel im) throws ImovelExisteException, SemAutorizacaoException {
        if (im != null) {
            imoveis.add(im);
        }
    }
    
    //Visualizar uma lista com as datas( e emails, caso exista essa informação) das 10 últimas consultas
    //aos imóveis que tem para venda
    //são geradas pelo métodos getImovel(String,Int),getHbitaveis(int),getMapearmentoImoveis() e getFavoritos()
    public List<Consulta> getConsultas() throws SemAutorizacaoException {
        return null;
    }
    
    //Alterar o estado de um imóvel, de acordo com as acções feitas sobre ele;
    public void setEstado(String idImovel, String estado) throws ImovelInexistenteException,
            SemAutorizacaoException,
            EstadoInvalidoException {

    }

    //Obter um conjunto com os códigos dos imóveis mais consultados(ou seja, com mais de N consultas).
    //refere-se aos imóveis do vendedor que está a fazer a consulta
    public Set<String> getTopImoveis(int n) {
        return null;
    }

    //Todos os utilizadores:
    //Consultar a lista de todos os imóveis de um dado tipo(Terreno, Moradia, etc) e até um certo preço.
    public List<Imovel> getImovel(String classe, int preco) {
        return null;
    }

    //Consultar a lista de todos os imóveis habitáveis(até um certo preço)
    public List<Habitavel> getHabitaveis(int preco) {
        return null;
    }

    //Obter um mapeamento entre todos os imóveis e respetivos vendedores.
    public Map<Imovel, Vendedor> getMapeamentoImoveis() {
        return null;
    }

    //Compradores registados:
    //Marcar um imóvel como favorito.
    public void setFavorito(String idImovel) throws ImovelInexistenteException, SemAutorizacaoException {
    }
    
    //Consultar imóveis favoritos ordenados por preço.
    public TreeSet<Imovel> getFavoritos() throws SemAutorizacaoException {
        return null;
    }
}

