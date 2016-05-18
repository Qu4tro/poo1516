
/**
 * Escreva a descrição da classe Imoobiliaria aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */

import javax.rmi.CORBA.Util;
import java.util.*;
import java.lang.String;
import java.util.stream.Collector;
import java.util.stream.Collectors;


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
                    System.out.println("Login incorrecto!");
                    initial_menu(imobiliaria);
                }
                break;

            case 2:
                params = registarUI();
                try {
                    params = registarUI();
                    Utilizador user = new Utilizador(params.get(0), params.get(1), params.get(2), params.get(3), params.get(4));
                    imobiliaria.registarUtilizador(user);
                } catch (UtilizadorExistenteException e) {
                    System.out.println("Utilizador já existente!");
                    initial_menu(imobiliaria);
                }
                break;

            case 3:
                noAuthMenu(imobiliaria);
                break;

        }
    }

    public static void noAuthMenu(Imoobiliaria imobiliaria) {

        Menu m = new Menu();
        List<String> params;

        int choice;

        m.addField("Consultar imóveis");
        m.addField("Consultar imóveis habitáveis");
        m.addField("Contactos");

        choice = m.presentChoices();

        switch (choice) {
            case 1:
                // TODO: listarUI(imobiliaria);;
                break;
            case 2:
                // TODO: habitaveisUI(imobiliaria);
                break;
            case 3:
                // TODO: contactosUI(imobiliaria);
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

        int choice;
        List<String> params;
        Menu menu = new Menu();

        menu.addField("Comprador");
        menu.addField("Vendedor");

        choice = menu.presentChoices();

        switch (choice) {
            case 1:
                params = registarUIParams();
                params.add(0, "comprador");
                break;
            case 2:
                params = registarUIParams();
                params.add(0, "vendedor");
                break;
            case 3:
                // TODO: contactosUI(imobiliaria);
                break;
        }

        return null;
    }

    public static List<String> registarUIParams(){
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
        if (loggedUser == null) {
            for (Utilizador utilizador : users) {
                if (email.equals(utilizador.getEmail())) {
                    if (password.equals(utilizador.getPassword())) {
                        loggedUser = utilizador;
                    } else {
                        // password errada
                        throw new SemAutorizacaoException("Password errada");
                    }
                } else throw new SemAutorizacaoException("O utilizado " + email + " não existe");
            }
            // Não há utilizador registado na aplicação;
        } else {
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
        if (loggedUser instanceof Vendedor && im != null) {
            if (imoveis.contains(im)) {
                throw new ImovelExisteException("Já existe este imóvel");
            } else imoveis.add(im);

        } else {
            throw new SemAutorizacaoException("O utilizador não tem acesso");
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

    public List<Imovel> getImovel(String classe, int preco) {
        return imoveis.stream()
                      .filter(i -> mesmoTipoImovel(classe, i))
                      .filter(i -> i.getPrecoPedido() < preco)
                      .collect(Collectors.toList());
    }

    public boolean mesmoTipoImovel(String s, Imovel i){
        switch(s){
            case "Terreno" : if( i instanceof Terreno) return true;
                            break;
            case "Moradia" : if( i instanceof Moradia) return true;
                            break;
            case "Apartamento" : if( i instanceof Apartamento) return true;
                                break;
            case "Loja" : if( i instanceof Loja) return true;
                        break;
        }
        return false;
    }
    

    //Consultar a lista de todos os imóveis habitáveis(até um certo preço)
    /*
    public List<Habitavel> getHabitaveis(int preco) {
        ArrayList<Habitavel> l = new ArrayList<Habitavel>();
        return l.stream().filter(i -> imoveisHabitaveis(i))
    }
    */

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

