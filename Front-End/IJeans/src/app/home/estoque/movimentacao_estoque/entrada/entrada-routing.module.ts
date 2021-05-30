import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { GuardsService } from "src/app/shared/guards/guards.service";
import { EntradaComponent } from "./entrada.component";

const routes: Routes = [
    {path:'entrada', component:EntradaComponent,canActivate:[GuardsService] },
    {path: 'entrada/:id', component: EntradaComponent},
     ];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
  })


export class EntradaRoutingModule{}
