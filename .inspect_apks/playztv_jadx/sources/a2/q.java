package a2;

import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class q extends p1.p0 {
    public final int D;
    public final String E;
    public final int F;
    public final p1.q G;
    public final int H;
    public final o2.d0 I;
    public final boolean J;

    public q(int i, Exception exc, int i10) {
        this(i, exc, i10, null, -1, null, 4, null, false);
    }

    public final q a(o2.d0 d0Var) {
        String message = getMessage();
        int i = s1.b0.f11647a;
        return new q(message, getCause(), this.f9984u, this.D, this.E, this.F, this.G, this.H, d0Var, this.f9985v, this.J);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(String str, Throwable th, int i, int i10, String str2, int i11, p1.q qVar, int i12, o2.d0 d0Var, long j5, boolean z2) {
        super(str, th, i, j5);
        Bundle bundle = Bundle.EMPTY;
        s1.d.b(!z2 || i10 == 1);
        s1.d.b(th != null || i10 == 3);
        this.D = i10;
        this.E = str2;
        this.F = i11;
        this.G = qVar;
        this.H = i12;
        this.I = d0Var;
        this.J = z2;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public q(int i, Throwable th, int i10, String str, int i11, p1.q qVar, int i12, o2.d0 d0Var, boolean z2) {
        String str2;
        int i13;
        p1.q qVar2;
        String string;
        String str3;
        if (i == 0) {
            str2 = str;
            i13 = i11;
            qVar2 = qVar;
            string = "Source error";
        } else if (i != 1) {
            if (i != 3) {
                string = "Unexpected runtime error";
            } else {
                string = "Remote error";
            }
            str2 = str;
            i13 = i11;
            qVar2 = qVar;
        } else {
            StringBuilder sb2 = new StringBuilder();
            str2 = str;
            sb2.append(str2);
            sb2.append(" error, index=");
            i13 = i11;
            sb2.append(i13);
            sb2.append(", format=");
            qVar2 = qVar;
            sb2.append(qVar2);
            sb2.append(", format_supported=");
            int i14 = s1.b0.f11647a;
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
            sb2.append(str3);
            string = sb2.toString();
        }
        this(TextUtils.isEmpty(null) ? string : e6.j.m(string, ": null"), th, i10, i, str2, i13, qVar2, i12, d0Var, SystemClock.elapsedRealtime(), z2);
    }
}
