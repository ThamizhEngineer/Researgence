import { Component, ElementRef, OnInit, Renderer2, ViewChild } from '@angular/core';
import { ScorebookService } from './../scorebook.service';

@Component({
  selector: 'app-scorebook',
  templateUrl: './scorebook.component.html',
  styleUrls: [ './scorebook.component.scss','./../../../../assets/given/css/style.css', './../../../../assets/given/css/bootstrap.min.css']
})
export class ScorebookComponent implements OnInit {

    scorebookData:any=[];
    scorebookNew:any=[];
    scorebookrecord:any=[];
    filterLength:any=[];
    data:any;
    types:any;
    tagid:string;
    matchValue:any;
  constructor(private el: ElementRef, private renderer: Renderer2, private service: ScorebookService) { }
  @ViewChild('selected') selected: ElementRef;
  @ViewChild('items') items: ElementRef;
  @ViewChild('ulRef', { static: true }) ulRef: ElementRef;
  ngOnInit(): void {  
    // this.setScoreCardData();

    this.scorebookcall();
  }
  

  // setScoreCardData(){
  //   this.service.getAllScoreCardEntries().subscribe(x=>{
  //          this.scorebookData = x;
  //          console.log(x);
  //   })

  


    
  scorebookcall(){
          
    this.service.getScoreFull().subscribe(x => {
      this.scorebookNew = x;
      let results = [];
      let keys = {
        'ScoreParameter': 'ArrayData',
        'Publication': 'lineitemtext',
      };
      this.filterLength = this.scorebookNew.filter((item, i, arr) => arr.findIndex((t) => t.scoreNumber=== item.scoreNumber) === i);
      for (let i = 0; i <= this.filterLength.length; i++) {
        let filteredArray = this.scorebookNew.filter(item => item.scoreNumber === i.toString());
    
        if (filteredArray.length > 0) {
          let item = filteredArray[0];
    
          // create an empty array for each key
          let lineItemTypes = [];
          let lineItemTexts = [];
          let lineItemCounts = [];
    
          // loop through filtered array and push values to respective arrays
          filteredArray.forEach(filteredItem => {
            lineItemTypes.push(filteredItem.lineItemType);
            lineItemTexts.push(filteredItem.lineItemText);
            lineItemCounts.push(filteredItem.lineItemCount);
          });
    
          // map keys to array
          item = Object.assign(item, {
            scoreParameters: lineItemTypes.map((type, index) => {
              return {
                // [keys[type]]
                slNo: index,
                lineItemText: lineItemTexts[index],
                lineitemcount: lineItemCounts[index],
                lineItemType: lineItemTypes[index]
              };
            })
          });
    
          results.push(item);
        }
      }
    
      this.scorebookrecord = results;
      console.log(this.scorebookrecord);
    });
    
    }

  clicked(event) {
    for (let index = 0; index < this.scorebookrecord.length; index++) {
      document.getElementById("li-"+index).classList.remove('active');
      document.getElementById("tab-"+index).classList.remove('current');
    }

    event.target.classList.add('active');
    let scoreNo = event.target.getAttribute("data-scoreNo");
    document.getElementById("tab-"+scoreNo).classList.add('current');
  }

}