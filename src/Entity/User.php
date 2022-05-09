<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * User
 *
 * @ORM\Table(name="user")
 * @ORM\Entity
 */
class User
{
    /**
     * @var int
     *
     * @ORM\Column(name="IdUser", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $iduser;

    /**
     * @var string
     *
     * @ORM\Column(name="NomUser", type="string", length=50, nullable=false)
     */
    private $nomuser;

    /**
     * @var string
     *
     * @ORM\Column(name="PrenomUser", type="string", length=50, nullable=false)
     */
    private $prenomuser;

    /**
     * @var string
     *
     * @ORM\Column(name="MailUser", type="string", length=60, nullable=false)
     */
    private $mailuser;

    /**
     * @var int
     *
     * @ORM\Column(name="TelephoneNumberUser", type="bigint", nullable=false)
     */
    private $telephonenumberuser;

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="DateNaissanceUser", type="date", nullable=false)
     */
    private $datenaissanceuser;

    /**
     * @var int
     *
     * @ORM\Column(name="RoleUser", type="integer", nullable=false)
     */
    private $roleuser;

    /**
     * @var int|null
     *
     * @ORM\Column(name="NumeroPackUser", type="integer", nullable=true, options={"default"="NULL"})
     */
    private $numeropackuser = NULL;

    /**
     * @var \DateTime|null
     *
     * @ORM\Column(name="DateCommence", type="date", nullable=true, options={"default"="NULL"})
     */
    private $datecommence = 'NULL';

    /**
     * @var string|null
     *
     * @ORM\Column(name="ExperienceUser", type="string", length=150, nullable=true, options={"default"="NULL"})
     */
    private $experienceuser = 'NULL';

    /**
     * @var string|null
     *
     * @ORM\Column(name="DiplomeUser", type="string", length=150, nullable=true, options={"default"="NULL"})
     */
    private $diplomeuser = 'NULL';

    /**
     * @var string|null
     *
     * @ORM\Column(name="AdresseSalleSport", type="string", length=150, nullable=true, options={"default"="NULL"})
     */
    private $adressesallesport = 'NULL';

    /**
     * @var int|null
     *
     * @ORM\Column(name="MatriculeFiscale", type="bigint", nullable=true, options={"default"="NULL"})
     */
    private $matriculefiscale = 'NULL';

    /**
     * @var string|null
     *
     * @ORM\Column(name="Password", type="string", length=45, nullable=true, options={"default"="NULL"})
     */
    private $password = 'NULL';

    /**
     * @var int|null
     *
     * @ORM\Column(name="CodeVerification", type="integer", nullable=true, options={"default"="NULL"})
     */
    private $codeverification = NULL;

    /**
     * @var string|null
     *
     * @ORM\Column(name="imageUser", type="string", length=250, nullable=true, options={"default"="NULL"})
     */
    private $imageuser = 'NULL';

    /**
     * @return int
     */
    public function getIduser():?int
    {
        return $this->iduser;
    }

    /**
     * @param int $iduser
     */
    public function setIduser(?int $iduser): void
    {
        $this->iduser = $iduser;
    }

    /**
     * @return string
     */
    public function getNomuser(): string
    {
        return $this->nomuser;
    }

    /**
     * @param string $nomuser
     */
    public function setNomuser(string $nomuser): void
    {
        $this->nomuser = $nomuser;
    }

    /**
     * @return string
     */
    public function getPrenomuser(): string
    {
        return $this->prenomuser;
    }

    /**
     * @param string $prenomuser
     */
    public function setPrenomuser(string $prenomuser): void
    {
        $this->prenomuser = $prenomuser;
    }

    /**
     * @return string
     */
    public function getMailuser(): string
    {
        return $this->mailuser;
    }

    /**
     * @param string $mailuser
     */
    public function setMailuser(string $mailuser): void
    {
        $this->mailuser = $mailuser;
    }

    /**
     * @return int
     */
    public function getTelephonenumberuser(): int
    {
        return $this->telephonenumberuser;
    }

    /**
     * @param int $telephonenumberuser
     */
    public function setTelephonenumberuser(int $telephonenumberuser): void
    {
        $this->telephonenumberuser = $telephonenumberuser;
    }

    /**
     * @return \DateTime
     */
    public function getDatenaissanceuser(): \DateTime
    {
        return $this->datenaissanceuser;
    }

    /**
     * @param \DateTime $datenaissanceuser
     */
    public function setDatenaissanceuser(\DateTime $datenaissanceuser): void
    {
        $this->datenaissanceuser = $datenaissanceuser;
    }

    /**
     * @return int
     */
    public function getRoleuser(): int
    {
        return $this->roleuser;
    }

    /**
     * @param int $roleuser
     */
    public function setRoleuser(int $roleuser): void
    {
        $this->roleuser = $roleuser;
    }

    /**
     * @return int|null
     */
    public function getNumeropackuser(): ?int
    {
        return $this->numeropackuser;
    }

    /**
     * @param int|null $numeropackuser
     */
    public function setNumeropackuser(?int $numeropackuser): void
    {
        $this->numeropackuser = $numeropackuser;
    }

    /**
     * @return \DateTime|null
     */
    public function getDatecommence(): \DateTime|string|null
    {
        return $this->datecommence;
    }

    /**
     * @param \DateTime|null $datecommence
     */
    public function setDatecommence(\DateTime|string|null $datecommence): void
    {
        $this->datecommence = $datecommence;
    }

    /**
     * @return string|null
     */
    public function getExperienceuser(): ?string
    {
        return $this->experienceuser;
    }

    /**
     * @param string|null $experienceuser
     */
    public function setExperienceuser(?string $experienceuser): void
    {
        $this->experienceuser = $experienceuser;
    }

    /**
     * @return string|null
     */
    public function getDiplomeuser(): ?string
    {
        return $this->diplomeuser;
    }

    /**
     * @param string|null $diplomeuser
     */
    public function setDiplomeuser(?string $diplomeuser): void
    {
        $this->diplomeuser = $diplomeuser;
    }

    /**
     * @return string|null
     */
    public function getAdressesallesport(): ?string
    {
        return $this->adressesallesport;
    }

    /**
     * @param string|null $adressesallesport
     */
    public function setAdressesallesport(?string $adressesallesport): void
    {
        $this->adressesallesport = $adressesallesport;
    }

    /**
     * @return int|null
     */
    public function getMatriculefiscale(): int|string|null
    {
        return $this->matriculefiscale;
    }

    /**
     * @param int|null $matriculefiscale
     */
    public function setMatriculefiscale(int|string|null $matriculefiscale): void
    {
        $this->matriculefiscale = $matriculefiscale;
    }

    /**
     * @return string|null
     */
    public function getPassword(): ?string
    {
        return $this->password;
    }

    /**
     * @param string|null $password
     */
    public function setPassword(?string $password): void
    {
        $this->password = $password;
    }

    /**
     * @return int|null
     */
    public function getCodeverification(): ?int
    {
        return $this->codeverification;
    }

    /**
     * @param int|null $codeverification
     */
    public function setCodeverification(?int $codeverification): void
    {
        $this->codeverification = $codeverification;
    }

    /**
     * @return string|null
     */
    public function getImageuser(): ?string
    {
        return $this->imageuser;
    }

    /**
     * @param string|null $imageuser
     */
    public function setImageuser(?string $imageuser): void
    {
        $this->imageuser = $imageuser;
    }
    public function toString() {
        return $this->iduser;
    }

}
