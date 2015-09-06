package com.jason.graph.algrithm;

import java.util.Scanner;

public class PrimMatrix {
	public static int MAX_INT = Integer.MAX_VALUE/10;
	
	public static void prim(int graph[][], int nVexs){
		
		 /* lowcost[i]记录以i为终点的边的最小权值，当lowcost[i]=0时表示终点i加入生成树 */
		int lowcost[] = new int[nVexs];
		
		/* closeset[i]记录了边依附在U中的顶点*/
		int closeset[] = new int[nVexs];
		
		/* visited[i]记录顶点是否可见*/
		boolean visited[] = new boolean[nVexs];
		
		int sumWeight =0;
		
		lowcost[0] = 0;
		closeset[0] = 0;
		visited[0] = true;
		
		//初始化
		for(int i=1; i<nVexs; i++){
			lowcost[i] = graph[0][i];
			closeset[i] = i;
			visited[i] = false;
		}
			
		/*选出n-1条边*/
		for(int j=1; j<nVexs; j++){
			
			int minCost = MAX_INT;
			int minIndex = -1;
			
			for(int k=0; k<nVexs; k++){
				if(!visited[k] && lowcost[k]<minCost){
					minCost = lowcost[k];
					minIndex = k;		
				}
			}
			
			visited[minIndex] = true;		//可见
			sumWeight+=minCost;
			
			//发现更小权值的边
			for(int m=1; m<nVexs; m++){
				if(!visited[m] && lowcost[m]>graph[minIndex][m]){
					lowcost[m] = graph[minIndex][m];
					closeset[m] = minIndex;
				}
			}
		}
		
		System.out.println(sumWeight);
	}
	
	public static void main(String [] args){
		Scanner scanner = new Scanner(System.in);
		char chx,chy;
		
		//读取节点和边的数目
		int nVex= scanner.nextInt();
		int nEdge = scanner.nextInt();
		
		int graph[][]=new int [nVex][nVex];
		
		/**初始化图	 */
		for(int i=0; i<nVex; i++){
			for(int j=0; j<nVex; j++){
				graph[i][j] = MAX_INT;
			}
		}
		
		for(int k=0; k<nEdge; k++){
//			chx = scanner.next().charAt(0);
//			chy = scanner.next().charAt(0);
//			cost = scanner.nextInt();
//			int i = chx-'A'+1;
//			int j = chy-'A'+1;
			
			int i = scanner.nextInt()-1;
			int j = scanner.nextInt()-1;
			int cost = scanner.nextInt();
			if(cost < graph[i][j])
				graph[i][j]=graph[j][i] = cost;
		}
		
		prim(graph,nVex);
	}
}
