import { Component, inject } from '@angular/core';
import { Router, RouterLink } from '@angular/router';

let loggedIn = false; //sort of global

export const authGuard = () => {
  if (loggedIn) return true;
  const router = inject(Router);
  //redirect if loggedIn false
  console.log('redirected back');
  return router.navigate(['/nguardsample']);
};

@Component({
  selector: 'route-guard-sample',
  standalone: true,
  imports: [RouterLink],
  styles: [
    `
      nav a {
        margin-right: 8px;
        text-decoration: none;
      }
      .status {
        margin-left: 8px;
        font-weight: 600;
      }
    `,
  ],
  template: `
    <h3>Route Guard (canActivate)</h3>
    <div class="toolbar">
      <button (click)="toggle()">{{ loggedIn ? 'Log out' : 'Log in' }}</button>
      <span class="status">Status: {{ loggedIn ? 'Logged in' : 'Logged out' }}</span>
    </div>
    <nav>
      <a routerLink="/nguardsample">Home</a>
      <a routerLink="/about">Protected</a>
    </nav>
  `,
})
export class RouteGuardSample {
  get loggedIn() {
    return loggedIn;
  }
  toggle() {
    loggedIn = !loggedIn;
  }
}
