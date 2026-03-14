import { Component } from '@angular/core';
import { NgTemplateOutlet } from '@angular/common';

@Component({
  selector: 'template-outlet',
  standalone: true,
  imports: [NgTemplateOutlet],
  template: `
    <h3>Templates with ngTemplateOutlet</h3>

    <label>
      Type:
      <select (change)="type = $any($event.target).value">
        <option value="info">info</option>
        <option value="warning">warning</option>
        <option value="success">success</option>
      </select>
    </label>

    <label>
      Message: <input (input)="msg = $any($event.target).value" [value]="msg" />
    </label>

    <ng-container
      [ngTemplateOutlet]="type === 'info' ? infoTpl : (type === 'warning' ? warnTpl : successTpl)"
      [ngTemplateOutletContext]="{ $implicit: msg }">
    </ng-container>
    <!--$implicit: msg is what we pas to let- variable text -->
    <!--these are templates that can be used again and again -->
    <!--we can pass these templates to other components  -->
    <ng-template #infoTpl let-text>
      <p style="color:royalblue">Info: {{ text }}</p>
    </ng-template>

    <ng-template #warnTpl let-text>
      <p style="color:darkorange">Warning: {{ text }}</p>
    </ng-template>

    <ng-template #successTpl let-text>
      <p style="color:seagreen">Success: {{ text }}</p>
    </ng-template>
  `
})
export class TemplateOutletSample {
  type: 'info' | 'warning' | 'success' = 'info';
  msg = 'Hello';
}