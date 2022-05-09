<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Evenement
 *
 * @ORM\Table(name="evenement")
 * @ORM\Entity
 */
class Evenement
{
    /**
     * @var int
     *
     * @ORM\Column(name="IDEvenement", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idevenement;

    /**
     * @var string
     *
     * @ORM\Column(name="IDCreatorEvenement", type="string", length=100, nullable=false)
     */
    private $idcreatorevenement;

    /**
     * @var \DateTime|null
     *
     * @ORM\Column(name="DateEvenement", type="date", nullable=true, options={"default"="NULL"})
     */
    private $dateevenement = 'NULL';

    /**
     * @var string
     *
     * @ORM\Column(name="TitreEvenement", type="string", length=50, nullable=false)
     */
    private $titreevenement;

    /**
     * @var string
     *
     * @ORM\Column(name="DescrEvenement", type="string", length=200, nullable=false)
     */
    private $descrevenement;

    /**
     * @var string
     *
     * @ORM\Column(name="AdresseEvenement", type="string", length=30, nullable=false)
     */
    private $adresseevenement;

    /**
     * @var string
     *
     * @ORM\Column(name="TypeEvenement", type="string", length=20, nullable=false)
     */
    private $typeevenement;

    /**
     * @var string
     *
     * @ORM\Column(name="Image", type="string", length=200, nullable=false)
     */
    private $image;


}
