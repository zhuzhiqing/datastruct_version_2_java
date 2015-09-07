package com.jason.algrithm.graph;

import java.util.Scanner;

public class DisktraPathMatrix {
//public class Main {
	int[][] map;
	int[] distance;
	boolean[] visited;
	int nVexs;
	int startPos;
	int endPos;

	private void init() {
		Scanner scanner = new Scanner(System.in);
		nVexs = scanner.nextInt();
		int nEdges = scanner.nextInt();
		startPos = scanner.nextInt() - 1;
		endPos = scanner.nextInt() - 1;

		// 初始化map,distance,visited
		map = new int[nVexs][nVexs];
		distance = new int[nVexs];
		visited = new boolean[nVexs];

		for (int i = 0; i < nVexs; i++) {
			visited[i] = false;

			for (int j = 0; j < nVexs; j++) {
				map[i][j] = Integer.MAX_VALUE/10;
			}
		}

		// 初始化边
		for (int j = 0; j < nEdges; j++) {
			int pos1 = scanner.nextInt() - 1;
			int pos2 = scanner.nextInt() - 1;
			int weight = scanner.nextInt();
			if (map[pos1][pos2] > weight) {
				map[pos1][pos2] = weight;
				map[pos2][pos1] = weight;
			}
		}
		
		scanner.close();

	}

	public int getDisktra() {
		int minVex = startPos;
		for (int i = 0; i < nVexs; i++) {
				distance[i] = map[startPos][i];
		}

		visited[startPos] = true;
		distance[startPos] = 0;

		for (int i = 0; i < nVexs; i++) {
			if (i == startPos)
				break;

			int minDistance = Integer.MAX_VALUE/10;
			; // 找到本轮距离最小点
			for (int j = 0; j < nVexs; j++) {

				if (!visited[j] && minDistance > distance[j]) {
					minDistance = distance[j];
					minVex = j;
				}
			}
			
			if(minDistance == Integer.MAX_VALUE/10)
				break;

			visited[minVex] = true; // 将本轮距离最小点标记一下
			distance[minVex] = minDistance;

			for (int k = 0; k < nVexs; k++) { // 更新U中剩余点的距离
				if (!visited[k] && map[minVex][k] != Integer.MAX_VALUE/10) { // U中的点
					if (distance[k] > minDistance + map[minVex][k]) {
						distance[k] = minDistance + map[minVex][k];
					}
				}
			}

		}

		return distance[endPos];
	}

	public static void main(String[] args) {
		DisktraPathMatrix instance = new DisktraPathMatrix();
	//	Main instance = new Main();
		instance.init();
		System.out.println(instance.getDisktra());
	}
}
