package j3;

import e6.j;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import p1.i0;
import p1.k0;
import p1.q;
import s1.d;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b implements k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6762a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f6763b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f6764c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f6765d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f6766e;
    public final int f;

    public b(int i, int i10, String str, String str2, String str3, boolean z2) {
        d.b(i10 == -1 || i10 > 0);
        this.f6762a = i;
        this.f6763b = str;
        this.f6764c = str2;
        this.f6765d = str3;
        this.f6766e = z2;
        this.f = i10;
    }

    public static b d(Map map) {
        boolean z2;
        int i;
        String str;
        String str2;
        String str3;
        boolean zEquals;
        int i10;
        List list = (List) map.get("icy-br");
        boolean z10 = true;
        int i11 = -1;
        if (list != null) {
            String str4 = (String) list.get(0);
            try {
                i10 = Integer.parseInt(str4) * 1000;
                if (i10 > 0) {
                    z2 = true;
                } else {
                    try {
                        s1.b.p("IcyHeaders", "Invalid bitrate: " + str4);
                        z2 = false;
                        i10 = -1;
                    } catch (NumberFormatException unused) {
                        j.r("Invalid bitrate header: ", str4, "IcyHeaders");
                        z2 = false;
                    }
                }
            } catch (NumberFormatException unused2) {
                i10 = -1;
            }
            i = i10;
        } else {
            z2 = false;
            i = -1;
        }
        List list2 = (List) map.get("icy-genre");
        if (list2 != null) {
            str = (String) list2.get(0);
            z2 = true;
        } else {
            str = null;
        }
        List list3 = (List) map.get("icy-name");
        if (list3 != null) {
            str2 = (String) list3.get(0);
            z2 = true;
        } else {
            str2 = null;
        }
        List list4 = (List) map.get("icy-url");
        if (list4 != null) {
            str3 = (String) list4.get(0);
            z2 = true;
        } else {
            str3 = null;
        }
        List list5 = (List) map.get("icy-pub");
        if (list5 != null) {
            zEquals = ((String) list5.get(0)).equals("1");
            z2 = true;
        } else {
            zEquals = false;
        }
        List list6 = (List) map.get("icy-metaint");
        if (list6 != null) {
            String str5 = (String) list6.get(0);
            try {
                int i12 = Integer.parseInt(str5);
                if (i12 > 0) {
                    i11 = i12;
                } else {
                    try {
                        s1.b.p("IcyHeaders", "Invalid metadata interval: " + str5);
                        z10 = z2;
                    } catch (NumberFormatException unused3) {
                        i11 = i12;
                        j.r("Invalid metadata interval: ", str5, "IcyHeaders");
                    }
                }
                z2 = z10;
            } catch (NumberFormatException unused4) {
            }
        }
        int i13 = i11;
        if (z2) {
            return new b(i, i13, str, str2, str3, zEquals);
        }
        return null;
    }

    @Override // p1.k0
    public final void a(i0 i0Var) {
        String str = this.f6764c;
        if (str != null) {
            i0Var.F = str;
        }
        String str2 = this.f6763b;
        if (str2 != null) {
            i0Var.D = str2;
        }
    }

    @Override // p1.k0
    public final /* synthetic */ q b() {
        return null;
    }

    @Override // p1.k0
    public final /* synthetic */ byte[] c() {
        return null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && b.class == obj.getClass()) {
            b bVar = (b) obj;
            if (this.f6762a == bVar.f6762a && Objects.equals(this.f6763b, bVar.f6763b) && Objects.equals(this.f6764c, bVar.f6764c) && Objects.equals(this.f6765d, bVar.f6765d) && this.f6766e == bVar.f6766e && this.f == bVar.f) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = (527 + this.f6762a) * 31;
        String str = this.f6763b;
        int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f6764c;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f6765d;
        return ((((iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + (this.f6766e ? 1 : 0)) * 31) + this.f;
    }

    public final String toString() {
        return "IcyHeaders: name=\"" + this.f6764c + "\", genre=\"" + this.f6763b + "\", bitrate=" + this.f6762a + ", metadataInterval=" + this.f;
    }
}
