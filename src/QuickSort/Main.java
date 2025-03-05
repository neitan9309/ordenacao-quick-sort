//Créditos para o dono do canal "Bro Code", que eu sempre recorro para procurar meus cursos (gratuitos) de programação.
//Link para o vídeo sobre estrutura de dados e algorítmos: https://youtu.be/CBYHwZcbD-s?si=NSHDQx0HUmC6M3XZ

package QuickSort;

public class Main{
	
	public static void main(String args[]) {
		int array[] = {11, 5, 13, 24, 15, 1, 0, 7, 9, 4};
		
		quickSort(array, 0, array.length - 1); //Chamada do método quickSort, assinando os parâmetros com o array a ser organizado, sua posição inicial e a final, respectivamente.
		
		for(int i : array) {
			System.out.print(i + " ");
		}
	}
	
	private static void quickSort(int[] array, int start, int end) {
		
		if(end <= start) return; //Cancela a operação caso não tenha elementos no conjunto.
		
		int pivot = partition(array, start, end); //Chamada do método "partition". Responsável por achar o "pivot", elemento que dividirá o array em duas partes, e o posicionar.
		quickSort(array, start, pivot - 1); //Chamada recursiva do método quickSort. Responsável por organizar o array "esquerdo" (em relação ao pivot).
		quickSort(array, pivot + 1, end); //Ordenação do array direito.
		
	}
	
	private static int partition(int[] array, int start, int end) {
		
		int pivot = array[end]; //Momento que definimos o índice do pivot, que será ao final do conjunto.
		int i = start - 1; //"Régua", iniciada uma posição antes do primeiro elemento, que serve para mapear onde o próximo dado menor que o pivot será alocado.
		
		for(int j = start; j <= end - 1; j++) { //Loop que percorre o array do inicio até o elemento anterior ao pivot, servindo como a segunda régua.
			if(array[j] < pivot) {   //Condicional que verifica se o elemento j é infereior ao pivot.
				i++; 				 //Caso a condição seja verdadeira, incrementamos i,
				int temp = array[i]; //assinamos a variável "temp" (que serve como um auxiliar na organização dos dados) com o elemento do índice i,
				array[i] = array[j]; //reescrevemos a posição i com o elemento de j,
				array[j] = temp;	 //e assinamos o índice j com o elemento temporário.
			}
		}
		i++; //Logo após o loop se encerrar, sabemos onde será a posição do pivot: uma posição após a última rearranjada.
		int temp = array[i];   //Então assinamos uma variável temp com elemento de i,
		array[i] = array[end]; //reescrevemos a posição com o último dado do array (pivot),
		array[end] = temp;	   //e assinamos o último índice com a variável temp.
		
		return i; //Retorna o pivot, complemetando o método quickSort.
	}
	
}