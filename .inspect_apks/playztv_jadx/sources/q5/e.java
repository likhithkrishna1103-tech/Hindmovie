package q5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final e f11010c = new e("COMPOSITION");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f11011a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f f11012b;

    public e(String... strArr) {
        this.f11011a = Arrays.asList(strArr);
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0088 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean a(java.lang.String r8, int r9) {
        /*
            r7 = this;
            java.util.List r0 = r7.f11011a
            int r1 = r0.size()
            r2 = 0
            if (r9 < r1) goto Lb
            goto L91
        Lb:
            int r1 = r0.size()
            r3 = 1
            int r1 = r1 - r3
            if (r9 != r1) goto L15
            r1 = r3
            goto L16
        L15:
            r1 = r2
        L16:
            java.lang.Object r4 = r0.get(r9)
            java.lang.String r4 = (java.lang.String) r4
            java.lang.String r5 = "**"
            boolean r6 = r4.equals(r5)
            if (r6 != 0) goto L54
            boolean r8 = r4.equals(r8)
            if (r8 != 0) goto L35
            java.lang.String r8 = "*"
            boolean r8 = r4.equals(r8)
            if (r8 == 0) goto L33
            goto L35
        L33:
            r8 = r2
            goto L36
        L35:
            r8 = r3
        L36:
            if (r1 != 0) goto L51
            int r1 = r0.size()
            int r1 = r1 + (-2)
            if (r9 != r1) goto L91
            int r9 = r0.size()
            int r9 = r9 - r3
            java.lang.Object r9 = r0.get(r9)
            java.lang.String r9 = (java.lang.String) r9
            boolean r9 = r9.equals(r5)
            if (r9 == 0) goto L91
        L51:
            if (r8 == 0) goto L91
            goto L88
        L54:
            if (r1 != 0) goto L86
            int r4 = r9 + 1
            java.lang.Object r4 = r0.get(r4)
            java.lang.String r4 = (java.lang.String) r4
            boolean r4 = r4.equals(r8)
            if (r4 == 0) goto L86
            int r8 = r0.size()
            int r8 = r8 + (-2)
            if (r9 == r8) goto L88
            int r8 = r0.size()
            int r8 = r8 + (-3)
            if (r9 != r8) goto L91
            int r8 = r0.size()
            int r8 = r8 - r3
            java.lang.Object r8 = r0.get(r8)
            java.lang.String r8 = (java.lang.String) r8
            boolean r8 = r8.equals(r5)
            if (r8 == 0) goto L91
            goto L88
        L86:
            if (r1 == 0) goto L89
        L88:
            return r3
        L89:
            int r9 = r9 + r3
            int r1 = r0.size()
            int r1 = r1 - r3
            if (r9 >= r1) goto L92
        L91:
            return r2
        L92:
            java.lang.Object r9 = r0.get(r9)
            java.lang.String r9 = (java.lang.String) r9
            boolean r8 = r9.equals(r8)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: q5.e.a(java.lang.String, int):boolean");
    }

    public final int b(String str, int i) {
        if ("__container".equals(str)) {
            return 0;
        }
        List list = this.f11011a;
        if (((String) list.get(i)).equals("**")) {
            return (i != list.size() - 1 && ((String) list.get(i + 1)).equals(str)) ? 2 : 0;
        }
        return 1;
    }

    public final boolean c(String str, int i) {
        if ("__container".equals(str)) {
            return true;
        }
        List list = this.f11011a;
        if (i >= list.size()) {
            return false;
        }
        return ((String) list.get(i)).equals(str) || ((String) list.get(i)).equals("**") || ((String) list.get(i)).equals("*");
    }

    public final boolean d(String str, int i) {
        if ("__container".equals(str)) {
            return true;
        }
        List list = this.f11011a;
        return i < list.size() - 1 || ((String) list.get(i)).equals("**");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && e.class == obj.getClass()) {
            e eVar = (e) obj;
            if (!this.f11011a.equals(eVar.f11011a)) {
                return false;
            }
            f fVar = this.f11012b;
            f fVar2 = eVar.f11012b;
            if (fVar != null) {
                return fVar.equals(fVar2);
            }
            if (fVar2 == null) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.f11011a.hashCode() * 31;
        f fVar = this.f11012b;
        return iHashCode + (fVar != null ? fVar.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("KeyPath{keys=");
        sb2.append(this.f11011a);
        sb2.append(",resolved=");
        sb2.append(this.f11012b != null);
        sb2.append('}');
        return sb2.toString();
    }

    public e(e eVar) {
        this.f11011a = new ArrayList(eVar.f11011a);
        this.f11012b = eVar.f11012b;
    }
}
