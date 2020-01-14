package medium;

import java.util.List;
import java.util.Stack;

public class Solution636 {
    public int[] exclusiveTime(int n, List<String> logs) {
        //store id
        Stack<Integer> stack = new Stack<>();
        int prev = 0;
        int[] res = new int[n];
        for(String log : logs){
            String[] arr = log.split(":");
            int id = Integer.parseInt(arr[0]);
            int cur = Integer.parseInt(arr[2]);
            String event = arr[1];
            if(event.equals("start")){
                if(!stack.isEmpty()){
                    res[stack.peek()] += cur - prev;

                }
                stack.push(id);
                prev = cur;

            }else{
                if(!stack.isEmpty()){
                    res[stack.pop()] += cur - prev + 1;
                    prev = cur + 1;
                }
            }
        }

        return res;
    }
}

/*
"{function_id}:{"start" | "end"}:{timestamp}"
logs = ["0:start:0",
        "1:start:2",
        "1:end:5",
        "0:end:6"]
Output: [3, 4]
*/