package umc.study.converter;

import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.web.dto.ReviewRequestDTO;
import umc.study.web.dto.ReviewResponseDTO;

import java.time.LocalDateTime;

public class ReviewConverter {

    public static Review toReview(Store store, ReviewRequestDTO.JoinDto request){

        return Review.builder()
                .store(store)
                .title(request.getTitle())
                .score(request.getScore())
                .build();
    }

    public static ReviewResponseDTO.JoinResultDTO toJoinResultDTO(Review review) {
        return ReviewResponseDTO.JoinResultDTO.builder()
                .reviewID(review.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
