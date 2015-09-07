package com.jason.algrithm.traceback;

public class EightQuenen {
	
	int [][]Board;
	int count;
	int N;
	
	//检查本次放下的位置是否合理
	boolean Feasible(int row,int col){
		
		if(row>N || col>N || row<0 ||col<0)
			return false;
		
		//该位置已经有皇后
		if(Board[row][col]==1)
			return false;
		
		//行列是否冲突
		for(int i=0; i<N; i++){
			if(Board[row][i]!=0 || Board[i][col]!=0)
				return false;
		}
		
		//斜线是否冲突
		 
	    for(int i=1;i<N;++i)  
	    {  
	/* i表示从当前点(row,col)向四个斜方向扩展的长度 
	  
	左上角 \  / 右上角   i=2 
	        \/           i=1 
	        /\           i=1 
	左下角 /  \ 右下角   i=2 
	*/  
	        //左上角  
	        if((row-i)>=0 && (col-i)>=0)    //位置合法  
	        {  
	            if(Board[row-i][col-i] != 0)//此处已有皇后，冲突  
	                return false;  
	        }  
	   
	        //左下角  
	        if((row+i)<N && (col-i)>=0)  
	        {  
	            if(Board[row+i][col-i] != 0)  
	                return false;  
	        }  
	   
	        //右上角  
	        if((row-i)>=0 && (col+i)<N)  
	        {  
	            if(Board[row-i][col+i] != 0)  
	                return false;  
	        }  
	   
	        //右下角  
	        if((row+i)<N && (col+i)<N)  
	        {  
	            if(Board[row+i][col+i] != 0)  
	                return false;  
	        }  
	    } 
	    
	    return true;
	}
	
	//摆放第几个皇后
	public void queue(int t){
		
		//形成一种答案
		if(t>N-1){
			count++;
			System.out.printf("第%d种方法\n",count);
//			System.out.printf("第%d种方法",count);
//			print();
		}
		else{
			for(int row=0; row<N;row++){
				for(int col=0;col<N;col++){
					
					//位置可以摆放皇后，不冲突 
					if(Feasible(row, col)){
						Board[row][col] = 1;		//摆放皇后t 
						queue(t+1);				//递归摆放皇后t+1 
						Board[row][col] = 0;		//恢复
					}
				}
			}
				
		}
	}
	
	public void solution(int n){
		if(n<1)
			return ;
		
		//新建棋盘
		Board = new int[n][n];
		count = 0;
		this.N = n;
		queue(0);
	}
	
	
	
	public int getCount() {
		return count;
	}

	public void print(){
		for(int i=0;i<N; i++){
			System.out.println();
			for(int j=0;j<N;j++){
				if(Board[i][j]==0)
					System.out.printf("-\t");
				else
					System.out.printf("*\t");
			}
		}
	}
	
	public static void main(String []args){
		int N = 6;	//棋盘大小
		EightQuenen eQuenen = new EightQuenen();
		eQuenen.solution(N);
		System.out.println(eQuenen.getCount());
	}
}
