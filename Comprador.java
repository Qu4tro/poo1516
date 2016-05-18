
/**
 * Escreva a descrição da classe Compradores aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
import java.util.ArrayList;

public class Comprador extends Utilizador {

    private ArrayList<Imovel> favoritos;

    public Comprador() {
        super();
        favoritos = new ArrayList<>();
    }

    public Comprador(String email, String nom, String pass, String mor, String dataN, ArrayList<Imovel> favor) {
        super(email, nom, pass, mor, dataN);
        this.favoritos = new ArrayList<Imovel>();
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

    public ArrayList<Imovel> getFavoritos() {
        ArrayList<Imovel> res = new ArrayList<Imovel>();
        for(Imovel i: favoritos){
            res.add(i.clone());
        }
        return res;
    }

    public void setFavoritos(ArrayList<Imovel> favoritos) {
        // TODO: Verificar se idMovel existe, se n existe throw ImovelInexistente
        this.favoritos.clear();
        for(Imovel i : favoritos){
            this.favoritos.add(i.clone());
        }
    }

    public void addFav(Imovel imovel) {
        if (imovel != null) {
            favoritos.add(imovel.clone());
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
        for(Imovel imovel : favoritos) s.append(imovel.toString() + "\n");
        return s.toString();
    }

}