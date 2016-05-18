
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
import java.util.Scanner;
import java.lang.String;
import java.util.Collections;
import java.util.Iterator;
import java.util.stream.Collectors;
import java.util.HashMap;


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
            if(loggedUser instanceof Vendedor && im != null){
                if(imoveis.contains(im)){
                  throw new ImovelExisteException("Já existe este imóvel");
                }
                else imoveis.add(im);

            }
            else {throw new SemAutorizacaoException("O utilizador não tem acesso");}
        
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
        ArrayList<Imovel> lista = new ArrayList<Imovel>();
        return lista.stream().filter(i -> mesmoTipoImovel(classe, i)).filter(i -> i.getPrecoPedido() < preco).collect(Collectors.toList());
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
    public List<Habitavel> getHabitaveis(int preco) {
        return null;
    }

    //Obter um mapeamento entre todos os imóveis e respetivos vendedores.
    public Map<Imovel, Vendedor> getMapeamentoImoveis() {
        HashMap<Imovel,Vendedor> res = new HashMap<Imovel,Vendedor>();
        for(Imovel i : imoveis){
            
       
        }
        
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

