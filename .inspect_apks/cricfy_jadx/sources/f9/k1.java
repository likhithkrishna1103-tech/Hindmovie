package f9;

import androidx.media3.decoder.DecoderInputBuffer;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class k1 implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4249a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f4250b;

    public /* synthetic */ k1(int i, Object obj) {
        this.f4249a = i;
        this.f4250b = obj;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.f4249a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return new com.google.android.gms.internal.measurement.k4(((l1) this.f4250b).G);
            case 1:
                a2 a2Var = (a2) this.f4250b;
                a2Var.f4001d.w();
                a1 a1Var = a2Var.f4001d.C;
                q4.P(a1Var);
                a1Var.m1();
                throw new IllegalStateException("Unexpected call on client side");
            default:
                synchronized (((u6.c) this.f4250b)) {
                    try {
                        u6.c cVar = (u6.c) this.f4250b;
                        if (cVar.D == null) {
                            return null;
                        }
                        cVar.h0();
                        if (((u6.c) this.f4250b).C()) {
                            ((u6.c) this.f4250b).e0();
                            ((u6.c) this.f4250b).F = 0;
                        }
                        return null;
                    } finally {
                    }
                }
        }
    }

    public k1(a2 a2Var, v vVar, String str) {
        this.f4249a = 1;
        this.f4250b = a2Var;
    }
}
