package com.example.myblog.controller;


import com.example.myblog.domain.board.BoardRepository;
import com.example.myblog.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class BoardController {

    private final BoardService boardService;
    private final BoardRepository boardRepository;

    @GetMapping("/board/save")
    public String save() {
        return "layout/board/board-save";
    }


    /**
     *글상세 페이지
     */
    @GetMapping("/board/{id}")
    public String detail(@PathVariable Long id, Model model) {
        model.addAttribute("board", boardService.detail(id));
        boardRepository.updateCount(id);
        return "layout/board/board-detail";
    }

    @GetMapping("/board/{id}/update")
    public String update(@PathVariable Long id, Model model) {
        model.addAttribute("board", boardService.detail(id));
        return "layout/board/board-update";
    }
}
