import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { inject, Injectable, signal } from '@angular/core';
import { catchError, finalize, Observable, throwError } from 'rxjs';

@Injectable()
export class HttpSampleService {
  private http = inject(HttpClient);
  private apiUrl = 'https://jsonplaceholder.typicode.com/users';

  // Signals for state management
  public data = signal<any>(null);
  public loading = signal(false);
  public error = signal<string | null>(null);

  fetchDataManually(): void {
    this.loading.set(true);
    this.error.set(null); // Clear previous errors

    this.http
      .get<any>(this.apiUrl)
      .pipe(
        catchError(this.handleError),
        finalize(() => this.loading.set(false)),
      )
      .subscribe({
        next: (response) => {
          this.data.set(response); // Update the signal
        },
        error: (err) => {
          console.log(err);
          this.error.set('Failed to load data. Please try again.'); // Set user-friendly error message
        },
      });
  }

  private handleError(error: HttpErrorResponse): Observable<never> {
    console.error('An error occurred:', error); // Log the error details
    // Return an observable with a user-facing error message
    return throwError(() => new Error('Something bad happened; please try again later.'));
  }
}
