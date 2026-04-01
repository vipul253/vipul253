import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { catchError, forkJoin, Observable, of } from 'rxjs';

export class User {
  constructor(id: number, name: string) {}
}
@Component({
  selector: 'fork-join-sample',
  template: ` <div class="container"></div> `,
})
export class ForkJoinSample {
  user: any;
  prefs: any;
  billing: any;

  constructor(private http: HttpClient) {}

  loadDashboardData() {
    // Pass a dictionary/object of sources for cleaner destructuring
    forkJoin({
      // here getUsers handles error internally so it wont break whole forkjoin
      user: this.getUsers(1), //this.http.get('/api/user'),
      prefs: this.http.get('/api/prefs'),
      billing: this.http.get('/api/billing'),
    }).subscribe({
      next: ({ user, prefs, billing }) => {
        // Destructure the object in the subscribe callback
        this.user = user;
        this.prefs = prefs;
        this.billing = billing;
        console.log('All data loaded successfully');
      },
      error: (err) => {
        console.error('An error occurred during one of the requests:', err);
      },
      complete: () => console.log('All requests completed.'),
    });
  }
  // A service method that might fail, returning an Observable
  getUsers(id: number): Observable<User[]> {
    return this.http.get<User[]>(`api/users/${id}`).pipe(
      // Place catchError inside the inner observable's pipe
      catchError((error) => {
        console.error('Error fetching user data for ID:', id, error);
        // Return a new Observable as a fallback value (e.g., an empty array)
        return of([]);
        // or return EMPTY if you want no value emitted and the inner observable to complete silently
        // return EMPTY;
        // or use throwError to rethrow the error to the outer observable (terminating the stream)
        // return throwError(() => new Error('Custom error message'));
      }),
    );
  }
}
