<?php

/**
 * classe Compra
 */


 class Cliente
 {
     //TODO
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

       
        public  function getValor(){
            //TODO
        }

        public function getQuantidadeItens(){
            return sizeof($itensCompra);
        }

        public  function adicionarPromocao(){
            
        }

        private function adicionarItem($item){
            $this->item[] = $item;
        }

        private function calcularPromocao(){
               $promocao = new Promocao();
        }



 }

/**
 * Frabrica de Depêndecia
 */
 static class Promocao(){
     
   function checar(Compra $compra){
        if($compra->getValor() > 1000){
            
        }
   }




 }
 

interface Desconto{
    function calcularDesconto();
}


class compraTotal implements Desconto
{
    function calcularDesconto(){

    }
}




class programaFidelidade implements Desconto
{
    function calcularDesconto(){
        
    }
}



class quantidadeItensComprados implements Desconto
{
    function calcularDesconto(){
        
    }
}