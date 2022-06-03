package Trabalho;

import Folha.FolhaPagamentoCargo;
import Folha.FolhaPessoal;
import Funcionario.Funcionario;
import Persistencia.Id;
import Persistencia.Tabela;
import Persistencia.Transiente;
import Trabalho.excessoes.numeroHorasTrabalho;
import Trabalho.excessoes.valorMinimoARceberPorHora;
import Validacao.ExcecaoNaoPodeSerNulo;
import Validacao.ExcecaoTamanhoMinimo;

@Tabela(nome = "_cargo")
public class Cargo implements FolhaPessoal{
	
	@Id
	private int id;
	@Transiente
	private Departamento departamento;
	@Transiente
	private Funcionario funcionario;
	private String nome;

	public Cargo(String nome, Departamento departamento, Funcionario funcionario)
			throws ExcecaoNaoPodeSerNulo, ExcecaoTamanhoMinimo, valorMinimoARceberPorHora, numeroHorasTrabalho {
		super();
		
		this.nome = nome;
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public void folhaPessoal(FolhaPagamentoCargo folha) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public String toString() {
		return "Cargo [departamento=" + departamento + ", funcionario=" + funcionario + ", nome=" + nome + "]";
	}
	
	
}
