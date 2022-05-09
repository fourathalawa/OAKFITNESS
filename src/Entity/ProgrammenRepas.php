<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * ProgrammenRepas
 *
 * @ORM\Table(name="programmen_repas", indexes={@ORM\Index(name="FK_IDProgrammeNutritionnel", columns={"IDProgrammeNutritionnel"}), @ORM\Index(name="FK_IDRepas", columns={"IDRepas"})})
 * @ORM\Entity
 */
class ProgrammenRepas
{
    /**
     * @var int
     *
     * @ORM\Column(name="IDPN_r", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idpnR;

    /**
     * @var int
     *
     * @ORM\Column(name="IDProgrammeNutritionnel", type="integer", nullable=false)
     */
    private $idprogrammenutritionnel;

    /**
     * @var int
     *
     * @ORM\Column(name="IDRepas", type="integer", nullable=false)
     */
    private $idrepas;

    /**
     * @var string
     *
     * @ORM\Column(name="JourRepas", type="string", length=25, nullable=false)
     */
    private $jourrepas;


}
