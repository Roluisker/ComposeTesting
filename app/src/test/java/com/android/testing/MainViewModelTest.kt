package com.android.testing

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MainViewModelTest {

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var mainViewModel: MainViewModel

    @Before
    fun setUp() {
        mainViewModel = MainViewModel()
    }

    @Test
    fun mainViewModel_Increment() {
        Assert.assertEquals(0, mainViewModel.counter.value)
        mainViewModel.counterIncrement()
        Assert.assertEquals(1, mainViewModel.counter.value)
    }
}