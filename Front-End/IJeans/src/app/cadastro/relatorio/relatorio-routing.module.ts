import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { GuardsService } from "src/app/shared/guards/guards.service";
import { RelatorioComponent } from "./relatorio.component";

const routes: Routes = [
  { path: 'envioRelatorio', component: RelatorioComponent, canActivate: [GuardsService] }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})


export class RelatorioRoutingModule {

}
