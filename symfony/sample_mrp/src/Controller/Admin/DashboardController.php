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
use App\Entity\Customer;
use App\Entity\Supplier;

use App\Controller\Admin\CommodityCrudController;

class DashboardController extends AbstractDashboardController
{
    /**
     * @Route("/admin", name="admin")
     */
    public function index(): Response {
        $routeBuilder = $this->get(CrudUrlGenerator::class)->build();
        $url = $routeBuilder->setController(CommodityCrudController::class)->generateUrl();
        return $this->redirect($url);
    }
    
    /**
     * @Route("/", name="home")
     */
    public function home(): Response {
        return $this->render('home/index.html.twig');
    }
    
    public function configureDashboard(): Dashboard {
        return Dashboard::new()
            ->setTitle('Sample Mrp');
    }

    public function configureMenuItems(): iterable
    {
        yield MenuItem::linkToRoute('Home', 'fas fa-home', 'home');
        yield MenuItem::linktoDashboard('Admin', 'fas fa-users-cog');
        yield MenuItem::linkToCrud('Commodities', 'fas fa-gift', Commodity::class);
        yield MenuItem::linkToCrud('Components', 'fas fa-barcode', Component::class);
        yield MenuItem::linkToCrud('Customers', 'fas fa-users', Customer::class);
        yield MenuItem::linkToCrud('Suppliers', 'fas fa-address-book', Supplier::class);
    }
}
