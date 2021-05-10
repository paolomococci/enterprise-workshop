<?php

namespace App\Entity;

use App\Repository\TrystRepository;
use Doctrine\Common\Collections\ArrayCollection;
use Doctrine\Common\Collections\Collection;
use Doctrine\ORM\Mapping as ORM;

/**
 * @ORM\Entity(repositoryClass=TrystRepository::class)
 */
class Tryst
{
    /**
     * @ORM\Id
     * @ORM\GeneratedValue
     * @ORM\Column(type="integer")
     */
    private $id;

    /**
     * @ORM\Column(type="string", length=255)
     */
    private $name;

    /**
     * @ORM\Column(type="string", length=255)
     */
    private $title;

    /**
     * @ORM\Column(type="text", nullable=true)
     */
    private $topic;

    /**
     * @ORM\Column(type="date", nullable=true)
     */
    private $day;

    /**
     * @ORM\Column(type="time", nullable=true)
     */
    private $hour;

    /**
     * @ORM\OneToMany(targetEntity=Guest::class, mappedBy="tryst")
     */
    private $guests;

    public function __construct()
    {
        $this->guests = new ArrayCollection();
    }

    public function getId(): ?int
    {
        return $this->id;
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

    public function getTitle(): ?string
    {
        return $this->title;
    }

    public function setTitle(string $title): self
    {
        $this->title = $title;

        return $this;
    }

    public function getTopic(): ?string
    {
        return $this->topic;
    }

    public function setTopic(?string $topic): self
    {
        $this->topic = $topic;

        return $this;
    }

    public function getDay(): ?\DateTimeInterface
    {
        return $this->day;
    }

    public function setDay(?\DateTimeInterface $day): self
    {
        $this->day = $day;

        return $this;
    }

    public function getHour(): ?\DateTimeInterface
    {
        return $this->hour;
    }

    public function setHour(?\DateTimeInterface $hour): self
    {
        $this->hour = $hour;

        return $this;
    }

    /**
     * @return Collection|Guest[]
     */
    public function getGuests(): Collection
    {
        return $this->guests;
    }

    public function addGuest(Guest $guest): self
    {
        if (!$this->guests->contains($guest)) {
            $this->guests[] = $guest;
            $guest->setTryst($this);
        }

        return $this;
    }

    public function removeGuest(Guest $guest): self
    {
        if ($this->guests->removeElement($guest)) {
            // set the owning side to null (unless already changed)
            if ($guest->getTryst() === $this) {
                $guest->setTryst(null);
            }
        }

        return $this;
    }
    
    public function __toString(): string
    {
        return (string) $this->id.' '.$this->name;
    }
}
