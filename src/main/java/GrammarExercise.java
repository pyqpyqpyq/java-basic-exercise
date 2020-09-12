
import java.util.Comparator;
import java.util.List;
import java.util.function.Supplier;
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
        Supplier<Stream<String>> supplier1 = () -> Stream.of(firstWordList.toUpperCase().split(","));
        Supplier<Stream<String>> supplier2 = () -> Stream.of(secondWordList.toUpperCase().split(","));

        checkValid(supplier1);
        checkValid(supplier2);

        List<String> result = supplier1.get()
                .filter(e -> supplier2.get().collect(Collectors.toList()).contains(e))
                .distinct()
                .sorted(Comparator.comparingInt(o -> o.charAt(0)))
                .collect(Collectors.toList());

        return result;
    }

    private static void checkValid(Supplier<Stream<String>> supplier) {
        final String regs = "^[a-zA-Z]+$";
        boolean isValid = supplier.get().allMatch(e -> e.matches(regs));
        if (!isValid) {
            throw new RuntimeException("input not valid");
        }

        if (supplier.get().anyMatch(String::isEmpty)) {
            throw new RuntimeException("input not valid");
        }
    }
}
