package br.edu.ifpb.armazenamento;

import br.edu.ifpb.dominio.Direcao;

public interface Armazenamento {

	public Direcao recuperar();
	
	public void armazenar(Direcao direcao) ;
	
}
