<?php
/**
 * Created by PhpStorm.
 * User: Marcelo
 */

class DescontoFidelidade implements Desconto
{

    function calcular(Descontable $descontable)
    {
        if($descontable->existeCPF()){
            if($descontable->getValorTotal() > 999) return $descontable->getValorTotal() * 0.1;
            if($descontable->getValorTotal() > 99) return $descontable->getValorTotal() * 0.05;
        }
            return 0;
    }

}