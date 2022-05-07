package com.DSA.question1;

import java.util.PriorityQueue;
import java.util.Scanner;

public class SkyscraperConstruction {
	
	//Create method for order of construction
	
	public void orderOfConstruction(int totalNoFloors,int totalFloorSize[]) {
		System.out.println("The order of Construction is as follows ");
		
		PriorityQueue<Integer>pq = new PriorityQueue<>(java.util.Collections.reverseOrder());
		
		int[] array = new int[totalNoFloors];
		int temp = totalNoFloors;
		
		for(int i =0; i<totalNoFloors;i++) {
			
			System.out.println("Day: "+(i+1));
			array[i] = totalFloorSize[i];
			pq.add(array[i]);
			
			while(!pq.isEmpty() && pq.peek() == temp) {
				System.out.println(pq.poll()+" ");
				temp--;
			}
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter total Number of floors in the building: ");
		int totalNoFloors = sc.nextInt(); //3
		
		int[] totalFloorSize = new int[totalNoFloors]; 
		
		for(int i=1; i<= totalNoFloors;i++) {
			System.out.println("Enter the Floor size given on Day : "+i); 
			totalFloorSize[i-1] = sc.nextInt();  
		}
		
		SkyscraperConstruction construction = new SkyscraperConstruction();
		construction.orderOfConstruction(totalNoFloors,totalFloorSize);

	}

}
