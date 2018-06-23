<?php

interface Frete
{
    function  calcular(Fretavel $fretavel, Descontable $descontable);
}