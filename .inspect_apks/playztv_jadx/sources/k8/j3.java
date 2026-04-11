package k8;

import android.content.pm.PackageManager;
import android.os.SystemClock;
import android.util.Pair;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class j3 extends t3 {
    public final a2.e2 A;
    public final a2.e2 B;
    public final a2.e2 C;
    public final a2.e2 D;
    public final a2.e2 E;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final HashMap f7261y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final a2.e2 f7262z;

    public j3(x3 x3Var) {
        super(x3Var);
        this.f7261y = new HashMap();
        this.f7262z = new a2.e2(n1(), "last_delete_stale", 0L);
        this.A = new a2.e2(n1(), "last_delete_stale_batch", 0L);
        this.B = new a2.e2(n1(), "backoff", 0L);
        this.C = new a2.e2(n1(), "last_upload", 0L);
        this.D = new a2.e2(n1(), "last_upload_attempt", 0L);
        this.E = new a2.e2(n1(), "midnight_offset", 0L);
    }

    @Override // k8.t3
    public final boolean v1() {
        return false;
    }

    public final String w1(String str, boolean z2) {
        p1();
        String str2 = z2 ? (String) x1(str).first : "00000000-0000-0000-0000-000000000000";
        MessageDigest messageDigestC2 = h4.C2();
        if (messageDigestC2 == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new BigInteger(1, messageDigestC2.digest(str2.getBytes())));
    }

    public final Pair x1(String str) {
        i3 i3Var;
        n7.a aVarA;
        p1();
        k1 k1Var = (k1) this.f2454v;
        x7.a aVar = k1Var.H;
        e eVar = k1Var.A;
        aVar.getClass();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        HashMap map = this.f7261y;
        i3 i3Var2 = (i3) map.get(str);
        if (i3Var2 != null && jElapsedRealtime < i3Var2.f7246c) {
            return new Pair(i3Var2.f7244a, Boolean.valueOf(i3Var2.f7245b));
        }
        eVar.getClass();
        long jV1 = eVar.v1(str, w.f7465b) + jElapsedRealtime;
        try {
            try {
                aVarA = n7.b.a(k1Var.f7282u);
            } catch (PackageManager.NameNotFoundException unused) {
                if (i3Var2 != null && jElapsedRealtime < i3Var2.f7246c + eVar.v1(str, w.f7468c)) {
                    return new Pair(i3Var2.f7244a, Boolean.valueOf(i3Var2.f7245b));
                }
                aVarA = null;
            }
        } catch (Exception e10) {
            g().H.c(e10, "Unable to get advertising id");
            i3Var = new i3(jV1, "", false);
        }
        if (aVarA == null) {
            return new Pair("00000000-0000-0000-0000-000000000000", Boolean.FALSE);
        }
        String str2 = aVarA.f8825c;
        i3Var = str2 != null ? new i3(jV1, str2, aVarA.f8824b) : new i3(jV1, "", aVarA.f8824b);
        map.put(str, i3Var);
        return new Pair(i3Var.f7244a, Boolean.valueOf(i3Var.f7245b));
    }
}
