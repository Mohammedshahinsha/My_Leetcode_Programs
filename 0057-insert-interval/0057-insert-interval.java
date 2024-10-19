class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        if(n==0){
            int[][] z = new int[1][2];
            z[0][0] = newInterval[0];
            z[0][1] = newInterval[1];
            return z;
        }
        if(n==1){
            if(newInterval[0]>=intervals[0][0] && newInterval[0]<=intervals[0][1]){
                int[][] some = new int[1][2];
                some[0][0] = intervals[0][0];
                some[0][1] = Math.max(newInterval[1],intervals[0][1]);
                return some;
            }
            else if(newInterval[0]>intervals[0][1]){
                int[][] some = new int[2][2];
                some[0][0] = intervals[0][0];
                some[0][1] = intervals[0][1];
                some[1][0] = newInterval[0];
                some[1][1] = newInterval[1];
                return some;
            }
            else if(newInterval[1]<intervals[0][0]){
                int[][] some = new int[2][2];
                some[0][0] = newInterval[0];
                some[0][1] = newInterval[1];
                some[1][0] = intervals[0][0];
                some[1][1] = intervals[0][1];
                return some;
            }
            else{
                int[][] some = new int [1][2];
                some[0][0] = newInterval[0];
                some[0][1] = intervals[0][1];
            }
        }
        List<List<Integer>> list = new ArrayList<>();
        int i = 0;
        while(newInterval[0]>intervals[i][0] && i<n-1){
            if(newInterval[0]>=intervals[i][0] && newInterval[0]<=intervals[i][1]){
                break;
            }
            i++;
        }
        int j = i;
        while(newInterval[1]>=intervals[j][1] && j<=n-2){
            if(newInterval[1]<intervals[j+1][0]){
                break;
            }
            j++;
        }
        for(int k=0;k<i;k++){
            List<Integer> temp = new ArrayList<>();
            temp.add(intervals[k][0]);
            temp.add(intervals[k][1]);
            list.add(temp);
        }
        if(newInterval[1]<intervals[0][0]){
            List<Integer> temp1 = new ArrayList<>();
            List<Integer> temp3 = new ArrayList<>();
            temp1.add(newInterval[0]);
            temp1.add(newInterval[1]);
            temp3.add(intervals[i][0]);
            temp3.add(intervals[i][1]);
            list.add(temp1);
            list.add(temp3);
        }
        else if(newInterval[0]>intervals[n-1][1]){
            List<Integer> temp4 = new ArrayList<>();
            List<Integer> temp5 = new ArrayList<>();
            temp4.add(intervals[j][0]);
            temp4.add(intervals[j][1]);
            temp5.add(newInterval[0]);
            temp5.add(newInterval[1]);
            list.add(temp4);
            list.add(temp5);
        }
        else if(newInterval[1]<intervals[i][0] && newInterval[0]>intervals[i-1][1]){
            List<Integer> temp6 = new ArrayList<>();
            List<Integer> temp7 = new ArrayList<>();
            temp6.add(newInterval[0]);
            temp6.add(newInterval[1]);
            temp7.add(intervals[i][0]);
            temp7.add(intervals[i][1]);
            list.add(temp6);
            list.add(temp7);
        }
        else{
            int min = Math.min(intervals[i][0],newInterval[0]);
            int max = Math.max(intervals[j][1],newInterval[1]);
            List<Integer> temp = new ArrayList<>();
            temp.add(min);
            temp.add(max);
            list.add(temp);
        }
        for(int k=j+1;k<n;k++){
            List<Integer> temp2 = new ArrayList<>();
            temp2.add(intervals[k][0]);
            temp2.add(intervals[k][1]);
            list.add(temp2);
        }
        int[][] ans = new int[list.size()][2];
        for(int x=0;x<list.size();x++){
            ans[x][0] = list.get(x).get(0);
            ans[x][1] = list.get(x).get(1);
        }
        return ans;
    }
}