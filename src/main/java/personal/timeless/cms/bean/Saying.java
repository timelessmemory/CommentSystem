package personal.timeless.cms.bean;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Saying {
	private Integer id;
	private String sayingContent;
	private String author;
	private String avatar;
	private int likes;
	private Date createTime;
	
	public Saying() {}
	
	public Saying(Integer id, String sayingContent, String author, String avatar, int likes, Date createTime) {
		this.id = id;
		this.sayingContent = sayingContent;
		this.author = author;
		this.avatar = avatar;
		this.likes = likes;
		this.createTime = createTime;
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
	
	public int getLikes() {
		return likes;
	}
	
	public void setLikes(int likes) {
		this.likes = likes;
	}
	
	public Date getCreateTime() {
		return createTime;
	}
	
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}