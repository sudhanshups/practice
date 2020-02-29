package practice.specific;

import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class AZAU {


    public ArrayList<String> popularNToys(int numToys, int topToys, List<String> toys,
                                          int numQuotes, List<String> quotes) {

        Set<String> comps = new HashSet<>(toys);

        Map<String, Integer> map = comps.stream().map(String::toLowerCase)
                .map(s -> s.replaceAll(" ", "#"))
                .collect(Collectors.toMap(s -> s, v -> 0));


        List<String> reviewsNew = new ArrayList<>();

        for (String s : quotes) {
            for (String cc : comps) {
                s = s.replaceAll(cc, cc.replaceAll(" ", "#"));
            }
            reviewsNew.add(s);
        }

        for (String review : reviewsNew) {

            review = review.toLowerCase().replaceAll(";,", " ");
            String c[] = review.split(" ");
            HashSet<String> compNamesInReview = new HashSet<>();
            for (String cc : c) {
                if (map.containsKey(cc)) {
                    if (!compNamesInReview.contains(cc)) {
                        map.put(cc, map.get(cc) + 1);
                    }
                    compNamesInReview.add(cc);
                }
            }
        }

        Comparator<Entry<String, Integer>> byCount = (e1, e2) -> {
            if (e2.getValue() == e1.getValue()) {
                return e1.getKey().compareTo(e2.getKey());
            }
            return e2.getValue() - e1.getValue();
        };
        PriorityQueue<Entry<String, Integer>> pq = new PriorityQueue<>(byCount);

        for (Entry<String, Integer> e : map.entrySet()) {
            pq.add(e);
        }

        ArrayList<String> ans = new ArrayList<>();
        for (int i = 0; i < topToys; i++) {
            Entry<String, Integer> e = pq.remove();
            if (e.getValue() == 0) break;
            ans.add(e.getKey().replaceAll("#", " "));
        }

        //System.out.println(map);
        return ans;
    }


    public static void main(String[] args) throws IOException {

        AZAU az1 = new AZAU();
        List<String> toys = new ArrayList<>(Arrays.asList("elmo", "elsa", "legos", "drone", "tablet", "warcraft"));
        List<String> quotes = new ArrayList<>(Arrays.asList(
                "Elmo is the hottest toy of the season! Elmo will be on every kids wish list",
                "the new Elmo dolls will be on super high quality",
                "Expect the Elsa dolls to be very popular this year",
                "Elsa and Elmo are the toys I will be buying for my kids",
                "For parents of older kids, look into buy them a drone ",
                "warcraft will be slowly riding in popularity ahead of the holiday season"
        ));

        System.out.println(az1.popularNToys(6, 2, toys, 6, quotes));

        List<List<Integer>> a = new ArrayList<>();
    }
}
