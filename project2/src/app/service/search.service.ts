import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { TradeForm } from '../model/tradeform.model';

@Injectable({
  providedIn: 'root'
})
export class SearchService {

  private url = 'http://localhost:8080/HunterFleaMarket/search';
  user = localStorage.getItem('user');
  cUser = JSON.parse(this.user);

  constructor(private http: HttpClient) { }

  getAllTrades(): Observable<TradeForm[]> {
    return this.http.get<TradeForm[]>(this.url);
    }
}
