package com.pojo;

// Generated 27 Nov, 2018 11:28:57 AM by Hibernate Tools 3.4.0.CR1

/**
 * Feedback generated by hbm2java
 */
public class Feedback implements java.io.Serializable {

	private Integer fid;
	private String fname;
	private String femail;
	private String fmobile;
	private String fmsg;

	public Feedback() {
	}

	public Feedback(String fname, String femail, String fmobile, String fmsg) {
		this.fname = fname;
		this.femail = femail;
		this.fmobile = fmobile;
		this.fmsg = fmsg;
	}

	public Integer getFid() {
		return this.fid;
	}

	public void setFid(Integer fid) {
		this.fid = fid;
	}

	public String getFname() {
		return this.fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getFemail() {
		return this.femail;
	}

	public void setFemail(String femail) {
		this.femail = femail;
	}

	public String getFmobile() {
		return this.fmobile;
	}

	public void setFmobile(String fmobile) {
		this.fmobile = fmobile;
	}

	public String getFmsg() {
		return this.fmsg;
	}

	public void setFmsg(String fmsg) {
		this.fmsg = fmsg;
	}

}
