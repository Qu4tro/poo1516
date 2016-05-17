
/**
 * Escreva a descrição da classe ComparatorLoja aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
import java.io.Serializable;
import java.util.Comparator;
public class ComparatorLoja implements Comparator<Loja>, Serializable
{
    public int compare(Loja l1, Loja l2){
        double c1 = l1.getArea();
        double c2 = l2.getArea();
        if(c1 < c2) return 1;
        else return -1;
    }
}