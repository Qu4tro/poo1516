
/**
 * Escreva a descrição da classe Loja aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Loja extends Imovel {
    private double area;
    private boolean temWC;
    private String tipoNegocio;
    private int porta;

    public Loja() {
        area = 0.0;
        temWC = false;
        tipoNegocio = "";
        porta = 0;
    }

    public Loja(String id, String rua, EstadoImovel estado, double precoP, double precoM, Vendedor vendedor,
                double area, boolean wc, String tipo, int porta) {
        super(id, rua, estado, precoP, precoM, vendedor);
        this.area = area;
        this.temWC = wc;
        this.tipoNegocio = tipo;
        this.porta = porta;
    }

    public Loja(Loja l) {
        super(l);
        area = l.getArea();
        temWC = l.getTemWC();
        tipoNegocio = l.getTipoNegocio();
        porta = l.getPorta();
    }

    public double getArea() {
        return area;
    }

    public boolean getTemWC() {
        return temWC;
    }

    public String getTipoNegocio() {
        return tipoNegocio;
    }

    public int getPorta() {
        return porta;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public void setTemWC(boolean wc) {
        this.temWC = wc;
    }

    public void setTipoNegocio(String tipo) {
        this.tipoNegocio = tipo;
    }

    public void setPorta(int porta) {
        this.porta = porta;
    }

    public Loja clone() {
        return new Loja(this);
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }
        Loja lj = (Loja) o;
        return lj.getArea() == area && lj.getTemWC() == temWC &&
                lj.getTipoNegocio().equals(tipoNegocio) && lj.getPorta() == porta;
    }

    public String toString() {
        StringBuilder s;
        s = new StringBuilder();
        s.append("Área: ");
        s.append(area);
        s.append("Tem WC: ");
        s.append(temWC);
        s.append("Tipo de negócio viável na loja: ");
        s.append(tipoNegocio);
        s.append("Nº de porta:");
        s.append(porta);
        return s.toString();
    }

}
