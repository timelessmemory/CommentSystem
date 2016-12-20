package personal.timeless.cms.service;

import personal.timeless.cms.bean.FirstLevelComment;
import personal.timeless.cms.bean.SecondLevelComment;

public interface CommentService {
	
	public void addFlcComment(FirstLevelComment firstLevelComment);
	
	public void removeFlcComment(int commentId, int sayingId);
	
	public void addSlcComment(SecondLevelComment secondLevelComment);
	
	public void removeSlcComment(int commentId, int sayingId);
}
