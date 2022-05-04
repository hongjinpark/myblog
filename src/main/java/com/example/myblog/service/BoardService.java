package com.example.myblog.service;


import com.example.myblog.domain.board.Board;
import com.example.myblog.domain.board.BoardRepository;
import com.example.myblog.domain.user.User;
import com.example.myblog.dto.board.BoardSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public Long save(BoardSaveRequestDto boardSaveRequestDto, User user) {
        boardSaveRequestDto.setUser(user);
        return boardRepository.save(boardSaveRequestDto.toEntity()).getId();
    }

    /**
     * 글목록 로직
     */
    public List<Board> findAll() {
        return boardRepository.findAll();
    }
}
