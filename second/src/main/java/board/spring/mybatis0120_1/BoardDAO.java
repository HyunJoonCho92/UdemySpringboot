package board.spring.mybatis0120_1;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository 
//("boarddao")
public interface BoardDAO {
	int getTotalBoard();
	List<BoardDTO> getBoardList(int limit);
	//1개의 상세 게시물 조회
	BoardDTO getOneBoard(int seq);
	void updateViewCount(int seq);
	void insertBoard(BoardDTO dto);
}