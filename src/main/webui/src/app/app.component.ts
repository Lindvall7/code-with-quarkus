import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {StartPageComponent} from "./start/start-page.component";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, StartPageComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'webui';
}
