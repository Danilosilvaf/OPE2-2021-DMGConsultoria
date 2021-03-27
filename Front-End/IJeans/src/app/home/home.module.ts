import { CommonModule } from "@angular/common";
import { NgModule } from "@angular/core";
import { HomeRoutingModule } from "./home-routing.module";
import { HomeComponent } from "./home.component";
import { ProdutoComponent } from './produto/produto.component';
import { FuncionarioComponent } from './funcionario/funcionario.component';
import { FornecedorComponent } from './fornecedor/fornecedor.component';
import { CadastrarProdutosComponent } from "./produto/cadastro/cadastro-produto.component";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import {MatSelectModule} from '@angular/material/select';
import { BrowserModule } from "@angular/platform-browser";
import { CadastrarFuncionarioComponent } from "./funcionario/cadastro/cadastro-funcionario.component";

@NgModule({
    declarations: [
        HomeComponent,
        ProdutoComponent,
        FuncionarioComponent,
        FornecedorComponent,
        CadastrarFuncionarioComponent,
        CadastrarProdutosComponent
    ],
    imports: [
        CommonModule,
        HomeRoutingModule,
        MatSelectModule,      
        ReactiveFormsModule,
        BrowserModule,
        FormsModule
    ],

    providers: []

})

export class HomeModule {

}
