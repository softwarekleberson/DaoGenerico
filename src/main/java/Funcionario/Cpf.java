package Funcionario;

import Persistencia.Coluna;
import Persistencia.Id;
import Persistencia.Tabela;
import Trabalho.excessoes.ExcecaoCpfInvalido;

@Tabela(nome = "cpf")
public class Cpf {
	
	@Id
	private int id;
	@Coluna(nome = "cadastroPessoaFissica")
	private String cpf;
	
	public Cpf(String cpf) throws ExcecaoCpfInvalido {
		this.cpf = cpf;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) throws ExcecaoCpfInvalido {
		if(cpf == null || !cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}")) {
			throw new ExcecaoCpfInvalido("cpf invalido");
		}
		this.cpf = cpf;
	}

	@Override
	public String toString() {
		return "Cpf [cpf=" + cpf + "]";
	}
	
	
}
