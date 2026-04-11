package k8;

import androidx.media3.decoder.DecoderInputBuffer;
import com.google.android.gms.internal.measurement.p5;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class f1 implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7174a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f7175b;

    public /* synthetic */ f1() {
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.f7174a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return new p5(((d1) this.f7175b).F);
            case 1:
                x3 x3Var = ((o1) this.f7175b).f7348d;
                x3Var.d0();
                s0 s0Var = x3Var.B;
                x3.y(s0Var);
                s0Var.p1();
                ((k1) s0Var.f2454v).getClass();
                throw new IllegalStateException("Unexpected call on client side");
            default:
                synchronized (((z5.c) this.f7175b)) {
                    try {
                        z5.c cVar = (z5.c) this.f7175b;
                        if (cVar.C == null) {
                            return null;
                        }
                        cVar.j0();
                        if (((z5.c) this.f7175b).H()) {
                            ((z5.c) this.f7175b).h0();
                            ((z5.c) this.f7175b).E = 0;
                        }
                        return null;
                    } finally {
                    }
                }
        }
    }

    public f1(o1 o1Var, v vVar, String str) {
        this.f7175b = o1Var;
    }

    public f1(z5.c cVar) {
        this.f7175b = cVar;
    }
}
