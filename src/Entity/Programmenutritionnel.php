<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Programmenutritionnel
 *
 * @ORM\Table(name="programmenutritionnel")
 * @ORM\Entity
 */
class Programmenutritionnel
{
    /**
     * @var int
     *
     * @ORM\Column(name="IDProgrammeNutritionnel", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idprogrammenutritionnel;

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
     * @ORM\Column(name="Calorie", type="integer", nullable=false)
     */
    private $calorie;

    /**
     * @var string
     *
     * @ORM\Column(name="TypeProgrammeNutritionnel", type="string", length=20, nullable=false)
     */
    private $typeprogrammenutritionnel;


}
