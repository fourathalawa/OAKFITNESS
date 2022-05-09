<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Challenge
 *
 * @ORM\Table(name="challenge")
 * @ORM\Entity
 */
class Challenge
{
    /**
     * @var int
     *
     * @ORM\Column(name="IdChallenge", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idchallenge;

    /**
     * @var string
     *
     * @ORM\Column(name="DateDebut", type="string", length=20, nullable=false)
     */
    private $datedebut;

    /**
     * @var string
     *
     * @ORM\Column(name="DateFin", type="string", length=20, nullable=false)
     */
    private $datefin;

    /**
     * @var float|null
     *
     * @ORM\Column(name="PoidInt", type="float", precision=10, scale=0, nullable=true, options={"default"="NULL"})
     */
    private $poidint = NULL;

    /**
     * @var float|null
     *
     * @ORM\Column(name="PoidOb", type="float", precision=10, scale=0, nullable=true, options={"default"="NULL"})
     */
    private $poidob = NULL;

    /**
     * @var float|null
     *
     * @ORM\Column(name="Taille", type="float", precision=10, scale=0, nullable=true, options={"default"="NULL"})
     */
    private $taille = NULL;

    /**
     * @var float|null
     *
     * @ORM\Column(name="PoidNv", type="float", precision=10, scale=0, nullable=true, options={"default"="NULL"})
     */
    private $poidnv = NULL;

    /**
     * @var int|null
     *
     * @ORM\Column(name="IdUser", type="integer", nullable=true, options={"default"="NULL"})
     */
    private $iduser = NULL;


}
