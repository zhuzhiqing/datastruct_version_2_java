package com.jason.algrithm.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DisktraPath {
		class ENode{
			int iVexs;		//邻接顶点的序号
			int weight;		//边的权重
		}
		
		class VNode{
			int iVex;		//顶点序号
			int disktra = Integer.MAX_VALUE;	
			boolean isVisited = false;
			List<ENode>	edgesNodes = new ArrayList<ENode>();
		}
		
		List<VNode> vexs = new ArrayList<VNode>();
		
		public void init(){
			Scanner scanner = new Scanner(System.in);
			int nVexs = scanner.nextInt();
			int nEdges = scanner.nextInt();
			int startPos = scanner.nextInt();
			int endPos = scanner.nextInt();
			
			//初始化顶点
			for(int i=0; i<nVexs; i++){
				VNode vex = new VNode();
				vex.iVex = i;
				vexs.add(vex);
			}
			
			//初始化边
			for(int j=0; j<nEdges; j++){
				int pos1 = scanner.nextInt();
				int pos2 = scanner.nextInt();
				int weight = scanner.nextInt();
				ENode edgeNode = new ENode ();
				edgeNode.iVexs = pos2;
				edgeNode.weight = weight;
				vexs.get(pos1).edgesNodes.add(edgeNode);
			}
			
			
			
		}
		
		public void getDisktraPath(int start){
			vexs.get(start).isVisited = true;
			vexs.get(start).disktra = 0;
			
			List<Integer> S = new ArrayList<Integer>();
			List<Integer> U = new ArrayList<Integer>();
			
			
			for(int i=0; i<vexs.get(start).edgesNodes.size(); i++){		//和源点相邻的点
				vexs.get(vexs.get(start).edgesNodes.get(i).iVexs).disktra = getDistance(start, vexs.get(start).edgesNodes.get(i).iVexs);
			}
			
			for(int i=0; i<vexs.size(); i++){
				int min = Integer.MAX_VALUE;
				int minIndex = 0;
				
				for(int j=0; j<vexs.size(); j++){		//遍历节点以找到dist最小的节点
					if(!vexs.get(j).isVisited)	{		//节点没有被访问过
						if(min> vexs.get(j).disktra){
							min = vexs.get(j).disktra;
							minIndex = j;
						}
					}
				}
				
//				VNode minNode = vexs.get(minIndex);
//				minNode.isVisited = true;		//更新一个点，变为已知的点
//				minNode.disktra = getDistance(pos1, pos2)
//				
//				//更新其余点
//				for(int k=0; k<minNode.edgesNodes.size(); k++){
//					int distance = getDistance(minIndex,minNode.edgesNodes.get(k).iVexs);
//					if(distance > )
//				}
//				
				
			}
		}
		
		private int getDistance(int pos1, int pos2){
			List<ENode> edgeNodes = vexs.get(pos1).edgesNodes;
			for(int i=0; i< edgeNodes.size(); i++){
				if(edgeNodes.get(i).iVexs == pos2){
					return edgeNodes.get(i).weight;
				}	
			}
			
			return Integer.MAX_VALUE;
		}
}
