import { BehaviorSubject, Observable, Subject } from 'rxjs';
import { Injectable } from '@angular/core';

@Injectable({ providedIn: 'root' })
export class HotStateService {
  // A Subject is a hot observable
  private messageSubject = new Subject<string>();

  // Expose the Subject as an Observable to prevent components from emitting values
  public message$ = this.messageSubject.asObservable();

  // Emit a value before any observer has subscribed
  constructor() {
    this.messageSubject.next('unread msg');
  }

  coldObservableSample() {
    // Create a cold observable
    const coldObservable = new Observable<number>((observer) => {
      console.log('Observable execution');
      observer.next(Math.random());
    });

    // Subscribe observer 1 to the cold observable
    coldObservable.subscribe((value) => {
      console.log(`cold Observer 1 received: ${value} (random number)`);
    });

    // Subscribe observer 2 to the cold observable
    coldObservable.subscribe((value) => {
      console.log(`cold Observer 2 received: ${value} (random number)`);
    });
  }

  behaviourSubjectSample() {
    // Create a BehaviorSubject with a starting value of 0
    const behaviorSubject = new BehaviorSubject<number>(0);

    // A part of the website subscribes to the BehaviorSubject
    behaviorSubject.subscribe((value) => {
      console.log(`Part 1 received: ${value}`);
    });

    // Change the value to 1
    behaviorSubject.next(1);

    // Another part of the website subscribes
    behaviorSubject.subscribe((value) => {
      console.log(`Part 2 received: ${value}`);
    });

    // Change the value to 2
    behaviorSubject.next(2);
  }

  sendMessage(message: string) {
    this.messageSubject.next(message);
    this.coldObservableSample();
    this.behaviourSubjectSample();
  }
}
