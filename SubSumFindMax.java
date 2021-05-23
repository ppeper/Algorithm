package algorithm;


// 구간합이 최대가 되는 index a,b를 찾아서 출력해주는 알고리즘
public class SubSumFindMax {
	public int SubSumMax(int arr[], int a, int b) {
		
		if(a==b) return arr[a];
		int left = 0,right = 0,temp = 0;
		int mid = (a+b)/2;
		
		//mid기준 오른쪽의 구간합의 최대(mid포함)
		for(int i=mid;i<=b;i++) {
			temp += arr[i];
			right = Math.max(temp, right);
		}
		temp=0; //초기화
		//mid기준 왼쪽의 구간합의 최대(mid포함 x)
		for(int i=mid-1;i>=a;i--) {
			temp += arr[i];
			left = Math.max(temp, left);
		}
		int value = Math.max(SubSumMax(arr, a, mid), SubSumMax(arr,mid+1,b));
		
		return Math.max(left+right, value);
	}
	
	public int SubSumMaxIndex(int arr[],int a,int b) {
		if(a==b) return arr[a];
		int from = 0, to = 0;
		int left = 0,right = 0,temp = 0;
		int mid = (a+b)/2;
		
		int value = Math.max(SubSumMax(arr, a, mid), SubSumMax(arr,mid+1,b));
		//mid기준 오른쪽의 구간합의 최대(mid포함)
		for(int i=mid;i<=b;i++) {
			temp += arr[i];
			if(Math.max(temp, right) == temp) {
				from=i;
				right = temp;
			}
		}
		temp=0; //초기화
		//mid기준 왼쪽의 구간합의 최대(mid포함 x)
		for(int i=mid-1;i>=a;i--) {
			temp += arr[i];
			if(Math.max(temp, left) == temp) {
				to = i;
				left = temp;
			}
		}
		System.out.println("---구간합이 최대가되는 인덱스 범위---");
		System.out.println("a = "+to+", b = "+from);
		return Math.max(left+right, value);
	}
}
