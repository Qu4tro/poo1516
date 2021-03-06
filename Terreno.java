
/**
 * Escreva a descrição da classe Terreno aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Terreno extends Imovel {
    private double area;
    private double diamCanalizacoes;
    private double kWh;
    private boolean temAcesso;
    private String id;
    
    public Terreno(){
        area = 0.0;
        diamCanalizacoes = 0.0;
        kWh = 0.0;
        temAcesso = false;
        id = "";
    }

    public Terreno(String id, String rua, EstadoImovel estado, double precoP, double precoM, Vendedor vendedor,
                   double a, double d, double k, boolean c) {
        super(id, rua, estado, precoP, precoM, vendedor);
        this.area = a;
        this.diamCanalizacoes = d;
        this.kWh = k;
        this.temAcesso = c;
    }

    public Terreno(Terreno a) {
        super(a);
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
        return ac.getArea() == area && ac.getDiam() == diamCanalizacoes && ac.getkW() == kWh && ac.getAcess() == temAcesso &&
        ac.getId() == id;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();

        s.append(super.toString());
        s.append("Area: ");
        s.append(area);
        s.append("\nO diametro das canalizações é: ");
        s.append(diamCanalizacoes);
        s.append("\nOs kwhz maximos são: ");
        s.append(kWh);
        s.append("\nTem acesso?: ");
        s.append(temAcesso);

        return s.toString();
    }


}
