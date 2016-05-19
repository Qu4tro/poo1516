
/**
 * Escreva a descrição da classe Imóveis aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public abstract class Imovel extends Imoobiliaria {

    private String id;
    private String rua;
    private double precoPedido;
    private double precoMinimo;
    private Vendedor vendedor;

    public Imovel() {
        id = "";
        rua = "";
        precoPedido = 0.0;
        precoMinimo = 0.0;
        vendedor = null;
    }

    public Imovel(String id, String rua, double precoP, double precoM, Vendedor vendedor) {
        this.id = id;
        this.rua = rua;
        this.precoPedido = precoP;
        this.precoMinimo = precoM;
        this.vendedor = vendedor;
    }

    public Imovel(Imovel i) {
        id = i.getId();
        rua = i.getRua();
        precoPedido = i.getPrecoPedido();
        precoMinimo = i.getPrecoMinimo();

    }

    public String getRua() {
        return rua;
    }

    public double getPrecoPedido() {
        return precoPedido;
    }

    public double getPrecoMinimo() {
        return precoMinimo;
    }

    public String getId() {
        return id;
    }

    public Vendedor getVendedor() {
        return vendedor.clone();
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public void setPrecoPedido(double precoP) {
        this.precoPedido = precoP;
    }

    public void setPrecoMinimo(double precoM) {
        this.precoMinimo = precoM;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public abstract Imovel clone();
    
    public boolean Imovel(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }
        Imovel im = (Imovel) o;
        return im.getRua().equals(rua) && im.getPrecoPedido() == precoPedido &&
                im.getPrecoMinimo() == precoMinimo && im.getId() == id && vendedor.equals(im.getVendedor());
    }

    public String toString() {
        StringBuilder s;

        s = new StringBuilder();
        s.append("ID: ");
        s.append(id);
        s.append("Rua: ");
        s.append(rua);
        s.append("\nPreço Pedido: ");
        s.append(precoPedido);
        s.append("\nPreço Minimo: ");
        s.append(precoMinimo);
        s.append("\nVendedor: ");
        s.append(vendedor.getEmail());
        return s.toString();
    }


}