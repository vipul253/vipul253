import { Component } from '@angular/core';
import { CounterService } from '../../services/service-sample';
import { HotStateService } from '../../services/hot-observable-sample';

@Component({
  selector: 'counter-a',
  standalone: true,
  template: `
    <p>Value: {{ counter.value }}</p>
    <button (click)="counter.inc()">+1</button>
    <button (click)="counter.dec()">-1</button>
  `,
})
export class CounterA {
  constructor(
    public counter: CounterService,
    public hotObservable: HotStateService,
  ) {
    this.hotObservable.message$.subscribe((msg: string) => console.log('Component 1:', msg));
  }
}

@Component({
  selector: 'counter-b',
  standalone: true,
  template: `
    <p>Value: {{ counter.value }}</p>
    <button (click)="counter.inc()">+1</button>
    <button (click)="counter.dec()">-1</button>
  `,
})
export class CounterB {
  constructor(
    public counter: CounterService,
    public hotObservable: HotStateService,
  ) {
    this.hotObservable.message$.subscribe((msg: string) => console.log('Component 2:', msg));
  }
}
