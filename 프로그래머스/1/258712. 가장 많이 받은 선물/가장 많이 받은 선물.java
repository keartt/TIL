import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        
        // name to index
        Map<String, Integer> index = new HashMap<>();
        for(int i=0; i < friends.length; i++)
            index.put(friends[i], i);
        
        int [] giftPoint = new int[friends.length];
        int [][] record = new int[friends.length][friends.length];
        
        for(String str : gifts){
            // make `gifts` people name to index
            String [] names = str.split(" ");
            int giver = index.get(names[0]);
            int receiver = index.get(names[1]);
            
            giftPoint[giver]++;
            giftPoint[receiver]--;
            record[giver][receiver]++;
        }
        
        for(int i=0; i < friends.length; i++){
            int count = 0;
            for(int j=0; j < friends.length; j++){
                if(i == j) continue; // self skip
                // case 1. more given
                if(record[i][j] > record[j][i]){
                    count++;
                // case 2. more gift point
                }else if(record[i][j] == record[j][i] && giftPoint[i] > giftPoint[j]){
                    count++;
                }
            }
            answer = Math.max(answer, count);
        }
        
        return answer;
    }
}