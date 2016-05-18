
/**
 * Escreva a descrição da classe Moradia aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Moradia extends Imovel {
    private String tipo;
    private double areaImplementacao;
    private double areaTotal;
    private double areaTerreno;
    private int quartos;
    private int wc;
    private int porta;

    public Moradia() {
        tipo = "";
        areaImplementacao = 0.0;
        areaTotal = 0.0;
        areaTerreno = 0.0;
        quartos = 0;
        wc = 0;
        porta = 0;
    }

    public Moradia(String tipo, double areaI, double areaTot, double areaTerr, int q, int wc, int por) {
        this.tipo = tipo;
        this.areaImplementacao = areaI;
        this.areaTotal = areaTot;
        this.areaTerreno = areaTerr;
        this.quartos = q;
        this.wc = wc;
        this.porta = por;
    }

    public Moradia(Moradia m) {
        tipo = m.getTipo();
        areaImplementacao = m.getAreaImplementacao();
        areaTotal = m.getAreaTotal();
        areaTerreno = m.getAreaTerreno();
        quartos = m.getQuartos();
        wc = m.getWc();
        porta = m.getPorta();
    }

    public String getTipo() {
        return tipo;
    }

    public double getAreaImplementacao() {
        return areaImplementacao;
    }

    public double getAreaTotal() {
        return areaTotal;
    }

    public double getAreaTerreno() {
        return areaTerreno;
    }

    public int getQuartos() {
        return quartos;
    }

    public int getWc() {
        return wc;
    }

    public int getPorta() {
        return porta;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setAreaImplementacao(double areaI) {
        this.areaImplementacao = areaI;
    }

    public void setAreaTotal(double areaTotal) {
        this.areaTotal = areaTotal;
    }

    public void setAreaTerreno(double areaTerreno) {
        this.areaTerreno = areaTerreno;
    }

    public void setQuartos(int quartos) {
        this.quartos = quartos;
    }

    public void setWc(int wc) {
        this.wc = wc;
    }

    public void setPortas(int porta) {
        this.porta = porta;
    }

    public Moradia clone() {
        return new Moradia(this);
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }
        Moradia mor = (Moradia) o;
        return mor.getTipo().equals(tipo) && mor.getAreaImplementacao() == areaImplementacao
                && mor.getAreaTotal() == areaTotal && mor.getAreaTerreno() == areaTerreno && mor.getQuartos() == quartos
                && mor.getWc() == wc && mor.getPorta() == porta;
    }

    public String toString() {
        StringBuilder s;
        s = new StringBuilder();

        s.append("Tipo: ");
        s.append(tipo);
        s.append("Área de Implementação: ");
        s.append(areaImplementacao);
        s.append("Área total coberta: ");
        s.append(areaTotal);
        s.append("Área terreno envolvente: ");
        s.append(areaTerreno);
        s.append("Nº de quartos: ");
        s.append(quartos);
        s.append("Nº de WCs: ");
        s.append(wc);
        s.append("Nº da porta: ");
        s.append(porta);
        return s.toString();
    }


}
