import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { GuardsService } from "src/app/shared/guards/guards.service";
import { CadastrarFuncionarioComponent } from "./cadastro-funcionario.component";

const routes: Routes = [
    {path:'cadastrofuncionario', component: CadastrarFuncionarioComponent,canActivate:[GuardsService]}
     ];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
  })


export class CadastroFuncionarioRoutingModule{}
