package com.example.core2.remote

import com.example.core2.domain.models.Unit
import com.example.core2.domain.repository.UnitRepository
import com.example.core2.utils.Resource
import com.google.firebase.firestore.CollectionReference
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

class UnitRepositoryImpl (
    private val unitRefs : CollectionReference
) : UnitRepository {
    override fun getAllUnits(): Flow<Resource<List<Unit>>> = callbackFlow {
        val snapshotListener = unitRefs.addSnapshotListener { snapshot, e ->
            val unitResponse = if (snapshot != null && !snapshot.isEmpty) {
                val units = snapshot.toObjects(Unit::class.java)
                Resource.Success(units)
            } else {
                Resource.Error(e?.localizedMessage ?: "An Unknown Error Occurred")
            }
            trySend(unitResponse)
        }
        awaitClose {
            snapshotListener.remove()
        }
    }

    override fun getUnitById(unitId: String): Flow<Resource<Unit>> = callbackFlow {
        val snapshotListener = unitRefs.document(unitId).addSnapshotListener { snapshot, e ->
            val unitResponse = if (snapshot != null) {
                val unit = snapshot.toObject(Unit::class.java)
                Resource.Success(unit!!)
            } else {
                Resource.Error(message = e?.localizedMessage ?: "An Unknown Error Occurred")
            }
            trySend(unitResponse)
        }
        awaitClose {
            snapshotListener.remove()
        }
    }
}