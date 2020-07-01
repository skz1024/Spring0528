package or.itschool.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.AllArgsConstructor;
import or.itschool.model.BoardVO;
import or.itschool.service.BoardServiceImpl;

@RequestMapping(value = "/board/*")
@Controller
@AllArgsConstructor
public class BoardController {

	private BoardServiceImpl service;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) throws Exception{
		System.out.println("게시글 페이지 열람 요청");
		List<BoardVO> articles = service.getAllArticles();
		for(BoardVO vo : articles)
			System.out.println("vo: " + vo);
		
		model.addAttribute("articles", service.getAllArticles());
		return "board/list";
	}
	
	@RequestMapping(value = "/write", method = RequestMethod.POST)
//	@PostMapping("/write")
	public String write(BoardVO article, RedirectAttributes redirectAttr) throws Exception {
		System.out.println("/board/write: requset post");
		service.insert(article);
		redirectAttr.addFlashAttribute("message", "regSuccess");
 		return "redirect:/board/list";
	}
	
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String write() throws Exception {
		return "board/write";
	}
	
	
	
	
	@RequestMapping(value = "/content", method = RequestMethod.GET)
	public String content(int boardNo, Model model) throws Exception {
		model.addAttribute("article", service.getArticle(boardNo));
		return "board/content";
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public String modify(int boardNo, Model model) throws Exception {
		model.addAttribute("article", service.getArticle(boardNo));
		return "board/modify";
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
//	@PostMapping("/modify")
	public String modify(BoardVO article, RedirectAttributes redirectAttr) throws Exception {
		service.update(article);
		redirectAttr.addFlashAttribute("message", "modSuccess");
		return "redirect:/board/content?boardNo=" + article.getBoardNo();
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
//	@PostMapping("/delete")
	public String delete(int boardNo, RedirectAttributes redirectAttr) throws Exception {
		service.delete(boardNo);
		redirectAttr.addFlashAttribute("message", "delSuccess");
		return "redirect:/board/list";
	}

}
