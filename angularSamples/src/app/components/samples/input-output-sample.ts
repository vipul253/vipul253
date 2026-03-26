import { Component, EventEmitter, Input, Output, SimpleChanges } from '@angular/core';

@Component({
  selector: 'child-sample',
  template: `
    <br />
    <label>Child received: {{ text }}</label
    ><br />
    <label
      >Text in Child: <input #iChild (input)="localInputValue = iChild.value" placeholder="Type here..."
    /></label>
    <button (click)="update()">Send Local Value To Parent</button>
  `,
})
export class ChildSample {
  @Input() text = '';
  @Output() dataToParent = new EventEmitter<string>();
  localInputValue = '';
  update() {
    this.dataToParent.emit(this.localInputValue);
  }
}

@Component({
  selector: 'parent-sample',
  imports: [ChildSample],
  template: `<h1>Lifecycle</h1>
    <label>Text in Parent: <input #iParent (input)="text = iParent.value" placeholder="Type here..." /></label
    ><br />
    <label>Text given by Child: {{ textFromChild }} </label><br />
    <child-sample [text]="text" (dataToParent)="handleValueFromChild($event)"></child-sample>`,
})
export class ParentSample {
  text = '';
  textFromChild = '';
  handleValueFromChild(childText: string) {
    this.textFromChild = childText;
  }
}
