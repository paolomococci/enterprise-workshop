<?php

namespace App\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

class TrystViewController extends AbstractController
{
    /**
     * @Route("/tryst/view", name="tryst_view", methods={"GET","HEAD"})
     */
    public function index(): Response
    {
        return $this->render('tryst_view/index.html.twig', [
            'controller_name' => 'TrystViewController',
        ]);
    }
}
