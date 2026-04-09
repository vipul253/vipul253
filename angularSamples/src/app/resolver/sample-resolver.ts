import { inject } from '@angular/core';
import { ResolveFn } from '@angular/router';
import { CounterService } from '../services/service-sample';

export const sampleResolver: ResolveFn<any> = (route, state) => {
  // Extract route parameters if needed
  const userId = route.paramMap.get('id');
  // Inject service and return data (Observable or Promise)
  const svc = inject(CounterService);
  svc.inc();// this just increments every time route is accessed to demonstrate the change
  return svc.getValue();
};
