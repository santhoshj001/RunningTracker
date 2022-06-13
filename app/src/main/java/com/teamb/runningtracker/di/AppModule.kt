package com.teamb.runningtracker.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.core.DataStoreFactory
import androidx.datastore.dataStoreFile
import androidx.room.Room
import com.teamb.runningtracker.UserDetail
import com.teamb.runningtracker.common.Constants
import com.teamb.runningtracker.data.local.RunDao
import com.teamb.runningtracker.data.local.RunDatabase
import com.teamb.runningtracker.data.proto.UserDetailSerializer
import com.teamb.runningtracker.data.repository.RunLocalRepository
import com.teamb.runningtracker.data.repository.UserDetailRepository
import com.teamb.runningtracker.domain.repository.RunLocalRepositoryImpl
import com.teamb.runningtracker.domain.repository.UserDetailRepositoryImpl
import com.teamb.runningtracker.domain.usecase.runlist.*
import com.teamb.runningtracker.domain.usecase.runstatistics.*
import com.teamb.runningtracker.domain.usecase.userdetail.GetUserDetailUseCase
import com.teamb.runningtracker.domain.usecase.userdetail.SaveUserDetailUseCase
import com.teamb.runningtracker.domain.usecase.userdetail.UserDetailUseCase
import com.teamb.runningtracker.domain.usecase.validation.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesRunDataBase(@ApplicationContext context: Context): RunDatabase {
        return Room.databaseBuilder(
            context,
            RunDatabase::class.java,
            "run_database"
        ).build()
    }

    @Provides
    @Singleton
    fun providesDao(database: RunDatabase): RunDao {
        return database.runDao
    }

    @Provides
    @Singleton
    fun providesLocalRepository(database: RunDatabase): RunLocalRepository {
        return RunLocalRepositoryImpl(database.runDao)
    }

    @Provides
    @Singleton
    fun providesRunListUseCase(repository: RunLocalRepository): RunListUseCase {
        return RunListUseCase(
            getRunsByDistanceUseCase = GetRunsByDistanceUseCase(
                repository = repository
            ), getRunsByTimeInMillisUseCase = GetRunsByTimeInMillisUseCase(
                repository = repository
            ), getRunsByTimeStampUseCase = GetRunsByTimeStampUseCase(
                repository = repository
            ), getRunsByAvgSpeedUseCase = GetRunsByAvgSpeedUseCase(
                repository = repository
            ), getRunsByCaloriesUseCase = GetRunsByCaloriesUseCase(
                repository = repository
            )
        )
    }

    @Provides
    @Singleton
    fun providesRunStatisticsUseCase(repository: RunLocalRepository): RunStatisticsUseCase {
        return RunStatisticsUseCase(
            getTotalDistanceUseCase = GetTotalDistanceCoveredUseCase(
                repository = repository
            ), getTotalTimeInMillisUseCase = GetTotalTimeInMillisUseCase(
                repository = repository
            ), getTotalCaloriesBurnedUseCase = GetTotalCaloriesBurnedUseCase(
                repository = repository
            ), getTotalAvgSpeedUseCase = GetTotalAvgSpeedUseCase(
                repository = repository
            )
        )
    }

    @Provides
    @Singleton
    fun providesProtoDataStore(@ApplicationContext context: Context)
            : DataStore<UserDetail> {
        return DataStoreFactory.create(
            serializer = UserDetailSerializer,
            produceFile = {
                context.dataStoreFile(Constants.PROTO_DATA_STORE)
            }
        )

    }

    @Provides
    @Singleton
    fun providesUserDetailRepository(datastore: DataStore<UserDetail>): UserDetailRepository {
        return UserDetailRepositoryImpl(datastore)
    }

    @Provides
    @Singleton
    fun providesUserDetailUseCase(userDetailRepository: UserDetailRepository): UserDetailUseCase {
        return UserDetailUseCase(
            getUserDetailUseCase = GetUserDetailUseCase(
                userDetailRepository = userDetailRepository
            ), saveUserDetailUseCase = SaveUserDetailUseCase(
                userDetailRepository = userDetailRepository
            )
        )
    }


    @Provides
    @Singleton
    fun providesValidationUseCase(): ValidationUseCase {
        return ValidationUseCase(
            firstNameValidationUseCase = FirstNameValidationUseCase(),
            lastNameValidationUseCase = LastNameValidationUseCase(),
            ageValidationUseCase = AgeValidationUseCase(),
            weightValidationUseCase = WeightValidationUseCase()
        )
    }
}