import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams} from '@angular/common/http';
import { TradeForm } from '../model/tradeform.model';
import { Observable } from 'rxjs';
import { HttpParamsOptions } from '@angular/common/http/src/params';
import { BidForm } from '../model/bidform.model';


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

  tradeid = localStorage.getItem('tradeId');

  private tradeUrl = 'http://localhost:8080/HunterFleaMarket/trades';
  private bidUrl = 'http://localhost:8080/HunterFleaMarket/bids';

  constructor(private http: HttpClient) {
  }

  sendBid(bidform: BidForm): Observable<BidForm> {
    const userId: any = { userid: this.cUser.userid,
                          tradeid: this.tradeid };
    const httpParams: HttpParamsOptions = { fromObject: userId } as HttpParamsOptions;
    const options = {params: new HttpParams(httpParams), headers: httpOptions.headers};
    return this.http.post<BidForm>(this.bidUrl,
        bidform, options
    );
  }

  sendTrade(tradeForm: TradeForm): Observable<TradeForm> {
    const userId: any = { userid: this.cUser.userid };
    const httpParams: HttpParamsOptions = { fromObject: userId } as HttpParamsOptions;
    const options = {params: new HttpParams(httpParams), headers: httpOptions.headers};
    return this.http.post<TradeForm>(this.tradeUrl,
      tradeForm, options
    );
}

getAllBids(): Observable<BidForm[]> {
  return this.http.get<BidForm[]>(this.bidUrl,
    {
      params: {
        userid: this.cUser.userid,
      }
    });
  }
}
