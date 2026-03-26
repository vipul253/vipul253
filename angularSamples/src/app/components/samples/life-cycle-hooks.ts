import {
  Component,
  OnInit,
  OnDestroy,
  AfterViewInit,
  SimpleChanges,
  Input,
  ViewChild,
  ElementRef,
} from '@angular/core';

@Component({
  selector: 'child-cmp',
  standalone: true,
  template: `
    <p>Child received: {{ text }}</p>
    <p>Last change: {{ lastPrev || 'blank' }} -> {{ lastCurr || 'blank' }}</p>
  `,
})
export class Child {
  @Input() text = '';
  lastPrev = null;
  lastCurr = null;
  ngOnChanges(changes: SimpleChanges) {
    const c = changes['text'];
    if (c) {
      this.lastPrev = c.previousValue ?? null;
      this.lastCurr = c.currentValue ?? null;
    }
  }
}

@Component({
  selector: 'life-cycle-hooks',
  imports: [Child],
  template: `<h1>Lifecycle</h1>
    <h3>Data Binding</h3>
    <input [value]="name" (input)="name = $any($event.target).value" placeholder="Type your name" />
    <p>Hello {{ name }}!</p>
    <button (click)="count = count + 1">Clicked {{ count }} times</button>
    <button [disabled]="isDisabled">Can't click me</button>
    <h3>OnChanges</h3>
    <label>Text: <input #i (input)="text = i.value" placeholder="Type here..." /></label>
    <child-cmp [text]="text"></child-cmp>

    <h3>ViewChild & AfterViewInit</h3>
    <div #panel>
      <div>
        <input #box type="text" placeholder="Focused after view init" />
        <button (click)="measure()">Measure</button>
      </div>
      <p>Panel size: {{ size }}</p>
    </div>`,
})
export class LifeCycleHooksSample implements OnInit, OnDestroy, AfterViewInit {
  intervalId: any;
  text = '';
  size = '';
  name = 'Angular';
  count = 0;
  isDisabled = true;
  @ViewChild('box') box!: ElementRef; // ElementRef<HTMLInputElement>
  @ViewChild('panel') panel!: ElementRef; // ElementRef<HTMLDivElement>
  ngOnInit() {
    this.intervalId = setInterval(() => {
      console.log('ngOnInit ran');
    }, 500);
  }
  // after component DOM is loaded
  ngAfterViewInit() {
    console.log('ngAfterViewInit ran');
    // Focus input once view is initialized, then measure panel
    setTimeout(() => {
      this.box?.nativeElement?.focus?.();
      this.measure();
    });
  }

  ngOnDestroy() {
    console.log('ngOnDestroy ran');
    clearInterval(this.intervalId);
  }

  measure() {
    const el = this.panel?.nativeElement;
    if (!el) return;
    const rect = el.getBoundingClientRect();
    this.size = `${Math.round(rect.width)}—${Math.round(rect.height)}`;
  }
}
