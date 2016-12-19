package personal.timeless.cms.service;

import personal.timeless.cms.bean.FirstLevelComment;

public interface CommentService {
	public void addFlcComment(FirstLevelComment firstLevelComment);
	
	public void removeFlcComment(int commentId, int sayingId);
}
