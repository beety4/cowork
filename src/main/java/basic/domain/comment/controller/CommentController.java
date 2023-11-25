package basic.domain.comment.controller;

import java.util.ArrayList;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import basic.domain.comment.dto.CommentDTO;
import basic.domain.comment.service.CommentService;
import basic.domain.security.config.PrincipalDetails;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class CommentController {
	private final CommentService commentService;
	
	@ResponseBody
	@PostMapping("/getComment.do")
	public ArrayList<CommentDTO> getComment(int boardNo) {
		return commentService.getComment(boardNo);
	}
	
	@ResponseBody
	@PostMapping("/addComment.do")
	public ArrayList<CommentDTO> addComment(@AuthenticationPrincipal PrincipalDetails details, CommentDTO commentDTO) {
		commentDTO.setName(details.getName());
		commentService.addComment(commentDTO);
		return commentService.getComment(commentDTO.getBoardNo());
	}
	
}
