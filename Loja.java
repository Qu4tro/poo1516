
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

    public Loja(double area, boolean wc, String tipo, int porta) {
        this.area = area;
        this.temWC = wc;
        this.tipoNegocio = tipo;
        this.porta = porta;
    }

    public Loja(Loja l) {
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

    public boolean Loja(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }
        Loja lj = (Loja) o;
        return lj.getArea() == area && lj.getTemWC() == temWC &&
                lj.getTipoNegocio() == tipoNegocio && lj.getPorta() == porta;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("Área: " + area + "Tem WC: " + temWC + "Tipo de negócio viável na loja: " +
                tipoNegocio + "Nº de porta: " + porta);
        return s.toString();
    }

}
