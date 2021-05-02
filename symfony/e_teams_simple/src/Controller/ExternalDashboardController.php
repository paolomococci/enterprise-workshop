<?php

namespace App\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

class ExternalDashboardController extends AbstractController
{
    /**
     * @Route("/external/dashboard", name="external_dashboard")
     */
    public function index(): Response
    {
        return $this->render('external_dashboard/index.html.twig', [
            'controller_name' => 'ExternalDashboardController',
        ]);
    }
}
