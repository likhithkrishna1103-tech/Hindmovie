package i6;

import android.net.Uri;
import androidx.media3.decoder.DecoderInputBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d0 implements r {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set f6389b = Collections.unmodifiableSet(new HashSet(Arrays.asList("file", "content", "android.resource")));

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f6390a;

    public d0(c0 c0Var) {
        this.f6390a = c0Var;
    }

    @Override // i6.r
    public final q a(Object obj, int i, int i10, c6.i iVar) {
        com.bumptech.glide.load.data.e aVar;
        Uri uri = (Uri) obj;
        w6.d dVar = new w6.d(uri);
        c0 c0Var = (c0) this.f6390a;
        switch (c0Var.f6385a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                aVar = new com.bumptech.glide.load.data.a(c0Var.f6386b, uri, 0);
                break;
            case 1:
                aVar = new com.bumptech.glide.load.data.a(c0Var.f6386b, uri, 1);
                break;
            default:
                aVar = new com.bumptech.glide.load.data.n(1, uri, c0Var.f6386b);
                break;
        }
        return new q(dVar, aVar);
    }

    @Override // i6.r
    public final boolean b(Object obj) {
        return f6389b.contains(((Uri) obj).getScheme());
    }
}
