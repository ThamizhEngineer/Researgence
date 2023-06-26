package com.scw.resservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="s_res_pub_detail")
public class ResPublicationDetails {

	@Id
	private Integer Recordid;
	private String Cid;
	private String Uniqueid;
	private String Level;
	private String Title;
	private String Link;
	private String Scopus;
	@Column(name = "web_of_sc")
	private String webOfSc4;
	private String Pumbed;
	private String Ieee;
	@Column(name="indian_citation_Index")
	private String indianCitationIndex;
	@Column(name="google_scholar")
	private String googleScholar;
	private String Year;
	private String Sourcepublication;
	@Column(name="scopus_citation")
	private Integer scopusCitation;
	@Column(name="wos_citation")
	private Integer wosCitateion;
	@Column(name="ieee_citation")
	private Integer ieeeCitateion;
	@Column(name="ici_citation")
	private Integer iciCitateion;
	@Column(name="gs_citation")
	private Integer gsCitateion;
	@Column(name="vol_no")
	private String volNo;
	@Column(name="issue_no")
	private String issueNo;
	@Column(name="b_page")
	private String bPage;
	@Column(name="e_page")
	private String ePage;
	private Float Snip;
	private Float Sjr;
	@Column(name="impact_factor")
	private Float impactFactor;
	private String Issn;
	private String Isbn;
	private String Status;
	private String Articletype;
	private String Authoraffiliation;
	private String Verifiedstatus;
	@Column(name="e_issn")
	private String eIssn;
	private String Ugc;
	@Column(name="q_rank")
	private String qRank;
	@Column(name="online_date")
	private String onlineDate;
	private String Abstract;
	@Column(name="technology_areas")
	private String technologyAreas;
	public ResPublicationDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ResPublicationDetails(Integer recordid, String cid, String uniqueid, String level, String title,
			String link, String scopus, String webOfSc4, String pumbed, String ieee, String indianCitationIndex,
			String googleScholar, String year, String sourcepublication, Integer scopusCitation, Integer wosCitateion,
			Integer ieeeCitateion, Integer iciCitateion, Integer gsCitateion, String volNo, String issueNo,
			String bPage, String ePage, Float snip, Float sjr, Float impactFactor, String issn, String isbn,
			String status, String articletype, String authoraffiliation, String verifiedstatus, String eIssn,
			String ugc, String qRank, String onlineDate, String abstract1, String technologyAreas) {
		super();
		Recordid = recordid;
		Cid = cid;
		Uniqueid = uniqueid;
		Level = level;
		Title = title;
		Link = link;
		Scopus = scopus;
		this.webOfSc4 = webOfSc4;
		Pumbed = pumbed;
		Ieee = ieee;
		this.indianCitationIndex = indianCitationIndex;
		this.googleScholar = googleScholar;
		Year = year;
		Sourcepublication = sourcepublication;
		this.scopusCitation = scopusCitation;
		this.wosCitateion = wosCitateion;
		this.ieeeCitateion = ieeeCitateion;
		this.iciCitateion = iciCitateion;
		this.gsCitateion = gsCitateion;
		this.volNo = volNo;
		this.issueNo = issueNo;
		this.bPage = bPage;
		this.ePage = ePage;
		Snip = snip;
		Sjr = sjr;
		this.impactFactor = impactFactor;
		Issn = issn;
		Isbn = isbn;
		Status = status;
		Articletype = articletype;
		Authoraffiliation = authoraffiliation;
		Verifiedstatus = verifiedstatus;
		this.eIssn = eIssn;
		Ugc = ugc;
		this.qRank = qRank;
		this.onlineDate = onlineDate;
		Abstract = abstract1;
		this.technologyAreas = technologyAreas;
	}
	public Integer getRecordid() {
		return Recordid;
	}
	public void setRecordid(Integer recordid) {
		Recordid = recordid;
	}
	public String getCid() {
		return Cid;
	}
	public void setCid(String cid) {
		Cid = cid;
	}
	public String getUniqueid() {
		return Uniqueid;
	}
	public void setUniqueid(String uniqueid) {
		Uniqueid = uniqueid;
	}
	public String getLevel() {
		return Level;
	}
	public void setLevel(String level) {
		Level = level;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getLink() {
		return Link;
	}
	public void setLink(String link) {
		Link = link;
	}
	public String getScopus() {
		return Scopus;
	}
	public void setScopus(String scopus) {
		Scopus = scopus;
	}
	public String getWebOfSc4() {
		return webOfSc4;
	}
	public void setWebOfSc4(String webOfSc4) {
		this.webOfSc4 = webOfSc4;
	}
	public String getPumbed() {
		return Pumbed;
	}
	public void setPumbed(String pumbed) {
		Pumbed = pumbed;
	}
	public String getIeee() {
		return Ieee;
	}
	public void setIeee(String ieee) {
		Ieee = ieee;
	}
	public String getIndianCitationIndex() {
		return indianCitationIndex;
	}
	public void setIndianCitationIndex(String indianCitationIndex) {
		this.indianCitationIndex = indianCitationIndex;
	}
	public String getGoogleScholar() {
		return googleScholar;
	}
	public void setGoogleScholar(String googleScholar) {
		this.googleScholar = googleScholar;
	}
	public String getYear() {
		return Year;
	}
	public void setYear(String year) {
		Year = year;
	}
	public String getSourcepublication() {
		return Sourcepublication;
	}
	public void setSourcepublication(String sourcepublication) {
		Sourcepublication = sourcepublication;
	}
	public Integer getScopusCitation() {
		return scopusCitation;
	}
	public void setScopusCitation(Integer scopusCitation) {
		this.scopusCitation = scopusCitation;
	}
	public Integer getWosCitateion() {
		return wosCitateion;
	}
	public void setWosCitateion(Integer wosCitateion) {
		this.wosCitateion = wosCitateion;
	}
	public Integer getIeeeCitateion() {
		return ieeeCitateion;
	}
	public void setIeeeCitateion(Integer ieeeCitateion) {
		this.ieeeCitateion = ieeeCitateion;
	}
	public Integer getIciCitateion() {
		return iciCitateion;
	}
	public void setIciCitateion(Integer iciCitateion) {
		this.iciCitateion = iciCitateion;
	}
	public Integer getGsCitateion() {
		return gsCitateion;
	}
	public void setGsCitateion(Integer gsCitateion) {
		this.gsCitateion = gsCitateion;
	}
	public String getVolNo() {
		return volNo;
	}
	public void setVolNo(String volNo) {
		this.volNo = volNo;
	}
	public String getIssueNo() {
		return issueNo;
	}
	public void setIssueNo(String issueNo) {
		this.issueNo = issueNo;
	}
	public String getbPage() {
		return bPage;
	}
	public void setbPage(String bPage) {
		this.bPage = bPage;
	}
	public String getePage() {
		return ePage;
	}
	public void setePage(String ePage) {
		this.ePage = ePage;
	}
	public Float getSnip() {
		return Snip;
	}
	public void setSnip(Float snip) {
		Snip = snip;
	}
	public Float getSjr() {
		return Sjr;
	}
	public void setSjr(Float sjr) {
		Sjr = sjr;
	}
	public Float getImpactFactor() {
		return impactFactor;
	}
	public void setImpactFactor(Float impactFactor) {
		this.impactFactor = impactFactor;
	}
	public String getIssn() {
		return Issn;
	}
	public void setIssn(String issn) {
		Issn = issn;
	}
	public String getIsbn() {
		return Isbn;
	}
	public void setIsbn(String isbn) {
		Isbn = isbn;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public String getArticletype() {
		return Articletype;
	}
	public void setArticletype(String articletype) {
		Articletype = articletype;
	}
	public String getAuthoraffiliation() {
		return Authoraffiliation;
	}
	public void setAuthoraffiliation(String authoraffiliation) {
		Authoraffiliation = authoraffiliation;
	}
	public String getVerifiedstatus() {
		return Verifiedstatus;
	}
	public void setVerifiedstatus(String verifiedstatus) {
		Verifiedstatus = verifiedstatus;
	}
	public String geteIssn() {
		return eIssn;
	}
	public void seteIssn(String eIssn) {
		this.eIssn = eIssn;
	}
	public String getUgc() {
		return Ugc;
	}
	public void setUgc(String ugc) {
		Ugc = ugc;
	}
	public String getqRank() {
		return qRank;
	}
	public void setqRank(String qRank) {
		this.qRank = qRank;
	}
	public String getOnlineDate() {
		return onlineDate;
	}
	public void setOnlineDate(String onlineDate) {
		this.onlineDate = onlineDate;
	}
	public String getAbstract() {
		return Abstract;
	}
	public void setAbstract(String abstract1) {
		Abstract = abstract1;
	}
	public String getTechnologyAreas() {
		return technologyAreas;
	}
	public void setTechnologyAreas(String technologyAreas) {
		this.technologyAreas = technologyAreas;
	}
	@Override
	public String toString() {
		return "ResearcherPublicationDetails [Recordid=" + Recordid + ", Cid=" + Cid + ", Uniqueid=" + Uniqueid
				+ ", Level=" + Level + ", Title=" + Title + ", Link=" + Link + ", Scopus=" + Scopus + ", webOfSc4="
				+ webOfSc4 + ", Pumbed=" + Pumbed + ", Ieee=" + Ieee + ", indianCitationIndex=" + indianCitationIndex
				+ ", googleScholar=" + googleScholar + ", Year=" + Year + ", Sourcepublication=" + Sourcepublication
				+ ", scopusCitation=" + scopusCitation + ", wosCitateion=" + wosCitateion + ", ieeeCitateion="
				+ ieeeCitateion + ", iciCitateion=" + iciCitateion + ", gsCitateion=" + gsCitateion + ", volNo=" + volNo
				+ ", issueNo=" + issueNo + ", bPage=" + bPage + ", ePage=" + ePage + ", Snip=" + Snip + ", Sjr=" + Sjr
				+ ", impactFactor=" + impactFactor + ", Issn=" + Issn + ", Isbn=" + Isbn + ", Status=" + Status
				+ ", Articletype=" + Articletype + ", Authoraffiliation=" + Authoraffiliation + ", Verifiedstatus="
				+ Verifiedstatus + ", eIssn=" + eIssn + ", Ugc=" + Ugc + ", qRank=" + qRank + ", onlineDate="
				+ onlineDate + ", Abstract=" + Abstract + ", technologyAreas=" + technologyAreas + "]";
	}
	
	
}
