<?php

namespace App\Controller;

use App\Entity\Repas;
use App\Form\RepasType;
use Doctrine\ORM\EntityManagerInterface;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

/**
 * @Route("/repas")
 */
class RepasController extends AbstractController
{
    /**
     * @Route("/", name="app_repas_index", methods={"GET"})
     */
    public function index(EntityManagerInterface $entityManager): Response
    {
        $repas = $entityManager
            ->getRepository(Repas::class)
            ->findAll();

        return $this->render('repas/index.html.twig', [
            'repas' => $repas,
        ]);
    }

    /**
     * @Route("/new", name="app_repas_new", methods={"GET", "POST"})
     */
    public function new(Request $request, EntityManagerInterface $entityManager): Response
    {
        $repa = new Repas();
        $form = $this->createForm(RepasType::class, $repa);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $entityManager->persist($repa);
            $entityManager->flush();

            return $this->redirectToRoute('app_repas_index', [], Response::HTTP_SEE_OTHER);
        }

        return $this->render('repas/new.html.twig', [
            'repa' => $repa,
            'form' => $form->createView(),
        ]);
    }

    /**
     * @Route("/{idrepas}", name="app_repas_show", methods={"GET"})
     */
    public function show(Repas $repa): Response
    {
        return $this->render('repas/show.html.twig', [
            'repa' => $repa,
        ]);
    }

    /**
     * @Route("/{idrepas}/edit", name="app_repas_edit", methods={"GET", "POST"})
     */
    public function edit(Request $request, Repas $repa, EntityManagerInterface $entityManager): Response
    {
        $form = $this->createForm(RepasType::class, $repa);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $entityManager->flush();

            return $this->redirectToRoute('app_repas_index', [], Response::HTTP_SEE_OTHER);
        }

        return $this->render('repas/edit.html.twig', [
            'repa' => $repa,
            'form' => $form->createView(),
        ]);
    }

    /**
     * @Route("/{idrepas}", name="app_repas_delete", methods={"POST"})
     */
    public function delete(Request $request, Repas $repa, EntityManagerInterface $entityManager): Response
    {
        if ($this->isCsrfTokenValid('delete'.$repa->getIdrepas(), $request->request->get('_token'))) {
            $entityManager->remove($repa);
            $entityManager->flush();
        }

        return $this->redirectToRoute('app_repas_index', [], Response::HTTP_SEE_OTHER);
    }
}
