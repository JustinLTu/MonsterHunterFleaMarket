import { Pipe, PipeTransform } from '@angular/core';
import { TradeForm } from '../model/tradeform.model';

@Pipe({
  name: 'filteritem'
})
export class FilteritemPipe implements PipeTransform {

  searchString: String = '';

  transform(value: Array<TradeForm>, limiter: string): Array<TradeForm> {
    if (!value) {
      return [];
    }
    if (!limiter) {
      return value;
    }
    limiter = limiter.toLocaleLowerCase();
      return value.filter(trade => {
        return trade.itemName.toLowerCase().includes(limiter);
      });
  }

}
