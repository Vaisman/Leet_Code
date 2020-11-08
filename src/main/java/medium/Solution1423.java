package medium;

public class Solution1423 {
    // We have to take exactly k elements, so in the end cardPoints.length - k elements remain.
    // We minimize the sum of the remaining elements to maximize the sum of the elements we take. We find the smallest sum subarray of length cardPoints.length - k.
    // O(cardPoints.length) time because we do a single pass through the given cardPoints array.
    // O(1) space.
    public int maxScore(int[] cardPoints, int k) {
        int totalSum = 0, minWindowSum = 0, currWindowSum = 0, windowSize = cardPoints.length - k;
        for (int i = 0; i < windowSize; ++i) currWindowSum += cardPoints[i];   // create sum for initial window
        minWindowSum = currWindowSum;
        totalSum += currWindowSum;
        for (int i = windowSize; i < cardPoints.length; ++i) {
            totalSum += cardPoints[i];
            currWindowSum += cardPoints[i];                   // move right pointer of the sliding window forward by one
            currWindowSum -= cardPoints[i - windowSize];      // move left pointer of the sliding window forward by one
            minWindowSum = Math.min(minWindowSum, currWindowSum);
        }
        return totalSum - minWindowSum;
    }
}

/*
//call this function with (A,B,index of the current element in B, index of the left element in A , index of the right element in B)
int getMaxSum(vector<int>& A, vector<int>& K, int x, int left,int right){
    if(x == K.size()){
        return 0;
    }
    int leftSum = A[left]*K[x] + getMaxSum(A,K,x+1,left+1,right);
    int rightSum = A[right]*K[x] + getMaxSum(A,K,x+1,left,right-1);
    int curr = max(leftSum,rightSum);
    return curr;
}

int maximizeSum(int[] A, int[] B) {
        int maxsum = Integer.MIN_VALUE;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, A.length-1, 0, 0}); // (A start, A end, B Start, val)
        while(!queue.isEmpty()) {
            int[] info = queue.poll();
            if(info[2] == B.length) {
                maxsum = Math.max(maxsum, info[3]);
            } else {
                queue.offer(new int[]{info[0]+1, info[1],
                    info[2]+1, info[3] +  (A[info[0]] * B[info[2]])});
                queue.offer(new int[]{info[0], info[1]-1,
                    info[2]+1, info[3] +  (A[info[1]] * B[info[2]])});
            }
        }
        return maxsum;
    }
 */