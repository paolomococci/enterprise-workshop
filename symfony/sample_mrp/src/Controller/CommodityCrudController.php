<?php

namespace App\Controller;

use App\Entity\Commodity;
use App\Form\CommodityType;
use App\Repository\CommodityRepository;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

/**
 * @Route("/commodity/crud")
 */
class CommodityCrudController extends AbstractController
{
    /**
     * @Route("/", name="commodity_crud_index", methods={"GET"})
     */
    public function index(CommodityRepository $commodityRepository): Response
    {
        return $this->render('commodity_crud/index.html.twig', [
            'commodities' => $commodityRepository->findAll(),
        ]);
    }

    /**
     * @Route("/new", name="commodity_crud_new", methods={"GET","POST"})
     */
    public function new(Request $request): Response
    {
        $commodity = new Commodity();
        $form = $this->createForm(CommodityType::class, $commodity);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $entityManager = $this->getDoctrine()->getManager();
            $entityManager->persist($commodity);
            $entityManager->flush();

            return $this->redirectToRoute('commodity_crud_index');
        }

        return $this->render('commodity_crud/new.html.twig', [
            'commodity' => $commodity,
            'form' => $form->createView(),
        ]);
    }

    /**
     * @Route("/{id}", name="commodity_crud_show", methods={"GET"})
     */
    public function show(Commodity $commodity): Response
    {
        return $this->render('commodity_crud/show.html.twig', [
            'commodity' => $commodity,
        ]);
    }

    /**
     * @Route("/{id}/edit", name="commodity_crud_edit", methods={"GET","POST"})
     */
    public function edit(Request $request, Commodity $commodity): Response
    {
        $form = $this->createForm(CommodityType::class, $commodity);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $this->getDoctrine()->getManager()->flush();

            return $this->redirectToRoute('commodity_crud_index');
        }

        return $this->render('commodity_crud/edit.html.twig', [
            'commodity' => $commodity,
            'form' => $form->createView(),
        ]);
    }

    /**
     * @Route("/{id}", name="commodity_crud_delete", methods={"POST"})
     */
    public function delete(Request $request, Commodity $commodity): Response
    {
        if ($this->isCsrfTokenValid('delete'.$commodity->getId(), $request->request->get('_token'))) {
            $entityManager = $this->getDoctrine()->getManager();
            $entityManager->remove($commodity);
            $entityManager->flush();
        }

        return $this->redirectToRoute('commodity_crud_index');
    }
}
