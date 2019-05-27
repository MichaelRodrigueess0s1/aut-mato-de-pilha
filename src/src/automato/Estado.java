package automato;

import java.util.ArrayList;
import java.util.LinkedList;


public class Estado {
	private String nome;
	private boolean esInicial, esFinal;
	
	private ArrayList<Transicao> listaTransicao = new ArrayList<Transicao>();
		public Estado(String nome, boolean esInicial, boolean esFinal) {
		this.nome = nome;
		this.esInicial = esInicial;
		this.esFinal = esFinal;
		
	}
		
		public void addTransicao(Transicao e){
			
			listaTransicao.add(e);
		}
                
                
                public void Desconstrutor(){
                    
                    listaTransicao.clear();
                    
                }
		
                
                public ArrayList<Transicao> getListaTransicao(){
                    
                    
                    return listaTransicao;
                }
              
		
				public String getNome() {
			return nome;
		}



		public void setNome(String nome) {
			this.nome = nome;
		}



		public boolean isEsInicial() {
			return esInicial;
		}



		public void setEsInicial(boolean esInicial) {
			this.esInicial = esInicial;
		}



		public boolean isEsFinal() {
			return esFinal;
		}



		public void setEsFinal(boolean esFinal) {
			this.esFinal = esFinal;
		}

				
		
}
