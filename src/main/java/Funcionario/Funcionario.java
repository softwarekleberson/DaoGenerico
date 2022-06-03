package Funcionario;

import Persistencia.Id;
import Persistencia.Tabela;
import Persistencia.Transiente;
import Trabalho.Departamento;
import Validacao.ExcecaoNaoPodeSerNulo;
import Validacao.ExcecaoTamanhoMinimo;

@Tabela(nome = "funcionario")
public class Funcionario {	
	
	public static final double SALARIO_MINIMO = 1212;
	
	@Id
	private int id;
	@Transiente
	private Cpf cpf;	
	@Transiente
	private Pessoa pessoa;
	@Transiente
	private Departamento departamento;

	public Funcionario(Pessoa pessoa, Cpf cpf, Departamento departamento)
			throws ExcecaoNaoPodeSerNulo, ExcecaoTamanhoMinimo {
		
		this.cpf = cpf;
		this.departamento = departamento;
	}

	@Override
	public String toString() {
		return "Funcionario [id=" + id + ", cpf=" + cpf + ", pessoa=" + pessoa + ", departamento=" + departamento + "]";
	}

}
