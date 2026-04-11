package l0;

import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.Build;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f7606a = 0;

    static {
        new ThreadLocal();
    }

    public static void a(int i, h6.a aVar) {
        PorterDuff.Mode mode;
        if (Build.VERSION.SDK_INT >= 29) {
            a.d(aVar, i != 0 ? a.b(i) : null);
            return;
        }
        if (i == 0) {
            aVar.setXfermode(null);
            return;
        }
        switch (y.e.c(i)) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                mode = PorterDuff.Mode.CLEAR;
                break;
            case 1:
                mode = PorterDuff.Mode.SRC;
                break;
            case 2:
                mode = PorterDuff.Mode.DST;
                break;
            case 3:
                mode = PorterDuff.Mode.SRC_OVER;
                break;
            case g1.h.LONG_FIELD_NUMBER /* 4 */:
                mode = PorterDuff.Mode.DST_OVER;
                break;
            case g1.h.STRING_FIELD_NUMBER /* 5 */:
                mode = PorterDuff.Mode.SRC_IN;
                break;
            case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                mode = PorterDuff.Mode.DST_IN;
                break;
            case g1.h.DOUBLE_FIELD_NUMBER /* 7 */:
                mode = PorterDuff.Mode.SRC_OUT;
                break;
            case g1.h.BYTES_FIELD_NUMBER /* 8 */:
                mode = PorterDuff.Mode.DST_OUT;
                break;
            case 9:
                mode = PorterDuff.Mode.SRC_ATOP;
                break;
            case 10:
                mode = PorterDuff.Mode.DST_ATOP;
                break;
            case 11:
                mode = PorterDuff.Mode.XOR;
                break;
            case 12:
                mode = PorterDuff.Mode.ADD;
                break;
            case 13:
                mode = PorterDuff.Mode.MULTIPLY;
                break;
            case 14:
                mode = PorterDuff.Mode.SCREEN;
                break;
            case 15:
                mode = PorterDuff.Mode.OVERLAY;
                break;
            case 16:
                mode = PorterDuff.Mode.DARKEN;
                break;
            case 17:
                mode = PorterDuff.Mode.LIGHTEN;
                break;
            default:
                mode = null;
                break;
        }
        aVar.setXfermode(mode != null ? new PorterDuffXfermode(mode) : null);
    }
}
