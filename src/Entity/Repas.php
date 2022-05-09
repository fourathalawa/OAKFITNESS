<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Repas
 *
 * @ORM\Table(name="repas")
 * @ORM\Entity
 */
class Repas
{
    /**
     * @var int
     *
     * @ORM\Column(name="IDRepas", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idrepas;

    /**
     * @var string
     *
     * @ORM\Column(name="PDej", type="string", length=2000, nullable=false)
     */
    private $pdej;

    /**
     * @var string
     *
     * @ORM\Column(name="Dej", type="string", length=2000, nullable=false)
     */
    private $dej;

    /**
     * @var string
     *
     * @ORM\Column(name="Dinn", type="string", length=2000, nullable=false)
     */
    private $dinn;

    /**
     * @var int
     *
     * @ORM\Column(name="Calorie", type="integer", nullable=false)
     */
    private $calorie;

    /**
     * @var string
     *
     * @ORM\Column(name="RestOrActive", type="string", length=20, nullable=false)
     */
    private $restoractive;

    /**
     * @var string
     *
     * @ORM\Column(name="Image", type="string", length=200, nullable=false)
     */
    private $image;


}
