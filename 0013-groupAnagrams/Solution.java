import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class groupAnagrams {
    public List<List<String>> GroupAnagrams(String[] strs) {
        //创建一个哈希表，key对应的是排序后的单词，value对应的是未进行排序的异位词集合
        HashMap<String,List<String>> map = new HashMap<>();
        //遍历字符串数组
        for (String str : strs) {
            //将每一个字符串转换成字符存入到新的字符数组中，方便排序。
            char[] arr = str.toCharArray();
            //排序每一个字符
            Arrays.sort(arr);
            //排序后重新存入,此时key中是排序后的字符串
            String key = new String(arr);
            //如果map中没有这个key就新创建一个value集合并存入
            if(!map.containsKey(key)){
                map.put(key,new ArrayList<>());
            }
            //如果存在key则直接添加进去当前的str
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
