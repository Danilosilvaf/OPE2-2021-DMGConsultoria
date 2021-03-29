import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { CadastroFornecedorComponent } from "./fornecedor-cadastro.component";

const routes: Routes = [
    {path:'cadastrofornecedor', component: CadastroFornecedorComponent}
     ];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
  })


export class CadastroFornecedorRoutingModule{}
