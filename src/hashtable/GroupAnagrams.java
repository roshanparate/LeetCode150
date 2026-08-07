package hashtable;

import java.util.*;

public class GroupAnagrams {

    public static void main(String[] args) {
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = groupAnagrams.groupAnagrams(strs);
        System.out.println(result); // Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
    }

    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> mp = new HashMap<>();

        for(String str : strs){
            char[] ar = str.toCharArray();
            Arrays.sort(ar);
            String  key = String.valueOf(ar);

            if(!mp.containsKey(key)){
                mp.put(key, new ArrayList<>());
            }

            mp.get(key).add(str);
        }

        List<List<String>> ans = new ArrayList<>();

        for(String key: mp.keySet()) {
            ans.add(mp.get(key));
        }

        return ans;

    }
}
