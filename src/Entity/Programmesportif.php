<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Programmesportif
 *
 * @ORM\Table(name="programmesportif")
 * @ORM\Entity
 */
class Programmesportif
{
    /**
     * @var int
     *
     * @ORM\Column(name="IDProgrammeSportif", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idprogrammesportif;

    /**
     * @var string
     *
     * @ORM\Column(name="IDCoach", type="string", length=100, nullable=false)
     */
    private $idcoach;

    /**
     * @var string
     *
     * @ORM\Column(name="IDAdherent", type="string", length=100, nullable=false)
     */
    private $idadherent;

    /**
     * @var int
     *
     * @ORM\Column(name="DureeMois", type="integer", nullable=false)
     */
    private $dureemois;

    /**
     * @var string
     *
     * @ORM\Column(name="TypeProgrammeSportif", type="string", length=20, nullable=false)
     */
    private $typeprogrammesportif;


}
