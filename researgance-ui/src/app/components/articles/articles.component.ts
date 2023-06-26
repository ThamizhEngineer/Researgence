import { Component, OnInit } from "@angular/core";
import { ActivatedRoute } from "@angular/router";
import { FacultiesService } from "../faculties/faculties.service";

@Component({
  selector: "app-articles",
  templateUrl: "./articles.component.html",
  styleUrls: ["./articles.component.scss"],
})
export class ArticlesComponent implements OnInit {
  id: any;
  articledata: any;
  art: any = [];
  row: any[];
  slNo: any;
  date: any;
  date1: any;
  constructor(
    private route: ActivatedRoute,
    private service: FacultiesService
  ) {}

  ngOnInit() {
    this.route.paramMap.subscribe((params) => {
      this.id = params.get("recordId");
      this.slNo = params.get("slNo");

      this.service .researcherPublicationDetails(this.slNo).subscribe((data: any) => {
          const dataArray = Object.values(data);
          console.log(dataArray);

          this.articledata = dataArray.filter(
            (item: any) => item.recordId == this.id
          );
          this.row = this.articledata.map((item) => item);
          console.log(this.row);

          //For split of Technologyareas & AuthorAffiliation
          for (let i = 0; i < this.row.length; i++) {
            this.row[i].technology_Areas = this.row[i].technology_Areas.split(";");
            this.row[i].authorAffiliation =this.row[i].authorAffiliation.split("|");
            
          }
        });

      this.date = new Date().toDateString();
    });
  }
}
