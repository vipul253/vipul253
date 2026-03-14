import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';
@Component({
  selector: 'app-footer',
  imports: [RouterLink],
  template: `
    <div class="container">
      <div class="row">
        <div class="col-md-4">
          <h5>[Company Name]</h5>
          <p>Providing services since [Year].</p>
        </div>
        <div class="col-md-4">
          <h5>Links</h5>
          <ul class="list-unstyled">
            <li><a routerLink="/about" class="text-white">About Us</a></li>
            <li><a routerLink="" class="text-white">Contact</a></li>
            <li><a routerLink="" class="text-white">Privacy Policy</a></li>
          </ul>
        </div>
        <div class="col-md-4">
          <h5>Connect</h5>
          <a href="#" class="text-white me-2">Facebook</a>
          <a href="#" class="text-white">Twitter</a>
        </div>
      </div>
      <div class="text-center mt-3">
        <p>&copy; 2026 [Company Name]. All rights reserved.</p>
      </div>
    </div>
  `,
})
export class FooterSample {}
