package umc.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.ReviewConverter;
import umc.study.domain.Review;
import umc.study.service.ReviewService.ReviewCommandServiceImpl;
import umc.study.web.dto.request.ReviewRequestDTO;
import umc.study.web.dto.response.ReviewResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewRestController {
    private final ReviewCommandServiceImpl reviewCommandService;

    @PostMapping("/{storeId}")
    public ApiResponse<ReviewResponseDTO.JoinResultDTO> join(@PathVariable Long storeId, @RequestBody @Valid ReviewRequestDTO.JoinDto request){
        Review review = reviewCommandService.joinReview(storeId, request);
        return ApiResponse.onSuccess(ReviewConverter.toJoinResultDTO(review));
    }
}
