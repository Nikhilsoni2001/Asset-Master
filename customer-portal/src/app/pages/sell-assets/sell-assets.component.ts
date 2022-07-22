import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Asset } from 'src/app/model/asset.model';
import { Sell } from 'src/app/model/sell.model';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-sell-assets',
  templateUrl: './sell-assets.component.html',
  styleUrls: ['./sell-assets.component.css'],
})
export class SellAssetsComponent implements OnInit {
  name = 'Nikhil';
  dataSource: Array<Asset> = [];

  displayedColumns: string[] = ['name', 'units'];

  constructor(private userService: UserService, private route: Router) {}

  // ngOnInit(): void {
  //   this.userService.getAllAssets().subscribe(
  //     (response: Array<any>) => {
  //       // response.map((res) => {
  //       //   console.log(res);
  //       //   this.dataSource.push(
  //       //     new Asset(
  //       //       res.assetid,
  //       //       res.portfolioid,
  //       //       res.tid,
  //       //       res.type,
  //       //       res.units,
  //       //       false
  //       //     )
  //       //   );
  //       // });
  //       response.map((res) => {
  //         res.selected = false;
  //         console.log(res);
  //       });
  //       this.dataSource = response;
  //       console.log(this.dataSource);
  //     },
  //     (error) => {
  //       console.error(error);
  //     }
  //   );
  // }

  ngOnInit(): void {
    this.userService.getAllAssets().subscribe(
      (response: Array<any>) => {
        response.map((res) => {
          res.checked = false;
        });
        this.dataSource = response;
        console.log(this.dataSource);
      },
      (error) => {
        console.error(error);
      }
    );
  }

  sellAssets() {
    let sell = new Sell();
    this.dataSource.forEach((data) => {
      if (data.checked === true) {
        if (data.type === 'MF') {
          sell.mfAssetList.set(data.assetid, data.units);
        } else {
          sell.stockIdList.set(data.assetid, data.units);
        }
      }
    });
    let id = this.dataSource[0].portfolioid;
    sell.pid = +id;

    this.userService.sellAssets(sell).subscribe(
      (response) => {
        console.log(response);
      },
      (error) => {
        console.log(error);
      }
    );

    this.route.navigate(['/calculate-networth']);
  }
}
