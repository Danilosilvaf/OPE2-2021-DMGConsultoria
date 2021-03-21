import { CommonModule } from "@angular/common";
import { NgModule } from "@angular/core";
import { HomeRoutingModule } from "./home-routing.module";
import { HomeComponent } from "./home.component";
import { ProdutoComponent } from './produto/produto.component';
import { FuncionarioComponent } from './funcionario/funcionario.component';
import { FornecedorComponent } from './fornecedor/fornecedor.component';

@NgModule({
    declarations: [
        HomeComponent,
        ProdutoComponent,
        FuncionarioComponent,
        FornecedorComponent
    ],
    imports: [
        CommonModule,
        HomeRoutingModule
    ],

    providers: []

})

export class HomeModule {

}
