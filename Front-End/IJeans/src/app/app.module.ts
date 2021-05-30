import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { BsDropdownModule } from 'ngx-bootstrap/dropdown';
import { TooltipModule } from 'ngx-bootstrap/tooltip';
import { ModalModule } from 'ngx-bootstrap/modal';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { LoginModule } from './login/login.module';
import { HomeModule } from './home/home.module';
import { CadastroFuncionarioModule } from './cadastro/funcionario/cadastro-funcionario.module';
import { CadastroProdutoModule } from './cadastro/produto/cadastro-produto.module';
import { CadastroFornecedorModule } from './cadastro/fornecedor/fornecedor-cadastro.module';
import { EntradaModule } from './home/estoque/movimentacao_estoque/entrada/entrada.module';
import { SaidaModule } from './home/estoque/movimentacao_estoque/saida/saida.module';
import { ToastrModule } from 'ngx-toastr';
import { GuardsModule } from './shared/guards/guards.module';




@NgModule({
  declarations: [
    AppComponent
     ],
  imports: [
    BrowserModule,
    CommonModule,
    HttpClientModule,
    CadastroFuncionarioModule,
    FormsModule,
    ReactiveFormsModule,
    LoginModule,
    HomeModule,
    CadastroFornecedorModule,
    CadastroProdutoModule,
    BrowserAnimationsModule,
    EntradaModule,
    SaidaModule,
    GuardsModule,
    AppRoutingModule,
    ToastrModule.forRoot(),
    BsDropdownModule.forRoot(),
    TooltipModule.forRoot(),
    ModalModule.forRoot()
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
