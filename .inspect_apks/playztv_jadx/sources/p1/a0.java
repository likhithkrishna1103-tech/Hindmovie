package p1;

import android.net.Uri;
import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a0 {
    public static final String i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f9626j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f9627k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f9628l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f9629m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f9630n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f9631o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String f9632p;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final UUID f9633a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Uri f9634b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final aa.m0 f9635c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f9636d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f9637e;
    public final boolean f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final aa.j0 f9638g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final byte[] f9639h;

    static {
        int i10 = s1.b0.f11647a;
        i = Integer.toString(0, 36);
        f9626j = Integer.toString(1, 36);
        f9627k = Integer.toString(2, 36);
        f9628l = Integer.toString(3, 36);
        f9629m = Integer.toString(4, 36);
        f9630n = Integer.toString(5, 36);
        f9631o = Integer.toString(6, 36);
        f9632p = Integer.toString(7, 36);
    }

    public a0(z zVar) {
        s1.d.g((zVar.f && zVar.f10114b == null) ? false : true);
        UUID uuid = zVar.f10113a;
        uuid.getClass();
        this.f9633a = uuid;
        this.f9634b = zVar.f10114b;
        this.f9635c = zVar.f10115c;
        this.f9636d = zVar.f10116d;
        this.f = zVar.f;
        this.f9637e = zVar.f10117e;
        this.f9638g = zVar.f10118g;
        byte[] bArr = zVar.f10119h;
        this.f9639h = bArr != null ? Arrays.copyOf(bArr, bArr.length) : null;
    }

    public final z a() {
        z zVar = new z();
        zVar.f10113a = this.f9633a;
        zVar.f10114b = this.f9634b;
        zVar.f10115c = this.f9635c;
        zVar.f10116d = this.f9636d;
        zVar.f10117e = this.f9637e;
        zVar.f = this.f;
        zVar.f10118g = this.f9638g;
        zVar.f10119h = this.f9639h;
        return zVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a0)) {
            return false;
        }
        a0 a0Var = (a0) obj;
        return this.f9633a.equals(a0Var.f9633a) && Objects.equals(this.f9634b, a0Var.f9634b) && Objects.equals(this.f9635c, a0Var.f9635c) && this.f9636d == a0Var.f9636d && this.f == a0Var.f && this.f9637e == a0Var.f9637e && this.f9638g.equals(a0Var.f9638g) && Arrays.equals(this.f9639h, a0Var.f9639h);
    }

    public final int hashCode() {
        int iHashCode = this.f9633a.hashCode() * 31;
        Uri uri = this.f9634b;
        return Arrays.hashCode(this.f9639h) + ((this.f9638g.hashCode() + ((((((((this.f9635c.hashCode() + ((iHashCode + (uri != null ? uri.hashCode() : 0)) * 31)) * 31) + (this.f9636d ? 1 : 0)) * 31) + (this.f ? 1 : 0)) * 31) + (this.f9637e ? 1 : 0)) * 31)) * 31);
    }
}
