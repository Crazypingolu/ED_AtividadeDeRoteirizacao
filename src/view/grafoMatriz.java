package view;

import controller.Controller;

public class grafoMatriz{
	public static void main(String[] args){
		try{
			Controller obj = new Controller();
			obj.carregaLista();
		} catch(Exception e){
			e.printStackTrace();
		} finally{
			System.out.println("\nFim do programa.\n");
		}
	}
}