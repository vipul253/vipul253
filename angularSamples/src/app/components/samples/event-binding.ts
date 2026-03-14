import { Component } from '@angular/core';

@Component({
  selector: 'event-binding-sample',
  styles: [
    `
      .toolbar {
        display: flex;
        gap: 8px;
        align-items: center;
        flex-wrap: wrap;
      }
      ul {
        margin-top: 10px;
      }
      li {
        line-height: 1.8;
      }
      input[type='text'] {
        padding: 6px 8px;
      }
    `,
  ],
  template: `
    <h2>Events</h2>
    <p>Count: {{ count }}</p>
    <button (click)="increment()">Click me</button>

    <div style="margin-top:12px">
      <input placeholder="Type..." (input)="onInput($event)" (keyup)="lastKey = $any($event).key" />
      <p>Value: {{ value }}</p>
      <p>Last key: {{ lastKey }}</p>
    </div>

    <h3>Event Filtering (keyup.enter)</h3>
    <div style="margin-top:12px" class="toolbar">
      <input
        type="text"
        placeholder="Add item and press Enter"
        [value]="draft"
        (input)="draft = $any($event.target).value"
        (keyup)="lastKey = $any($event).key"
        (keyup.enter)="add()"
      />
      <button (click)="add()">Add</button>
      <button (click)="clear()" [disabled]="items.length === 0">Clear</button>
      <span style="margin-left:8px;color:#666">Last key: {{ lastKey }}</span>
    </div>

    <ul>
      @for (item of items; track $index; let i = $index) {
        <li>{{ i + 1 }}. {{ item }}</li>
      } @empty {
        <li>There are no items.</li>
      }
    </ul>

    <h3>Debounced Input</h3>
    <input type="text" placeholder="Type here" (input)="onInputDebounce($event)" />
    <p>Immediate: {{ immediate }}</p>
    <p>Debounced (400ms): {{ debounced }}</p>
  `,
})
export class EventBindingSample {
  count = 0;
  value = '';
  lastKey = '';
  draft = '';
  items = ['Buy milk', 'Learn Angular'];

  increment() {
    this.count++;
  }

  onInput(e: Event) {
    this.value = (e.target as HTMLInputElement).value;
  }

  add() {
    const v = (this.draft || '').trim();
    if (!v) return;
    this.items = [...this.items, v];
    this.draft = '';
  }

  clear() {
    this.items = [];
  }

  immediate = '';
  debounced = '';
  private handle: any;

  onInputDebounce(e: Event) {
    const v = (e.target as HTMLInputElement)?.value ?? '';
    this.immediate = v;
    //custom delay and clear/reset timeout
    clearTimeout(this.handle);
    this.handle = setTimeout(() => (this.debounced = v), 400);
  }
}
