<?php

namespace App\Controller\Admin;

use App\Entity\Commodity;
use EasyCorp\Bundle\EasyAdminBundle\Controller\AbstractCrudController;

class CommodityCrudController extends AbstractCrudController
{
    public static function getEntityFqcn(): string
    {
        return Commodity::class;
    }

    /*
    public function configureFields(string $pageName): iterable
    {
        return [
            IdField::new('id'),
            TextField::new('title'),
            TextEditorField::new('description'),
        ];
    }
    */
}
