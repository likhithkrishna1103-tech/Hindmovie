package f9;

import android.content.pm.PackageManager;
import android.os.SystemClock;
import android.util.Pair;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class v3 extends l4 {
    public final e1 A;
    public final e1 B;
    public final e1 C;
    public final e1 D;
    public final e1 E;
    public final e1 F;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final HashMap f4451z;

    public v3(q4 q4Var) {
        super(q4Var);
        this.f4451z = new HashMap();
        f1 f1Var = ((r1) this.f307w).f4367z;
        r1.e(f1Var);
        this.A = new e1(f1Var, "last_delete_stale", 0L);
        f1 f1Var2 = ((r1) this.f307w).f4367z;
        r1.e(f1Var2);
        this.B = new e1(f1Var2, "last_delete_stale_batch", 0L);
        f1 f1Var3 = ((r1) this.f307w).f4367z;
        r1.e(f1Var3);
        this.C = new e1(f1Var3, "backoff", 0L);
        f1 f1Var4 = ((r1) this.f307w).f4367z;
        r1.e(f1Var4);
        this.D = new e1(f1Var4, "last_upload", 0L);
        f1 f1Var5 = ((r1) this.f307w).f4367z;
        r1.e(f1Var5);
        this.E = new e1(f1Var5, "last_upload_attempt", 0L);
        f1 f1Var6 = ((r1) this.f307w).f4367z;
        r1.e(f1Var6);
        this.F = new e1(f1Var6, "midnight_offset", 0L);
    }

    public final Pair q1(String str) {
        u3 u3Var;
        i8.a aVarA;
        m1();
        r1 r1Var = (r1) this.f307w;
        s8.a aVar = r1Var.F;
        g gVar = r1Var.f4366y;
        aVar.getClass();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        HashMap map = this.f4451z;
        u3 u3Var2 = (u3) map.get(str);
        if (u3Var2 != null && jElapsedRealtime < u3Var2.f4438c) {
            return new Pair(u3Var2.f4436a, Boolean.valueOf(u3Var2.f4437b));
        }
        long jT1 = gVar.t1(str, f0.f4111b) + jElapsedRealtime;
        try {
            try {
                aVarA = i8.b.a(r1Var.f4363v);
            } catch (PackageManager.NameNotFoundException unused) {
                if (u3Var2 != null && jElapsedRealtime < u3Var2.f4438c + gVar.t1(str, f0.f4114c)) {
                    return new Pair(u3Var2.f4436a, Boolean.valueOf(u3Var2.f4437b));
                }
                aVarA = null;
            }
        } catch (Exception e9) {
            w0 w0Var = r1Var.A;
            r1.g(w0Var);
            w0Var.I.b(e9, "Unable to get advertising id");
            u3Var = new u3(jT1, "", false);
        }
        if (aVarA == null) {
            return new Pair("00000000-0000-0000-0000-000000000000", Boolean.FALSE);
        }
        String str2 = aVarA.f6351b;
        u3Var = str2 != null ? new u3(jT1, str2, aVarA.f6352c) : new u3(jT1, "", aVarA.f6352c);
        map.put(str, u3Var);
        return new Pair(u3Var.f4436a, Boolean.valueOf(u3Var.f4437b));
    }

    public final String r1(String str, boolean z10) {
        m1();
        String str2 = z10 ? (String) q1(str).first : "00000000-0000-0000-0000-000000000000";
        MessageDigest messageDigestD1 = u4.D1();
        if (messageDigestD1 == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new BigInteger(1, messageDigestD1.digest(str2.getBytes())));
    }

    @Override // f9.l4
    public final void p1() {
    }
}
