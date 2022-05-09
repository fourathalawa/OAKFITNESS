<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Notecommentaire
 *
 * @ORM\Table(name="notecommentaire")
 * @ORM\Entity
 */
class Notecommentaire
{
    /**
     * @var int
     *
     * @ORM\Column(name="idNote", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idnote;

    /**
     * @var int
     *
     * @ORM\Column(name="userID", type="integer", nullable=false)
     */
    private $userid;

    /**
     * @var int
     *
     * @ORM\Column(name="IDCommentaire", type="integer", nullable=false)
     */
    private $idcommentaire;

    /**
     * @var int
     *
     * @ORM\Column(name="isLike", type="integer", nullable=false)
     */
    private $islike;


}
