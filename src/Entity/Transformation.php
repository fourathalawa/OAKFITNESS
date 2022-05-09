<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Transformation
 *
 * @ORM\Table(name="transformation")
 * @ORM\Entity
 */
class Transformation
{
    /**
     * @var int
     *
     * @ORM\Column(name="IdImage", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idimage;

    /**
     * @var string
     *
     * @ORM\Column(name="TitreImage", type="string", length=255, nullable=false)
     */
    private $titreimage;

    /**
     * @var string
     *
     * @ORM\Column(name="DescreptionImage", type="string", length=255, nullable=false)
     */
    private $descreptionimage;

    /**
     * @var string
     *
     * @ORM\Column(name="ImageAvant", type="string", length=255, nullable=false)
     */
    private $imageavant;

    /**
     * @var string
     *
     * @ORM\Column(name="ImageApres", type="string", length=255, nullable=false)
     */
    private $imageapres;

    /**
     * @var int
     *
     * @ORM\Column(name="IdUser", type="integer", nullable=false)
     */
    private $iduser;

    /**
     * @var float
     *
     * @ORM\Column(name="PoidAvant", type="float", precision=10, scale=0, nullable=false)
     */
    private $poidavant;

    /**
     * @var float
     *
     * @ORM\Column(name="PoidApres", type="float", precision=10, scale=0, nullable=false)
     */
    private $poidapres;

    /**
     * @var float
     *
     * @ORM\Column(name="TailleAvant", type="float", precision=10, scale=0, nullable=false)
     */
    private $tailleavant;

    /**
     * @var float
     *
     * @ORM\Column(name="TailleApres", type="float", precision=10, scale=0, nullable=false)
     */
    private $tailleapres;

    /**
     * @var int
     *
     * @ORM\Column(name="Tlike", type="integer", nullable=false)
     */
    private $tlike;


}
