package personal.timeless.cms.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import personal.timeless.cms.bean.Saying;

@Mapper
public interface SayingMapper {
	
	public Saying selectOneById(int id);
	
	public void updateLikesById(@Param("id") int id, @Param("likes") String likes);
}
