package com.giant.project.model;

import java.util.Date;

public class Board {
	private int    post_no;
	private String mem_id;
	private String subject;
	private String content;
	private Date   reg_date;
	private String upt_id;
	private String upt_name;
	private Date   upt_date;
	private int    status;
	
	//  직급
	private int    d_job;
	
	
	
	
	public int getD_job() {
		return d_job;
	}
	public void setD_job(int d_job) {
		this.d_job = d_job;
	}
	public String getUpt_name() {
		return upt_name;
	}
	public void setUpt_name(String upt_name) {
		this.upt_name = upt_name;
	}
	public int getPost_no() {
		return post_no;
	}
	public void setPost_no(int post_no) {
		this.post_no = post_no;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
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
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	public String getUpt_id() {
		return upt_id;
	}
	public void setUpt_id(String upt_id) {
		this.upt_id = upt_id;
	}
	public Date getUpt_date() {
		return upt_date;
	}
	public void setUpt_date(Date upt_date) {
		this.upt_date = upt_date;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
	
}
