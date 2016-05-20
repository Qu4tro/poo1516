
/**
 * Escreva a descrição da classe Consulta aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class Consulta
{
    private GregorianCalendar data;
    private String email;
    
    public Consulta(){
        data = new GregorianCalendar();
        email = "";

    }
    
    public Consulta(GregorianCalendar data, String email){
        this.data = data;
        this.email = email;

    }
    
    public Consulta(Consulta c){
        this.data = c.getData();
        this.email = c.getEmail();

    }
    
    public GregorianCalendar getData(){
        return data;
    }
    
    public String getEmail(){
        return email;
    }


    public Consulta clone(){
        return new Consulta(this);
    }
    
    public boolean equals(Object o){
        if(o == this){
            return true;
        }
        if(o == null || o.getClass() != this.getClass()){
            return false;
        }
        Consulta c = (Consulta) o;
        return data.equals(c.getData()) && email.equals(c.getEmail());
    }
    
    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append("Data: " + data);
        s.append("\t");
        s.append("Email: " + email);
        return s.toString();
    }
    

}
    

