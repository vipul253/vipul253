import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { FooterSample } from './components/samples/footer-sample';
import { HeaderSample } from './components/samples/header-sample';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, HeaderSample, FooterSample],
  templateUrl: './app.html',
  styleUrl: './app.css',
})
export class App {
  protected readonly title = signal('angularSamples');
}
