import { Injectable, HostListener } from '@angular/core';
import { BehaviorSubject, Observable, Subscriber } from 'rxjs';

// Menu
export interface Menu {
	path?: string;
	title?: string;
	icon?: string;
	type?: string;
	badgeType?: string;
	badgeValue?: string;
	active?: boolean;
	bookmark?: boolean;
	onClick?: string;
	children?: Menu[];
}

@Injectable({
	providedIn: 'root'
})

export class NavService {

	public screenWidth: any
	public collapseSidebar: boolean = false
	public fullScreen = false;

	constructor() {
		this.onResize();
		if (this.screenWidth < 991) {
			this.collapseSidebar = false
		}

	}

	// Windows width
	@HostListener('window:resize', ['$event'])
	onResize(event?) {
		this.screenWidth = window.innerWidth;
	}

	MENUITEMS: Menu[] = [
		{
			path: '/dashboard', title: 'Dashboard', icon: 'home', type: 'link' 
		},
		{
			path: '/faculties', title: 'My Profile', icon: 'airplay', type: 'link' 
		},
		{
			path: '/scorebook', title: 'Score Book', icon: 'airplay', type: 'link' 
		},
		
		{
			title: 'My Research Outcomes', icon: 'airplay', type: 'sub', active: false, children: [
				{ path: '/faculties/:id', title: 'Publications', type: 'link' },
				{ path: '/dashboard#Tab11', title: 'Faculty Profiles', type: 'link' },
				{ path: '/dashboard#Tab12', title: 'Scholar Profiles', type: 'link', onClick: 'openCard' },
				{ path: '/dashboard#Tab13', title: 'Sponsored Projects', type: 'link' ,onClick: 'openCard' },
				{ path: '/My Research Outcomes/', title: 'Consultancy Projects', type: 'link' },
				{ path: '/My Research Outcomes/', title: 'Incubation Start-ups', type: 'link' },
				{ path: '/My Research Outcomes/', title: 'Patents', type: 'link' },
				{ path: '/My Research Outcomes/', title: 'Copyrights', type: 'link' },
				{ path: '/My Research Outcomes/', title: 'Trademarks', type: 'link' },
				{ path: '/My Research Outcomes/', title: 'Guideship', type: 'link' },
				{ path: '/My Research Outcomes/', title: 'Editorship', type: 'link' },
				{ path: '/My Research Outcomes/', title: 'Membership', type: 'link' },
				{ path: '/My Research Outcomes/', title: 'Books', type: 'link' },
				{ path: '/My Research Outcomes/', title: 'Conferences', type: 'link' },
				{ path: '/My Research Outcomes/', title: 'Digital Content', type: 'link' },
				{ path: '/My Research Outcomes/', title: 'MOU', type: 'link' },
				{ path: '/My Research Outcomes/', title: 'Technology Licensing', type: 'link' },
				{ path: '/My Research Outcomes/', title: 'Products', type: 'link' },
				{ path: '/My Research Outcomes/', title: 'Admin', type: 'link' },

			]
		},
		
	]
	// Array
	items = new BehaviorSubject<Menu[]>(this.MENUITEMS);
	openCard(event) {
		event.preventDefault();
		const path = event.target.getAttribute('href');
		const cardId = path.substring(path.indexOf("#") + 1);
		console.log(cardId);
		const card = document.getElementById(cardId);
		console.log(card);
		const cards = document.getElementsByClassName("card");
		console.log(cards);
		for (let i = 0; i < cards.length; i++) {
			cards[i].classList.remove("open");
		}
		card.classList.add('open');
	}
	
}

  
  