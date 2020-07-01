package or.itschool.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import or.itschool.mapper.BoardMapper;
import or.itschool.model.BoardVO;

@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService{
	
	private BoardMapper mapper;
	
	@Override
	public void insert(BoardVO article) throws Exception {
		mapper.insert(article);
	}
	
	@Override
	public BoardVO getArticle(int boardNo) throws Exception {
		// TODO Auto-generated method stub
		return mapper.getArticle(boardNo);
	}
	
	@Override
	public void update(BoardVO article) throws Exception {
		// TODO Auto-generated method stub
		mapper.update(article);
	}
	
	@Override
	public void delete(int boardNo) throws Exception {
		mapper.delete(boardNo);
	}
	
	@Override
	public List<BoardVO> getAllArticles() throws Exception {
		System.out.println(mapper);
		return mapper.getAllArticles();
	}

}
