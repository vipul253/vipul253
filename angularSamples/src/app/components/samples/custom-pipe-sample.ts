import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { TitleCase2Pipe } from '../../pipes/pipe-sample';

@Component({
  selector: 'custom-pipe-sample',
  standalone: true,
  imports: [CommonModule, FormsModule, TitleCase2Pipe],
  template: `
    <h3>Custom Pipe</h3>
    <label> Text: <input [(ngModel)]="text" placeholder="type here" /> </label>
    <p>Original: {{ text }}</p>
    <p>TitleCase2: {{ text | titlecase2 }}</p>
  `,
})
export class CustomPipeSample {
  text = 'hello angular pipes';
}
