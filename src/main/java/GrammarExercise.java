import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GrammarExercise {
    public static void main(String[] args) {
        //需要从命令行读入
        String firstWordList = "apple,juice,mother,people,beautiful,apple,dog";
        String secondWordList = "cat,baby,smile,good,apple,beautiful,Dog,nice";

        List<String> result = findCommonWordsWithSpace(firstWordList,secondWordList);
        //按要求输出到命令行

    }

    public static List<String> findCommonWordsWithSpace(String firstWordList, String secondWordList) {

        String[] List1 =firstWordList.split(",");
        String[] List2 =secondWordList.split(",");
        List<String> intersection = Arrays.stream(List1).map(String::toUpperCase).filter(item -> Arrays.stream(List2).map(String::toUpperCase).map(e -> e.toString()).collect(Collectors.toList()).contains(item.toString())).collect(Collectors.toList());
        List<String> ans=intersection.stream()
                .distinct()
                .collect(Collectors.toList());
//        System.out.println(ans.toString());
        return ans;
    }
}
