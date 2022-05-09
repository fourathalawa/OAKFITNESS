<?php

namespace App\Form;

use App\Entity\Programmenutritionnel;
use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolver;

class ProgrammenutritionnelType extends AbstractType
{
    public function buildForm(FormBuilderInterface $builder, array $options): void
    {
        $builder
            ->add('idcoach')
            ->add('idadherent')
            ->add('calorie')
            ->add('typeprogrammenutritionnel')
        ;
    }

    public function configureOptions(OptionsResolver $resolver): void
    {
        $resolver->setDefaults([
            'data_class' => Programmenutritionnel::class,
        ]);
    }
}
