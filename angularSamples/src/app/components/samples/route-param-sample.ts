import { Component } from '@angular/core';
import { RouterLink, RouterLinkActive, RouterOutlet } from '@angular/router';
@Component({
  selector: 'route-param-sample',
  standalone: true,
  imports: [RouterOutlet, RouterLink, RouterLinkActive],
  template: `
    <h3>Router Params</h3>
    <nav>
      <a routerLink="/product/1" routerLinkActive="active">Product 1</a> |
      <a routerLink="/product/2" routerLinkActive="active">Product 2</a>
    </nav>
    <router-outlet></router-outlet>
  `,
  styles: [
    `
      nav a {
        margin-right: 6px;
      }
      .active {
        font-weight: bold;
      }
    `,
  ],
})
export class RouteParamSample {}
