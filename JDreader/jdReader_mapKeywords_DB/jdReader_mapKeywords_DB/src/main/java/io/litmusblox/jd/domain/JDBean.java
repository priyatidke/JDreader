package io.litmusblox.jd.domain;

public class JDBean {

	private String jd;
	private String keywordListCommaSep;
	public String getJd() {
		return jd;
	}
	public void setJd(String jd) {
		this.jd = jd;
	}
	public String getKeywordListCommaSep() {
		return keywordListCommaSep;
	}
	public void setKeywordListCommaSep(String keywordListCommaSep) {
		this.keywordListCommaSep = keywordListCommaSep;
	}
	public JDBean(String jd, String keywordListCommaSep) {
		super();
		this.jd = jd;
		this.keywordListCommaSep = keywordListCommaSep;
	}
	
	
}
