class Solution {
    public int evalRPN(String[] tokens) {
      Stack<String> st = new Stack<>();

      for(int i=0;i<tokens.length;i++)
      {
         if(!tokens[i].equals("+") && !tokens[i].equals("-") && !tokens[i].equals("*") && !tokens[i].equals("/"))
         st.push(tokens[i]);
         else
         {
            int ans=0;
            int val1=Integer.parseInt(st.pop());
            int val2=Integer.parseInt(st.pop());
            if(tokens[i].equals("+"))
            ans = val1+val2;
            else if(tokens[i].equals("-"))
            ans = val2-val1;
            else if(tokens[i].equals("*"))
            ans = val1*val2;
            else if(tokens[i].equals("/"))
            ans = val2/val1;
            String temp = Integer.toString(ans);
            st.push(temp);
         }
      }  
      return Integer.parseInt(st.peek());
    }
}