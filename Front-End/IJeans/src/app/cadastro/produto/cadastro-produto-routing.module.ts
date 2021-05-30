import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { GuardsService } from "src/app/shared/guards/guards.service";
import { CadastrarProdutosComponent } from "./cadastro-produto.component";

const routes: Routes = [
    {path:'cadastroproduto', component: CadastrarProdutosComponent,canActivate:[GuardsService]}
     ];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
  })


export class CadastroProdutoRoutingModule{}
