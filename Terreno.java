
/**
 * Escreva a descrição da classe Terreno aqui.
 *
 * @author Talig81
 * @version (número de versão ou data)
 */
public class Terreno extends Imovel {
    private double area;
    private double diamCanalizacoes;
    private double kWh;
    private boolean temAcesso;

    public Terreno(double a, double d, double k, boolean c) {
        this.area = a;
        this.diamCanalizacoes = d;
        this.kWh = k;
        this.temAcesso = c;
    }

    public Terreno(Terreno a) {
        area = a.getArea();
        diamCanalizacoes = a.getDiam();
        kWh = a.getkW();
        temAcesso = a.getAcess();
    }

    public double getArea() {
        return area;
    }

    public double getDiam() {
        return diamCanalizacoes;
    }

    public double getkW() {
        return kWh;
    }

    public boolean getAcess() {
        return temAcesso;
    }

    public void setArea(double d) {
        this.area = d;
    }

    public void setDiam(double d) {
        this.diamCanalizacoes = d;
    }

    public void setKw(double d) {
        this.kWh = d;
    }

    public void setAcess(boolean t) {
        this.temAcesso = t;
    }


    public Terreno clone() {
        return new Terreno(this);
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }
        Terreno ac = (Terreno) o;
        return ac.getArea() == area && ac.getDiam() == diamCanalizacoes && ac.getkW() == kWh && ac.getAcess() == temAcesso;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("Area: " + area);
        s.append("O diametro das canalizações é: " + diamCanalizacoes);
        s.append("Os kwhz maximos são: " + kWh);
        s.append("Tem acesso?: " + temAcesso);

        return s.toString();
    }
}
