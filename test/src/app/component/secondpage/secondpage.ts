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
  resp: String = "";
  profileForm = new FormGroup({
    name: new FormControl(''),
    email: new FormControl(''),
  });

  addData() {
    if (this.profileForm.value.name == '' || this.profileForm.value.email == '') {
      alert("Please fill all fields");
      return;
    } else {
      this.resp = this.firstService.addUsers(this.profileForm.value.name!, this.profileForm.value.email!);
      alert(this.resp);
    }
  }

}
