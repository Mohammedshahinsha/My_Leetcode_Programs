class Solution {
    void solve(int idx,StringBuilder temp,List<String> result,String digits, HashMap<Integer,String> map){
        // if the index crosses thedigits length the we have gotour answer in temp
        // add it and return
        if(idx>=digits.length()) {
            result.add(temp.toString());
            return;
        }
        // for every index of digits store its corresponding string to processs further
        String s=map.get(Character.getNumericValue(digits.charAt(idx)));
        // for loop for trying every combos 
        for(int i=0;i<s.length();i++){
            // basic backtracking template as we have to perform it for every digits alternative strings 
            temp.append(s.charAt(i));
            solve(idx + 1, temp, result, digits, map);
            temp.deleteCharAt(temp.length() - 1);
        }
    }
    public List<String> letterCombinations(String digits) {
        // check case to end fast
        List<String> result=new ArrayList<>();
        if(digits.length()==0) return result;
        // map to store all data
        HashMap<Integer,String> map=new HashMap<>();
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");

        // stringbuilder as temp tostore strings at every recursive step
        StringBuilder temp=new StringBuilder();

        solve(0,temp,result,digits,map);
        return result;
    }
}