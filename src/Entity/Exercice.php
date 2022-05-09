<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Exercice
 *
 * @ORM\Table(name="exercice")
 * @ORM\Entity
 */
class Exercice
{
    /**
     * @var int
     *
     * @ORM\Column(name="IDExercice", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idexercice;

    /**
     * @var string
     *
     * @ORM\Column(name="TypeExercice", type="string", length=20, nullable=false)
     */
    private $typeexercice;

    /**
     * @var string
     *
     * @ORM\Column(name="NomExercice", type="string", length=50, nullable=false)
     */
    private $nomexercice;

    /**
     * @var string
     *
     * @ORM\Column(name="Muscle", type="string", length=70, nullable=false)
     */
    private $muscle;

    /**
     * @var string
     *
     * @ORM\Column(name="Video", type="string", length=150, nullable=false)
     */
    private $video;

    /**
     * @var string
     *
     * @ORM\Column(name="DescrExercice", type="string", length=2000, nullable=false)
     */
    private $descrexercice;

    /**
     * @var string
     *
     * @ORM\Column(name="DiffExercice", type="string", length=20, nullable=false)
     */
    private $diffexercice;

    /**
     * @var string
     *
     * @ORM\Column(name="JusteSalleExercice", type="string", length=20, nullable=false)
     */
    private $justesalleexercice;

    /**
     * @var string
     *
     * @ORM\Column(name="DureeExercice", type="string", length=30, nullable=false)
     */
    private $dureeexercice;

    /**
     * @var string
     *
     * @ORM\Column(name="Image", type="string", length=200, nullable=false)
     */
    private $image;


}
