class Solution {
    public int lengthOfLongestSubstring(String s) { 
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
      
}
    
}

// M 1- enumerate/traverse all the elements and check for repetition, and increment at ascii val of char[], use 2 pointer technique. O(n^3)
    
//     int res=0;
//         for(int i=0;i<s.length();i++)
//         {
//             for(int j=i;j<s.length();j++)
//             {
//                 if(checkRepetition(s,i,j)) //imp 
//                     res=Math.max(res,(j-i+1));
//             }
//         }
//         return res;
//     }
    
//     private boolean checkRepetition(String s, int start, int end)
//     {   int[] chars= new int[128];   //for chars[]- ascii values
//         for(int i=start;i<=end;i++)
//         {
//             char c=s.charAt(i); //syntax+purpose
//             chars[c]++;  //freq increment
//             if(chars[c]>1)
//                 return false;
//         }
//      return true;
//     }
    
    
//     M 2- sliding window- traverse and store freq with right pointer, if freq>1 decrement left pointer an delete the left char--- O(2n) 
//  int[] chars= new int[128]; 
//        int left=0;
//         int right=0;
//         int res=0;
//         while(right<s.length())
//         {
//             char r=s.charAt(right);
//             chars[r]++;
            
//             while(chars[r]>1)
//             {
//                 char l=s.charAt(left);
//                 chars[l]--;
//                 left++;
//             }
//             res=Math.max(res,right-left+1);
//             right++;
//         }
//        return res; 
       
        
//     M 3- We use HashSet to store the characters in current window [i, j)[i,j) (j = ij=i initially). Then we slide the index jj to the right. If it is not in the HashSet, we slide jj further. Doing so until s[j] is already in the HashSet. At this point, we found the maximum size of substrings without duplicate characters start with index ii. If we do this for all ii, we get our answer.