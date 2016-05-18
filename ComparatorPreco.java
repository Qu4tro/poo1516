
/**
 * Escreva a descrição da classe ComparatorPreco aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
import java.util.Comparator;
import java.io.Serializable;
public class ComparatorPreco implements Comparator<Imovel>, Serializable
{
    public int compare(Imovel i1, Imovel i2){
        double p1 = i1.getPrecoPedido();
        double p2 = i2.getPrecoPedido();
        if(p1 < p2) return 1;
        else return -1;
    }
}
