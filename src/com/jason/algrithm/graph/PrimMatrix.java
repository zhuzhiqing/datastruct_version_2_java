package com.jason.algrithm.graph;

import java.util.Scanner;

public class PrimMatrix {
	public static int MAX_INT = Integer.MAX_VALUE/10;
	
	public static void prim(int graph[][], int nVexs){
		
		 /* lowcost[i]记录以i为终点的边的最小权值，当lowcost[i]=0时表示终点i加入生成树
		  	记录的是权值*/
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
			lowcost[i] = graph[0][i];	/* 最短距离初始化为其他节点到1号节点的距离 */
			closeset[i] = 0;			
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
			
			 /* 输出生成树边的信息:起点，终点，权值 */
			//System.out.printf("%c - %c : %d\n", closeset[minIndex] + 'A', minIndex + 'A', minCost);
			
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

/**
 * 
7 11
1 2 7
1 4 5
2 3 8
2 4 9
2 5 7
3 5 5
4 5 15
4 6 6
5 6 8
5 7 9
6 7 11
结果 39
*/