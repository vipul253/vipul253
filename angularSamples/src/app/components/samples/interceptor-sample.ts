import { HttpInterceptorFn, HttpRequest, HttpHandlerFn, HttpEvent } from '@angular/common/http';
import { Observable } from 'rxjs';

export const authInterceptor: HttpInterceptorFn = (req: HttpRequest<unknown>, next: HttpHandlerFn): Observable<HttpEvent<unknown>> => {
  // Clone request to set Authorization header (requests are immutable)
  const authReq = req.clone({
    setHeaders: { Authorization: `Bearer ${localStorage.getItem('token')}` }
  });
  return next(authReq); // Pass the request to the next handler
};