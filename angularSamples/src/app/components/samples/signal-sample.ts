import { Component, signal } from '@angular/core';

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
}
