import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
// date:'yyyy-MM-dd': Formats the today Date using the provided format string (year-month-day).
// Locale defaults apply unless specified.
// uppercase: Transforms the string value of name to upper case.
// percent:'1.0-2': Formats ratio as a percentage with digitsInfo (minInteger.minFraction-maxFraction):
// 1 integer digit, 0–2 fraction digits.
// Chaining: Pipes run left to right. ratio | percent:'1.0-2' | uppercase first formats a percent string,
// then uppercases it.
@Component({
  selector: 'template-pipes',
  imports: [CommonModule],
  template: `
    <h3>Built-in pipes</h3>
    <p>Today: {{ today | date: 'yyyy-MM-dd' }} | date:'yyyy-MM-dd'</p>
    <p>Name: {{ name | uppercase }} | uppercase</p>
    <p>Chained: {{ ratio | percent: '1.0-2' | uppercase }} | percent:'1.0-2' | uppercase</p>
    <h3>Attribute binding (attr.)</h3>
    <button [attr.aria-label]="label" (click)="toggle()" class="btn btn-primary">Toggle label</button>
    <p>[attr.colspan] = {{ wide ? 2 : 1 }}</p>
    <table class="table table-bordered">
      <tr>
        <th>A</th>
        <th>B</th>
        <th>C</th>
      </tr>
      <tr>
        <td [attr.colspan]="wide ? 2 : 1">Row {{ wide ? 2 : 1 }}</td>
        <td>Cell 1</td>
        <td>Cell 1</td>
      </tr>
    </table>
  `,
})
export class TemplatePipesSample {
  today = new Date();
  name = 'Auto Name Gene';
  ratio = 0.756;

  wide = true;
  get label() {
    return this.wide ? 'Table is wide' : 'Table is narrow';
  }
  toggle() {
    this.wide = !this.wide;
  }
}
