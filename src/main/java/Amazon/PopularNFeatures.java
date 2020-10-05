package Amazon;

import org.junit.Test;

import java.util.*;

public class PopularNFeatures {
    public ArrayList<String> popularNFeatures(int numFeatures,
                                              int topFeatures,
                                              List<String> possibleFeatures,
                                              int numFeatureRequests,
                                              List<String> featureRequests) {

        ArrayList<String> topFeaturesResult = new ArrayList<>();
        //input validation
        if (featureRequests == null || featureRequests.size() == 0 ||
                possibleFeatures == null || possibleFeatures.size() == 0 ||
                numFeatureRequests <= 0 || numFeatures <= 0 || topFeatures <= 0) {
            return topFeaturesResult;
        }

        // create feature frequency map, runtime O(n*m) memory O(n)
        Map<String, Integer> featureRequestCounter = new HashMap<>();
        for (String featureRequest : featureRequests) {
            for (String possibleFeature : possibleFeatures) {
                if (featureRequest.contains(possibleFeature)) {
                    featureRequestCounter.put(possibleFeature,
                            featureRequestCounter.getOrDefault(possibleFeature, 0) + 1);
                }
            }
        }

        if (featureRequestCounter.size() == 0) {
            return topFeaturesResult;
        }

        // Sort features by frequency runtime O(n * log n) memory O(n)
        PriorityQueue<Map.Entry<String, Integer>> orderedFeaturesFrequency = new PriorityQueue<>((e1, e2) ->
                e1.getValue().equals(e2.getValue()) ?
                        e1.getKey().compareTo(e2.getKey()) : e2.getValue() - e1.getValue());

        orderedFeaturesFrequency.addAll(featureRequestCounter.entrySet());

        // Compose result runtime O(n), memory O(n)
        int currentTopFeatures = 0;
        while (orderedFeaturesFrequency.size() > 0 && (currentTopFeatures < topFeatures)) {
            Map.Entry<String, Integer> entry = orderedFeaturesFrequency.poll();
            if (entry.getValue() == 0) {
                break;
            }
            topFeaturesResult.add(entry.getKey());
            currentTopFeatures++;
        }

        if (topFeaturesResult.size() < topFeatures) {
            // TODO is exceptional case ?
        }

        return topFeaturesResult;
    }

    @Test
    public void test() {
        popularNFeatures(6, 2,
                Arrays.asList("storage", "battery", "hover", "alexa", "waterproof", "solar"), 7,
                Arrays.asList(
                        "I wish my Kindle had even more storage!",
                        "I wish the battery life on my Kindle lasted 2 years.",
                        "I read in the bath and would enjoy a waterproof Kindle",
                        "Waterproof and increased battery are my top two requests.",
                        "I want to take my Kindle into the shower. Waterproof please waterproof !",
                        "It would be neat if my Kindle would hover on my desk when not in use.",
                        "How cool would it be if my Kindle charged in the sun via solar power?"));
    }
}
