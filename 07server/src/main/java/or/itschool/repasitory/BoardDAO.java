package or.itschool.repasitory;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import or.itschool.mapper.BoardMapper;
import or.itschool.model.BoardVO;

public class BoardDAO implements BoardMapper {
	
	public final SqlSessionFactory sqlSession = null;
	private static final String NAMESPACE = "BoardMapper";
	
	@Autowired
	public BoardDAO() throws Exception{
		// TODO Auto-generated constructor stub
		((SqlSession) sqlSession).insert(NAMESPACE+".insert");
	}
	
	@Override
	public void insert(BoardVO article) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BoardVO getArticle(int boardNo) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("게시글 번호: " + boardNo);
		return ((SqlSession) sqlSession).selectOne(NAMESPACE+".getArticle", boardNo);
	}

	@Override
	public void update(BoardVO article) throws Exception {
		// TODO Auto-generated method stub
		((SqlSession) sqlSession).update(NAMESPACE+".update", article);
	}

	@Override
	public void delete(int boardNo) throws Exception {
		// TODO Auto-generated method stub
		((SqlSession) sqlSession).delete(NAMESPACE+".delete", boardNo);
	}

	@Override
	public List<BoardVO> getAllArticles() throws Exception {
		// TODO Auto-generated method stub
		return ((SqlSession) sqlSession).selectList(NAMESPACE+".getAllArticles");
	}

}
