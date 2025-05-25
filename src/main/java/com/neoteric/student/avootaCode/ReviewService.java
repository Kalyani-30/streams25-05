package com.neoteric.student.avootaCode;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

@Service
public class ReviewService {

    // Remove jsonReader from here, instead pass RootResponse as parameter
    public Map<String, Object> calculateAverageRatings(RootResponse rootResponse) throws IOException {

        ResponseData response = rootResponse.getResponse();

        Map<String, Object> result = new HashMap<>();

        if (response == null || response.getCategoryList() == null) {
            result.put("error", "No categories found.");
            return result;
        }

        for (Category category : response.getCategoryList()) {
            Map<String, Object> categoryResult = new HashMap<>();
            categoryResult.put("categoryName", category.getCategoryName());

            Map<String, Double> categoryAverages = category.getCategoryReview().stream()
                    .collect(Collectors.toMap(
                            CategoryReview::getType,
                            CategoryReview::getAverageRating
                    ));
            categoryResult.put("subcategoryAverages", categoryAverages);

            OptionalDouble reviewAvg = category.getReviewList().stream()
                    .mapToInt(Review::getRating)
                    .average();
            categoryResult.put("overallRatingAverage", reviewAvg.orElse(0.0));

            result.put(category.getCategoryName(), categoryResult);
        }

        return result;
    }

}
