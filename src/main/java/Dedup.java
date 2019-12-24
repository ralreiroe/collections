import java.util.*;

public class Dedup {

    public static void main(String[] input) {

        List<Integer> integers = Arrays.asList(1, 2, 3, 5, 3, 6, 7, 2, 1);

        HashSet<Integer> seen = new HashSet<>();

        ArrayList<Integer> result = new ArrayList<>();

        for (Integer el : integers) {

            if (!seen.contains(el)) {
                seen.add(el);
                result.add(el);
            }
        }

        System.out.println(result);

    }
}
