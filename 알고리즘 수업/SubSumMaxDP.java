package algorithm;

public class SubSumMaxDP {
	public int SubSumMax(int [] arr) {
		//초기화
		int max = 0;
		int SubSum = 0;
		
		for(int i=0;i<arr.length;i++) {
			//구간합이 음수면 다음값부터가 최대가 될것이다.
			if(SubSum < 0)
				
				SubSum = arr[i];
			//아닌경우는 전의 구간합에서 다음배열값을 더해준다.
			else
				SubSum += arr[i];
			//전의 max값과 지금현재의 값중 큰값을 구간합의 최대
			max = Math.max(SubSum, max);
		}
		return max;
	}
	public void SubSumMaxIndex(int [] arr) {
		//초기화
		int max = 0;
		int SubSum = 0;
		int begin = 0;
		int end  = 0;
		
		for(int i=0;i<arr.length;i++) {
			//구간합이 음수면 다음값부터가 최대가 될것이다.
			if(SubSum < 0) {
				SubSum = arr[i];
				//구간 시작점 끝점 다시 설정
				begin = i;
				end = i;
			}
			//아닌경우는 전의 구간합에서 다음배열값을 더해준다.
			else
				SubSum += arr[i];
			//전의 max값과 지금현재의 값중 큰값을 구간합의 최대
			max = Math.max(SubSum, max);
			
			//만약 구간합의 최대가 추가된값이면
			if(max == SubSum)
				end = i;
		}
		System.out.println("구간: " + begin + "부터 구간: " + end);
	}
}
