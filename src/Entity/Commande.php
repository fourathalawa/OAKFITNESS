<?php

namespace App\Entity;

use DateTime;
use Doctrine\ORM\Mapping as ORM;
use phpDocumentor\Reflection\Types\String_;
use Symfony\Component\Validator\Constraints as Assert;
use Symfony\Component\Validator\Mapping\ClassMetadata;

/**
 * Commande
 *
 * @ORM\Table(name="commande", indexes={@ORM\Index(name="id_client", columns={"id_client"})})
 * @ORM\Entity
 */
class Commande
{
    /**
     * @var int
     *
     * @ORM\Column(name="id", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $id;

    /**
     * @var \Date
     *
     * @ORM\Column(name="datecommande", type="date", nullable=true, options={"default"="NULL"})
     */
    private $dateCommande = 'NULL';

    /**
     * @var int
     *
     * @ORM\Column(name="total", type="bigint", nullable=false)
     */
    private $total;

    /**
     * @var int
     *
     * @ORM\Column(name="etat", type="integer", nullable=false)
     */
    private $etat;

    /**
     * @var string|null
     *
     * @ORM\Column(name="avisclient", type="string", length=255, nullable=true, options={"default"="NULL"})
     */
    private $avisclient = 'NULL';

    /**
     * @var \User
     *
     * @ORM\ManyToOne(targetEntity="User")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="id_client", referencedColumnName="IdUser")
     * })
     */
    private $idClient;

    /**
     * @return int
     */
    public function getId(): ?int
    {
        return $this->id;
    }

    /**
     * @param int $id
     */
    public function setId(int $id): void
    {
        $this->id = $id;
    }

    /**
     * @return DateTime
     */
    public function getDateCommande(): DateTime|string
    {
        return $this->dateCommande;
    }

    /**
     * @param DateTime $dateCommande
     */
    public function setDateCommande(DateTime|string $dateCommande): void
    {
        $this->dateCommande = $dateCommande;
    }




    /**
     * @return int
     */
    public function getTotal(): ?int
    {
        return $this->total;
    }

    /**
     * @param int $total
     */
    public function setTotal(int $total): void
    {
        $this->total = $total;
    }

    /**
     * @return int
     */
    public function getEtat(): int
    {
        return $this->etat;
    }



    /**
     * @param int $etat
     */
    public function setEtat(int $etat): void
    {
        $this->etat = $etat;
    }

    /**
     * @return string|null
     */
    public function getAvisclient(): ?string
    {
        return $this->avisclient;
    }

    /**
     * @param string|null $avisclient
     */
    public function setAvisclient(?string $avisclient): void
    {
        $this->avisclient = $avisclient;
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
    public function setIdClient(?User $idClient): self
    {
        $this->idClient = $idClient;
        return $this;
    }
    public static function loadValidatorMetadata(ClassMetadata $metadata)
    {


        $metadata->addPropertyConstraint('etat', new Assert\LessThan([

            'value' =>4 ,
        ]));
    }

}
