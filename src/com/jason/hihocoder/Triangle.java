package com.jason.hihocoder;

import java.util.ArrayList;
import java.util.List;

public class Triangle {
   static public int minimumTotal(List<List<Integer>> triangle) {
        int [][]sums = new int[triangle.size()][triangle.size()];
        
        int min = Integer.MAX_VALUE/10;
        for(int i=0; i<triangle.size(); i++){
        	//sums[]
        	for(int j=0; j<triangle.get(i).size(); ++j){
	        	if(i==0) sums[0][0] = triangle.get(0).get(0);
	        	else if(i==1){
	        		sums[i][j] = triangle.get(0).get(0)+triangle.get(i).get(j);
	        	}
	        	else {
	        		if(j==0) sums[i][j] = sums[i-1][j]+triangle.get(i).get(j);	
	        		else if(j==triangle.get(i).size()-1){
	        			sums[i][j] = sums[i-1][j-1]+triangle.get(i).get(j);
	        		}else
	        			sums[i][j] = Math.min(sums[i-1][j-1], sums[i-1][j])+triangle.get(i).get(j);
	        	}
        	}
        }
        
        for(int i=0; i<triangle.get(triangle.size()-1).size(); ++i){
        	if(sums[triangle.size()-1][i] < min)
        		min = sums[triangle.size()-1][i];
        }
        System.out.println(min);
       return min;
    }
    
    public static void main(String []args){
    	List<Integer> item1 = new ArrayList<>();
    	List<Integer> item2 = new ArrayList<>();
    	item1.add(1);
    	item2.add(2);
    	item2.add(3);
    	
    	List<List<Integer>> items = new ArrayList<List<Integer>>(); 
    	items.add(item1);
    	items.add(item2);
    	minimumTotal(items);
    }
}
