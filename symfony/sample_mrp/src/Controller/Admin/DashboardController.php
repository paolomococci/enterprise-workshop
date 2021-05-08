<?php

namespace App\Controller\Admin;

use EasyCorp\Bundle\EasyAdminBundle\Config\Dashboard;
use EasyCorp\Bundle\EasyAdminBundle\Config\MenuItem;
use EasyCorp\Bundle\EasyAdminBundle\Controller\AbstractDashboardController;
use EasyCorp\Bundle\EasyAdminBundle\Router\CrudUrlGenerator;

use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

use App\Entity\Commodity;
use App\Entity\Component;

use App\Controller\Admin\CommodityCrudController;

class DashboardController extends AbstractDashboardController
{
    /**
     * @Route("/admin", name="admin")
     */
    public function index(): Response
    {
        $routeBuilder = $this->get(CrudUrlGenerator::class)->build();
        $url = $routeBuilder->setController(CommodityCrudController::class)->generateUrl();
        return $this->redirect($url);
    }

    public function configureDashboard(): Dashboard
    {
        return Dashboard::new()
            ->setTitle('Sample Mrp');
    }

    public function configureMenuItems(): iterable
    {
        yield MenuItem::linktoDashboard('Admin', 'fa fa-home');
        yield MenuItem::linkToCrud('commodities', 'fa-caret-square-down', Commodity::class);
        yield MenuItem::linkToCrud('components', 'fas fa-caret-square-up', Component::class);
    }
}
