<?php

declare(strict_types=1);

namespace DoctrineMigrations;

use Doctrine\DBAL\Schema\Schema;
use Doctrine\Migrations\AbstractMigration;

/**
 * Auto-generated Migration: Please modify to your needs!
 */
final class Version20210508202324 extends AbstractMigration
{
    public function getDescription(): string
    {
        return '';
    }

    public function up(Schema $schema): void
    {
        // this up() migration is auto-generated, please modify it to your needs
        $this->addSql('ALTER TABLE component ADD supplier_id INT DEFAULT NULL');
        $this->addSql('ALTER TABLE component ADD CONSTRAINT FK_49FEA1572ADD6D8C FOREIGN KEY (supplier_id) REFERENCES supplier (id)');
        $this->addSql('CREATE INDEX IDX_49FEA1572ADD6D8C ON component (supplier_id)');
        $this->addSql('ALTER TABLE supplier ADD email VARCHAR(255) NOT NULL, ADD address VARCHAR(255) NOT NULL');
    }

    public function down(Schema $schema): void
    {
        // this down() migration is auto-generated, please modify it to your needs
        $this->addSql('ALTER TABLE component DROP FOREIGN KEY FK_49FEA1572ADD6D8C');
        $this->addSql('DROP INDEX IDX_49FEA1572ADD6D8C ON component');
        $this->addSql('ALTER TABLE component DROP supplier_id');
        $this->addSql('ALTER TABLE supplier DROP email, DROP address');
    }
}
