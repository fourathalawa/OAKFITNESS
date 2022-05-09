<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Reclamation
 *
 * @ORM\Table(name="reclamation")
 * @ORM\Entity
 */
class Reclamation
{
    /**
     * @var int
     *
     * @ORM\Column(name="IDReclamation", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idreclamation;

    /**
     * @var int|null
     *
     * @ORM\Column(name="IDUserReclamation", type="integer", nullable=true, options={"default"="NULL"})
     */
    private $iduserreclamation = NULL;

    /**
     * @var string
     *
     * @ORM\Column(name="DescrReclam", type="string", length=500, nullable=false)
     */
    private $descrreclam;

    /**
     * @var int
     *
     * @ORM\Column(name="CategReclam", type="integer", nullable=false)
     */
    private $categreclam;

    /**
     * @var string
     *
     * @ORM\Column(name="DateReclam", type="string", length=255, nullable=false)
     */
    private $datereclam;

    /**
     * @var string
     *
     * @ORM\Column(name="EtatReclamation", type="string", length=110, nullable=false)
     */
    private $etatreclamation;

    /**
     * @var string|null
     *
     * @ORM\Column(name="CommentaireRec", type="string", length=255, nullable=true, options={"default"="NULL"})
     */
    private $commentairerec = 'NULL';

    /**
     * @var string|null
     *
     * @ORM\Column(name="PubRec", type="string", length=255, nullable=true, options={"default"="NULL"})
     */
    private $pubrec = 'NULL';

    /**
     * @var int|null
     *
     * @ORM\Column(name="idCommentReclam", type="integer", nullable=true, options={"default"="NULL"})
     */
    private $idcommentreclam = NULL;

    /**
     * @var int|null
     *
     * @ORM\Column(name="idReclameur", type="integer", nullable=true, options={"default"="NULL"})
     */
    private $idreclameur = NULL;


}
