import { Directive, Input } from '@angular/core';
import { NG_VALIDATORS, Validator, AbstractControl, ValidationErrors, ValidatorFn } from '@angular/forms';

/**
 * A validator that checks if the control's value is in a list of allowed names.
 * @param allowedNames The array of names to check against.
 * @returns A validator function.
 */
function allowedNameValidator(allowedNames: string[]): ValidatorFn {
  // return (control: AbstractControl): ValidationErrors | null => {
  //   const forbidden = nameRe.test(control.value);
  //   return forbidden ? { forbiddenName: { value: control.value } } : null;
  // };
  return (control: AbstractControl): ValidationErrors | null => {
    const name: string = control.value;
    // Check if the entered name is in the allowedNames array
    const isValid = allowedNames.includes(name?.toLowerCase());
    // Return an error object if invalid, otherwise null
    return isValid ? { invalidName: { value: name, allowedValues: allowedNames } } : null;
  };
}

@Directive({
  selector: '[forbiddenName]',
  standalone: true, // Use standalone for modern Angular
  providers: [
    {
      provide: NG_VALIDATORS,
      useExisting: ForbiddenNameDirective, // Use the existing instance of the directive
      multi: true, // Allows multiple validators to be applied to the same control
    },
  ],
})
export class ForbiddenNameDirective implements Validator {
  //@Input('forbiddenName') forbiddenName: '';
  @Input() forbiddenName: string[] = []; // Input to make the validator dynamic

  validate(control: AbstractControl): ValidationErrors | null {
    //return this.forbiddenName ? forbiddenNameValidator(new RegExp(this.forbiddenName, 'i'))(control) : null;
    return this.forbiddenName ? allowedNameValidator(this.forbiddenName)(control) : null;
  }
}
