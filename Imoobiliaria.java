import java.util.ArrayList;
/**
 * \\ TODO: Receber 
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Imoobiliaria{

	private ArrayList<Actor> users;

	public boolean verificaUtilizador(Actor user){
		if (user == null) {
            return false;
        }
        return users.contains(user);
	}
   
   public void registarUtilizador(Actor user){
   		if (verificaUtilizador(user)){
   			users.add(user);

   		} 

   		else System.out.println("O utilizador já existe no sistema");
   		
   		
   }
}
