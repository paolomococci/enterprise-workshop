<?php

namespace App\Controller;

use App\Entity\Tryst;
use App\Form\TrystType;
use App\Repository\TrystRepository;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

/**
 * @Route("/tryst/crud")
 */
class TrystCrudController extends AbstractController
{
    /**
     * @Route("/", name="tryst_crud_index", methods={"GET"})
     */
    public function index(TrystRepository $trystRepository): Response
    {
        return $this->render('tryst_crud/index.html.twig', [
            'trysts' => $trystRepository->findAll(),
        ]);
    }

    /**
     * @Route("/new", name="tryst_crud_new", methods={"GET","POST"})
     */
    public function new(Request $request): Response
    {
        $tryst = new Tryst();
        $form = $this->createForm(TrystType::class, $tryst);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $entityManager = $this->getDoctrine()->getManager();
            $entityManager->persist($tryst);
            $entityManager->flush();

            return $this->redirectToRoute('tryst_crud_index');
        }

        return $this->render('tryst_crud/new.html.twig', [
            'tryst' => $tryst,
            'form' => $form->createView(),
        ]);
    }

    /**
     * @Route("/{id}", name="tryst_crud_show", methods={"GET"})
     */
    public function show(Tryst $tryst): Response
    {
        return $this->render('tryst_crud/show.html.twig', [
            'tryst' => $tryst,
        ]);
    }

    /**
     * @Route("/{id}/edit", name="tryst_crud_edit", methods={"GET","POST"})
     */
    public function edit(Request $request, Tryst $tryst): Response
    {
        $form = $this->createForm(TrystType::class, $tryst);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $this->getDoctrine()->getManager()->flush();

            return $this->redirectToRoute('tryst_crud_index');
        }

        return $this->render('tryst_crud/edit.html.twig', [
            'tryst' => $tryst,
            'form' => $form->createView(),
        ]);
    }

    /**
     * @Route("/{id}", name="tryst_crud_delete", methods={"POST"})
     */
    public function delete(Request $request, Tryst $tryst): Response
    {
        if ($this->isCsrfTokenValid('delete'.$tryst->getId(), $request->request->get('_token'))) {
            $entityManager = $this->getDoctrine()->getManager();
            $entityManager->remove($tryst);
            $entityManager->flush();
        }

        return $this->redirectToRoute('tryst_crud_index');
    }
}
