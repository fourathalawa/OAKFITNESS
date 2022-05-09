<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * ProgrammesExercice
 *
 * @ORM\Table(name="programmes_exercice", indexes={@ORM\Index(name="FK_IDExercice", columns={"IDExercice"}), @ORM\Index(name="FK_IDProgrammeSportif", columns={"IDProgrammeSportif"})})
 * @ORM\Entity
 */
class ProgrammesExercice
{
    /**
     * @var int
     *
     * @ORM\Column(name="IDPS_exercice", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idpsExercice;

    /**
     * @var int
     *
     * @ORM\Column(name="IDProgrammeSportif", type="integer", nullable=false)
     */
    private $idprogrammesportif;

    /**
     * @var int
     *
     * @ORM\Column(name="IDExercice", type="integer", nullable=false)
     */
    private $idexercice;

    /**
     * @var string
     *
     * @ORM\Column(name="JourExercice", type="string", length=50, nullable=false)
     */
    private $jourexercice;


}
