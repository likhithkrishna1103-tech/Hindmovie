package c2;

import aa.n0;
import aa.o0;
import aa.q1;
import android.os.Build;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f2238d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2239a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f2240b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final o0 f2241c;

    static {
        a aVar;
        if (Build.VERSION.SDK_INT >= 33) {
            n0 n0Var = new n0(4);
            for (int i = 1; i <= 10; i++) {
                n0Var.a(Integer.valueOf(s1.b0.q(i)));
            }
            aVar = new a(2, n0Var.g());
        } else {
            aVar = new a(2, 10);
        }
        f2238d = aVar;
    }

    public a(int i, Set set) {
        this.f2239a = i;
        o0 o0VarR = o0.r(set);
        this.f2241c = o0VarR;
        q1 it = o0VarR.iterator();
        int iMax = 0;
        while (it.hasNext()) {
            iMax = Math.max(iMax, Integer.bitCount(((Integer) it.next()).intValue()));
        }
        this.f2240b = iMax;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f2239a == aVar.f2239a && this.f2240b == aVar.f2240b && Objects.equals(this.f2241c, aVar.f2241c);
    }

    public final int hashCode() {
        int i = ((this.f2239a * 31) + this.f2240b) * 31;
        o0 o0Var = this.f2241c;
        return i + (o0Var == null ? 0 : o0Var.hashCode());
    }

    public final String toString() {
        return "AudioProfile[format=" + this.f2239a + ", maxChannelCount=" + this.f2240b + ", channelMasks=" + this.f2241c + "]";
    }

    public a(int i, int i10) {
        this.f2239a = i;
        this.f2240b = i10;
        this.f2241c = null;
    }
}
