package com.neoteric.student.avootaCode;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ReviewService {

    public Map<String, Object> calculateAverageRatings(RootResponse rootResponse) throws IOException {
        ResponseData response = rootResponse.getResponse();
        Map<String, Object> result = new HashMap<>();

        if (response == null || response.getCategoryList() == null) {
            result.put("error", "No categories found.");
            return result;
        }

        // Process each category using Stream, groupingBy, and map
        result = response.getCategoryList().stream()
                .collect(Collectors.toMap(
                        Category::getCategoryName,
                        category -> {
                            Map<String, Object> categoryResult = new HashMap<>();

                            // Add categoryName
                            categoryResult.put("categoryName", category.getCategoryName());

                            // Map subcategoryAverages from categoryReview using Stream and map
                            Map<String, Double> subcategoryAverages = category.getCategoryReview().stream()
                                    .collect(Collectors.toMap(
                                            CategoryReview::getType,
                                            CategoryReview::getAverageRating
                                    ));
                            categoryResult.put("subcategoryAverages", subcategoryAverages);

                            // Calculate overallRatingAverage using Stream
                            double overallRatingAverage = category.getReviewList().stream()
                                    .mapToInt(Review::getRating)
                                    .average()
                                    .orElse(0.0);
                            categoryResult.put("overallRatingAverage", overallRatingAverage);

                            // Process reviewSummary using Stream and map, ensuring all types are present
                            Map<String, String> typeToPercentage = category.getReviewSummary().stream()
                                    .collect(Collectors.toMap(
                                            ReviewSummary::getType,
                                            ReviewSummary::getPercentage
                                    ));

                            List<String> allTypes = Arrays.asList("Good", "Average", "Bad");
                            List<Map<String, String>> reviewSummary = allTypes.stream()
                                    .map(type -> {
                                        Map<String, String> summaryMap = new HashMap<>();
                                        summaryMap.put("type", type);
                                        summaryMap.put("percentage", typeToPercentage.getOrDefault(type, "0"));
                                        return summaryMap;
                                    })
                                    .collect(Collectors.toList());
                            categoryResult.put("reviewSummary", reviewSummary);

                            // Aggregate subratings from reviewList using Stream, flatMap, and groupingBy
                            Map<String, Double> subratings = category.getReviewList().stream()
                                    .flatMap(review -> review.getSubratings().values().stream())
                                    .collect(Collectors.groupingBy(
                                            Subrating::getLocalized_name,
                                            Collectors.averagingDouble(Subrating::getValue)
                                    ));

                            // If subratings is empty, fall back to categoryReview data
                            if (subratings.isEmpty()) {
                                subratings = category.getCategoryReview().stream()
                                        .collect(Collectors.toMap(
                                                CategoryReview::getType,
                                                CategoryReview::getAverageRating
                                        ));
                            }
                            categoryResult.put("subratings", subratings);

                            return categoryResult;
                        }
                ));

        return result;
    }
}