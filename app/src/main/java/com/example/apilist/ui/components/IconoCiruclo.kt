package com.example.apilist.ui.components

import android.R.attr.fillAlpha
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.materialIcon
import androidx.compose.material.icons.materialPath
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.Path
import androidx.compose.ui.graphics.vector.path

val Icons.Outlined.ThinCircle: ImageVector
    @Composable
    get() {
        if (_thinCircle != null) {
            return _thinCircle!!
        }
        _thinCircle = materialIcon(name = "Outlined.ThinCircle") {
            path(
                fill = null,
                stroke = androidx.compose.ui.graphics.SolidColor(androidx.compose.ui.graphics.Color.Black),
                strokeLineWidth = 0.5f, // Ajusta el grosor del trazo
                strokeLineCap = androidx.compose.ui.graphics.StrokeCap.Butt,
                strokeLineJoin = androidx.compose.ui.graphics.StrokeJoin.Miter,
                pathFillType = androidx.compose.ui.graphics.PathFillType.NonZero
            ) {
                moveTo(12.0f, 2.0f)
                curveTo(6.47f, 2.0f, 2.0f, 6.47f, 2.0f, 12.0f)
                curveToRelative(0.0f, 5.53f, 4.47f, 10.0f, 10.0f, 10.0f)
                reflectiveCurveToRelative(10.1f, -4.47f, 10.0f, -10.0f)
                curveTo(22.0f, 6.47f, 17.53f, 2.0f, 12.0f, 2.0f)
                close()
            }
        }
        return _thinCircle!!
    }

private var _thinCircle: ImageVector? = null