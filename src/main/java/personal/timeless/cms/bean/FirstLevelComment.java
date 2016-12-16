package personal.timeless.cms.bean;

import java.util.Date;

public class FirstLevelComment {
	private Integer id;
	private Integer sayingId;
	private String commenter;
	private String avatar;
	private String commentContent;
	private Date commentTime;
	
	public FirstLevelComment() {}
	
	public FirstLevelComment(Integer id, Integer sayingId, String commenter, String avatar, String commentContent,
			Date commentTime) {
		this.id = id;
		this.sayingId = sayingId;
		this.commenter = commenter;
		this.avatar = avatar;
		this.commentContent = commentContent;
		this.commentTime = commentTime;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getSayingId() {
		return sayingId;
	}
	
	public void setSayingId(Integer sayingId) {
		this.sayingId = sayingId;
	}
	
	public String getCommenter() {
		return commenter;
	}
	
	public void setCommenter(String commenter) {
		this.commenter = commenter;
	}
	
	public String getAvatar() {
		return avatar;
	}
	
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	
	public String getCommentContent() {
		return commentContent;
	}
	
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	
	public Date getCommentTime() {
		return commentTime;
	}
	
	public void setCommentTime(Date commentTime) {
		this.commentTime = commentTime;
	}
}
