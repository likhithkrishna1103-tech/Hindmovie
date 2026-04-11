package d1;

import androidx.media3.decoder.DecoderInputBuffer;
import java.io.File;
import java.io.IOException;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class n extends ge.j implements fe.a {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ int f3276w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ h0 f3277x;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ n(h0 h0Var, int i) {
        super(0);
        this.f3276w = i;
        this.f3277x = h0Var;
    }

    @Override // fe.a
    public final Object b() throws IOException {
        switch (this.f3276w) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return ((o0) this.f3277x.f3242j.getValue()).f3284c;
            default:
                l0 l0Var = this.f3277x.f3235a;
                File canonicalFile = ((File) l0Var.f3270c.b()).getCanonicalFile();
                synchronized (l0.f3267e) {
                    String absolutePath = canonicalFile.getAbsolutePath();
                    LinkedHashSet linkedHashSet = l0.f3266d;
                    if (linkedHashSet.contains(absolutePath)) {
                        throw new IllegalStateException(("There are multiple DataStores active for the same file: " + absolutePath + ". You should either maintain your DataStore as a singleton or confirm that there is no two DataStore's active on the same file (by confirming that the scope is cancelled).").toString());
                    }
                    ge.i.d(absolutePath, "path");
                    linkedHashSet.add(absolutePath);
                }
                return new o0(canonicalFile, l0Var.f3268a, (s0) l0Var.f3269b.a(canonicalFile), new androidx.lifecycle.j0(1, canonicalFile));
        }
    }
}
