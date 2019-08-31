package program;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Timer;
import java.util.TimerTask;

public class EDS {
	private static ArrayList vetor = new ArrayList();
	private static long tempocorrido = 0;

	public static void main(String[] args) {

		int x = 30;
		System.out.println("Serão " + x + " iterações."); //PREPARANDO O ESTADO DO SISTEMA E A LISTA DE EVENTOS
		for (int i=0;i<=ThreadLocalRandom.current().nextInt(200, 300);i++) {
			vetor.add(0 + ThreadLocalRandom.current().nextInt(0, 100000));
			System.out.println((i+1) + " elementos no atual estado.");
			System.out.println(vetor.get(i));
		}
		System.out.println("");
		while(true) {
			long duracaoEmMilissegundos;
            if(x == 0)
            	break;
    		Instant inicio = Instant.now(); //COLETA ESTATÍSTICAS DE TEMPO DO ESTADO ATUAL
			process(); //REMOVE EVENTO DA LISTA
			Instant fim = Instant.now();
			Duration duracao = Duration.between(inicio, fim); //REALIZA A CONTAGEM DE TEMPO DOS EVENTOS
			duracaoEmMilissegundos = duracao.toMillis(); 
			tempocorrido += duracaoEmMilissegundos;
			System.out.println("TEMPO DECORRIDO: " + duracaoEmMilissegundos + "ms");
			System.out.println("TEMPO TOTAL: " + tempocorrido + "ms");
			x--; //DECREMENTA DA LISTAGEM DE EVENTOS
		}
	}

	private static void process() {
		System.out.println(vetor);
		System.out.println("\nRemovido evento " + vetor.get(0));
		vetor.remove(0);
		vetor.add(ThreadLocalRandom.current().nextInt(0, 100));
		System.out.println("----------------------------------------------------------------------");		
	}

}
