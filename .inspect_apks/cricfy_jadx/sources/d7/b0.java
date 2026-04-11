package d7;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import androidx.media3.decoder.DecoderInputBuffer;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b0 implements u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3456a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Resources f3457b;

    public /* synthetic */ b0(Resources resources, int i) {
        this.f3456a = i;
        this.f3457b = resources;
    }

    @Override // d7.u
    public final t a(a0 a0Var) {
        switch (this.f3456a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return new b(this.f3457b, a0Var.b(Uri.class, AssetFileDescriptor.class));
            case 1:
                return new b(this.f3457b, a0Var.b(Uri.class, InputStream.class));
            default:
                return new b(this.f3457b, e0.f3467b);
        }
    }
}
