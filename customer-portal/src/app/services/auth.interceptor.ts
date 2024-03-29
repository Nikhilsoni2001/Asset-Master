import {
  HttpEvent,
  HttpHandler,
  HttpInterceptor,
  HttpRequest,
} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { UserService } from './user.service';

@Injectable()
export class AuthInterceptor implements HttpInterceptor {
  constructor(private userService: UserService) {}
  intercept(
    req: HttpRequest<any>,
    next: HttpHandler
  ): Observable<HttpEvent<any>> {
    let newRequest = req;
    let token = this.userService.getToken();
    console.log('INTERCEPTOR', token);

    if (token != null) {
      newRequest = newRequest.clone({
        setHeaders: { Authorization: `Bearer ${token}` },
      });
    }
    return next.handle(newRequest);
  }
}
