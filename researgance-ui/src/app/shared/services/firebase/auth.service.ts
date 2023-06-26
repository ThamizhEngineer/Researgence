import { Injectable, NgZone } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';
import 'rxjs/add/operator/do'
import 'rxjs/add/operator/catch';
import { environment } from '../../../../environments/environment';


export interface User {
  uid: string;
  email: string;
  displayName: string;
  photoURL: string;
  emailVerified: boolean;
}

@Injectable({
  providedIn: 'root',
})

export class AuthService {
  baseUrl = environment.authApiUrl;

  private jwt() {
    let httpHeaders = new HttpHeaders({
        'Content-Type': 'application/json',
        'Cache-Control': 'no-cache',
        'tenantID':'evlr2'
    });
    let options = {
        headers: httpHeaders
    };
    return options;
}

  public showLoader: boolean = false;
  userData: any; // Save logged in user data
  constructor(
    public router: Router,
    public ngZone: NgZone,
    private httpClient: HttpClient
  ) {
    
  }

  get isLoggedIn(): boolean {
    const user = JSON.parse(localStorage.getItem('currentUser')!);
    return user !== null && user.id !== false ? true : false;
  }

  login(body) {    
    let url = this.baseUrl + "auth/tokens/login";
    return this.httpClient.post(url, body, this.jwt())
        .do(user => {
            localStorage.setItem('currentUser', JSON.stringify(user));            
              this.showLoader = true;
              this.router.navigate(['/dashboard/default']);     
            console.log("Logging in")
        });
}

SignOut() {

  let url = this.baseUrl + "auth/tokens/logout";
  let body  = JSON.parse(localStorage.getItem('currentUser'));
  return this.httpClient.post(url, body, this.jwt())
      .do(user => {
        localStorage.clear();
        localStorage.removeItem('currentUser');
        this.showLoader = false;
        this.router.navigate(['/auth/login']);
      });
}

validate(user) {
    console.log("Validating")
    let url = this.baseUrl + "/tokens/validate";
    return this.httpClient.post(url, user, this.jwt())
        .do(user => {
            localStorage.setItem('currentUser', JSON.stringify(user));
        });
}

  
}