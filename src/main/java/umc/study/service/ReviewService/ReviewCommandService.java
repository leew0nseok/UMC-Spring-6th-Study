package umc.study.service.ReviewService;

import jakarta.transaction.Transactional;
import umc.study.domain.Review;
import umc.study.web.dto.request.ReviewRequestDTO;

public interface ReviewCommandService {
    @Transactional
    Review joinReview(Long storeId, ReviewRequestDTO.JoinDto request);
}
