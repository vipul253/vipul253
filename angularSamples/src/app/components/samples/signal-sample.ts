import { Component, computed, signal, effect } from '@angular/core';

@Component({
  selector: 'signal-sample',
  styles: [
    `
      .toolbar {
        display: flex;
        gap: 8px;
        align-items: center;
        flex-wrap: wrap;
      }
    `,
  ],
  template: `
    <h3>Conditional Rendering</h3>
    <button (click)="show.set(!show())">Toggle</button>
    @if (show()) {
      <p>Now you see me!</p>
    } @else {
      <p>Now I'm hidden.</p>
    }

    <h3>Conditional Rendering with &commat;switch</h3>
    <label>
      Status:
      <select (change)="status.set($any($event.target).value)">
        <option value="loading">loading</option>
        <option value="success">success</option>
        <option value="error">error</option>
      </select>
    </label>

    @switch (status()) {
      @case ('loading') {
        <p>Loading...</p>
      }
      @case ('success') {
        <p>Success!</p>
      }
      @case ('error') {
        <p style="color:crimson">Error!</p>
      }
      @default {
        <p>Unknown status</p>
      }
    }

    <h3>Multi-state with &commat;if</h3>

    <div class="toolbar">
      <button (click)="startLoading()">Start Loading</button>
      <button (click)="showError()">Set Error</button>
      <button (click)="reset()">Reset</button>
      <button (click)="myLog()">fullNameSignal</button>
      <span style="margin-left:8px;color:#666">loading={{ loading() }} error={{ error() }}</span>
    </div>

    @if (!loading() && !error()) {
      <p>Content loaded successfully.</p>
    } @else if (loading()) {
      <p>Loading...</p>
    } @else {
      <p style="color:crimson">Something went wrong.</p>
    }
  `,
})
export class SignalSample {
  show = signal(true);
  status = signal<string>('loading');

  loading = signal(false);
  error = signal(false);

  private _timer: any;

  startLoading() {
    this.loading.set(true);
    this.error.set(false);
    clearTimeout(this._timer);
    this._timer = setTimeout(() => {
      this.loading.set(false);
    }, 2000);
  }
  showError() {
    this.error.set(true);
    this.loading.set(false);
  }
  reset() {
    this.loading.set(false);
    this.error.set(false);
    this.startLoading();
  }

  // 1. Writable Signal (The raw state)
  quantity = signal(2);
  price = signal(10);

  // 2. Computed Signal (Derived state, read-only)
  // Re-calculates only when quantity or price changes
  total = computed(() => this.quantity() + this.price());

  firstName = signal('Jane');
  lastName = signal('Smith');
  age = signal(25);

  // The 'fullName' is a computed signal that updates automatically when
  // 'firstName' or 'lastName' changes.
  fullName = computed(() => `${this.firstName()} ${this.lastName()}`);

  // The 'isAdult' is a computed signal based on the 'age' signal.
  isAdult = computed(() => this.age() >= 18);

  myLog() {
    console.log(this.fullName()); // Outputs: Jane Smith
    console.log(this.isAdult());
    // Outputs: true
    this.firstName.set('John');
    console.log(this.fullName()); // Outputs: John Smith (automatically updated)
  }

  // 3. Effect (Side Effect)
  // Runs whenever count() changes
  // An effect is used to synchronize the state of signals with non-reactive APIs or 
  // perform actions like logging
  count = signal(0);
  constructor() {
    // This effect runs whenever the 'count' signal changes
    effect(() => {
      const currentCount = this.count();
      try {
        // Good use case: interacting with a non-reactive browser API (localStorage)
        // localStorage.setItem('count', currentCount);
        console.log(`count updated in localStorage to: ${currentCount}`);
      } catch (error) {
        console.error('Could not save theme to localStorage', error);
      }
    });
  }
}
