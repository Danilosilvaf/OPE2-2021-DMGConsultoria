import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { GuardsService } from "src/app/shared/guards/guards.service";
import { SaidaComponent } from "./saida.component";

const routes: Routes = [
    {path:'saida/:id', component:SaidaComponent,canActivate:[GuardsService] }
     ];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
  })


export class SaidaRoutingModule{}
