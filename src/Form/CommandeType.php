<?php

namespace App\Form;

use App\Entity\Commande;
use App\Entity\User;
use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\Extension\Core\Type\SubmitType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolver;
use Symfony\Bridge\Doctrine\Form\Type\EntityType;

class CommandeType extends AbstractType
{
    public function buildForm(FormBuilderInterface $builder, array $options): void
    {
        $builder
            ->add('id')
            ->add('datecommande', DateTimeType::class)
            ->add('total')
            ->add('etat')
            ->add('avisclient')
            ->add('idClient',
                EntityType::class,
                ['label'=>'iduser','class'=>\App\Entity\User::class,
                    'choice_label'=>'iduser','multiple'=>false,'expanded'=>false])
        ;
    }

    public function configureOptions(OptionsResolver $resolver): void
    {
        $resolver->setDefaults([
            'data_class' => Commande::class,
        ]);
    }
}
