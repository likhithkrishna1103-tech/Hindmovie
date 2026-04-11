package b6;

import androidx.media3.decoder.DecoderInputBuffer;
import i6.r;
import i6.s;
import i6.x;
import ue.d;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b implements s {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile ue.s f1824c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1825a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f1826b;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(int i) {
        this(f1824c);
        this.f1825a = i;
        switch (i) {
            case 1:
                this.f1826b = new i6.c(3);
                return;
            case 2:
                this.f1826b = new wb.c(18);
                return;
            default:
                if (f1824c == null) {
                    synchronized (b.class) {
                        try {
                            if (f1824c == null) {
                                f1824c = new ue.s();
                            }
                        } finally {
                        }
                        break;
                    }
                }
                return;
        }
    }

    @Override // i6.s
    public final r a(x xVar) {
        switch (this.f1825a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return new c(0, (d) this.f1826b);
            case 1:
                return new c(2, (i6.c) this.f1826b);
            default:
                return new j6.a((wb.c) this.f1826b);
        }
    }

    public b(d dVar) {
        this.f1825a = 0;
        this.f1826b = dVar;
    }
}
