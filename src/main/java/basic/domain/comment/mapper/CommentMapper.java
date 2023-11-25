package basic.domain.comment.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import basic.domain.comment.dto.CommentDTO;

@Mapper
public interface CommentMapper {
	public ArrayList<CommentDTO> getComment(int boardNo);
	public void addComment(CommentDTO commentDTO);
	public void deleteComment(int commentNo);
}
