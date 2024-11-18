package model.estrutura.grafo;

import java.util.*;

public class grafoMatriz<T>{
	private int[][] matrix;
	private String[] point;
	
	/** 
		grafoMatriz(String[]) -> builder, create a matrix with all the items in an array;
		link -> stablish the conection beteween 2 points in the matrix;
		toString() -> print on console;
	**/
	
	public grafoMatriz(String[] point){
		this.point = point;
		this.matrix = new int[point.length][point.length];
	}
	
	public void link(String Origin, String Destination){
		int indexOrigin = Arrays.asList(this.point).indexOf(Origin);
		int indexDestination = Arrays.asList(this.point).indexOf(Destination);
		this.matrix[indexOrigin][indexDestination] = 1;
		this.matrix[indexDestination][indexOrigin] = 1;
	}
	
	public void remove(String element1, String element2){
		int indexElement1 = Arrays.asList(this.point).indexOf(element1);
		int indexElement2 = Arrays.asList(this.point).indexOf(element2);
		this.matrix[indexElement1][indexElement2] = 0;
		this.matrix[indexElement2][indexElement1] = 0;
	}
	
	public void removeAll(String Element, String[] array){
		int indexElement = 0;
		for(int cto = 0; cto < array.length; cto ++){
			if(Element == array[cto]){
				indexElement = cto;
				break;
			}
		}
		for(int i = 0; i < this.point.length; i++){
			this.matrix[i][indexElement] = 0;
			this.matrix[indexElement][i] = 0;
		}
	}

	
	@Override
	public String toString(){
		StringBuilder builder = new StringBuilder();
		for(int i = 0; i < this.point.length; i++){
			builder.append(this.point[i] + ":");
			for(int j = 0; j < this.point.length; j++){
				if(this.matrix[i][j] == 1){
					builder.append(this.point[j] + " ");
				}
			}
			builder.append("\r\n");
		}
		return(builder.toString());
	}
}