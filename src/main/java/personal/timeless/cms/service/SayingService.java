package personal.timeless.cms.service;

import personal.timeless.cms.bean.Saying;

public interface SayingService {

	public Saying QueryOneSaying(int id);
	
	public void modifySayingLikes(int id, String likes);

}