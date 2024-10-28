package com.example.boruto.domain.use_cases

import com.example.boruto.domain.use_cases.read_onboarding.ReadOnBoardingUseCase
import com.example.boruto.domain.use_cases.save_onboarding.SaveOnBoardingUseCase

data class UseCases(
    val readOnBoardingUseCase: ReadOnBoardingUseCase,
    val saveOnBoardingUseCase: SaveOnBoardingUseCase
)
