package personal.timeless.cms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import personal.timeless.cms.bean.Saying;
import personal.timeless.cms.service.SayingService;

@RequestMapping("/saying")
@RestController
public class SayingController {
	
	@Autowired
	private SayingService sayingService;
	
	@RequestMapping("/get/comment/{id}")
    public Saying showCommment(@PathVariable(value="id") int id) {
		return sayingService.QueryOneSaying(id);
    }
	
	@RequestMapping(value="/likes", method=RequestMethod.POST)
    public void changeLikes(@RequestParam int id, @RequestParam String likes) {
		sayingService.modifySayingLikes(id, likes);
    }
}
