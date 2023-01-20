package board.spring.mybatis0120_1;

import java.util.List;

public interface BoardService {
	//게시물리스트 서비스 명세서
	int getTotalBoard();
	List<BoardDTO> getBoardList(int limit);
	//상세 게시물 정보
	BoardDTO getOneBoard(int seq);
	//void updateViewCount(int seq);
	
	void insertBoard(BoardDTO dto);

}
