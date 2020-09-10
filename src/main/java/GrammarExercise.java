import com.sun.tools.javac.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GrammarExercise {
    public static void main(String[] args) {
        //需要从命令行读入
        String firstWordList = "";
        String secondWordList = "";

        List<String> result = findCommonWordsWithSpace(firstWordList, secondWordList);
        //按要求输出到命令行

    }

    public static List<String> findCommonWordsWithSpace(String firstWordList, String secondWordList) {
        //在这编写实现代码
        Stream<String> stream = Arrays.stream(firstWordList.toUpperCase().split(","));
        List<String> list = new ArrayList<>(Arrays.asList(secondWordList.toUpperCase().split(",")));

        if (stream.anyMatch(String::isEmpty)) {
            throw new RuntimeException();
        }

        List<String> result = stream.filter(list::contains).distinct().sorted(Comparator.comparingInt(o -> o.charAt(0))).collect(Collectors.toList());
        return result;
    }
}


//import java.lang.reflect.Array;
//import java.util.Arrays;
//import java.util.List;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//public class GrammarExercise {
//    public static void main(String[] args) {
//        //需要从命令行读入
//        String firstWordList = "";
//        String secondWordList = "";
//
//        List<String> result = findCommonWordsWithSpace(firstWordList,secondWordList);
//        //按要求输出到命令行
//
//    }
//
//    public static List<String> findCommonWordsWithSpace(String firstWordList, String secondWordList) {
//
//        String[] List1 =firstWordList.split(",");
//        String[] List2 =secondWordList.split(",");
//        List<String> intersection = Arrays.stream(List1).map(String::toUpperCase).filter(item -> Arrays.stream(List2).map(String::toUpperCase).map(e -> e.toString()).collect(Collectors.toList()).contains(item.toString())).collect(Collectors.toList());
//        List<String> ans=intersection.stream()
//                .distinct()
//                .collect(Collectors.toList());
//        System.out.println(ans.toString());
//        return ans;
//    }
//}
