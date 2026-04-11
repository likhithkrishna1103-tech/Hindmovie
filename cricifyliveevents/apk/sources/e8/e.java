package e8;

import android.content.Context;
import androidx.media3.decoder.DecoderInputBuffer;
import vc.h0;
import vc.r0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e implements z7.b, xc.b {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f3835v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final qd.a f3836w;

    public /* synthetic */ e(qd.a aVar, int i) {
        this.f3835v = i;
        this.f3836w = aVar;
    }

    @Override // qd.a
    public final Object get() {
        switch (this.f3835v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                String packageName = ((Context) this.f3836w.get()).getPackageName();
                if (packageName != null) {
                    return packageName;
                }
                throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
            default:
                return new h0((r0) this.f3836w.get());
        }
    }
}
