package Trabalho;

import Persistencia.Id;
import Persistencia.Tabela;
import Persistencia.Transiente;
import Trabalho.excessoes.nomeInferiorADoisCaracteres;
import Trabalho.excessoes.salarioBaseDepartamento;

@Tabela(nome = "_departamento")
public class Departamento {

	@Transiente
	public static final double SALARIO_MINIMO_DEPARTAMENTO = 2000;
	@Transiente
	public static final int TAMANHO_MINIMO_STRING = 2;
	
	@Id
	private int id;
	private String nome;
	private double salarioBase;
	
	public Departamento(String nome, double salarioBase) throws salarioBaseDepartamento, nomeInferiorADoisCaracteres {

		setNome(nome);
		setSalarioBase(salarioBase);		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) throws nomeInferiorADoisCaracteres {
		if(nome == null || nome.length() < TAMANHO_MINIMO_STRING) {
			throw new nomeInferiorADoisCaracteres("nome deve ser superior a dois caracteres");
		}
		this.nome = nome;
	}

	public double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(double salarioBase) {
		this.salarioBase = salarioBase;
	}

	@Override
	public String toString() {
		return "Departamento [nome=" + nome + ", salarioBase=" + salarioBase + "]";
	}


}
