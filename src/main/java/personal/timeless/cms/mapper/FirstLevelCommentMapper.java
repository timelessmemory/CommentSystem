package personal.timeless.cms.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import personal.timeless.cms.bean.FirstLevelComment;

@Mapper
public interface FirstLevelCommentMapper {
	public void insertFlcComment(FirstLevelComment firstLevelComment);
	
	public void deleteFlcComment(@Param("commentId") int commentId, @Param("sayingId") int sayingId);
}
