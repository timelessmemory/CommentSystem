package personal.timeless.cms.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import personal.timeless.cms.bean.Saying;
import personal.timeless.cms.mapper.SayingMapper;
import personal.timeless.cms.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired
    private SayingMapper sayingMapper;
	
	@Override
	public Saying QueryOneSaying(int id) {
		return sayingMapper.selectOneById(id);
	}
}
