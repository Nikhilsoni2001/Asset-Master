import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

import endpointData from '../../assets/configuration/config.json';
import { Sell } from '../model/sell.model';

@Injectable({
  providedIn: 'root',
})
export class UserService {
  constructor(private http: HttpClient, private route: Router) {}

  // calling server to generate token
  generateToken(credentials) {
    let cred = {
      userid: credentials.username,
      upassword: credentials.password,
      authToken: '',
      uname: '',
    };
    return this.http.post(
      endpointData.authorizationServiceAPI + endpointData.loginURI,
      cred
    );
  }

  // To login the user
  loginUser(response) {
    localStorage.setItem('token', response.authToken);
    localStorage.setItem('portfolioId', response.userid);
    return true;
  }

  // To calculate the networth
  getNetWorth() {
    let id = this.getPortfolioId();
    if (id === null) {
      console.error('Please login again');
      return null;
    }

    return this.http.get(
      endpointData.netWorthAPI + endpointData.netWorthURI + '/' + id
    );
  }

  getAllAssets() {
    let id = this.getPortfolioId();
    if (id === null) {
      console.error('Please login again');
      return null;
    }
    return this.http.get(
      endpointData.netWorthAPI + endpointData.getAssetsURI + '/' + id
    );
  }

  // Sell stock
  sellAssets(sell: Sell) {
    const map1 = {};
    const map2 = {};
    sell.mfAssetList.forEach((val: number, key: string) => {
      map1[key] = val;
    });
    sell.stockIdList.forEach((val: number, key: string) => {
      map2[key] = val;
    });

    let obj = {
      pid: sell.pid,
      mfAssetList: map1,
      stockIdList: map2,
    };

    return this.http.post(
      endpointData.netWorthAPI + endpointData.sellAssetsURI,
      obj
    );
  }

  // To check whether the user is logged in or not
  isLoggedIn() {
    let token = this.getToken();
    if (token === undefined || token === '' || token === null) {
      return false;
    } else {
      return true;
    }
  }

  // To logout the user
  logout() {
    localStorage.removeItem('token');
    localStorage.removeItem('portfolioId');
    this.route.navigate(['/login']);
  }

  autoLogout() {
    setTimeout(() => {
      console.log('Hello from setTimeout');
    }, 1000);
  }

  // For getting the token
  getToken() {
    return localStorage.getItem('token');
  }

  getPortfolioId() {
    return localStorage.getItem('portfolioId');
  }
}
