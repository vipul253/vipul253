import { Component } from '@angular/core';
import { CounterService } from '../../services/service-sample';
import { CounterA, CounterB } from './shared-service';
import { CardComponent } from './card';
import { HotStateService } from '../../services/hot-observable-sample';

@Component({
  selector: 'service-sample-demo',
  imports: [CounterA, CounterB, CardComponent],
  template: `
    <h3>Service Component which has counterA and counterB components as well</h3>
    <p>Counter: {{ counter.value }}</p>
    <button (click)="counter.reset()">Reset</button>
    <div class="row justify-content-md-center row-cols-sm-2 row-cols-md-4">
      <div class="col">
        <w3-card>
          <a card-title>Counter A</a>
          <counter-a></counter-a>
        </w3-card>
      </div>
      <div class="col">
        <w3-card>
          <a card-title>Counter B</a>
          <counter-b></counter-b>
        </w3-card>
      </div>
    </div>
    <p><em>All components use the same CounterService instance.</em></p>
    <button class="btn btn-primary" (click)="callHotObservable()">Hot Cold Observable Demo ConsoleLog</button>
  `,
})
export class ServiceSampleDemo {
  constructor(
    public counter: CounterService,
    public hotObservable: HotStateService,
  ) {}

  callHotObservable() {
    this.hotObservable.sendMessage('Hello everyone');
  }
}
