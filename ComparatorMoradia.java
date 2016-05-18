
/**
 * Escreva a descrição da classe ComparatorMoradia aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
import java.io.Serializable;
import java.util.Comparator;
public class ComparatorMoradia implements Comparator<Moradia>, Serializable
{
    public int compare(Moradia m1, Moradia m2){
        String c1 = m1.getTipo();
        String c2 = m2.getTipo();
        return c1.compareTo(c2);
    }
}
