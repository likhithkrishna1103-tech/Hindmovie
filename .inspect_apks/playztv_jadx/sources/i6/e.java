package i6;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import androidx.media3.decoder.DecoderInputBuffer;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class e implements s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6391a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f6392b;

    public /* synthetic */ e(Context context, int i) {
        this.f6391a = i;
        this.f6392b = context;
    }

    @Override // i6.s
    public final r a(x xVar) {
        switch (this.f6391a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return new b(this.f6392b, this);
            case 1:
                return new b(this.f6392b, this);
            case 2:
                return new b(this.f6392b, this);
            case 3:
                return new n(this.f6392b, 0);
            case b1.j.LONG_FIELD_NUMBER /* 4 */:
                return new b(this.f6392b, xVar.b(Integer.class, AssetFileDescriptor.class));
            case b1.j.STRING_FIELD_NUMBER /* 5 */:
                return new b(this.f6392b, xVar.b(Integer.class, InputStream.class));
            case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                return new n(this.f6392b, 1);
            default:
                return new n(this.f6392b, 2);
        }
    }
}
