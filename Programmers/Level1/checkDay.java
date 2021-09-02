// 2016년 1월 1일은 금요일입니다. 
// 2016년 a월 b일은 무슨 요일일까요? 
// 두 수 a ,b를 입력받아 2016년 a월 b일이 무슨 요일인지 리턴하는 함수, solution을 완성하세요. 
// 요일의 이름은 일요일부터 토요일까지 각각 SUN,MON,TUE,WED,THU,FRI,SAT

class checkDay {
    public String solution(int a, int b) {
        String [] week = {"FRI","SAT","SUN","MON","TUE","WED","THU"};
        int [] month = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int day = 0;
        if (a == 1) {
            day += b - 1;
            return week[day % 7];
        } else {
            for (int i = 0; i < a-1; i++) {
                day += month[i];
            }
            day += b-1;
            return week[day % 7];
        }
    }
}