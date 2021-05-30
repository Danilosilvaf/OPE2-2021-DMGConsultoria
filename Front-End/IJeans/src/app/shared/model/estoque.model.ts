import { FornecedorModel } from "./fornecedor.model";
import { ProdutoModel } from "./produto.model";



export class EstoqueModel{
    quantidade:number;
    status:boolean;
    preco:number;
    produto:ProdutoModel;
    fornecedor:FornecedorModel
}