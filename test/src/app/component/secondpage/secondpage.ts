import { Component, inject } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { Firstservice } from '../../services/firstservice';

@Component({
  selector: 'app-secondpage',
  imports: [ReactiveFormsModule],
  templateUrl: './secondpage.html',
  styleUrl: './secondpage.css'
})
export class Secondpage {

  firstService = inject(Firstservice);
  profileForm = new FormGroup({
    name: new FormControl(''),
    email: new FormControl(''),
  });

  addData() {
    if (this.profileForm.value.name == '' || this.profileForm.value.email == '') {
      alert("Please fill all fields");
    } else {
      this.firstService.addUsers(this.profileForm.value.name!, this.profileForm.value.email!);
    }
  }

}
