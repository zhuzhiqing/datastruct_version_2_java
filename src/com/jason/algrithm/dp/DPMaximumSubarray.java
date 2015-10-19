package com.jason.algrithm.dp;

public class DPMaximumSubarray {
	
	//分治解法
    public int maxSubArray(int[] nums,int start,int end) {
    	if(start == end){
    		return nums[0];
    	}
    	int mid = end>>1;
    	
    	//分
    	//左边0...mid-1,  右边mid...n-1
    	int answer = Math.max(maxSubArray(nums,start,mid), maxSubArray(nums,mid+1,end));
    	
    	//合
    	int now = nums[mid], may = now;
    	for(int i=mid-1; i>=0; --i)
    		may = Math.max(may, now += nums[i]);
    	
    	now = may;
    	for(int i=mid; i<nums.length; ++i)
    		may = Math.max(may, now+= nums[i]);
    	
    	return Math.max(answer, may);
    }
    
    public int maxSubArray(int [] nums){
    	return maxSubArray(nums,0,nums.length-1);
    }
    
    
    public int maxSubArrayDP(int[] nums) {
    	int []sums = new int[nums.length];
    	int rst = nums[0];
    	
    	for(int i=0; i<nums.length; i++){
    		if(i==0) sums[0] = nums[0];
    		else sums[i] = Math.max(sums[i-1]+nums[i], nums[i]);
    		
    		if(sums[i]>rst) rst = sums[i];
    	}
    	
    	return rst;
    }
}
