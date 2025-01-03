package Entities;

import java.sql.Date;

public class Report {

	private Integer reportId;
	private Enum reportType;
	private Date generatedDate;
	private String data;
	
	public Integer getReportId() {
		return reportId;
	}
	public void setReportId(Integer reportId) {
		this.reportId = reportId;
	}
	public Enum getReportType() {
		return reportType;
	}
	public void setReportType(Enum reportType) {
		this.reportType = reportType;
	}
	public Date getGeneratedDate() {
		return generatedDate;
	}
	public void setGeneratedDate(Date generatedDate) {
		this.generatedDate = generatedDate;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}


}