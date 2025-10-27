import { Routes } from '@angular/router';

export const routes: Routes = [{
    path: '', pathMatch: 'full', loadComponent() {
        return import('./component/home/home').then(m => m.Home);
    },
}, {
    path: 'firstpage',pathMatch: 'full', loadComponent() {
        return import('./component/firstpage/firstpage').then(m => m.Firstpage);
    }
}];
