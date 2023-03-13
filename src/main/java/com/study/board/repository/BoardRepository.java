package com.study.board.repository;

import com.study.board.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board, Integer> {

    //findBy(칼럼이름)Containing 명령규칙으로 칼럼이름에 키워드가 포함된것을 찾음
    Page<Board> findByTitleContaining(String searchKeyword, Pageable pageable);
}
