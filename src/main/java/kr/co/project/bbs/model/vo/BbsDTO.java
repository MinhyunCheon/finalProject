package kr.co.project.bbs.model.vo;

public class BbsDTO {
	private String subject;
	private String content;
	private String writer;
	
	public BbsDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public BbsDTO(String subject, String content, String writer) {
		super();
		this.subject = subject;
		this.content = content;
		this.writer = writer;
	}

	public String getSubject() {
		return subject;
	}
	
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	@Override
	public String toString() {
		return "BbsDTO [subject=" + subject + ", content=" + content + ", writer=" + writer + "]";
	}
	
}
