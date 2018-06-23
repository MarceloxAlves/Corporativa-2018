<?php
/**
 * Created by PhpStorm.
 * User: Marcelo
 */



interface Desconto
{
    function calcular(Descontable $descontable);

}