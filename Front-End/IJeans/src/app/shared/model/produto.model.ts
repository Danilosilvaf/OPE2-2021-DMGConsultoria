import { MarcaModel } from "./marca.model";
import { TamanhoModel } from "./tamanho.model";
import { TipoProduto } from "./tipo.model";

export class ProdutoModel{
    id:number;
    nome:String;
    preco_atual:number;
    quantidade_estoque:number;
    marca:MarcaModel;
    tipo:TipoProduto;
    tamanho:TamanhoModel;
}