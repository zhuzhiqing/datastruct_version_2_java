package com.jason.algrithm.sort;

public class InsertSort {

	public void insertSort(int []array, int first, int last){
		int i,j;
		int tmp;
		for(i=first+1; i<=last; i++){
			tmp = array[i];
			 j = i-1;
			//与已排序的数逐一比较，大于temp时，概述向后移
			while((j>=first) && (array[j]>tmp)){
				array[j+1] = array[j];
				j--;
			}
			
			array[j+1] = tmp;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
