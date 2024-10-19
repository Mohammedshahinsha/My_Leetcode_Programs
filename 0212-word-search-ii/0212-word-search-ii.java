class TrieNode {
    char value;
    TrieNode[] children;
    boolean isEndOfWord;

    TrieNode(char val) {
        value = val;
        children = new TrieNode[26];
        isEndOfWord = false;
    }
}

class Solution {
    private TrieNode root;

    public Solution() {
        root = new TrieNode('\0');
    }

    private void insertWord(String word) {
        TrieNode currentNode = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (currentNode.children[index] == null) {
                currentNode.children[index] = new TrieNode(ch);
            }
            currentNode = currentNode.children[index];
        }
        currentNode.isEndOfWord = true;
    }

    public List<String> findWords(char[][] board, String[] words) {
        for (String word : words) {
            insertWord(word);
        }

        Set<String> foundWords = new HashSet<>();
        StringBuilder currentWord = new StringBuilder();
        int numRows = board.length;
        int numCols = board[0].length;
        boolean[][] visited = new boolean[numRows][numCols];

        for (int row = 0; row < numRows; ++row) {
            for (int col = 0; col < numCols; ++col) {
                searchWords(board, foundWords, root, row, col, currentWord, visited);
            }
        }

        return new ArrayList<>(foundWords);
    }

    private void searchWords(char[][] board, Set<String> foundWords, TrieNode currentNode, int row, int col, StringBuilder currentWord, boolean[][] visited) {
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || visited[row][col]) return;

        char currentChar = board[row][col];
        if (currentNode.children[currentChar - 'a'] == null) return;

        currentWord.append(currentChar);
        currentNode = currentNode.children[currentChar - 'a'];

        if (currentNode.isEndOfWord) foundWords.add(currentWord.toString());

        visited[row][col] = true;
        searchWords(board, foundWords, currentNode, row + 1, col, currentWord, visited);
        searchWords(board, foundWords, currentNode, row - 1, col, currentWord, visited);
        searchWords(board, foundWords, currentNode, row, col + 1, currentWord, visited);
        searchWords(board, foundWords, currentNode, row, col - 1, currentWord, visited);
        visited[row][col] = false;

        currentWord.deleteCharAt(currentWord.length() - 1);
    }
}