package Algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 *

 Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

 For example, given
 s ="leetcode",
 dict =["leet", "code"].

 Return true because"leetcode"can be segmented as"leet code".


 */
public class CWordBreak {
    public static boolean wordBreak(String s, Set<String> dict) {
        if (dict==null||s==null){
            return false;
        }
        boolean flags[][]=new boolean[s.length()][s.length()];

        //循环把表填了,

        //[i][j]指的是s里从i到j是否是某个单词
        int len=s.length();
        for (int i=0;i<len;i++){
            for (int j=i;j<len;j++){

                Iterator<String> iterator=dict.iterator();
                while (iterator.hasNext()){
                    if (s.substring(i,j+1).equals(iterator.next())){//substring包括前面不包括后面
                        flags[i][j]=true;
                    }
                }

            }
        }

        return hasWordToEnd(0,flags);
    }


    public static boolean hasWordToEnd(int start,boolean[][] flags){
        if (start==flags.length){
            return true;
        }
        int len=flags.length;
        for (int i=start;i<len;i++){
            if (flags[start][i]){
                if (hasWordToEnd(i+1,flags)){
                    return true;
                }
            }
        }
        return false;
    }


    public static void main(String args[]){
        String s= "leetcode";
        Set<String> dict=new HashSet<>();
        dict.add("leet");
        dict.add("code");

        System.out.println(wordBreak(s,dict));

    }

}
