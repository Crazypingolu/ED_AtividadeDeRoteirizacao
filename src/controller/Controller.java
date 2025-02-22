package controller;

import model.estrutura.grafo.grafoMatriz;
import model.estrutura.listaEncadeada.listaEncadeada;
import java.io.*;

public class Controller{
	public Controller(){
		super();
	}
	
	public void carregaLista() throws Exception{
		String cidadeA, cidadeB, dist;
		listaEncadeada lista = new listaEncadeada();
		String file = "mapa2.txt"; // Escolhe o arquivo para leitura
        BufferedReader ler = new BufferedReader(new FileReader(file)); // cria  "leitor"
		int cto = 0;
        while(true){
            cidadeA = ler.readLine(); // ler str
			if(cidadeA == null){
				break;
			}
			cidadeB = ler.readLine(); // ler str
			dist = ler.readLine(); // por convenção (int)
			cidadeA = cidadeA.trim();
			cidadeB = cidadeB.trim();
			dist = dist.trim();
			// procura na lista:
			if(cto == 0 || lista.index(cidadeA) == -1){
				cto += 1;
				lista.append(cidadeA);
			}
			if(lista.index(cidadeB) == -1){
				lista.append(cidadeB);
			}
        }
        ler.close();
		int tamanho = lista.total();
		System.out.println(test(lista, tamanho));
	}
	
	public String test(listaEncadeada lista, int tamanho) throws Exception{
		String[] points = new String[tamanho];
		for(int i = 0; i < points.length; i++){
			points[i] = lista.get(i).getCidade();
		}
		grafoMatriz g = new grafoMatriz(points);		
		return g.toString();
	}
}