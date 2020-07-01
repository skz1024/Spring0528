package or.itschool.service;

import java.util.List;

import or.itschool.model.BoardVO;

public interface BoardService {
	void insert(BoardVO article) throws Exception;
	BoardVO getArticle(int boardNo) throws Exception;
	void update(BoardVO article) throws Exception;
	void delete(int boardNo) throws Exception;
	List<BoardVO> getAllArticles() throws Exception;

}
