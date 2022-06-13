package com.teamb.runningtracker.data.proto

import androidx.datastore.core.Serializer
import com.google.protobuf.InvalidProtocolBufferException
import com.teamb.runningtracker.UserDetail
import java.io.InputStream
import java.io.OutputStream

object UserDetailSerializer : Serializer<UserDetail> {
    override val defaultValue: UserDetail
        get() = UserDetail.getDefaultInstance()

    override suspend fun readFrom(input: InputStream): UserDetail {
        try {
            return UserDetail.parseFrom(input)
        } catch (e: InvalidProtocolBufferException) {
            throw  ConcurrentModificationException(" cannot read proto", e)
        }
    }

    override suspend fun writeTo(t: UserDetail, output: OutputStream) {
        t.writeTo(output)
    }
}