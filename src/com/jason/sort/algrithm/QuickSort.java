package com.jason.sort.algrithm;

/*
 * 
 快速排序算法Java实现 
网上关于快速排序的算法原理和算法实现都比较多，不过java是实现并不多，而且部分实现很难理解，
和思路有点不搭调。所以整理了这篇文章。如果有不妥之处还请建议。首先先复习一些基础。

1、算法概念。
快速排序（Quicksort）是对冒泡排序的一种改进。由C. A. R. Hoare在1962年提出。

2、算法思想。

通过一趟排序将要排序的数据分割成独立的两部分，其中一部分的所有数据都比另外一部分的所有数据都要小，
然后再按此方法对这两部分数据分别进行快速排序，整个排序过程可以递归进行，以此达到整个数据变成有序序列。

3、实现思路。

①以第一个关键字 K 1 为控制字，将 [K 1 ,K 2 ,…,K n ] 分成两个子区，使左区所有关键字小于等于 K 1 ，
   右区所有关键字大于等于 K 1 ，最后控制字居两个子区中间的适当位置。在子区内数据尚处于无序状态。 
②把左区作为一个整体，用①的步骤进行处理，右区进行相同的处理。（即递归）
③重复第①、②步，直到左区处理完毕。
 */

public class QuickSort {
	
	//快速排序
	//http://blog.csdn.net/morewindows/article/details/6684558
	void quick_sort_version_1(int s[], int l, int r)
	{
	  if (l < r)
	  {
			//Swap(s[l], s[(l + r) / 2]); //将中间的这个数和第一个数交换 参见注1
	      int i = l, j = r, x = s[l];
	      while (i < j)
	      {
	          while(i < j && s[j] >= x) // 从右向左找第一个小于x的数
					j--;  
	          if(i < j) 
					s[i++] = s[j];
				
	          while(i < j && s[i] < x) // 从左向右找第一个大于等于x的数
					i++;  
	          if(i < j) 
					s[j--] = s[i];
	      }
	      s[i] = x;
	      quick_sort_version_1(s, l, i - 1); // 递归调用 
	      quick_sort_version_1(s, i + 1, r);
	  }
	}
	
	public void quicksort_version_2(int n[], int left, int right){
		int dp ;
		if(left<right){
			dp = partition(n, left, right);
			quicksort_version_2(n,left,dp-1);
			quicksort_version_2(n,dp+1,right);
		}
	}
	
	private int partition(int n[], int left,int right){
		int pivot = n[left];
		while(left<right){
			while(left<right && n[right]>=pivot)
				right--;
			
			if(left<right)
				n[left++]=n[right];
			
			while(left<right && n[left]<=pivot)
				left++;
			
			if(left<right)
				n[right--]=n[left];
		}
		n[left] = pivot;
		return left;
	}
	
	

}

