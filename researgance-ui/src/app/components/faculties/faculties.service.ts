import { Injectable, NgZone } from '@angular/core';
//import{ Http,RequestOptions,Headers } from '@angular/http'
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';
import { Observable } from 'rxjs/Rx'
import { environment } from '../../../environments/environment';
import { map, catchError, retry } from 'rxjs/operators';
import { DocCount,Faculty,DataModels ,FacultyList, Article, dashboardModel} from '../../shared/model/data.models';
import { throwError } from 'rxjs';

@Injectable({
    providedIn: 'root',
})

export class FacultiesService {
    baseUrl = environment.authApiUrl;
    cachedMenuItems: any;
    error:any;
    
    // private jwt() {
    //     let httpHeaders = new HttpHeaders({
    //         'Content-Type': 'application/json',
    //         'Cache-Control': 'no-cache',
    //         'tenantID': 'master'
    //     });
    //     let options = {
    //         headers: httpHeaders
    //     };
    //     return options;
    // }
    // facultyList: [any]
    // userData: any; // Save logged in user data
    // constructor(
    //     public router: Router,
    //     public ngZone: NgZone,
    //     private httpClient: HttpClient
    // ) {

    // }


    // GetPubFacultyList() {
    //     let url =environment.profileUrl;
    //     return this.httpClient.get<{ [key: string]: Faculty }>(url, this.jwt()).pipe(map((res) => {
    //         const Faculty = [];
    //         for (const key in res) {
    //             Faculty.push({ ...res[key], id: key })
    //         }
    //         return Faculty;
    //     }))
    // }

    // GetProfile(id: any) {
    //     let url = environment.facultyUrl + id;
    //     return this.httpClient.get<{ [key: string]: FacultyList }>(url, this.jwt()).pipe(map((res) => {
    //         const facultyList = [];
    //         for (const key in res) {
    //             facultyList.push({ ...res[key], id: key })
    //         }
    //         return facultyList;
    //     }))
    // }

    // researcherPublicationDetails(id: any){
    //     let url =environment.publicationUrl + id;
    //     return this.httpClient.get<{ [key: string]: DataModels }>(url, this.jwt()).pipe(map((res) => {
    //         const DataModels = [];
    //         for (const key in res) {
    //             DataModels.push({ ...res[key], id: key })
    //         }
    //         return DataModels;
    //     }))
    // }

    // GetResearcherDocumentCounts(id: any){
    //     let url = environment.documentcountUrl + id;
    //     return this.httpClient.get<{ [key: string]: DocCount }>(url, this.jwt()).pipe(map((res) => {
    //         const DocCount = [];
    //         for (const key in res) {
    //             DocCount.push({ ...res[key], id: key })
    //         }
    //         return DocCount;
    //     }))
    // }
    // GetArticleRecords(id: any){
    //     let url = environment.articleUrl + id;
    //     return this.httpClient.get<{ [key: string]: Article }>(url, this.jwt()).pipe(map((res) => {
    //         const Article = [];
    //         for (const key in res) {
    //             Article.push({ ...res[key], id: key })
    //         }
    //         return Article;
    //     }))
    // }

       
    private jwt() {
        let headers = new HttpHeaders({ 'Accept': 'application/json', 'Content-Type': 'application/json' });
        let options = {
            headers: headers
         }
		return options;
    }
    constructor(private http: HttpClient) {

    }

             
//      GetDashboard(){
//               var url="/assets/jsondata/dashboard.json" ;
//               return this.http.get<dashboardModel>(url, this.jwt()).pipe(map((res) => res))
    
//       }
//       GetPubFacultyList() {
//               var url="/assets/jsondata/facultylist.json";
//               return this.http.get<Faculty>(url, this.jwt()).pipe(map((res) => res))
//       }

//        GetProfile() {
//               var url = "/assets/jsondata/profile.json" ;
//                 return this.http.get<FacultyList>(url,this.jwt()).pipe(map((res) => res))
//       }

//       researcherPublicationDetails(){
//               var url ="/assets/jsondata/publication.json";
//               return this.http.get(url,this.jwt()).pipe(map((res) => res))
//       }  

//       GetArticleRecords(){
//         var url ="/assets/jsondata/articlecount.json";
//         return this.http.get<Article>(url,this.jwt()).pipe(map((res) => res))
//       }

//       GetResearcherDocumentCounts(){
//         var url ="/assets/jsondata/documentcount.json";
//         return this.http.get<DocCount>(url,this.jwt()).pipe(map((res) => res))
// }  
        

           ///clienturl


           private handleError(error: HttpErrorResponse) {
                if (error.error instanceof ErrorEvent) {
                  // A client-side or network error occurred. Handle it accordingly.
                  console.error('An error occurred:', error.error.message);
                } else {
                  // The backend returned an unsuccessful response code.
                  // The response body may contain clues as to what went wrong,
                  console.error(
                    `Backend returned code ${error.status}, ` +
                    `body was: ${error.error}`);
                }
                // return an observable with a user-facing error message
                return throwError(
                  'Something bad happened; please try again later.');
              };

        //    GetDashboard(){
        //         return this.http.get(environment.DashboardUrl, this.jwt()).pipe(map((res) => res))
      
        // }
        // GetPubFacultyList() {
        //         return this.http.get(environment.profileUrl, this.jwt()).pipe(catchError(this.error));
        //                 // map((res) => res))
        // }
             GetDashboard(){
              var url="/assets/jsondata/dashboard.json" ;
              return this.http.get<dashboardModel>(url, this.jwt()).pipe(map((res) => res))
    
      }
         GetProfile(id:any) {
                  return this.http.get(environment.facultyUrl + id,this.jwt()).pipe(
                        map((res) => res),
                        catchError(this.handleError)
                      );
                    }
                    GetPubFacultyList() {
                                    var url="/assets/jsondata/facultylist.json";
                                    return this.http.get<Faculty>(url, this.jwt()).pipe(map((res) => res))
                            }
         researcherPublicationDetails(id: any) {
                return this.http.get(environment.publicationUrl + id, this.jwt()).pipe(
                  map((res) => res),
                  catchError(this.handleError)
                );
              }
              
        GetArticleRecords(id:any){
          return this.http.get(environment.articleUrl +id,this.jwt()).pipe(map((res) => res))
        }
  
        GetResearcherDocumentCounts(id:any){
         
          return this.http.get(environment.documentcountUrl +id,this.jwt()).pipe(catchError(this.error))
  }  
}