package com.example.mobiledevolopment.theme

import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.dp

@Immutable
class Shapes (
    val small: CornerBasedShape = RoundedCornerShape(4.dp),
    val medium: CornerBasedShape = RoundedCornerShape(4.dp),
    val large: CornerBasedShape = RoundedCornerShape(4.dp)
) {
    fun copy (
        small: CornerBasedShape = this.small,
        medium: CornerBasedShape =this.medium,
        large: CornerBasedShape =this.large,
    )
            = Shapes (small, medium, large)
}