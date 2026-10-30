class Solution {
    // TC -> O()
    // SC -> O()
    String b;
    HashMap<String, Integer> map;
    List<List<String>> ans;
    private void dfs(String word, List<String> seq) {
        if(word.equals(b)) {
            List<String> dup = new ArrayList<>(seq);
            Collections.reverse(dup);
            ans.add(dup);
            return;
        }
        int steps = map.get(word);
        int size = word.length();
        for(int i=0; i<size; i++) {
            for(char ch = 'a'; ch <= 'z'; ch++) {
                char[] replaceCharArray = word.toCharArray();
                replaceCharArray[i] = ch;
                String replaceWord = new String(replaceCharArray);
                if(map.containsKey(replaceWord)
                && map.get(replaceWord) + 1 == steps) {
                    seq.add(replaceWord);
                    dfs(replaceWord, seq);
                    seq.remove(seq.size() - 1);
                }
            }
        }
    }
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>();
        int len = wordList.size();
        for(int i=0; i<len; i++) set.add(wordList.get(i));
        Queue<String> q = new LinkedList<>();
        b = beginWord;
        q.add(beginWord);
        map = new HashMap<>();
        map.put(beginWord, 1);
        int size = beginWord.length();
        set.remove(beginWord);
        while(!q.isEmpty()) {
            String word = q.peek();
            int steps = map.get(word);
            q.remove();
            if(word.equals(endWord) == true) break;
            for(int i=0; i<size; i++) {
                for(char ch = 'a'; ch <= 'z'; ch++) {
                    char[] replacedCharArray = word.toCharArray();
                    replacedCharArray[i] = ch;
                    String replacedWord = new String(replacedCharArray);
                    // it exists in the set
                    if(set.contains(replacedWord) == true) {
                        q.add(replacedWord);
                        set.remove(replacedWord);
                        map.put(replacedWord, steps + 1);
                    }
                }
            }
        }
        ans = new ArrayList<>();
        if(map.containsKey(endWord) == true) {
            List<String> seq = new ArrayList<>();
            seq.add(endWord);
            dfs(endWord, seq);
        }
        return ans;
    }
}