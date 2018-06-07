<?php

/**
 * classe Compra
 */


 class Cliente
 {
     private $pontos;

     public function getPontos(){
         //TODO
     } 
 }

 class Compra
    {
        private $itensCompra;
        private $cliente;
        private $descontos;

        function __construct(Cliente $cliente){
            $this->cliente  = $cliente  
            $this->itensCompra  = array(); 
        
        }
        

        public  function getValorFinal(){
            $promocao = new Promocao($this, $this->cliente);
            return $this->getValor() - $promocao->getDesconto()->calcularDesconto();
        }

        public function getQuantidadeItens(){
            return sizeof($itensCompra);
        }
        }

        private  function getValor(){
            //TODO - return SUM valor itens
        }

        private function adicionarItem($item){
            $this->item[] = $item;
        }

        


 }

/**
 * Frabrica de Dependecia
 */
 class Promocao(){

    private $compra;
    private $cliente;

    function __construct(Compra $compra, Cliente $cliente)
    {
        $this->cliente = $cliente;
        $this->compra = $compra;
    }

   function getDesconto(){
        if($this->compra->getValor() > 1000 || $this->compra->getQuantidadeItens() > 20)  return new compraTotal($this->compra->getValor());
        if($this->cliente->getPontos() >= 100) return new programaFidelidade($this->compra->getValor());
   }

 }
 

interface Desconto{
    function calcularDesconto();
}


class compraTotal implements Desconto
{
    private $valor;
    
    funtion __construct($valor){
        $this->valor = $valor;
    }

    function calcularDesconto(){
        return $this->valor * 0.1;
    }
}




class programaFidelidade implements Desconto
{
    private $valor;
    
    funtion __construct($valor){
        $this->valor = $valor;
    }

    function calcularDesconto(){
        return $this->valor * 0.05;
    }
}
