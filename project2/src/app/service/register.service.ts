import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from '../model/user.model';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {


  private url = 'http://localhost:8080/HunterFleaMarket/accounts';
  constructor(private http: HttpClient) {
  }
  signup(user: User) {
    return this.http.post(this.url,
      console.log(JSON.stringify(user))
    );
}
}
