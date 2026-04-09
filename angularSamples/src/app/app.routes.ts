import { Routes } from '@angular/router';
import { HomeSample } from './components/samples/home-sample';
import { AboutSample } from './components/samples/about-sample';
import { Product } from './components/samples/product-cmp';
import { authGuard } from './components/samples/route-guard-sample';
import { authGuardGlobal } from './guards/auth-guard';
import { sampleResolver } from './resolver/sample-resolver';

export const routes: Routes = [
  // Public route for login (no guard applied)
  { path: 'login', component: HomeSample }, //LoginComponent },
  {
    path: 'tempPath',
    canActivate: [authGuardGlobal], // Apply the guard to this parent route
    children: [
      //here internal child routes now check authGuardGlobal
    ],
  },
  {
    path: '',
    pathMatch: 'full',
    component: HomeSample,
  },
  {
    path: 'home',
    component: HomeSample,
  },
  {
    path: 'about',
    component: AboutSample,
    canActivate: [authGuard],
  },
  {
    path: 'product/:id',
    component: Product,
    resolve: { data: sampleResolver } // 'data' is the key to access data later
  },
  {
    path: 'cardnav',
    loadComponent: () => import('./components/samples/card-nav-sample').then((m) => m.CardNavSample),
  },
  {
    path: 'nsafenav',
    loadComponent: () =>
      import('./components/samples/null-safe-navigation').then((m) => m.NullSafeNavigation),
  },
  {
    path: 'ntempout',
    loadComponent: () => import('./components/samples/template-outlet').then((m) => m.TemplateOutletSample),
  },
  {
    path: 'nbuiltinpipe',
    loadComponent: () => import('./components/samples/builtin-pipes').then((m) => m.TemplatePipesSample),
  },
  {
    path: 'nforbidname',
    loadComponent: () => import('./components/samples/directive-sample').then((m) => m.DirectiveSample),
  },
  {
    path: 'nhighlight',
    loadComponent: () => import('./components/samples/directive-use').then((m) => m.HighlightUseDemo),
  },
  {
    path: 'neventbind',
    loadComponent: () => import('./components/samples/event-binding').then((m) => m.EventBindingSample),
  },
  {
    path: 'nlifecycle',
    loadComponent: () => import('./components/samples/life-cycle-hooks').then((m) => m.LifeCycleHooksSample),
  },
  {
    path: 'nlisting',
    loadComponent: () => import('./components/samples/list-sample').then((m) => m.ListSample),
  },
  {
    path: 'nreactform',
    loadComponent: () =>
      import('./components/samples/reactive-form-sample').then((m) => m.ReactiveFormSample),
  },
  {
    path: 'nsignal',
    loadComponent: () => import('./components/samples/signal-sample').then((m) => m.SignalSample),
  },
  {
    path: 'ntempform',
    loadComponent: () =>
      import('./components/samples/template-form-sample').then((m) => m.TemplateFormSample),
  },
  {
    path: 'nrouteparam',
    loadComponent: () => import('./components/samples/route-param-sample').then((m) => m.RouteParamSample),
  },
  {
    path: 'nguardsample',
    loadComponent: () => import('./components/samples/route-guard-sample').then((m) => m.RouteGuardSample),
  },
  {
    path: 'nservicesample',
    loadComponent: () => import('./components/samples/service-sample-demo').then((m) => m.ServiceSampleDemo),
  },
  {
    path: 'nhttpsample',
    loadComponent: () => import('./components/samples/http-sample').then((m) => m.HttpSample),
  },
  {
    path: 'nasyncpipe',
    loadComponent: () => import('./components/samples/async-pipe-sample').then((m) => m.AsyncPipeSample),
  },
  {
    path: 'ncustompipe',
    loadComponent: () => import('./components/samples/custom-pipe-sample').then((m) => m.CustomPipeSample),
  },
  {
    path: 'ninoutput',
    loadComponent: () => import('./components/samples/input-output-sample').then((m) => m.ParentSample),
  },
  {
    path: 'nuploadsample',
    loadComponent: () => import('./components/samples/file-upload-sample').then((m) => m.FileUploadSample),
  },
];
