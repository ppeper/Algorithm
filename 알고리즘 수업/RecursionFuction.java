package algorithm;

public class RecursionFuction {
	public int FindMin(int [] arr, int index,int min) {
		if(min>arr[index])
			min = arr[index];	//�迭�� �ּڰ��� �ٲ���
		if(index==arr.length-1)
			return min;	//�迭�� �ٵ��Ҵٸ� �ּڰ��� ��������
		else 
			return FindMin(arr,index+1,min);//�迭�� �����ִٸ� index�� ������ ����Լ� ȣ��
		
	}
	
	public int AddFunction(int [] arr, int index) {
		int hap=0;
		if(arr.length == index)
			return hap;	//�迭�� �� ���
		else {
			//hap�� �迭�� ù��° ���Һ� �����Ͽ� ���ȣ�����Ͽ� ���������Ҹ� ������ ����
			return hap= arr[index]+AddFunction(arr,index+1);
		}
	}
	
	public void SelectionSort(int [] arr,int startIndex) {
		if(arr.length==1) return;	//�迭�� ũ�Ⱑ 1�̸� �׳� ����
		else {
			if(startIndex==arr.length) //�迭�� ���������Ƽ� ������ �Ϸ���
				return;
			
			//�迭�� ������ �������� ������ �ε����� ������
			int minIndex = findMin(arr,startIndex,arr.length-1);
			if(minIndex!=arr.length) {
				//�����������ҿ� ó����������  �迭�� ���Ҹ� �ٲ��ش�
				int temp = arr[minIndex];
				arr[minIndex] = arr[startIndex];
				arr[startIndex] = temp;
			}
			SelectionSort(arr,startIndex+1);
		}
		
	}
	private int findMin(int [] arr, int start, int end) {
		if(start == end)	//�迭�� ������ Ȯ��
			return start;
		int minIndex = findMin(arr,start+1,end);
		if(arr[minIndex]>arr[start])
			minIndex = start;
		return minIndex;
	}
}