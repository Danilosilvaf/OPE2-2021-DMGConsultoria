import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { CadastrarFuncionarioComponent } from "./cadastro-funcionario.component";

const routes: Routes = [
    {path:'cadastrofuncionario', component: CadastrarFuncionarioComponent}
     ];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
  })


export class CadastroFuncionarioRoutingModule{}
