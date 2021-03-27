import { CommonModule } from "@angular/common";
import { NgModule } from "@angular/core";
import { HomeRoutingModule } from "./home-routing.module";
import { HomeComponent } from "./home.component";
import { ProdutoComponent } from './produto/produto.component';
import { FuncionarioComponent } from './funcionario/funcionario.component';
import { FornecedorComponent } from './fornecedor/fornecedor.component';
import { CadastrarProdutosComponent } from "./produto/cadastro/cadastro-produto.component";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";

@NgModule({
    declarations: [
        HomeComponent,
        ProdutoComponent,
        FuncionarioComponent,
        FornecedorComponent,
        CadastrarProdutosComponent
    ],
    imports: [
        CommonModule,
        HomeRoutingModule,
        ReactiveFormsModule,
        FormsModule
    ],

    providers: []

})

export class HomeModule {

}
