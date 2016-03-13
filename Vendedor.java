import java.util.ArrayList;

public class Vendedor extends Utilizador {

    ArrayList<String> imoveisEmVenda;
    ArrayList<String> imoveisVendidos;

    public Vendedor() {
        imoveisEmVenda = new ArrayList<>();
        imoveisVendidos = new ArrayList<>();
    }

    public Vendedor(String email, String nom, String pass, String mor, String dataN) {
        super(email, nom, pass, mor, dataN);
        imoveisEmVenda = new ArrayList<>();
        imoveisVendidos = new ArrayList<>();
    }

    public Vendedor(Utilizador vendedor) {
        this(vendedor.getEmail(), vendedor.getNome(),
                vendedor.getPassword(), vendedor.getMorada(), vendedor.getDataNascimento());
    }


    public ArrayList<String> getImoveisEmVenda() {
        return imoveisEmVenda;
    }

    public void setImoveisEmVenda(ArrayList<String> imoveisEmVenda) {
        this.imoveisEmVenda = imoveisEmVenda;
    }

    public void setImovelEmVenda(String idImovel) {

    }

    public ArrayList<String> getImoveisVendidos() {
        return imoveisVendidos;
    }

    public void setImoveisVendidos(ArrayList<String> imoveisVendidos) {
        this.imoveisVendidos = imoveisVendidos;
    }

    public void setImovelComoVendido(String idImovel) {

    }
}
