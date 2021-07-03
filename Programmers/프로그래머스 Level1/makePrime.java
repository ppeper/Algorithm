package algorithm;

//주어진 숫자 중 3개의 수를 더했을 때 소수가 되는 경우의 개수를 구하려고 합니다. 
//숫자들이 들어있는 배열 nums가 매개변수로 주어질 때, 
//nums에 있는 숫자들 중 서로 다른 3개를 골라 더했을 때 소수가 되는 경우의 개수를 return 하도록 solution 함수를 완성해주세요.

public class makePrime {
    public int solution(int[] nums) {
        int answer = 0;
        for(int i=0; i<nums.length-2; i++){
            for(int j=i+1; j<nums.length-1; j++){
                for(int k=j+1; k<nums.length; k++){
                    int result = nums[i] + nums[j] + nums[k];
                    if(checkPrime(result)) answer++;
                }
            }
        }
        return answer;
    }
    
    public boolean checkPrime(int number){
        for(int i=2; i<number;i++){
            if(number % i == 0) return false;
        }
        return true;
    }
}