package personal.timeless.cms.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import personal.timeless.cms.bean.FirstLevelComment;
import personal.timeless.cms.mapper.FirstLevelCommentMapper;
import personal.timeless.cms.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	private FirstLevelCommentMapper firstLevelCommentMapper;

	@Override
	public void addFlcComment(FirstLevelComment firstLevelComment) {
		firstLevelCommentMapper.insertFlcComment(firstLevelComment);
	}

	@Override
	public void removeFlcComment(int commentId, int sayingId) {
		firstLevelCommentMapper.deleteFlcComment(commentId, sayingId);
	}

}
