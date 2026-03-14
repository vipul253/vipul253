import { Component } from '@angular/core';
//this is a shell card component that can be used by parent compopnents by ng-content
@Component({
  selector: 'w3-card',
  standalone: true,
  styles: [
    `
      .card {
        border: 1px solid #ccc;
        border-radius: 8px;
        padding: 12px;
        max-width: 360px;
      }
      .card-header {
        font-weight: 600;
        margin-bottom: 6px;
      }
      .card-body {
        color: #333;
      }
    `,
  ],
  template: `
    <div class="card">
      <div class="card-header"><ng-content select="[card-title]"></ng-content></div>
      <div class="card-body"><ng-content></ng-content></div>
    </div>
  `,
})
export class CardComponent {}
