<?php

declare(strict_types=1);

namespace DoctrineMigrations;

use Doctrine\DBAL\Schema\Schema;
use Doctrine\Migrations\AbstractMigration;

/**
 * Auto-generated Migration: Please modify to your needs!
 */
final class Version20210507155315 extends AbstractMigration
{
    public function getDescription(): string
    {
        return '';
    }

    public function up(Schema $schema): void
    {
        // this up() migration is auto-generated, please modify it to your needs
        $this->addSql('CREATE TABLE commodity (id INT AUTO_INCREMENT NOT NULL, code VARCHAR(8) NOT NULL, name VARCHAR(128) NOT NULL, batch INT DEFAULT NULL, PRIMARY KEY(id)) DEFAULT CHARACTER SET utf8mb4 COLLATE `utf8mb4_unicode_ci` ENGINE = InnoDB');
        $this->addSql('CREATE TABLE component (id INT AUTO_INCREMENT NOT NULL, commodity_id INT DEFAULT NULL, code VARCHAR(8) NOT NULL, name VARCHAR(128) NOT NULL, quantity NUMERIC(10, 5) DEFAULT NULL, INDEX IDX_49FEA157B4ACC212 (commodity_id), PRIMARY KEY(id)) DEFAULT CHARACTER SET utf8mb4 COLLATE `utf8mb4_unicode_ci` ENGINE = InnoDB');
        $this->addSql('ALTER TABLE component ADD CONSTRAINT FK_49FEA157B4ACC212 FOREIGN KEY (commodity_id) REFERENCES commodity (id)');
    }

    public function down(Schema $schema): void
    {
        // this down() migration is auto-generated, please modify it to your needs
        $this->addSql('ALTER TABLE component DROP FOREIGN KEY FK_49FEA157B4ACC212');
        $this->addSql('DROP TABLE commodity');
        $this->addSql('DROP TABLE component');
    }
}
