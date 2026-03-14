import { Component } from '@angular/core';
import { CounterService } from '../../services/service-sample';

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
  constructor(public counter: CounterService) {}
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
  constructor(public counter: CounterService) {}
}
