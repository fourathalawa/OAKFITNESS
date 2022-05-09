<?php

namespace App\Controller;
use App\Entity\User;
use DateTime;
use App\Entity\Commande;
use App\Entity\Panier;
use App\Entity\Produit;
use App\Form\PanierType;
use Doctrine\ORM\EntityManagerInterface;
use Dompdf\Dompdf;
use Dompdf\Options;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;
use Symfony\Component\Mime\Email;
use Symfony\Component\Mailer\MailerInterface;

/**
 * @Route("/panier")
 */
class PanierController extends AbstractController
{
    /**
     * @Route("/index/{idClient}", name="app_panier_index", methods={"GET"})
     */
    public function index(EntityManagerInterface $entityManager,$idClient): Response
    {
        $paniers = $entityManager->getRepository(Panier::class)->findBy(["idClient"=> $idClient]);
        $produits = $entityManager->getRepository(Produit::class)->findAll();


        return $this->render('panier/index.html.twig', [
            'paniers' => $paniers,'produits'=>$produits
        ]);
    }
    /**
     * @Route("/indexback/", name="app_panier_indexback", methods={"GET","POST"})
     */
    public function indexback(EntityManagerInterface $entityManager): Response
    {
        $paniers = $entityManager->getRepository(Panier::class)->findAll();

        return $this->render('panier/indexback.html.twig', [
            'panier' => $paniers,
        ]);
    }

    /**
     * @Route("/{idClient}/addProduct/{idProduct}/{quantity}", name="app_panier_add_product", methods={"GET", "POST"})
     */
    public function new(Request $request, EntityManagerInterface $entityManager, $idClient, $idProduct, $quantity): Response
    {   $panier = $entityManager->getRepository(Panier::class)->findOneBy(["idClient" => $idClient]);
        //var_dump($panier);
      if (!$panier instanceof Panier){
          $panier = new Panier();
          $panier->setIdClient($idClient);
      }
        $produit = $entityManager->getRepository(Produit::class)->findOneBy(["idproduit" => $idProduct]);
        $total = floatval($quantity*$produit->getPrixproduit());
      $panier->setIdProduit($produit);
      $panier->setQuantity($quantity);
       $panier->setTotal($total);
        $entityManager->persist($panier);
        $entityManager->flush();
        return $this->redirectToRoute('app_panier_index', [], Response::HTTP_SEE_OTHER);
    }



    /**
     * @Route("/{idClient}/edit", name="app_panier_edit", methods={"GET", "POST"})
     */
    public function edit(Request $request, Panier $panier, EntityManagerInterface $entityManager): Response
    {
        $form = $this->createForm(PanierType::class, $panier);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $entityManager->flush();

            return $this->redirectToRoute('app_panier_index', [], Response::HTTP_SEE_OTHER);
        }

        return $this->render('panier/edit.html.twig', [
            'panier' => $panier,
            'form' => $form->createView(),
        ]);
    }

    /**
     * @Route("/{idClient}/{idProduit}/editQuantity/", name="app_panier_editQuantity", methods={"GET", "POST"})
     */
    public function editQuantity(Request $request, EntityManagerInterface $entityManager, $idClient, $idProduit): Response
    {
        $panier = $entityManager->getRepository(Panier::class)->findOneBy(["idClient" => $idClient]);
        //var_dump($panier);
        $product = $entityManager->getRepository(Produit::class)->findOneBy(["idproduit" => $idProduit]);


                $panier->setQuantity(($panier->getQuantity())+1);
                $panier->setTotal($panier->getTotal()+$product->getPrixproduit());
                $entityManager->persist($panier);
                $entityManager->flush();



        return $this->redirectToRoute('app_panier_index',['idClient'=>$idClient]);



    }
    /**
     * @Route("/{idClient}/{idProduit}/demQuantity/", name="app_panier_demQuantity", methods={"GET", "POST"})
     */
    public function demQuantity(Request $request, EntityManagerInterface $entityManager, $idClient, $idProduit): Response
    {
        $panier = $entityManager->getRepository(Panier::class)->findOneBy(["idClient" => $idClient]);
        //var_dump($panier);
        $product = $entityManager->getRepository(Produit::class)->findOneBy(["idproduit" => $idProduit]);
        $panier->setQuantity(($panier->getQuantity())-1);
        $panier->setTotal($panier->getTotal()-$product->getPrixproduit());
        $entityManager->persist($panier);
        $entityManager->flush();
        return $this->redirectToRoute('app_panier_index',['idClient'=>$idClient]);

    }
    /**
     * @Route("/{idPanier}/{idClient}/delete/", name="app_panier_delete", methods={"GET","POST"})
     */
    public function delete(Request $request, EntityManagerInterface $entityManager,$idPanier,$idClient): Response
    {
        $panier = $entityManager->getRepository(Panier::class)->findOneBy(["id" => $idPanier]);
            $entityManager->remove($panier);
            $entityManager->flush();
            return $this->redirectToRoute('app_panier_index', ['idClient'=>$idClient]);
    }
    /**
     * @Route("/{idClient}/vider_panier", name="app_panier_vider_panier", methods={"GET","POST"})
     */
    public function viderPanier(Request $request, EntityManagerInterface $entityManager, $idClient): Response
    {
        $paniers = $entityManager->getRepository(Panier::class)->findBy(["idClient" => $idClient]);
        //var_dump(count($paniers));
        foreach ($paniers as $panier)
        {
            $entityManager->remove($panier);
        }
        $entityManager->flush();

        return $this->redirectToRoute('app_panier_index', ['idClient'=>$idClient], Response::HTTP_SEE_OTHER);
    }
    /**
     * @Route("/{idClient}/validerpanier", name="app_panier_validerpanier", methods={"GET","POST"})
     */
    public function validerPanier(Request $request, EntityManagerInterface $entityManager, $idClient,MailerInterface $mailer): Response
    {

        $produits = $entityManager->getRepository(Produit::class)->findAll();
        var_dump($idClient);
        //todo:handleexp
        //$commande=$entityManager->getRepository(Commande::class)->findby(["idClient" => $idClient]);

        //var_dump($commande->getDateCommande());
        $paniers = $entityManager->getRepository(Panier::class)->findOneBy(["idClient" => $idClient]);

        //var_dump(count($paniers));
        $total=0;
        //$date=getdate();
//var_dump((new DateTime('now'))->format('Y-m-d-H-m-s'));
        foreach ($paniers as $panier)
        { $total = $total+$panier->getTotal();

        }

        $user=new User();
        $user = $this->getDoctrine()
            ->getRepository(User::class)
            ->find(44);
$commande=new Commande();

        $commande->setDateCommande((new DateTime('now')));
        $commande->setTotal($total);
        $commande->setEtat(1);
        $clint= $this->getDoctrine()->getRepository(User::class)->find(52);
        $commande->setIdClient($clint);
        $entityManager->persist($commande);
        $entityManager->flush();
        $email = (new Email())
            ->from('oakfitness12@gmail.com')
            ->to($user->getMailuser())
            //->bcc('bcc@example.com')
            //->replyTo('fabien@example.com')
            //->priority(Email::PRIORITY_HIGH)
            ->subject('Confirmation de votre commande')
            ->text('votre commande bien')
            ->html('<p>commande Ajouté avec succée merci pour votre confiance.</p>' );


        $mailer->send($email);
        $pdfOptions=new Options();
        $pdfOptions->set('defaultFront','Arial');
        $dompdf= new Dompdf($pdfOptions);
        $html=$this->renderView('panier/listep.html.twig',['paniers' => $paniers,'produits'=>$produits]);
        $dompdf->loadHtml($html);
        $dompdf->setPaper('A4','portrait');
        $dompdf->render();
        $dompdf->stream("facture.pdf",["Attachment"=>true]);


        return $this->redirectToRoute('app_panier_index', ['idClient'=>$idClient]);
    }
    /**
     * @Route("/senEmail", name="app_panier_sendEmail", methods={"GET","POST"})
     */
    public function sendEmail( \Swift_Mailer $mailer)
    {
        $message = (new \Swift_Message('mail de confirmation'))
            ->setFrom('oakfitness12@gmail.com')
            ->setTo('sarra.tounsi@esprit.tn')
            ->setBody('votre commande est confirmée merci pour votre confiance'
            )
        ;
        $mailer->send($message);
        return $this->redirectToRoute('app_commande_indexback', [], Response::HTTP_SEE_OTHER);

    }
    /**
     * @Route("/{idClient}/total_panier", name="app_panier_total_panier", methods={"GET","POST"})
     */
    public function totalPanier(Request $request, EntityManagerInterface $entityManager, $idClient): Response
    {
        return $this->redirectToRoute('app_panier_index', [], Response::HTTP_SEE_OTHER);
        $panier = $entityManager->getRepository(Panier::class)->findBy(["idClient" => $idClient]);
        foreach ($paniers as $panier)
        {
            $total=$panier->getTotal($idClient)+$total;
        }
        return $total;


    }
}
