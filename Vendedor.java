
/**
 * Escreva a descrição da classe Vendedor aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Vendedor extends Utilizador {

    ArrayList<Imovel> imoveis;
    private Map<String, Integer> nConsultas;

    public Vendedor() {
        imoveis = new ArrayList<Imovel>();
        nConsultas = new HashMap<>();

    }

    public Vendedor(String email, String nom, String pass, String mor, String dataN, ArrayList<Imovel> imoveis) {
        super(email, nom, pass, mor, dataN);
        this.imoveis = imoveis;
        nConsultas = new HashMap<>();
    }

    public Vendedor(Vendedor vend){
        super(vend);
        setImoveis(vend.getImoveis());
        nConsultas = vend.getNConsultas();
    }

    public ArrayList<Imovel> getImoveis() {
        ArrayList<Imovel> res = new ArrayList<>();
        for (Imovel i : imoveis) {
            res.add(i.clone());
        }
        return res;
    }

    public Map<String, Integer> getNConsultas() {
        return nConsultas;
    }

    public void setNConsultas(Map<String, Integer> nConsultas) {
        this.nConsultas = nConsultas;
    }

    public void consult(String idImovel) {
        if (nConsultas.containsKey(idImovel)) {
            nConsultas.put(idImovel, nConsultas.get(idImovel) + 1);
        }
        nConsultas.put(idImovel, 1);
    }

    public void setImoveis(ArrayList<Imovel> imoveisVendidos) {
        this.imoveis.clear();
        for (Imovel i : imoveis) {
            this.imoveis.add(i.clone());
        }
    }
    
    public Vendedor clone(){
        return new Vendedor(this);
    }
    
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if(o == null | o.getClass() != this.getClass()){
            return false;
        }
        Vendedor v = (Vendedor) o;
        if (imoveis.size() != v.getImoveis().size()) {
            return false;
        }

        for (int i = 0; i < imoveis.size(); i++) {
            if (!imoveis.get(i).equals(v.getImoveis().get(i))) {
                return false;
            }
        }
        return true;
    }
    
    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append(super.toString());
        for (Imovel imovel : imoveis) {
            s.append(imoveis.toString() + "\n");
        }
        for (Imovel imovel : imoveis) {
            s.append(imoveis.toString() + "\n");
        }
        return s.toString();
    }

}