import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'template-form-sample',
  standalone: true,
  imports: [CommonModule, FormsModule],
  template: `
    <h3>Sample Form and Validation</h3>
    <form #f="ngForm" (ngSubmit)="onSubmit()">
      <label>
        Name:
        <input name="name" [(ngModel)]="user.name" required minlength="3" #name="ngModel" />
      </label>
      @if (name.invalid && (name.dirty || name.touched || submitted)) {
        <div style="color:crimson">
          @if (name.errors && name.errors['required']) {
            <small>Name is required</small>
          } @else if (name.errors && name.errors['minlength']) {
            <small>Name must be at least 3 characters</small>
          }
        </div>
      }

      <label>
        Email:
        <input name="email" [(ngModel)]="user.email" email required #emal="ngModel" />
      </label>
      @if (emal.invalid && (emal.dirty || emal.touched || submitted)) {
        <div style="color:crimson">
          @if (emal.errors && emal.errors['required']) {
            <small>Email is required</small>
          } @else if (emal.errors && emal.errors['email']) {
            <small>Email must be valid</small>
          }
        </div>
      }
      <button type="submit" [disabled]="f.invalid">Submit</button>
    </form>

    @if (submitted) {
      <p>Submitted: {{ user | json }}</p>
    }

    <h3>HTML Form Elements</h3>
    <form #f1="ngForm" (ngSubmit)="onSubmitElements()">
      <!-- name="elementName" is only needed in template forms and in case ngModel is used -->
      <label> Email:<input name="email" type="email" [(ngModel)]="model.email" /></label>

      <label><input type="checkbox" name="agree" [(ngModel)]="model.agree" /> Agree</label>

      @for (color of colors; track color) {
        <div>
          <label>
            <input type="checkbox" [value]="color.value" (change)="onCheckboxChange($event)" />
            {{ color.name }}
          </label>
        </div>
      }

      <label><input type="radio" name="color" [value]="'red'" [(ngModel)]="model.color" /> Red</label>
      <label><input type="radio" name="color" [value]="'blue'" [(ngModel)]="model.color" /> Blue</label>
      <br />
      <!-- value will be string maybe need to check -->
      <label><input type="radio" name="size" [value]="1" [(ngModel)]="model.size" /> Small</label>
      <label><input type="radio" name="size" [value]="2" [(ngModel)]="model.size" /> Medium</label>
      <br />

      <!--Add multiple and bind to an array; use [ngValue] for non-strings.-->
      <select size="2" name="tags" [(ngModel)]="model.tags" multiple>
        <option [ngValue]="'news'">News</option>
        <option [ngValue]="'tech'">Tech</option>
        <option [ngValue]="'sports'">Sports</option>
      </select>
      <br />
      <!-- Template-driven binds values as strings; 
           convert in code if you need numbers -->
      <input type="number" name="age" [ngModel]="age" (ngModelChange)="age = $any($event)" />
      <br />
      <!--Read files with a (change) handler; do not two-way bind files-->
      <input type="file" multiple (change)="onFiles($event)" />
      <!--Use [compareWith] when options are objects that may be re-created across renders.-->
      <br />
      <select name="pet" [(ngModel)]="model.pet" [compareWith]="byId">
        <option [ngValue]="{ id: 1, name: 'Cat' }">Cat</option>
        <option [ngValue]="{ id: 2, name: 'Dog' }">Dog</option>
      </select>
      <br />
      <label> Bio:<textarea name="bio" [(ngModel)]="model.bio"></textarea></label>
      <br />
      <button type="submit" [disabled]="f1.invalid">Submit</button>
    </form>
    @if (submittedElements) {
      <p>Submitted: {{ model | json }}</p>
    }
  `,
})
export class TemplateFormSample {
  name = '';
  age = 0;
  user = { name: '', email: '' };
  model = { name: '', email: '', bio: '', agree: false, color: '', size: '', tags: [], pet: '' };
  byId = (a: any, b: any) => a?.id === b?.id;
  submitted = false;
  submittedElements = false;
  onSubmit() {
    this.submitted = true;
  }
  onSubmitElements() {
    this.submittedElements = true;
  }
  onFiles(e: Event) {
    console.log((e?.target as HTMLInputElement)?.value);
  }

  // Data source for the checkboxes
  colors = [
    { id: 1, name: 'Red', value: 'red' },
    { id: 2, name: 'Blue', value: 'blue' },
    { id: 3, name: 'Green', value: 'green' },
  ];

  // Array to store the values of selected checkboxes
  public selectedColorValues: string[] = [];

  // Method to handle the change event for each checkbox
  onCheckboxChange(event: any) {
    const value = event.target.value;
    if (event.target.checked) {
      // Add the value if checked
      this.selectedColorValues.push(value);
    } else {
      // Remove the value if unchecked
      const index = this.selectedColorValues.indexOf(value);
      if (index !== -1) {
        this.selectedColorValues.splice(index, 1);
      }
    }
  }
}
