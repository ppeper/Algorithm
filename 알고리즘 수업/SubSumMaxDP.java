package algorithm;

public class SubSumMaxDP {
	public int SubSumMax(int [] arr) {
		//�ʱ�ȭ
		int max = 0;
		int SubSum = 0;
		
		for(int i=0;i<arr.length;i++) {
			//�������� ������ ���������Ͱ� �ִ밡 �ɰ��̴�.
			if(SubSum < 0)
				
				SubSum = arr[i];
			//�ƴѰ��� ���� �����տ��� �����迭���� �����ش�.
			else
				SubSum += arr[i];
			//���� max���� ���������� ���� ū���� �������� �ִ�
			max = Math.max(SubSum, max);
		}
		return max;
	}
	public void SubSumMaxIndex(int [] arr) {
		//�ʱ�ȭ
		int max = 0;
		int SubSum = 0;
		int begin = 0;
		int end  = 0;
		
		for(int i=0;i<arr.length;i++) {
			//�������� ������ ���������Ͱ� �ִ밡 �ɰ��̴�.
			if(SubSum < 0) {
				SubSum = arr[i];
				//���� ������ ���� �ٽ� ����
				begin = i;
				end = i;
			}
			//�ƴѰ��� ���� �����տ��� �����迭���� �����ش�.
			else
				SubSum += arr[i];
			//���� max���� ���������� ���� ū���� �������� �ִ�
			max = Math.max(SubSum, max);
			
			//���� �������� �ִ밡 �߰��Ȱ��̸�
			if(max == SubSum)
				end = i;
		}
		System.out.println("����: " + begin + "���� ����: " + end);
	}
}
