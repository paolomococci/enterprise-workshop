<?php

declare(strict_types=1);

namespace DoctrineMigrations;

use Doctrine\DBAL\Schema\Schema;
use Doctrine\Migrations\AbstractMigration;

/**
 * Auto-generated Migration: Please modify to your needs!
 */
final class Version20210508202951 extends AbstractMigration
{
    public function getDescription(): string
    {
        return '';
    }

    public function up(Schema $schema): void
    {
        // this up() migration is auto-generated, please modify it to your needs
        $this->addSql('ALTER TABLE commodity ADD customer_id INT DEFAULT NULL');
        $this->addSql('ALTER TABLE commodity ADD CONSTRAINT FK_5E8D2F749395C3F3 FOREIGN KEY (customer_id) REFERENCES customer (id)');
        $this->addSql('CREATE INDEX IDX_5E8D2F749395C3F3 ON commodity (customer_id)');
        $this->addSql('ALTER TABLE customer ADD email VARCHAR(255) NOT NULL, ADD address VARCHAR(255) NOT NULL');
    }

    public function down(Schema $schema): void
    {
        // this down() migration is auto-generated, please modify it to your needs
        $this->addSql('ALTER TABLE commodity DROP FOREIGN KEY FK_5E8D2F749395C3F3');
        $this->addSql('DROP INDEX IDX_5E8D2F749395C3F3 ON commodity');
        $this->addSql('ALTER TABLE commodity DROP customer_id');
        $this->addSql('ALTER TABLE customer DROP email, DROP address');
    }
}
