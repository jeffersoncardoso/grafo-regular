/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafo;

import java.util.Scanner;

/**
 *
 * @author jeffe
 */
public class Grafo {
    
    public static void mostrarMatriz(int[][] m){
        try{
            int rows = m.length;
            int columns = m[0].length;
            
            String str = "|\t\t";
            
            for(int j=0;j<columns;j++){ str += j + "\t"; }
            str += "|\n";
            str += "|\t";
                
            for(int i=0;i<rows;i++){
                str += i + "\t";
                for(int j=0;j<columns;j++){ str += m[i][j] + "\t"; }
                System.out.println(str + "|");
                str = "|\t";
            }

        }catch(Exception e){System.out.println("Matrix is empty!!");}
    }
    
    private static boolean verificarEhRegular(int[][] grafo)
    {
        int linhas = grafo.length;
        int colunas = grafo[0].length;
        
        int arestasPrimeiraLinha = contarArestas(grafo[0]);
        for (int i = 1; i < grafo.length; i++) {
            if(arestasPrimeiraLinha != contarArestas(grafo[i]))
                return false;
        }
        
        return true;
    }
    
    private static int contarArestas(int[] vetor) 
    {
        int soma = 0;
        for (int i = 0; i < vetor.length; i++) {
            if(vetor[i] == 1)
                soma++;
        }
        
        return soma;
    }
    
    private static int[][] inicializarGrafo(int numeroVertices)
    {
        Scanner scanner = new Scanner(System.in);
        int grafo[][] = new int[numeroVertices][numeroVertices];
        
        for (int i = 0; i < numeroVertices; i++) {
            for (int j = 0; j < numeroVertices; j++) {
                grafo[i][j] = 0;
            }
        }
        
        return grafo;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Digite o número de vértices: ");
        int numeroVertices = Integer.parseInt(scanner.nextLine());        
        
        int grafo[][] = inicializarGrafo(numeroVertices);
        
        for (int vertice = 0; vertice < numeroVertices; vertice++) {
            System.out.printf("Digite os vértices que formam arestas com o vértice %s (separados por vírgula): ", vertice);
            
            String texto = scanner.nextLine().trim();
            if(texto.isEmpty())
                continue;
            
            String[] arestas = texto.split(",");
            
            for (String aresta : arestas) {
                grafo[vertice][Integer.parseInt(aresta)] = 1;
                grafo[Integer.parseInt(aresta)][vertice] = 1;
            }
        }
        
        System.out.println("");
        mostrarMatriz(grafo);
        if(verificarEhRegular(grafo)) {
            System.out.println("\t\tGRAFO REGULAR");
        } else {
            System.out.println("\t\tGRAFO NÃO É REGULAR");
        }
    }
    
}
