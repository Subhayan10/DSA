class Pair {
    String word;
    int seq;

    Pair(String word, int seq) {
        this.word = word;
        this.seq = seq;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) return 0;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord, 1));

        while (!q.isEmpty()) {
            Pair p = q.poll();
            String word = p.word;
            int seq = p.seq;

            if (word.equals(endWord)) return seq;

            for (int i = 0; i < word.length(); i++) {
                char[] arr = word.toCharArray();

                for (char ch = 'a'; ch <= 'z'; ch++) {
                    if (arr[i] == ch) continue;

                    arr[i] = ch;
                    String newWord = new String(arr);

                    if (set.contains(newWord)) {
                        set.remove(newWord);
                        q.add(new Pair(newWord, seq + 1));
                    }
                }
            }
        }
        return 0;
    }
}
