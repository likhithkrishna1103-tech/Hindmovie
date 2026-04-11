package l6;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import androidx.media3.decoder.DecoderInputBuffer;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class z implements c6.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8018a;

    public /* synthetic */ z(int i) {
        this.f8018a = i;
    }

    @Override // c6.k
    public final /* bridge */ /* synthetic */ boolean a(Object obj, c6.i iVar) {
        switch (this.f8018a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                break;
            case 1:
                break;
            default:
                break;
        }
        return true;
    }

    @Override // c6.k
    public final e6.b0 b(Object obj, int i, int i10, c6.i iVar) {
        switch (this.f8018a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return new y(0, (Bitmap) obj);
            case 1:
                Drawable drawable = (Drawable) obj;
                if (drawable != null) {
                    return new n6.b(drawable, 0);
                }
                return null;
            default:
                return new y((File) obj);
        }
    }
}
