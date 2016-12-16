package personal.timeless.cms.mapper;

import org.apache.ibatis.annotations.Mapper;

import personal.timeless.cms.bean.Saying;

@Mapper
public interface SayingMapper {
	
	public Saying selectOneById(int id);
}
