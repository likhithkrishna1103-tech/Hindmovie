package androidx.fragment.app;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class p0 implements androidx.lifecycle.r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1342a;

    @Override // androidx.lifecycle.r0
    public final androidx.lifecycle.o0 a(Class cls) {
        switch (this.f1342a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return new q0(true);
            default:
                return new o1.a();
        }
    }

    @Override // androidx.lifecycle.r0
    public final androidx.lifecycle.o0 b(Class cls, n1.c cVar) {
        switch (this.f1342a) {
        }
        return a(cls);
    }
}
