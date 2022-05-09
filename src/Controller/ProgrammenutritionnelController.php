<?php

namespace App\Controller;

use App\Entity\Programmenutritionnel;
use App\Form\ProgrammenutritionnelType;
use Doctrine\ORM\EntityManagerInterface;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

/**
 * @Route("/programmenutritionnel")
 */
class ProgrammenutritionnelController extends AbstractController
{
    /**
     * @Route("/", name="app_programmenutritionnel_index", methods={"GET"})
     */
    public function index(EntityManagerInterface $entityManager): Response
    {
        $programmenutritionnels = $entityManager
            ->getRepository(Programmenutritionnel::class)
            ->findAll();

        return $this->render('programmenutritionnel/index.html.twig', [
            'programmenutritionnels' => $programmenutritionnels,
        ]);
    }

    /**
     * @Route("/new", name="app_programmenutritionnel_new", methods={"GET", "POST"})
     */
    public function new(Request $request, EntityManagerInterface $entityManager): Response
    {
        $programmenutritionnel = new Programmenutritionnel();
        $form = $this->createForm(ProgrammenutritionnelType::class, $programmenutritionnel);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $entityManager->persist($programmenutritionnel);
            $entityManager->flush();

            return $this->redirectToRoute('app_programmenutritionnel_index', [], Response::HTTP_SEE_OTHER);
        }

        return $this->render('programmenutritionnel/new.html.twig', [
            'programmenutritionnel' => $programmenutritionnel,
            'form' => $form->createView(),
        ]);
    }

    /**
     * @Route("/{idprogrammenutritionnel}", name="app_programmenutritionnel_show", methods={"GET"})
     */
    public function show(Programmenutritionnel $programmenutritionnel): Response
    {
        return $this->render('programmenutritionnel/show.html.twig', [
            'programmenutritionnel' => $programmenutritionnel,
        ]);
    }

    /**
     * @Route("/{idprogrammenutritionnel}/edit", name="app_programmenutritionnel_edit", methods={"GET", "POST"})
     */
    public function edit(Request $request, Programmenutritionnel $programmenutritionnel, EntityManagerInterface $entityManager): Response
    {
        $form = $this->createForm(ProgrammenutritionnelType::class, $programmenutritionnel);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $entityManager->flush();

            return $this->redirectToRoute('app_programmenutritionnel_index', [], Response::HTTP_SEE_OTHER);
        }

        return $this->render('programmenutritionnel/edit.html.twig', [
            'programmenutritionnel' => $programmenutritionnel,
            'form' => $form->createView(),
        ]);
    }

    /**
     * @Route("/{idprogrammenutritionnel}", name="app_programmenutritionnel_delete", methods={"POST"})
     */
    public function delete(Request $request, Programmenutritionnel $programmenutritionnel, EntityManagerInterface $entityManager): Response
    {
        if ($this->isCsrfTokenValid('delete'.$programmenutritionnel->getIdprogrammenutritionnel(), $request->request->get('_token'))) {
            $entityManager->remove($programmenutritionnel);
            $entityManager->flush();
        }

        return $this->redirectToRoute('app_programmenutritionnel_index', [], Response::HTTP_SEE_OTHER);
    }
}
