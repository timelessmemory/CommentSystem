package personal.timeless.cms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import personal.timeless.cms.bean.Saying;
import personal.timeless.cms.service.CommentService;

@RequestMapping("/saying")
@RestController
public class SayingController {
	
	@Autowired
	private CommentService commentService;
	
	@RequestMapping("/get")
    public Saying greeting(@RequestParam(value="id") int id) {
		return commentService.QueryOneSaying(id);
    }
}
