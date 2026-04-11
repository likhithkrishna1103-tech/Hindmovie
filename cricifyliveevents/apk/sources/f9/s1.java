package f9;

import androidx.media3.decoder.DecoderInputBuffer;
import java.util.Objects;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class s1 implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4392a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f4393b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f4394c;

    public /* synthetic */ s1(a2 a2Var, Object obj, int i) {
        this.f4392a = i;
        this.f4394c = obj;
        this.f4393b = a2Var;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.f4392a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                a2 a2Var = (a2) this.f4393b;
                a2Var.f4001d.w();
                n nVar = a2Var.f4001d.f4355x;
                q4.P(nVar);
                return nVar.h2((String) this.f4394c);
            case 1:
                a2 a2Var2 = (a2) this.f4393b;
                a2Var2.f4001d.w();
                return new i(a2Var2.f4001d.m0(((w4) this.f4394c).f4462v));
            default:
                w4 w4Var = (w4) this.f4394c;
                String str = w4Var.f4462v;
                o8.u.g(str);
                q4 q4Var = (q4) this.f4393b;
                g2 g2VarA = q4Var.a(str);
                f2 f2Var = f2.f4171x;
                if (g2VarA.i(f2Var) && g2.c(100, w4Var.N).i(f2Var)) {
                    return q4Var.X(w4Var).E();
                }
                q4Var.C().J.a("Analytics storage consent denied. Returning null app instance id");
                return null;
        }
    }

    public s1(q4 q4Var, w4 w4Var) {
        this.f4392a = 2;
        this.f4394c = w4Var;
        Objects.requireNonNull(q4Var);
        this.f4393b = q4Var;
    }
}
