package w6;

import androidx.media3.decoder.DecoderInputBuffer;
import d7.a0;
import d7.c;
import d7.d;
import d7.t;
import d7.u;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements u {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile kf.u f14023c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f14024a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f14025b;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(int i) {
        this(f14023c);
        this.f14024a = i;
        switch (i) {
            case 1:
                this.f14025b = new c(3);
                return;
            case 2:
                this.f14025b = new pc.c(8);
                return;
            default:
                if (f14023c == null) {
                    synchronized (b.class) {
                        try {
                            if (f14023c == null) {
                                f14023c = new kf.u();
                            }
                        } finally {
                        }
                        break;
                    }
                }
                return;
        }
    }

    @Override // d7.u
    public final t a(a0 a0Var) {
        switch (this.f14024a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return new d(3, (kf.d) this.f14025b);
            case 1:
                return new d(1, (c) this.f14025b);
            default:
                return new e7.a((pc.c) this.f14025b);
        }
    }

    public b(kf.d dVar) {
        this.f14024a = 0;
        this.f14025b = dVar;
    }
}
