<?php

namespace App\Controller\Admin;

use App\Entity\Guest;

use EasyCorp\Bundle\EasyAdminBundle\Config\Crud;
use EasyCorp\Bundle\EasyAdminBundle\Config\Filters;
use EasyCorp\Bundle\EasyAdminBundle\Controller\AbstractCrudController;
use EasyCorp\Bundle\EasyAdminBundle\Field\AssociationField;
use EasyCorp\Bundle\EasyAdminBundle\Field\DateField;
use EasyCorp\Bundle\EasyAdminBundle\Field\EmailField;
use EasyCorp\Bundle\EasyAdminBundle\Filter\EntityFilter;
use EasyCorp\Bundle\EasyAdminBundle\Field\TextField;

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
    
    public function configureFilters(Filters $filters): Filters 
    {
        return $filters->add(EntityFilter::new('email'));
    }
    
    public function configureFields(string $pageName): iterable 
    {
        yield AssociationField::new('tryst');
        yield TextField::new('name');
        yield TextField::new('surname');
        yield EmailField::new('email');
        $birthday = DateField::new('birthday')->setFormTypeOptions([
            'html5' => true,
            'years' => range(date('Y'), date('Y')),
            'widget' => 'single_text',
        ]);
        if (Crud::PAGE_EDIT === $pageName) {
            yield $birthday->setFormTypeOption('disabled', true);
        } else {
            yield $birthday;
        }
    }
}
