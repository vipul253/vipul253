import { Component } from '@angular/core';
import { CardComponent } from './card';
@Component({
  selector: 'content-use',
  imports: [CardComponent],
  template: `
    <h3>Content Projection (ng-content)</h3>

    <w3-card>
      <span card-title>Welcome</span>
      <p>Project any markup into a reusable shell component.</p>
    </w3-card>

    <br>

    <w3-card>
      <span card-title>Another Card</span>
      <ul>
        <li>Works with lists</li>
        <li>Images, buttons, etc.</li>
      </ul>
    </w3-card>
  `
})
export class ContentUseSample {}