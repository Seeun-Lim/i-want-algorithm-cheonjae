import java.util.*;

class Solution {
    
    public String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();

        List<String> l = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) l.add(String.valueOf(numbers[i]));

        l.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });
        
        if(l.get(0).equals("0")) return "0";

        for (int i = 0; i < l.size(); i++) {
            answer.append(l.get(i));
        }

        return String.valueOf(answer);
    }
}