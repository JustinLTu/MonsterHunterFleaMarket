import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from '../model/user.model';
import { Observable } from 'rxjs';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
};


@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private url = 'http://localhost:8080/HunterFleaMarket/login';
  constructor( private http: HttpClient) { }

  getInfo(user: User): Observable<User> {
    return this.http.post<User>(this.url,
        user, httpOptions
    );
}
}

