import { Injectable } from "@angular/core";
import { Headers, Http, RequestOptions, Response } from "@angular/http";
import { Observable } from 'rxjs/Rx'
import { environment } from '../../../../environments/environment';


Injectable()
export class AuthenticationService {

    baseUrl: string = "/auth/tokens/login";
    clientId: string = 'evlr';

    constructor(private http: Http) {
        this.http.get('https://api.ipify.org?format=json').subscribe(data => localStorage.setItem('clientIp', data.json().ip));
    }

    private jwt() {
        let headers = new Headers({ 'Accept': 'application/json', 
        'Content-Type': 'application/json',
        'tenantID':localStorage.getItem('tenant_id') });
        return new RequestOptions({ headers: headers });
    }
    
    login(email: string, password: string, timeZone) {       
        let obj = JSON.stringify({ userName: email, password: password, appClientId: this.clientId,timeZone:timeZone });
        return this.http.post(this.baseUrl + 'tokens/login', obj, this.jwt())
            .map((response: Response) => {
                let user = response.json();
                if (user.acceptedAgmt == 'Y' && user && user.appToken) {
                    // store user details and jwt token in local storage to keep user logged in between page refreshes
                    localStorage.setItem('currentUser', JSON.stringify(user));
                }
                return user;
            });
    }

    getCurrentToken(currentUser): string {
        var currentToken: string = "";
        if (currentUser.applicationCode == 'evaluator') {
            var res = currentUser.authToken.filter(x => x.applicationCode === currentUser.applicationCode);
            if (res) {
                currentToken = res[0].appToken
            }else{
                error =>{
                    console.log(error)
                }
            }
        }
        return currentToken;
    }

    logout() {
        let currentUser = JSON.parse(localStorage.getItem('currentUser')||'{}');
        if (currentUser) {
            var currToken = this.getCurrentToken(currentUser);
            let obj = JSON.stringify({ userName: currentUser.userName, appToken: currToken, appClientId: this.clientId, applicationCode: 'evaluator' });
            return this.http.post(this.baseUrl + 'tokens/logout', obj, this.jwt()).map(res => { });
        }
        else return Observable.of(null);
    }
}
