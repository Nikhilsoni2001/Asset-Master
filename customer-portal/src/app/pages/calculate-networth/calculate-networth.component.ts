import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-calculate-networth',
  templateUrl: './calculate-networth.component.html',
  styleUrls: ['./calculate-networth.component.css'],
})
export class CalculateNetworthComponent implements OnInit {
  portfolioId = '';
  networth: number;
  constructor(private userService: UserService) {}

  ngOnInit(): void {
    this.portfolioId = this.userService.getPortfolioId();
    this.userService.getNetWorth().subscribe(
      (response) => {
        this.networth = +response;
      },
      (error) => {
        console.log('ERR', error);
      }
    );
  }
}
