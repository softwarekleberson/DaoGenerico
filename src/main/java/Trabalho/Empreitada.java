package Trabalho;

import java.util.ArrayList;
import java.util.List;

import Folha.FolhaPagamentoCargo;
import Folha.FolhaPessoal;
import Funcionario.Pessoa;
import Persistencia.Id;
import Persistencia.Tabela;
import Validacao.ExcecaoNaoPodeSerNulo;
import Validacao.ExcecaoTamanhoMinimo;

@Tabela(nome = "empreitada")
public class Empreitada extends Pessoa implements FolhaPessoal {

	@Id
	private int id;
	private List <LocalConserto> conserto = new ArrayList<>();
	
	
	public Empreitada(String nomePessoa)
			throws ExcecaoNaoPodeSerNulo, ExcecaoTamanhoMinimo {
		super(nomePessoa);
		
	}


	public List<LocalConserto> getConserto() {
		return conserto;
	}

	
	public void setConserto(List<LocalConserto> conserto) {
		this.conserto.addAll(conserto);
	}


	@Override
	public void folhaPessoal(FolhaPagamentoCargo folha) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public String toString() {
		return "Empreitada [conserto=" + conserto + "]";
	}	

}
