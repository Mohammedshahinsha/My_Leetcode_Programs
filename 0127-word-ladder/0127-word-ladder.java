class Solution {
    private static int ans;

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        boolean contains = false;
        for (String s : wordList)
            if (s.equals(endWord)) {
                contains = true;
                break;
            }
        if (!contains) return 0;
        ans = Integer.MAX_VALUE;
        bfs(beginWord, endWord, wordList, new ArrayList<>());
        if (ans == Integer.MAX_VALUE) return 0;
        return ans + 1;
    }

    private static void bfs(String beginWord, String endword, List<String> wordList, ArrayList<boolean[]> visited) {

        class Node {
            String str;
            int layer;
            int serit;

            Node(Node ata, String s, int j) {
                layer = ata.layer + 1;
                str = s;
                setSerit(ata, j);
            }

            Node(String s) {
                layer = 0;
                str = s;
            }

            private void setSerit(Node ata, int j) {
                serit = ata.serit + j;
            }
        }

        boolean[] şerit = new boolean[wordList.size() + 1];
        visited.add(şerit);

        Queue<Node> Q = new LinkedList<>();

        Q.add(new Node(beginWord));
        şerit[0] = true;

        while (!Q.isEmpty()) {
            Node ata = Q.poll();

            int j = 0;
            for (int i = 0; i < wordList.size(); i++) {
                if (!visited.get(j)[i + 1] && differsByOneLetter(ata.str, wordList.get(i))) {
                    Node child = new Node(ata, wordList.get(i), j);
                    if (child.str.equals(endword)) {
                        ans = child.layer;
                        return;
                    }
                    Q.add(child);
                    visited.get(j)[i + 1] = true;
                    visited.add(şeritCopy(visited.get(j)));
                    j++;
                }
            }
        }
    }

    private static boolean differsByOneLetter(String s, String otherS) {
        if (s.length() != otherS.length()) return false;
        int letterDiff = 0;
        for (int i = 0; i < s.length(); i++) if (s.charAt(i) != otherS.charAt(i)) letterDiff++;
        return letterDiff == 1;
    }

    private static boolean[] şeritCopy(boolean[] şerit) {
        boolean[] ret = new boolean[şerit.length];
        System.arraycopy(şerit, 0, ret, 0, şerit.length);
        return ret;
    }
}