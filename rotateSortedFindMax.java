package algorithm;

public class rotateSortedFindMax {
	
	public int rotateSortedMax(int arr[],int a, int b,int k, int index) {
		if(a==b) {
			if(arr[a]==k) {
				index = a;
				return index;				
			}
			else return -1;
		}
		int mid = (a+b)/2;
		if(arr[mid] < k)
			if(k <= arr[b])
				return index = rotateSortedMax(arr,mid+1,b,k,index);
			else
				return index = rotateSortedMax(arr,a,mid-1,k,index);
		
		else if(arr[mid] > k)
			return index = rotateSortedMax(arr,a,mid-1,k,index);
		
		else if(arr[mid] == k)
			return index = mid;
		
		return -1;

	}
}
