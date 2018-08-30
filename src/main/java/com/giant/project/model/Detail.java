package com.giant.project.model;

import java.util.Date;

public class Detail {
	private int post_no;
	private int d_post_no;
	private int d_job;
	private int d_status;
	private Date d_upt_date;
	private String d_upt_id;
	public int getPost_no() {
		return post_no;
	}
	public void setPost_no(int post_no) {
		this.post_no = post_no;
	}
	public int getD_post_no() {
		return d_post_no;
	}
	public void setD_post_no(int d_post_no) {
		this.d_post_no = d_post_no;
	}
	public int getD_job() {
		return d_job;
	}
	public void setD_job(int d_job) {
		this.d_job = d_job;
	}
	public int getD_status() {
		return d_status;
	}
	public void setD_status(int d_status) {
		this.d_status = d_status;
	}
	public Date getD_upt_date() {
		return d_upt_date;
	}
	public void setD_upt_date(Date d_upt_date) {
		this.d_upt_date = d_upt_date;
	}
	public String getD_upt_id() {
		return d_upt_id;
	}
	public void setD_upt_id(String d_upt_id) {
		this.d_upt_id = d_upt_id;
	}
	
}
