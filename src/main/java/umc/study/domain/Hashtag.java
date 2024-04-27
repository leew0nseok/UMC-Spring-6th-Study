package umc.study.domain;
import jakarta.persistence.*;
import lombok.*;
import umc.study.domain.common.BaseEntity;
import umc.study.domain.mapping.BookHashtag;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Hashtag extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hashtag_id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private String hashtagContent;

    @OneToMany(mappedBy = "hashtag", cascade = CascadeType.ALL)
    private List<BookHashtag> bookHashTagList = new ArrayList<>();
}
