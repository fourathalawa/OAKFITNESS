<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Publication
 *
 * @ORM\Table(name="publication")
 * @ORM\Entity
 */
class Publication
{
    /**
     * @var int
     *
     * @ORM\Column(name="IDpublication", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idpublication;

    /**
     * @var int
     *
     * @ORM\Column(name="IDuser", type="integer", nullable=false)
     */
    private $iduser;

    /**
     * @var string
     *
     * @ORM\Column(name="DatePublication", type="string", length=255, nullable=false)
     */
    private $datepublication;

    /**
     * @var string
     *
     * @ORM\Column(name="Publication", type="string", length=255, nullable=false)
     */
    private $publication;


}
