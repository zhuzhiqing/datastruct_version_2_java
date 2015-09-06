package com.jason.graph.algrithm;

import java.util.Scanner;

public class FloydMatrix {
//public class Main {
	int map[][];
	int nVexs;

	private void init() {
		Scanner scanner = new Scanner(System.in);
		nVexs = scanner.nextInt();
		int nEdges = scanner.nextInt();

		map = new int[nVexs][nVexs];
		for (int i = 0; i < nVexs; i++) {
			for (int j = 0; j < nVexs; j++) {
				map[i][j] = Integer.MAX_VALUE/10;
			}
		}

		for (int k = 0; k < nEdges; k++) {				//构造邻接矩阵
			int pos1 = scanner.nextInt()-1;
			int pos2 = scanner.nextInt()-1;
			int weight = scanner.nextInt();

			if (map[pos1][pos2] > weight) {
				map[pos2][pos1] = map[pos1][pos2] = weight;
			}
		}
		
		for(int j=0; j<nVexs; j++){					//对角线为0
			map[j][j] = 0;
		}
	}
	
	public void floyd(){
		for(int k=0; k<nVexs; k++){
			for(int i=0; i<nVexs; i++){
				for(int j=0; j<nVexs; j++){
					if(map[i][j]>map[i][k]+map[k][j]){
						map[i][j] = map[j][i] = map[i][k]+map[k][j];
					}
				}
			}
		}
	}
	
	public void printFloyd(){
		for(int i=0; i<nVexs; i++){
			for(int j=0; j<nVexs; j++){
				System.out.print(map[i][j]);
				System.out.print(" ");
			}
			System.out.println("");
		}
	}
	
	public static void main(String []args){
		FloydMatrix instance = new FloydMatrix();
		instance.init();
		instance.floyd();
		instance.printFloyd();
	}
}
