package i6;

import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import androidx.media3.decoder.DecoderInputBuffer;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a0 implements s {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a0 f6377b = new a0(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6378a;

    public /* synthetic */ a0(int i) {
        this.f6378a = i;
    }

    @Override // i6.s
    public final r a(x xVar) {
        switch (this.f6378a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return b0.f6382b;
            case 1:
                return new b6.c(1, new c(0));
            case 2:
                return new b6.c(1, new c(1));
            case 3:
                return new b0(1);
            case b1.j.LONG_FIELD_NUMBER /* 4 */:
                return new z(xVar.b(Uri.class, AssetFileDescriptor.class), 0);
            case b1.j.STRING_FIELD_NUMBER /* 5 */:
                return new z(xVar.b(Uri.class, ParcelFileDescriptor.class), 0);
            case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                return new z(xVar.b(Uri.class, InputStream.class), 0);
            default:
                return new e0(xVar.b(h.class, InputStream.class));
        }
    }
}
