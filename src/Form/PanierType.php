<?php

namespace App\Form;

use App\Entity\Commande;
use App\Entity\Panier;
use App\Entity\Produit;
use http\Client\Curl\User;
use Symfony\Bridge\Doctrine\Form\Type\EntityType;
use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolver;

class PanierType extends AbstractType
{
    public function buildForm(FormBuilderInterface $builder, array $options): void
    {
        $builder
            ->add('imageproduit',
                EntityType::class,
                ['label'=>'imageproduit','class'=>Produit::class,
                    'choice_label'=>'imageProduit','multiple'=>false,'expanded'=>false])
            ->add('quantity')
            ->add('total')
            ->add('idClient',
                EntityType::class,
                ['label'=>'iduser','class'=>\App\Entity\User::class,
                    'choice_label'=>'iduser','multiple'=>false,'expanded'=>false])

        ->add('id_commande',
            EntityType::class,
            ['label'=>'id','class'=>commande::class,
                'choice_label'=>'id','multiple'=>false,'expanded'=>false]);



    }

    public function configureOptions(OptionsResolver $resolver): void
    {
        $resolver->setDefaults([
            'data_class' => Panier::class,
        ]);
    }
}
