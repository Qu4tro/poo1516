import java.util.ArrayList;
/**
 * Escreva a descrição da classe Compradores aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Compradores extends Actores{
	
	private ArrayList<String> favoritos;

	public Compradores(){
		favoritos = new ArrayList<>();

	}
	/*
	public Compradores(ArrayList<String> fav){
		this.favoritos = fav;
	}
	*/

	public Compradores(Compradores comprador){
		favoritos = comprador.getFav();
	}

	public ArrayList<> getFav(){
		return favoritos;
	}

	public void setFavorito(String idImovel){

		// TODO: Verificar se idMovel existe, se n existe throw ImovelInexistente
		favoritos.add(idImovel);


	}

	public void addFav(Imvel a){
		if (a != NULL){
			favoritos.add(a);
		}
	}

	public Compradores clone(){
		return new Compradores(this);
	}

	public boolean Compradores(Object o){
		if(o == this){
			return true;
		}

	}
}   

