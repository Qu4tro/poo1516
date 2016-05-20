import java.util.HashMap;
import java.util.Map;

/**
 * Escreva a descrição da classe Imóveis aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */

enum EstadoImovel {
    LIVRE, VENDIDO;
}

public abstract class Imovel extends Imoobiliaria {

    private String id;
    private String rua;
    private EstadoImovel estado;
    private double precoPedido;
    private double precoMinimo;
    private Vendedor vendedor;


    public Imovel() {
        id = "";
        rua = "";
        estado = EstadoImovel.VENDIDO;
        precoPedido = 0.0;
        precoMinimo = 0.0;
        vendedor = null;
    }

    public Imovel(String id, String rua, EstadoImovel estado, double precoP, double precoM, Vendedor vendedor) {
        this.id = id;
        this.rua = rua;
        this.estado = estado;
        this.precoPedido = precoP;
        this.precoMinimo = precoM;
        this.vendedor = vendedor;
    }

    public Imovel(Imovel i) {
        id = i.getId();
        rua = i.getRua();
        estado = i.getEstado();
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

    public EstadoImovel getEstado() {
        return estado;
    }


    public void setEstado(EstadoImovel estado) {
        this.estado = estado;
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
        return im.getId().equals(id) && im.getRua().equals(rua) && im.getEstado().equals(estado)
                && getPrecoPedido() == precoPedido && im.getPrecoMinimo() == precoMinimo
                && vendedor.equals(im.getVendedor());
    }

    public String shortLine() {
        StringBuilder s;

        s = new StringBuilder();
        s.append(id);
        s.append(" - ");
        s.append(this.getClass().getSimpleName());
        s.append(" - ");
        s.append(rua);
        s.append(" - ");
        s.append(precoPedido);

        return s.toString();
    }

    public String toString() {
        StringBuilder s;

        s = new StringBuilder();
        s.append("ID: ");
        s.append(id);
        s.append("\nRua: ");
        s.append(rua);
        s.append("\nEstado: ");
        s.append(estado);
        s.append("\nPreço Pedido: ");
        s.append(precoPedido);
        s.append("\nPreço Minimo: ");
        s.append(precoMinimo);
        s.append("\n\nVendedor: ");
        s.append(vendedor.getEmail());
        return s.toString();
    }


}