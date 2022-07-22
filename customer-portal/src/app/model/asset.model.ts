export class Asset {
  constructor(
    public assetid: string,
    public portfolioid: string,
    public tid: number,
    public type: string,
    public units: number,
    public checked: boolean = false
  ) {}
}
