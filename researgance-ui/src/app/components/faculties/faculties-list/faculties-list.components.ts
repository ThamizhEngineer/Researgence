import { Component, OnInit,ViewChild, TemplateRef, Input, Output, EventEmitter } from '@angular/core';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { FacultiesService} from '../faculties.service'

import { Faculty } from '../../../shared/model/data.models';
import { environment } from 'src/environments/environment';
import { CommonsearchService } from 'src/app/shared/services/commonsearch.service';

@Component({
    selector: '',
    templateUrl: 'faculties-list.components.html',
    styleUrls: ['./../../../../assets/given/selected.css', './../../../../assets/given/css/style-vit1.css', './../../../../assets/given/css/style-vit2.css', './../../../../assets/given/css/style.css'],

})

export class FacultiesListComponent implements OnInit {

    facultiesList:any;
    imageSrc:any;
    uibaseurl: string;
     facultyimages: string[] =[ 
    '/assets/given/facultyimagestmp/ISC001.jpg',
    '/assets/given/facultyimagestmp/ISC002.jpg',
    '/assets/given/facultyimagestmp/ISC003.jpg',
    '/assets/given/facultyimagestmp/ISC004.jpg',
    '/assets/given/facultyimagestmp/ISC005.jpg', 
    ]

    //For Pagination
 
    page :number = 1;
    pageSize :number = 8;
    pageSizes: number[] = [5, 10, 15, 20, 100];

    showDropdown: boolean = false;

    toggleDropdown() {
      this.showDropdown = !this.showDropdown;
    }
    constructor(public service:FacultiesService, private router:Router,private search:CommonsearchService){

    }
   
    filteredItems:any;
    ngOnInit() { 

     this.service.GetPubFacultyList().subscribe(x=>{
        this.facultiesList =x;   
        this.filteredItems=this.facultiesList;     
        console.log(x);
     })   
    
      
     this.search.getSearchQuery().subscribe(query => {
        this.filteredItems = this.facultiesList?.filter(item => item.facultyName.toLowerCase().includes(query.toLowerCase()));
    });
     this.uibaseurl='/faculties';
     this.imageSrc=environment.imageUrl;
    }

    movedetail(){
        this.router.navigateByUrl("/faculties/"+this.facultiesList.slNo);   
    }

   
}