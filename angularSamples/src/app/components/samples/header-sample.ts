import { Component } from '@angular/core';
import { RouterLink, RouterLinkActive } from '@angular/router';
@Component({
  selector: 'app-header',
  imports: [RouterLink, RouterLinkActive],
  template: `<nav class="navbar navbar-expand-lg bg-body-tertiary">
    <div class="container-fluid justify-content-center">
      <a class="navbar-brand" routerLink="/" routerLinkActive="active" [routerLinkActiveOptions]="{ exact: true }">Angular Demo</a>
      <button
        class="navbar-toggler"
        type="button"
        data-bs-toggle="collapse"
        data-bs-target="#navbarNav"
        aria-controls="navbarNav"
        aria-expanded="false"
        aria-label="Toggle navigation"
      >
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse flex-grow-0" id="navbarNav">
        <ul class="navbar-nav text-center">
          <li class="nav-item">
            <a class="nav-link" routerLink="/home" routerLinkActive="active">Home</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" routerLink="/cardnav" routerLinkActive="active">Samples</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" routerLink="/about" routerLinkActive="active">About</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" aria-disabled="true">Disabled</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>`,
})
export class HeaderSample {}
