import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from '../model/user.model';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
};

@Injectable({
  providedIn: 'root'
})
export class RegisterService {

  private url = 'http://localhost:8080/HunterFleaMarket/accounts';
  constructor(private http: HttpClient) {
  }
  signup(user: User) {
    return this.http.post(this.url,
      user,  httpOptions
    );
}
}
