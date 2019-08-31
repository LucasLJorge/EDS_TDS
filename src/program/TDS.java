package program;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Random;

public class TDS {
	private static long simulation_time; //TEMPO TOTAL DE SIMULAÇÃO
	private static long increment; //INCREMENTO REALIZADO ENTRE SIMULAÇÕES

	private static int process_counts;
	private static ArrayList<Integer> results = new ArrayList<Integer>();
	private static ArrayList<Long> resultsTimes = new ArrayList<Long>();
	private static Random random = new Random();
	private static ArrayList<Integer> vetor1 = new ArrayList<Integer>(20);
	private static ArrayList<Integer> vetor2 = new ArrayList<Integer>(10);
	private static long iterationTime;

	public static void main(String[] args) {
		simulation_time = 3000;
		long simulation_time_total = simulation_time;
		
		increment = 100;
		iterationTime += increment;
		long remainingIterationTime = iterationTime;

		for (int i=0;i<20;i++) { //POPULANDO A LISTA A SER MANIPULADA
			vetor1.add(0 + random.nextInt(100));
		}
		while(true) {
			boolean isEndIterarionStep = false;
			Instant inicio = Instant.now();
			process();
			Instant fim = Instant.now();

			//VALIDA SE PROCESSO PODE ENTRAR NA ITERACAO
			Duration duracao = Duration.between(inicio, fim);
			long duracaoEmMilissegundos = duracao.toMillis();
			remainingIterationTime -= duracaoEmMilissegundos;
			if(remainingIterationTime >= 0) {
				process_counts++;
				System.out.println("Tempo estimado: " + duracaoEmMilissegundos + "ms");
				System.out.println("----");
			}else {//SE NAO PODE ADICIONAR, PREPARA PARA NOVO CICLO PARA ITERAR
				resultsTimes.add(new Long(iterationTime));
				isEndIterarionStep = true;
				iterationTime += increment;
				remainingIterationTime = iterationTime;
			}
			
			//VALIDA SE TEM TEMPO PARA CONTINUAR COM SIMULACAO
			simulation_time -= duracaoEmMilissegundos;
			if(simulation_time > 0) {
				if (isEndIterarionStep) results.add(new Integer(process_counts));
			}else {
				if(isEndIterarionStep) results.add(new Integer(process_counts));
				break;
			}
		}
		
		System.out.println("-----------------------------------------------------------------");
		System.out.println("Tempo total estimado: " + simulation_time_total + "ms");
		System.out.println("Passos executados: " + results.size());
		System.out.println("-----------------------------------------------------------------");
		System.out.println("DESCRICAO:");
		for(int i = 0; i < results.size(); i++) {
			System.out.println("-----------------------------------------------------------------");
			System.out.println("PASSO ("+ i +"):");
			System.out.println("Tempo estimado: " + resultsTimes.get(i).longValue() + "ms");
			System.out.println("Processos executados: " + results.get(i).intValue());
			System.out.println("-----------------------------------------------------------------");
		}
	}

	public static void process() {

		System.out.println("FILA INICIAL: " + vetor1); //FILA QUE É REPASSADA PARA PROCESSAMENTO
		for (int j=0;j<10;j++) {
			vetor2.add(vetor1.get(0));
			vetor1.remove(0);
			vetor1.add(0 + random.nextInt(100));
		}
		System.out.println("ATENDIMENTO: " + vetor2);
		System.out.println("FILA: " + vetor1);
		System.out.println("");
		System.out.println("----");
		vetor2.clear();

	}
}
