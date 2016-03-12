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

   		else{
          throw new UtilizadorExistenteException();
      }
   		
   		
   }


   public void iniciaSessao ( String email , String password ){
        for(String actor : users){
          if (email == actor.getEmail()){
            if(password == actor.getPassword()){
                // inicia a sessão;  
            } else {
                // password errada
            }
          }
        }
        throw new SemautorizacaoException();
        // não há utilizador;
   }
   public void fechaSessao(){
    // falta cenas
   }

}
  
  class UtilizadorExistenteException extends Exception{
      public UtilizadorExistenteExcetpion(){
          super();
      }
  }

  class SemautorizacaoException extends Exception{
      public SemautorizacaoException() {
          super();
      }
  }