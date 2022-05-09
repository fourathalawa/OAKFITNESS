<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Salledesport
 *
 * @ORM\Table(name="salledesport")
 * @ORM\Entity
 */
class Salledesport
{
    /**
     * @var int
     *
     * @ORM\Column(name="Id_Salle", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idSalle;

    /**
     * @var string|null
     *
     * @ORM\Column(name="Adresse", type="string", length=300, nullable=true, options={"default"="NULL"})
     */
    private $adresse = 'NULL';

    /**
     * @var int|null
     *
     * @ORM\Column(name="Id_responsable", type="integer", nullable=true, options={"default"="NULL"})
     */
    private $idResponsable = NULL;

    /**
     * @var string
     *
     * @ORM\Column(name="NomSalle", type="string", length=30, nullable=false)
     */
    private $nomsalle;

    /**
     * @var float
     *
     * @ORM\Column(name="PrixSeance", type="float", precision=10, scale=0, nullable=false)
     */
    private $prixseance;


}
