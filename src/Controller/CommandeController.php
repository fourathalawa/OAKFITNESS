<?php

namespace App\Controller;

use App\Entity\Commande;
use App\Form\CommandeType;
use Doctrine\ORM\EntityManagerInterface;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

/**
 * @Route("/commande")
 */
class CommandeController extends AbstractController
{
    /**
     * @Route("/indexback", name="app_commande_indexback", methods={"GET", "POST"})
     */
    public function indexback(EntityManagerInterface $entityManager): Response
    {
        $commandes = $entityManager
            ->getRepository(Commande::class)
            ->findAll();

        return $this->render('commande/indexback.html.twig', [
            'commandes' => $commandes,
        ]);
    }
    /**
     * @Route("/afficheClient/{idClient}", name="app_commande_afficheClient", methods={"GET","POST"})
     */
    public function afficheClient(EntityManagerInterface $entityManager, $idClient): Response
    {
        $commandes = $entityManager
            ->getRepository(Commande::class)
            ->findBy(["idClient"=>$idClient]);

        return $this->render('commande/index.html.twig', [
            'commandes' => $commandes,
        ]);
    }

    /**
     * @Route("/new", name="app_commande_new", methods={"GET", "POST"})
     */
    public function new(Request $request, EntityManagerInterface $entityManager): Response
    {
        $commande = new Commande();
        $form = $this->createForm(CommandeType::class, $commande);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $entityManager->persist($commande);
            $entityManager->flush();

            return $this->redirectToRoute('app_commande_indexback', [], Response::HTTP_SEE_OTHER);
        }

        return $this->render('commande/newback.html.twig', [
            'commande' => $commande,
            'form' => $form->createView(),
        ]);
    }
    /**
     * @Route("/{idC}/editEtat/", name="app_commande_editEtat", methods={"GET", "POST"})
     */
    public function editEtat(Request $request, EntityManagerInterface $entityManager, $idC): Response
    {
        $commande = $entityManager->getRepository(Commande::class)->findOneBy(["id" => $idC]);


        $commande->setEtat($commande->getEtat()+1);
        $entityManager->persist($commande);
        $entityManager->flush();
        return $this->redirectToRoute('app_commande_indexback');

    }
    /**
     * @Route("/{idC}/annulerCommande/", name="app_commande_annulerCommande", methods={"GET", "POST"})
     */
    public function annulerCommande(Request $request, EntityManagerInterface $entityManager, $idC): Response
    {
        $commande = $entityManager->getRepository(Commande::class)->findOneBy(["id" => $idC]);

        $commande->setEtat(5);
        $entityManager->persist($commande);
        $entityManager->flush();
        return $this->redirectToRoute('app_commande_indexback');

    }
    /**
     * @Route("/", name="app_commande_showback", methods={"GET"})
     */
    /*public function show(Commande $commande): Response
    {
        return $this->render('commande/showback.html.twig', [
            'commande' => $commande,
        ]);
    }*/


    /**
     * @Route("/ajouteravis/{idC}", name="app_commande_ajouteravis", methods={"GET", "POST"})
     */
    public function ajouteravis(Request $request, Commande $commande, EntityManagerInterface $entityManager,$idC): Response
    {

        $commande=$commande = $entityManager->getRepository(Commande::class)->findOneBy(["id" => $idC]);

        if ($request->isMethod("POST"))
        {
            $avis=$request->request->all();
            $av=$avis['form']['ajouteravis'];
            $commande->setAvisclient($avis);
            $entityManager->persist($commande);
            $entityManager->flush();

        }
        return $this->redirectToRoute('app_commande_index', ['commandes' => $commande], Response::HTTP_SEE_OTHER);}


    /**
     * @Route("/delete", name="app_commande_delete", methods={"POST"})
     */
    public function delete(Request $request, Commande $commande, EntityManagerInterface $entityManager,$idCommande): Response
    {
        $commande = $entityManager->getRepository(Commande::class)->findOneBy(["id" => $idCommande]);
        $entityManager->remove($commande);
        $entityManager->flush();

        return $this->redirectToRoute('app_commande_index', [], Response::HTTP_SEE_OTHER);
    }
    /**
     * @Route("/deleteback", name="app_commande_deleteback", methods={"POST"})
     */
    public function deleteback(Request $request, Commande $commande, EntityManagerInterface $entityManager,$idCommande): Response
    {
        $commande = $entityManager->getRepository(Commande::class)->findOneBy(["id" => $idCommande]);
        $entityManager->remove($commande);
        $entityManager->flush();

        return $this->redirectToRoute('app_commande_indexback', [], Response::HTTP_SEE_OTHER);
    }
}
