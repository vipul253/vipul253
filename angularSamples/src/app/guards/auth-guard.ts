import { inject } from '@angular/core';
import { CanActivateFn, Router } from '@angular/router';
import { AuthService } from '../services/auth-service';

export const authGuardGlobal: CanActivateFn = (route, state) => {
  const authService = inject(AuthService);
  const router = inject(Router);

  if (!authService.isLoggedIn()) {
     // Redirect to the login page and potentially save the attempted URL as a query param
    authService.redirectUrl = state.url; // Optional: store the intended URL to redirect after login
    router.navigate(['/login'], { queryParams: { returnUrl: state.url } });
    return false; // Block navigation
  }
  return true; // Allow navigation
};
