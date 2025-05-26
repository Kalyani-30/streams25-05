package com.neoteric.student.avootaCode;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
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

        result = response.getCategoryList().stream()
                .collect(Collectors.toMap(
                        Category::getCategoryName,
                        category -> {
                            Map<String, Object> categoryResult = new HashMap<>();

                            // Add categoryName
                            categoryResult.put("categoryName", category.getCategoryName());

                            // Map subcategoryAverages from categoryReview
                            Map<String, Double> categoryAverages = category.getCategoryReview().stream()
                                    .collect(Collectors.toMap(
                                            CategoryReview::getType,
                                            CategoryReview::getAverageRating
                                    ));
                            categoryResult.put("subcategoryAverages", categoryAverages);

                            // Calculate overallRatingAverage from reviewList
                            OptionalDouble reviewAvg = category.getReviewList().stream()
                                    .mapToInt(Review::getRating)
                                    .average();
                            categoryResult.put("overallRatingAverage", reviewAvg.orElse(0.0));

                            // Ensure reviewSummary includes all types (Good, Average, Bad)
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

                            // Aggregate subratings from reviewList
                            Map<String, Double> subratings = category.getReviewList().stream()
                                    .flatMap(review -> review.getSubratings().values().stream())
                                    .collect(Collectors.groupingBy(
                                            Subrating::getLocalized_name,
                                            Collectors.averagingDouble(Subrating::getValue)
                                    ));
                            categoryResult.put("subratings", subratings);

                            return categoryResult;
                        }
                ));

        return result;
    }
}