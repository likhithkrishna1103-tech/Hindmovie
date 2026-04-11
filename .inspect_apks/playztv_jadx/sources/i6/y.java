package i6;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import androidx.media3.decoder.DecoderInputBuffer;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class y implements s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6440a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Resources f6441b;

    public /* synthetic */ y(Resources resources, int i) {
        this.f6440a = i;
        this.f6441b = resources;
    }

    @Override // i6.s
    public final r a(x xVar) {
        switch (this.f6440a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return new b(this.f6441b, xVar.b(Uri.class, AssetFileDescriptor.class));
            case 1:
                return new b(this.f6441b, xVar.b(Uri.class, InputStream.class));
            default:
                return new b(this.f6441b, b0.f6382b);
        }
    }
}
