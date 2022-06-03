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

@Tabela(nome = "horista")
public class Horista implements FolhaPessoal {
		
	@Transiente
	private static final double VALOR_MINIMO_RECEBER = 5;
	@Transiente
	private static final int HORAS_MINIMAS_TRABALHO = 30;
	
	@Id
	private int id;
	private double valor;
	private int horasTrabalhadas;
	
	@Transiente
	private Funcionario funcionario;
	@Transiente
	private Departamento departamento;

	
	public Horista(double valor, int horasTrabalhadas,Funcionario funcionario, Departamento departamento)
			throws ExcecaoNaoPodeSerNulo, ExcecaoTamanhoMinimo, valorMinimoARceberPorHora, numeroHorasTrabalho {
		super();

		setValor(valor);
		setHorasTrabalhadas(horasTrabalhadas);
	
	}
	
	public double getValor() {
		return valor;
	}

	public void setValor(double valor) throws valorMinimoARceberPorHora {
		if(valor < VALOR_MINIMO_RECEBER) {
			throw new valorMinimoARceberPorHora("valor minimo a receber por hora de trabalho " );
		}
		this.valor = valor;
	}

	public int getHorasTrabalhadas() {
		return horasTrabalhadas;
	}

	public void setHorasTrabalhadas(int horasTrabalhadas) throws numeroHorasTrabalho {
		if(horasTrabalhadas < HORAS_MINIMAS_TRABALHO) {
			throw new numeroHorasTrabalho("valor minimo de horas de trabalho " + this.horasTrabalhadas);
		}
		this.horasTrabalhadas = horasTrabalhadas;
	}


	@Override
	public void folhaPessoal(FolhaPagamentoCargo folha) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		return "Horista [valor=" + valor + ", horasTrabalhadas=" + horasTrabalhadas + ", funcionario=" + funcionario
				+ ", departamento=" + departamento + "]";
	}

	
}
