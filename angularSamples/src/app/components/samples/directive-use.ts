import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HighlightDirective } from '../../directives/highlight-directive';
@Component({
  selector: 'highlight-use-demo',
  standalone: true,
  imports: [CommonModule, HighlightDirective],
  styles: [
    `
      .box {
        padding: 10px;
        border: 1px dashed #bbb;
        border-radius: 6px;
      }
    `,
  ],
  template: `
    <h3>Attribute Directive (highlight)</h3>
    <p>Hover the first box to see the effect:</p>
    <div class="box" [highLight]="'lightyellow'">I get highlighted on hover</div>
    <div class="box" style="margin-top:8px">I do not</div>
  `,
})
export class HighlightUseDemo {}
