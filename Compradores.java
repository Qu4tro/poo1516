import java.util.ArrayList;

public class Compradores extends Utilizador {

    private ArrayList<String> favoritos;

    public Compradores() {
        super();
        favoritos = new ArrayList<>();
    }

    public Compradores(String email, String nom, String pass, String mor, String dataN) {
        super(email, nom, pass, mor, dataN);
        favoritos = new ArrayList<>();
    }

    public Compradores(Utilizador vendedor) {
        this(vendedor.getEmail(), vendedor.getNome(),
                vendedor.getPassword(), vendedor.getMorada(), vendedor.getDataNascimento());
        favoritos = new ArrayList<>();
    }

    public Compradores(Compradores comprador) {
        super(comprador);
        favoritos = comprador.getFav();
    }

    public ArrayList<String> getFav() {
        return favoritos;
    }

    public void setFavorito(String idImovel) {
        // TODO: Verificar se idMovel existe, se n existe throw ImovelInexistente
        favoritos.add(idImovel);
    }

    public void addFav(String a) {
        if (a != null) {
            favoritos.add(a);
        }
    }

    public Compradores clone() {
        return new Compradores(this);
    }


}   

