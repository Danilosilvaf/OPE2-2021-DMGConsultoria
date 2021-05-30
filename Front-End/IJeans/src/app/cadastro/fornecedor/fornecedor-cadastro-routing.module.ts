import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { GuardsService } from "src/app/shared/guards/guards.service";
import { CadastroFornecedorComponent } from "./fornecedor-cadastro.component";

const routes: Routes = [
    {path:'cadastrofornecedor', component: CadastroFornecedorComponent ,canActivate:[GuardsService]}
     ];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
  })


export class CadastroFornecedorRoutingModule{}
