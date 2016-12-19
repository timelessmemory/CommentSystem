package personal.timeless.cms.bean;

import java.util.Date;
import java.util.List;

public class Saying {
	private Integer id;
	private String sayingContent;
	private String author;
	private String avatar;
	private String likes;
	private Date createTime;
	private List<FirstLevelComment> flcs;
	
	public Saying() {}
	
	public List<FirstLevelComment> getFlcs() {
		return flcs;
	}

	public void setFlcs(List<FirstLevelComment> flcs) {
		this.flcs = flcs;
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getSayingContent() {
		return sayingContent;
	}
	
	public void setSayingContent(String sayingContent) {
		this.sayingContent = sayingContent;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getAvatar() {
		return avatar;
	}
	
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	
	public String getLikes() {
		return likes;
	}
	
	public void setLikes(String likes) {
		this.likes = likes;
	}
	
	public Date getCreateTime() {
		return createTime;
	}
	
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}