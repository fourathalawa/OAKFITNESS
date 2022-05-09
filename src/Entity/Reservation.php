<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Reservation
 *
 * @ORM\Table(name="reservation")
 * @ORM\Entity
 */
class Reservation
{
    /**
     * @var int
     *
     * @ORM\Column(name="IdReservation", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idreservation;

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="DateReservation", type="date", nullable=false)
     */
    private $datereservation;

    /**
     * @var int
     *
     * @ORM\Column(name="IdUser", type="integer", nullable=false)
     */
    private $iduser;

    /**
     * @var string
     *
     * @ORM\Column(name="NomSalle", type="string", length=500, nullable=false)
     */
    private $nomsalle;

    /**
     * @var bool
     *
     * @ORM\Column(name="AccCoach", type="boolean", nullable=false)
     */
    private $acccoach;

    /**
     * @var bool
     *
     * @ORM\Column(name="AccResponsable", type="boolean", nullable=false)
     */
    private $accresponsable;


}
