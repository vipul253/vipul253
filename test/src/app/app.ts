import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { FormsModule } from '@angular/forms';

import { Header } from './component/header/header';
import { Navigator } from "./component/navigator/navigator";

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, FormsModule, Header, Navigator],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('test');
}
