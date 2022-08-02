import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Vocabulary {
    String sentence;

    public Vocabulary(String sentence) {
        this.sentence = sentence;
    }

    public void vocabularyAdd() {
        List<String> list = Arrays.asList(sentence);
        Function<String, String> function = w -> w.toString();
        List<String> words = list.stream()
                .flatMap(v -> Arrays.stream(v.split(" ")))
                .sorted(Comparator.naturalOrder())
                .distinct()
                .collect(Collectors.toList());

        for (String q : words) {
            String result = function.apply(q);
            System.out.print(result);

            Map<String, String> map = new HashMap<>();
            map.put(q, "пока не известно как переводиться");
            System.out.println(" - " + map.values());
        }
    }
}
