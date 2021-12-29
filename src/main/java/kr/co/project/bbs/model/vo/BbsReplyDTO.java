package kr.co.project.bbs.model.vo;
/*
 *	CREATE TABLE REPLY_TBL (
		RSEQ NUMBER PRIMARY KEY
		, SEQ NUMBER REFERENCES BBS_TBL(SEQ)
		, RWRITER VARCHAR(20)
		, RCONTENT VARCHAR(1000)
		, RDATE DATE DEFAULT SYSDATE
	);

	CREATE SEQUENCE REPLY_SEQ;
 */
public class BbsReplyDTO {
	private int rSeq;
	private int seq;
	private String rWriter;
	private String rContent;
	private String rDate;
	
	public BbsReplyDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public BbsReplyDTO(int rSeq, int seq, String rWriter, String rContent, String rDate) {
		super();
		this.rSeq = rSeq;
		this.seq = seq;
		this.rWriter = rWriter;
		this.rContent = rContent;
		this.rDate = rDate;
	}
	
	public int getrSeq() {
		return rSeq;
	}
	
	public void setrSeq(int rSeq) {
		this.rSeq = rSeq;
	}
	
	public int getSeq() {
		return seq;
	}
	
	public void setSeq(int seq) {
		this.seq = seq;
	}
	
	public String getrWriter() {
		return rWriter;
	}
	
	public void setrWriter(String rWriter) {
		this.rWriter = rWriter;
	}
	
	public String getrContent() {
		return rContent;
	}
	
	public void setrContent(String rContent) {
		this.rContent = rContent;
	}
	
	public String getrDate() {
		return rDate;
	}
	
	public void setrDate(String rDate) {
		this.rDate = rDate;
	}
	
	@Override
	public String toString() {
		return "BbsReplyDTO [rSeq=" + rSeq + ", seq=" + seq + ", rWriter=" + rWriter + ", rContent=" + rContent
				+ ", rDate=" + rDate + "]";
	}
	
}
