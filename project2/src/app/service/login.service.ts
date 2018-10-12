import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from '../model/user.model';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private url = 'http://localhost:8080/HunterFleaMarket/login';
  constructor( private http: HttpClient) { }

  getInfo(user: User) {

    return this.http.post(this.url,
      JSON.stringify(User)
    );
}
}

