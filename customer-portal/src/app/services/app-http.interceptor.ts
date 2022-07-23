import {
  HttpErrorResponse,
  HttpEvent,
  HttpHandler,
  HttpInterceptor,
  HttpRequest,
} from '@angular/common/http';
import 'rxjs/add/operator/do';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';

@Injectable()
export class AppHttpInterceptor implements HttpInterceptor {
  constructor(private router: Router) {}
  headers = new Headers({
    'Content-Type': 'application/json',
    Token: localStorage.getItem('Token'),
  });
  intercept(
    req: HttpRequest<any>,
    next: HttpHandler
  ): Observable<HttpEvent<any>> {
    console.log('intercepted request ... ');

    // Clone the request to add the new header.
    const authReq = req.clone({
      headers: req.headers.set('token', localStorage.getItem('token')),
    });

    console.log('Sending request with new header now ...');

    //send the newly created request
    return next.handle(authReq).catch((err) => {
      // onError
      console.log(err);
      if (err instanceof HttpErrorResponse) {
        console.log(err.status);
        console.log(err.statusText);
        if (err.status === 401) {
          window.location.href = '/login';
        }
      }
      return Observable.throw(err);
    }) as any;
  }
}
