<?php

namespace App\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

class HelloController extends AbstractController
{
    /**
     * @Route("/hello", name="hello", methods={"GET","HEAD"})
     */
    public function index(): Response
    {
        $user = ['name' => 'everyone'];
        return $this->render(
            'hello/index.html.twig', 
            [
                'controller_name' => 'HelloController',
                'user' => $user
            ]
        );
    }
}
