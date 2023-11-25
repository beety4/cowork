package basic.domain.comment.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import basic.domain.comment.dto.CommentDTO;
import basic.domain.comment.mapper.CommentMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class CommentService {
	private final CommentMapper commentMapper;
	
	public ArrayList<CommentDTO> getComment(int boardNo) {
		return commentMapper.getComment(boardNo);
	}
	
	public void addComment(CommentDTO commentDTO) {
		commentMapper.addComment(commentDTO);
	}
	
	public void deleteComment(int commentNo) {
		commentMapper.deleteComment(commentNo);
	}
	
}
