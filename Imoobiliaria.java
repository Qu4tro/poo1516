import java.util.ArrayList;
/**
 * \\ TODO: Receber 
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Imoobiliaria{

	private ArrayList<Actor> lista;

	public boolean verificautilizador(Actor utilizador){
		for (int i = 0; i < lista.size(); i++){
			if (utilizador == lista.get(i)) return true;

		}
		return false;
	}
   
   public void registarUtilizador(Actor utilizador){
   		if (verificautilizador(utilizador)){
   			lista.add(utilizador);

   		} 

   		else System.out.println("O utilizador já existe no sistema");
   		
   		
   }
}
