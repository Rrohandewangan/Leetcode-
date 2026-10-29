class Pair {
    String first;
    int second;
    Pair(String first, int second) {
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord, 1));
        HashSet<String> set = new HashSet<>();
        int len = wordList.size();
        for(int i=0; i<len; i++) {
            set.add(wordList.get(i));
        }
        set.remove(beginWord);
        while(!q.isEmpty()) {
            String word = q.peek().first;
            int steps = q.peek().second;
            q.remove();
            if(word.equals(endWord) == true) return steps;
            // word = hat
            for(int i=0; i<word.length(); i++) {
                for(char ch = 'a'; ch <= 'z'; ch++) {
                    char[] replacedCharArray = word.toCharArray();
                    replacedCharArray[i] = ch;
                    String replacedWord = new String(replacedCharArray);
                    // it exists in the set
                    if(set.contains(replacedWord) == true) {
                        set.remove(replacedWord);
                        q.add(new Pair(replacedWord, steps + 1));
                    }
                }
            }
        }
        return 0;
    }
}