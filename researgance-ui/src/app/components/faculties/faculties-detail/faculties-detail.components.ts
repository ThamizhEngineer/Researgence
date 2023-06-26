import { Component, ElementRef, HostListener, Input, OnInit, Renderer2, ViewChild } from '@angular/core';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { FacultiesService } from '../faculties.service'
import { switchMap } from 'rxjs/operators';
import { DocCount,FacultyList,DataModels, Article, Faculty } from '../../../shared/model/data.models';
import { environment } from 'src/environments/environment';
import { MenuService } from 'src/app/shared/services/menu.service';
import { CommonsearchService } from 'src/app/shared/services/commonsearch.service';
import { HttpClient } from '@angular/common/http';



@Component({
    selector: '',
    templateUrl: './faculties-detail.components.html',
    styleUrls: ['./../../../../assets/given/selected.css', './../../../../assets/given/css/style-vit1.css', './../../../../assets/given/css/style-vit2.css', './../../../../assets/given/css/style.css', './../../../../assets/given/css/bootstrap.min.css'],
    
})
export class FacultiesDetailComponent implements OnInit {
    filteredItems: any;
    isScrolled = false;
    marginTop = '0px';
    ipAddress:string; 
    selectedTab :string;
  userIP: any;
    constructor(private route: ActivatedRoute, private service: FacultiesService,
      private menuService: MenuService,private search:CommonsearchService,private http: HttpClient,
      private routes:Router,
        private renderer: Renderer2, private el: ElementRef) { 
          this.menuService.menu$.subscribe(menuOpen => {
            this.isMenuOpen = menuOpen;
          });
         
        }

    pubrecord: any[] = [];
    faculty: any;
    pubdetails:any;
    docCount:any;
    articlecount:any;
    imageSrc:any;
    articleUrl:any;
    orderSort=['Ascending','Descending'];
    ascendValue='Ascending';
    yearSort=['Year','Month','Day']
    yearValue='Year';
    poPage=0;
    poPageSize=5;
    pageSizes = [5, 10, 20, 50];
    searchFilter:string;
    filterValue:string;
    showModal = false;
    showShare=false;
    showIcons:any;
    authoraffiliation:any;
    reverse = false;
    datasample:any;
    affiliationrecord
    isCollapsed = true;
    values:string;
    order:any;
    tech:any;
    rows=[];
    row=[];
    items: any[] = [
        { name: 'Tiger Nixon'},
        { name: ' Garrett Winters '},
        { name: 'Ashton Cox '},
        { name: ' Cedric Kelly'},
        { name: ' Airi Satou '},
        { name: ' Brielle Williamson'},
        { name: 'Herrod Chandler '},
        { name: '  Rhona Davidson'},
        {name:'Colleen Hurst '},
         {name:'Sonya Frost '},
         {name:' Jena Gaines '},
         {name:'Quinn Flynn '},
         {name:'Charde Marshall '},
         {name:' Haley Kennedy '},
         {name:' Tatyana Fitzpatrick'},
         {name:'Michael Silva '},
         {name:'Paul Byrd '},
         {name:'Gloria Little '},
         {name:'Bradley Greer '},
         {name:' Dai Rios '},
         {name:'Jenette Caldwell '},
         {name:' Yuri Berry '},
        { name: 'Caesar Vance '},
        { name: 'Doris Wilder '},
        { name: 'Angelica Ramos '},
        { name: 'Gavin Joyce '},
        { name: ' Jennifer Chang'},
        { name: ' Brenden Wagner'},
        { name: 'Fiona Green '},
        { name: 'Shou Itou '},
      ];
      facultyimages: string[] =[ 
    '/assets/given/facultyimagestmp/ISC001.jpg',
     '/assets/given/facultyimagestmp/ISC002.jpg',
      '/assets/given/facultyimagestmp/ISC003.jpg',
       '/assets/given/facultyimagestmp/ISC004.jpg',
        '/assets/given/facultyimagestmp/ISC005.jpg', 
    ]
    imageToShow = ['ISC001','ISC002','ISC003','ISC004','ISC005'];
    techarea:any;
    sortitems:any;
    showDropdown = false;
    name=[];
    ngOnInit() {   
      this.articleUrl='article/art/';
      this.selectedTab = 'apa';
        this.route.params.subscribe(params => {           
            //Profile API
            console.log(params.id);
            
            this.service.GetProfile(params.id).subscribe(x => {
                this.faculty = x;
               console.log(this.faculty);
               console.log(this.faculty.empid);
               
              //For Faculty
               if(this.imageToShow.find(x => x ==this.faculty.empid)){
                this.imageSrc=this.facultyimages;
               }else{
                this.imageSrc = environment.imageUrl+this.faculty.empid+'.jpg';
               }

            })
            
           //Publication API
            this.service.researcherPublicationDetails(params.id).subscribe(x => {
                this.pubdetails = x;
                this.filteredItems=this.pubdetails;
                console.log(x);
           
            //For split of Technologyareas &  AuthorAffiliation
            for (let i = 0; i < this.pubdetails.length; i++) {
               this.pubdetails[i].technology_Areas = this.pubdetails[i].technology_Areas.split(';');
               this.pubdetails[i].authorAffiliation = this.pubdetails[i].authorAffiliation.split('|');

              //  console.log(this.pubdetails[i].authorAffiliation);
              //  console.log(this.pubdetails[i].technology_Areas);
             }
           
          //Name Filter
            this.sortitems=this.pubdetails.title;
            this.order = this.sortitems;   
            })

           //For SearchBox filter
           this.search.getSearchQuery().subscribe(query => {
            this.filteredItems = this.pubdetails?.filter(item =>
              item.year.toLowerCase().includes(query.toLowerCase()) ||
              item.sourcePublication.toLowerCase().includes(query.toLowerCase()) ||
              item.abstract.toLowerCase().includes(query.toLowerCase()) ||
              item.title.toLowerCase().includes(query.toLowerCase())
            );
          });
          
            //document Api
            this.service.GetResearcherDocumentCounts(params.id).subscribe(x => {
                this.docCount = x;
                console.log(x);
                
            })
            
            //Journal api
            this.service.GetArticleRecords(params.id).subscribe(x => {
              this.articlecount = x;
              console.log(x);
          })

       
        });
    }
  //detail & compact view
  selectedScheme = 'detailed';

  //sidebar transformation
  isMenuOpen = false;
 
      toggleMenu() {
        this.menuService.toggleMenu();
      }
      showshare(){
        this.showIcons =!this.showIcons;
      }
  updateSelectedScheme(event: any) {
    const elements = document.getElementsByTagName('article');
    for (let i = 0; i < elements.length; i++) {
      elements[i].classList.remove(this.selectedScheme);
      elements[i].classList.add(event.target.value);
    }
    this.selectedScheme = event.target.value;
  }
    //Transition set for triangle to square box
    @HostListener('window:scroll', [])
    onWindowScroll() {
      const scroll = window.pageYOffset || document.documentElement.scrollTop || document.body.scrollTop || 0;
      if (scroll >=400) {
        this.isScrolled = true;
        this.marginTop = '636px';
      } else {
        this.isScrolled = false;
        this.marginTop = '0px';
      }
    }
   
    //For Modal Box 
    openModal() {
      console.log('dialogbox button opened!');
      this.showModal = true;
      
    }
    closeModal() {
      console.log('Close button clicked!');
      this.showModal = false;
    }

    //Filter for ascending &descending
    changesOrder(values){
      console.log(values);
      if(values=='Ascending'){
          this.pubdetails.sort((a, b) => (a.title > b.title) ? 1 : ((b.title > a.title) ? -1 : 0));
      }
      if(values=='Descending'){
        this.pubdetails.sort((a, b) => (a.title < b.title) ? 1 : ((b.title < a.title) ? -1 : 0));
      }
      
    }
    changeYear(values){
      console.log(values);
      if(values=='Year'){
          this.pubdetails.sort((a,b) => b - a);
      }
      
    }
    toggle() {
      this.isCollapsed = !this.isCollapsed;
    }

    openArticle(url: string) {
      window.open(url, '_blank');
    }

    getShareUrl( id:string): string {
      const shareUrl = 'http://localhost:4200/article/art';
      const recordid = id;
      const sno = this.faculty.slNo;
      const fullUrl = `${shareUrl}/${recordid}/${sno}`;
      return fullUrl;
    }
  
}