package l0;

import android.graphics.BlendMode;
import android.graphics.Insets;
import android.graphics.Paint;
import android.os.Trace;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {
    public static boolean a() {
        return Trace.isEnabled();
    }

    public static Object b(int i) {
        switch (y.e.c(i)) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return BlendMode.CLEAR;
            case 1:
                return BlendMode.SRC;
            case 2:
                return BlendMode.DST;
            case 3:
                return BlendMode.SRC_OVER;
            case g1.h.LONG_FIELD_NUMBER /* 4 */:
                return BlendMode.DST_OVER;
            case g1.h.STRING_FIELD_NUMBER /* 5 */:
                return BlendMode.SRC_IN;
            case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                return BlendMode.DST_IN;
            case g1.h.DOUBLE_FIELD_NUMBER /* 7 */:
                return BlendMode.SRC_OUT;
            case g1.h.BYTES_FIELD_NUMBER /* 8 */:
                return BlendMode.DST_OUT;
            case 9:
                return BlendMode.SRC_ATOP;
            case 10:
                return BlendMode.DST_ATOP;
            case 11:
                return BlendMode.XOR;
            case 12:
                return BlendMode.PLUS;
            case 13:
                return BlendMode.MODULATE;
            case 14:
                return BlendMode.SCREEN;
            case 15:
                return BlendMode.OVERLAY;
            case 16:
                return BlendMode.DARKEN;
            case 17:
                return BlendMode.LIGHTEN;
            case 18:
                return BlendMode.COLOR_DODGE;
            case 19:
                return BlendMode.COLOR_BURN;
            case 20:
                return BlendMode.HARD_LIGHT;
            case 21:
                return BlendMode.SOFT_LIGHT;
            case 22:
                return BlendMode.DIFFERENCE;
            case 23:
                return BlendMode.EXCLUSION;
            case 24:
                return BlendMode.MULTIPLY;
            case 25:
                return BlendMode.HUE;
            case 26:
                return BlendMode.SATURATION;
            case 27:
                return BlendMode.COLOR;
            case 28:
                return BlendMode.LUMINOSITY;
            default:
                return null;
        }
    }

    public static Insets c(int i, int i10, int i11, int i12) {
        return Insets.of(i, i10, i11, i12);
    }

    public static void d(Paint paint, Object obj) {
        paint.setBlendMode((BlendMode) obj);
    }
}
