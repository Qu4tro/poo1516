
/**
 * Escreva a descrição da classe Apartamento aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Apartamento extends Imovel {
    private String tipo;
    private double areaTotal;
    private int quartos;
    private int wc;
    private int porta;
    private int andar;
    private boolean temGaragem;

    public Apartamento() {
        tipo = "";
        areaTotal = 0.0;
        quartos = 0;
        wc = 0;
        porta = 0;
        andar = 0;
        temGaragem = false;
    }

    public Apartamento(String tipo, double areaT, int quar, int wc, int p, int and, boolean temGaragem) {
        this.tipo = tipo;
        this.areaTotal = areaT;
        this.quartos = quar;
        this.wc = wc;
        this.porta = p;
        this.andar = and;
        this.temGaragem = temGaragem;
    }

    public Apartamento(Apartamento ap) {
        tipo = ap.getTipo();
        areaTotal = ap.getAreaTotal();
        quartos = ap.getQuartos();
        wc = ap.getWc();
        porta = ap.getPorta();
        andar = ap.getAndar();
        temGaragem = ap.getTemGaragem();
    }

    public String getTipo() {
        return tipo;
    }

    public double getAreaTotal() {
        return areaTotal;
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

    public int getAndar() {
        return andar;
    }

    public boolean getTemGaragem() {
        return temGaragem;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setAreaTotal(double area) {
        this.areaTotal = area;
    }

    public void setQuartos(int quartos) {
        this.quartos = quartos;
    }

    public void setWc(int wc) {
        this.wc = wc;
    }

    public void setPorta(int porta) {
        this.porta = porta;
    }

    public void setAndar(int andar) {
        this.andar = andar;
    }

    public void setTemGaragem(boolean temGaragem) {
        this.temGaragem = temGaragem;
    }

    public Apartamento clone() {
        return new Apartamento(this);
    }

    public boolean Apartamento(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }
        Apartamento apart = (Apartamento) o;
        return apart.getTipo().equals(tipo) && apart.getAreaTotal() == areaTotal && apart.getQuartos() == quartos
                && apart.getWc() == wc && apart.getPorta() == porta && apart.getAndar() == andar &&
                apart.getTemGaragem() == temGaragem;
    }

    public String toString() {
        StringBuilder s;
        s = new StringBuilder();

        s.append("Tipo: ");
        s.append(tipo);
        s.append("Área Total: ");
        s.append(areaTotal);
        s.append("Nº de quartos: ");
        s.append(quartos);
        s.append("Nº de WCs: ");
        s.append(wc);
        s.append("Nº da porta: ");
        s.append(porta);
        s.append("Nº do andar: ");
        s.append(andar);
        s.append("Tem garagem: ");
        s.append(temGaragem);
        return s.toString();
    }

}
