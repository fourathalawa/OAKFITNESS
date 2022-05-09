<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Produit
 *
 * @ORM\Table(name="produit")
 * @ORM\Entity
 */
class Produit
{
    /**
     * @var int
     *
     * @ORM\Column(name="IdProduit", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idproduit;

    /**
     * @var string
     *
     * @ORM\Column(name="NomProduit", type="string", length=255, nullable=false)
     */
    private $nomproduit;

    /**
     * @var string
     *
     * @ORM\Column(name="CategProduit", type="string", length=255, nullable=false)
     */
    private $categproduit;

    /**
     * @var string
     *
     * @ORM\Column(name="DescrProduit", type="string", length=255, nullable=false)
     */
    private $descrproduit;

    /**
     * @var float
     *
     * @ORM\Column(name="PrixProduit", type="float", precision=10, scale=0, nullable=false)
     */
    private $prixproduit;

    /**
     * @var int
     *
     * @ORM\Column(name="IsAvailable", type="integer", nullable=false)
     */
    private $isavailable;

    /**
     * @var string
     *
     * @ORM\Column(name="ImageProduit", type="string", length=255, nullable=false)
     */
    private $imageproduit;

    /**
     * @var int
     *
     * @ORM\Column(name="StockProduit", type="integer", nullable=false)
     */
    private $stockproduit;

    /**
     * @return int
     */
    public function getIdproduit(): int
    {
        return $this->idproduit;
    }

    /**
     * @param int $idproduit
     */
    public function setIdproduit(int $idproduit): void
    {
        $this->idproduit = $idproduit;
    }

    /**
     * @return string
     */
    public function getNomproduit(): string
    {
        return $this->nomproduit;
    }

    /**
     * @param string $nomproduit
     */
    public function setNomproduit(string $nomproduit): void
    {
        $this->nomproduit = $nomproduit;
    }

    /**
     * @return string
     */
    public function getCategproduit(): string
    {
        return $this->categproduit;
    }

    /**
     * @param string $categproduit
     */
    public function setCategproduit(string $categproduit): void
    {
        $this->categproduit = $categproduit;
    }

    /**
     * @return string
     */
    public function getDescrproduit(): string
    {
        return $this->descrproduit;
    }

    /**
     * @param string $descrproduit
     */
    public function setDescrproduit(string $descrproduit): void
    {
        $this->descrproduit = $descrproduit;
    }

    /**
     * @return float
     */
    public function getPrixproduit(): float
    {
        return $this->prixproduit;
    }

    /**
     * @param float $prixproduit
     */
    public function setPrixproduit(float $prixproduit): void
    {
        $this->prixproduit = $prixproduit;
    }

    /**
     * @return int
     */
    public function getIsavailable(): int
    {
        return $this->isavailable;
    }

    /**
     * @param int $isavailable
     */
    public function setIsavailable(int $isavailable): void
    {
        $this->isavailable = $isavailable;
    }

    /**
     * @return string
     */
    public function getImageproduit(): string
    {
        return $this->imageproduit;
    }

    /**
     * @param string $imageproduit
     */
    public function setImageproduit(string $imageproduit): void
    {
        $this->imageproduit = $imageproduit;
    }

    /**
     * @return int
     */
    public function getStockproduit(): int
    {
        return $this->stockproduit;
    }

    /**
     * @param int $stockproduit
     */
    public function setStockproduit(int $stockproduit): void
    {
        $this->stockproduit = $stockproduit;
    }


}
