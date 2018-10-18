import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { TradeForm } from '../model/tradeform.model';

@Injectable({
  providedIn: 'root'
})
export class GetformsService {

  private url = 'http://localhost:8080/HunterFleaMarket/trades';
  user = localStorage.getItem('user');
  cUser = JSON.parse(this.user);

  constructor(private http: HttpClient) { }

  getUserTrades(): Observable<TradeForm[]> {
    return this.http.get<TradeForm[]>(this.url,
      {
        params: {
          userid: this.cUser.userid,
        }
      });
    }
}
