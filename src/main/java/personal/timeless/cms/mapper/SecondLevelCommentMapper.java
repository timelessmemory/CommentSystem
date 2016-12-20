package personal.timeless.cms.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import personal.timeless.cms.bean.SecondLevelComment;

@Mapper
public interface SecondLevelCommentMapper {
	
	public int insertSlcComment(SecondLevelComment secondLevelComment);
	public void deleteSlcComment(@Param("sayingId") int sayingId, @Param("commentId") int commentId);
}
