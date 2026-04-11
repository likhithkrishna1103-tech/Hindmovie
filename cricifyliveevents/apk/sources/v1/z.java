package v1;

import android.net.Uri;
import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class z {
    public static final String i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f13048j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f13049k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f13050l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f13051m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f13052n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f13053o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String f13054p;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final UUID f13055a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Uri f13056b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ua.k0 f13057c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f13058d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f13059e;
    public final boolean f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ua.i0 f13060g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final byte[] f13061h;

    static {
        int i10 = y1.a0.f14551a;
        i = Integer.toString(0, 36);
        f13048j = Integer.toString(1, 36);
        f13049k = Integer.toString(2, 36);
        f13050l = Integer.toString(3, 36);
        f13051m = Integer.toString(4, 36);
        f13052n = Integer.toString(5, 36);
        f13053o = Integer.toString(6, 36);
        f13054p = Integer.toString(7, 36);
    }

    public z(y yVar) {
        y1.d.g((yVar.f && yVar.f13038b == null) ? false : true);
        UUID uuid = yVar.f13037a;
        uuid.getClass();
        this.f13055a = uuid;
        this.f13056b = yVar.f13038b;
        this.f13057c = yVar.f13039c;
        this.f13058d = yVar.f13040d;
        this.f = yVar.f;
        this.f13059e = yVar.f13041e;
        this.f13060g = yVar.f13042g;
        byte[] bArr = yVar.f13043h;
        this.f13061h = bArr != null ? Arrays.copyOf(bArr, bArr.length) : null;
    }

    public final y a() {
        y yVar = new y();
        yVar.f13037a = this.f13055a;
        yVar.f13038b = this.f13056b;
        yVar.f13039c = this.f13057c;
        yVar.f13040d = this.f13058d;
        yVar.f13041e = this.f13059e;
        yVar.f = this.f;
        yVar.f13042g = this.f13060g;
        yVar.f13043h = this.f13061h;
        return yVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof z)) {
            return false;
        }
        z zVar = (z) obj;
        return this.f13055a.equals(zVar.f13055a) && Objects.equals(this.f13056b, zVar.f13056b) && Objects.equals(this.f13057c, zVar.f13057c) && this.f13058d == zVar.f13058d && this.f == zVar.f && this.f13059e == zVar.f13059e && this.f13060g.equals(zVar.f13060g) && Arrays.equals(this.f13061h, zVar.f13061h);
    }

    public final int hashCode() {
        int iHashCode = this.f13055a.hashCode() * 31;
        Uri uri = this.f13056b;
        return Arrays.hashCode(this.f13061h) + ((this.f13060g.hashCode() + ((((((((this.f13057c.hashCode() + ((iHashCode + (uri != null ? uri.hashCode() : 0)) * 31)) * 31) + (this.f13058d ? 1 : 0)) * 31) + (this.f ? 1 : 0)) * 31) + (this.f13059e ? 1 : 0)) * 31)) * 31);
    }
}
