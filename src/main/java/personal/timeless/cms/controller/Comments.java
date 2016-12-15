package personal.timeless.cms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import personal.timeless.cms.model.JsonResponse;
import personal.timeless.cms.service.CommentService;

@RestController
public class Comments {
	
	@Autowired
	private CommentService commentService;
	
	@RequestMapping("/greeting")
    public JsonResponse greeting(@RequestParam(value="name", defaultValue="World") String name) {
		commentService.Queryall();
        return new JsonResponse(200, "ok");
    }
}
