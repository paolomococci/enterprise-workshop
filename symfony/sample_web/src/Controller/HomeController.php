<?php

namespace App\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

class HomeController extends AbstractController
{
    /**
     * @Route("/home", name="home", methods={"GET","HEAD"})
     */
    public function index(): Response
    {
        return $this->render(
            'home/index.html.twig', 
            [
                'greeting' => 'hello from sample web demo application'
            ]
        );
    }
}
