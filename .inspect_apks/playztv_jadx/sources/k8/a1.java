package k8;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7069a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k1 f7070b;

    public /* synthetic */ a1(k1 k1Var, int i) {
        this.f7069a = i;
        this.f7070b = k1Var;
    }

    public void a(String str, Bundle bundle) {
        String string;
        k1 k1Var = this.f7070b;
        z0 z0Var = k1Var.B;
        h1 h1Var = k1Var.D;
        k1.f(h1Var);
        h1Var.p1();
        if (k1Var.h()) {
            return;
        }
        if (bundle.isEmpty()) {
            string = null;
        } else {
            if (str.isEmpty()) {
                str = "auto";
            }
            Uri.Builder builder = new Uri.Builder();
            builder.path(str);
            for (String str2 : bundle.keySet()) {
                builder.appendQueryParameter(str2, bundle.getString(str2));
            }
            string = builder.build().toString();
        }
        if (TextUtils.isEmpty(string)) {
            return;
        }
        k1.d(z0Var);
        z0Var.S.r(string);
        k1.d(z0Var);
        a2.e2 e2Var = z0Var.T;
        k1Var.H.getClass();
        e2Var.d(System.currentTimeMillis());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean b() {
        switch (this.f7069a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                k1 k1Var = this.f7070b;
                boolean z2 = false;
                try {
                    wc.b bVarA = z7.b.a(k1Var.f7282u);
                    if (bVarA == null) {
                        p0 p0Var = k1Var.C;
                        k1.f(p0Var);
                        p0Var.I.d("Failed to get PackageManager for Install Referrer Play Store compatibility check");
                        k1Var = k1Var;
                    } else {
                        int i = bVarA.c("com.android.vending", 128).versionCode;
                        k1Var = i;
                        if (i >= 80837300) {
                            z2 = true;
                            k1Var = i;
                        }
                    }
                    break;
                } catch (Exception e10) {
                    p0 p0Var2 = k1Var.C;
                    k1.f(p0Var2);
                    p0Var2.I.c(e10, "Failed to retrieve Play Store version for Install Referrer");
                }
                return z2;
            default:
                k1 k1Var2 = this.f7070b;
                if (TextUtils.isEmpty(k1Var2.f7283v)) {
                    p0 p0Var3 = k1Var2.C;
                    k1.f(p0Var3);
                    if (p0Var3.x1(3)) {
                        return true;
                    }
                }
                return false;
        }
    }

    public boolean c() {
        z0 z0Var = this.f7070b.B;
        k1.d(z0Var);
        return z0Var.T.c() > 0;
    }

    public boolean d() {
        if (!c()) {
            return false;
        }
        k1 k1Var = this.f7070b;
        k1Var.H.getClass();
        long jCurrentTimeMillis = System.currentTimeMillis();
        z0 z0Var = k1Var.B;
        k1.d(z0Var);
        return jCurrentTimeMillis - z0Var.T.c() > k1Var.A.v1(null, w.W);
    }

    public a1(x3 x3Var) {
        this.f7069a = 0;
        this.f7070b = x3Var.F;
    }
}
