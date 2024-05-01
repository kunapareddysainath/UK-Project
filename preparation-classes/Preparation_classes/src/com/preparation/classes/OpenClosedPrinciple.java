package com.preparation.classes;

interface ValueComparator {
	public int compare(int value1, int value2);
}

class AscendingComparation implements ValueComparator {

	@Override
	public int compare(int value1, int value2) {
		return value1 - value2;
	}
}

class DescendingComparation implements ValueComparator {

	@Override
	public int compare(int value1, int value2) {
		return value2 - value1;
	}
}

class UtilityOperations{
	
	public static void sortNumbers(int list[],ValueComparator valueComparator) {
		
		for(int i=0;i<list.length;i++) {
			for(int j=0;j<list.length;j++) {
				if(valueComparator.compare(list[i],list[j])<0) {
					int temp = list[i];
					list[i]=list[j];
					list[j]=temp;
				}
			}	
		}
		
	}
}

public class OpenClosedPrinciple {

	public static void main(String[] args) {
		
		int numbers[]= {18,2,87,23};
		
		UtilityOperations.sortNumbers(numbers, new DescendingComparation());
		
		for (int i : numbers) {
			System.out.println(i);
		}
		
	}

}
