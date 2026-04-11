package g7;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import androidx.media3.decoder.DecoderInputBuffer;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b0 implements x6.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5172a;

    public /* synthetic */ b0(int i) {
        this.f5172a = i;
    }

    @Override // x6.j
    public final /* bridge */ /* synthetic */ boolean a(Object obj, x6.h hVar) {
        switch (this.f5172a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                break;
            case 1:
                break;
            default:
                break;
        }
        return true;
    }

    @Override // x6.j
    public final z6.b0 b(Object obj, int i, int i10, x6.h hVar) {
        switch (this.f5172a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return new a0(0, (Bitmap) obj);
            case 1:
                Drawable drawable = (Drawable) obj;
                if (drawable != null) {
                    return new i7.b(drawable, 0);
                }
                return null;
            default:
                return new a0((File) obj);
        }
    }
}
