// This file can be replaced during build by using the `fileReplacements` array.
// `ng build --prod` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.

export const environment = {
  production: true,
  serviceApiUrl: "http://localhost:4505/business/",
  authApiUrl: "http://49.50.94.117:4500/res-auth-service/",
  imageUrl:"https://staffphotos.gitam.edu/",
  DashboardUrl:"http://49.50.94.117:83/api/Home/GetDashboard",
  publicationUrl:"http://49.50.94.117:83/api/Researcher/GetResearcherAuthPublications?authorId=",
  profileUrl:"http://49.50.94.117:83/api/Researcher/GetResearcherList",
  facultyUrl:"http://49.50.94.117:83/api/Researcher/GetResearcher?authorId=",
  articleUrl:"http://49.50.94.117:83/api/Researcher/GetResearcherArticleCounts?authorId=",
  documentcountUrl:"http://49.50.94.117:83/api/Researcher/GetResearcherDocumentCounts?authorId=",

};
/*
 * For easier debugging in development mode, you can import the following file
 * to ignore zone related error stack frames such as `zone.run`, `zoneDelegate.invokeTask`.
 *
 * This import should be commented out in production mode because it will have a negative impact
 * on performance if an error is thrown.
 */
// import 'zone.js/plugins/zone-error';  // Included with Angular CLI.
