
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

    public Terreno(double a, double d, double k, boolean c, String id) {
        this.area = a;
        this.diamCanalizacoes = d;
        this.kWh = k;
        this.temAcesso = c;
        this.id = id;
    }

    public Terreno(Terreno a) {
        area = a.getArea();
        diamCanalizacoes = a.getDiam();
        kWh = a.getkW();
        temAcesso = a.getAcess();
        id = a.getId();
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
    
    public String getId(){
        return id;
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
    
    public void setId(String id){
        this.id = id;
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
        s.append("Area: ");
        s.append(area);
        s.append("\nO diametro das canalizações é: ");
        s.append(diamCanalizacoes);
        s.append("\nOs kwhz maximos são: ");
        s.append(kWh);
        s.append("\nTem acesso?: ");
        s.append(temAcesso);
        s.append("\nId : ");
        s.append(id);

        return s.toString();
    }


}
