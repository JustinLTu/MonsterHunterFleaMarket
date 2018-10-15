import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { TradeForm } from '../model/tradeform.model';
import { Observable } from 'rxjs';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
};

@Injectable({
  providedIn: 'root'
})
export class TradeService {

  private url = 'http://localhost:8080/HunterFleaMarket/accounts';
  constructor(private http: HttpClient) {
  }

  sendTrade(tradeForm: TradeForm): Observable<TradeForm> {
    return this.http.post<TradeForm>(this.url,
      tradeForm,  httpOptions
    );
}
}
