package com.jason.algrithm.other;

public class Perm {

	static void swap(int []array,int pos1,int pos2){
		if(array[pos1]!=array[pos2]){
			array[pos1] ^=array[pos2];
			array[pos2] ^=array[pos1];
			array[pos1] ^=array[pos2];
		}
	}
	
	static void perm(int []array, int begin, int end){
		int i,j;
		if(begin==end){
			//一个排序形成
            for(i=0;i<=end;i++){  
                System.out.print(array[i]+" ");  
            }  
            System.out.println(); 
            return;
		}
		else{
			for(j=begin;j<=end;j++){
				swap(array,begin,j);
				perm(array,begin+1,end);
				swap(array,begin,j);
			}
		}
	}
	
	public static void main(String []args){
		int [] array=new int []{1,2,3};
		perm(array,0,array.length-1);
	}
}
