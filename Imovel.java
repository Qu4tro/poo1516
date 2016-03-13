
/**
 * Escreva a descrição da classe Imovel aqui.
 *
 * @author (seu nome)
 * @version (número de versão ou data)
 */
public class Imovel extends Imoobiliaria {
    private String rua;
    private double precoPedido;
    private double precoMinimo;

    public Imovel() {
        rua = "";
        precoPedido = 0.0;
        precoMinimo = 0.0;
    }

    public Imovel(String rua, double precoP, double precoM) {
        this.rua = rua;
        this.precoPedido = precoP;
        this.precoMinimo = precoM;
    }

    public Imovel(Imovel i) {
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

    public void setRua(String rua) {
        this.rua = rua;
    }

    public void setPrecoPedido(double precoP) {
        this.precoPedido = precoP;
    }

    public void setPrecoMinimo(double precoM) {
        this.precoMinimo = precoM;
    }

    public Imovel clone() {
        return new Imovel(this);
    }

    public boolean Imovel(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }
        Imovel im = (Imovel) o;
        return im.getRua().equals(rua) && im.getPrecoPedido() == precoPedido &&
                im.getPrecoMinimo() == precoMinimo;
    }

    public String toString() {
        StringBuilder s;

        s = new StringBuilder();
        s.append("Rua: ");
        s.append(rua);
        s.append("\nPreço Pedido: ");
        s.append(precoPedido);
        s.append("\nPreço Minimo: ");
        s.append(precoMinimo);
        return s.toString();
    }


}
