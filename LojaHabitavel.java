
/**
 * Escreva a descrição da classe LojaHabitavel aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class LojaHabitavel extends Loja implements Habitavel
{
    private String tipo;
    private int quartos;
    private int andar;
    private boolean temGaragem;

    public LojaHabitavel() {
        tipo = "";
        quartos = 0;
        andar = 0;
        temGaragem = false;
    }

    public LojaHabitavel(String tipo, int quar, int and, boolean temGaragem) {
        this.tipo = tipo;
        this.quartos = quar;
        this.andar = and;
        this.temGaragem = temGaragem;
    }

    public LojaHabitavel(LojaHabitavel lh) {
        tipo = lh.getTipo();
        quartos = lh.getQuartos();
        andar = lh.getAndar();
        temGaragem = lh.getTemGaragem();
    }

    public String getTipo() {
        return tipo;
    }

    public int getQuartos() {
        return quartos;
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

    public void setQuartos(int quartos) {
        this.quartos = quartos;
    }

    public void setAndar(int andar) {
        this.andar = andar;
    }

    public void setTemGaragem(boolean temGaragem) {
        this.temGaragem = temGaragem;
    }

    public LojaHabitavel clone() {
        return new LojaHabitavel(this);
    }

    public boolean LojaHabitavel(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }
        LojaHabitavel apart = (LojaHabitavel) o;
        return apart.getTipo().equals(tipo) && apart.getQuartos() == quartos && apart.getAndar() == andar &&
                apart.getTemGaragem() == temGaragem;
    }

    public String toString() {
        StringBuilder s;
        s = new StringBuilder();

        s.append("Tipo: ");
        s.append(tipo);
        s.append("Nº de quartos: ");
        s.append(quartos);
        s.append("Nº do andar: ");
        s.append(andar);
        s.append("Tem garagem: ");
        s.append(temGaragem);
        return s.toString();
    }
}
