import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { GuardsService } from "../shared/guards/guards.service";
import { HomeComponent } from "./home.component";

const routes: Routes = [
    {path:'home', component: HomeComponent ,canActivate:[GuardsService] }
     ];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
  })


export class HomeRoutingModule{}
