

import java.awt.image.ImageObserver;
import java.util.*;
import java.lang.String;
import java.util.stream.Collectors;
import java.util.function.Supplier;



public class Imoobiliaria {

    //private ArrayList<Imovel> imoveis;
    //private ArrayList<Utilizador> users;
    private HashMap<String, Imovel> imoveis;
    private HashMap<String, Utilizador> users;

    private Utilizador loggedUser;


    // Métodos estáticos
    public static void main(String[] args) {

        Imoobiliaria imobiliaria = new Imoobiliaria();

        initial_menu(imobiliaria);
    }

    public static void initial_menu(Imoobiliaria imobiliaria) {

        Menu m = new Menu();
        List<String> params;
        Utilizador user = null;

        int choice;

        m.addField("Autenticar");
        m.addField("Registar");
        m.addField("Continuar sem autenticação");
        m.addField("Sair");

        choice = m.presentChoices();

        switch (choice) {
            case 1:
                params = loginUI();
                try {
                    imobiliaria.iniciaSessao(params.get(0), params.get(1));
                } catch (SemAutorizacaoException e) {
                    System.out.println("Login incorrecto!");
                    new Scanner(System.in).nextLine();
                    initial_menu(imobiliaria);
                    return;
                }
                if (imobiliaria.loggedAsBuyer()) {
                    buyerMenu(imobiliaria);
                } else if (imobiliaria.loggedAsSeller()) {
                    sellerMenu(imobiliaria);
                }
                break;

            case 2:
                try {
                    params = registarUI(imobiliaria);
                    if (params == null) {
                        return;
                    }
                    if (params.get(0).equals("comprador")) {
                        user = new Comprador(params.get(1), params.get(2), params.get(3), params.get(4), params.get(5), null);
                    } else if (params.get(0).equals("vendedor")) {
                        user = new Vendedor(params.get(1), params.get(2), params.get(3), params.get(4), params.get(5), null, null);
                    }
                    imobiliaria.registarUtilizador(user);
                } catch (UtilizadorExistenteException e) {
                    System.out.println("Utilizador já existente!");
                    new Scanner(System.in).nextLine();
                }
                initial_menu(imobiliaria);
                break;

            case 3:
                noAuthMenu(imobiliaria);
                break;

            case 0:
                break;

        }
    }


    public static List<String> loginUI() {
        Menu menu = new Menu();
        menu.addField("Email");
        menu.addField("Password");

        return menu.getParams();
    }

    public static List<String> registarUI(Imoobiliaria imoobiliaria) {

        int choice;
        List<String> params = null;
        Menu menu = new Menu();

        menu.addField("Comprador");
        menu.addField("Vendedor");
        menu.addField("Voltar");

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
            case 0:
                initial_menu(imoobiliaria);
                return null;
        }

        return params;
    }

    public static List<String> registarUIParams() {
        Menu menu = new Menu();
        menu.addField("Email");
        menu.addField("Nome");
        menu.addField("Password");
        menu.addField("Morada");
        menu.addField("Data de Nascimento");

        return menu.getParams();

    }

    public static void noAuthMenu(Imoobiliaria imobiliaria) {

        Menu m = new Menu();
        List<String> params;

        int choice;

        m.addField("Consultar imóveis");
        m.addField("Consultar imóveis habitáveis");
        m.addField("Contactos");
        m.addField("Voltar");

        choice = m.presentChoices();

        switch (choice) {
            case 1:
                listarUI(imobiliaria);
                break;
            case 2:
                habitaveisUI(imobiliaria);
                break;
            case 3:
                contactosUI(imobiliaria);
                break;
            case 0:
                initial_menu(imobiliaria);
                break;
        }
    }

    public static void buyerMenu(Imoobiliaria imobiliaria) {

        Menu m = new Menu();
        List<String> params;

        int choice;

        m.addField("Consultar imóveis");
        m.addField("Consultar imóveis habitáveis");
        m.addField("Consultar imóveis favoritos");
        m.addField("Contactos");
        m.addField("Logout");

        choice = m.presentChoices();

        switch (choice) {
            case 1:
                listarUI(imobiliaria);
                break;
            case 2:
                habitaveisUI(imobiliaria);
                break;
            case 3:
                favoritosUI(imobiliaria);
                break;
            case 4:
                contactosUI(imobiliaria);
                break;
            case 0:
                imobiliaria.fechaSessao();
                initial_menu(imobiliaria);
                break;
        }
    }

    public static void sellerMenu(Imoobiliaria imobiliaria) {

        Menu m = new Menu();
        List<String> params;

        int choice;

        m.addField("Consultar imóveis");
        m.addField("Consultar imóveis habitáveis");
        m.addField("Consultar seus imóveis em venda");
        m.addField("Consultar vendas passadas");
        m.addField("Contactos");
        m.addField("Logout");

        choice = m.presentChoices();

        switch (choice) {
            case 1:
                listarUI(imobiliaria);
                break;
            case 2:
                habitaveisUI(imobiliaria);
                break;
            case 3:
                sellerImoveisUI(imobiliaria);
                break;
            case 4:
                sellLogUI(imobiliaria);
                break;
            case 5:
                contactosUI(imobiliaria);
                break;
            case 0:
                imobiliaria.fechaSessao();
                initial_menu(imobiliaria);
                break;
        }
    }


    public static void listarUI(Imoobiliaria imobiliaria) {
        Menu m = new Menu();
        //TODO

    }

    public static void contactosUI(Imoobiliaria imobiliaria) {
        //TODO
    }

    public static void habitaveisUI(Imoobiliaria imobiliaria) {
        //TODO fhikjik
    }

    public static void favoritosUI(Imoobiliaria imobiliaria) {
        //TODO
    }

    public static void sellerImoveisUI(Imoobiliaria imobiliaria) {
        //TODO
    }

    public static void sellLogUI(Imoobiliaria imobiliaria) {
        //TODO
    }

    // Métodos de instância
    public Imoobiliaria() {
        imoveis = new HashMap<>();
        users = new HashMap<>();

        loggedUser = null;
    }

    //Validar o acesso à aplicação utilizando as credenciais(email e password)
    public void iniciaSessao(String email, String password) throws SemAutorizacaoException {
        if (loggedUser == null) {
            if (users.containsKey(email)) {
                Utilizador utilizador = users.get(email);
                if (password.equals(utilizador.getPassword())) {
                    loggedUser = utilizador;
                } else {
                    throw new SemAutorizacaoException("Password errada");
                }
            } else {
                throw new SemAutorizacaoException("O utilizado " + email + " não existe");
            }
        } else {
            throw new SemAutorizacaoException("O utilizador já iniciou sessão");
        }
    }

    public void fechaSessao() {
        loggedUser = null;
    }

    //Registar um utilizador, quer vendedor, quer comprador
    public void registarUtilizador(Utilizador user) throws UtilizadorExistenteException {

        if (user != null && !(users.containsKey(user.getEmail()))) {
            users.put(user.getEmail(), user.clone());

        } else {
            throw new UtilizadorExistenteException("Este utilizador já existe");
        }


    }


    //Vendedores(é necessário estarem previamente autenticados)
    //Colocar um imóvel à venda;
    public void registaImovel(Imovel im) throws ImovelExisteException, SemAutorizacaoException {
        if (loggedUser instanceof Vendedor && im != null) {
            if (imoveis.containsKey(im.getId())) {
                throw new ImovelExisteException("Já existe este imóvel");
            } else imoveis.put(im.getId(), im.clone());

        } else {
            throw new SemAutorizacaoException("O utilizador não tem acesso");
        }
    }


    
    //Visualizar uma lista com as datas( e emails, caso exista essa informação) das 10 últimas consultas
    //aos imóveis que tem para venda
    //são geradas pelo métodos getImovel(String,Int),getHbitaveis(int),getMapearmentoImoveis() e getFavoritos()
    public List<Consulta> getConsultas() throws SemAutorizacaoException {
        //TODO
        return null;
    }
    
    //Alterar o estado de um imóvel, de acordo com as acções feitas sobre ele;
    public void setEstado(String idImovel, String estado) throws ImovelInexistenteException,
            SemAutorizacaoException,
            EstadoInvalidoException {
        if (loggedAsSeller()) {
            if (imoveis.containsKey(idImovel)) {
                Imovel i = imoveis.get(idImovel);
                EstadoImovel ei = string2Estado(estado);
                if (ei == null) {
                    throw new EstadoInvalidoException("Estado não é válido");
                }
                i.setEstado(ei);
            } else {
                throw new ImovelInexistenteException("Imovel não registado.");
            }
        } else {
            throw new SemAutorizacaoException("Não está autenticado como comprador.");
        }

    }

    public EstadoImovel string2Estado(String estado) {
        if (estado.equals("Livre")) {
            return EstadoImovel.LIVRE;
        } else if (estado.equals("Vendido")) {
            return EstadoImovel.VENDIDO;
        } else {
            return null;
        }
    }



    //Obter um conjunto com os códigos dos imóveis mais consultados(ou seja, com mais de N consultas).
    //refere-se aos imóveis do vendedor que está a fazer a consulta
    public Set<String> getTopImoveis(int n) {
        return null; // TODO
    }

    public List<Imovel> getImovel(String classe, int preco) {
        return imoveis.values()
                .stream()
                      .filter(i -> mesmoTipoImovel(classe, i))
                      .filter(i -> i.getPrecoPedido() < preco)
                      .collect(Collectors.toList());
    }

    public boolean mesmoTipoImovel(String s, Imovel i){
        switch(s){
            case "Terreno":
                if (i instanceof Terreno)
                    return true;
                break;
            case "Moradia":
                if (i instanceof Moradia)
                    return true;
                break;
            case "Apartamento":
                if (i instanceof Apartamento)
                    return true;
                break;
            case "Loja":
                if (i instanceof Loja)
                    return true;
                break;
        }
        return false;
    }
    

    //Consultar a lista de todos os imóveis habitáveis(até um certo preço)
    public List<Habitavel> getHabitaveis(int preco) {
        return imoveis.values()
                .stream()
                .filter(i -> eHabitavel(i) != null)
                .filter(i -> i.getPrecoPedido() < preco)
                .map(i -> eHabitavel(i))
                .collect(Collectors.toList());
    }


    public Habitavel eHabitavel(Imovel i) {

        if (i instanceof LojaHabitavel) {
            LojaHabitavel lh = (LojaHabitavel) i;
            return lh;
        } else if (i instanceof Apartamento) {
            Apartamento ap = (Apartamento) i;
            return ap;
        } else if (i instanceof Moradia) {
            Moradia mor = (Moradia) i;
            return mor;
        } else {
            return null;
        }
    }

    //Obter um mapeamento entre todos os imóveis e respetivos vendedores.
    public Map<Imovel, Vendedor> getMapeamentoImoveis() {
        return imoveis.values().stream()
                .collect(Collectors.toMap(e -> e, e -> e.getVendedor()));
    }

    //Compradores registados:
    //Marcar um imóvel como favorito.
    public void setFavorito(String idImovel) throws ImovelInexistenteException, SemAutorizacaoException {
        if (loggedAsBuyer()) {
            if (imoveis.containsKey(idImovel)) {
                Comprador c = (Comprador) loggedUser;
                c.addFav(idImovel);
            } else {
                throw new ImovelInexistenteException("Imóvel não existe");
            }
        } else {
            throw new SemAutorizacaoException("Não está autenticado como comprador.");
        }
    }
    
    //Consultar imóveis favoritos ordenados por preço.
    public TreeSet<Imovel> getFavoritos() throws SemAutorizacaoException {

        if (loggedAsBuyer()) {
            Supplier<TreeSet<Imovel>> supplier = () -> new TreeSet<>(new ComparatorPreco());

            Comprador c = (Comprador) loggedUser;
            return c.getFavoritos()
                    .stream()
                    .map(id -> imoveis.get(id))
                    .collect(Collectors.toCollection(supplier));
        } else {
            throw new SemAutorizacaoException("Não está autenticado como comprador.");
        }

    }


    public boolean loggedAsBuyer() {
        if (loggedUser != null) {
            return (loggedUser instanceof Vendedor);
        }

        return false;
    }

    public boolean loggedAsSeller() {
        if (loggedUser != null) {
            return (loggedUser instanceof Comprador);
        }

        return false;
    }

}

