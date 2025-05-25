package com.neoteric.student.avootaCode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping("/average")
    public ResponseEntity<Map<String, Object>> getAverageRatings(@RequestBody RootResponse rootResponse) throws IOException {
        Map<String, Object> averages = reviewService.calculateAverageRatings(rootResponse);
        return ResponseEntity.ok(averages);
    }
}
