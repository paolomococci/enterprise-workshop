<?php

declare(strict_types=1);

namespace DoctrineMigrations;

use Doctrine\DBAL\Schema\Schema;
use Doctrine\Migrations\AbstractMigration;

/**
 * Auto-generated Migration: Please modify to your needs!
 */
final class Version20210510070424 extends AbstractMigration
{
    public function getDescription(): string
    {
        return '';
    }

    public function up(Schema $schema): void
    {
        // this up() migration is auto-generated, please modify it to your needs
        $this->addSql('ALTER TABLE guest ADD tryst_id INT DEFAULT NULL');
        $this->addSql('ALTER TABLE guest ADD CONSTRAINT FK_ACB79A35D9CD6CFE FOREIGN KEY (tryst_id) REFERENCES tryst (id)');
        $this->addSql('CREATE INDEX IDX_ACB79A35D9CD6CFE ON guest (tryst_id)');
    }

    public function down(Schema $schema): void
    {
        // this down() migration is auto-generated, please modify it to your needs
        $this->addSql('ALTER TABLE guest DROP FOREIGN KEY FK_ACB79A35D9CD6CFE');
        $this->addSql('DROP INDEX IDX_ACB79A35D9CD6CFE ON guest');
        $this->addSql('ALTER TABLE guest DROP tryst_id');
    }
}
