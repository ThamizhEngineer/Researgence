import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MenuService {

  private menuSubject = new BehaviorSubject<boolean>(false);
  menu$ = this.menuSubject.asObservable();

  toggleMenu() {
    this.menuSubject.next(!this.menuSubject.value);
  }
}
