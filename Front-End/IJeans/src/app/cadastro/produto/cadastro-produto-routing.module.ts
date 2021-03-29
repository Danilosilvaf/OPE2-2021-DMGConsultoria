import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { CadastrarProdutosComponent } from "./cadastro-produto.component";

const routes: Routes = [
    {path:'cadastroproduto', component: CadastrarProdutosComponent}
     ];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
  })


export class CadastroProdutoRoutingModule{}
