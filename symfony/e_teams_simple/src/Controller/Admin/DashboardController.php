<?php

namespace App\Controller\Admin;

use EasyCorp\Bundle\EasyAdminBundle\Config\Dashboard;
use EasyCorp\Bundle\EasyAdminBundle\Config\MenuItem;
use EasyCorp\Bundle\EasyAdminBundle\Controller\AbstractDashboardController;
use EasyCorp\Bundle\EasyAdminBundle\Router\CrudUrlGenerator;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

use App\Entity\User;
use App\Entity\Category;
use App\Entity\Post;

use App\Controller\Admin\UserCrudController;

class DashboardController extends AbstractDashboardController
{
    /**
     * @Route("/admin", name="admin")
     */
    public function index(): Response
    {
        //return parent::index();
        $routeBuilder = $this->get(CrudUrlGenerator::class)->build();
        $url = $routeBuilder->setController(UserCrudController::class)->generateUrl();
        return $this->redirect($url);
    }

    public function configureDashboard(): Dashboard
    {
        return Dashboard::new()
            ->setTitle('E-Teams Simple');
    }

    public function configureMenuItems(): iterable
    {
        yield MenuItem::linktoDashboard('Admin', 'fas fa-users-cog');
        // yield MenuItem::linkToCrud('The Label', 'fas fa-list', EntityClass::class);
        // yield MenuItem::linktoRoute('Back to the home', 'fas fa-home', 'homepage');
        yield MenuItem::linkToCrud('Users', 'fas fa-users', User::class);
        yield MenuItem::linkToCrud('Category', 'fas fa-hashtag', Category::class);
        yield MenuItem::linkToCrud('Post', 'fas fa-comment', Post::class);
    }
}
