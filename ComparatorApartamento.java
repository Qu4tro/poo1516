
/**
 * Escreva a descrição da classe ComparatorApartamento aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
import java.io.Serializable;
import java.util.Comparator;
public class ComparatorApartamento implements Comparator<Apartamento>, Serializable 
{
    public int compare(Apartamento a1, Apartamento a2){
        String c1 = a1.getTipo();
        String c2 = a2.getTipo();
        return c1.compareTo(c2);
    }
}
