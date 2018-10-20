import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { TradeForm } from '../model/tradeform.model';

@Injectable({
  providedIn: 'root'
})
export class GetformsService {

  private url = 'http://localhost:8080/HunterFleaMarket/trades/userid';
  

  constructor(private http: HttpClient) { }

  getUserTrades(): Observable<TradeForm[]> {
    const user = localStorage.getItem('user');
    const cUser = JSON.parse(user);
    return this.http.get<TradeForm[]>(this.url,
      {
        params: {
          userid: cUser.userid,
        }
      });
    }
}
