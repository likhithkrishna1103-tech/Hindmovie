package i2;

import android.os.Build;
import java.util.Objects;
import java.util.Set;
import ua.m0;
import ua.n1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b f5972d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5973a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f5974b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final m0 f5975c;

    static {
        b bVar;
        if (Build.VERSION.SDK_INT >= 33) {
            ua.l0 l0Var = new ua.l0(4);
            for (int i = 1; i <= 10; i++) {
                l0Var.a(Integer.valueOf(y1.a0.q(i)));
            }
            bVar = new b(2, l0Var.g());
        } else {
            bVar = new b(2, 10);
        }
        f5972d = bVar;
    }

    public b(int i, Set set) {
        this.f5973a = i;
        m0 m0VarK = m0.k(set);
        this.f5975c = m0VarK;
        n1 it = m0VarK.iterator();
        int iMax = 0;
        while (it.hasNext()) {
            iMax = Math.max(iMax, Integer.bitCount(((Integer) it.next()).intValue()));
        }
        this.f5974b = iMax;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f5973a == bVar.f5973a && this.f5974b == bVar.f5974b && Objects.equals(this.f5975c, bVar.f5975c);
    }

    public final int hashCode() {
        int i = ((this.f5973a * 31) + this.f5974b) * 31;
        m0 m0Var = this.f5975c;
        return i + (m0Var == null ? 0 : m0Var.hashCode());
    }

    public final String toString() {
        return "AudioProfile[format=" + this.f5973a + ", maxChannelCount=" + this.f5974b + ", channelMasks=" + this.f5975c + "]";
    }

    public b(int i, int i10) {
        this.f5973a = i;
        this.f5974b = i10;
        this.f5975c = null;
    }
}
