<?php

namespace App\Controller\Admin;

use App\Entity\Tryst;

use EasyCorp\Bundle\EasyAdminBundle\Controller\AbstractCrudController;

class TrystCrudController extends AbstractCrudController
{
    public static function getEntityFqcn(): string
    {
        return Tryst::class;
    }

    // TODO
}
