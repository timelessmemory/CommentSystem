package personal.timeless.cms.controller;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import personal.timeless.cms.bean.Saying;
import personal.timeless.cms.model.JsonResponse;
import personal.timeless.cms.service.CommentService;

@RestController
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	@RequestMapping("/greeting")
    public Saying greeting(@RequestParam(value="name", defaultValue="World") String name) {
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(commentService.QueryOneSaying(1).getCreateTime()));
		return commentService.QueryOneSaying(1);
    }
}
