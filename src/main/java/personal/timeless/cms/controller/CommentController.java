package personal.timeless.cms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import personal.timeless.cms.bean.FirstLevelComment;
import personal.timeless.cms.bean.SecondLevelComment;
import personal.timeless.cms.service.CommentService;

@RequestMapping("/comment")
@RestController
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	@RequestMapping(value="/add/first", method=RequestMethod.POST)
    public FirstLevelComment addFirstLevelCommment(FirstLevelComment firstLevelComment) {
		commentService.addFlcComment(firstLevelComment);
		return firstLevelComment;
    }
	
	@RequestMapping(value="/delete/first/{sayingId}/{commentId}")
    public void removeFirstLevelCommment(@PathVariable int sayingId, @PathVariable int commentId) {
		commentService.removeFlcComment(commentId, sayingId);
    }
	
	@RequestMapping(value="/add/second", method=RequestMethod.POST)
    public SecondLevelComment addSecondLevelCommment(SecondLevelComment secondLevelComment) {
		commentService.addSlcComment(secondLevelComment);
		System.out.println(secondLevelComment);
		return secondLevelComment;
    }
	
	@RequestMapping(value="/delete/second/{sayingId}/{commentId}")
    public void removeSecondLevelCommment(@PathVariable int sayingId, @PathVariable int commentId) {
		commentService.removeSlcComment(commentId, sayingId);
    }
}