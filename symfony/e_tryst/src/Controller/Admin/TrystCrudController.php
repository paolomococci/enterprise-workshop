<?php

namespace App\Controller\Admin;

use App\Entity\Tryst;

use EasyCorp\Bundle\EasyAdminBundle\Config\Crud;
use EasyCorp\Bundle\EasyAdminBundle\Config\Filters;
use EasyCorp\Bundle\EasyAdminBundle\Controller\AbstractCrudController;
use EasyCorp\Bundle\EasyAdminBundle\Field\DateField;
use EasyCorp\Bundle\EasyAdminBundle\Field\TimeField;
use EasyCorp\Bundle\EasyAdminBundle\Filter\EntityFilter;
use EasyCorp\Bundle\EasyAdminBundle\Field\TextareaField;
use EasyCorp\Bundle\EasyAdminBundle\Field\TextField;

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
    
    public function configureFields(string $pageName): iterable 
    {
        yield TextField::new('name');
        yield TextField::new('title');
        yield TextareaField::new('topic')->hideOnIndex();
        $day = DateField::new('day')->setFormTypeOptions([
            'html5' => true,
            'years' => range(date('Y'), date('Y') + 5),
            'widget' => 'single_text',
        ]);
        $hour = TimeField::new('hour')->setFormTypeOptions([
            'html5' => true,
            'widget' => 'single_text',
        ]);
        if (Crud::PAGE_EDIT === $pageName) {
            yield $day->setFormTypeOption('disabled', true);
            yield $hour->setFormTypeOption('disabled', true);
        } else {
            yield $day;
            yield $hour;
        }
    }
}
