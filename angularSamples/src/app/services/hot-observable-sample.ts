import { Subject } from 'rxjs';
import { Injectable } from '@angular/core';

@Injectable({ providedIn: 'root' })
export class HotStateService {
  // A Subject is a hot observable
  private messageSubject = new Subject<string>();

  // Expose the Subject as an Observable to prevent components from emitting values
  public message$ = this.messageSubject.asObservable();

  sendMessage(message: string) {
    this.messageSubject.next(message);
  }
}
