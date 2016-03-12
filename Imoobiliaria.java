import java.util.ArrayList
/**
 * \\ TODO: Receber 
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Imoobiliaria{

	private ArrayList<Actores> lista;

	public boolean verificautilizador(Actores utilizador){
		for (int i = 0; i < lista.size(); i++){
			if (utilizador == lista.get(i)) return True;

		}
		return False;
	}
   
   public void registarUtilizador(Actores utilizador){
   		if (verificautilizador(utilizador)){
   			lista.add(utilizador);

   		} 

   		else System.out.println("O utilizador já existe no sistema");
   		
   		
   }
}
