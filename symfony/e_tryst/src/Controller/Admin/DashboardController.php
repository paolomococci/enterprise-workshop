<?php

namespace App\Controller\Admin;

use EasyCorp\Bundle\EasyAdminBundle\Config\Dashboard;
use EasyCorp\Bundle\EasyAdminBundle\Config\MenuItem;
use EasyCorp\Bundle\EasyAdminBundle\Controller\AbstractDashboardController;
use EasyCorp\Bundle\EasyAdminBundle\Router\CrudUrlGenerator;

use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

use App\Entity\Guest;
use App\Entity\Tryst;
use App\Entity\Post;

use App\Controller\Admin\GuestCrudController;

class DashboardController extends AbstractDashboardController
{
    /**
     * @Route("/admin", name="admin")
     */
    public function index(): Response
    {
        $routeBuilder = $this->get(CrudUrlGenerator::class)->build();
        $url = $routeBuilder->setController(GuestCrudController::class)->generateUrl();
        return $this->redirect($url);
    }

    public function configureDashboard(): Dashboard
    {
        return Dashboard::new()
            ->setTitle('E-Tryst');
    }

    public function configureMenuItems(): iterable
    {
        //yield MenuItem::linkToRoute('Index', 'fas fa-home', 'index');
        yield MenuItem::linktoDashboard('Admin', 'fa-users-cog');
        yield MenuItem::linkToCrud('Guest', 'fas fa-users', Guest::class);
        yield MenuItem::linkToCrud('Tryst', 'fas fa-users', Tryst::class);
        yield MenuItem::linkToCrud('Post', 'fas fa-users', Post::class);
    }
}
