<?php

namespace App\Controller\Admin;

use App\Entity\Guest;

use EasyCorp\Bundle\EasyAdminBundle\Controller\AbstractCrudController;

class GuestCrudController extends AbstractCrudController
{
    public static function getEntityFqcn(): string
    {
        return Guest::class;
    }

    // TODO
}
