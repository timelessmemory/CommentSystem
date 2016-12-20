package personal.timeless.cms.bean;

import java.util.Date;

public class SecondLevelComment {
	private Integer id;
	private Integer sayingId;
	private Integer flcId;
	private String replier;
	private String toCommenter;
	private String replyContent;
	private Date replyTime;
	private FirstLevelComment flc;
	
	public SecondLevelComment() {
		this.replyTime = new Date();
	}

	public FirstLevelComment getFlc() {
		return flc;
	}

	public void setFlc(FirstLevelComment flc) {
		this.flc = flc;
	}

	public Integer getSayingId() {
		return sayingId;
	}

	public void setSayingId(Integer sayingId) {
		this.sayingId = sayingId;
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getFlcId() {
		return flcId;
	}
	
	public void setFlcId(Integer flcId) {
		this.flcId = flcId;
	}
	
	public String getReplier() {
		return replier;
	}
	
	public void setReplier(String replier) {
		this.replier = replier;
	}
	
	public String getToCommenter() {
		return toCommenter;
	}
	
	public void setToCommenter(String toCommenter) {
		this.toCommenter = toCommenter;
	}
	
	public String getReplyContent() {
		return replyContent;
	}
	
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	
	public Date getReplyTime() {
		return replyTime;
	}
	
	public void setReplyTime(Date replyTime) {
		this.replyTime = replyTime;
	}

	@Override
	public String toString() {
		return "SecondLevelComment [id=" + id + ", sayingId=" + sayingId + ", flcId=" + flcId + ", replier=" + replier
				+ ", toCommenter=" + toCommenter + ", replyContent=" + replyContent + ", replyTime=" + replyTime + "]";
	}
}
