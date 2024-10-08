class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();        
        int currIndex = 0;
        while (currIndex < words.length) {
            int lineStart = currIndex;
            int lineWidth = words[currIndex].length();
            currIndex++;
            while (currIndex < words.length && (lineWidth + words[currIndex].length() + 1) <= maxWidth) {
                lineWidth += words[currIndex].length() + 1;
                currIndex++;
            }

            StringBuilder line = new StringBuilder(words[lineStart]);
            int numWordsInLine = currIndex - lineStart;            
            if (numWordsInLine == 1 || currIndex >= words.length) { 
                for (int i = lineStart + 1; i < currIndex; i++) {
                    line.append(" ").append(words[i]);
                }
                while (line.length() < maxWidth)    line.append(" ");
            } else { 
                int totalSpaces = maxWidth - lineWidth + (numWordsInLine - 1);
                int spaceBetweenWords = totalSpaces / (numWordsInLine - 1);
                int extraSpaces = totalSpaces % (numWordsInLine - 1);
                
                for (int i = lineStart + 1; i < currIndex; i++) {
                    int spacesToAdd = spaceBetweenWords + (extraSpaces > 0 ? 1 : 0);
                    line.append(" ".repeat(spacesToAdd)).append(words[i]);
                    extraSpaces--;
                }
            }
            
            result.add(line.toString());
        }        
        return result;
    }
}