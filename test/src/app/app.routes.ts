import { Routes } from '@angular/router';

export const routes: Routes = [
    {
        path: '', pathMatch: 'full',
        loadComponent: () => import('./component/home/home').then(m => m.Home),
    },
    {
        path: 'home',
        loadComponent: () => import('./component/home/home').then(m => m.Home),
    },
    {
        path: 'firstpage',
        loadComponent: () => import('./component/firstpage/firstpage').then(m => m.Firstpage),

    },{
        path: 'secondpage',
        loadComponent: () => import('./component/secondpage/secondpage').then(m => m.Secondpage),

    }];
