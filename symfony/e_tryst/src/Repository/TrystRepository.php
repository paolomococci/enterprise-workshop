<?php

namespace App\Repository;

use App\Entity\Tryst;
use Doctrine\Bundle\DoctrineBundle\Repository\ServiceEntityRepository;
use Doctrine\Persistence\ManagerRegistry;

/**
 * @method Tryst|null find($id, $lockMode = null, $lockVersion = null)
 * @method Tryst|null findOneBy(array $criteria, array $orderBy = null)
 * @method Tryst[]    findAll()
 * @method Tryst[]    findBy(array $criteria, array $orderBy = null, $limit = null, $offset = null)
 */
class TrystRepository extends ServiceEntityRepository
{
    public function __construct(ManagerRegistry $registry)
    {
        parent::__construct($registry, Tryst::class);
    }

    // /**
    //  * @return Tryst[] Returns an array of Tryst objects
    //  */
    /*
    public function findByExampleField($value)
    {
        return $this->createQueryBuilder('t')
            ->andWhere('t.exampleField = :val')
            ->setParameter('val', $value)
            ->orderBy('t.id', 'ASC')
            ->setMaxResults(10)
            ->getQuery()
            ->getResult()
        ;
    }
    */

    /*
    public function findOneBySomeField($value): ?Tryst
    {
        return $this->createQueryBuilder('t')
            ->andWhere('t.exampleField = :val')
            ->setParameter('val', $value)
            ->getQuery()
            ->getOneOrNullResult()
        ;
    }
    */
}
