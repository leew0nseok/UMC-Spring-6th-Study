package umc.study.service.ReviewService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.apiPayload.exception.handler.StoreCategoryHandler;
import umc.study.converter.ReviewConverter;
import umc.study.domain.Review;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.domain.Store;
import umc.study.repository.ReviewRepository;
import umc.study.repository.StoreRepository;
import umc.study.web.dto.request.ReviewRequestDTO;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService {

    private final ReviewRepository reviewRepository;
    private final StoreRepository storeRepository;

    @Override
    @Transactional
    public Review joinReview(Long storeId, ReviewRequestDTO.JoinDto request) {
        // 음식점 조회
        Optional<Store> storeOptional = storeRepository.findById(storeId);
        if (storeOptional.isEmpty()) {
            throw new StoreCategoryHandler(ErrorStatus.STORE_NOT_FOUND);
        }
        Store store = storeOptional.get();

        Review newReview = ReviewConverter.toReview(store, request);

        return reviewRepository.save(newReview);
    }


}
