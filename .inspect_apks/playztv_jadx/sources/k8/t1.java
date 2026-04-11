package k8;

import androidx.media3.decoder.DecoderInputBuffer;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class t1 implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7430a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f7431b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f7432c;

    public /* synthetic */ t1(Object obj, int i, Object obj2) {
        this.f7430a = i;
        this.f7432c = obj2;
        this.f7431b = obj;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.f7430a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                o1 o1Var = (o1) this.f7431b;
                o1Var.f7348d.d0();
                return new g(o1Var.f7348d.d(((a4) this.f7432c).f7076u));
            case 1:
                x3 x3Var = ((o1) this.f7431b).f7348d;
                x3Var.d0();
                i iVar = x3Var.f7546w;
                x3.y(iVar);
                return iVar.u2((String) this.f7432c);
            default:
                x3 x3Var2 = (x3) this.f7431b;
                a4 a4Var = (a4) this.f7432c;
                String str = a4Var.f7076u;
                t7.v.h(str);
                z1 z1VarI = x3Var2.I(str);
                y1 y1Var = y1.f7555w;
                if (z1VarI.i(y1Var) && z1.d(a4Var.P, 100).i(y1Var)) {
                    return x3Var2.j(a4Var).g();
                }
                x3Var2.g().I.d("Analytics storage consent denied. Returning null app instance id");
                return null;
        }
    }
}
