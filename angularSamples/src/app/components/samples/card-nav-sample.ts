import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';
import { CardComponent } from './card';

@Component({
  selector: 'app-card-nav',
  imports: [RouterLink, CardComponent],
  styles: [
    `
      .card-container {
        padding: 10px;
      }
      .card-container div {
        padding: 5px;
        text-align: center;
      }
    `,
  ],
  templateUrl: './html/card-nav-sample.html',
})
export class CardNavSample {}
