
/**
 * Escreva a descrição da classe ComparatorTerreno aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
import java.io.Serializable;
import java.util.Comparator;
public class ComparatorTerreno implements Comparator<Terreno>, Serializable
{
    public int compare(Terreno t1, Terreno t2){
        double c1 = t1.getArea();
        double c2 = t2.getArea();
        if(c1 < c2) return 1;
        else return -1;
    }
}