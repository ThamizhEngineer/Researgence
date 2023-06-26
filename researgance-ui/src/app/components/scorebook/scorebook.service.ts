import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ScorebookService {

  private jwt() {
    let headers = new HttpHeaders({ 'Accept': 'application/json', 'Content-Type': 'application/json' });
    let options = {
        headers: headers
     }
return options;
}
constructor(private http: HttpClient) {

}
// getAllScoreCardEntries(){
//   var url="/assets/jsondata/scorecard.json" ;
//   return this.http.get(url, this.jwt()).pipe(map((res) => res))

// } 

getScoreFull(){
  var url="/assets/jsondata/scorebook1.json";
  return this.http.get(url, this.jwt()).pipe(map((res) => res))
}

}
