package model.estrutura.listaEncadeada;

import java.lang.Exception;
import model.estrutura.listaEncadeada.No;

public class listaEncadeada {
		private No inicio = null;
		
		public void append (String elemento){
			No buffer = new No(elemento);
			if (this.inicio == null){
				this.inicio = buffer;
			} else {
				this.last().setProximo(buffer);
			}
		}
		public No get (int index) throws IllegalArgumentException{
			int i = 0;
			if (this.inicio == null) 
				throw new IllegalArgumentException("Nao existe item na lista.");
			No buffer = this.inicio;
			for(i = 0; i < index; i++){
				if(buffer.getProximo() == null)
					break;
				buffer = buffer.getProximo();
			}
			if(i < index)
				throw new IllegalArgumentException("O indice informado não existe");
			return buffer;
		}
		public int index(String elemento) throws IllegalArgumentException{
			if (this.inicio == null)
				throw new IllegalArgumentException("Não existe item na lista");
			int index = 0;
			if (this.inicio.getCidade().equals(elemento))
				return index;
			No buffer = this.inicio;
			do {
				if( buffer.getCidade().equals(elemento)){
					return index;
				}
				buffer = buffer.getProximo();
				index++;
			} while(buffer != null);
			System.out.println("não achou");
			return (-1);
		}
		public void insert(int index, String elemento) throws IllegalArgumentException{
			if (index == 0){
				No buffer_novo = new No (elemento);
				if( this. inicio != null ){
					No buffer_inicio = this.inicio;
					buffer_novo.setProximo(buffer_inicio);
					this.inicio = buffer_novo;
				} else {
					this.inicio = buffer_novo;
				}
			} else {
				this.insert(this.get(--index), elemento);
			}
		}
		public void insert(No item, String elemento) throws IllegalArgumentException {
			No buffer_novo = new No(elemento);
			No buffer_proximo = item.getProximo();
			item.setProximo(buffer_novo);
			buffer_novo.setProximo(buffer_proximo);
		}
		public No last() throws IllegalArgumentException{
			if (this.inicio == null )
				throw new IllegalArgumentException ("Não existe item na lista");
			No buffer = this.inicio;
			while(buffer.getProximo() != null)
				buffer = buffer.getProximo();
			return buffer;
		}
		public void remove(int index){
			if(index == 0){
				this.inicio.setCidade(null);
				if(this.inicio.getProximo() == null){
					this.inicio = null;
				} else {
					No buffer = this.inicio.getProximo();
					this.inicio.setProximo(null);
					this.inicio = buffer;
				}
				return;
			}
			No buffer_anterior = this.get(--index);
			No item = buffer_anterior.getProximo();
			No buffer_proximo = item.getProximo();
			buffer_anterior.setProximo(buffer_proximo);
			item.setProximo(null);
			item.setCidade(null);
		}
		public int total() {
			if (this.inicio == null)
				return 0;
			No buffer = this.inicio;
			int total_elementos = 0;
			do{
				total_elementos++;
				buffer = buffer.getProximo();
			} while (buffer != null);
			return total_elementos;
		}
		
		@Override
		public String toString(){
			if (this.inicio == null){
				return "{}";
			}
			StringBuilder builder = new StringBuilder("[");
			No buffer = this.inicio;
			builder.append(buffer.getCidade());
			while(buffer.getProximo() != null){
				builder.append(",");
				buffer = buffer.getProximo();
				builder.append(buffer.getCidade());
			}
			builder.append("]");
			return builder.toString();
		}
}