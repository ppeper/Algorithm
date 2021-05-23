package algorithm;

import java.util.Scanner;

public class CountMaxCheeze {
	Scanner sc = new Scanner(System.in);
	int [][] count;
	//�迭 ���� �� ġ�� ��ġ �ʱ�ȭ
		
	public int countCheeze() {
		
		int size = sc.nextInt();
		int cheeze = sc.nextInt();
		count = new int [size][size];
		for(int i=0;i<cheeze;i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			//ġ� �ִ���ġ Ȯ��
			count[x-1][y-1] = 1;
		}
		if(count[0][0] == 1) count[0][0] = 1;
		else count[0][0] = 0;
		
		for(int i=1;i<size;i++) {
			if(count[i][0] == 1)
				count[i][0] = count[i-1][0] + 1;
			else
				count[i][0] = count[i-1][0];
		}
		for(int j=1;j<size;j++) {
			if(count[0][j] == 1)
				count[0][j] = count[0][j-1] + 1;
			else
				count[0][j] = count[0][j-1];
		}
		
		for(int i=1;i<size;i++) {
			for(int j=1;j<size;j++) {
				if(count[i][j] == 1)
					count[i][j] = Math.max(count[i-1][j], count[i][j-1]) + 1;
				else
					count[i][j] = Math.max(count[i-1][j], count[i][j-1]);
			}
		}
		return count[size-1][size-1];
	}
}
