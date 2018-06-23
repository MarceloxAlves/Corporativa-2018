<?php
class Compra implements Descontable
{
    private $itens;
    private $cpf;

    function  adicionarItem(Produto $produto){
        $this->itens[] = $produto;
    }

    function existeCPF(){
        return $this->cpf ? true : false;
    }

    function getValorTotal()
    {
        return array_sum(array_column($this->itens, 'valor'));
    }
}