<?php

namespace App\Controller\Admin;

use App\Entity\Post;

use EasyCorp\Bundle\EasyAdminBundle\Config\Crud;
use EasyCorp\Bundle\EasyAdminBundle\Config\Filters;
use EasyCorp\Bundle\EasyAdminBundle\Controller\AbstractCrudController;
use EasyCorp\Bundle\EasyAdminBundle\Field\AssociationField;
use EasyCorp\Bundle\EasyAdminBundle\Field\DateTimeField;
use EasyCorp\Bundle\EasyAdminBundle\Filter\EntityFilter;
use EasyCorp\Bundle\EasyAdminBundle\Field\TextareaField;
use EasyCorp\Bundle\EasyAdminBundle\Field\TextField;

class PostCrudController extends AbstractCrudController
{
    public static function getEntityFqcn(): string
    {
        return Post::class;
    }

    public function configureCrud(Crud $crud): Crud 
    {
        return $crud
                ->setEntityLabelInSingular('Tryst Post')
                ->setEntityLabelInPlural('Tryst Posts')
                ->setSearchFields(['title', 'merit'])
                ->setDefaultSort(['at' => 'DESC']);
    }
    
    public function configureFilters(Filters $filters): Filters 
    {
        return $filters->add(EntityFilter::new('guest'));
    }
    
    public function configureFields(string $pageName): iterable 
    {
        yield AssociationField::new('guest');
        yield TextField::new('title');
        yield TextareaField::new('merit')->hideOnIndex();
        $at = DateTimeField::new('at')->setFormTypeOptions([
            'html5' => true,
            'years' => range(date('Y'), date('Y') + 5),
            'widget' => 'single_text',
        ]);
        if (Crud::PAGE_EDIT === $pageName) {
            yield $at->setFormTypeOption('disabled', true);
        } else {
            yield $at;
        }
    }
}
