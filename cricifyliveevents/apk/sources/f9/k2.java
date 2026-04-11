package f9;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class k2 implements Runnable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f4251v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ x2 f4252w;

    public /* synthetic */ k2(x2 x2Var, int i) {
        this.f4251v = i;
        this.f4252w = x2Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4251v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                this.f4252w.J1();
                break;
            case 1:
                p6.d dVar = this.f4252w.N;
                r1 r1Var = (r1) dVar.f10037w;
                p1 p1Var = r1Var.B;
                x2 x2Var = r1Var.H;
                f1 f1Var = r1Var.f4367z;
                r1.g(p1Var);
                p1Var.m1();
                if (dVar.H()) {
                    if (dVar.D()) {
                        r1.e(f1Var);
                        f1Var.S.t(null);
                        Bundle bundle = new Bundle();
                        bundle.putString("source", "(not set)");
                        bundle.putString("medium", "(not set)");
                        bundle.putString("_cis", "intent");
                        bundle.putLong("_cc", 1L);
                        r1.f(x2Var);
                        x2Var.t1("auto", "_cmpx", bundle);
                    } else {
                        r1.e(f1Var);
                        com.bumptech.glide.l lVar = f1Var.S;
                        String strR = lVar.r();
                        if (TextUtils.isEmpty(strR)) {
                            w0 w0Var = r1Var.A;
                            r1.g(w0Var);
                            w0Var.C.a("Cache still valid but referrer not found");
                        } else {
                            long jC = f1Var.T.c() / 3600000;
                            Uri uri = Uri.parse(strR);
                            Bundle bundle2 = new Bundle();
                            Pair pair = new Pair(uri.getPath(), bundle2);
                            for (String str : uri.getQueryParameterNames()) {
                                bundle2.putString(str, uri.getQueryParameter(str));
                            }
                            ((Bundle) pair.second).putLong("_cc", (jC - 1) * 3600000);
                            Object obj = pair.first;
                            String str2 = obj == null ? "app" : (String) obj;
                            r1.f(x2Var);
                            x2Var.t1(str2, "_cmp", (Bundle) pair.second);
                        }
                        lVar.t(null);
                    }
                    r1.e(f1Var);
                    f1Var.T.e(0L);
                    break;
                }
                break;
            case 2:
                x2 x2Var2 = this.f4252w;
                x2Var2.m1();
                r1 r1Var2 = (r1) x2Var2.f307w;
                f1 f1Var2 = r1Var2.f4367z;
                w0 w0Var2 = r1Var2.A;
                r1.e(f1Var2);
                d1 d1Var = f1Var2.P;
                if (d1Var.a()) {
                    r1.g(w0Var2);
                    w0Var2.I.a("Deferred Deep Link already retrieved. Not fetching again.");
                } else {
                    e1 e1Var = f1Var2.Q;
                    long jC2 = e1Var.c();
                    e1Var.e(1 + jC2);
                    if (jC2 >= 5) {
                        r1.g(w0Var2);
                        w0Var2.E.a("Permanently failed to retrieve Deferred Deep Link. Reached maximum retries.");
                        d1Var.b(true);
                    } else {
                        if (x2Var2.P == null) {
                            x2Var2.P = new l2(x2Var2, r1Var2, 3);
                        }
                        x2Var2.P.b(0L);
                    }
                }
                break;
            default:
                this.f4252w.J1();
                break;
        }
    }
}
