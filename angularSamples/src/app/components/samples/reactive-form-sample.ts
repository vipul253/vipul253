import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'reactive-form-sample',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  template: `
    <h3>Reactive Forms</h3>
    <form [formGroup]="form" (ngSubmit)="onSubmit()">
      <label>
        Name
        <input formControlName="name" placeholder="Your name" />
      </label>
      @if (
        form.controls.name.invalid && (form.controls.name.dirty || form.controls.name.touched || submitted)
      ) {
        <div style="color:crimson">
          @if (form.controls.name.errors && form.controls.name.errors['required']) {
            <small>Name is required</small>
          } @else if (form.controls.name.errors && form.controls.name.errors['minlength']) {
            <small>Name must be at least 3 characters</small>
          }
        </div>
      }

      <label>
        Email
        <input formControlName="email" placeholder="you@example.com" />
      </label>
      @if (
        form.controls.email.invalid && (form.controls.email.dirty || form.controls.email.touched || submitted)
      ) {
        <div style="color:crimson">
          @if (form.controls.email.errors && form.controls.email.errors['required']) {
            <small>Email is required</small>
          } @else if (form.controls.email.errors && form.controls.email.errors['email']) {
            <small>Email must be valid</small>
          }
        </div>
      }

      <label>
        <input type="checkbox" formControlName="newsletter" />
        Subscribe to newsletter
      </label>

      <button type="submit" [disabled]="form.invalid">Submit</button>
    </form>

    <p>Status: {{ form.status }}</p>
    <p>Value: {{ form.value | json }}</p>
    @if (submitted) {
      <p style="color: seagreen;">Submitted!</p>
    }
  `,
})
export class ReactiveFormSample {
  fb = new FormBuilder();
  submitted = false;
  form = this.fb.group({
    name: ['', [Validators.required, Validators.minLength(3)]],
    email: ['', [Validators.required, Validators.email]],
    newsletter: [false],
  });

  onSubmit() {
    this.submitted = true;
  }
}
