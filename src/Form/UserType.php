<?php

namespace App\Form;

use App\Entity\User;
use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolver;

class UserType extends AbstractType
{
    public function buildForm(FormBuilderInterface $builder, array $options): void
    {
        $builder
            ->add('nomuser')
            ->add('prenomuser')
            ->add('mailuser')
            ->add('telephonenumberuser')
            ->add('datenaissanceuser')
            ->add('roleuser')
            ->add('numeropackuser')
            ->add('datecommence')
            ->add('experienceuser')
            ->add('diplomeuser')
            ->add('adressesallesport')
            ->add('matriculefiscale')
            ->add('password')
            ->add('codeverification')
            ->add('imageuser')
        ;
    }

    public function configureOptions(OptionsResolver $resolver): void
    {
        $resolver->setDefaults([
            'data_class' => User::class,
        ]);
    }
}
