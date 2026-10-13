class Solution {
    // TC -> O(nlogn)
    // SC -> O(n)
    public int minGroups(int[][] intervals) {
        
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int[] i : intervals) {
            int start = i[0];
            int end = i[1];
            
            if(!pq.isEmpty() && pq.peek() < start) {
                pq.poll();
            }

            pq.offer(end);
        }

        return pq.size();
    }
}