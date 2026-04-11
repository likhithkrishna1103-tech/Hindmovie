package androidx.fragment.app;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class t0 implements androidx.lifecycle.r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1075a;

    @Override // androidx.lifecycle.r0
    public final androidx.lifecycle.o0 a(Class cls) {
        switch (this.f1075a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return new u0(true);
            case 1:
                return new androidx.navigation.h();
            default:
                return new u1.a();
        }
    }

    @Override // androidx.lifecycle.r0
    public final androidx.lifecycle.o0 b(Class cls, t1.c cVar) {
        switch (this.f1075a) {
        }
        return a(cls);
    }
}
