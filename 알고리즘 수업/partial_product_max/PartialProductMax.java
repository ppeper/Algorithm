package partial_product_max;

import java.util.Arrays;

// 최대곱 부분배열을 구하는문제
// 음수, 0, 양수의 가능성이있다.
// 음수를 저장해두는 배열(Q)와 양수를 저장해두는 배열(P)를 설정
public class PartialProductMax {	
	public int PPM(int arr[]) {
		int length = arr.length;
		//저장해 두는 배열
		int P[] = new int[length], Q[] = new int[length];
		for(int i=0;i<arr.length;i++) {
			if(i==0) {
				//P는 가장 큰수를 저장하면서 나아간다.
				P[i] = Math.max(1, arr[0]);
				//Q는 가장 작은수를 저장하면서 나아간다 -> 나중에 읍수가 나와 곱할때 가장커짐
				Q[i] = Math.min(1, arr[0]);
			}
			else {
				int temp1 = Math.max(1, P[i-1]*arr[i]);
				P[i] = Math.max(temp1, Q[i-1]*arr[i]);
				int temp2 = Math.min(1, Q[i-1]*arr[i]);
				Q[i] = Math.min(temp2, P[i-1]*arr[i]);
			}
		}
		Arrays.sort(P);
		//최대값 리턴
		return P[length-1];
	}
}
