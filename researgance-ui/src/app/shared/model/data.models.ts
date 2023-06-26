export interface DataModels {
    recordId: number;
    cid: string;
    uniqueId: string;
    level: string;
    title: string;
    link: string;
    scopus: string;
    web_Of_Sc: string;
    pubmed: string;
    ieee: string;
    indian_Citation_Index: string;
    google_Scholar: string;
    year: string;
    sourcePublication: string;
    scopus_Citation: number;
    woS_Citation: number;
    ieeE_Citation: string;
    icI_Citation: string;
    gS_Citation: number;
    vol_No: string;
    issue_No: string;
    b_Page: string;
    e_Page: string;
    snip: number;
    sjr: number;
    impact_Factor: number;
    issn: string;
    isbn: string;
    status: string;
    articleType: string;
    authorAffiliation: string;
    verifiedStatus: string;
    e_ISSN: string;
    ugc: string;
    q_Rank: string;
    online_Date: string;
    abstract: string;
    technology_Areas: string;
    
}

export interface DocCount {
    userId:number;
    pubCount:              number;
    pubCountHome:          number;
    pubCountAway:          number;
    patentCount:           number;
    projectCount:          number;
    academicGuidanceCount: number;
}

export interface Faculty {
    facultyName:           string;
    slNo:                  number;
    empId:                 string;
    pubCount_Total:        number;
    pubCount_Home:         number;
    PubCount_Away:         number;
    patentCount:           number;
    projectCount:          number;
    academicGuidanceCount: number;
    department:            string;
    designation:           string;
    location:              string;
    faculty:               string;
}

export interface FacultyList {
  slNo: number,
  authorName: string,
  department: string,
  institute:  string,
  location:  string,
  link:  string,
  scopusId:  string,
  scopusLink: number,
  researcherID:  string,
  researcherLink:   string,
  orchidId:  string,
  orchidLink:  string,
  scopusH_Index: number,
  wosH_Index: number,
  gssH_Index: number,
  verification:  string,
  empid: number,
  emailID:  string,
  designation:  string,
  researchArea:  string
 
}

export interface Article{
    userId:number;
    journal:number;
    conference:number;
    book:number;
    bookChapter:number;
}


export interface dashboardModel{
    moduleName:string;
    totalCount:number;
    lineItem1Text:string;
    lineItem1Count:number;
    lineItem2Text:string;
    lineItem2Count:number;
}
