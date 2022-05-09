<?php

namespace App\Controller;

use App\Entity\Programmesportif;
use App\Form\ProgrammesportifType;
use Doctrine\ORM\EntityManagerInterface;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

/**
 * @Route("/programmesportif")
 */
class ProgrammesportifController extends AbstractController
{
    /**
     * @Route("/", name="app_programmesportif_index", methods={"GET"})
     */
    public function index(EntityManagerInterface $entityManager): Response
    {
        $programmesportifs = $entityManager
            ->getRepository(Programmesportif::class)
            ->findAll();

        return $this->render('programmesportif/index.html.twig', [
            'programmesportifs' => $programmesportifs,
        ]);
    }

    /**
     * @Route("/new", name="app_programmesportif_new", methods={"GET", "POST"})
     */
    public function new(Request $request, EntityManagerInterface $entityManager): Response
    {
        $programmesportif = new Programmesportif();
        $form = $this->createForm(ProgrammesportifType::class, $programmesportif);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $entityManager->persist($programmesportif);
            $entityManager->flush();

            return $this->redirectToRoute('app_programmesportif_index', [], Response::HTTP_SEE_OTHER);
        }

        return $this->render('programmesportif/new.html.twig', [
            'programmesportif' => $programmesportif,
            'form' => $form->createView(),
        ]);
    }

    /**
     * @Route("/{idprogrammesportif}", name="app_programmesportif_show", methods={"GET"})
     */
    public function show(Programmesportif $programmesportif): Response
    {
        return $this->render('programmesportif/show.html.twig', [
            'programmesportif' => $programmesportif,
        ]);
    }

    /**
     * @Route("/{idprogrammesportif}/edit", name="app_programmesportif_edit", methods={"GET", "POST"})
     */
    public function edit(Request $request, Programmesportif $programmesportif, EntityManagerInterface $entityManager): Response
    {
        $form = $this->createForm(ProgrammesportifType::class, $programmesportif);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $entityManager->flush();

            return $this->redirectToRoute('app_programmesportif_index', [], Response::HTTP_SEE_OTHER);
        }

        return $this->render('programmesportif/edit.html.twig', [
            'programmesportif' => $programmesportif,
            'form' => $form->createView(),
        ]);
    }

    /**
     * @Route("/{idprogrammesportif}", name="app_programmesportif_delete", methods={"POST"})
     */
    public function delete(Request $request, Programmesportif $programmesportif, EntityManagerInterface $entityManager): Response
    {
        if ($this->isCsrfTokenValid('delete'.$programmesportif->getIdprogrammesportif(), $request->request->get('_token'))) {
            $entityManager->remove($programmesportif);
            $entityManager->flush();
        }

        return $this->redirectToRoute('app_programmesportif_index', [], Response::HTTP_SEE_OTHER);
    }
}
