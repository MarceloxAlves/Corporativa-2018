<?php

class Produto
{

    private $descricao;
    private $valor;

    /**
     * Produto constructor.
     * @param $descricao
     * @param $valor
     */
    public function __construct($descricao, $valor)
    {
        $this->descricao = $descricao;
        $this->valor = $valor;
    }


}