package modules.stream;

import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 2 * @Author: jiyongchao
 * 3 * @Date: 2020/8/26 23:41
 * 4
 */
public class StreamTest4 {
    public static void main(String[] args) {
//        Stream<String> modules.stream = Stream.of("hello", "world", "helloworld");
//        String[] stringArray = modules.stream.toArray(length -> new String[length]);
//        String[] strings = modules.stream.toArray(String[]::new);
//        Arrays.asList(stringArray).forEach(System.out::println);
//        Stream<String> modules.stream = Stream.of("hello", "world", "helloworld");
//        List<String> list = modules.stream.collect(Collectors.toList());
//        list.forEach(System.out::println);

//        List<String> list = modules.stream.collect(() -> new ArrayList<String>(), (theList, item) -> theList.add(item),
//                (theList1, theList2) -> theList1.addAll(theList2));
//
//        modules.stream.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

        Stream<String> stream = Stream.of("hello", "world", "helloworld");
//        LinkedList<String> list = modules.stream.collect(Collectors.toCollection(LinkedList::new));
//        list.forEach(System.out::println);

        TreeSet<String> set = stream.collect(Collectors.toCollection(TreeSet::new));
        set.forEach(System.out::println);

        String str = stream.collect(Collectors.joining()).toString();
    }
}
