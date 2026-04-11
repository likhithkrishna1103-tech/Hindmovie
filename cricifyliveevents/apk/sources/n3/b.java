package n3;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import l0.e;
import v1.i0;
import v1.k0;
import v1.p;
import y1.d;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f8757a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f8758b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f8759c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f8760d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f8761e;
    public final int f;

    public b(int i, int i10, String str, String str2, String str3, boolean z10) {
        d.b(i10 == -1 || i10 > 0);
        this.f8757a = i;
        this.f8758b = str;
        this.f8759c = str2;
        this.f8760d = str3;
        this.f8761e = z10;
        this.f = i10;
    }

    public static b d(Map map) {
        boolean z10;
        int i;
        String str;
        String str2;
        String str3;
        boolean zEquals;
        int i10;
        List list = (List) map.get("icy-br");
        boolean z11 = true;
        int i11 = -1;
        if (list != null) {
            String str4 = (String) list.get(0);
            try {
                i10 = Integer.parseInt(str4) * 1000;
                if (i10 > 0) {
                    z10 = true;
                } else {
                    try {
                        y1.b.p("IcyHeaders", "Invalid bitrate: " + str4);
                        z10 = false;
                        i10 = -1;
                    } catch (NumberFormatException unused) {
                        e.r("Invalid bitrate header: ", str4, "IcyHeaders");
                        z10 = false;
                    }
                }
            } catch (NumberFormatException unused2) {
                i10 = -1;
            }
            i = i10;
        } else {
            z10 = false;
            i = -1;
        }
        List list2 = (List) map.get("icy-genre");
        if (list2 != null) {
            str = (String) list2.get(0);
            z10 = true;
        } else {
            str = null;
        }
        List list3 = (List) map.get("icy-name");
        if (list3 != null) {
            str2 = (String) list3.get(0);
            z10 = true;
        } else {
            str2 = null;
        }
        List list4 = (List) map.get("icy-url");
        if (list4 != null) {
            str3 = (String) list4.get(0);
            z10 = true;
        } else {
            str3 = null;
        }
        List list5 = (List) map.get("icy-pub");
        if (list5 != null) {
            zEquals = ((String) list5.get(0)).equals("1");
            z10 = true;
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
                        y1.b.p("IcyHeaders", "Invalid metadata interval: " + str5);
                        z11 = z10;
                    } catch (NumberFormatException unused3) {
                        i11 = i12;
                        e.r("Invalid metadata interval: ", str5, "IcyHeaders");
                    }
                }
                z10 = z11;
            } catch (NumberFormatException unused4) {
            }
        }
        int i13 = i11;
        if (z10) {
            return new b(i, i13, str, str2, str3, zEquals);
        }
        return null;
    }

    @Override // v1.k0
    public final /* synthetic */ p a() {
        return null;
    }

    @Override // v1.k0
    public final /* synthetic */ byte[] b() {
        return null;
    }

    @Override // v1.k0
    public final void c(i0 i0Var) {
        String str = this.f8759c;
        if (str != null) {
            i0Var.F = str;
        }
        String str2 = this.f8758b;
        if (str2 != null) {
            i0Var.D = str2;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && b.class == obj.getClass()) {
            b bVar = (b) obj;
            if (this.f8757a == bVar.f8757a && Objects.equals(this.f8758b, bVar.f8758b) && Objects.equals(this.f8759c, bVar.f8759c) && Objects.equals(this.f8760d, bVar.f8760d) && this.f8761e == bVar.f8761e && this.f == bVar.f) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = (527 + this.f8757a) * 31;
        String str = this.f8758b;
        int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f8759c;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f8760d;
        return ((((iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + (this.f8761e ? 1 : 0)) * 31) + this.f;
    }

    public final String toString() {
        return "IcyHeaders: name=\"" + this.f8759c + "\", genre=\"" + this.f8758b + "\", bitrate=" + this.f8757a + ", metadataInterval=" + this.f;
    }
}
