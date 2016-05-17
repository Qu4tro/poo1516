
/**
 * Escreva a descrição da classe Vendedor aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
import java.util.ArrayList;

public class Vendedor extends Utilizador {

    ArrayList<Imovel> imoveisEmVenda;
    ArrayList<Imovel> imoveisVendidos;

    public Vendedor() {
        imoveisEmVenda = new ArrayList<Imovel>();
        imoveisVendidos = new ArrayList<Imovel>();
    }

    public Vendedor(String email, String nom, String pass, String mor, String dataN, ArrayList<Imovel> iVenda, ArrayList<Imovel> iVendidos) {
        super(email, nom, pass, mor, dataN);
        iVenda = new ArrayList<>();
        iVendidos = new ArrayList<>();
    }

    public Vendedor(Utilizador vendedor) {
        //this(vendedor.getEmail(), vendedor.getNome(),
          //      vendedor.getPassword(), vendedor.getMorada(), vendedor.getDataNascimento());
    }

    public Vendedor(Vendedor vend){
        super(vend);
        setImoveisEmVenda(vend.getImoveisEmVenda());
        setImoveisVendidos(vend.getImoveisVendidos());
    }
    
    public ArrayList<Imovel> getImoveisEmVenda() {
        ArrayList<Imovel> res = new ArrayList<Imovel>();
        for(Imovel i : imoveisEmVenda){
            res.add(i.clone());
        }
        return res;
    }
    
    public ArrayList<Imovel> getImoveisVendidos(){
        ArrayList<Imovel> res = new ArrayList<Imovel>();
        for(Imovel i : imoveisVendidos){
            res.add(i.clone());
        }
        return res;
    }
    
    public void setImoveisEmVenda(ArrayList<Imovel> imoveisEmVenda){
        this.imoveisEmVenda.clear();
        for(Imovel i : imoveisEmVenda){
            this.imoveisEmVenda.add(i.clone());
        }
    }

    public void setImoveisVendidos(ArrayList<Imovel> imoveisVendidos) {
        this.imoveisVendidos.clear();
        for(Imovel i : imoveisVendidos){
            this.imoveisVendidos.add(i.clone());
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
        if(imoveisEmVenda.size() != v.getImoveisEmVenda().size()){
            return false;
        }
        if(imoveisVendidos.size() != v.getImoveisVendidos().size()){
            return false;
        }
        for(int i=0; i<imoveisEmVenda.size(); i++){
            if(!imoveisEmVenda.get(i).equals(v.getImoveisEmVenda().get(i))){
                return false;
            }
        }
        for(int i=0; i<imoveisVendidos.size(); i++){
            if(!imoveisVendidos.get(i).equals(v.getImoveisVendidos().get(i))){
                return false;
            }
        }
        return true;
    }
    
    public String toString(){
        StringBuilder s = new StringBuilder();
        for(Imovel imovel : imoveisEmVenda){
            s.append(imoveisEmVenda.toString() +"\n");
        }
        for(Imovel imovel : imoveisVendidos){
            s.append(imoveisVendidos.toString() + "\n");
        }
        return s.toString();
    }

}