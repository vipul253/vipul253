import { Component } from '@angular/core';
// What is Null-Safe Navigation (?.)?
// ?. reads values that might be missing without throwing errors.
// If any segment is null or undefined, the result is undefined.
// Improves safety for deep property paths in templates.
// When to use Null-Safe Navigation?
// Async or optional data where properties may be absent.
// Use ?. (and optional chaining in code) over verbose checks.
// Combine with ?? to provide default values.
@Component({
  selector: 'null-safe-navigation',
  imports: [],
  template: `
    <h3>Null-Safe Navigation (?.)</h3>
    <button (click)="toggle()">Toggle user</button>
    <p>Email: {{ user?.profile?.email || '(none)' }}</p>
  `,
})
export class NullSafeNavigation {
  user: { profile?: { email?: string } } | undefined = undefined;
  toggle() {
    this.user = this.user ? undefined : { profile: { email: 'a@example.com' } };
  }
}
