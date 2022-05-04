package com.example.myblog.controller.api;


import com.example.myblog.config.auth.PrincipalDetail;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class BoardApiController {

    private final BoardService boardService;

    /**
     * 글작성 API
     */
    @PostMapping("/api/v1/board")
    public Long save(@RequestBody BoardSaveRequestDto boardSaveRequestDto, @AuthenticationPrincipal PrincipalDetail principalDetail) {
        return boardSaveRequestDto.save(boardSaveRequestDto, principalDetail.getUser());
    }
}
