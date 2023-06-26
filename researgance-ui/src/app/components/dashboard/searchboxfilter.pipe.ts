import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'searchboxfilter'
})
export class SearchboxfilterPipe implements PipeTransform {
  transform(items: any[], searchQuery: string): any[] {
    if (!searchQuery) {
      return items;
    }

    return items.filter(item => {
      return item.moduleName.toLowerCase().includes(searchQuery.toLowerCase());
    });
  }
}