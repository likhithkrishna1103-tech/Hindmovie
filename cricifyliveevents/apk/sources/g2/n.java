package g2;

import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class n extends v1.p0 {
    public final int E;
    public final String F;
    public final int G;
    public final v1.p H;
    public final int I;
    public final s2.c0 J;
    public final boolean K;

    public n(int i, Exception exc, int i10) {
        this(i, exc, i10, null, -1, null, 4, null, false);
    }

    public final n a(s2.c0 c0Var) {
        String message = getMessage();
        int i = y1.a0.f14551a;
        return new n(message, getCause(), this.f12961v, this.E, this.F, this.G, this.H, this.I, c0Var, this.f12962w, this.K);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(String str, Throwable th, int i, int i10, String str2, int i11, v1.p pVar, int i12, s2.c0 c0Var, long j4, boolean z10) {
        super(str, th, i, j4);
        Bundle bundle = Bundle.EMPTY;
        y1.d.b(!z10 || i10 == 1);
        y1.d.b(th != null || i10 == 3);
        this.E = i10;
        this.F = str2;
        this.G = i11;
        this.H = pVar;
        this.I = i12;
        this.J = c0Var;
        this.K = z10;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public n(int i, Throwable th, int i10, String str, int i11, v1.p pVar, int i12, s2.c0 c0Var, boolean z10) {
        String str2;
        int i13;
        v1.p pVar2;
        String string;
        String str3;
        if (i == 0) {
            str2 = str;
            i13 = i11;
            pVar2 = pVar;
            string = "Source error";
        } else if (i != 1) {
            if (i != 3) {
                string = "Unexpected runtime error";
            } else {
                string = "Remote error";
            }
            str2 = str;
            i13 = i11;
            pVar2 = pVar;
        } else {
            StringBuilder sb = new StringBuilder();
            str2 = str;
            sb.append(str2);
            sb.append(" error, index=");
            i13 = i11;
            sb.append(i13);
            sb.append(", format=");
            pVar2 = pVar;
            sb.append(pVar2);
            sb.append(", format_supported=");
            int i14 = y1.a0.f14551a;
            if (i12 == 0) {
                str3 = "NO";
            } else if (i12 == 1) {
                str3 = "NO_UNSUPPORTED_TYPE";
            } else if (i12 == 2) {
                str3 = "NO_UNSUPPORTED_DRM";
            } else if (i12 == 3) {
                str3 = "NO_EXCEEDS_CAPABILITIES";
            } else if (i12 == 4) {
                str3 = "YES";
            } else {
                throw new IllegalStateException();
            }
            sb.append(str3);
            string = sb.toString();
        }
        this(TextUtils.isEmpty(null) ? string : l0.e.j(string, ": null"), th, i10, i, str2, i13, pVar2, i12, c0Var, SystemClock.elapsedRealtime(), z10);
    }
}
