

import sun.reflect.generics.tree.Tree;

import java.io.*;
import java.util.*;
import java.lang.String;
import java.util.stream.Collectors;
import java.util.function.Supplier;


public class Imoobiliaria implements Serializable {

    private Map<String, Imovel> imoveis;
    private Set<Consulta> consultas;

    private Map<String, Utilizador> users;

    private Utilizador loggedUser;


    // Métodos estáticos
    public static void main(String[] args) {

        Imoobiliaria imobiliaria = initApp();
        initial_menu(imobiliaria);

    }

    public static Imoobiliaria initApp() {
        try {
            load("ficheiro.app");
        } catch (IOException e) {
            System.out.println("Couldn't read file. Using empty one");
        } catch (ClassNotFoundException e) {
            System.exit(1);
        }
        return new Imoobiliaria();
        //LOAD /SAVE TODO
    }

    public void save(String file) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(this);

        oos.flush();
        oos.close();
    }

    public static Imoobiliaria load(String file) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));

        Imoobiliaria imob = (Imoobiliaria) ois.readObject();

        ois.close();
        return imob;
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
                    Menu.messageUser("Login incorrecto!");
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
                        user = new Vendedor(params.get(1), params.get(2), params.get(3), params.get(4), params.get(5), null);
                    }
                    imobiliaria.registarUtilizador(user);
                } catch (UtilizadorExistenteException e) {
                    Menu.messageUser("Utilizador já existente!");
                }
                initial_menu(imobiliaria);
                break;

            case 3:
                noAuthMenu(imobiliaria);
                break;

            case 0:
                try {
                    imobiliaria.save("ficheiro.app");
                } catch (IOException e) {
                    System.out.println("Couldn't save file.");
                }
                System.exit(0);
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
        m.addField("Adicionar novo imóvel");
        m.addField("Mudar estado de imóvel");
        m.addField("Consultar imóveis mais visitados");
        m.addField("Últimas consultas aos seus imóveis em venda");
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
                novoImovelUI(imobiliaria);
                break;
            case 4:
                mudarEstadoImovelUI(imobiliaria);
                break;
            case 5:
                //topVisitasUI(imobiliaria);
                break;
            case 6:
                aVendaUI(imobiliaria);
                break;
            case 7:
                contactosUI(imobiliaria);
                break;
            case 0:
                imobiliaria.fechaSessao();
                initial_menu(imobiliaria);
                break;
        }
    }


    public static void listarUI(Imoobiliaria imobiliaria) {

        int choice;
        Scanner scanner = new Scanner(System.in);
        Menu m = new Menu();
        Menu n = new Menu();
        String tipos[] = {"Apartamento", "Loja", "Moradia", "Terreno"};
        String tipo;

        m.addField("Apartamento");
        m.addField("Loja");
        m.addField("Moradia");
        m.addField("Terreno");
        m.addField("Voltar");

        choice = m.presentChoices();
        if (choice == 0) {
            initial_menu(imobiliaria);
            return;
        } else {
            tipo = tipos[choice - 1];
        }

        System.out.println("Preço máximo: ");
        int precoMaximo = scanner.nextInt();

        List<Imovel> imoveis = imobiliaria.getImovel(tipo, precoMaximo);

        imoveis.stream().forEach(i -> n.addField(i.shortLine()));
        n.addField("Sair");

        choice = m.presentChoices(15);
        if (choice == 0) {
            initial_menu(imobiliaria);
        } else {
            imovelUI(imobiliaria);
        }



    }

    public static void contactosUI(Imoobiliaria imobiliaria) {
        Menu m = new Menu();
        Map<Imovel, Vendedor> contactos = imobiliaria.getMapeamentoImoveis();
        Set<Map.Entry<Imovel, Vendedor>> entries = contactos.entrySet();

        entries.stream()
                .forEach(entry -> m.addField(entry.getKey().getId() + " - " + entry.getValue().getEmail()));

        m.addField("Sair");

        int choice = m.presentChoices(15);
        if (choice == 0) {
            initial_menu(imobiliaria);
        } else {
            imovelUI(imobiliaria);
        }
    }

    public static void habitaveisUI(Imoobiliaria imobiliaria) {
        //TODO public List<Habitavel> getHabitaveis(int preco)
        Menu m = new Menu();
        m.addField("Price");
        int price = Integer.parseInt(m.getParams().get(0));
        List<Habitavel> habitaveis = imobiliaria.getHabitaveis(price);

        Menu n = new Menu();
        habitaveis.stream().map(h -> (Imovel) h).forEach(i -> n.addField(i.shortLine()));
        n.addField("Sair");

        int choice = n.presentChoices(15);
        if (choice == 0) {
            initial_menu(imobiliaria);
        } else {
            imovelUI(imobiliaria);
        }
    }

    public static void favoritosUI(Imoobiliaria imobiliaria) {
        TreeSet<Imovel> favs;
        try {
            favs = imobiliaria.getFavoritos();
        } catch (SemAutorizacaoException e) {
            return;
        }
        Menu m = new Menu();
        favs.stream().forEach(i -> m.addField(i.shortLine()));
        m.addField("Sair");

        int choice = m.presentChoices(15);
        if (choice == 0) {
            initial_menu(imobiliaria);
        } else {
            imovelUI(imobiliaria);
        }

    }

    public static void aVendaUI(Imoobiliaria imobiliaria) {
        List<Consulta> consultas;
        try {
            consultas = imobiliaria.getConsultas();
        } catch (SemAutorizacaoException e) {
            return;
        }

        Menu m = new Menu();
        consultas.stream().forEach(i -> m.addField(i.toString()));
        m.addField("Sair");

        int choice = m.presentChoices(15);
        if (choice == 0) {
            initial_menu(imobiliaria);
        } else {
            imovelUI(imobiliaria);
        }
    }


    public static void topVisitasUI(Imoobiliaria imobiliaria) {
        //TODO Set<String> getTopImoveis(int n)
        Menu m = new Menu();
        m.addField("Número de entradas");
        int n = Integer.parseInt(m.getParams().get(0));

        Set<String> topImoveis = imobiliaria.getTopImoveis(n);

        Menu m2 = new Menu();
        topImoveis.stream().forEach(s -> m2.addField(s));
        m2.addField("Sair");

        int choice = m2.presentChoices(15);
        if (choice == 0) {
            initial_menu(imobiliaria);
        } else {
            imovelUI(imobiliaria);
        }

    }

    public static void novoImovelUI(Imoobiliaria imobiliaria) {
        // TODO void registaImovel(Imovel im) throws ImovelExisteException, SemAutorizacaoException
        Menu m = new Menu();
        m.addField("");
    }

    public static void mudarEstadoImovelUI(Imoobiliaria imobiliaria) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Id do imóvel:");
        String idImovel = scanner.nextLine();

        Menu m = new Menu();
        m.addField("Por vender");
        m.addField("Vendido");
        m.addField("Sair");

        int choice = m.presentChoices();

        if (choice != 0) {
            try {
                if (choice == 1) {
                    imobiliaria.setEstado(idImovel, "Livre");
                } else if (choice == 2) {
                    imobiliaria.setEstado(idImovel, "Vendido");
                }

            } catch (ImovelInexistenteException e) {
                Menu.messageUser("Imóvel não existente!");
            } catch (SemAutorizacaoException e) {
                Menu.messageUser("Utilizador tem de ser vendedor!");
            } catch (EstadoInvalidoException e) {
                Menu.messageUser("Estado não é válido!");
            }

        } else {
            initial_menu(imobiliaria);
        }

    }

    public static void imovelUI(Imoobiliaria imobiliaria) {

    }


    // Métodos de instância
    public Imoobiliaria() {
        imoveis = new HashMap<>();
        users = new HashMap<>();

        loggedUser = null;
        consultas = new TreeSet<>(new ComparatorData());
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
        if (loggedAsSeller()) {
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
        if (loggedAsSeller()) {
            return consultas.stream()
                    .limit(10)
                    .collect(Collectors.toList());
        } else {
            throw new SemAutorizacaoException("Não está autenticado como vendedor!");
        }
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
            throw new SemAutorizacaoException("Não está autenticado como vendedor!");
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

        Set<Map.Entry<String, Integer>> sortedEntries = new TreeSet<>(new ComparatorCounter());

        Vendedor v = (Vendedor) loggedUser;
        sortedEntries.addAll(v.getNConsultas().entrySet());
        return sortedEntries.stream()
                .limit(n)
                .map(i -> i.getKey())
                .collect(Collectors.toSet());
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

