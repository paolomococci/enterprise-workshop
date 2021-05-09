<?php

namespace App\Entity;

use App\Repository\CommodityRepository;
use Doctrine\Common\Collections\ArrayCollection;
use Doctrine\Common\Collections\Collection;
use Doctrine\ORM\Mapping as ORM;

/**
 * @ORM\Entity(repositoryClass=CommodityRepository::class)
 */
class Commodity
{
    /**
     * @ORM\Id
     * @ORM\GeneratedValue
     * @ORM\Column(type="integer")
     */
    private $id;

    /**
     * @ORM\Column(type="string", length=8)
     */
    private $code;

    /**
     * @ORM\Column(type="string", length=128)
     */
    private $name;

    /**
     * @ORM\Column(type="integer", nullable=true)
     */
    private $batch;

    /**
     * @ORM\OneToMany(targetEntity=Component::class, mappedBy="commodity")
     */
    private $items;

    /**
     * @ORM\ManyToOne(targetEntity=Customer::class, inversedBy="goods")
     */
    private $customer;

    public function __construct()
    {
        $this->items = new ArrayCollection();
    }

    public function getId(): ?int
    {
        return $this->id;
    }

    public function getCode(): ?string
    {
        return $this->code;
    }

    public function setCode(string $code): self
    {
        $this->code = $code;

        return $this;
    }

    public function getName(): ?string
    {
        return $this->name;
    }

    public function setName(string $name): self
    {
        $this->name = $name;

        return $this;
    }

    public function getBatch(): ?int
    {
        return $this->batch;
    }

    public function setBatch(?int $batch): self
    {
        $this->batch = $batch;

        return $this;
    }

    /**
     * @return Collection|Component[]
     */
    public function getItems(): Collection
    {
        return $this->items;
    }

    public function addItem(Component $item): self
    {
        if (!$this->items->contains($item)) {
            $this->items[] = $item;
            $item->setCommodity($this);
        }

        return $this;
    }

    public function removeItem(Component $item): self
    {
        if ($this->items->removeElement($item)) {
            // set the owning side to null (unless already changed)
            if ($item->getCommodity() === $this) {
                $item->setCommodity(null);
            }
        }

        return $this;
    }

    public function getCustomer(): ?Customer
    {
        return $this->customer;
    }

    public function setCustomer(?Customer $customer): self
    {
        $this->customer = $customer;

        return $this;
    }
    
    public function __toString(): string
    {
        return (string) $this->id.' '.$this->code.' '.$this->name;
    }
}
