
/**
 * Escreva a descrição da classe Imóveis aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Imóveis extends Imoobiliaria
{
    private String rua;
    private double precoPedido;
    private double precoMinimo;
    
    public Imóveis(){
        rua = "";
        precoPedido = 0.0;
        precoMinimo = 0.0;
    }
    
    public Imóveis(String rua, double precoP, double precoM){
        this.rua = rua;
        this.precoPedido = precoP;
        this.precoMinimo = precoM;
    }
    
    public Imóveis(Imóveis i){
        rua = i.getRua();
        precoPedido = i.getPrecoPedido();
        precoMinimo = i.getPrecoMinimo();
    }
    
    public String getRua(){
        return rua;
    }
    public double getPrecoPedido(){
        return precoPedido;
    }
    public double getPrecoMinimo(){
        return precoMinimo;
    }
    
    public void setRua(String rua){
        this.rua = rua;
    }
    public void setPrecoPedido(double precoP){
        this.precoPedido = precoP;
    }
    public void setPrecoMinimo(double precoM){
        this.precoMinimo = precoM;
    }
    
    public Imóveis clone(){
        return new Imóveis(this);
    }
    
    public boolean Imóveis(Object o){
        if(o == this){
            return true;
        }
        if(o == null || o.getClass() != this.getClass()){
            return false;
        }
        Imóveis im = (Imóveis) o;
        return im.getRua() == rua && im.getPrecoPedido() == precoPedido && 
        im.getPrecoMinimo() == precoMinimo;
    }
    
    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append("Rua: " + rua + "Preço Pedido: " + precoPedido + "PrecoMinimo: " + precoMinimo);
        return s.toString();
    }
    
    
    
    
}
