import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  constructor(private router: Router) {}
  redirectUrl: string = '';
  // Example: Check for a token in local storage
  isLoggedIn(): boolean {
    const token = localStorage.getItem('token');
    return !!token; // Returns true if token exists, false otherwise
  }

  // Example: Login method (set the token)
  login(username: string, password: string): void {
    // Add your actual authentication logic (e.g., API call) here
    if (username === 'test' && password === 'password') {
      localStorage.setItem('token', 'fake-jwt-token'); // Store the token
    }
  }

  // Example: Logout method (remove the token)
  logout(): void {
    localStorage.removeItem('token');
    this.router.navigate(['/login']); // Redirect to login after logout
  }
}
