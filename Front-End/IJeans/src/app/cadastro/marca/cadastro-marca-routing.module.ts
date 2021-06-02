import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { GuardsService } from "src/app/shared/guards/guards.service";
import { CadastrarMarcaComponent } from "./cadastro-marca.component";

const routes: Routes = [
  { path: 'cadastromarca', component: CadastrarMarcaComponent, canActivate: [GuardsService] }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})


export class CadastroMarcaRoutingModule {

}
