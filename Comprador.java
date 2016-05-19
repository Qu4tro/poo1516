
/**
 * Escreva a descrição da classe Compradores aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
import java.util.ArrayList;

public class Comprador extends Utilizador {

    private ArrayList<String> favoritos;

    public Comprador() {
        super();
        favoritos = new ArrayList<>();
    }

    public Comprador(String email, String nom, String pass, String mor, String dataN, ArrayList<Imovel> favor) {
        super(email, nom, pass, mor, dataN);
        this.favoritos = new ArrayList<>();
    }

    public Comprador(Utilizador vendedor) {
      //  this(vendedor.getEmail(), vendedor.getNome(),
        //        vendedor.getPassword(), vendedor.getMorada(), vendedor.getDataNascimento());
        favoritos = new ArrayList<>();
    }

    public Comprador(Comprador favoritos) {
        super(favoritos);
        setFavoritos(favoritos.getFavoritos());
    }

    public ArrayList<String> getFavoritos() {
        return (ArrayList<String>) favoritos.clone();
    }

    public void setFavoritos(ArrayList<String> favoritos) {
        // TODO: Verificar se idMovel existe, se n existe throw ImovelInexistente
        this.favoritos = (ArrayList<String>) favoritos.clone();
    }

    public void addFav(String idImovel) {
        if (idImovel != null) {
            favoritos.add(idImovel);
        }
    }

    public Comprador clone() {
        return new Comprador(this);
    }
    
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if(o ==null || o.getClass() != this.getClass()){
            return false;
        }
        Comprador c = (Comprador) o;
        if(favoritos.size() != c.getFavoritos().size()){
            return false;
        }
        for(int i=0; i<favoritos.size(); i++){
            if(!favoritos.get(i).equals(c.getFavoritos().get(i))){
                return false;
            }
        }
        return true;
    }
    
    public String toString(){
        StringBuilder s = new StringBuilder();
        for (String imovel : favoritos) s.append(imovel + "\n");
        return s.toString();
    }

}