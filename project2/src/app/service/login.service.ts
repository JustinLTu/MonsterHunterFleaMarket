import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from '../model/user.model';
import { Observable } from 'rxjs';

const options = new HttpHeaders().set('Content-Type', 'text/plain; charset=utf-8');


@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private url = 'http://localhost:8080/HunterFleaMarket/login';
  constructor( private http: HttpClient) { }

  getInfo(user: User): Observable<User> {
    // this.url = this.url + '?username=' + user.username + '&password=' + user.password;
    // const resp = {responseType: 'text' as 'text' };
    return this.http.post<User>(this.url,
        user,
    );
       // resp);
}
}

