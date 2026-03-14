import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
// the new, built-in @if(), @for(), and @switch() control flow syntax,
// introduced in Angular 17, is now the recommended approach. The older structural directives
// are officially deprecated as of Angular 20.
@Component({
  selector: 'old-micro-syntax',
  imports: [CommonModule],
  template: `<h3>Structural directives micro-syntax</h3>
    <button (click)="ok = !ok">Toggle</button>
    <div *ngIf="ok; else other">OK</div>
    <ng-template #other>Not OK</ng-template>
    <ul>
      <li *ngFor="let item of items; index as i">{{ i }} - {{ item }}</li>
    </ul>`,
})
export class OldMicroSyntax {
  ok = true;
  items = ['A', 'B', 'C'];
}
