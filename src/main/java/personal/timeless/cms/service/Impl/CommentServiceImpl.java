package personal.timeless.cms.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import personal.timeless.cms.bean.FirstLevelComment;
import personal.timeless.cms.bean.SecondLevelComment;
import personal.timeless.cms.mapper.FirstLevelCommentMapper;
import personal.timeless.cms.mapper.SecondLevelCommentMapper;
import personal.timeless.cms.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	private FirstLevelCommentMapper firstLevelCommentMapper;
	
	@Autowired
	private SecondLevelCommentMapper secondLevelCommentMapper;

	@Override
	public void addFlcComment(FirstLevelComment firstLevelComment) {
		firstLevelCommentMapper.insertFlcComment(firstLevelComment);
	}

	@Override
	public void removeFlcComment(int commentId, int sayingId) {
		firstLevelCommentMapper.deleteFlcComment(commentId, sayingId);
	}

	@Override
	public void addSlcComment(SecondLevelComment secondLevelComment) {
		secondLevelCommentMapper.insertSlcComment(secondLevelComment);
	}

	@Override
	public void removeSlcComment(int commentId, int sayingId) {
		secondLevelCommentMapper.deleteSlcComment(sayingId, commentId);
	}

}
