/*
 * Copyright (C) 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.unscramble
// 10 раздел https://web.archive.org/web/20210918160955/https://developer.android.com/codelabs/basic-android-kotlin-training-viewmodel#1

//1 раздел
// https://web.archive.org/web/20211113015819/https://developer.android.com/codelabs/basic-android-kotlin-training-livedata?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-kotlin-unit-3-pathway-3%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fbasic-android-kotlin-training-livedata#0
//https://web.archive.org/web/20230602155014/https://developer.android.com/courses/pathways/android-basics-kotlin-unit-3-pathway-3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * Creates an Activity that hosts the Game fragment in the app
 * 14. Резюме
 * Рекомендации по архитектуре приложений Android рекомендуют разделять классы с разными обязанностями и управлять пользовательским интерфейсом на основе модели.
 * Контроллер пользовательского интерфейса — это класс на основе пользовательского интерфейса, такой как Activityили Fragment. Контроллеры пользовательского интерфейса должны содержать только логику, которая обрабатывает взаимодействие пользовательского интерфейса и операционной системы; они не должны быть источником данных, отображаемых в пользовательском интерфейсе. Поместите эти данные и всю связанную с ними логику в файл ViewModel.
 * Класс ViewModelхранит и управляет данными, связанными с пользовательским интерфейсом. Класс ViewModelпозволяет данным сохраняться при изменении конфигурации, например при повороте экрана.
 * ViewModelявляется одним из рекомендуемых компонентов архитектуры Android.
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
    }
}
