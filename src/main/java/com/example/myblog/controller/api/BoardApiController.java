package com.example.myblog.controller.api;


import com.example.myblog.config.auth.PrincipalDetail;
import com.example.myblog.dto.board.BoardSaveRequestDto;
import com.example.myblog.dto.board.BoardUpdateRequestDto;
import com.example.myblog.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class BoardApiController {

    private final BoardService boardService;

    /**
     * 글작성 API
     */
    @PostMapping("/api/v1/board")
    public Long save(@RequestBody BoardSaveRequestDto boardSaveRequestDto, @AuthenticationPrincipal PrincipalDetail principalDetail) {
        return boardService.save(boardSaveRequestDto, principalDetail.getUser());
    }

    /**
     * 글삭제 API
     */
    @DeleteMapping("/api/v1/board/{id}")
    public Long deleteById(@PathVariable Long id) {
        boardService.deleteById(id);
        return id;
    }

    /**
     * 글수정 API
     */
    @PutMapping("/api/v1/board/{id}")
    public Long update(@PathVariable Long id, @RequestBody BoardUpdateRequestDto boardUpdateRequestDto) {
        return boardService.update(id, boardUpdateRequestDto);
    }
}
