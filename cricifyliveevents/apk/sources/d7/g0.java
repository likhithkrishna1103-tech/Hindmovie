package d7;

import android.net.Uri;
import androidx.media3.decoder.DecoderInputBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class g0 implements t {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set f3478b = Collections.unmodifiableSet(new HashSet(Arrays.asList("file", "content", "android.resource")));

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f3479a;

    public g0(f0 f0Var) {
        this.f3479a = f0Var;
    }

    @Override // d7.t
    public final s a(Object obj, int i, int i10, x6.h hVar) {
        com.bumptech.glide.load.data.d aVar;
        Uri uri = (Uri) obj;
        r7.b bVar = new r7.b(uri);
        f0 f0Var = (f0) this.f3479a;
        switch (f0Var.f3473a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                aVar = new com.bumptech.glide.load.data.a(f0Var.f3474b, uri, f0Var.f3475c, 0);
                break;
            case 1:
                aVar = new com.bumptech.glide.load.data.a(f0Var.f3474b, uri, f0Var.f3475c, 1);
                break;
            default:
                aVar = new com.bumptech.glide.load.data.n(f0Var.f3474b, uri, f0Var.f3475c);
                break;
        }
        return new s(bVar, aVar);
    }

    @Override // d7.t
    public final boolean b(Object obj) {
        return f3478b.contains(((Uri) obj).getScheme());
    }
}
