import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams} from '@angular/common/http';
import { TradeForm } from '../model/tradeform.model';
import { Observable } from 'rxjs';
import { HttpParamsOptions } from '@angular/common/http/src/params';
import { analyzeAndValidateNgModules } from '@angular/compiler';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
};

@Injectable({
  providedIn: 'root'
})
export class TradeService {

  user = localStorage.getItem('user');
  cUser = JSON.parse(this.user);
  private url = 'http://localhost:8080/HunterFleaMarket/trades';

  constructor(private http: HttpClient) {
  }

  sendTrade(tradeForm: TradeForm): Observable<TradeForm> {
    const userId: any = { userid: this.cUser.userid };
    const httpParams: HttpParamsOptions = { fromObject: userId } as HttpParamsOptions;
    const options = {params: new HttpParams(httpParams), headers: httpOptions.headers};
    return this.http.post<TradeForm>(this.url,
      tradeForm, options
    );
}
}
