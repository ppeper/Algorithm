package algorithm;

public class RecursionFuction {
	public int FindMin(int [] arr, int index,int min) {
		if(min>arr[index])
			min = arr[index];	//배열의 최솟값을 바꿔줌
		if(index==arr.length-1)
			return min;	//배열을 다돌았다면 최솟값을 리턴해줌
		else 
			return FindMin(arr,index+1,min);//배열이 남아있다면 index값 증가후 재귀함수 호출
		
	}
	
	public int AddFunction(int [] arr, int index) {
		int hap=0;
		if(arr.length == index)
			return hap;	//배열의 합 출력
		else {
			//hap에 배열의 첫번째 원소붜 저장하여 재귀호출을하여 마지막원소면 리턴을 해줌
			return hap= arr[index]+AddFunction(arr,index+1);
		}
	}
	
	public void SelectionSort(int [] arr,int startIndex) {
		if(arr.length==1) return;	//배열의 크기가 1이면 그냥 리턴
		else {
			if(startIndex==arr.length) //배열을 끝까지돌아서 정렬을 완료함
				return;
			
			//배열의 원소중 가장작은 원소의 인덱스를 가져옴
			int minIndex = findMin(arr,startIndex,arr.length-1);
			if(minIndex!=arr.length) {
				//가장작은원소와 처음시작점의  배열의 원소를 바꿔준다
				int temp = arr[minIndex];
				arr[minIndex] = arr[startIndex];
				arr[startIndex] = temp;
			}
			SelectionSort(arr,startIndex+1);
		}
		
	}
	private int findMin(int [] arr, int start, int end) {
		if(start == end)	//배열의 끝까지 확인
			return start;
		int minIndex = findMin(arr,start+1,end);
		if(arr[minIndex]>arr[start])
			minIndex = start;
		return minIndex;
	}
}