package k8;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class n1 implements Runnable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f7329u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public /* synthetic */ g2 f7330v;

    public /* synthetic */ n1(int i) {
        this.f7329u = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f7329u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                this.f7330v.N1();
                break;
            case 1:
                g2 g2Var = this.f7330v;
                g2Var.p1();
                if (g2Var.n1().P.b()) {
                    g2Var.g().H.d("Deferred Deep Link already retrieved. Not fetching again.");
                } else {
                    long jC = g2Var.n1().Q.c();
                    g2Var.n1().Q.d(1 + jC);
                    if (jC >= 5) {
                        g2Var.g().D.d("Permanently failed to retrieve Deferred Deep Link. Reached maximum retries.");
                        g2Var.n1().P.a(true);
                    } else {
                        if (g2Var.N == null) {
                            g2Var.N = new m2(g2Var, (k1) g2Var.f2454v, 2);
                        }
                        g2Var.N.b(0L);
                    }
                }
                break;
            case 2:
                a1 a1Var = this.f7330v.L;
                k1 k1Var = a1Var.f7070b;
                h1 h1Var = k1Var.D;
                g2 g2Var2 = k1Var.J;
                z0 z0Var = k1Var.B;
                k1.f(h1Var);
                h1Var.p1();
                if (a1Var.c()) {
                    if (a1Var.d()) {
                        k1.d(z0Var);
                        z0Var.S.r(null);
                        Bundle bundle = new Bundle();
                        bundle.putString("source", "(not set)");
                        bundle.putString("medium", "(not set)");
                        bundle.putString("_cis", "intent");
                        bundle.putLong("_cc", 1L);
                        k1.e(g2Var2);
                        g2Var2.T1("auto", "_cmpx", bundle);
                    } else {
                        k1.d(z0Var);
                        String strO = z0Var.S.o();
                        if (TextUtils.isEmpty(strO)) {
                            p0 p0Var = k1Var.C;
                            k1.f(p0Var);
                            p0Var.B.d("Cache still valid but referrer not found");
                        } else {
                            k1.d(z0Var);
                            long jC2 = ((z0Var.T.c() / 3600000) - 1) * 3600000;
                            Uri uri = Uri.parse(strO);
                            Bundle bundle2 = new Bundle();
                            Pair pair = new Pair(uri.getPath(), bundle2);
                            for (String str : uri.getQueryParameterNames()) {
                                bundle2.putString(str, uri.getQueryParameter(str));
                            }
                            ((Bundle) pair.second).putLong("_cc", jC2);
                            Object obj = pair.first;
                            String str2 = obj == null ? "app" : (String) obj;
                            k1.e(g2Var2);
                            g2Var2.T1(str2, "_cmp", (Bundle) pair.second);
                        }
                        k1.d(z0Var);
                        z0Var.S.r(null);
                    }
                    k1.d(z0Var);
                    z0Var.T.d(0L);
                    break;
                }
                break;
            default:
                this.f7330v.N1();
                break;
        }
    }

    public n1(g2 g2Var) {
        this.f7329u = 2;
        this.f7330v = g2Var;
    }
}
