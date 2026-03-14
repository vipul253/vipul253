import { Component, inject, signal } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpSampleService } from '../../services/http-service-sample';

@Component({
  selector: 'http-sample',
  standalone: true,
  imports: [CommonModule],
  providers:[HttpSampleService],
  template: `
    <h3>HttpClient</h3>
    <button class="btn btn-primary" (click)="fetchData()">Load Users</button>
    @if (this.httpSvc.loading()) {
      <div class="d-flex justify-content-center">
        <div class="spinner-border" role="status"></div>
      </div>
    }
    @if (this.httpSvc.error() != '') {
      <p style="color:crimson">{{ this.httpSvc.error() }}</p>
    }
    @if (this.httpSvc.data()) {
      <h3>Fetched Data:</h3>
      <ul class="list-group">
        @for (u of this.httpSvc.data(); track u.id) {
          <li class="list-group-item">{{ u.name }} | ({{ u.email }})</li>
        }
      </ul>
    }
  `,
})
export class HttpSample {
  public httpSvc = inject(HttpSampleService);
  fetchData(): void {
    this.httpSvc.fetchDataManually(); // Call the service method on click
  }
}
