package com.jason.algrithm.other;
//回溯思路求解全排列
//http://blog.csdn.net/jarvischu/article/details/16067319
public class TreaceBack_Package {
	
	void swap(int []array,int pos1,int pos2){
		if(array[pos1]!=array[pos2]){
			array[pos1] ^=array[pos2];
			array[pos2] ^=array[pos1];
			array[pos1] ^=array[pos2];
		}
	}
	
	public void backtracPerm(int []array,int length,int pos){
		if(pos>length-1){
			//形成一个排列
            for(int i=0;i<length;i++){  
                System.out.print(array[i]+" ");  
            }  
            System.out.println(); 
			return ;
		}
		else{
			for(int i=pos; i<length;i++){
				swap(array,i,pos);
				backtracPerm(array, length, pos+1);
				swap(array,i,pos);
			}
		}
	}
	
	public static void main(String []args){
		int []array={1,2,3,4};
		TreaceBack_Package instance = new TreaceBack_Package();
		instance.backtracPerm(array,array.length,0);
	}
}
