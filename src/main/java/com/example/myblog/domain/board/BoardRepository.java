package com.example.myblog.domain.board;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


public interface BoardRepository extends JpaRepository<Board, Long> {

    @Transactional
    @Modifying
    @Query("update Board b set b.count = b.count + 1 where b.id = :id")
    int updateCount(Long id);

    Page<Board> findByTitleContainingOrContentContaining(
            @Param("title") String title, @Param("content") String content, Pageable pageable);
}
