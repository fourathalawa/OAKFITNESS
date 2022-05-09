<?php

namespace App\Entity;
use Symfony\Component\Validator\Constraints as Assert;
use Symfony\Component\Validator\Mapping\ClassMetadata;
use Doctrine\ORM\Mapping as ORM;

/**
 * Panier
 *
 * @ORM\Table(name="panier", indexes={@ORM\Index(name="fkCom", columns={"id_commande"}), @ORM\Index(name="FK_24CC0DF2E173B1B8", columns={"id_client"}), @ORM\Index(name="id", columns={"id"}), @ORM\Index(name="fkProduit", columns={"id_produit"})})
 * @ORM\Entity
 */
class Panier
{
    /**
     * @var int
     *
     * @ORM\Column(name="id", type="integer", nullable=false)
     */
    private $id;

    /**
     * @var int
     *
     * @ORM\Column(name="quantity", type="integer", nullable=false ,scale=0)
     * Assert\NotEqualTo(
     *  value=0
     * message="la quantité doit etre min 1"
     * )
     */
    private $quantity;

    /**
     * @var int
     *
     * @ORM\Column(name="total", type="bigint", nullable=false)
     */
    private $total;

    /**
     * @var \User
     *
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="NONE")
     * @ORM\OneToOne(targetEntity="User")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="id_client", referencedColumnName="IdUser")
     * })
     */
    private $idClient;

    /**
     * @var \Commande
     *
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="NONE")
     * @ORM\OneToOne(targetEntity="Commande")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="id_commande", referencedColumnName="id")
     * })
     */
    private $idCommande;

    /**
     * @var \Produit
     *
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="NONE")
     * @ORM\OneToOne(targetEntity="Produit")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="id_produit", referencedColumnName="IdProduit")
     * })
     */
    private $idProduit;

    /**
     * @return int
     */
    public function getId():?int
    {
        return $this->id;
    }

    /**
     * @param int $id
     */
    public function setId(?int $id): void
    {
        $this->id = $id;
    }

    /**
     * @return int
     */
    public function getQuantity():?int
    {
        return $this->quantity;
    }

    /**
     * @param int $quantity
     */
    public function setQuantity(?int $quantity): void
    {
        $this->quantity = $quantity;
    }

    /**
     * @return int
     */
    public function getTotal():?int
    {
        return $this->total;
    }

    /**
     * @param int $total
     */
    public function setTotal(?int $total): void
    {
        $this->total = $total;
    }

    /**
     * @return \User
     */
    public function getIdClient(): ?User
    {
        return $this->idClient;
    }

    /**
     * @param \User $idClient
     */
    public function setIdClient(?int $idClient): self
    {
        $this->idClient = $idClient;
        return $this;
    }

    /**
     * @return \Commande
     */
    public function getIdCommande(): ?Commande
    {
        return $this->idCommande;
    }

    /**
     * @param \Commande $idCommande
     */
    public function setIdCommande(?Commande $idCommande): self
    {
        $this->idCommande = $idCommande;
        return $this;
    }

    /**
     * @return \Produit
     */
    public function getIdProduit(): ?Produit
    {
        return $this->idProduit;
    }

    /**
     * @param \Produit $idProduit
     */
    public function setIdProduit(?Produit $idProduit): self
    {
        $this->idProduit = $idProduit;
        return $this;
    }
    public function toString() {
        return $this->idClient;
    }


    public static function loadValidatorMetadata(ClassMetadata $metadata)
    {


        $metadata->addPropertyConstraint('quantity', new Assert\NotEqualTo([
            'value' => 0,
        ]));
    }

}
