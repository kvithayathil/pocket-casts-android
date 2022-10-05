package au.com.shiftyjelly.pocketcasts.compose.buttons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import au.com.shiftyjelly.pocketcasts.compose.AppTheme
import au.com.shiftyjelly.pocketcasts.compose.theme
import au.com.shiftyjelly.pocketcasts.ui.theme.Theme

@Composable
fun RowOutlinedButton(
    text: String,
    modifier: Modifier = Modifier,
    image: Painter? = null,
    textColor: Color = MaterialTheme.theme.colors.primaryInteractive01,
    borderWidth: Dp = 2.dp,
    borderColor: Color = MaterialTheme.theme.colors.primaryInteractive01,
    fontSize: TextUnit = 18.sp,
    fontWeight: FontWeight = FontWeight.SemiBold,
    includePadding: Boolean = true,
    onClick: () -> Unit
) {
    Row(
        modifier = modifier
            .then(if (includePadding) Modifier.padding(16.dp) else Modifier)
            .fillMaxWidth()
    ) {
        val borderStroke = remember(borderWidth, borderColor) {
            BorderStroke(borderWidth, borderColor)
        }
        OutlinedButton(
            onClick = { onClick() },
            shape = RoundedCornerShape(12.dp),
            border = borderStroke,
            modifier = Modifier.fillMaxWidth()
        ) {
            Box(contentAlignment = Alignment.CenterStart) {
                if (image != null) {
                    Image(
                        painter = image,
                        contentDescription = null
                    )
                }
                Text(
                    text = text,
                    textAlign = TextAlign.Center,
                    color = textColor,
                    fontSize = fontSize,
                    fontWeight = fontWeight,
                    modifier = Modifier
                        .padding(horizontal = 30.dp, vertical = 6.dp)
                        .fillMaxWidth()
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RowOutlinedButtonLightPreview() {
    AppTheme(Theme.ThemeType.LIGHT) {
        RowOutlinedButton(
            text = "Accept",
            onClick = {}
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF000000)
@Composable
fun RowOutlinedButtonDarkPreview() {
    AppTheme(Theme.ThemeType.DARK) {
        RowOutlinedButton(
            text = "Accept",
            onClick = {}
        )
    }
}
