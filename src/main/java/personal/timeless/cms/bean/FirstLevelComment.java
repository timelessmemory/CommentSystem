package personal.timeless.cms.bean;

import java.util.Date;
import java.util.List;

public class FirstLevelComment {
	private Integer id;
	private Integer sayingId;
	private String commenter;
	private String avatar;
	private String commentContent;
	private Date commentTime;
	private Saying saying;
	private List<SecondLevelComment> slcs;
	
	public FirstLevelComment() {
		this.commentTime = new Date();
	}
	
	public List<SecondLevelComment> getSlcs() {
		return slcs;
	}

	public void setSlcs(List<SecondLevelComment> slcs) {
		this.slcs = slcs;
	}

	public Saying getSaying() {
		return saying;
	}

	public void setSaying(Saying saying) {
		this.saying = saying;
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

	@Override
	public String toString() {
		return "FirstLevelComment [flc_id=" + id + ", sayingId=" + sayingId + ", commenter=" + commenter
				+ ", avatar=" + avatar + ", commentContent=" + commentContent + ", commentTime=" + commentTime + "]";
	}
}
