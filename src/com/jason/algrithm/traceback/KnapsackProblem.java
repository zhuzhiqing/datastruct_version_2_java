package com.jason.algrithm.traceback;

import java.util.HashMap;

/**
 * 0-1背包问题
 * 回溯法解
 * 
 * 1. 0-1背包问题
        问题：给定n种物品和一背包。物品i的重量是wi，其价值为pi，背包的容量为C。问应如何选择装入背包的物品，使得装入背包中物品的总价值最大?
 * @author ToZhu
 *
 */
public class KnapsackProblem {
	int BestValue = 0; 	//最优值；当前的最大价值，初始化为0 
	int []BestX; 		//最优解；BestX[i]=1代表物品i放入背包，0代表不放入
	int []x;
	
	int N;				//物品的数量
	int C;				//背包的容量
	
	int curWeight =0;	//当前背中物品体积
	int curVaule = 0;	//当前背包中物品的价值
	
	void backtrace(int []weights,int[]vaules, int t){
		//叶子节点，输出结果
		if(t>N-1){
			//如果找到了一个更优的解  
			if(curVaule>BestValue){
				//保存更优的值和解 
				BestValue = curVaule;
				for(int i=0; i<N; i++)
					BestX[i] = x[i];
			}
		}
		else{
			//遍历当前子节点：0不放入背包，1放入背包
			for(int i=0; i<=1; i++){
				x[t]=i;
				
				if(i==0){	//不放入背包
					backtrace(weights, vaules, t+1);
				}
				else{		//放入背包
					if(curWeight+weights[t]<=C){
						curWeight += weights[t];
						curVaule += vaules[t];
						backtrace(weights, vaules, t+1);
						curWeight -= weights[t];
						curVaule -= vaules[t];
					}
					
				}
			}
		}
	}
	
	public void print(){
		System.out.println("依次放入以下物品");
		for(int i=0; i<N; i++){
			if(BestX[i]!=0)
				System.out.printf("%d\t",i);
		}
	}
	
	
	
	public int getBestValue() {
		return BestValue;
	}



	public void setBestValue(int bestValue) {
		BestValue = bestValue;
	}



	public int[] getBestX() {
		return BestX;
	}



	public void setBestX(int[] bestX) {
		BestX = bestX;
	}



	void init(int N,int C){
		this.N = N;
		this.C = C;
		x = new int[N];
		BestX = new int[N];
	}
	
	static public void main(String []args){
		int N = 3;	//物品的数量
		int C = 16;	//背包的容量
		
		int []weight = {10,8,5};	//每个物品的重量
		int []value = {5,4,1};		//每个物品的价值
		
		KnapsackProblem knapsackProblem = new KnapsackProblem();
		knapsackProblem.init(N, C);
		knapsackProblem.backtrace(weight, value, 0);
		System.out.println(knapsackProblem.getBestValue());
		//输出结果
		knapsackProblem.print();
	}
}
