package algorithm;


// �������� �ִ밡 �Ǵ� index a,b�� ã�Ƽ� ������ִ� �˰���
public class SubSumFindMax {
	public int SubSumMax(int arr[], int a, int b) {
		
		if(a==b) return arr[a];
		int left = 0,right = 0,temp = 0;
		int mid = (a+b)/2;
		
		//mid���� �������� �������� �ִ�(mid����)
		for(int i=mid;i<=b;i++) {
			temp += arr[i];
			right = Math.max(temp, right);
		}
		temp=0; //�ʱ�ȭ
		//mid���� ������ �������� �ִ�(mid���� x)
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
		//mid���� �������� �������� �ִ�(mid����)
		for(int i=mid;i<=b;i++) {
			temp += arr[i];
			if(Math.max(temp, right) == temp) {
				from=i;
				right = temp;
			}
		}
		temp=0; //�ʱ�ȭ
		//mid���� ������ �������� �ִ�(mid���� x)
		for(int i=mid-1;i>=a;i--) {
			temp += arr[i];
			if(Math.max(temp, left) == temp) {
				to = i;
				left = temp;
			}
		}
		System.out.println("---�������� �ִ밡�Ǵ� �ε��� ����---");
		System.out.println("a = "+to+", b = "+from);
		return Math.max(left+right, value);
	}
}
