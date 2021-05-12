<?php

namespace App\Controller\Admin;

use App\Entity\Tryst;

use EasyCorp\Bundle\EasyAdminBundle\Config\Crud;
use EasyCorp\Bundle\EasyAdminBundle\Config\Filters;
use EasyCorp\Bundle\EasyAdminBundle\Filter\EntityFilter;
use EasyCorp\Bundle\EasyAdminBundle\Controller\AbstractCrudController;

class TrystCrudController extends AbstractCrudController
{
    public static function getEntityFqcn(): string
    {
        return Tryst::class;
    }

    public function configureCrud(Crud $crud): Crud 
    {
        return $crud
                ->setEntityLabelInSingular('a Guest Tryst')
                ->setEntityLabelInPlural('some Guest Trysts')
                ->setSearchFields(['name', 'title','topic','day','hour'])
                ->setDefaultSort(['day' => 'DESC']);
    }
    
    public function configureFilters(Filters $filters): Filters 
    {
        return $filters->add(EntityFilter::new('title'));
    }

    // TODO
}
