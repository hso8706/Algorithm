class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        for(int i=0; i<num_list.length; i++){
            int portion = num_list[i];
            while(portion > 1){
                if(portion%2 == 0) {//짝수인 경우
                    portion /= 2;
                }
                else { //홀수인 경우
                    portion = (portion-1)/2;
                }
                answer++;
            }
        }
        return answer;
    }
}