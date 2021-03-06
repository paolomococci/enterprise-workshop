<?php

namespace App\Entity;

use App\Repository\PostRepository;
use Doctrine\ORM\Mapping as ORM;

/**
 * @ORM\Entity(repositoryClass=PostRepository::class)
 */
class Post
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
    private $title;

    /**
     * @ORM\Column(type="text")
     */
    private $merit;

    /**
     * @ORM\Column(type="datetime")
     */
    private $at;

    /**
     * @ORM\ManyToOne(targetEntity=Guest::class, inversedBy="posts")
     */
    private $guest;
    
    public function __construct() 
    {
        $this->at = new \DateTime();
    }

    public function getId(): ?int
    {
        return $this->id;
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

    public function getMerit(): ?string
    {
        return $this->merit;
    }

    public function setMerit(string $merit): self
    {
        $this->merit = $merit;

        return $this;
    }

    public function getAt(): ?\DateTimeInterface
    {
        return $this->at;
    }

    public function setAt(\DateTimeInterface $at): self
    {
        $this->at = $at;

        return $this;
    }

    public function getGuest(): ?Guest
    {
        return $this->guest;
    }

    public function setGuest(?Guest $guest): self
    {
        $this->guest = $guest;

        return $this;
    }
    
    public function __toString(): string
    {
        return (string) $this->id.') '.$this->title;
    }
}
