<?php

namespace App\Controller\Admin;

use App\Entity\Guest;

use EasyCorp\Bundle\EasyAdminBundle\Config\Crud;
use EasyCorp\Bundle\EasyAdminBundle\Controller\AbstractCrudController;

class GuestCrudController extends AbstractCrudController
{
    public static function getEntityFqcn(): string
    {
        return Guest::class;
    }

    public function configureCrud(Crud $crud): Crud 
    {
        return $crud
                ->setEntityLabelInSingular('a Guest on Tryst')
                ->setEntityLabelInPlural('some Guests on Tryst')
                ->setSearchFields(['name', 'surname','email','birthday'])
                ->setDefaultSort(['email' => 'DESC']);
    }

    // TODO
}
