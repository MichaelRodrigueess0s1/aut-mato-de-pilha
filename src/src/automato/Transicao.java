package automato;

import estruturas.SimpleStack;

public class Transicao{

	private Character simbolo;
	private Estado proximo, origem;
	private Character empilha;
	private Character desempilha;
	
	
	
	public Transicao(Character simbolo, Estado origem, Estado proximo, Character desempilha, Character empilha) {
	
		this.simbolo = simbolo;
		this.proximo = proximo;
		this.empilha = empilha;
		this.desempilha = desempilha;
		this.origem = origem;
		
				// vou empilhar e desempilhar os elementos assin que forem passados no construtor
		
		
	}

	public char getSimbolo() {
		return simbolo;
	}


	public void setSimbolo(Character simbolo) {
		this.simbolo = simbolo;
	}


	public Estado getProximo() {
		return proximo;
	}


	public void setProximo(Estado proximo) {
		this.proximo = proximo;
	}


	public Estado getOrigem() {
		return origem;
	}


	public void setOrigem(Estado origem) {
		this.origem = origem;
	}


	public Character getEmpilha() {
		return empilha;
	}


	public void setEmpilha(Character empilha) {
		this.empilha = empilha;
	}


	public Character getDesempilha() {
		return desempilha;
	}


	public void setDesempilha(Character desempilha) {
		this.desempilha = desempilha;
	}
        
	public Estado retornaProximo(){
		
		return proximo;
	}
	
	public Estado retornaOrigem(){
		
		
		return origem;		
	}
	
	
	
	
}
