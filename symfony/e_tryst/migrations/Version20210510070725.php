<?php

declare(strict_types=1);

namespace DoctrineMigrations;

use Doctrine\DBAL\Schema\Schema;
use Doctrine\Migrations\AbstractMigration;

/**
 * Auto-generated Migration: Please modify to your needs!
 */
final class Version20210510070725 extends AbstractMigration
{
    public function getDescription(): string
    {
        return '';
    }

    public function up(Schema $schema): void
    {
        // this up() migration is auto-generated, please modify it to your needs
        $this->addSql('ALTER TABLE post ADD guest_id INT DEFAULT NULL');
        $this->addSql('ALTER TABLE post ADD CONSTRAINT FK_5A8A6C8D9A4AA658 FOREIGN KEY (guest_id) REFERENCES guest (id)');
        $this->addSql('CREATE INDEX IDX_5A8A6C8D9A4AA658 ON post (guest_id)');
    }

    public function down(Schema $schema): void
    {
        // this down() migration is auto-generated, please modify it to your needs
        $this->addSql('ALTER TABLE post DROP FOREIGN KEY FK_5A8A6C8D9A4AA658');
        $this->addSql('DROP INDEX IDX_5A8A6C8D9A4AA658 ON post');
        $this->addSql('ALTER TABLE post DROP guest_id');
    }
}
