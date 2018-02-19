package com.testScripts;

import org.testng.annotations.Test;

public class testSort {
	
	
	@Test(groups={"sort","bubble"})
	
	public void testbubble() {
		
		int [] a = {2,1,0,3,9};
	
		
		for (int i=0;i<a.length;i++) {
			
			for (int j=i;j<a.length;j++) {
				
				if (a[i]>a[j]) {
					
					swap(a,i,j);
					
				}
			
			}
		}
		
			afterSort(a ,"test bubble");
		
	}
	
	@Test(groups={"sort","insert"})
	
	public void testInsert() {
		
		int [] a = {2,1,0,3,9};
		
	
		for (int i=0;i<a.length;i++){
			
			for (int j=i;j>0;j--) {
				 
				if (a[j]>a[j-1]) {
					
					swap(a,j,j-1);
				}
				
			} 
			
		}
	   
		afterSort(a ,"test insert");
	}
	@Test(groups={"sort","Select"})
	
	public void testSelect () {
		
		int [] a = {2,1,0,3,9};
		int index;
		
		for (int i=0;i<a.length-1;i++){
			
			index =i;
			
			for (int j=i+1;j<a.length;j++) {
				
				   if (a[index]>a[j]) 
					   
					   index = j;
			}
			
					swap(a,i,index);
			
		}
	   
				afterSort(a ,"test select");
		
	}
	
public void afterSort(int [] a ,String s) {
		
		for (int i=0;i<a.length;i++) {
			
			System.out.println("after "+s+"..."+a[i]);
			
		}
		
			System.out.println("xxxxxxxxxxx");
		
	}

public void swap (int[] a, int i, int j) {
	
	         int temp = a[i];
	         a[i]=a[j];
	         a[j]= temp;
	      
	}

}
