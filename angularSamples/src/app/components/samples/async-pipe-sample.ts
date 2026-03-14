import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { interval, of } from 'rxjs';
import { map, delay } from 'rxjs/operators';

@Component({
  selector: 'async-pipe-sample',
  imports: [CommonModule],
  template: `
    <h3>Async Pipe</h3>
    <p>Time: {{ time$ | async | date: 'mediumTime' }}</p>

    <h4>Users (delayed)</h4>
    @if (users$ | async; as users) {
      <ng-container>
        <ul>
          @for (u of users; track u) {
            <li>{{ u.name }}</li>
          }
        </ul>
      </ng-container>
    } @else {
      <div class="d-flex justify-content-center">
        <div class="spinner-border" role="status"></div>
      </div>
    }
  `,
})
export class AsyncPipeSample {
  //delayed observables
  time$ = interval(1200).pipe(map(() => new Date()));
  users$ = of([{ name: 'Alice' }, { name: 'Bob' }, { name: 'Carol' }]).pipe(delay(1200));
}
