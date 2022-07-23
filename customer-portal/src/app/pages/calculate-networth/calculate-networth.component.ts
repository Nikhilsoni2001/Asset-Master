import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-calculate-networth',
  templateUrl: './calculate-networth.component.html',
  styleUrls: ['./calculate-networth.component.css'],
})
export class CalculateNetworthComponent implements OnInit {
  portfolioId = '';
  networth: number;
  constructor(private userService: UserService, private route: ActivatedRoute) {
    route.params.subscribe((val) => this.ngOnInit());
  }

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
