import { Component, Input, OnInit, ViewEncapsulation } from "@angular/core";
import {
  doughnutData,
  vertical_stack_chart,
  multiData,
} from "../../shared/data/dashboard/project";
import * as graphoptions from "../../shared/data/dashboard/project";
import * as chartData from "../../shared/data/chart/chartist";
import { dashboardModel } from "src/app/shared/model/data.models";
import { FacultiesService } from "../faculties/faculties.service";
import { ActivatedRoute, Router } from "@angular/router";
import { CommonsearchService } from "src/app/shared/services/commonsearch.service";
import { generate } from "rxjs";

@Component({
  selector: "app-dashboard",
  templateUrl: "./dashboard.component.html",
  styleUrls: ["./../../../assets/given/selected.css"],
  encapsulation: ViewEncapsulation.None,
})
export class DashboardComponent implements OnInit {
  @Input() startValue: number = 0;
  @Input() max: number;
  counter: number = 0;
  totalCount: number = 0;
  private timer: any;
  models: any;
  public doughnutData = doughnutData;
  public active1 = 1;
  public vertical_stack_chart = vertical_stack_chart;

  public chart7 = chartData.chart7;
  searchboxfilter: string;

  constructor(
    private route: Router,
    private service: FacultiesService,
    private search: CommonsearchService,
    private routes: ActivatedRoute
  ) {
    Object.assign(this, { doughnutData, vertical_stack_chart, multiData });
  }

  // doughnut
  public view = graphoptions.view;
  public doughnutChartColorScheme = graphoptions.doughnutChartcolorScheme;
  public doughnutChartShowLabels = graphoptions.doughnutChartShowLabels;
  public doughnutChartGradient = graphoptions.doughnutChartGradient;

  //vertical_stack_chart
  public verticalStackChartColorScheme = graphoptions.colorScheme;
  public verticalStackChartshowXAxis = graphoptions.showXAxis;
  public verticalStackChartshowYAxis = graphoptions.showYAxis;
  public verticalStackChartgradient = graphoptions.gradient;
  public verticalStackChartshowLegend = graphoptions.showLegend;
  public verticalStackChartshowXAxisLabel = graphoptions.showXAxisLabel;
  public verticalStackChartshowYAxisLabel = graphoptions.showYAxisLabel;

  public chart1 = graphoptions.chart1;
  public chart2 = graphoptions.chart2;
  public chart3 = graphoptions.chart3;
  public chart4 = graphoptions.chart4;
  public chart5 = graphoptions.chart5;
  public chart6 = graphoptions.chart6;

  public pieChart1 = graphoptions.pieChart1;
  public barChartSingle1 = graphoptions.barChartSingle1;
  public barChartSingle2 = graphoptions.barChartSingle2;
  public barChartSingle3 = graphoptions.barChartSingle3;

  filteredItems: any;
  counterMap = {
    Publications: 0,
    Faculty: 0,
    "Consultancy Projects": 0,
    EDP: 0,
    "Sponsored Projects": 0,
  };
  ngOnInit() {
    this.service.GetDashboard().subscribe((x) => {
      this.models = x;
      this.filteredItems = this.models;

      console.log(x);
       this.generate();
       console.log( this.generate())
       console.log( this.generate())
       console.log( this.generate())
       console.log( this.generate())
       console.log( this.generate())


       this.routes.fragment.subscribe(fragment => {
        if (fragment === 'Tab12') {
          this.openScholarSection();
        } else if (fragment === 'Tab13') {
          this.openSponsoredSection();
        }
      });
      for (let val of this.filteredItems) {
        if (val.moduleName == "Publications") {
          this.totalCount = val.totalCount;
          console.log(this.totalCount);
        }
        if (val.moduleName == "Faculty") {
          this.totalCount = val.totalCount;
          console.log(this.totalCount);
        }
        if (val.moduleName == "Consultancy Projects") {
          this.totalCount = val.totalCount;
          console.log(this.totalCount);
        }

      
      }

      // Set the initial value of the counter to the total count
      this.startTimer();
    });

    //For global search filter in dashboard
    this.search.getSearchQuery().subscribe((query) => {
      this.filteredItems = this.models?.filter((item) =>
        item.moduleName.toLowerCase().includes(query.toLowerCase())
      );
    });
  }

  openScholarSection() {
    const element = document.getElementById('scholar-section');
    element.scrollIntoView({ behavior: 'smooth' });
  }

  openSponsoredSection() {
    const element = document.getElementById('sponsored-section');
    element.scrollIntoView({ behavior: 'smooth' });
  }
  ngOnDestroy(): void {
    this.stopTimer();
  }

  private startTimer(): void {
    // Loop through each module in filteredItems

    this.filteredItems.forEach((module) => {
      const maxForModule = module.totalCount; // Set the maximum value of the counter to the totalCount of the module

      const moduleName = module.moduleName;

      // Use setInterval to increment the counter by 1 every 10 milliseconds

      const timer = setInterval(() => {
        this.counterMap[moduleName]++;

        // Check if the counter has reached the maximum value for the current module

        if (this.counterMap[moduleName] === maxForModule) {
          clearInterval(timer); // Clear the interval for the current module
        }
      }, 10);
    });
  }

  private stopTimer(): void {
    clearInterval(this.timer);
  }

  generate(){
    var digits = '0123456789';
    let OTP ='';
    for (let i=0;i<6;i++){
      OTP += digits[Math.floor(Math.random()*10)];

    }
    return OTP;
  }
}











