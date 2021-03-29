import { CommonModule } from "@angular/common";
import { NgModule } from "@angular/core";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { BrowserModule } from "@angular/platform-browser";
import { CadastroProdutoRoutingModule } from "./cadastro-produto-routing.module";
import { CadastrarProdutosComponent } from "./cadastro-produto.component";


@NgModule({
    declarations: [
        CadastrarProdutosComponent,
    ],
    imports: [
        CommonModule,
        ReactiveFormsModule,
        BrowserModule,
        CadastroProdutoRoutingModule,
        FormsModule
    ],

    providers: []

})

export class CadastroProdutoModule{
    
}
