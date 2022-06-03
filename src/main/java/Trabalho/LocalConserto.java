package Trabalho;

import java.time.LocalDate;

import Persistencia.Id;
import Persistencia.Tabela;
import Persistencia.Transiente;
import Trabalho.excessoes.nomeInferiorADoisCaracteres;
import Trabalho.excessoes.valorMinimoObra;

@Tabela(nome = "localConseto")
public class LocalConserto {

	@Transiente
	private static final double VALOR_MINIMO_OBRA = 0;
	
	@Id
	private int id;
	private String localObra;
	private double valorObra;
	private LocalDate inicioObra = LocalDate.now();
	
	public LocalConserto(String localObra, double valorObra) throws nomeInferiorADoisCaracteres, valorMinimoObra {

		setLocalObra(localObra);
		setValorObra(valorObra);
	}

	public String getLocalObra() {
		return localObra;
	}

	public void setLocalObra(String localObra) throws nomeInferiorADoisCaracteres {
		if(localObra == null || localObra.length() < 2) {
			throw new nomeInferiorADoisCaracteres("nome deve ser superior a 2 caracteres");
		}
		this.localObra = localObra;
	}

	public double getValorObra() {
		return valorObra;
	}

	public void setValorObra(double valorObra) throws valorMinimoObra {
		if(valorObra < VALOR_MINIMO_OBRA) {
			throw new valorMinimoObra("valor minimo deve ser superior a 0");
		}
		this.valorObra = valorObra;
	}

	public LocalDate getInicioObra() {
		return inicioObra;
	}

	public void setInicioObra(LocalDate inicioObra) {
		this.inicioObra = inicioObra;
	}

	@Override
	public String toString() {
		return "LocalConserto [localObra=" + localObra + ", valorObra=" + valorObra + ", inicioObra=" + inicioObra
				+ "]";
	}
	
}
