import { Component } from '@angular/core';
import { ForbiddenNameDirective } from '../../directives/forbidden-name';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'directive-sample',
  imports: [FormsModule, ForbiddenNameDirective],
  template: `<form #myForm="ngForm">
    <label for="name">Name:</label>
    <!-- Apply the directive as an attribute with a dynamic value -->
    <input
      type="text"
      id="name"
      name="name"
      [(ngModel)]="nameSample"
      [forbiddenName]="invalidNames"
      #nameField="ngModel"
      required
    />
    <!-- Display error message -->
    @if (nameField.invalid && nameField.touched) {
      <div class="error">
        @if (nameField.errors?.['required']) {
          <span> Name is required </span>
        }
        @if (nameField.errors?.['invalidName']) {
          <span> Name cannot be {{ nameSample }} </span>
        }
      </div>
    }
  </form>`,
})
export class DirectiveSample {
  invalidNames = ['alice', 'bob', 'charlie'];
  nameSample = '';
}
